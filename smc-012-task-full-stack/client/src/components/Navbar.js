import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './security/AuthContext';

export const Navbar = () => {
  const { activeUser } = useContext(AuthContext);

  return (
    <nav className="navbar navbar-expand navbar-dark bg-dark">
      <div className="container-fluid">
        <a className="navbar-brand" href="#">
          MD Bytes
        </a>

        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            {activeUser !== '' ? (
              <React.Fragment>
                <Link className="nav-link active" to="/welcome">
                  Dashboard
                </Link>
                <Link className="nav-link active" to="/tasks">
                  Tasks
                </Link>
                <Link className="nav-link active" to="/logout">
                  Logout
                </Link>
              </React.Fragment>
            ) : (
              <Link className="nav-link active" to="/login">
                Login
              </Link>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
};
