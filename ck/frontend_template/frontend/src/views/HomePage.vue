<template>
  <div class="home-page-body">
    <div class="splitview skewed">
      <div class="panel bottom">
        <div class="content">
          <div class="description">
            <h1>Optimizing service for customers.</h1>
            <p>More comfortable, more secure, more convenient.</p>
          </div>

          <img src="../assets/image/original-image-background.png" alt="Original" />
        </div>
      </div>

      <div class="panel top">
        <div class="content">
          <div class="description">
            <h1>The new way to plan your next trip.</h1>
            <p>Create a fully customized day by day itinerary for free</p>
          </div>

          <img src="../assets/image/background-image.png" alt="HongKong" />
        </div>
      </div>
      <div class="handle"></div>
    </div>
    <div class="plan-content">
      <div class="pc-action">
        <input class="modal-btn" type="checkbox" id="modal-btn" name="modal-btn" />
        <label for="modal-btn"> START PLANNING </label>
        <div class="modal">
          <div class="modal-wrap">
            <div class="pc-action-a2">
              <h2>Intinerary Planner</h2>
              <input
                type="text"
                v-model="plan_param.destination"
                class="aa-binput"
                placeholder="Enter destination (Eg. Da Nang City)"
              />
              <div class="aa-sitem">
                <label class="aa-stext"> Budget </label>
                <input
                  type="text"
                  v-model="plan_param.budget"
                  placeholder="5000000VND"
                  class="aa-sinput"
                />
              </div>
              <div class="aa-sitem">
                <label class="aa-stext">Start date</label>
                <input type="date" v-model="plan_param.start_date" class="aa-sinput" />
              </div>
              <div class="aa-sitem">
                <label class="aa-stext">End date</label>
                <input type="date" v-model="plan_param.end_date" class="aa-sinput" />
              </div>
              <div class="aa-sbutton">
                <button @click="planning">See your trip</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="container pc-list">
        <!-- <p id="list-title">My trip</p>
                <div class="cards">
                    <div class="card">
                        <div class="card-title">
                            <h1>Title</h1>
                            <p>Date fill in here</p>
                        </div>
                        <div class="card-content"> Content card 1
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-title">
                            <h1>Title</h1>
                            <p>Date fill in here</p>
                        </div>
                        <div class="card-content"> Content card 2</div>
                    </div>
                    <div class="card">
                        <div class="card-title">
                            <h1>Title</h1>
                            <p>Date fill in here</p>
                        </div>
                        <div class="card-content"> Content card 3</div>
                    </div>
                </div> -->
      </div>
      <div class="pc-advertisement">
        <p>Easy to use, easy to browse</p>
        <ul class="plan-steps">
          <li class="step">
            <div class="step__sec">
              <i class="fa-solid fa-globe fa-3x"></i>
            </div>
            <div class="step__sec">
              <div class="step__title">Get a personalized trip</div>
              <div class="step__desc">
                A full day by day itinerary based on your preferences
              </div>
            </div>
          </li>
          <li class="step">
            <div class="step__sec">
              <i class="fa-solid fa-calendar fa-3x"></i>
            </div>
            <div class="step__sec">
              <div class="step__title">Customize it</div>
              <div class="step__desc">
                Refine your trip. We'll find the <br />best routes and schedules
              </div>
            </div>
          </li>
          <li class="step">
            <div class="step__sec">
              <i class="fa-solid fa-rocket fa-3x"></i>
            </div>
            <div class="step__sec">
              <div class="step__title">Book it</div>
              <div class="step__desc">
                Choose from the best hotels and activities. Up to 50% off
              </div>
            </div>
          </li>
          <li class="step">
            <div class="step__sec">
              <i class="fa-solid fa-address-card fa-3x"></i>
            </div>
            <div class="step__sec">
              <div class="step__title">Manage it</div>
              <div class="step__desc">
                Everything in one place. Everyone on the same page.
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import * as jquery from "../assets/js/jquery.min.js";
import { PlanServices } from "../services/plan.services.js";
// import { useCanister, useWallet } from "@connect2ic/vue"
import { ref } from "vue";
import("../assets/css/homepage.css");

