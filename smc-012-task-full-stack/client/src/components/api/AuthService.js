import axios from 'axios';

const authClient = axios.create({ baseURL: 'http://localhost:8080/api/v1' });

export const basicAuth = (token) => {
  return authClient.get(`/auth`, {
    headers: {
      Authorization: token,
    },
  });
};
