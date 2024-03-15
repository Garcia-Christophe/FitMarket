<template>
  <div style="display: flex; width: 100%; margin: 1%;">
    <img class="img-product" :src="props.product.firstImg" alt=""
      style="object-fit: cover; max-width: 200px; width: 100%; height: 200px;"
      @click="() => $router.push('/product?id=' + props.product.idProduct)">
    <div style="display: flex; width: 100%; justify-content: space-between; align-items: center; margin: 0 5%;">
      <p style="width: 100%; font-size: x-large"><strong>{{ props.product.name }}</strong></p>
      <div style="display: flex; flex-direction: column; width: fit-content; gap: 5px;">
        <div style="display: flex; gap: 20px; justify-content: space-between;">
          <p>Quantité&nbsp;:</p>
          <p>{{ props.product.quantity }}</p>
        </div>
        <div style="display: flex; gap: 20px; justify-content: space-between;">
          <p>Prix&nbsp;unitaire&nbsp;:</p>
          <p>{{ props.product.price }}&nbsp;€</p>
        </div>
        <div style="display: flex; gap: 20px; justify-content: space-between;">
          <p><strong>Prix&nbsp;total&nbsp;:</strong></p>
          <p><strong>{{ props.product.quantity * props.product.price }}&nbsp;€</strong></p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps(['product'])
</script>

<style>
.img-product:hover {
  cursor: pointer;
  box-shadow: rgba(0, 0, 0, 0.2) 0px 10px 16px 0px, rgba(0, 0, 0, 0.19) 0px 6px 20px 0px;
}
</style>