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
import ProcessNft from "./components/ProcessNft.vue"

const client = createClient({
  canisters: {
    nft,
  },
  providers: defaultProviders,
  globalProviderConfig: {
    dev: import.meta.env.DEV,
  },
})
</script>

<template>
  <Connect2ICProvider :client="client">
    <div class="App">
      <div class="auth-section">
        <ConnectButton />
      </div>
      <ConnectDialog />
      <div class="examples">
        <ProcessNft/>
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


.example {
  padding: 50px 50px;
  min-height: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  /*border: 1px solid black;*/
  /*background: #f4f4f4;*/
  border-radius: 15px;
}

</style>
