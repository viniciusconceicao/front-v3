import axios from 'axios'

const api = axios.create({
    baseURL: 'http://54.161.249.114:9090',
});

export default api
