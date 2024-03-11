<template>
  <label :class="carousel ? 'for-carousel' : 'classic'">
    <!-- Note -->
    <div style="display: flex; justify-content: space-between; align-items: center; flex-wrap: wrap">
      <v-rating :model-value="props.comment.note" color="yellow-darken-3" readonly half-increments></v-rating>
      <p>{{ new Date(props.comment.date_time).toLocaleDateString('fr-FR', {
    day: 'numeric', month: 'long', year: 'numeric',
    hour: '2-digit', minute: '2-digit'
  }) }}</p>
    </div>

    <!-- Contenu -->
    <p style="font-weight: bold; font-size: large">{{ props.comment.title }}</p>
    <p style="text-align: justify; margin: 10px 0;">{{ props.comment.content }}</p>
    <p style="font-weight: 500; margin-top: 10px; margin-bottom: 20px">~ {{ props.comment.user.firstname }} {{
    props.comment.user.lastname }}</p>

    <!-- Images -->
    <div v-if="props.comment.images.length" style="display: flex; gap: 20px; overflow: auto">
      <img v-for="(img, i) in props.comment.images" :src="img" :key="i"
        style="width: 150px; height: 150px; object-fit: cover;">
    </div>
  </label>
</template>

<script setup>
const props = defineProps(['comment', 'carousel'])
</script>

<style scoped>
.for-carousel {
  margin: auto;
  padding: 20px;
  width: 45%;
  height: 100%;
  border-radius: 4px;
  position: absolute;
  left: 0;
  right: 0;
  cursor: pointer;
  transition: transform 0.4s ease;
  background-color: white;
  overflow: auto;
}

.classic {
  display: flex;
  flex-direction: column;
  padding: 20px;
  border-radius: 10px;
  cursor: auto;
  background-color: white;
  box-shadow: 0 13px 25px 0 rgba(0, 0, 0, 0.3);
  overflow: auto;
}
</style>