<template>
  <div class="card">
    <img  style="width:700px" :src="property.imageUrl" />
    <p>{{ property.description }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      property: {},
    };
  },
  created() {
    const propertyId = this.$route.params.id;
    this.property = this.$store.state.availableProperties.find(
      (x) => x.propertyId === parseInt(propertyId)
    );
  },
};
</script>

<style scoped>

.card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

</style>