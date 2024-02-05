<template>
  <v-app>
    <NavBar />

    <v-main>
      <v-container>
        <v-card style="margin-top: 380px" flat>
          <!-- Tabs -->
          <v-tabs v-model="tabActif" color="#D7473F" align-tabs="center">
            <v-tab :value="1">Les plus récents</v-tab>
            <v-tab :value="2">Les mieux notés</v-tab>
            <v-tab :value="3">Les plus demandés</v-tab>
            <v-tab :value="4">Ordre prix croissant</v-tab>
            <v-tab :value="5">Ordre prix décroissant</v-tab>
          </v-tabs>

          <!-- Contenu des tabs -->
          <v-window v-model="tabActif">
            <v-window-item v-for="n in 5" :key="n" :value="n" :transition="true" style="width: 90%; margin: 0% 5%">
              <v-container fluid>
                <v-row>
                  <v-col cols="12" sm="9">
                    <Product />
                  </v-col>

                  <v-col cols="12" sm="3" style="justify-content: center">
                    <!-- Catégories -->
                    <v-toolbar color="transparent">
                      Catégories
                      <v-spacer></v-spacer>
                      <v-btn :icon="categoriesOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="categoriesOpen = !categoriesOpen"></v-btn>
                    </v-toolbar>
                    <v-row v-if="categoriesOpen">
                      <v-col cols="12" sm="6" md="6">
                        <v-checkbox v-model="ex4" label="Sofas" color="info" value="success" hide-details>
                        </v-checkbox>
                        <v-checkbox v-checkbox v-model="ex4" label="Bethrooms" color="info" value="info"
                          hide-details></v-checkbox>
                        <v-checkbox v-checkbox v-model="ex4" label="Beds" color="info" value="red" hide-details>
                        </v-checkbox>
                      </v-col>
                      <v-col cols="12" sm="6" md="6">
                        <v-checkbox v-model="ex5" label="Sofas" color="info" value="success" hide-details>
                        </v-checkbox>
                        <v-checkbox v-checkbox v-model="ex5" label="Bethrooms" color="info" value="info"
                          hide-details></v-checkbox>
                        <v-checkbox v-checkbox v-model="ex5" label="Beds" color="info" value="red" hide-details>
                        </v-checkbox>
                      </v-col>
                    </v-row>

                    <!-- Couleurs -->
                    <v-toolbar color="transparent">
                      Couleurs
                      <v-spacer></v-spacer>
                      <v-btn :icon="colorsOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="colorsOpen = !colorsOpen"></v-btn>
                    </v-toolbar>
                    <v-col v-if="colorsOpen">
                      <v-row>
                        <v-avatar color="grey" class="ml-1"></v-avatar>
                        <v-avatar color="#DBEBCE" class="ml-1"></v-avatar>
                        <v-avatar color="#EBDFD1" class="ml-1"></v-avatar>
                        <v-avatar color="#E6C5B8" class="ml-1"></v-avatar>
                        <v-avatar color="#D5CAB4" class="ml-1"></v-avatar>
                        <v-avatar color="#E6C5B8" class="ml-1"></v-avatar>
                      </v-row>
                      <v-row>
                        <v-avatar color="#E0E1E0" class="ml-1 mt-3"></v-avatar>
                        <v-avatar color="#E2BAB6" class="ml-1 mt-3"></v-avatar>
                        <v-avatar color="#CCD0E0" class="ml-1 mt-3"></v-avatar>
                        <v-avatar color="#8B9DC2" class="ml-1 mt-3"></v-avatar>
                        <v-avatar color="#959DB6" class="ml-1 mt-3"></v-avatar>
                        <v-avatar color="#CFE7EB" class="ml-1 mt-3"></v-avatar>
                      </v-row>
                    </v-col>

                    <!-- Matériels -->
                    <v-toolbar color="transparent">
                      Matériels
                      <v-spacer></v-spacer>
                      <v-btn :icon="materialsOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="materialsOpen = !materialsOpen"></v-btn>
                    </v-toolbar>
                    <v-row v-if="materialsOpen">
                      <v-col cols="12" sm="6" md="6">
                        <v-checkbox v-model="ex4" label="Wood" color="success" value="success" hide-details></v-checkbox>
                        <v-checkbox v-model="ex4" label="Metal" color="success" value="info" hide-details></v-checkbox>
                        <v-checkbox v-model="ex4" label="Leathers" color="success" value="red" hide-details></v-checkbox>
                      </v-col>
                      <v-col cols="12" sm="6" md="6">
                        <v-checkbox v-model="ex5" label="Fabrics" color="success" value="success"
                          hide-details></v-checkbox>
                        <v-checkbox v-model="ex5" label="Bethrooms" color="success" value="info"
                          hide-details></v-checkbox>
                        <v-checkbox v-model="ex5" label="Beds" color="success" value="red" hide-details></v-checkbox>
                      </v-col>
                    </v-row>

                    <!-- Notes -->
                    <v-toolbar color="transparent">
                      Note minimum
                      <v-spacer></v-spacer>
                      <v-btn :icon="noteOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="noteOpen = !noteOpen"></v-btn>
                    </v-toolbar>
                    <v-rating v-if="noteOpen" v-model="noteMin" color="yellow-darken-3"></v-rating>

                    <!-- Prix maximum -->
                    <v-toolbar color="transparent">
                      Prix
                      <v-spacer></v-spacer>
                      <v-btn :icon="priceOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="priceOpen = !priceOpen"></v-btn>
                    </v-toolbar>
                    <v-range-slider v-if="priceOpen" v-model="rangePrix" :step="1" :min="rangeMin" :max="rangeMax"
                      thumb-label="always" color="#653253"></v-range-slider>

                    <v-btn append-icon="mdi mdi-filter-check-outline"
                      style="width: 60%; margin: 5% 20%; background: #653253; color: white">
                      Filtrer
                    </v-btn>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
          </v-window>
        </v-card>
      </v-container>
    </v-main>

    <Footer />
  </v-app>
</template>

<script setup>
import { ref } from "vue";
import NavBar from "@/components/NavBar.vue"
import Product from "@/components/Product.vue"
import Footer from "@/components/Footer.vue"

const categoriesOpen = ref(true)
const colorsOpen = ref(true)
const materialsOpen = ref(true)
const noteOpen = ref(true)
const priceOpen = ref(true)

const tabActif = ref(1);
const noteMin = ref(1)
const rangeMin = 0
const rangeMax = 500
const rangePrix = ref([rangeMin, rangeMax])

const ex4 = ref([
  "red",
  "indigo",
  "orange",
  "primary",
  "secondary",
  "success",
  "info",
  "warning",
  "error",
  "red darken-3",
  "indigo darken-3",
  "orange darken-3",
])
const ex5 = ref([
  "red",
  "indigo",
  "orange",
  "primary",
  "secondary",
  "success",
  "info",
  "warning",
  "error",
  "red darken-3",
  "indigo darken-3",
  "orange darken-3",
])
</script>