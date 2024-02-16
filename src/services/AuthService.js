import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getAvailableProperties() {
    return axios.get('/browse-properties')
  },

  addProperty(property) {
    return axios.post('/add-property', property)
  }

}
