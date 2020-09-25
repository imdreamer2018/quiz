import React, {Component} from 'react';
import {Link} from "react-router-dom";
import './Product.css';

class Product extends Component {

  render() {
    return (
        <div id="product" className="card">
          <img id="product-img" src={this.props.product.imgLink}  className="card-img-top" alt="calculator"/>
          <div className="card-body">
            <h5 className="card-title">{this.props.product.name}</h5>
            <p className="card-text">单价：{this.props.product.price}/{this.props.product.unit}</p>
            <Link className="btn btn-primary" to="/calculator">点击前往</Link>
          </div>
        </div>
    )
  }
}

export default Product;
