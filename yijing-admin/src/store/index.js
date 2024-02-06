import Vue from 'vue'
import Vuex from 'vuex'
import selects from './modules/selects'
import getters from './getters'
import createPersistedState from "vuex-persistedstate";
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    selects
  },
  getters,
  plugins: [
    createPersistedState({
      storage: window.localStorage,
      paths:['selects']
    }),
  ],
})

export default store
