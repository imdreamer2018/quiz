import React, {Component} from 'react';
import {Link} from "react-router-dom";

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="navbar-nav">
          <Link className="nav-link active" to="/">商城 <span className="sr-only">(current)</span></Link>
          <Link className="nav-link" to="/order">订单</Link>
          <Link className="nav-link" to="/add-product">添加商品</Link>
        </div>
      </nav>
    )
  }
}

export default Header;
