import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PassengerList from "@/views/PassengerList";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/passengerList',
    name: 'passengerList',
    component: PassengerList
  },
  {
    path: '/about',
    name: 'about',
    component: () => import( '../views/PassengerAdd.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
