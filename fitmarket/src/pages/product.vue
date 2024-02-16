<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main style="padding: 50px 5%;">
      <!-- présentation produit -->
      <div id="div-wrap" style="display: flex; gap: 50px; justify-content: center;">
        <div style="display: flex; flex-direction: column; align-items: center; gap: 10px; flex-shrink: 1;">
          <!-- Images -->
          <img :src="product.images[idxImg]" style="object-fit: cover; max-width: 600px; width: 100%;">
          <v-btn v-if="product.images.length > 1" elevation="0" v-on:click="nextImage()"><u>Prochaine image</u></v-btn>

          <!-- actions -->
          <div style="display: flex; justify-content: space-evenly; margin: 20px 0; flex-wrap: wrap; column-gap: 20px;">
            <v-text-field style="max-width: 100px" type="number" color="#D7473F" v-model="quantity" min="1" required />
            <v-btn style="min-width: 200px; margin-top: 10px" prepend-icon="mdi mdi-cart"
              v-on:click="() => console.log('au panier !')" color="#D7473F">Ajouter au panier</v-btn>
            <v-btn style="min-width: 200px; margin-top: 10px" prepend-icon="mdi mdi-link"
              v-on:click="() => console.log('lien copié !')">Copier le lien</v-btn>
          </div>
        </div>

        <div style="display: flex; flex-direction: column; flex-shrink: 100;">
          <!-- Titre -->
          <h1>{{ product.name }}</h1>

          <!-- Prix + note moyenne -->
          <div
            style="display: flex; justify-content: space-between; align-items: center; flex-wrap: wrap; margin: 10px 0;">
            <p style="font-size: x-large;">{{ product.price }}&nbsp;€</p>
            <div style="display: flex; align-items: center; justify-content: center; flex-wrap: wrap;">
              <v-rating :model-value="noteAvg" color="yellow-darken-3" readonly half-increments></v-rating>
              <p>({{ product.comments.length }} avis)</p>
            </div>
          </div>

          <!-- description -->
          <p style="text-align: justify; word-wrap: break-word; white-space: pre-wrap;">
            {{ product.description }}</p>
        </div>
      </div>

      <hr style="margin: 30px auto;">

      <!-- commentaires -->
      <div style="margin: 0 15%">
        <p style="font-size: x-large; text-align: center; font-weight: bold; margin: 20px auto;">
          Explorez les retours d'expérience de nos clients fidèles !
        </p>

        <div style="display: flex; flex-direction: column; gap: 50px; margin-bottom: 50px;">
          <ProductComment v-for="(comment, i) in product.comments" :key="i" :comment="comment" />
        </div>
      </div>

      <!-- formulaire d'ajout d'un commentaire -->
      <!-- TODO: html/css/js -->
      <v-card>
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
              v-model="newComment.titre" />
            <v-textarea label="Message" prepend-icon="mdi-text-long" color="#D7473F" v-model="newComment.contenu" />
            <v-file-input id="file-input" accept="image/*" label="Photos" multiple chips
              v-on:change="handleChangeFileInput" v-model="files"></v-file-input>

            <!-- Bouton Se connecter -->
            <div style="display: flex; flex-direction: column; width: 15%; margin: auto">
              <v-btn rounded color="#D7473F" v-on:click="publishComment()">PUBLIER</v-btn>
            </div>
          </v-form>

        </v-card-text>
      </v-card>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
import NavBar from '@/components/NavBar.vue'
import ProductComment from '@/components/ProductComment.vue';

window.addEventListener('resize', handleWrap);

const idxImg = ref(0);
const files = ref(null);

const product = ref({
  name: "Banc de Musculation",
  price: 29.99,
  description: "Hauteur ajustable : Notre banc de musculation et son rouleau se règlent très rapidement à 7 différentes hauteurs (de 35 à 50 cm) en fonction de l'exercice souhaité et de votre morphologie.\n\nConfort maximal: Il était essentiel pour nous de proposer un banc de musculation complet alliant confort et design.Ce banc de sport propose un coussin et une plateforme de forte épaisseur, rien de mieux pour réaliser des séances de musculation intenses et sans gêne !\n\nUltra- polyvalent : Vous pourrez effectuer une multitude d'exercices sur notre banc de musculation. Il est également possible de placer des bandes élastiques de part et d'autre du Power Bench grâce aux supports de fixation.\n\nVoici quelques exemples d'exercices réalisables avec le banc de sport multi-fonctions : \n\nHip Trust : Fessier\nCrunch & Dragon Flag : Abdominaux\nNordic Ham Curls : Ischio - jambier & Fessier\nFentes Bulgares : Fessier & Quadriceps\nPompes : Pectoraux\nBox Step Up : Fessier, Quadriceps & Ischio - jambiers\nTirage Bûcheron : Dos\nPistol Squat : Fessier & Quadriceps\nRowing avec Bandes Élastiques : Grand Dorsal\nCharge maximale : 300 kg",
  images: ["https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717", "https://ericflag.com/cdn/shop/products/Slide-Bar-1200x1200.jpg?v=1702655402", "https://ericflag.com/cdn/shop/products/slide-1800x-2.jpg?v=1702655402"],
  comments: [{
    id: '1',
    nomUtilisateur: 'Sorin',
    prenomUtilisateur: 'Audrey',
    titre: "Une histoire d'amour... Tout bonnement",
    contenu: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
    date: "29 janvier 2024",
    note: 4,
    images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
  },
  {
    id: '2',
    nomUtilisateur: 'Sorin',
    prenomUtilisateur: 'Anne',
    titre: "Service client exceptionnel",
    contenu: "Service client exceptionnel ! J'avais un soucis avec ma slide bar (causé par utilisateur, pas un défaut de production). J'ai contacté le service client et j'ai pu avoir des pièces détachés sans le moindre inconvénient, ce qui m'a permis du coup de réutiliser ma slide bar, me faire économiser de l'argent et de moins polluer finalement !",
    date: "01 février 2024",
    note: 5,
    images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
  }, {
    id: '3',
    nomUtilisateur: 'Sorin',
    prenomUtilisateur: 'Anthony',
    titre: "Matériaux très qualitatifs",
    contenu: "Matériaux très qualitatifs et gilet fonctionnel. Testé en pompes et rucking, très bonne expérience (moins de24 heures, mais je suis jusqu'à présent très satisfait des produits utilisés, ceinture et parallettes).",
    date: "15 janvier 2024",
    note: 5,
    images: []
  }]
})
const quantity = ref(1);
const noteAvg = ref(noteAvgCalc())

const defaultComment = {
  id: '1',
  nomUtilisateur: 'Sorin',
  prenomUtilisateur: 'Audrey',
  titre: "",
  contenu: "",
  date: new Date().toLocaleDateString('fr-FR', { year: 'numeric', month: 'long', day: 'numeric' }),
  note: 5,
  images: []
}

const newComment = ref({ ...defaultComment })

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

function publishComment() {
  product.value.comments.push(newComment.value)
  newComment.value = { ...defaultComment };
  files.value = null;
  noteAvg.value = noteAvgCalc()
}

function noteAvgCalc() {
  return product.value.comments.reduce((total, next) => total + next.note, 0) / product.value.comments.length;
}
</script>