<template>
  <div class="about">
    <h1>Airline System</h1>
    <h2>Passenger Info</h2><br>

    <span  class="demonstration"><b>Name</b></span><br><br>
    <el-input  placeholder="Name" v-model="firstName"></el-input><br><br>

    <span class="demonstration"><b>Surname</b></span><br><br>
    <el-input placeholder="Surname" v-model="lastName"></el-input><br><br>

    <p><b>Gender</b></p>
    <el-radio-group v-model="gender">
      <el-radio :label="3">Male</el-radio>
      <el-radio :label="6">Female</el-radio>
      <el-radio :label="9">Other</el-radio>
    </el-radio-group><br><br><br>

    <span class="demonstration"><b>Profession</b></span><br><br>
    <el-input placeholder="Profession" v-model="profession"></el-input><br><br>

    <span class="demonstration"><b>Birth Date</b></span><br><br>
    <el-date-picker
        v-model="birthDate"
        type="date"
        placeholder="Pick a day"
        :picker-options="pickerOptions">
    </el-date-picker><br><br>

    <p><b>Type</b></p>
      <el-select v-model="passengerType" placeholder="Select">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select><br><br>

    <span class="demonstration"><b>Email</b></span><br><br>
    <el-input placeholder="Email" v-model="email"></el-input><br><br>

    <p><b>Miles</b></p>
    <el-input-number v-model="miles" @change="handleChange" :min="1" ></el-input-number><br><br><br>


    <span class="demonstration"><b>Phone Number</b></span><br><br>
    <el-input placeholder="Phone Number" v-model="phoneNumber"></el-input><br><br>

    <el-button @click="addPassenger"><b>Submit</b></el-button>
  </div>


</template>
<script>
const axios = require('axios');
import swal from 'sweetalert';
export default {
  data() {
    return {
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: 'Today',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: 'Yesterday',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: 'A week ago',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      options: [{
        passengerType: 'Adult',
        label: 'Adult'
      },{
        passengerType: 'Child',
        label: 'Child'
      }],


      passengerType: '',
     // value1: '',
      birthDate: '',
      firstName: '',
      lastName: '',
      gender: 3,
      profession:'',
      email:'',
      miles: 1,
      phoneNumber:''
    };
  },
  props : ["baseURL", "categories"],
  methods: {
    handleChange(value) {
      console.log(value)
    },


    async addPassenger() {
      const newPassenger = {
        firstName : this.firstName,
        lastName : this.lastName,
        gender : this.gender,
        profession : this.profession,
        birthDate : this.birthDate,
        passengerType : this.passengerType,
        email : this.email,
        miles : this.miles,
        phoneNumber : this.phoneNumber,
      }
      await axios({
        method:'post',
        url:"http://localhost:8080/passenger/add",
        data:JSON.stringify(newPassenger),
        headers:{
          'Content-Type':'application/json'
        }
      })
          .then(() => {
            swal({
              text:"Passenger Added Successfully!",
              icon:"success",
              closeOnClickOutside:false,
            });
          })
          .catch(err => console.log(err));
    }
  }
    


};
</script>
