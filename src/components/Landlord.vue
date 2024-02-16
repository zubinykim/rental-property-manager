<template>
  <form v-on:submit.prevent="addProperty">
    <div>
      <label for="description">Description</label>
      <input type="text" v-model="property.description" />
    </div>

    <div>
      <label for="imageUrl">Image Url</label>
      <input type="text" v-model="property.imageUrl" />
    </div>
    <button type="submit">Submit</button>
  </form>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      property: {
        description: "",
        imageUrl: ""
      },
    };
  },
  methods: {
          addProperty(){
            authService.addProperty(this.property).then(
                response => {
                    if (response.status == 201){
                        alert("Property added")
                        this.$router.push("/properties")
                    }
                }
            )
          }
      },
};
</script>