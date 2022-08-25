<template>
    <div class="body">
        <ul class="navbar-navx-t">
            <li class="navx-t-item" :class="route_item == 'Route' ? 'route-selected-item' : ''">
                <a class="navx-t-link" href="#" @click="route_item = 'Route'">
                    <span class="link-name">Route</span>
                    <div class="sidebar-icon">
                        <span class="material-icons" v-if="route_item == 'Route'">keyboard_arrow_down</span>
                    </div>
                </a>
            </li>
            <li class="navx-t-item" :class="route_item == 'Day by day' ? 'route-selected-item' : ''">
                <a class="navx-t-link" href="#" @click="route_item = 'Day by day'">
                    <span class="link-name">Day by day</span>   
                    <div class="sidebar-icon">
                        <span class="material-icons" v-if="route_item == 'Day by day'">keyboard_arrow_down</span>
                    </div>                  
                </a>
            </li>
            <li class="navx-t-item" :class="route_item == 'Where to stay' ? 'route-selected-item' : ''">
                <a class="navx-t-link" href="#" @click="route_item = 'Where to stay'">
                    <span class="link-name">Where to stay</span>   
                    <div class="sidebar-icon">
                        <span class="material-icons" v-if="route_item == 'Where to stay'">keyboard_arrow_down</span>
                    </div>                 
                </a>
            </li>
            <li class="navx-t-item" :class="route_item == 'Checklist' ? 'route-selected-item' : ''">
                <a class="navx-t-link" href="#" @click="route_item = 'Checklist'">
                    <span class="link-name">Checklist</span>           
                    <div class="sidebar-icon">
                        <span class="material-icons" v-if="route_item == 'Checklist'">keyboard_arrow_down</span>
                    </div>          
                </a>
            </li>
        </ul>
        <div class="trip-section">
            <div class="t-right-section t-section">
                <div v-for="date in getDates(trip_data.listDays)" :key="date">
                    <div class="tr-mon tr-item">{{date.mon}}</div>
                    <div v-for="(day,idx) in date.days" :key="day">
                        <a :href="'#t-date-'+date.dates[idx]" class="tr-day tr-item">{{day}}</a>
                    </div>
                </div>
            </div>
            <div class="t-middle-section t-section">
                <div v-for="(pois,idx) in trip_data.listDays" :key="idx+'lday'">
                    <div class="t-day-item" :id="'t-date-' + pois.date">
                        {{pois.date}}
                    </div>
                    <div v-for="(poi,idx) in pois.listPOIs" :key="poi.number+'lpoi'">
                        <div class="t-hope-item">
                            <div class="top-line"></div>
                            <span class="material-icons">local_taxi</span>
                            <div class="bottom-line"></div>
                        </div>
                        <div class="t-place-item">
                            <div class="tp-time">
                                <div class="tp-time-item">{{poi.startTime}}</div>
                                <div class="tp-time-item">{{poi.endTime}}</div>
                            </div>
                            <div class="tp-image">

                            </div>
                            <div class="tp-infor">
                                <div class="tp-i-destination">{{poi.poi.name}}</div>
                                <div class="tp-i-rate">{{poi.poi.totalRating}}</div>
                                <div class="tp-i-price">{{poi.poi.price}}</div>
                                <div class="tp-i-description">{{poi.poi.description}}</div>
                            </div>
                        </div>
                    </div>
                    <div class="separate-line"></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useCanister, useWallet } from "@connect2ic/vue"
import {ref} from "vue";

const [nft] = useCanister("nft")
const [wallet] = useWallet()

var route_item = ref("Day by day")

const convertMon = (day) => {
    switch(day) {
        case "01":
            return "Jan"
            break;
        case "02":
            return "Feb"
            break;
        case "03":
            return "Mar"
            break;
        case "04":
            return "Apr"
            break;
        case "05":
            return "May"
            break;
        case "06":
            return "Jun"
            break;
        case "07":
            return "Jul"
            break;
        case "08":
            return "Aug"
            break;
        case "09":
            return "Sep"
            break;
        case "10":
            return "Oct"
            break;
        case "11":
            return "Nov"
            break;
        case "12":
            return "Dec"
            break;
        default:
            return ""
    }
}

