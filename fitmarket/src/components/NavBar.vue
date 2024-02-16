<template>
  <v-app-bar class="text-white" style="position: sticky; height: fit-content" :collapse="collapseNavBar">
    <img id="img-title" src="../assets/logo.png" width="50" height="50" @click="$router.push('/')" />
    <v-app-bar-title v-if="!collapseNavBar" id="title" @click="$router.push('/')">Fit Market</v-app-bar-title>

    <div v-if="!collapseNavBar"
      style="display: flex; width: 50%; column-gap: 10px; justify-content: center; align-items: center; margin-right: 80px;">
      <v-btn append-icon="mdi mdi-chevron-down">Matériels</v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">Cours</v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">Nutrition</v-btn>
      <v-btn append-icon="mdi mdi-chevron-down">Vêtements</v-btn>
      <v-text-field density="compact" label="Rechercher" prepend-inner-icon="mdi-magnify" single-line hide-details flat
        style="min-width: 150px"></v-text-field>
    </div>

    <v-btn v-if="!collapseNavBar" prepend-icon="mdi mdi-account" href="/account">Compte</v-btn>
    <v-btn v-if="!collapseNavBar" prepend-icon="mdi mdi-cart">Panier</v-btn>
  </v-app-bar>
</template>

<script setup>
import { ref } from 'vue';

window.addEventListener('resize', handleCollapse);

const collapseNavBar = ref(false);

function handleCollapse() {
  collapseNavBar.value = window.innerWidth < 1170
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
