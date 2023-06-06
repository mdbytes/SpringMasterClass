import { createContext, useState } from 'react';
import { basicAuth } from '../api/AuthService';

// 1. Create context
export const AuthContext = createContext();

//2: Share the context with other components
export const AuthProvider = ({ children }) => {
  //3: Put some state in the context
  const [activeUser, setActiveUser] = useState('');
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [token, setToken] = useState(null);

  const login = async (username, password) => {
    const basicAuthToken = `Basic ` + window.btoa(username + ':' + password);

    try {
      let res = await basicAuth(basicAuthToken);
      if (res.status === 200) {
        setActiveUser(username);
        setIsAuthenticated(true);
        setToken(basicAuthToken);
        return true;
      } else {
        logout();
        return false;
      }
    } catch (err) {
      console.log(err);
      logout();
      return false;
    }
  };

  const logout = () => {
    setActiveUser('');
    setToken(null);
    setIsAuthenticated(false);
  };

  return (
    <AuthContext.Provider
      value={{ login, logout, activeUser, token, isAuthenticated }}
    >
      {children}
    </AuthContext.Provider>
  );
};
