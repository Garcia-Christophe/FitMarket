<template>
  <v-app>
    <!-- Barre de navigation -->
    <NavBar :color="navBarBg" />

    <!-- Accueil 1re impression -->
    <div class="image shape"
      style="background: url('backgroundAccueilAllonge.png'); background-size: cover; background-position: center; display: flex; justify-content: center; position: absolute; height: 400px; width: 100%;">
      <v-row class="row-acheter-maintenant">
        <v-btn prepend-icon="mdi mdi-star" v-on:click="scrollTo('best-comments')">Vos avis</v-btn>
        <v-btn rounded="xl" style="background: #D7473F; color: white;" @click="() => $router.push('/cart')">Acheter
          maintenant</v-btn>
        <v-btn prepend-icon="mdi mdi-handshake" v-on:click="scrollTo('partners')">Partenaires</v-btn>
      </v-row>
    </div>

    <!-- Recherche de produits -->
    <v-main>
      <v-container>
        <v-card style="margin-top: 320px" flat>
          <!-- Tabs -->
          <v-tabs v-model="tab" color="#D7473F" align-tabs="center">
            <v-tab :value="1">Ordre aléatoire</v-tab>
            <v-tab :value="2">Les mieux notés</v-tab>
            <v-tab :value="3">Les plus commentés</v-tab>
            <v-tab :value="4">Ordre prix croissant</v-tab>
            <v-tab :value="5">Ordre prix décroissant</v-tab>
          </v-tabs>

          <!-- Contenu des tabs -->
          <v-window v-model="tab">
            <v-window-item v-for="n in 5" :key="n" :value="n" :transition="true" style="width: 100%; padding: 0% 5%">
              <v-container fluid>
                <v-row>
                  <v-col cols="12" sm="9">
                    <v-col v-if="filteredProducts.length" cols="12" sm="12">
                      <v-row>
                        <v-col sm="4" v-for="(product, i) in filteredProducts" :key="i">
                          <v-card class="mx-auto product" max-width="344">
                            <v-img class="product-card-img" :src="product.images?.[0]" height="200px" cover
                              @click="() => $router.push('/product?id=' + product.id)"></v-img>
                            <v-divider></v-divider>

                            <v-card-title>
                              {{ product.title }}
                            </v-card-title>

                            <v-card-actions>
                              <p style="margin-left: 8px">{{ product.price }} €</p>
                              <v-spacer></v-spacer>
                              <v-btn size="small" color="surface-radiant" variant="text" icon="mdi-cart"
                                @click="addToCart"></v-btn>
                              <v-btn size="small" color="surface-radiant" variant="text" icon="mdi-link"
                                @click="() => copyLink(product.id)"></v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-col>
                      </v-row>
                    </v-col>
                    <p v-else sm="4" style="font-size: large; text-align: center; margin: 20px auto; font-weight: 500">
                      Aucun résultat ne correspond aux filtres appliqués
                    </p>
                  </v-col>

                  <v-col cols="12" sm="3" style="justify-content: center">
                    <v-alert variant="outlined" style="border-color: #653253;">
                      <div
                        style="width: 90%; margin: auto; display: flex; flex-direction: column; justify-content: center;">
                        <p style="text-align: center; font-size: x-large">
                          <v-icon icon="mdi mdi-filter-check-outline"></v-icon>
                          Filtres
                        </p>

                        <!-- Catégories -->
                        <v-toolbar color="transparent">
                          Catégories
                          <v-spacer></v-spacer>
                          <v-btn :icon="categoriesOpen ? 'mdi-chevron-down' : 'mdi-chevron-up'"
                            v-on:click="categoriesOpen = !categoriesOpen"></v-btn>
                        </v-toolbar>
                        <v-row v-if="categoriesOpen">
                          <v-col cols="12" sm="6" md="6">
                            <v-checkbox v-model="equipment" label="Équipement" color="#653253" hide-details />
                            <v-checkbox v-model="nutrition" label="Nutrition" color="#653253" hide-details />
                          </v-col>
                          <v-col cols="12" sm="6" md="6">
                            <v-checkbox v-model="clothes" label="Vêtements" color="#653253" hide-details />
                            <v-checkbox v-model="classes" label="Cours" color="#653253" hide-details />
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
                        <v-range-slider v-if="priceOpen" v-model="price" :step="1" :min="rangeMin" :max="rangeMax"
                          thumb-label="always" color="#653253" style="margin-top: 20px"></v-range-slider>

                        <!-- Bouton Filtrer -->
                        <v-btn prepend-icon="mdi mdi-filter-check-outline" color="#653253" v-on:click="sortProducts"
                          style="margin-bottom: 20px">Filtrer</v-btn>
                      </div>
                    </v-alert>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
          </v-window>
        </v-card>
      </v-container>

      <v-snackbar v-model="addedToCart" :timeout="2000" elevation="24">
        Produit ajouté au panier !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="addedToCart = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
      <v-snackbar v-model="linkCopied" :timeout="2000" elevation="24">
        Lien copié dans le presse-papier !

        <template v-slot:actions>
          <v-btn color="#D56F97" variant="text" @click="linkCopied = false">
            Fermer
          </v-btn>
        </template>
      </v-snackbar>
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
import { ref, watch } from "vue";
import NavBar from "@/components/NavBar.vue"
import BestComments from "@/components/BestComments.vue"
import Footer from "@/components/Footer.vue"

