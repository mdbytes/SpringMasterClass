import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './security/AuthContext';

export const Header = () => {
  const authContext = useContext(AuthContext);

  console.log(authContext.number);
  return (
    <header className="border-bottom border-light border-5 mb-5 p-2">
      <h1 className="text-center">Task Master</h1>
    </header>
  );
};
