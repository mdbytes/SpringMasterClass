import React, { useContext, useEffect } from 'react';
import { AuthContext } from './security/AuthContext';

export const Logout = () => {
  const { logout } = useContext(AuthContext);

  useEffect(() => {
    logout();
  }, []);

  return (
    <div>
      <h4>You are logged out.</h4>
      <p>Come back soon!</p>
    </div>
  );
};
