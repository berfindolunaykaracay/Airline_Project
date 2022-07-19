<template>
  <validation-observer
      ref="observer"
  >

    <form @submit.prevent=' submit'>
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
      <validation-provider

          name="Password"
          rules="required|max:10"

      >
        <v-text-field
            :append-icon="show3 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show3 ? 'text' : 'password'"
            name="input-10-2"
            label="Password"
            hint="At least 8 characters"
            value=""
            class="input-group--focused"
            v-model="password"
            @click:append="show3 = !show3"
        ></v-text-field>

      </validation-provider>


      <v-btn
          class="mr-4"
          type="submit"
          @click = "enter"
      >

        <div v-if="isLogin" v-bind:style="{ 'background-color': 'red' }">
          <router-link class="mr-4"  type="submit" tag="button" to="/AddPassenger">Submit</router-link>
        </div>

      </v-btn>

      <v-btn
          class="mr-4"
          type="submit"
          :disabled="invalid"
      >
        <router-link  v-if="isNotInConfig()" class="mr-4" type="submit" tag="button" to="/AddPassenger">Register</router-link>

      </v-btn>

      <div v-if="!isLogin">
        <p>Password or email is invalid!</p>
      </div>
    </form>

  </validation-observer>

</template>
<script>
import { required, email} from 'vee-validate/dist/rules'
import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
import axios from "axios";

setInteractionMode('eager')



extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})


extend('email', {
  ...email,
  message: 'Email must be valid',
})

export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },
  data: () => ({
    password: '',
    email: '',
    isLogin:false,
    show3: false,
    rules: {
      required: value => !!value || 'Required.',
      min: v => v.length >= 8 || 'Min 8 characters',

    },

  }),

  methods: {
    async enter(){

      const params = {
        email : this.email,
        password: this.password
      }

       await axios.get('http://localhost:8080/login/signin', { params }).
       then(res => this.isLogin =res.data.success);
      console.log(this.isLogin);
    },
    submit () {
      this.$refs.observer.validate()
    },
    isNotInConfig() {
      return this.$router.history.current["path"] !== "/user/config";
    },

  },
}
</script>