import React, { useState } from 'react';
import { Home } from './Home';
import { Login } from './Login';
import { Welcome } from './Welcome';
import { Error } from './Error';
import './TaskMasterApp.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { TaskList } from './TaskList';
import { Task } from './Task';
import { Header } from './Header';
import { Footer } from './Footer';
import { Logout } from './Logout';
import { Navbar } from './Navbar';
import { AuthProvider } from './security/AuthContext';
import { AuthenticatedRoute } from './security/AuthenticatedRoute';

export const TaskMasterApp = () => {
  const [activeUser, setActiveUser] = useState('');
  return (
    <div className="TaskMasterApp">
      <AuthProvider>
        <BrowserRouter>
          <Navbar activeUser={activeUser} />
          <Header />
          <Routes>
            <Route path="/" element={<Home />}></Route>

            <Route
              path="/login"
              element={<Login setActiveUser={setActiveUser} />}
            ></Route>

            <Route
              path="/logout"
              element={<Logout setActiveUser={setActiveUser} />}
            ></Route>
            <Route
              path="/welcome"
              element={
                <AuthenticatedRoute>
                  <Welcome activeUser={activeUser} />
                </AuthenticatedRoute>
              }
            ></Route>
            <Route
              path="/tasks"
              element={
                <AuthenticatedRoute>
                  <TaskList activeUser={activeUser} />
                </AuthenticatedRoute>
              }
            ></Route>
            <Route
              path="/task/:id?"
              element={
                <AuthenticatedRoute>
                  <Task activeUser={activeUser} />
                </AuthenticatedRoute>
              }
            ></Route>
            <Route path="*" element={<Error />}></Route>
          </Routes>
        </BrowserRouter>
      </AuthProvider>
      <Footer />
    </div>
  );
};
