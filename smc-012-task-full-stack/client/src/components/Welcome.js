import React, { useContext, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { AuthContext } from './security/AuthContext';
import axios from 'axios';
import {
  retrieveHelloWorld,
  retrieveHelloWorldBean,
  retrieveHelloWorldUser,
} from './api/HelloWorldApiService';

export const Welcome = () => {
  const [message, setMessage] = useState(null);

  const authContext = useContext(AuthContext);

  const { activeUser, token } = authContext;

  const helloWorldClick = async () => {
    try {
      let res = await retrieveHelloWorld(token);
      setMessage(res.data);
    } catch (e) {
      console.log(e);
    } finally {
      // cleanup
    }
  };

  const helloWorldBeanClick = async () => {
    try {
      let res = await retrieveHelloWorldBean(token);
      setMessage(res.data.message);
    } catch (e) {
      console.log(e);
    } finally {
      // cleanup
    }
  };
  const helloWorldUserClick = async () => {
    try {
      let res = await retrieveHelloWorldUser(activeUser, token);
      setMessage(res.data.message);
    } catch (e) {
      console.log(e);
    } finally {
      // cleanup
    }
  };
  return (
    <div>
      <h3>Welcome {activeUser}</h3>
      <h4>
        Your task list: <Link to="/tasks">Go</Link>
      </h4>
      <div>
        <p>Hello World REST API</p>
        <div className="text-info">{message}</div>
        <button className="btn btn-success" onClick={() => helloWorldClick()}>
          Hello World
        </button>
      </div>
      <div>
        <button
          className="btn btn-success"
          onClick={() => helloWorldBeanClick()}
        >
          Hello World Bean
        </button>
      </div>
      <div>
        <button
          className="btn btn-success"
          onClick={() => helloWorldUserClick()}
        >
          Hello World User
        </button>
      </div>
    </div>
  );
};
