<script setup>
/*
 * Connect2ic provides essential utilities for IC app development
 */
import { createClient } from "@connect2ic/core"
import { defaultProviders } from "@connect2ic/core/providers"
import { ConnectButton, ConnectDialog, Connect2ICProvider } from "@connect2ic/vue"
import "@connect2ic/core/style.css"
/*
 * Import canister definitions like this:
 */
import * as nft from "../.dfx/local/canisters/nft"
/*
 * Some examples to get you started
 */
import HomePage from "./views/HomePage.vue"

const client = createClient({
  canisters: {
    nft,
  },
  providers: defaultProviders,
  globalProviderConfig: {
    dev: import.meta.env.DEV,
  },
})

const routing = (url) => {

}

</script>

<template>
  <Connect2ICProvider :client="client">
    <div class="App">
      <div class="app-navbar">
        <ul class="navbar-navx">
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
      <ConnectDialog />
      <div class="app-header">
      </div>
      <div class="app-view">
        <HomePage />
      </div>
      <div class="app-footer">
      </div>
    </div>
  </Connect2ICProvider>
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
.app-navbar{
  height: 60px;
  width: 100%;
}

.navbar-navx{
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: flex-end;
  background-color: white;
}

.navx-item{
  height: 100%;
  width: 100px;
  padding: 1rem 1rem 1rem 1rem;
}

.navx-item-button{
  padding: 0.5rem 0.5rem 0.5rem 0.5rem;
}

.navx-item .navx-link{
  font-size: 1rem;
  font-weight: 600;
  line-height: 1.5;
  color: #525c68;
  text-decoration: none;
}

</style>
