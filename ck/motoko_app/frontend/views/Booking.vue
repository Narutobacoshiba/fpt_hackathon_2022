<template>
    <div>
        <div class="b-background">
            <img src="../assets/image/background_booking.png" />
            <div class="b-background-content">
                <h1>Find your next stay</h1>
                <p>Search low prices on hotels, homes and much more...</p>
            </div>
        </div>
        <div class="b-app-navbar">
            <ul class="b-navbar">
                <li class="b-nav-item">
                    <!-- <label for="location-search">Name</label> -->
                    <input class="search-destination-input" type="search" placeholder="Location or hotel name"
                        id="location-search" />
                </li>
                <li class="b-nav-item">
                    <input class="date-input" type="date" /> - <input class="date-input" type="date" />
                </li>
                <li class="b-nav-item">
                    <button @click="() => TogglePopup('buttonTrigger')" class="b-nav-item-button-1">{{ adults }} adults
                        - {{
                                children
                        }} children - {{ rooms }} rooms</button>
                </li>
                <li class="b-nav-item">
                    <button class="b-nav-item-button-2">Find</button>
                </li>
                <!-- <li class="b-nav-item-button">
                <ConnectButton />
            </li> -->
            </ul>
            <div class="popup" v-if="popupTriggers.buttonTrigger" :TogglePopup="() => TogglePopup('buttonTrigger')">
                Say hello to my friend Golde
                <div class="popup-inner">
                    <button class="popup-close" @click="() => TogglePopup('buttonTrigger')">Close</button>
                </div>
            </div>
        </div>
        <div class="book-image">
            <div id="main-image">
                <img src="https://khachsantaythi.com.vn/wp-content/uploads/2019/05/DSCF4744-1024x683.jpg" />
            </div>
            <div id="sub-image">
                <img src="https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg" />
                <img src="https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg" />
                <img src="https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg" />
            </div>
        </div>
        <div class="hotel-main-body">
            <div class="hotel-h-item">
                <div class="hotel-h-item-up">
                    <div class="hotel-item-up-hl">
                        <div class="hiu-header">Resort Novotel</div>
                        <div class="hiu-rating">
                            <div class="hiu-star">
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star"></span>
                            </div>
                            <div class="hiu-score">
                                4.1
                            </div>
                        </div>
                        <div class="hm-text-light">
                            90. 19 Alley of Ly Thuong Kiet street, Phan Chu Trinh ward. Hoan Kiem district, Hanoi city
                        </div>
                    </div>
                    <div class="hotel-item-up-hr">
                        <div class="hm-text-light">
                            Price range from
                        </div>
                        <div class="hm-text-light">
                            <span style="font-size: 30px;">1.699.200 VND</span>/night
                        </div>
                        <div class="hm-button">
                            <button> BOOK A ROOM</button>
                        </div>
                    </div>
                </div>
                <div class="hotel-h-item-down">
                    <div class="hm-text-bold">
                        Hotel Amenities
                    </div>
                    <div class="hm-row">
                        <div class="hiu-symbol-1">
                            <span><i class="fa-solid fa-wifi"></i> - Wifi</span>
                        </div>
                        <div class="hiu-symbol">
                            <span><i class="fa-solid fa-house"></i> - Family rooms</span>
                        </div>
                        <div class="hiu-symbol">
                            <span><i class="fa-solid fa-p"></i> - Free Parking</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hotel-h-item-b">
                <div class="hotel-h-item-room">
                    <div class="hotel-item-room-name">
                        Delux Room
                    </div>
                    <div class="hotel-item-room-h">
                        <div class="hotel-item-room-hl">
                            <img width="300" height="200"
                                src="https://khachsantaythi.com.vn/wp-content/uploads/2019/05/DSCF4744-1024x683.jpg" />
                            <div class="hiu-symbol">
                                <span><i class="fa-solid fa-house"></i> - 40m2</span>
                            </div>
                            <div class="hiu-symbol">
                                <span><i class="fa-solid fa-bed"></i> - 2 singles bed</span>
                            </div>
                            <div class="hiu-symbol">
                                <span><i class="fa-solid fa-wifi"></i> - Wifi</span>
                            </div>
                            <div class="hiu-symbol">
                                <span><i class="fa-solid fa-circle-plus"></i> View more</span>
                            </div>
                        </div>
                        <div class="hotel-item-room-hr">
                            <div class="hotel-item-room-card-up">
                                <div class="hirc-u-header">Benefits</div>
                                <div class="hiu-symbol">
                                    <span><i class="fa-solid fa-circle-check"></i> Breakfast included</span>
                                </div>
                            </div>
                            <div class="hotel-item-room-card-dowm">
                                <div class="hirc-d-item">
                                    <div class="hm-text-light">
                                        <span style="font-size: 30px;">1.899.000 VND</span>/night
                                    </div>
                                    <div class="hm-button-t">
                                        <button> BOOK NOW</button>
                                    </div>
                                </div>
                                <div class="hirc-d-text">
                                    The above prices include taxes and fees
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hotel-h-item-b">
                <div class="hotel-h-item-room">
                    <div class="hotel-item-room-name">
                        Delux Room
                    </div>
                    <div class="hotel-item-room-hl">
                        <img width="300" height="200"
                            src="https://khachsantaythi.com.vn/wp-content/uploads/2019/05/DSCF4744-1024x683.jpg" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from "@vue/reactivity"