const getDates = (data) => {
    var dates = []
    var c_t = {mon:"",days:[],dates:[]}
    for(const i in data){
        var t = data[i].date
        var temp = t.split("-")
        if(c_t.mon == ""){
            c_t.mon = convertMon(temp[1])
            c_t.days.push(temp[2])
            c_t.dates.push(t)
        }else{
            if(c_t.mon == convertMon(temp[1])){
                c_t.days.push(temp[2])
                c_t.dates.push(t)
            }else{
                dates.push(JSON.parse(JSON.stringify(c_t)))
                c_t.mon = convertMon(temp[1])
                c_t.days = [temp[2]]
                c_t.dates = [t]
            }
        }
    }
    dates.push(JSON.parse(JSON.stringify(c_t)))
    return dates;
}

var trip_data = ref({
    "id": 0,
    "startDate": null,
    "endDate": null,
    "account": null,
    "listDays": [
        {
            "id": 0,
            "number": 1,
            "date": "2022-08-23",
            "tour": null,
            "listPOIs": [
                {
                    "id": 0,
                    "number": 1,
                    "poi": {
                        "name": "Sân vận động Mỹ Đình",
                        "description": null,
                        "totalRating": 2.66,
                        "price": 118803.0,
                        "location": null,
                        "openTime": 32400.0,
                        "closeTime": 72000.0,
                        "duration": 9000.0,
                        "poiid": 146
                    },
                    "dayOfTrip": null,
                    "startTime": 32400,
                    "endTime": 41400
                },
                {
                    "id": 0,
                    "number": 2,
                    "poi": {
                        "name": "Công viên Thủ Lệ",
                        "description": null,
                        "totalRating": 2.66,
                        "price": 113950.0,
                        "location": null,
                        "openTime": 25200.0,
                        "closeTime": 79200.0,
                        "duration": 9000.0,
                        "poiid": 138
                    },
                    "dayOfTrip": null,
                    "startTime": 41805,
                    "endTime": 50805
                },
                {
                    "id": 0,
                    "number": 3,
                    "poi": {
                        "name": "Hanoi Train Street",
                        "description": null,
                        "totalRating": 2.63,
                        "price": 133033.0,
                        "location": null,
                        "openTime": 0.0,
                        "closeTime": 86400.0,
                        "duration": 7200.0,
                        "poiid": 59
                    },
                    "dayOfTrip": null,
                    "startTime": 51164,
                    "endTime": 58364
                },
                {
                    "id": 0,
                    "number": 4,
                    "poi": {
                        "name": "Mattana 57B Phan Chu Trinh, Hà Nội",
                        "description": null,
                        "totalRating": 2.43,
                        "price": 171829.0,
                        "location": null,
                        "openTime": 28800.0,
                        "closeTime": 79200.0,
                        "duration": 9000.0,
                        "poiid": 83
                    },
                    "dayOfTrip": null,
                    "startTime": 58364,
                    "endTime": 67364
                },
                {
                    "id": 0,
                    "number": 5,
                    "poi": {
                        "name": "Salmonoid",
                        "description": null,
                        "totalRating": 3.02,
                        "price": 200000.0,
                        "location": null,
                        "openTime": 36000.0,
                        "closeTime": 50400.0,
                        "duration": 5400.0,
                        "poiid": 183
                    },
                    "dayOfTrip": null,
                    "startTime": 67562,
                    "endTime": 72962
                },
                {
                    "id": 0,
                    "number": 6,
                    "poi": {
                        "name": "Trung Tâm Thương Mại Hàng Da",
                        "description": null,
                        "totalRating": 3.19,
                        "price": 208426.0,
                        "location": null,
                        "openTime": 28800.0,
                        "closeTime": 79200.0,
                        "duration": 10800.0,
                        "poiid": 121
                    },
                    "dayOfTrip": null,
                    "startTime": 73042,
                    "endTime": 83842
                }
            ]
        },
        {
            "id": 0,
            "number": 2,
            "date": "2022-08-24",
            "tour": null,
            "listPOIs": [
                {
                    "id": 0,
                    "number": 1,
                    "poi": {
                        "name": "Pizza Belga Hang Be",
                        "description": null,
                        "totalRating": 3.01,
                        "price": 250000.0,
                        "location": null,
                        "openTime": 39600.0,
                        "closeTime": 52200.0,
                        "duration": 7200.0,
                        "poiid": 181
                    },
                    "dayOfTrip": null,
                    "startTime": 39600,
                    "endTime": 46800
                },
                {
                    "id": 0,
                    "number": 2,
                    "poi": {
                        "name": "Lầu Bát Giác",
                        "description": null,
                        "totalRating": 2.92,
                        "price": 122195.0,
                        "location": null,
                        "openTime": 32400.0,
                        "closeTime": 79200.0,
                        "duration": 5400.0,
                        "poiid": 79
                    },
                    "dayOfTrip": null,
                    "startTime": 46982,
                    "endTime": 52382
                },
                {
                    "id": 0,
                    "number": 3,
                    "poi": {
                        "name": "Coffee Club",
                        "description": null,
                        "totalRating": 3.19,
                        "price": 150000.0,
                        "location": null,
                        "openTime": 32400.0,
                        "closeTime": 79200.0,
                        "duration": 5400.0,
                        "poiid": 154
                    },
                    "dayOfTrip": null,
                    "startTime": 52382,
                    "endTime": 57782
                },
                {
                    "id": 0,
                    "number": 4,
                    "poi": {
                        "name": "HANOI 1930 Bistro",
                        "description": null,
                        "totalRating": 2.2,
                        "price": 400000.0,
                        "location": null,
                        "openTime": 28800.0,
                        "closeTime": 84600.0,
                        "duration": 10800.0,
                        "poiid": 159
                    },
                    "dayOfTrip": null,
                    "startTime": 57782,
                    "endTime": 68582
                }
            ]
        },
        {
            "id": 0,
            "number": 3,
            "date": "2022-08-25",
            "tour": null,
            "listPOIs": [
                {
                    "id": 0,
                    "number": 1,
                    "poi": {
                        "name": "Cầu Long Biên",
                        "description": null,
                        "totalRating": 2.94,
                        "price": 174920.0,
                        "location": null,
                        "openTime": 0.0,
                        "closeTime": 86400.0,
                        "duration": 9000.0,
                        "poiid": 132
                    },
                    "dayOfTrip": null,
                    "startTime": 27000,
                    "endTime": 36000
                },
                {
                    "id": 0,
                    "number": 2,
                    "poi": {
                        "name": "Vietnam's Delights",
                        "description": null,
                        "totalRating": 3.06,
                        "price": 118173.0,
                        "location": null,
                        "openTime": 36000.0,
                        "closeTime": 79200.0,
                        "duration": 9000.0,
                        "poiid": 125
                    },
                    "dayOfTrip": null,
                    "startTime": 36197,
                    "endTime": 45197
                },
                {
                    "id": 0,
                    "number": 3,
                    "poi": {
                        "name": "Hoa10Gio - Floral & Book Cafe",
                        "description": null,
                        "totalRating": 2.31,
                        "price": 273732.0,
                        "location": null,
                        "openTime": 27000.0,
                        "closeTime": 79200.0,
                        "duration": 5400.0,
                        "poiid": 68
                    },
                    "dayOfTrip": null,
                    "startTime": 45197,
                    "endTime": 50597
                },
                {
                    "id": 0,
                    "number": 4,
                    "poi": {
                        "name": "Tổ Dân Phố",
                        "description": null,
                        "totalRating": 2.85,
                        "price": 281034.0,
                        "location": null,
                        "openTime": 27000.0,
                        "closeTime": 75600.0,
                        "duration": 10800.0,
                        "poiid": 116
                    },
                    "dayOfTrip": null,
                    "startTime": 50597,
                    "endTime": 61397
                },
                {
                    "id": 0,
                    "number": 5,
                    "poi": {
                        "name": "Time Art Gallery",
                        "description": null,
                        "totalRating": 2.5,
                        "price": 135538.0,
                        "location": null,
                        "openTime": 27000.0,
                        "closeTime": 61200.0,
                        "duration": 7200.0,
                        "poiid": 115
                    },
                    "dayOfTrip": null,
                    "startTime": 61955,
                    "endTime": 69155
                }
            ]
        },
        {
            "id": 0,
            "number": 4,
            "date": "2022-08-26",
            "tour": null,
            "listPOIs": [
                {
                    "id": 0,
                    "number": 1,
                    "poi": {
                        "name": "PK Spice Indian Restaurant",
                        "description": null,
                        "totalRating": 2.78,
                        "price": 181818.0,
                        "location": null,
                        "openTime": 39600.0,
                        "closeTime": 81000.0,
                        "duration": 10800.0,
                        "poiid": 182
                    },
                    "dayOfTrip": null,
                    "startTime": 39600,
                    "endTime": 50400
                },
                {
                    "id": 0,
                    "number": 2,
                    "poi": {
                        "name": "Hai Su Restaurant",
                        "description": null,
                        "totalRating": 3.38,
                        "price": 150000.0,
                        "location": null,
                        "openTime": 0.0,
                        "closeTime": 86400.0,
                        "duration": 9000.0,
                        "poiid": 158
                    },
                    "dayOfTrip": null,
                    "startTime": 50629,
                    "endTime": 59629
                },
                {
                    "id": 0,
                    "number": 3,
                    "poi": {
                        "name": "Công viên nước Hồ Tây",
                        "description": null,
                        "totalRating": 2.75,
                        "price": 145252.0,
                        "location": null,
                        "openTime": 30600.0,
                        "closeTime": 68400.0,
                        "duration": 5400.0,
                        "poiid": 137
                    },
                    "dayOfTrip": null,
                    "startTime": 60089,
                    "endTime": 65489
                },
                {
                    "id": 0,
                    "number": 4,
                    "poi": {
                        "name": "Chùa Kim Liên",
                        "description": null,
                        "totalRating": 3.08,
                        "price": 245751.0,
                        "location": null,
                        "openTime": 25200.0,
                        "closeTime": 61200.0,
                        "duration": 9000.0,
                        "poiid": 19
                    },
                    "dayOfTrip": null,
                    "startTime": 65489,
                    "endTime": 74489
                }
            ]
        },
        {
            "id": 0,
            "number": 5,
            "date": "2022-08-27",
            "tour": null,
            "listPOIs": [
                {
                    "id": 0,
                    "number": 1,
                    "poi": {
                        "name": "Sóng Sánh Café",
                        "description": null,
                        "totalRating": 3.05,
                        "price": 277462.0,
                        "location": null,
                        "openTime": 36000.0,
                        "closeTime": 79200.0,
                        "duration": 7200.0,
                        "poiid": 103
                    },
                    "dayOfTrip": null,
                    "startTime": 36000,
                    "endTime": 43200
                },
                {
                    "id": 0,
                    "number": 2,
                    "poi": {
                        "name": "Galeria Cafe Hanoi (Quán số 2)",
                        "description": null,
                        "totalRating": 2.92,
                        "price": 130734.0,
                        "location": null,
                        "openTime": 25200.0,
                        "closeTime": 79200.0,
                        "duration": 9000.0,
                        "poiid": 45
                    },
                    "dayOfTrip": null,
                    "startTime": 43477,
                    "endTime": 52477
                },
                {
                    "id": 0,
                    "number": 3,
                    "poi": {
                        "name": "Nét Huế Restaurant",
                        "description": null,
                        "totalRating": 2.76,
                        "price": 250000.0,
                        "location": null,
                        "openTime": 25200.0,
                        "closeTime": 79200.0,
                        "duration": 7200.0,
                        "poiid": 188
                    },
                    "dayOfTrip": null,
                    "startTime": 52477,
                    "endTime": 59677
                },
                {
                    "id": 0,
                    "number": 4,
                    "poi": {
                        "name": "Văn Miếu Quốc Tử Giám",
                        "description": null,
                        "totalRating": 4.16,
                        "price": 246008.0,
                        "location": null,
                        "openTime": 28800.0,
                        "closeTime": 64800.0,
                        "duration": 10800.0,
                        "poiid": 124
                    },
                    "dayOfTrip": null,
                    "startTime": 59789,
                    "endTime": 70589
                }
            ]
        }
    ]
})
</script>

