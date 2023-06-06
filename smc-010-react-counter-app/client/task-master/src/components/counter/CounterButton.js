import React, { useState } from 'react';
import './counter.css';

export const CounterButton = ({ count, countBy, setCount }) => {
  function incrementCount() {
    let newCount = count + countBy;
    setCount(newCount);
  }

  function decrementCount() {
    let newCount = count - countBy;
    setCount(newCount);
  }

  return (
    <div>
      <div>
        <button className="counterButton" onClick={() => incrementCount()}>
          + {countBy}
        </button>
        <button className="counterButton" onClick={() => decrementCount()}>
          - {countBy}
        </button>
      </div>
    </div>
  );
};
