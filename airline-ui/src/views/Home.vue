<template>
  <v-data-table
      :headers="headers"
      :items="passengers"
      sort-by="lastName"
      class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
          flat
      >
        <v-toolbar-title>Passenger List</v-toolbar-title>
        <router-link to="EditPassenger">Edit</router-link>
        <v-divider
            class="mx-4"
            inset
            vertical
        ></v-divider>
        <v-spacer></v-spacer>
        <v-dialog
            v-model="dialog"
            max-width="500px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                color="primary"
                dark
                class="mb-2"
                v-bind="attrs"
                v-on="on"
            >
              New Passenger
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.firstName"
                        label="First Name"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.lastName"
                        label="Last Name"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.gender"
                        label="Gender"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.profession"
                        label="Profession"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.birthDate"
                        label="birthDate"
                    ></v-text-field>
                  </v-col>


                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.passengerType"
                        label="Passenger Type"
                    ></v-text-field>
                  </v-col>

                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.email"
                        label="Email"
                    ></v-text-field>
                  </v-col>

                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.miles"
                        label="Miles"
                    ></v-text-field>
                  </v-col>

                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.phoneNumber"
                        label="Phone Number"
                    ></v-text-field>
                  </v-col>

                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                  color="blue darken-1"
                  text
                  @click="close"
              >
                Cancel
              </v-btn>
              <v-btn
                  color="blue darken-1"
                  text
                  @click="save"
              >
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>

    <template v-slot:item.actions="{ item }">


      <router-link :to="{ name: 'EditPassenger' , params: { id : item.id, passenger:item }}">
        <v-icon
            small
            class="mr-2"
            @click="editItem(item)"
        >
          mdi-pencil
        </v-icon>
      </router-link>
      <v-icon
          small
          @click="deleteItem(item)"
      >
        mdi-delete
      </v-icon>
    </template>



    <template v-slot:no-data>
      <v-btn
          color="primary"
          @click="initialize"
      >
        Reset
      </v-btn>
    </template>
  </v-data-table>
</template>
<script>
const axios = require('axios');
export default {
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      {text: 'First Name', value: 'firstName'},
      { text: 'Last Name', value: 'lastName' },
      { text: 'Gender', value: 'gender' },
      { text: 'Profession', value: 'profession' },
      { text: 'Birth Date', value: 'birthDate' },
      { text: 'Passenger Type', value: 'passengerType' },
      { text: 'Email', value: 'email' },
      { text: 'Miles', value: 'miles' },
      { text: 'Phone Number', value: 'phoneNumber' },
      { text: 'Actions', value: 'actions', sortable: false },
    ],
    passengers: [],
    editedIndex: -1,
    editedItem: {
      firstName: '',
      lastName: '',
      gender: '',
      profession: '',
      birthDate: '',
      passengerType: '',
      email: '',
      miles: 0,
      phoneNumber: '',
    },
    defaultItem: {
      firstName: '',
      lastName: '',
      gender: '',
      profession:'',
      birthDate: '',
      passengerType: '',
      email: '',
      miles: 0,
      phoneNumber: '',
    },
  }),

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
    },
  },

  watch: {
    dialog (val) {
      val || this.close()
    },
    dialogDelete (val) {
      val || this.closeDelete()
    },
  },

  created () {
    this.listPassenger()
  },

  methods: {
    async listPassenger() {

      await axios.get("http://localhost:8080/passenger/read")
          .then(res=>this.passengers=res.data)
          .catch(err => console.log(err));
    },

    editItem (item) {
      this.editedIndex = this.passengers.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
      console.log(item.firstName);
    },

    deleteItem (item) {
      this.editedIndex = this.passengers.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
      console.log(this.passengers[this.editedIndex].id);
      const index = this.passengers[this.editedIndex].id;
      this.createProduct(index);
    },
    async createProduct(id) {
      await axios.delete(`http://localhost:8080/passenger/delete/${id}`)
          .then(response => {
            console.log(response);
            this.listPassenger();
          });
    },
    deleteItemConfirm () {
      this.passengers.splice(this.editedIndex, 1)
      this.closeDelete()
    },

    close () {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete () {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save () {
      if (this.editedIndex > -1) {
        Object.assign(this.passengers[this.editedIndex], this.editedItem)
      } else {
        this.passengers.push(this.editedItem)
      }
      this.close()
    },
  },
}
</script>