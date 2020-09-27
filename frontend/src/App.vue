<template>
  <div>
    <!-- <h>Shipping Gateway</h> -->
    <b-navbar  
    type="dark" variant="dark" class="nav-background">
    <b-img src="@/assets/shipping.jpg">
    </b-img>
    <b-img src="@/assets/shipping.jpg">
    </b-img>
    <b-img src="@/assets/shipping.jpg">
    </b-img>
    <b-img src="@/assets/shipping.jpg">
    </b-img>
  </b-navbar>

  <p></p>
  <p></p>
  <b-content>
 <router-view></router-view>
 </b-content>
</div>
</template>

<script>
export default {
    name:'app',
    components:{}
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
