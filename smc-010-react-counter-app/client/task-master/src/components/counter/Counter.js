import React, { useState } from 'react';
import './counter.css';
import { CounterButton } from './CounterButton';

export const Counter = () => {
  const [count, setCount] = useState(0);

  const resetCount = () => {
    setCount(0);
  };

  return (
    <div>
      <span className="count">{count}</span>
      <CounterButton count={count} countBy={1} setCount={setCount} />
      <CounterButton count={count} countBy={2} setCount={setCount} />
      <CounterButton count={count} countBy={5} setCount={setCount} />
      <button className="reset-button" onClick={() => resetCount()}>
        Reset
      </button>
    </div>
  );
};