// const [nft] = useCanister("nft")
// const [wallet] = useWallet()

var plan_param = ref({
  destination: null,
  budget: null,
  start_date: null,
  end_date: null,
});

const planning = async () => {
  try {
    let res = await PlanServices.createPlan(plan_param);
    console.log("res: " + res);
  } catch (error) {
    console.log(error);
  }
};
</script>
<script>
$(document).ready(function () {
  CheckExistTrip();
   
  function CheckExistTrip() {
    $.ajax({
      url: "http://localhost:8080/trip/getByAccount/test",
      type: "get",
      contentType: "application/json",
      success: function (result, status, xhr) {
        if (result.length) {
          //    <p id="list-title">My trip</p>
          let appendELement = $(".pc-list").last();
          let list_trip = document.createElement("p");
          list_trip.setAttribute("id", "list-title");
          $(list_trip).html("My Trip (" + result.length + ")");
          let cards = document.createElement("div");
          $(cards).addClass("tour-list-parent");
          console.log(result.length)
          if (result.length <= 3) {
            for (let i = 0; i < result.length; i++) {
              let card = document.createElement("div");
              $(card).addClass("tour-child card");
              let icon = document.createElement("i");
              $(icon).addClass("fa-solid fa-trash-can fa-lg");
              let top_right = document.createElement("div");
              $(top_right).addClass("top-right");
              $(top_right).append($(icon));
              $(card).append($(top_right));
              let card_img = document.createElement("img");
              $(card_img).addClass("card-img-top");
              $(card_img).attr(
                "src",
                "https://hegka.com/storage/image-content/N8GKHx1ldeMY3uv2OPa9Ls5N9rt8U0N31rcFStIWVrRaX.webp"
              );
              $(card).append($(card_img));
              let caption = document.createElement("div");
              $(caption).addClass("caption");
              $(caption).append(
                $("<h5>").html(result[i]["numberOfDays"] + " days in Hanoi")
              );
              let start_date = document.createElement("p");
              $(start_date).addClass("date-detail");
              let stdate = new Date(result[i]["startDate"]);
              let edate = new Date(result[i]["endDate"]);

              let options = {
                weekday: "long",
                year: "numeric",
                month: "long",
                day: "numeric",
              };
              console.log(stdate.toLocaleDateString("en-US", options));
              $(start_date).html(
                stdate.toLocaleDateString("en-US", options) +
                  " to <br> " +
                  edate.toLocaleDateString("en-US", options)
              );
              $(caption).append($(start_date));
              $(card).append($(caption));
              let card_body = document.createElement("div");
              $(card_body).addClass("card-body");
              $(card_body).html(
                "<p class='card-text text-center tour-summary'>August . Popular Sights</p><div class='tour-detail'><span><b>Preferences:</b> August</span><br /><span><b>Attraction style:</b> Popular sights</span><br /><span><b>Paces:</b> Medium</span></div><a href='#' class='stretched-link'></a>"
              );
              $(card).append(card_body);
              cards.append(card);
            }
          } else {
            for (let i = 0; i < 3; i++) {
              let card = document.createElement("div");
              $(card).addClass("tour-child card");
              let icon = document.createElement("i");
              $(icon).addClass("fa-solid fa-trash-can fa-lg");
              let top_right = document.createElement("div");
              $(top_right).addClass("top-right");
              $(top_right).append($(icon));
              $(card).append($(top_right));
              let card_img = document.createElement("img");
              $(card_img).addClass("card-img-top");
              $(card_img).attr(
                "src",
                "https://hegka.com/storage/image-content/N8GKHx1ldeMY3uv2OPa9Ls5N9rt8U0N31rcFStIWVrRaX.webp"
              );
              $(card).append($(card_img));
              let caption = document.createElement("div");
              $(caption).addClass("caption");
              $(caption).append(
                $("<h5>").html(result[i]["numberOfDays"] + " days in Hanoi")
              );
              let start_date = document.createElement("p");
              $(start_date).addClass("date-detail");
              let stdate = new Date(result[i]["startDate"]);
              let edate = new Date(result[i]["endDate"]);

              let options = {
                weekday: "long",
                year: "numeric",
                month: "long",
                day: "numeric",
              };
              console.log(stdate.toLocaleDateString("en-US", options));
              $(start_date).html(
                stdate.toLocaleDateString("en-US", options) +
                  " to <br> " +
                  edate.toLocaleDateString("en-US", options)
              );
              $(caption).append($(start_date));
              $(card).append($(caption));
              let card_body = document.createElement("div");
              $(card_body).addClass("card-body");
              $(card_body).html(
                "<p class='card-text text-center tour-summary'>August . Popular Sights</p><div class='tour-detail'><span><b>Preferences:</b> August</span><br /><span><b>Attraction style:</b> Popular sights</span><br /><span><b>Paces:</b> Medium</span></div><a href='#' class='stretched-link'></a>"
              );
              $(card).append(card_body);
              cards.append(card);
            }
             $(cards).append($("<a>").html("See all my trips").attr("href","#").attr("class","full-trip-link"))
          }
          $(appendELement).append(list_trip);
          $(appendELement).append(cards);
         
        }
        
         else {

        }
         $(".top-right").on("click", function() {
        if (confirm("Do you want to delete this trip?")) {
            $(this).closest('.card').css("display", "none");
        }
    });
      },
      error: function (xhr, status, error) {
        console.log(xhr);
      },
    });
  }
});
document.addEventListener("DOMContentLoaded", function () {
  var parent = document.querySelector(".splitview"),
    topPanel = parent.querySelector(".top"),
    handle = parent.querySelector(".handle"),
    skewHack = 0,
    delta = 0;

  // If the parent has .skewed class, set the skewHack var.
  if (parent.className.indexOf("skewed") != -1) {
    skewHack = 1000;
  }

  parent.addEventListener("mousemove", function (event) {
    // Get the delta between the mouse position and center point.
    delta = (event.clientX - window.innerWidth / 2) * 0.5;

    // Move the handle.
    handle.style.left = event.clientX + delta + "px";

    // Adjust the top panel width.
    topPanel.style.width = event.clientX + skewHack + delta + "px";
  });
});
</script>

