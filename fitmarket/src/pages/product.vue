<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main style="padding: 50px 5%;">
      <!-- présentation produit -->
      <div id="div-wrap" style="display: flex; gap: 50px; justify-content: center;">
        <div style="display: flex; flex-direction: column; align-items: center; gap: 10px; flex-shrink: 1;">
          <!-- Images -->
          <img :src="product.images?.[idxImg]" style="object-fit: cover; max-width: 600px; width: 100%;">
          <v-btn v-if="product.images?.length > 1" elevation="0" v-on:click="nextImage()"><u>Prochaine image</u></v-btn>

          <!-- actions -->
          <div style="display: flex; justify-content: space-evenly; margin: 20px 0; flex-wrap: wrap; column-gap: 20px;">
            <v-text-field style="max-width: 100px" type="number" color="#D7473F" v-model="quantity" min="1" required />
            <v-btn style="min-width: 200px; margin-top: 10px" prepend-icon="mdi mdi-cart" v-on:click="addToCart"
              color="#D7473F">Ajouter au panier</v-btn>
            <v-btn style="min-width: 200px; margin-top: 10px" prepend-icon="mdi mdi-link" v-on:click="copyLink">Copier
              le lien</v-btn>
            <v-snackbar v-model="linkCopied" :timeout="2000" elevation="24">
              Lien copié dans le presse-papier !

              <template v-slot:actions>
                <v-btn color="#D56F97" variant="text" @click="linkCopied = false">
                  Fermer
                </v-btn>
              </template>
            </v-snackbar>
            <v-snackbar v-model="addedToCart" :timeout="2000" elevation="24">
              Produit ajouté au panier !

              <template v-slot:actions>
                <v-btn color="#D56F97" variant="text" @click="addedToCart = false">
                  Fermer
                </v-btn>
              </template>
            </v-snackbar>
          </div>
        </div>

        <div style="display: flex; flex-direction: column; flex-shrink: 100;">
          <!-- Titre -->
          <h1>{{ product.title }}</h1>

          <!-- Prix + note moyenne -->
          <div
            style="display: flex; justify-content: space-between; align-items: center; flex-wrap: wrap; margin: 10px 0;">
            <p style="font-size: x-large;">{{ product.price }}&nbsp;€</p>
            <div style="display: flex; align-items: center; justify-content: center; flex-wrap: wrap;">
              <v-rating :model-value="noteAvg" color="yellow-darken-3" readonly half-increments></v-rating>
              <p>({{ comments.length }} avis)</p>
            </div>
          </div>

          <!-- description -->
          <p style="word-wrap: break-word; white-space: pre-wrap;">
            {{ product.description }}</p>
        </div>
      </div>

      <hr style="margin: 30px auto;">

      <!-- commentaires -->
      <div style="margin: 0 15%">
        <p style="font-size: x-large; text-align: center; font-weight: bold; margin: 20px auto;">
          Explorez les retours d'expérience de nos clients fidèles !
        </p>

        <div v-if="comments.length" style="display: flex; flex-direction: column; gap: 50px; margin-bottom: 50px;">
          <ProductComment v-for="( comment, i ) in  comments " :key="i" :comment="comment" />
        </div>
      </div>

      <!-- formulaire d'ajout d'un commentaire -->
      <v-card v-if="isConnected()">
        <v-card-text style="display: flex; flex-direction: column; gap: 20px">
          <p style="font-size: x-large; text-align: center; margin: 20px auto;">
            Ajoutez un commentaire !
          </p>

          <!-- Formulaire -->
          <v-form>
            <div style="display: flex; align-items: center; gap: 10px; margin: 10px auto;">
              <v-icon icon="mdi-star" color="#7A7A7A" style="padding-left: 3px"></v-icon>
              <v-rating v-model="newComment.note" color="yellow-darken-3" hover></v-rating>
            </div>
            <v-text-field label="Titre" prepend-icon="mdi-format-title" type="text" color="#D7473F"
              v-model="newComment.title" />
            <v-textarea label="Message" prepend-icon="mdi-text-long" color="#D7473F" v-model="newComment.content" />
            <v-file-input id="file-input" accept="image/*" label="Photos" multiple chips
              v-on:change="handleChangeFileInput" v-model="files"></v-file-input>

            <!-- Bouton Se connecter -->
            <div style="display: flex; flex-direction: column; width: 15%; margin: auto">
              <v-btn rounded color="#D7473F" v-on:click="publishComment">PUBLIER</v-btn>
            </div>
          </v-form>
        </v-card-text>
      </v-card>
    </v-main>

    <!-- Notification champs manquants nouveau commentaire -->
    <v-snackbar v-model="missingFiels" :timeout="2000" elevation="24">
      Veuillez saisir un titre et un message !

      <template v-slot:actions>
        <v-btn color="#D56F97" variant="text" @click="missingFiels = false">
          Fermer
        </v-btn>
      </template>
    </v-snackbar>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute } from 'vue-router'
