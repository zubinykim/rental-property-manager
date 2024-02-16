<template>
  <div class="home">
    <h1>Home</h1>
    <p v-if="user">Your Role: {{ role }}</p>
    <p>If you are seeing this, you are authenticated.</p>

      <landlord-view v-if="role==='ROLE_LANDLORD'" />
      <tenant-view v-if="role==='ROLE_TENANT'" />
      <maintenance-view v-if="role==='ROLE_MAINTENANCE'" />

  </div>
</template>

<script>
import LandlordView from "../components/Landlord.vue"
import MaintenanceView from '../components/Maintenance.vue';
import TenantView from "../components/Tenant.vue"

export default {
  
  data () {
    return {
      user: {},
      role : ""
    }
  },
  components : {
    LandlordView,
    TenantView,
    MaintenanceView
  },
  created() {
    
    this.getLoggedInUser();
    this.getUserRole();
  },
  methods: {
    getLoggedInUser() {
      this.user = this.$store.state.user;
    },
    getUserRole() {
      this.role = this.user.authorities[0].name
    }
  }
};
</script>
