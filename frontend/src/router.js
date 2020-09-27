import Vue from 'vue'
import Router from 'vue-router'
import Register from './components/Register'
import HelloWorld from './components/HelloWorld'
import Order from './components/Order'


Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/Register',
      name: 'Register',
      component: Register
    },
    {
        path: '/Order',
        name: 'Order',
        component: Order
        },
    {
        path: '/HelloWorld',
        name: 'HelloWorld',
        component: HelloWorld
            },
    

]
})