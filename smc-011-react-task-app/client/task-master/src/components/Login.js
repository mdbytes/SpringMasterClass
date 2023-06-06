import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from './security/AuthContext';

export const Login = () => {
  const [username, setUsername] = useState('martin');
  const [password, setPassword] = useState('pickles4lunch!');
  const [validLogin, setValidLogin] = useState(false);
  const [loginAttempts, setLoginAttempts] = useState(0);

  const navigate = useNavigate();

  const { login } = useContext(AuthContext);

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    let newAttempts = loginAttempts + 1;
    setLoginAttempts(newAttempts);
    if (await login(username, password)) {
      setValidLogin(true);
      navigate(`/welcome`);
    } else {
      setValidLogin(false);
    }
  };

  return (
    <div className="Login">
      {validLogin ? (
        <div className="successMessage">Authentication Successful!</div>
      ) : null}
      {!validLogin && loginAttempts > 0 ? (
        <div className="errorMessage">Authentication Failed!</div>
      ) : null}

      <h3>Login to continue:</h3>
      <form className="loginForm">
        <div>
          <label htmlFor="">User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={(e) => handleUsernameChange(e)}
          />
        </div>
        <div>
          <label htmlFor="">Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={(e) => handlePasswordChange(e)}
          />
        </div>
        <div>
          <button type="submit" onClick={(e) => handleSubmit(e)}>
            Login
          </button>
        </div>
      </form>
    </div>
  );
};
