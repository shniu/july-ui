import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Index from '@/components/Index'
import Login from '@/components/Login'
import { Getitem } from '../services/common'
import Settings from '../settings'

Vue.use(Router)

let routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      requiresAuth: false
    }
  }, {
    path: '/',
    name: 'Index',
    component: Index,
    meta: {
      requiresAuth: true
    }
  }
]

const router = new Router({
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth) {
    const token = Getitem(Settings.constant.lsTokenName)
    console.log(to.fullPath)
    if (token) {
      next()
    } else {
      next({
        path: '/login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
})

export default router