<style>
html {
  scroll-behavior: smooth;
}

.body {
    height: 100%;
    width: 100%;
    margin-top: 60px;
}

ul {
  padding-left: 0rem;
  list-style-type: none;
  margin-top: 0;
}

.navbar-navx-t{
    position: fixed;
    top: 60px;
    width: 100%;
    text-align: center;
    box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;;
    background-color: white;
}

.navx-t-item{
  display: inline-block;
  height: 43px;
  margin: auto;
  padding-left: 0.8rem;
  margin-top: 0.2rem;
}
.navx-t-item:hover{
  background-color: #e5e6e7;
}

.navx-t-item .navx-t-link{
  height: 100%;
  width: 100%;
  color: rgb(91, 91, 91);
  display: flex;
  align-items: center;
  text-decoration: none;
  white-space: nowrap;
  text-overflow: clip;
  overflow: hidden;
}

.navx-t-item 
.navx-t-link .sidebar-icon{
  margin-left: 0.05rem;
  margin-right: 0.2rem;
  margin-top: 0.6rem;
  text-align: center;
  width: 1.6rem;
}

.route-selected-item{
  border-bottom: 2px solid black;
}

.route-selected-item .navx-t-link{
  color: black;
}

/* trip section */
.trip-section{
    margin-top: 60px;
    width: 100%;
}

