<template>
  <div id="best-comments">
    <p id="title">Découvrez les témoignages de ceux qui nous ont fait confiance !</p>

    <section id="slider">
      <input type="radio" name="slider" id="s1" checked>
      <input type="radio" name="slider" id="s2">
      <input type="radio" name="slider" id="s3">
      <input type="radio" name="slider" id="s4">
      <input type="radio" name="slider" id="s5">

      <ProductComment v-for="(comment, i) in comments" :for="`s${i + 1}`" :id="`slide${i + 1}`" :key="i"
        :comment="comment" carousel="true" />
    </section>
  </div>
</template>

<script setup>
import { ref } from 'vue';

import ProductComment from '@/components/ProductComment.vue';

const comments = ref([{
  id: '1',
  user: {
    firstname: 'Alexia',
    lastname: 'Sorin',
  },
  titme: "Une histoire d'amour... Tout bonnement",
  content: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
  date_time: "29 janvier 2024",
  note: 4,
  images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
}, {
  id: '1',
  user: {
    firstname: 'Alexia',
    lastname: 'Sorin',
  },
  titme: "Une histoire d'amour... Tout bonnement",
  content: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
  date_time: "29 janvier 2024",
  note: 4,
  images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
}, {
  id: '1',
  user: {
    firstname: 'Alexia',
    lastname: 'Sorin',
  },
  titme: "Une histoire d'amour... Tout bonnement",
  content: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
  date_time: "29 janvier 2024",
  note: 4,
  images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
}, {
  id: '1',
  user: {
    firstname: 'Alexia',
    lastname: 'Sorin',
  },
  titme: "Une histoire d'amour... Tout bonnement",
  content: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
  date_time: "29 janvier 2024",
  note: 4,
  images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
}, {
  id: '1',
  user: {
    firstname: 'Alexia',
    lastname: 'Sorin',
  },
  titme: "Une histoire d'amour... Tout bonnement",
  content: "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !",
  date_time: "29 janvier 2024",
  note: 4,
  images: ["https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png", "https://assets.roguefitness.com/f_auto,q_auto,c_limit,w_1536,b_rgb:f8f8f8/catalog/Straps%20Wraps%20and%20Support%20/Belts%20/Weightlifting/HDDLEVSD/HDDLEVSD-h_ylyzck.png"]
}])
</script>

<style scoped>
#best-comments {
  background-color: #653253;
}

#title {
  font-size: xx-large;
  text-align: center;
  font-weight: bold;
  margin: 20px auto;
  color: white;
}

[type=radio] {
  display: none;
}

#slider {
  height: 450px;
  position: relative;
  margin-bottom: 50px;
  perspective: 1000px;
  transform-style: preserve-3d;
}

/* Tout à gauche */
#s1:checked~#slide4,
#s2:checked~#slide5,
#s3:checked~#slide1,
#s4:checked~#slide2,
#s5:checked~#slide3 {
  box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.37);
  transform: translate3d(-30%, 0, -200px);
  filter: blur(2px);
}

/* Milieu gauche */
#s1:checked~#slide5,
#s2:checked~#slide1,
#s3:checked~#slide2,
#s4:checked~#slide3,
#s5:checked~#slide4 {
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.3), 0 2px 2px 0 rgba(0, 0, 0, 0.2);
  transform: translate3d(-15%, 0, -100px);
  filter: blur(1px);
}

/* Milieu */
#s1:checked~#slide1,
#s2:checked~#slide2,
#s3:checked~#slide3,
#s4:checked~#slide4,
#s5:checked~#slide5 {
  box-shadow: 0 13px 25px 0 rgba(0, 0, 0, 0.3), 0 11px 7px 0 rgba(0, 0, 0, 0.19);
  transform: translate3d(0, 0, 0);
}

/* Milieu droite */
#s1:checked~#slide2,
#s2:checked~#slide3,
#s3:checked~#slide4,
#s4:checked~#slide5,
#s5:checked~#slide1 {
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.3), 0 2px 2px 0 rgba(0, 0, 0, 0.2);
  transform: translate3d(15%, 0, -100px);
  filter: blur(1px);
}

/* Tout à droite */
#s1:checked~#slide3,
#s2:checked~#slide4,
#s3:checked~#slide5,
#s4:checked~#slide1,
#s5:checked~#slide2 {
  box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.37);
  transform: translate3d(30%, 0, -200px);
  filter: blur(2px);
}
</style>