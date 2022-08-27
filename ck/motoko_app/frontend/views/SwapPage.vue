<template>
    <div>
        <div class="swap-body">
            <div class="swap-background"></div>
            <div class="swap-card">
                <div class="sc-title">
                    <h4 style="margin-top: 0; margin-bottom: 0; font-size: 25px;"> Swap </h4>
                    <button @click="() => TogglePopup('buttonTrigger')" class="b-nav-item-button-1">
                        <i class="fa-solid fa-gear"></i>
                    </button>
                </div>
                <div class="sc-swap-content">
                    <div class="sc-input">
                        <div class="sci-hl">
                            <div class="sci-hl-input">
                                <input placeholder=".0" />
                            </div>
                            <div class="sci-hl-info">
                                <h4 style="margin-top: 0; margin-bottom: 0; font-size: 25px; margin-top: 3px; margin-right: 5px;">
                                TOKEN 1</h4>
                                <p style="margin-top: 0; margin-bottom: 0; font-size: 15px; margin-top: 10px;">
                                    balance: {{ 0 }}</p>
                            </div>
                        </div>
                        <div class="sci-hr"></div>
                    </div>
                    <div class="sc-output">
                        <div class="sci-hl">
                            <div class="sci-hl-input">
                                <input placeholder=".0" />
                            </div>
                            <div class="sci-hl-info">
                                <h4 style="margin-top: 0; margin-bottom: 0; font-size: 25px; margin-top: 3px; margin-right: 5px;">
                                TOKEN 2</h4>
                                <p style="margin-top: 0; margin-bottom: 0; font-size: 15px; margin-top: 10px;">
                                    balance: {{ 0 }}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sc-button-swap">
                    <button>Swap</button>
                </div>
            </div>
            <div class="list-token">
                <h4>Hello Beautiful Lady!</h4>

            </div>
        </div>
    </div>
</template>

<script setup>

import { ref } from "vue"

const popupTriggers = ref({
    buttonTrigger: false,
})

const TogglePopup = (trigger) => {
    popupTriggers.value[trigger] = !popupTriggers.value[trigger]

}

</script>


<style scoped>
.swap-background {
    width: 100%;
    height: 841px;
    background: -moz-linear-gradient(top, rgb(77, 69, 173) 0%, rgb(141, 138, 178) 100%);
    background: -webkit-linear-gradient(top, rgb(77, 69, 173) 0%, rgb(141, 138, 178) 100%);
    background: -o-linear-gradient(top, rgb(77, 69, 173) 0%, rgb(141, 138, 178) 100%);
    background: linear-gradient(top, rgb(77, 69, 173)f 0%, rgb(141, 138, 178) 100%);
}

.swap-card {
    display: block;
    margin-top: -35%;
    z-index: 10;
    width: 40%;
    background-color: rgb(241, 236, 236);
    box-shadow: 0.2px 2px 129px black;
    margin-left: 30%;
    border-radius: 5px;
    height: 400px;
}

.sc-title {
    display: flex;
    padding: 10px 15PX;
    margin: auto;
}

.sc-title button {
    margin-left: 88%;
    font-size: 20px;
    border: 0;
    background-color: rgb(241, 236, 236);
}

.sc-title button:hover {
    cursor: pointer;
    font-size: 22px;
}

.sc-swap-content {
    margin: 30px;
}

.sc-input {
    width: 80%;
    background-color: rgb(190, 233, 233);
    display: block;
    height: 80px;
    margin-left: 10%;
    margin-bottom: 25px;
    border-radius: 5px;
}

.sci-hl {
    width: 90%;
    display: flex;
    height: 100%;
}

.sci-hl {
    width: 100%;
    display: flex-end;
    height: 100%;
}

.sci-hl-input {
    margin: 3%;
    height: 75%;
    width: 90%;
    font-size: 30px;
}

.sci-hl-input input {
    border-radius: 5px;
    border: 0;
    font-size: 30px;
}

.sci-hl-info {
    width: 25%;
    margin: 1px;
}

.sc-output {
    margin-top: 25px;
    width: 80%;
    background-color: rgb(190, 233, 233);
    display: block;
    height: 80px;
    margin-left: 10%;
}

.list-token {
    display: none;
    margin-top: -21%;
    z-index: 10;
    width: 20%;
    background-color: rgb(247, 247, 247);
    box-shadow: 0.2px 2px 129px black;
    margin-left: 75%;
    border-radius: 5px;
    height: 400px;
}

.sc-button-swap {
    text-align: center;
    align-items: center;
}

.sc-button-swap button {
    width: 240px;
    height: 50px;
    font-size: 22px;
    border-radius: 10px;
    border-color: rgb(77, 69, 173);
    color: #e4e9ee;
    background-color: rgb(77, 69, 173);
}
</style>