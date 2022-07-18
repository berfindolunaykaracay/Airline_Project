<template>
  <validation-observer
      ref="observer"
      v-slot="{ invalid }"
  >
    <form @submit.prevent="submit">
      <validation-provider
          v-slot="{ errors }"
          name="First Name"
      >
        <v-text-field
            v-model="firstName"

            :error-messages="errors"
            label="First Name"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="Last Name"
      >
        <v-text-field
            v-model="lastName"

            :error-messages="errors"
            label="Last Name"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="Gender"
      >
        <v-text-field
            v-model="gender"

            :error-messages="errors"
            label="Gender"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="Profession"
      >
        <v-text-field
            v-model="profession"

            :error-messages="errors"
            label="Profession"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="Type"
      >
        <v-text-field
            v-model="type"

            :error-messages="errors"
            label="Type"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="Miles"
      >
        <v-text-field
            v-model="miles"

            :error-messages="errors"
            label="Miles"
            required
        ></v-text-field>
      </validation-provider>

      <validation-provider
          v-slot="{ errors }"
          name="phoneNumber"
          :rules="{
          required: true,
          digits: 10,
        }"
      >
        <v-text-field
            v-model="phoneNumber"
            :counter="7"
            :error-messages="errors"
            label="Phone Number"
            required
        ></v-text-field>
      </validation-provider>
      <validation-provider
          v-slot="{ errors }"
          name="email"
          rules="required|email"
      >
        <v-text-field
            v-model="email"
            :error-messages="errors"
            label="E-mail"
            required
        ></v-text-field>
      </validation-provider>


      <v-btn
          class="mr-4"
          type="submit"
          :disabled="invalid"
      >
        submit
      </v-btn>
      <v-btn @click="clear">
        clear
      </v-btn>
    </form>
  </validation-observer>
</template>

<script>
import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'

setInteractionMode('eager')

extend('digits', {
  ...digits,
  message: '{_field_} needs to be {length} digits. ({_value_})',
})

extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})

extend('max', {
  ...max,
  message: '{_field_} may not be greater than {length} characters',
})

extend('regex', {
  ...regex,
  message: '{_field_} {_value_} does not match {regex}',
})

extend('email', {
  ...email,
  message: 'Email must be valid',
})
const axios =  require('axios')
import swal from 'sweetalert';
export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },
  data: () => ({
    firstName: '',
    lastName: '',
    gender: '',
    profession: '',
    type: '',
    miles: '',
    phoneNumber: '',
    email: '',
  }),

  methods: {
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
  },

  submit () {
    this.$refs.observer.validate()
  },
  clear () {
    this.firstName = ''
    this.lastName = ''
    this.gender = ''
    this.profession = ''
    this.type = ''
    this.miles = ''
    this.phoneNumber = ''
    this.email = ''
    this.$refs.observer.reset()
  },

}
</script>

<style scoped>

</style>