import NavBar from '@/components/NavBar.vue'
import ProductComment from '@/components/ProductComment.vue';

window.addEventListener('resize', handleWrap);

const route = useRoute();

const idxImg = ref(0);
const files = ref(null);

const product = ref({
  id: 0,
  title: "",
  price: 0,
  description: "",
  category: "",
  images: []
})
const comments = ref([])
const quantity = ref(1);
const noteAvg = ref(noteAvgCalc())
const linkCopied = ref(false)
const addedToCart = ref(false)

fetch(`http://localhost:8080/api/v1/products/${route.query.id}`)
  .then((res) => res.json())
  .then((res) => {
    product.value.id = res.id
    product.value.title = res.title
    product.value.price = res.price
    product.value.description = res.description
    product.value.images = res.images
    product.value.category = res.category

    fetch(`http://localhost:8080/api/v1/comments/${res.id}`)
      .then((res2) => res2.json())
      .then((res2) => {
        res2.forEach((comment) => {
          comments.value.push({
            id: comment.id,
            user: comment.user,
            title: comment.title,
            content: comment.content,
            date_time: comment.date_time,
            note: comment.note,
            images: comment.images || []
          })
        })
        noteAvg.value = noteAvgCalc()
      })
  })

const defaultComment = {
  title: "",
  content: "",
  date_time: "",
  note: 5,
  images: []
}

const newComment = ref({ ...defaultComment })
const missingFiels = ref(false)

function nextImage() {
  idxImg.value = idxImg.value === product.value.images.length - 1 ? 0 : idxImg.value + 1;
}

function handleWrap() {
  document.getElementById('div-wrap').style['flex-wrap'] = window.innerWidth > 1200 ? 'nowrap' : 'wrap';
}

function handleChangeFileInput(e) {
  newComment.value.images = [];
  [...e.target.files].forEach((file) => {
    const reader = new FileReader();
    reader.onloadend = () => newComment.value.images.push(reader.result);
    reader.readAsDataURL(file);
  })
}

async function publishComment() {
  if (newComment.value.title && newComment.value.content) {
    // Définition de la date, du user et du produit
    newComment.value.date_time = new Date()
    newComment.value.user = { ...JSON.parse(localStorage.getItem('connectedUser')) }
    newComment.value.product = { ...product.value }

    // Ajout du commentaire
    const data = await fetch('http://localhost:8080/api/v1/comments', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        content: newComment.value.content,
        date_time: new Date(newComment.value.date_time).toISOString().slice(0, 19).replace('T', ' '),
        images: newComment.value.images,
        note: newComment.value.note,
        title: newComment.value.title,
        product: {
          id: product.value.id,
        },
        user: {
          lastname: JSON.parse(localStorage.getItem('connectedUser')).lastname,
          firstname: JSON.parse(localStorage.getItem('connectedUser')).firstname,
          email: JSON.parse(localStorage.getItem('connectedUser')).email,
          password: JSON.parse(localStorage.getItem('connectedUser')).password,
        }
      })
    })
    if (data.ok) {
      comments.value.push(newComment.value)

      // Reset + recalcul de la note moyenne
      newComment.value = { ...defaultComment };
      files.value = null;
      noteAvg.value = noteAvgCalc()
    }
  } else {
    missingFiels.value = true;
    setTimeout(() => missingFiels.value = false, 5000)
  }
}

function noteAvgCalc() {
  return comments.value.reduce((total, next) => total + next.note, 0) / comments.value.length;
}

function copyLink() {
  navigator.clipboard.writeText(`http://localhost:3000/product?id=${product.value.id}`)
  linkCopied.value = true;
  setTimeout(() => linkCopied.value = false, 2000)
}

async function addToCart() {
  // Enregistrement de la commande
  const userId = JSON.parse(localStorage.getItem('connectedUser')).id
  let orderInProgress;
  try {
    orderInProgress = await (await fetch(`http://localhost:8080/api/v1/orders/${userId}/inprogress`)).json()
  } catch (e) {
    console.log(e);
  }

  if (orderInProgress.code === '404') {
    orderInProgress = { products: [{ quantity: Number(quantity.value), product: { id: product.value.id } }] }
  } else {
    const existingProduct = orderInProgress.products.find((p) => p.product.id === product.value.id)
    if (existingProduct) {
      // Augmentation de la quantité
      existingProduct.quantity += quantity.value
    } else {
      // Ajout du produit
      orderInProgress.products.push({ quantity: quantity.value, product: { id: product.value.id } })
    }
  }
  console.log(JSON.stringify(orderInProgress));

  await fetch(`http://localhost:8080/api/v1/orders/${userId}`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(orderInProgress)
  })

  // Notification
  addedToCart.value = true;
  setTimeout(() => addedToCart.value = false, 2000)
}

function isConnected() {
  return localStorage.getItem('connectedUser')
}
</script>