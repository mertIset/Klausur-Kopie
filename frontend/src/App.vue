<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div id="nav">
    <RouterLink to="/">About Chuck</RouterLink> |
    <RouterLink to="/admin">Admin Console</RouterLink>
  </div>
  <RouterView />
</template>

<style scoped>
html,
body {
  background-color: #f7f7f7;
  margin: 0;
  padding: 0;
  height: 100%;
}
#nav {
  padding: 30px;
  text-align: center;
}
#nav a {
  font-weight: bold;
  font-size: x-large;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
