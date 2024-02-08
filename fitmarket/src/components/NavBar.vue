<template>
  <v-app-bar color="transparent" class="text-white">
    <img src="../assets/logo.png" width="50" height="50" style="margin-left: 20px;" />
    <v-app-bar-title>Fit Market</v-app-bar-title>
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
