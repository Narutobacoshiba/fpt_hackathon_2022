<template>
  <div class="process-image" >
    <template v-if="wallet">
        <div class="button-section">
            <div class="button-t"> Load Image </div>
            <div class="button-t"> Mint </div>
        </div>
        <div class="images-section">

        </div>
    </template>
    <template v-else>
        <p> Connect with a wallet to access this function </p>
    </template>
  </div>
</template>

<script setup>
import { useCanister, useWallet } from "@connect2ic/vue"

const [nft] = useCanister("nft")

const [wallet] = useWallet()

</script>

<style>
.process-image{
    height: 600px;
    width: 700px;
}

.button-section{
    display: flex;
    justify-content: space-between;
}

.button-t{
    height: 100px;
    width: 50px;
    border: 1px solid black;
}

.images-section{
    width: 700px;
    height: 400px;
    border: 1px solid black;
}

</style>