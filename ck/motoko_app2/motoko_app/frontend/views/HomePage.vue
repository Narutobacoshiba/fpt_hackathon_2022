<template>
    <div class="home-page-body">
        <div class="hp-background"></div>
        <div class="plan-content">
            <div class="pc-text">
                <div class="pc-text-b">The new way to plan your next trip</div>
                <div class="pc-text-s">Create a fully customized day by day itinerary for free</div>
            </div>
            <div class="pc-action">
                <div class="pc-action-a1" @click="planning">
                    START PLANNING
                </div>
                <div class="pc-action-a2">
                    <h4>Planner</h4>
                    <input type="text" v-model="plan_param.destination" class="aa-binput" placeholder="Enter destination">
                    <div class="aa-sitem">
                        <div class="aa-stext">Budget</div>
                        <input type="text" v-model="plan_param.budget" placeholder="5000000VND" class="aa-sinput">
                    </div>
                    <div class="aa-sitem">
                        <div class="aa-stext">Start date</div>
                        <input type="date" v-model="plan_param.start_date" class="aa-sinput">
                    </div>
                    <div class="aa-sitem">
                        <div class="aa-stext">End date</div>
                        <input type="date" v-model="plan_param.end_date" class="aa-sinput">
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import {PlanServices} from "../services/plan.services.js"
import { useCanister, useWallet } from "@connect2ic/vue"
import {ref} from "vue";

const [nft] = useCanister("nft")
const [wallet] = useWallet()

var plan_param = ref({
                destination: null,
                budget: null,
                start_date: null,
                end_date: null
            })

const planning = async () => {
    if(wallet.value){
        try{
            let res = await PlanServices.createPlan(plan_param)
            console.log(res)
        }catch(error){
            console.log(error)
        }
    }else{
        console.log("you are not connected")
    }
}
</script>

<style>

.hp-background{
    width: 100%;
    height: 400px;
    background-color: #edf0f4;
}

.plan-content{
    position: absolute;
    z-index: 2;
    width: 50%;
    margin-left: 25%;
    top: 110px;
    background-color: inherit;
}

.pc-text{
    width: 21rem;
    margin-bottom: 1.5rem;
}

.pc-text .pc-text-b{
    font-size: 3rem;
    font-weight: 700;
    line-height: 1.5;
    color: #3b4754;
}

.pc-text .pc-text-s{
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.1;
    color: #96a6b7;
}

.pc-action{
    width: 500px;
    display: flex;
    justify-content: space-between;
}

.pc-action-a1{
    width: 170px;
    height: 36px;
    background-color: black;
    border-radius: 25px;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 12px;
    font-weight: 700;
    line-height: 1;
    cursor: pointer;
}

.pc-action-a1:hover{
    background-color: rgb(42, 41, 41);
}

.pc-action-a2{
    width: 300px;
    border: 1px solid black;
    padding-top: 25px;
    padding-left: 8px;
    padding-right: 15px;
    padding-bottom: 40px;
    background-color: white;
}

.pc-action-a2 h4{
    text-align: center;
}

.aa-binput{
    width: 290px;
    height: 34px;
    border-radius: 4px;
    margin-bottom: 7px;
    padding-left: 5px;
    font-size: 15px;
    font-weight: 400;
}

.aa-sitem{
    display: flex;
    justify-content: space-between;
    margin-bottom: 7px;
}

.aa-sitem .aa-sinput{
    width: 200px;
    height: 34px;
    border-radius: 4px;
    font-size: 14px;
    font-weight: 400;
    padding-left: 5px;
}

.aa-sitem .aa-stext{
    font-size: 15px;
    font-weight: 500;
    line-height: 1.2;
    color: #3e3e3e;
    padding-top: 6px;
}

</style>
