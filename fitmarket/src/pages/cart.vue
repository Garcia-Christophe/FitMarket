<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main v-if="isConnected()">
      <div style="display: flex; flex-direction: column; gap: 30px; width: 100%; align-items: center;">
        <h2>Votre panier</h2>

        <!-- Liste des produits -->
        <div
          style="display: flex; flex-direction: column; width: 80%; margin: auto; align-items: center; box-shadow: 0 13px 25px 0 rgba(0, 0, 0, 0.3); border-radius: 10px;">
          <p style="font-size: x-large; margin: 10px auto;">Commande en cours</p>
          <div v-for="(product, iProduct) in products" :key="iProduct"
            style="display: flex; flex-direction: column; width: 90%; margin: auto;">
            <hr style="width: 80%; margin: auto;">
            <div style="display: flex; align-items: center;">
              <!-- Produit -->
              <ProductOrdered :product="product" />

              <!-- Modification de la quantité du produit -->
              <div style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
                <v-text-field style="max-width: 100px" type="number" color="#D7473F" v-model="product.quantity" min="1"
                  required @change="saveOrder" />
                <v-btn density="compact" size="x-large" icon="mdi mdi-trash-can-outline"
                  style="margin: 0 10px; background-color: #D7473F; color: white"
                  @click="() => removeItem(iProduct)"></v-btn>
              </div>
            </div>
          </div>
        </div>

        <!-- Boutons d'action -->
        <div style="display: flex; width: 80%; justify-content: space-evenly; margin-top: 50px;">
          <v-btn prepend-icon="mdi mdi-trash-can-outline" @click="cancelOrder">
            Vider la commande
          </v-btn>
          <v-btn prepend-icon="mdi mdi-check-all" @click="validOrder" color="#D7473F">
            Valider la commande
          </v-btn>
        </div>
      </div>

      <!-- Notifications -->
      <v-snackbar v-model="orderValidated" :timeout="5000" elevation="24">
        Produits commandés !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="orderValidated = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
      <v-snackbar v-model="orderCancelled" :timeout="2000" elevation="24">
        Commande vidée !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="orderCancelled = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
      <v-snackbar v-model="orderImpossible" :timeout="2000" elevation="24">
        Rien à commander !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="orderImpossible = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
      <v-snackbar v-model="orderNotClearable" :timeout="2000" elevation="24">
        Rien à vider !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="orderNotClearable = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
import NavBar from '@/components/NavBar.vue'
import ProductOrdered from '@/components/ProductOrdered.vue'

// Empêche l'accès aux utilisateurs non connectés
if (!localStorage.getItem('connectedUser')) {
  document.location.href = '/sign';
}

const orderValidated = ref(false)
const orderCancelled = ref(false)
const orderImpossible = ref(false)
const orderNotClearable = ref(false)

const user = ref({
  ...JSON.parse(localStorage.getItem('connectedUser'))
})

let orderId;
let products = ref([])

fetch(`http://localhost:8080/api/v1/orders/${user.value.id}/inprogress`)
  .then((res) => res.json())
  .then(async (res) => {
    orderId = res.id;

    if (res.products) {
      for (const item of res.products) {
        const product = {
          idProduct: item.product.id,
          name: item.product.title,
          quantity: item.quantity,
          price: item.product.price
        }
        product.firstImg = (await (await fetch(`http://localhost:8080/api/v1/products/${product.idProduct}`)).json()).images?.[0]
        products.value.push(product)
      }
    }
  })

function isConnected() {
  return localStorage.getItem('connectedUser')
}

async function validOrder() {
  // Enregistrement de la commande
  const jsonToSend = {
    id: orderId,
    date_order: new Date().toISOString().slice(0, 19).replace('T', ' '),
    products: []
  }
  products.value.forEach((product) => jsonToSend.products.push({ quantity: product.quantity, product: { id: product.idProduct } }))
  const data = await fetch(`http://localhost:8080/api/v1/orders/${user.value.id}`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(jsonToSend)
  })

  if (data.ok) {
    // Mise à jour de la vue
    products.value.splice(0, products.value.length)
    orderId = -1;

    // Notification : commande validée
    orderValidated.value = true;
    setTimeout(() => orderValidated.value = false, 5000)
  } else {
    // Notification
    orderImpossible.value = true;
    setTimeout(() => orderImpossible.value = false, 2000)
  }
}

function cancelOrder() {
  if (products.value.length) {
    // Vidage de la commande
    resetOrder(true)
  } else {
    // Notification
    orderNotClearable.value = true
    setTimeout(() => orderNotClearable.value = false, 2000)
  }
}

async function resetOrder() {
  // Mise à jour de la bdd
  const jsonToSend = { products: [] }
  jsonToSend.id = orderId
  const data = await fetch(`http://localhost:8080/api/v1/orders/${user.value.id}`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(jsonToSend)
  })

  if (data.ok) {
    // Notification : commande vidée
    orderCancelled.value = true;
    setTimeout(() => orderCancelled.value = false, 2000)
  } else {
    console.log(data);
    // Notification
    orderNotClearable.value = true
    setTimeout(() => orderNotClearable.value = false, 2000)
  }

  // Mise à jour de la vue
  products.value.splice(0, products.value.length)
  orderId = -1;
}

function removeItem(idxProduct) {
  products.value.splice(idxProduct, 1);

  // Enregistre la modification
  saveOrder();
}

async function saveOrder() {
  // Enregistrement de la commande
  const jsonToSend = {
    id: orderId,
    products: []
  }
  products.value.forEach((product) => jsonToSend.products.push({ quantity: product.quantity, product: { id: product.idProduct } }))
  await fetch(`http://localhost:8080/api/v1/orders/${user.value.id}`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(jsonToSend)
  })
}
</script>