let adults = 4
let children = 3
let rooms = 100

const popupTriggers = ref({
    buttonTrigger: false,
})

const TogglePopup = (trigger) => {
    popupTriggers.value[trigger] = !popupTriggers.value[trigger]

}
</script>


<style scoped>
/* NavBar css */
.b-app-navbar {
    height: 80px;
    width: 72%;
    top: 0;
    justify-content: center;
    text-align: center;
    margin: auto;
}

.b-background {
    width: 100%;
    height: 320px;
}

.b-background img {
    width: 100%;
    height: 320px;
}

.b-background .b-background-content {
    display: block;
    margin-top: -15%;
    z-index: 10;
    color: white;
    padding-left: 8%;
}

.b-background .b-background-content h1 {
    font-size: 70px;
    margin-top: 40px;
    margin-bottom: 0;
}

.b-background .b-background-content p {
    font-size: 30px;
    margin: 2px;
}

.b-navbar {
    display: flex;
    position: relative;
    z-index: 100;
    justify-content: center;
    background-color: rgb(254, 187, 2);
    border: 1px solid rgb(254, 187, 2);
    border-radius: 3px;
    top: -30px;
    height: 60px;
}

.b-nav-item {
    margin: auto;
}

.b-nav-item-button-1 {
    /* flex-basis: 40%; */
    width: 320px;
    height: 50px;
    padding: 0.5rem 0.5rem 0.5rem 0.5rem;
    font-size: 20px;
    background-color: white;
    border-radius: 3px;
    border: 1px solid white;
}

.b-nav-item-button-2 {
    width: 100px;
    height: 50px;
    padding: 0.5rem 0.5rem 0.5rem 0.5rem;
    font-size: 20px;
    background-color: aquamarine;
    border-radius: 3px;
    border: 1px solid aquamarine;
}

.b-nav-item-button-2:hover {
    cursor: pointer;
    background-color: aqua;
    widows: 98px;
    border: 1px solid aqua;
}

.b-nav-item-button-1:hover {
    cursor: pointer;
    width: 318px;
}

.b-nav-item .b-nav-link {
    font-size: 1rem;
    font-weight: 600;
    line-height: 1.5;
    color: #525c68;
    text-decoration: none;
}

.b-nav-item .search-destination-input {
    height: 50px;
    width: 500px;
    padding-left: 35px;
    font-size: 20px;
    border: 0;
    border-radius: 3px;
}

.b-nav-item .date-input {
    height: 50px;
    padding-left: 35px;
    font-size: 20px;
    border: 0;
    border-radius: 3px;
}

.popup {
    display: flex;
    position: fixed;
    z-index: 300;
    top: 48%;
    left: 50%;
}

.popup .popup-inner {
    background-color: #fff;
    background-color: aqua;
}

.book-image {
    height: 685px;
    width: 72%;
    top: 0;
    justify-content: center;
    text-align: center;
    margin: auto;
    display: flex;
    justify-content: space-between;
}

