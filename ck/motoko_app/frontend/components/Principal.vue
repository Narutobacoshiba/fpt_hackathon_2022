<template>
    <div v-if="wallet">
        <div class="user-principal">
            ID: {{wallet.principal}}
        </div>
        <div class="user-balance">
            Balance: 0
        </div>
    </div>
</template>

<script setup>
import { useWallet } from "@connect2ic/vue"

const [wallet] = useWallet()
</script>

<style>
.user-principal{
    color: #424242;
}
</style>