.t-right-section{
    width: 80px;
    left: calc(50% - 430px);
    overflow-y: auto;
    position: fixed;
}

.t-right-section .tr-item{
    color: #0E0E0F;
    font-weight: 500;
    text-align: center;
    padding: 12px 0;
    display: block;
    text-decoration: none;
}

.t-right-section .tr-day{
    cursor: pointer;
}

.t-right-section .tr-day:hover{
    text-decoration: underline solid black 2px;
}

.t-middle-section{
    padding-top: 30px;
    width: 700px;
    margin: auto;
}

.t-day-item{
    height: 36px;
    line-height: 36px;
    text-align: center;
    display: inline-block;
    padding: 0 25px;
    background: #f0F1F1;
    border-radius: 20px;
    font-weight: 700;
    background-color: #f0f1f1;
}

.t-place-item{
    width: 600px;
    height: 150px;
    box-shadow: 0 2px 9px rgba(0,0,0,.15);
    border-radius: 16px;
    display: flex;
}

.t-hope-item{
    padding-left: 34px;
}

.bottom-line{
    bottom: 0;
    width: 0;
    height: 30px;
    border-right: 2px solid #f0F1F1 !important;
    margin-inline-start: 11px;
}

.top-line{
    top: 0;
    width: 0;
    height: 30px;
    border-right: 2px solid #f0F1F1 !important;
    margin-inline-start: 11px;
}

.separate-line{
    top: 0;
    width: 0;
    height: 30px;
    border-right: 2px solid #f0F1F1 !important;
    margin-inline-start: 45px;
}
</style>
