<template>
  <v-row>
    <v-col cols="12" sm="4" v-for="(product, i) in products" :key="i">
      <v-card class="mx-auto product" max-width="344">
        <v-img :src="product.img" height="200px" cover></v-img>
        <v-divider></v-divider>

        <v-card-title>
          {{ product.type }}
        </v-card-title>

        <v-card-actions>
          <v-btn prepend-icon="mdi mdi-cart">{{ product.price }}</v-btn>
          <v-spacer></v-spacer>
          <v-btn size="small" color="surface-radiant" variant="text" icon="mdi-heart"></v-btn>
          <v-btn size="small" color="surface-radiant" variant="text" icon="mdi-share-variant"></v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup>
const products = [
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  },
  {
    img: "backgroundAccueil.png",
    type: "Bedroom",
    price: "50 €"
  }
]
</script>

<style scoped>
.product:hover {
  box-shadow: rgba(0, 0, 0, 0.2) 0px 10px 16px 0px, rgba(0, 0, 0, 0.19) 0px 6px 20px 0px !important
}
</style>