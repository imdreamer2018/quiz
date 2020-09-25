import React, {Component} from 'react';
import Header from "./Header/Header";
import Products from "./Products/Products";
import Footer from "./Footer/Footer";
import {Route} from "react-router-dom";

class Shop extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <Header/>
        <Route exact path="/" component={Products}/>
        <Footer/>
      </div>
    )
  }
}

export default Shop;
