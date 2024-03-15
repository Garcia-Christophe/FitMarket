<template>
  <v-app-bar class="text-white" style="position: sticky; height: fit-content" :collapse="collapseNavBar">
    <img id="img-title" src="../assets/logo.png" width="50" height="50" @click="$router.push('/')" />
    <v-app-bar-title v-if="!collapseNavBar" id="title" @click="$router.push('/')">Fit Market</v-app-bar-title>

    <div v-if="!collapseNavBar"
      style="display: flex; width: 50%; column-gap: 10px; justify-content: center; align-items: center; margin-right: 80px;">
      <v-btn append-icon="mdi mdi-chevron-down">
        Équipements
        <v-menu activator="parent">
          <v-list>
            <v-list-item v-for="(product, index) in allProducts.filter((p) => p.category === 'EQUIPMENT')" :key="index"
              :value="index">
              <v-list-item-title @click="$router.push('/product?id=' + product.id)">
                {{ product.title }}
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">
        Cours
        <v-menu activator="parent">
          <v-list>
            <v-list-item v-for="(product, index) in allProducts.filter((p) => p.category === 'CLASSES') " :key="index"
              :value="index">
              <v-list-item-title @click="$router.push('/product?id=' + product.id)">
                {{ product.title }}
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">
        Nutrition
        <v-menu activator="parent">
          <v-list>
            <v-list-item v-for="(product, index) in allProducts.filter((p) => p.category === 'NUTRITION') " :key="index"
              :value="index">
              <v-list-item-title @click="$router.push('/product?id=' + product.id)">
                {{ product.title }}
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">
        Vêtements
        <v-menu activator="parent">
          <v-list>
            <v-list-item v-for="(product, index) in allProducts.filter((p) => p.category === 'CLOTHES') " :key="index"
              :value="index">
              <v-list-item-title @click="$router.push('/product?id=' + product.id)">
                {{ product.title }}
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
      <v-autocomplete variant="underlined" clearable label="Rechercher" :items="allProducts.map((p) => p.title)"
        @update:model-value="(event) => $router.push(event ? '/product?id=' + allProducts.find((p) => p.title === event).id : '/')"></v-autocomplete>
    </div>

    <v-btn v-if="!collapseNavBar" prepend-icon="mdi mdi-account"
      :href="isConnected() ? '/account' : '/sign'">Compte</v-btn>
    <v-btn v-if="!collapseNavBar && isConnected()" prepend-icon="mdi mdi-cart" href="/cart">Panier</v-btn>
  </v-app-bar>
</template>

<script setup>
import { ref } from 'vue';

window.addEventListener('resize', handleCollapse);

const allProducts = ref([])

fetch('http://localhost:8080/api/v1/products')
  .then((res) => res.json())
  .then((res) => allProducts.value.push(...res))

const collapseNavBar = ref(false);

function handleCollapse() {
  collapseNavBar.value = window.innerWidth < 1170
}

function isConnected() {
  return localStorage.getItem('connectedUser')
}
</script>

<style scoped>
#img-title {
  margin-left: 20px;
}

#img-title:hover,
#title:hover {
  cursor: pointer;
}
</style>
