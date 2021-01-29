import Vue from 'vue'
import App from './App.vue'
import Axios from  'axios'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'




// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)



Vue.prototype.$http = Axios;

const URLBase = "http://localhost:9090";
Vue.prototype.$baseURL = URLBase;
Vue.prototype.$api = URLBase + "/api/";


Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
