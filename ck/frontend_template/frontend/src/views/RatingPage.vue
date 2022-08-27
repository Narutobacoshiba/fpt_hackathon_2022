<script setup>
// import { useCanister, useWallet } from "@connect2ic/vue"
import { ref } from "vue";
import("../assets/css/ratingpage.css");
 import axios from "axios";
// const [nft] = useCanister("nft")
// const [wallet] = useWallet()
</script>
<template>
  <div class='container'>
        <div class=" wrap-body row">

            <div class="col-md-12 ">
                <span class="h4 title">{{posts.name}}</span>
            </div>


        </div>
        <div class="wrap-body row">
            <div class="col-md-8">



                <img v-if="posts.thumbnail==null" class="img-thumb" src="https://s.inspirockcdn.com/ds10/photos/Vietnam/3/lake-of-the-restored-sword-hoan-kiem-lake-1920386144.jpg">
                 <img v-else class="img-thumb" :src=posts.thumbnail>

            </div>
            <div class="col-md-4">
                <h4><b>Recommended Duration</b></h4>
                <h5 class="description">{{secondsToHms(posts.duration)}}</h5>
                <br>

                <h4><b>Hours</b></h4>
                <div class="grid-container">
                    <table class="activate-time">
                        <tr>
                            <td>Sunday</td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Monday</td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Tuesday </td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Wednesday</td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Thursday</td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Friday</td>
                            <td>8am - 5pm</td>
                        </tr>
                        <tr>
                            <td>Saturday</td>
                            <td>8am - 5pm</td>
                        </tr>

                    </table>
                </div>
                <br>
                <h4><b>Address</b></h4>
                <p class="description">{{concatAddress(posts.location)[0]}}<br>{{concatAddress(posts.location)[1]}}<br>{{concatAddress(posts.location)[2]}}<br>{{concatAddress(posts.location)[3]}}<br>{{concatAddress(posts.location)[4]}}</p>

            </div>

        </div>
        <div class="wrap-body row">
            <div class="col-md-8">
                <p class="description">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen
                    book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and
                    more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
            </div>
        </div>

        <div class="wrap-body row">



            <div class="col-md-4">
                <div>
                    <h5 class="title">Rate this attraction: </h5><span></span>
                    <br>
                    <div class="rate">
                        <input type="radio" id="star5" name="rate" value="5" />
                        <label for="star5" title="text">5 stars</label>
                        <input type="radio" id="star4" name="rate" value="4" />
                        <label for="star4" title="text">4 stars</label>
                        <input type="radio" id="star3" name="rate" value="3" />
                        <label for="star3" title="text">3 stars</label>
                        <input type="radio" id="star2" name="rate" value="2" />
                        <label for="star2" title="text">2 stars</label>
                        <input type="radio" id="star1" name="rate" value="1" />
                        <label for="star1" title="text">1 star</label>
                    </div>
                </div>


            </div>

        </div>
        <div class="wrap-body row">
            <div class="margin-f-none col-md-12">
                <span class="h4 title">Lake of the Restored Sword (Hoan Kiem Lake) reviews</span>
                <br>

            </div>
        </div>
        <div class="wrap-body row">
            <div class="col-8">
                <div class="static-rate">
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                </div>
                <div>
                    <span class="review"> <span>By</span>
                    <span class="author"> Thủy Phạm</span>
                    </span>
                    <br>


                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
            </div>
        </div>
        <div class="wrap-body row">
            <div class="col-8">
                <div class="static-rate">
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                </div>
                <div>
                    <span class="review"> <span>By</span>
                    <span class="author"> Thủy Phạm</span>
                    </span>
                    <br>


                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
            </div>
        </div>
         <div class="wrap-body row">
            <div class="col-8">
                <div class="form-group">
                    <h4>Leave a comment</h4>

                    <textarea name="msg" id="" msg cols="30" rows="5" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <button type="button" id="post" class="btn">Post Comment</button>
                </div>
            </div>
        </div>
    </div>

  
</template>

<script>
    export default {
  data() {
    return {
      posts: [],
      errors: [],
    };
  },
  created() {
    axios.get(`http://localhost:8080/poi/12`)
      .then((response) => {
        this.posts = response.data;
        console.log(this.posts)
      })
      .catch((e) => {
        this.errors.push(e);
        console.log("fail")
      });
  },
  methods: {
    secondsToHms(d) {
    d = Number(d);
    var h = Math.floor(d / 3600);
    var m = Math.floor(d % 3600 / 60);
    var s = Math.floor(d % 3600 % 60);

    var hDisplay = h > 0 ? h + (h == 1 ? " hour, " : " hours, ") : "";
    var mDisplay = m > 0 ? m + (m == 1 ? " minute, " : " minutes, ") : "";
    var sDisplay = s > 0 ? s + (s == 1 ? " second" : " seconds") : "";
    return hDisplay + mDisplay + sDisplay; 
}   ,
    concatAddress(s){
        const arr = s.split(",");
        return arr;
    }
  }
};
</script>