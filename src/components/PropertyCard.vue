<template>
  <div>
    <img :src="data.imageUrl" style="width: 400px; height: auto" />
    <p>{{ data.description }} </p>
  </div>
</template>

<script>
export default {
  props: {
    data: Object,
  },
};
</script>