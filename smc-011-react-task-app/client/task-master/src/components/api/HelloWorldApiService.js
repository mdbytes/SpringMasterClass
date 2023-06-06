import { apiClient } from './ApiClient';

export const retrieveHelloWorld = async (token) => {
  return apiClient.get('/hello-world', {
    headers: {
      Authorization: token,
    },
  });
};

export const retrieveHelloWorldBean = async (token) => {
  return apiClient.get('/hello-world-bean', {
    headers: {
      Authorization: token,
    },
  });
};

export const retrieveHelloWorldUser = (activeUser, token) => {
  return apiClient.get(`/hello-world/path-variable/${activeUser}`, {
    headers: {
      Authorization: token,
    },
  });
};
