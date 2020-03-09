import axios from 'axios';

const service = axios.create({
  baseURL: "http://localhost:8098", // api的base_url
  timeout: 5000,
  withCredentials:true
});

export default service;
