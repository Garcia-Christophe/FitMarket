<template>
  <v-app-bar class="text-white" style="position: sticky; height: fit-content">
    <img id="img-title" src="../assets/logo.png" width="50" height="50" @click="$router.push('/')" />
    <v-app-bar-title id="title" @click="$router.push('/')">Fit Market</v-app-bar-title>
    <v-btn append-icon="mdi mdi-chevron-down">Matériels</v-btn>
    <v-btn append-icon="mdi mdi-chevron-down">Cours</v-btn>
    <v-btn append-icon="mdi mdi-chevron-down">Nutrition</v-btn>
    <v-btn append-icon="mdi mdi-chevron-down">Vêtements</v-btn>
    <v-text-field density="compact" label="Rechercher" prepend-inner-icon="mdi-magnify" single-line hide-details
      flat></v-text-field>
    <v-spacer></v-spacer>
    <v-btn prepend-icon="mdi mdi-account" href="/sign">Compte</v-btn>
    <v-btn prepend-icon="mdi mdi-cart">Panier</v-btn>
  </v-app-bar>
</template>

<style scoped>
#img-title {
  margin-left: 20px;
}

#img-title:hover,
#title:hover {
  cursor: pointer;
}
</style>