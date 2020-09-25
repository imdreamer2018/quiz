import React from 'react';
import './App.css';
import Shop from "./components/Shop/Shop";
import {BrowserRouter} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Shop/>
      </BrowserRouter>
    </div>
  );
}

export default App;