window.addEventListener('scroll', handleScroll);

const navBarBg = ref(window.scrollY > 0 ? '#D7473F' : 'transparent')

const categoriesOpen = ref(true)
const noteOpen = ref(true)
const priceOpen = ref(true)
const tab = ref(1)
const equipment = ref(true)
const nutrition = ref(true)
const clothes = ref(true)
const classes = ref(true)
const noteMin = ref(1)
const [rangeMin, rangeMax] = [0, 500]
const price = ref([rangeMin, rangeMax])

watch(tab, sortProducts)

const addedToCart = ref(false)
const linkCopied = ref(false)

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
const allProducts = ref([])
const filteredProducts = ref([])

fetch('http://localhost:8080/api/v1/products')
  .then((res) => res.json())
  .then((res) => allProducts.value.push(...res.sort(() => Math.random() - 0.5)) && sortProducts())

async function sortProducts() {
  let filteredProductsTmp = [...allProducts.value]

  // Catégories
  if (!equipment.value) {
    filteredProductsTmp = filteredProductsTmp.filter((product) => product.category !== 'EQUIPMENT')
  }
  if (!nutrition.value) {
    filteredProductsTmp = filteredProductsTmp.filter((product) => product.category !== 'NUTRITION')
  }
  if (!clothes.value) {
    filteredProductsTmp = filteredProductsTmp.filter((product) => product.category !== 'CLOTHES')
  }
  if (!classes.value) {
    filteredProductsTmp = filteredProductsTmp.filter((product) => product.category !== 'CLASSES')
  }

  // Note
  const asyncFilter = async (predicate) => Promise.all(filteredProductsTmp.map(predicate))
    .then((results) => filteredProductsTmp.filter((_, i) => results[i]))

  filteredProductsTmp = await asyncFilter(async (product) => {
    const comments = await (await fetch(`http://localhost:8080/api/v1/comments/${product.id}`)).json()
    product.nbComments = comments.length
    product.noteAvg = (comments.reduce((sum, comment) => sum + comment.note, 0) / comments.length) || 1
    return product.noteAvg >= noteMin.value
  })

  // Prix
  filteredProductsTmp = filteredProductsTmp.filter((product) => product.price >= price.value[0] && product.price <= price.value[1])

  // Onglet
  if (tab.value === 1) {
    // Ordre aléatoire
    filteredProductsTmp = filteredProductsTmp.sort(() => Math.random() - 0.5)
  } else if (tab.value === 2) {
    // Les mieux notés
    filteredProductsTmp = filteredProductsTmp.sort((a, b) => b.noteAvg - a.noteAvg)
  } else if (tab.value === 3) {
    // Les plus commentés
    filteredProductsTmp = filteredProductsTmp.sort((a, b) => b.nbComments - a.nbComments)
  } else if (tab.value === 4) {
    // Ordre prix croissant
    filteredProductsTmp = filteredProductsTmp.sort((a, b) => a.price - b.price)
  } else if (tab.value === 5) {
    // Ordre prix décroissant
    filteredProductsTmp = filteredProductsTmp.sort((a, b) => b.price - a.price)
  }

  filteredProducts.value = filteredProductsTmp
}

function scrollTo(id) {
  document.getElementById(id)?.scrollIntoView({ behavior: 'smooth' });
}

function handleScroll() {
  navBarBg.value = window.scrollY > 0 ? '#D7473F' : 'transparent'
}

function copyLink(id) {
  navigator.clipboard.writeText(`http://localhost:3000/product?id=${id}`)
  linkCopied.value = true;
  setTimeout(() => linkCopied.value = false, 2000)
}

function addToCart() {
  addedToCart.value = true;
  setTimeout(() => addedToCart.value = false, 2000)
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

.product:hover {
  box-shadow: rgba(0, 0, 0, 0.2) 0px 10px 16px 0px, rgba(0, 0, 0, 0.19) 0px 6px 20px 0px !important
}

.product-card-img:hover {
  cursor: pointer
}
</style>