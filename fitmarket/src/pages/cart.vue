<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main v-if="isConnected()">
      Coming soon...
    </v-main>
  </v-app>
</template>

<script setup>
import NavBar from '@/components/NavBar.vue'

// Empêche l'accès aux utilisateurs non connectés
if (!localStorage.getItem('connectedUser')) {
  document.location.href = '/sign';
}

function isConnected() {
  return localStorage.getItem('connectedUser')
}
</script>