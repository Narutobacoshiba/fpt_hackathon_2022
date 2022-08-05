<template>
  <div class="process-nft" >
    <template v-if="wallet">   
        <template v-if="views == 'my_nft'">
            <div class="nft-header">
                My NFT
            </div>
            <div class="nft-body">
                <div class="images-section">
                    <div v-for="(item, idx) in list_nft" :key="item+idx" @click="selectNft(item)" class="image-item" 
                    :class="item.index == selected_nft_index ? 'sl-img':'usl-img'">
                        <img :src="item.image" class="nft-image-item">
                    </div>
                </div>
                <div class="button-section">
                    <div class="button-t" @click="changeViews('transfer_nft')"> Transfer </div>
                    <div class="button-t" @click="changeViews('create_nft')"> Create </div>
                </div>
            </div>
            <div class="nft-footer">
                Owned by   {{wallet.principal}}
            </div>
        </template>
        <template v-if="views == 'create_nft'">
            <div class="create-nft-header">
                Create New Item
            </div>
            <div class="load-image-section">
                <input type="file" class="button-t" spellcheck="false" @change="uploadFile($event)">
                <div class="input-text-section">
                    NFT name <input type="text" v-model="nft_image_name" class="input-text-item">
                </div>
                <div class="input-text-section">
                    Description <input type="text" v-model="nft_image_description" class="input-text-item">
                </div>
                <div class="button-t" @click="mintImage">
                    Submit
                </div>
            </div>
        </template>
        <template v-if="views == 'transfer_nft'">
            <div class="transfer-nft-header">
                Send NFT
            </div>
            <div class="transfer-item-section">
                <img :src="selected_nft.image" class="nft-image-item">
            </div>
            <div class="transfer-owned-section">
                Owned by {{wallet.principal}}
            </div>
            <div class="input-text-section">
                    To Principal <input type="text" v-model="to_principal" class="input-text-item">
            </div>
            <div class="button-t" @click="transferNft">
                Send
            </div>
        </template>
    </template>
    <template v-else>
        <p> Connect with a wallet to access this function </p>
    </template>
  </div>
</template>

<script setup>
import { useCanister, useWallet } from "@connect2ic/vue"
import { client } from '../utilities/ipfs';
import { Principal } from '@dfinity/principal';
import { customAxios } from '../utilities/custom-axios';
import {ref, watchEffect} from "vue";

const IPFS_LINK = 'https://dweb.link/ipfs/';

const [nft] = useCanister("nft")
const [wallet] = useWallet()

var file = null
var list_nft = ref([])
var to_principal = ref("")
var views = ref("my_nft")
var nft_image_name = ref("")
var nft_image_description = ref("")
var selected_nft = ref(null)
var selected_nft_index = ref("-1")

const uploadFile = (event) => {
    file = event.target.files[0]
    console.log("upload success")
}

const changeViews = (view) => {
    console.log(view)
    if(views.value != view){
        views.value = view
    }
}

const mintImage = async () => {
    if(file == null){
        const res = await nft.value.getPrincipal()
        console.log(res.toText())
    }else{
        try{
            const cid = await client.put([file]);
            const nFile = new File(
                            [
                            JSON.stringify({
                                description: nft_image_description,
                                name: nft_image_name,
                                image: `${IPFS_LINK}${cid}/${file.name}`,
                            }),
                        ],
                        `${file.name}.json`,
                        { type: 'text/plain' }
                    )
            const metadataCID = await client.put([nFile]);
            
            const res = await nft.value.mint(Principal.fromText(wallet.value.principal), [
                { tokenUri: `${IPFS_LINK}${metadataCID}/${file.name}.json` },
            ]);
            console.log(res)

            file = null

            getListNft()
            changeViews("my_nft")
        }
        catch (error){
            console.log(error)
        }
    }
}

const transferNft = async () => {
    if(selected_nft){
        const res = await nft.value.transfer(Principal.fromText(to_principal.value), BigInt(selected_nft.value.index))
        console.log(res)
        to_principal.value = ""
        selected_nft.value = null
        getListNft()
        changeViews("my_nft")
    }
}

const getListNft = async () => {
    const res = await nft.value.getUserTokens(Principal.fromText(wallet.value.principal))
    const promise4all = Promise.all(
		res.map(function (el) {
			return customAxios(el.metadata[0]?.tokenUri);
		})
	);
	const resu = await promise4all;
	list_nft.value = res.map((el, index) => {
		return {...el, ...resu[index]}
	})    
    
}

watchEffect(() => {
		if(wallet.value && nft.value) {
			getListNft()
		}else{
            file = null
            list_nft.value = []
            selected_nft.value = null
            to_principal.value = ""
            views.value = "my_nft"
        }
});

const selectNft = (val) => {
    selected_nft.value = val
    selected_nft_index.value = val.index
}

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
    height: 40px;
    width: 100px;
    border: 1px solid black;
    cursor: pointer;
}

.images-section{
    width: 1200px;
    height: 500px;
    border: 1px solid black;
    display: flex;
    overflow: auto;
}

.image-item{
    margin-left: 20px;
}

.sl-img{
    border: 1px solid rgb(21, 21, 237);
}

.usl-img{
    border: none;
}
</style>