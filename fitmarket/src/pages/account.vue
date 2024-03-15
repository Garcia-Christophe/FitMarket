<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main v-if="isConnected()"
      style="padding: 50px 5%; display: flex; flex-direction: column; align-items: center; gap: 50px;">
      <h1>Bonjour, {{ user.firstname }} {{ user.lastname }} !</h1>

      <!-- champs données utilisateur -->
      <div style="display: flex; flex-direction: column; gap: 30px; width: 100%; align-items: center;">
        <h2>Vos informations personnelles</h2>
        <div style="display: flex; flex-direction: column; width: 100%; gap: 20px;">
          <div style="display: flex; width: 100%; gap: 50px; justify-content: center;">
            <v-text-field v-model="user.lastname" label="Nom" name="Nom" prepend-icon="mdi-card-account-details"
              type="text" color="#D7473F" />
            <v-text-field v-model="user.firstname" label="Prénom" name="Prénom" prepend-icon="mdi-card-account-details"
              type="text" color="#D7473F" />
          </div>

          <div style="display: flex; width: 100%; gap: 50px; justify-content: center;">
            <v-text-field v-model="user.email" label="Adresse email" name="Email" prepend-icon="mdi-email" type="email"
              color="#D7473F" />
            <v-text-field v-model="user.password" label="Mot de passe" name="password" prepend-icon="mdi-lock"
              type="password" color="#D7473F" />
          </div>

          <div style="display: flex; width: 100%; gap: 50px; justify-content: center;">
            <!-- Bouton déconnexion -->
            <v-btn @click="updateUserDetails" color="#D7473F">Mettre à jour</v-btn>
            <v-btn @click="deconnexion">Se déconnecter</v-btn>
          </div>
        </div>
      </div>

      <!-- historique des commandes -->
      <div style="display: flex; flex-direction: column; gap: 30px; width: 100%; align-items: center;">
        <h2>L'historique de vos commandes</h2>
        <div v-for="(order, iOrder) in orders" :key="iOrder"
          style="display: flex; flex-direction: column; width: 80%; margin: auto; align-items: center; box-shadow: 0 13px 25px 0 rgba(0, 0, 0, 0.3); border-radius: 10px;">
          <p style="font-size: x-large; margin: 10px auto;">Commande du
            <strong>{{ new Date(order.date).toLocaleDateString('fr-FR', {
      day: 'numeric', month: 'long', year: 'numeric'
    }) }}</strong>
          </p>
          <div v-for="(product, iProduct) in order.products" :key="iProduct"
            style="display: flex; flex-direction: column; width: 90%; margin: auto;">
            <hr style="width: 80%; margin: auto;">
            <ProductOrdered :product="product" />
          </div>
        </div>
      </div>

      <!-- notifications -->
      <v-snackbar v-model="updated" :timeout="2000" elevation="24">
        Informations mises à jour !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="updated = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
      <v-snackbar v-model="notUpdated" :timeout="2000" elevation="24">
        Veuillez remplir tous les champs !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="notUpdated = false">
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

const user = ref({
  ...JSON.parse(localStorage.getItem('connectedUser'))
})
const updated = ref(false)
const notUpdated = ref(false)

const orders = ref([])

fetch(`http://localhost:8080/api/v1/orders/${user.value.id}`)
  .then((res) => res.json())
  .then(async (res) => {
    for await (const orderJson of res) {
      const order = {
        idOrder: orderJson.id,
        date: orderJson.date_order,
        products: []
      };
      for (const item of orderJson.products) {
        const product = {
          idProduct: item.product.id,
          name: item.product.title,
          quantity: item.quantity,
          price: item.product.price
        }
        product.firstImg = (await (await fetch(`http://localhost:8080/api/v1/products/${product.idProduct}`)).json()).images?.[0]
        order.products.push(product)
      }
      orders.value.push({ ...order })
    }
    orders.value.sort((a, b) => new Date(b.date) - new Date(a.date));
  })

async function updateUserDetails() {
  let data = { ok: false };

  if (user.value.email && user.value.firstname && user.value.lastname && user.value.password) {
    data = await fetch(`http://localhost:8080/api/v1/sign/${user.value.id}`, {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(user.value)
    })
  }

  if (data.ok) {
    // Modifie les informations de l'utilisateur dans le localStorage
    localStorage.getItem('connectedUser', { ...user.value })
    updated.value = true;
    setTimeout(() => updated.value = false, 2000)
  } else {
    notUpdated.value = true;
    setTimeout(() => notUpdated.value = false, 2000)
  }
}

function deconnexion() {
  localStorage.removeItem('connectedUser');
  document.location.href = '/sign';
}

function isConnected() {
  return localStorage.getItem('connectedUser')
}
</script>