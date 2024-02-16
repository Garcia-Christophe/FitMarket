<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main style="padding: 50px 5%; display: flex; flex-direction: column; align-items: center; gap: 50px;">
      <h1>Bonjour, {{ user.firstName }} {{ user.name }} !</h1>

      <!-- champs données utilisateur -->
      <div style="display: flex; flex-direction: column; gap: 30px; width: 100%; align-items: center;">
        <h2>Vos informations personnelles</h2>
        <div style="display: flex; width: 100%; gap: 50px;">
          <div style="display: flex; flex-direction: column; width: 100%;">
            <v-text-field v-model="user.name" label="Nom" name="Nom" prepend-icon="mdi-card-account-details" type="text"
              color="#D7473F" />
            <v-text-field v-model="user.email" label="Email" name="Email" prepend-icon="mdi-email" type="email"
              color="#D7473F" />
          </div>

          <div style="display: flex; flex-direction: column; width: 100%;">
            <v-text-field v-model="user.firstName" label="Prénom" name="Prénom" prepend-icon="mdi-card-account-details"
              type="text" color="#D7473F" />
            <v-text-field v-model="user.password" label="Password" name="password" prepend-icon="mdi-lock" type="password"
              color="#D7473F" />
          </div>
        </div>
      </div>

      <!-- historique des commandes -->
      <div style="display: flex; flex-direction: column; gap: 30px; width: 100%; align-items: center;">
        <h2>L'historique de vos commandes</h2>
        <div v-for="(order, iOrder) in orders" :key="iOrder"
          style="display: flex; flex-direction: column; width: 80%; margin: auto; align-items: center; box-shadow: 0 13px 25px 0 rgba(0, 0, 0, 0.3); border-radius: 10px;">
          <p style="font-size: x-large; margin: 10px auto;">Commande du <strong>{{ order.date }}</strong></p>
          <div v-for="(product, iProduct) in order.products" :key="iProduct"
            style="display: flex; flex-direction: column; width: 90%; margin: auto;">
            <hr style="width: 80%; margin: auto;">
            <div style="display: flex; width: 100%; margin: 1%;">
              <img :src="product.firstImg" alt="" style="max-width: 200px; width: 100%;">
              <div style="display: flex; width: 100%; justify-content: space-between; align-items: center; margin: 0 5%;">
                <p style="width: 100%; font-size: x-large"><strong>{{ product.name }}</strong></p>
                <div style="display: flex; flex-direction: column; width: fit-content; gap: 5px;">
                  <div style="display: flex; gap: 20px; justify-content: space-between;">
                    <p>Quantité&nbsp;:</p>
                    <p>{{ product.quantity }}</p>
                  </div>
                  <div style="display: flex; gap: 20px; justify-content: space-between;">
                    <p>Prix&nbsp;unitaire&nbsp;:</p>
                    <p>{{ product.price }}&nbsp;€</p>
                  </div>
                  <div style="display: flex; gap: 20px; justify-content: space-between;">
                    <p><strong>Prix&nbsp;total&nbsp;:</strong></p>
                    <p><strong>{{ product.quantity * product.price }}&nbsp;€</strong></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
import NavBar from '@/components/NavBar.vue'

const user = ref({
  name: 'Sorin',
  firstName: 'Alexia',
  email: 'alexia.sorin@gmail.com',
  password: 'coucou'
})

const orders = ref([{
  idOrder: 1,
  date: "05/01/2024",
  products: [{
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  },
  {
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  }]
}, {
  idOrder: 2,
  date: "05/01/2024",
  products: [{
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  }]
}, {
  idOrder: 3,
  date: "05/01/2024",
  products: [{
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  },
  {
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  },
  {
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  },
  {
    idProduct: 1,
    name: "Banc de musculation",
    quantity: 2,
    price: 29.99,
    firstImg: "https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717"
  }]
}])
</script>