.book-image #main-image {
    flex-basis: 75%;
    height: 100%;
}

.book-image #sub-image {
    flex-basis: 24%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    flex-direction: column;
}

.book-image #main-image img {
    width: 100%;
}

.book-image #sub-image img {
    width: 100%;
}

.hotel-main-body {
    margin-top: 40px;
    height: 80px;
    width: 72%;
    margin-left: 14%;
    justify-content: center;
}

.hotel-h-item {
    height: 330px;
    width: 100%;
    box-shadow: 0 5px 12px rgba(0, 0, 0, .15);
    margin-bottom: 70px;
}

.hotel-h-item-up {
    display: flex;
    padding: 1rem 2rem 2rem 3rem;
    border-bottom: 1px solid rgba(0, 0, 0, .15);
}

.hotel-item-up-hl {
    width: 70%;
}

.hiu-header {
    font-weight: 700;
    font-size: 35px;
}

.hiu-rating {
    display: flex;
    margin-top: 15px;
    margin-bottom: 10px;
    font-size: 20px;
}

.checked {
    color: orange;
}

.hiu-score {
    font-weight: 400;
    margin-left: 20px;
    color: #8b8c8f;
}

.hm-text-light {
    font-weight: 400;
    font-size: 20px;
    padding: 7px;
}

.hm-button {
    left: 50%;
    margin-top: 15px;
}

.hm-button button {
    width: 300px;
    height: 60px;
    font-size: 22px;
    border-radius: 30px;
    border-color: rgb(77, 69, 173);
    color: #e4e9ee;
    background-color: rgb(77, 69, 173);
}

.hm-button button:hover {
    cursor: pointer;
}

.hm-button-t {
    left: 50%;
    margin-top: 15px;
}

.hm-button-t button {
    width: 240px;
    height: 50px;
    font-size: 22px;
    border-radius: 10px;
    border-color: rgb(77, 69, 173);
    color: #e4e9ee;
    background-color: rgb(77, 69, 173);
}

.hm-button-t button:hover {
    cursor: pointer;
}

.hotel-h-item-down {
    padding: 1rem 2rem 2rem 3rem;
    width: 100%;
}

.hm-text-bold {
    font-weight: 600;
    font-size: 25px;
    display: block;
    width: 100%;
}

.hm-row {
    display: flex;
}

.hiu-symbol-1 {
    margin-top: 15px;
    margin-right: 30px;
    margin-bottom: 15px;
    display: flex;
    font-size: 20px;
}

.hiu-symbol {
    margin-left: 30px;
    margin-top: 15px;
    margin-right: 30px;
    margin-bottom: 15px;
    display: flex;
    font-size: 20px;
}

.hotel-h-item-b {
    height: 480px;
    width: 100%;
    box-shadow: 0 5px 12px rgba(0, 0, 0, .15);
    margin-bottom: 70px;
    padding-bottom: 40px;
}

.hotel-h-item-room {
    margin-top: 70px;
    padding-top: 7px;
    height: 300px;
    padding-left: 5%;
    padding-right: 5%;
}

.hotel-item-room-name {
    margin-top: 30px;
    margin-bottom: 20px;
    font-weight: 700;
    font-size: 25px;
}

.hotel-item-room-h {
    display: flex;
}

.hotel-item-room-hl {
    width: 30%;
}

.hotel-item-room-hr {
    width: 70%;
    border: 1px solid rgba(0, 0, 0, .15);
    border-radius: 8px;
}

.hotel-item-room-card-up {
    border-bottom: 1px solid rgba(0, 0, 0, .15);
    height: 160px;
    padding-top: 10px;
    padding-left: 20px;
}

.hirc-u-header {
    font-weight: 600;
    font-size: 20px;
}

.hotel-item-room-card-dowm {
    padding-top: 20px;
    padding-left: 36%;
}

.hirc-d-item {
    display: flex;
    justify-content: space-between;
    padding-right: 20px;
    align-items: center;
}

.hirc-d-text {
    margin-top: 40px;
    color: rgb(66, 66, 66);
    padding-left: 7px;
}
</style>