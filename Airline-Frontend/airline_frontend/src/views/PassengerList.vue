<template>
  <div class="about">
    <h1>Airline System</h1>
    <h2>Passenger List</h2><br>
    <el-table
        :data="passsengerList"
        style="width: 100%">
      <el-table-column

          prop="firstName"
          label="Name"
          width="150">
      </el-table-column>
      <el-table-column
          prop="lastName"
          label="Surname"
          width="150">
      </el-table-column>

      <el-table-column
          prop="gender"
          label="Gender"
          width="150">
      </el-table-column>

      <el-table-column
          prop="profession"
          label="Profession"
          width="150">
      </el-table-column>

      <el-table-column
          fixed
          prop="birthDate"
          label="Birth Date"
          width="150">
      </el-table-column>
      <el-table-column
          prop="passengerType"
          label="Type"
          width="150">
      </el-table-column>

      <el-table-column
          prop="email"
          label="Email"
          width="150">
      </el-table-column>

      <el-table-column
          prop="miles"
          label="Miles"
          width="150">
      </el-table-column>
      <el-table-column
          prop="phoneNumber"
          label="Phone Number"
          width="150">
      </el-table-column>


      <el-table-column
          fixed="right"
          label="Operations"
          width="120">
        <template >
          <el-button
              @click="deleteRow(scope.$index, passsengerList)"
              type="text"
              size="small">
            Remove
          </el-button>
        </template>
      </el-table-column>


    </el-table>



  </div>


</template>
<script>
const axios = require('axios');

export default {

  data() {
    return {
    passsengerList : []

    };
  },
  props : ["baseURL", "categories"],
  methods: {
    deleteRow(index, rows) {
      rows.splice(index, 1);
    }
    ,
    handleClick() {
      console.log('click');
    },
    handleChange(value) {
      console.log(value)
    },


    async listPassenger() {

     await axios.get("http://localhost:8080/passenger/read")
            .then(res=>this.passsengerList=res.data)
          .catch(err => console.log(err));
    }

  },
    mounted() {
      this.listPassenger();
    },
  handleEdit(index, row) {
    console.log(index, row);
  },
  handleDelete(index, row) {
    console.log(index, row);
  }
};
</script>
