import React, { useState, useEffect, useContext } from 'react';
import { AuthContext } from './security/AuthContext';
import { useNavigate, useParams } from 'react-router-dom';
import { retrieveTask, updateTask } from './api/TaskApiService';
import { Formik, Form, Field } from 'formik';

export const Task = () => {
  const { id } = useParams();

  const [task, setTask] = useState(null);

  const { activeUser, token } = useContext(AuthContext);

  const navigate = useNavigate();

  useEffect(() => {
    const getTask = async (id) => {
      let res = await retrieveTask(id, token);
      setTask(res.data);
    };

    if (id) {
      getTask(id);
    }
  }, []);

  const handleUpdateTask = async (task) => {
    try {
      let res = await updateTask(task, token);
      navigate('/tasks');
    } catch (e) {
      console.log(e);
    }
  };

  let newTask = {
    description: '',
    done: false,
    targetDate: Date(),
    username: activeUser,
  };

  const handleAddTask = async (task) => {
    try {
      let res = await updateTask(task, token);
      navigate('/tasks');
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div className="container task">
      <h3>Task Entry</h3>

      {task ? (
        <Formik
          initialValues={task}
          enableReinitialize={true}
          onSubmit={handleUpdateTask}
        >
          {(props) => (
            <Form>
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                ></Field>
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field
                  type="date"
                  className="form-control"
                  name="targetDate"
                ></Field>
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      ) : (
        <Formik
          initialValues={newTask}
          enableReinitialize={true}
          onSubmit={handleAddTask}
        >
          {(props) => (
            <Form>
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                ></Field>
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field
                  type="date"
                  className="form-control"
                  name="targetDate"
                ></Field>
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      )}
    </div>
  );
};
