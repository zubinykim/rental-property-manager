<template>
  <div class="container">
    <h1 class="title">List of available properties</h1>
    <div class="property-list">
      <div
        class="property-item"
        v-for="item in properties"
        :key="item.id"
      >
         <router-link :to="{ name: 'propertyDetails', params: { id: item.propertyId } }">
          <property-card :data="item" />
        </router-link> 
      </div>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import PropertyCard from "../components/PropertyCard.vue";

export default {
  data() {
    return {
      properties: [],
    };
  },

  components: {
    PropertyCard,
  },
  created(){
      authService.getAvailableProperties()
      .then(response => {
          const temp = response;
          if (response.status == 200){
              this.properties = response.data
              this.$store.commit("UPDATE_AVAILABLE_PROPERTIES", this.properties)
          }
      })
  }
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.property-list {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.property-item {
  flex: 0 0 auto;
  margin-right: 10px;
  margin-left: 10px;
  margin-bottom: 10px;
}

.title {
  display: flex;
  justify-content: center;
}
</style>