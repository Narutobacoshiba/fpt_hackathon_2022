<template>
    <template v-if="wallet">
        <template v-if="views == 'list_customer'">
            <div class="customer-list" >
            <br><br><br><br><br>
            <div>
                <h1 style="text-align: center; color:"> Customer List</h1>  
                <table class="content-table">
                    
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Phone</th>
                        <th>Sex</th>
                        <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item, idx) in list_customer" :key="item+idx">
                        <td>{{item[1].id}}</td>
                        <td>{{item[1].name}}</td>
                        <td>{{item[1].date_of_birth}}</td>
                        <td>{{item[1].phone}}</td>
                        <td>{{item[1].sex}}</td>
                        <td>
                            <a class="button-cl" @click="updateCustomer(item[1])">Update</a>
                            <a class="button-cl" @click="deleteCustomer(item[1])">Delete</a>
                        </td>
                        </tr>
                    
                    </tbody>
                    </table>
                    <br>
                <div class="buttons-center">
                <button type="submit" @click="changeViews('register_customer')">Register</button>
            </div>
            
            </div>
            </div>
        </template>
        <template v-if="views == 'register_customer'">
            <div class="register">
                <br><br><br><br><br><br>
                <div style="text-align:center; ">
                    <h1>Register</h1>
                </div>
                <br>
                <table class="content-table">
                    <tr>
                        <td>First name</td>
                        <td>  <input v-model="firstName" class="text" placeholder="First name"/>  </td>
                    </tr>
                    <tr>
                        <td>Last name</td>
                        <td> <input v-model="lastName" class="text" placeholder="Last name"/>  </td>
                    </tr>
                    <tr>
                        <td>Sex</td>
                        <td>
                            <input v-model="sex" type="radio" id="male" value="Male" />  
                            <label for="male">male</label>
                            <input v-model="sex" type="radio" id="female" value="Female" />  
                            <label for="female">female</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                            <td>
                        <input v-model="dateOfBirth" placeholder="Date of birth" type="date"/>  
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>  <input v-model="phone" placeholder="Phone"  />  </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>  <input v-model="address" placeholder="Address" />    </td>
                    </tr>
                    <div class="buttons-center" >
                        <button type="submit" @click="saveRegister">Save</button>
                        <button type="submit" @click="cancelRegister">Cancel</button>
                    </div>
                </table>
            </div>
        </template>
        <template v-if="views == 'update_customer'">
            <div class="register">
                <br><br><br><br><br><br>
                <div style="text-align:center; ">
                    <h1>Update</h1>
                </div>
                <br>
                <table class="content-table">
                    <tr>
                        <td>Name</td>
                        <td>  <input v-model="selected_customer.name" class="text" placeholder="First name"/>  </td>
                    </tr>
                    <tr>
                        <td>Sex</td>
                        <td>
                            <input v-model="selected_customer.sex" type="radio" id="male" value="Male" />  
                            <label for="male">male</label>
                            <input v-model="selected_customer.sex" type="radio" id="female" value="Female" />  
                            <label for="female">female</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                            <td>
                        <input v-model="selected_customer.date_of_birth" placeholder="Date of birth" type="date"/>  
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>  <input v-model="selected_customer.phone" placeholder="Phone"  />  </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>  <input v-model="selected_customer.address" placeholder="Address" />    </td>
                    </tr>
                    <div class="buttons-center" >
                        <button type="submit" @click="saveUpdate">Save</button>
                        <button type="submit" @click="cancelUpdate">Cancel</button>
                    </div>
                </table>
            </div>
        </template>
    </template>
    <template v-else>
        <p> Connect with a wallet to access this function </p>
    </template>
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
var list_customer = ref([])
var views = ref("list_customer")
var firstName =  ref("")
var lastName = ref("")
var sex = ref("")
var dateOfBirth = ref("")
var phone = ref("")
var address = ref("")
var selected_customer = ref(null)

const updateCustomer = async (value) => {
    if(value){
        selected_customer.value = value
        changeViews("update_customer")
    }
}

const deleteCustomer = async (value) => {
    if(value){
        if(confirm("Press a button!\nEither OK or Cancel.")){
            console.log("delete customer")
            const res = await nft.value.delete_profile(value.id)
            console.log(res)
            listAllCustomer()
        }
    }
}

const cancelUpdate = () => {
    selected_customer.value = null
    changeViews("list_customer")
}

