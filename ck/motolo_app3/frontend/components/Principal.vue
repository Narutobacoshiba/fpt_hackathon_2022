<template>
    <div v-if="wallet">
        <div class="user-principal">
            ID: {{wallet.principal}}
        </div>
    </div>
</template>

<script setup>
import { useCanister, useWallet } from "@connect2ic/vue"
import { ref, watchEffect } from "vue";

const [wallet] = useWallet()
const [defi] = useCanister("defi")


const getConnect = async () => {
    var res = await defi.value.connect()
    console.log(res)
}

watchEffect(() => {
	if(wallet.value && defi.value) {
		getConnect()
	}else{
    }
});

</script>

<style>
.user-principal{
    color: #424242;
}
</style>