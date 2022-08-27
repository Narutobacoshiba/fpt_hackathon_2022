<script setup>
// import { useCanister, useWallet } from "@connect2ic/vue"
import { ref } from "vue";
import("../assets/css/ratingpage.css");

// const [nft] = useCanister("nft")
// const [wallet] = useWallet()
</script>
<template>
<div class="container">
<h1 style="margin-left: 110px">Hoa Lo Prison , Hanoi</h1>

  <div class="container">
    <div class="leftpane">
      <img
        class="thumbnail"
        src="data:image/jpeg;base64,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"
      />
    </div>


    <div class="rightpane">
      <h3>Recommended duration</h3>
      <p>1h 30 min</p>
      <h3>Hours</h3>
      <div class="grid-container">
        <table class="activate-time table-primary">
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
          <!-- <p> <pre>Monday          8am - 5pm</pre></p>
        <p> <pre>Tuesday         8am - 5pm</pre></p>
        <p> <pre>Wednesday       8am - 5pm</pre></p>
        <p> <pre>Thursday        8am - 5pm</pre></p>
        <p> <pre>Friday          8am - 5pm</pre></p>
        <p> <pre>Saturday        8am - 5pm</pre></p> -->
        </table>
      </div>

      <h3>Contact</h3>
      <!-- contact and number -->
    </div>
  </div>

  <div class="container">
  
    <div class="middle1">
      <p>
        Hỏa Lò Prison (Vietnamese:Nhà tù Hỏa Lò; French: Prison Hỏa Lò) was a prison in
        Hanoi originally used by the French colonists in Indochina for political
        prisoners, and later by North Vietnam for U.S. prisoners of war during the Vietnam
        War. During this later period, it was known to American POWs as the "Hanoi
        Hilton". The prison was demolished during the 1990s, although the gatehouse
        remains as a museum. The name Hỏa Lò, commonly translated as "fiery furnace" or
        even "Hell's hole",[1] also means "stove". The name originated from the street
        name phố Hỏa Lò, due to the concentration of stores selling wood stoves and
        coal-fire stoves along the street in pre-colonial times.The prison was built in
        Hanoi by the French, in dates ranging from 1886–1889[1] to 1898[2] to 1901,[3]
        when Vietnam was still part of French Indochina. The French called the prison
        Maison Centrale,[1] 'Central House', which is still the designation of prisons for
        dangerous or long sentence detainees in France. It was located near Hanoi's French
        Quarter.[2] It was intended to hold Vietnamese prisoners, particularly political
        prisoners agitating for independence who were often subject to torture and
        execution.[3] A 1913 renovation expanded its capacity from 460 inmates to 600.[2]
        It was nevertheless often overcrowded, holding some 730 prisoners on a given day
        in 1916, a figure which rose to 895 in 1922 and 1,430 in 1933.[2] By 1954 it held
        more than 2000 people;[1] with its inmates held in subhuman conditions,[3] it had
        become a symbol of colonialist exploitation and of the bitterness of the
        Vietnamese towards the French.[1]
      </p>
    </div>
  </div>

  <div class="container" style="margin-left: 110px; margin-top: -170px">
    <h1>Hoa Lo Prison reviews</h1>

    <p>Rate this attraction</p>
    <p>Leave a comment:</p>
    <input class="input" type="text" placeholder="Type here" />

    <button class="button1">Submit</button>
  </div>

 
</div>
  
</template>
