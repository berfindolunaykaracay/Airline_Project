<template>

  <v-data-table
      :headers="headers"
      :items="flights"

  >
    <template v-slot:top>
      <v-toolbar
          flat
      >
        <v-toolbar-title>Flights</v-toolbar-title>

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
                        v-model="editedItem.airplaneType"
                        label="Airplane Type"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.connectingFlight"
                        label="Connecting Flight"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.ftime"
                        label="Flight Time"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.airlineName"
                        label="Airline Name"
                    ></v-text-field>
                  </v-col>
                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.fromLocation"
                        label="From Location"
                    ></v-text-field>
                  </v-col>


                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.toLocation"
                        label="To Location"
                    ></v-text-field>
                  </v-col>

                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.departureTime"
                        label="Departure Time"
                    ></v-text-field>
                  </v-col>

                  <v-col
                      cols="12"
                      sm="6"
                      md="4"
                  >
                    <v-text-field
                        v-model="editedItem.duration"
                        label="Duration"
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>


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
      {text: 'Airplane Type', value: 'airplaneType'},
      { text: 'Connecting Flight', value: 'connectingFlight' },
      { text: 'Flight Time', value: 'ftime' },
      { text: 'Airline Name', value: 'airlineName' },
      { text: 'From Location', value: 'fromLocation' },
      { text: 'To Location', value: 'toLocation' },
      { text: 'Departure Time', value: 'departureTime' },
      { text: 'Duration', value: 'duration' },
      { text: 'Actions', value: 'actions', sortable: false },
    ],
    flights: [],
    editedIndex: -1,
    editedItem: {
      airplaneType: '',
      connectingFlight: '',
      ftime: '',
      airlineName: '',
      fromLocation: '',
      toLocation: '',
      departureTime: '',
      duration: 0,


    },
    defaultItem: {
      airplaneType: '',
      connectingFlight: '',
      ftime: '',
      airlineName:'',
      fromLocation: '',
      toLocation: '',
      departureTime: '',
      duration: 0,


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
    this.listFlights()
  },

  methods: {
    async listFlights() {

      await axios.get("http://localhost:8080/flight/read")
          .then(res=>this.flights=res.data)
          .catch(err => console.log(err));
    },

    editItem (item) {
      this.editedIndex = this.flights.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
      console.log(item.airplaneType);
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
        Object.assign(this.flights[this.editedIndex], this.editedItem)
      } else {
        this.flights.push(this.editedItem)
      }
      this.close()
    },
  },
}
</script>