<style>
.hp-background {
  width: 100%;
  height: 400px;
  background-color: #edf0f4;
  background-image: url(https://s.inspirockcdn.com/images/home/hero-klarna.png);
}

.plan-content {
  margin-top: 3%;
  background-color: inherit;
  margin-bottom: 5%;
}

.pc-text {
  width: 21rem;
  margin-bottom: 1.5rem;
}

.pc-action {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.pc-action-a1 {
  width: 200px;
  height: 50px;
  background-color: rgb(65, 59, 177);
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

.pc-action-a1:hover {
  background-color: rgb(74, 87, 183);
}

.pc-action-a2 {
  background-color: #fafafa;
  z-index: 100;
  width: 500px;
  height: 400px;
  text-align: center;
}

.pc-action-a2 h2 {
  text-align: center;
  padding: 2%;
}

.pc-action-a2 input {
  text-align: center;
  height: 50px;
}

.pc-list {
  position: relative;
  margin-left: 18%;
  margin-right: auto;
  margin-bottom: 50px;
  width: 100%;
  display: block;
  margin-top: 1%;
}

#list-title {
  font-size: 40px;
  font-weight: bold;
  letter-spacing: 0.3px;
}

.pc-advertisement {
  position: relative;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
  width: 100%;
  display: block;
  margin-top: 1%;
}

.pc-advertisement p {
  font-size: 60px;
  font-weight: bold;
  text-align: center;
  letter-spacing: 0.3px;
}
</style>
