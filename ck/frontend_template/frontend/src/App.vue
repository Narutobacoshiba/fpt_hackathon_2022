<script setup>
/*
 * Connect2ic provides essential utilities for IC app development
 */
// import { createClient } from "@connect2ic/core"
// import { defaultProviders } from "@connect2ic/core/providers"
// import { ConnectButton, ConnectDialog, Connect2ICProvider } from "@connect2ic/vue"
// import "@connect2ic/core/style.css"
/*
 * Import canister definitions like this:
 */
// import * as nft from "../.dfx/local/canisters/nft"
/*
 * Some examples to get you started
 */
import HomePage from "./views/HomePage.vue"

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import { ref } from "vue";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

var routing = ref("home")

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)


import Booking from "./views/Booking.vue"
import RatingPage from "./views/RatingPage.vue"
import SwapPage from "./views/SwapPage.vue"



</script>

<template>
  <div class="App">
    <div class="app-navbar">
      <ul class="navbar-navx">
        <li>
          
        </li>
        <li class="navx-item">
          <a class="navx-link" @click="routing('/')" href="#">
            My trips
          </a>
        </li>
        <li class="navx-item">
          <a class="navx-link" @click="routing('/')" href="#">
            FAQ
          </a>
        </li>
        <li class="navx-item-button">
          <ConnectButton />
        </li>
      </ul>
    </div>
    <!-- <button @click="routing = 'rating'">click</button> -->
    <ConnectDialog />
    <div class="app-header">
    </div>
    <div class="app-view">


      <!-- <Rating v-if="routing == 'rating'"/> -->
      

      <!-- <HomePage v-if="routing == 'home'"/>
      <Rating v-if="routing == 'rating'"/> -->
      <!-- <Booking /> -->
      <!-- <RatingPage /> -->
      <RatingPage />


    </div>
    
    <div class="app-footer">
    </div>
  </div>
</template>

<style>
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen",
    "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue",
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #424242;
}


ul {
  padding-left: 0rem;
  list-style-type: none;
  margin-top: 0;
}

/* NavBar css */
.app-navbar {
  height: 60px;
  width: 100%;
  position: sticky;
  top: 0;

  z-index: 1000;
}

.app-view {
  z-index: 1;
}

.navbar-navx {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: flex-end;
  background-color: white;

}

.navx-item {
  height: 100%;
  width: 100px;
  padding: 1rem 1rem 1rem 1rem;
}

.navx-item-button {
  padding: 0.5rem 0.5rem 0.5rem 0.5rem;
}

.navx-item .navx-link {
  font-size: 1rem;
  font-weight: 600;
  line-height: 1.5;
  color: #525c68;
  text-decoration: none;
}
</style>
