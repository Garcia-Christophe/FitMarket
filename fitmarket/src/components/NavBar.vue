<template>
  <div class="image shape"
    style="background: url('backgroundAccueilAllonge.png'); background-size: cover; background-position: center; display: flex; justify-content: center; position: absolute; height: 400px; width: 100%;">
    <!-- Barre de navigation -->
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
      <v-btn prepend-icon="mdi mdi-account">Compte</v-btn>
      <v-btn prepend-icon="mdi mdi-cart">Panier</v-btn>
    </v-app-bar>

    <!-- Accueil 1re impression -->
    <v-row class="row-acheter-maintenant">
      <a href="" target="_blank">
        <v-btn prepend-icon="mdi mdi-handshake">Partenaires</v-btn>
      </a>
      <v-btn rounded="xl" style="background: #D7473F; color: white;">Acheter maintenant</v-btn>
      <a href="https://fr.trustpilot.com/review/ericflag.com?utm_medium=trustbox&utm_source=Horizontal" target="_blank">
        <v-btn prepend-icon="mdi mdi-star">
          Vos avis
        </v-btn>
      </a>
    </v-row>
  </div>
</template>

<script>
export default {
}
</script>

<style>
.shape {
  border-radius: 0 0 30% 30%;
}

.row-acheter-maintenant {
  position: absolute;
  bottom: -5px;
  width: 50%;
  justify-content: space-evenly;
}
</style>