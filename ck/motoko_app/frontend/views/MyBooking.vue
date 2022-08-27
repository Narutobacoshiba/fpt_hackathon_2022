<template>
    <div class="list-booking">
        <div class="lb-header">
            <h1>My Booking List</h1>
            <h4>See your booking room information</h4>
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
                                    <button> CANCEL</button>
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
                                    <button>CANCEL</button>
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
    </div>
</template>

<style scoped>
html {
    scroll-behavior: smooth;
}

/* 
.list-booking {
} */

.lb-header {
    margin-left: 10%;
    margin-top: 2%;
}

.hm-text-light {
    font-weight: 400;
    font-size: 20px;
    padding: 7px;
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

.hiu-symbol {
    margin-left: 30px;
    margin-top: 15px;
    margin-right: 30px;
    margin-bottom: 15px;
    display: flex;
    font-size: 20px;
}

.hotel-h-item-b {
    margin-top: 3%;
    margin-left: 20%;
    height: 510px;
    width: 60%;
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