import React, { useContext, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './security/AuthContext';
import { deleteTaskForUser, retrieveTasksForUser } from './api/TaskApiService';
import { useNavigate } from 'react-router-dom';

export const TaskList = () => {
  const { activeUser, token } = useContext(AuthContext);
  const [tasks, setTasks] = useState([]);
  const [message, setMessage] = useState(null);

  const navigate = useNavigate();

  const today = new Date();

  const handleTaskDelete = async (id) => {
    try {
      let res = await deleteTaskForUser(activeUser, id, token);
      setMessage(`Task with id of ${id} successfully deleted`);

      refreshTasks();
    } catch (err) {
      console.log(err);
    }
  };

  const handleTaskUpdate = async (id) => {
    navigate(`/task/${id}`);
  };

  const refreshTasks = async () => {
    let res = await retrieveTasksForUser(activeUser, token);
    setTasks(res.data);
  };

  useEffect(() => {
    const getUserTasks = async (activeUser) => {
      let res = await retrieveTasksForUser(activeUser, token);
      setTasks(res.data);
    };

    getUserTasks(activeUser);
  }, [activeUser]);
  return (
    <div className="container">
      <h3>Task List</h3>
      <h5>User: {activeUser}</h5>
      <Link to="/task" className="btn btn-success my-4">
        New Task
      </Link>
      {message ? <div className="alert alert-warning">{message}</div> : null}

      {tasks.length !== 0 ? (
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Description</th>
              <th>Completed</th>
              <th>Target Date</th>
              <th>Delete</th>
              <th>Update</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.id}</td>
                <td>{task.description}</td>
                <td>{task.done.toString()}</td>
                <td>{task.targetDate}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => handleTaskDelete(task.id)}
                  >
                    Delete
                  </button>
                </td>

                <td>
                  <button
                    className="btn btn-info"
                    onClick={() => handleTaskUpdate(task.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : null}
    </div>
  );
};
