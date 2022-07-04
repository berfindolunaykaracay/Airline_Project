<template>
  <div class="about">
    <h1>Airline System</h1>
    <h2>Passenger Info</h2><br>

    <span  class="demonstration">Name</span><br><br>
    <el-input  placeholder="Name" v-model="inputName"></el-input><br><br>

    <span class="demonstration">Surname</span><br><br>
    <el-input placeholder="Surname" v-model="inputSurname"></el-input><br><br>

    <p>Gender</p>
    <el-radio-group v-model="radio">
      <el-radio :label="3">Male</el-radio>
      <el-radio :label="6">Female</el-radio>
      <el-radio :label="9">Other</el-radio>
    </el-radio-group><br><br><br>

    <span class="demonstration">Profession</span><br><br>
    <el-input placeholder="Profession" v-model="inputProfession"></el-input><br><br>

    <span class="demonstration">Birth Date</span><br><br>
    <el-date-picker
        v-model="value2"
        type="date"
        placeholder="Pick a day"
        :picker-options="pickerOptions">
    </el-date-picker><br><br>

    <p>Type</p>
      <el-select v-model="value" placeholder="Select">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select><br><br>

    <span class="demonstration">Email</span><br><br>
    <el-input placeholder="Email" v-model="inputEmail"></el-input><br><br>

    <p>Miles</p>
    <el-input-number v-model="num" @change="handleChange" :min="1" ></el-input-number><br><br><br>


    <span class="demonstration">Phone Number</span><br><br>
    <el-input placeholder="Phone Number" v-model="inputPhoneNumber"></el-input><br><br>

    <el-button>Submit</el-button>
  </div>


</template>
<script>
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
        value: 'Adult',
        label: 'Adult'
      },{
        value: 'Child',
        label: 'Child'
      }],


      value: '',
      value1: '',
      value2: '',
      inputName: '',
      inputSurname: '',
      radio: 3,
      inputProfession:'',
      inputEmail:'',
      num: 1,
      inputPhoneNumber:''
    };
  },
  methods: {
    handleChange(value) {
      console.log(value)
    }
  }
};
</script>