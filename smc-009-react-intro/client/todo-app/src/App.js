import React from 'react';
import './App.css';
import { MyFirstComponent } from './components/MyFirstComponent';
import { SecondComponent } from './components/MySecondComponent';
import { ThirdComponent } from './components/ThirdComponent';
import { FourthComponent } from './components/FourthComponent';

function App() {
  return (
    <div className="App">
      <h1>Task Master Application</h1>
      <MyFirstComponent />
      <SecondComponent />
      <ThirdComponent />
      <FourthComponent />
    </div>
  );
}

export default App;
