import React, { useContext } from 'react';
import { AuthContext } from './AuthContext';
import { Navigate } from 'react-router-dom';

export const AuthenticatedRoute = ({ children }) => {
  const { activeUser } = useContext(AuthContext);

  if (activeUser !== '') {
    return children;
  } else {
    return <Navigate to="/login" />;
  }
};
