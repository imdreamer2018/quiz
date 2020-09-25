import React, {Component} from 'react';
import Product from "./Product/Product";
import './Products.css';

class Products extends Component {
  url = "http://localhost:8080/products";
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    fetch(this.url)
      .then((response) => {
          if (response.ok)
            return response.clone().json();
          else
            return Promise.reject(response.statusText);
          }
      )
      .then(result => {
        console.log(result);
        this.setState({
          products: result.data,
        })
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div className={'products'}>
        {this.state.products.map((product) => (
          <Product key={product.id} product={product}/>
        ))}
      </div>
    )
  }
}

export default Products;