const saveUpdate = async () => {
    console.log("save update customer")
    const res = await nft.value.update_profile(selected_customer.value.id,
                { id:  selected_customer.value.id,
                  name: selected_customer.value.name,
                  date_of_birth: selected_customer.value.date_of_birth,
                  phone: selected_customer.value.phone,
                  address: selected_customer.value.address,
                  sex: selected_customer.value.sex
                },);
    console.log(res)
    selected_customer.value = null
    listAllCustomer()
    changeViews("list_customer")
}

const listAllCustomer = async () => {
    const res = await nft.value.get_all_profile()    
    list_customer.value = res
    console.log(res)
}

const changeViews = (view) => {
    console.log(view)
    if(views.value != view){
        views.value = view
    }
}

const cancelRegister = () => {
    firstName.value = ""
    lastName.value = ""
    sex.value = ""
    dateOfBirth.value = ""
    phone.value = ""
    address.value = ""
    changeViews("list_customer")
}

const generateRandomInteger = (max) => {
    return Math.floor(Math.random() * max) + 1;
}

const saveRegister = async () => {
    console.log("save customer")
    const res = await nft.value.create_profile(
                { id:  generateRandomInteger(1000000),
                  name: firstName.value + " " + lastName.value,
                  date_of_birth: dateOfBirth.value,
                  phone: phone.value,
                  address: address.value,
                  sex: sex.value
                },);
    firstName.value = ""
    lastName.value = ""
    sex.value = ""
    dateOfBirth.value = ""
    phone.value = ""
    address.value = ""
    console.log(res)
    listAllCustomer()
    changeViews("list_customer")
}

const getSex = (sex) => {
    if(sex){
        return "Male"
    }else{
        return "Female"
    }
}

watchEffect(() => {
	if(wallet.value && nft.value) {
		listAllCustomer()
	}else{
            list_customer.value = []
    }
});
</script>


<style scoped>
* {
  font-family: sans-serif; /* Change your font family */
}
 
body {
    min-height: 100%;
}
 
.content-table {
  border-collapse: collapse;
  margin: 0 auto;
  font-size: 0.9em;
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
 
.content-table thead tr {
  background-color: #009879;
  color: #ffffff;
  text-align: left;
  font-weight: bold;
}
 
.content-table th,
.content-table td {
  padding: 12px 15px;
}
 
.content-table tbody tr {
  border-bottom: 1px solid #dddddd;
}
 
.content-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}
 
.content-table tbody tr:last-of-type {
  border-bottom: 2px solid #009879;
}
 
.content-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}
 
.customer-list {
    display: grid;
    align-items: center;
  justify-content: center;
   
}
 
.buttons-center{
  display:flex;
  justify-content:center;
  gap:10px;
  padding:20px;
}
 
.buttons-center button {
  padding:8px 10px;
  border-radius:8px;
  border:0;
  width:150px;
}
 
.buttons-center button:first-child {
 background-color : #808080;
  color: white;
}
 
.buttons-center button:first-child:hover {
 background-color : #a9a9a9;
}
 
.buttons-center button:last-child {
 background-color :  #009879;
  color: white;
}
.buttons-center button:last-child:hover {
 background-color : #48bb78;
}

* {
  font-family: sans-serif; /* Change your font family */
}
 
body {
    min-height: 100%;
}
 
.input {
    margin-left: 20px;
    border: none;
    padding: 10px 0;
    border-bottom: solid 1px #808080;
    transition: all 0.3s cubic-bezier(.64,.09,.08,1);
}
 
.form  {
    text-align: center;
}
 
.content-table {
  border-collapse: collapse;
  margin: 0 auto;
  font-size: 0.9em;
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
 
.content-table thead tr {
  background-color: #009879;
  color: #ffffff;
  text-align: left;
  font-weight: bold;
}
 
.content-table th,
.content-table td {
  padding: 12px 15px;
}
 
.content-table tbody tr {
  border-bottom: 1px solid #dddddd;
}
 
.content-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}
 
.content-table tbody tr:last-of-type {
  border-bottom: 2px solid #009879;
}
 
.content-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}
 
.register {
    display: grid;
    align-items: center;
  justify-content: center;  
}
 
.buttons-center{
  display:flex;
  justify-content:center;
  gap:10px;
  padding:20px;
}
 
.buttons-center button {
  padding:8px 10px;
  border-radius:8px;
  border:0;
  width:150px;
}
 
.buttons-center button:last-child {
 background-color : #808080;
  color: white;
}
 
.buttons-center button:last-child:hover {
 background-color : #a9a9a9;
}
 
.buttons-center button:first-child {
 background-color :  #009879;
  color: white;
}
.buttons-center button:first-child:hover {
 background-color : #48bb78;
}

</style>