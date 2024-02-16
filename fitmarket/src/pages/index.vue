<template>
  <v-app>
    <!-- Barre de navigation -->
    <NavBar :color="navBarBg" />

    <!-- Accueil 1re impression -->
    <div class="image shape"
      style="background: url('backgroundAccueilAllonge.png'); background-size: cover; background-position: center; display: flex; justify-content: center; position: absolute; height: 400px; width: 100%;">
      <v-row class="row-acheter-maintenant">
        <v-btn prepend-icon="mdi mdi-star" v-on:click="scrollTo('best-comments')">Vos avis</v-btn>
        <v-btn rounded="xl" style="background: #D7473F; color: white;">Acheter maintenant</v-btn>
        <v-btn prepend-icon="mdi mdi-handshake" v-on:click="scrollTo('partners')">Partenaires</v-btn>
      </v-row>
    </div>

    <!-- Recherche de produits -->
    <v-main>
      <v-container>
        <v-card style="margin-top: 320px" flat>
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
            <v-window-item v-for="n in 5" :key="n" :value="n" :transition="true" style="width: 100%; padding: 0% 5%">
              <v-container fluid>
                <v-row>
                  <v-col cols="12" sm="9">
                    <ProductCards />
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
                    <v-rating v-if="noteOpen" v-model="noteMin" color="yellow-darken-3" hover></v-rating>

                    <!-- Prix maximum -->
                    <v-toolbar color="transparent">
                      Prix
                      <v-spacer></v-spacer>
                      <v-btn :icon="priceOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                        v-on:click="priceOpen = !priceOpen"></v-btn>
                    </v-toolbar>
                    <v-range-slider v-if="priceOpen" v-model="rangePrix" :step="1" :min="rangeMin" :max="rangeMax"
                      thumb-label="always" color="#653253" style="margin-top: 20px"></v-range-slider>

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

    <!-- Meilleurs avis -->
    <BestComments id="best-comments" />

    <!-- Partenaires -->
    <div id="partners"
      style="display: flex; flex-direction: column; gap: 20px; justify-content: center; width: 80%; margin: 50px auto">
      <p style="font-size: xx-large; text-align: center; font-weight: bold">Nos partenaires</p>

      <div style="display: flex; column-gap: 100px; row-gap: 10px; justify-content: center; flex-wrap: wrap">
        <a v-for="(partner, i) in partners" :key="i" :href="partner.url" target="_blank"
          style="display: flex; flex-direction: column; justify-content: center; align-items: center; text-decoration: none; color: inherit;">
          <img :src="partner.logo" style="width: 100px; height: 100px; object-fit: contain">
          <p style="text-align: center">{{ partner.name }}</p>
        </a>
      </div>
    </div>

    <!-- Footer -->
    <Footer />
  </v-app>
</template>

<script setup>
import { ref } from "vue";
import NavBar from "@/components/NavBar.vue"
import ProductCards from "@/components/ProductCards.vue"
import BestComments from "@/components/BestComments.vue"
import Footer from "@/components/Footer.vue"

window.addEventListener('scroll', handleScroll);

const navBarBg = ref(window.scrollY > 0 ? '#D7473F' : 'transparent')

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

const partners = ref([{
  name: "Nike",
  logo: "https://static.vecteezy.com/ti/vecteur-libre/p1/12560876-logo-nike-sur-fond-transparent-gratuit-vectoriel.jpg",
  url: "https://www.nike.com/fr/",
}, {
  name: "Adidas",
  logo: "https://www.shutterstock.com/image-vector/valencia-spain-april-25-2023-600nw-2293213071.jpg",
  url: "https://www.adidas.fr/",
}, {
  name: "Nu3",
  logo: "https://www.nu3.fr/cdn/shop/collections/nu3_1200x1200.jpg?v=1605190011",
  url: "https://www.nu3.fr/",
}, {
  name: "BH Fitness",
  logo: "https://bh.fitness/content/themes/bhfitness/assets/components/header-mobile/img/bh-fitness-logo.png",
  url: "https://bh.fitness/fr/",
}, {
  name: "Hammer Strength",
  logo: "https://pbs.twimg.com/media/DLPWZsFU8AArEt_.jpg",
  url: "https://www.instagram.com/hammerstrengthofficial/?hl=fr",
}, {
  name: "MyProtein",
  logo: "https://upload.wikimedia.org/wikipedia/en/0/05/Myprotein_logo.png",
  url: "https://fr.myprotein.com/",
}, {
  name: "Eric Flag",
  logo: "https://s3-eu-west-1.amazonaws.com/tpd/logos/6189166f31723d1506ccb601/0x0.png",
  url: "https://ericflag.com/",
}, {
  name: "Tibo InShape",
  logo: "https://blog.tiboinshape.com/wp-content/uploads/2021/08/TEAMSHAPE_LOGO-noir.png",
  url: "https://tiboinshape.com/shop/",
}, {
  name: "Asics",
  logo: "https://stickair.com/18861-large_default/asics-logo.jpg",
  url: "https://www.asics.com/fr/fr-fr/",
}, {
  name: "Hoka",
  logo: "https://www.captainwild.com/wp-content/uploads/2021/04/MARQUE-LOGO-HOKA-ONE-ONE.jpg",
  url: "https://www.hoka.com/fr/fr/",
}, {
  name: "Brooks",
  logo: "https://sportbusiness.club/wp-content/uploads/2020/04/Brooks-1-Logo.jpg",
  url: "https://www.brooksrunning.com/fr_fr",
}, {
  name: "TechnoGym",
  logo: "https://gymaddict.fr/wp-content/uploads/2019/03/cropped-technogym-logo-600x315.png",
  url: "https://www.technogym.com/fr-FR/",
}, {
  name: "Gorilla Sports",
  logo: "https://www.nouvelobs.com/codepromo/static/shop/37464/logo/code-promo-gorilla-sports.png",
  url: "https://www.gorillasports.fr/",
}])

function scrollTo(id) {
  document.getElementById(id)?.scrollIntoView({ behavior: 'smooth' });
}

function handleScroll() {
  navBarBg.value = window.scrollY > 0 ? '#D7473F' : 'transparent'
}
</script>

<style scoped>
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