<template>
    <div v-if="wallet">
        <div class="user-principal">
            ID: {{wallet.principal}}
        </div>
        <div class="user-balance">
            yasuo: {{yasuo_balance}}
        </div>
        <div class="user-balance">
            zed: {{zed_balance}}
        </div>
    </div>
</template>

<script setup>
import { useCanister, useWallet } from "@connect2ic/vue"
import { ref, watchEffect } from "vue";
import { Principal } from '@dfinity/principal';

const [wallet] = useWallet()
const [defi] = useCanister("defi")

var yasuo_balance = ref(0)
var zed_balance = ref(0)

const getBalance = async () => {
    var res = await defi.value.connect()
    console.log(res)

    zed_balance.value = await defi.value.zedBalanceOf(Principal.fromText(wallet.value.principal))
    yasuo_balance.value = await defi.value.yasuoBalanceOf(Principal.fromText(wallet.value.principal))
    console.log(zed_balance)
    console.log(yasuo_balance)
}

watchEffect(() => {
	if(wallet.value && defi.value) {
		getBalance()
	}else{
        yasuo_balance.value = 0;
        zed_balance.value = 0;
    }
});

</script>

<style>
.user-principal{
    color: #424242;
}
</style>