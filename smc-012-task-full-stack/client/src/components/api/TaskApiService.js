import axios from 'axios';
import { apiClient } from './ApiClient';

export const retrieveTasksForUser = (activeUser, token) => {
  return apiClient.get(`/users/${activeUser}/tasks`, {
    headers: {
      Authorization: token,
    },
  });
};

export const retrieveTaskForUser = (activeUser, taskId, token) => {
  return apiClient.get(`/users/${activeUser}/tasks/${taskId}`, {
    headers: {
      Authorization: token,
    },
  });
};

export const retrieveTask = (taskId, token) => {
  return apiClient.get(`/tasks/${taskId}`, {
    headers: {
      Authorization: token,
    },
  });
};

export const deleteTaskForUser = (activeUser, taskId, token) => {
  return apiClient.delete(`/users/${activeUser}/tasks/${taskId}`, {
    headers: {
      Authorization: token,
    },
  });
};

export const updateTask = (task, token) => {
  return axios({
    method: 'post',
    url: 'http://localhost:8080/api/v1/tasks',
    headers: {
      Authorization: token,
    },
    data: {
      id: task.id,
      description: task.description,
      done: task.done,
      targetDate: task.targetDate,
      username: task.username,
    },
  });
};
