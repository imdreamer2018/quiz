import React, {Component} from 'react';

class AddProduct extends Component {
  url= "http://localhost:8080/products";
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      price: 0,
      unit: '',
      imgLink: '',
    };
  }

  handleFiledChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    });
  };

  async postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      mode: 'cors', // no-cors, *cors, same-origin
      cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
      credentials: 'same-origin', // include, *same-origin, omit
      headers: {
        'Content-Type': 'application/json'
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: 'follow', // manual, *follow, error
      referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: JSON.stringify(data) // body data type must match "Content-Type" header
    }); // parses JSON response into native JavaScript objects
    return response.json();
  }

  handleFormSubmit = (e) => {
    e.preventDefault();
    this.postData(this.url, this.state)
      .then((response) => {
          console.log(response);
          if (response.code === 201) {
            alert("添加成功")
          }
          else {
            return Promise.reject(response.message);
          }
        }
      )
      .catch((error) => {
        alert(error);
      });
  };

  render() {
    return (
      <div className="container">
        <h1>添加商品</h1>
        <form onSubmit={this.handleFormSubmit}>
          <div className="form-group">
            <label htmlFor="name">名称：</label>
            <input
              type="text"
              className="form-control"
              id="name"
              placeholder = "商品名称"
              value={this.state.name}
              onChange={(e) => {this.handleFiledChange("name", e)}}
            />
          </div>
          <div className="form-group">
            <label htmlFor="name">价格：</label>
            <input
              type="text"
              className="form-control"
              id="name"
              placeholder = "商品价格"
              value={this.state.price}
              onChange={(e) => {this.handleFiledChange("price", e)}}
            />
          </div>
          <div className="form-group">
            <label htmlFor="name">单位：</label>
            <input
              type="text"
              className="form-control"
              id="name"
              placeholder = "商品单位"
              value={this.state.unit}
              onChange={(e) => {this.handleFiledChange("unit", e)}}
            />
          </div>
          <div className="form-group">
            <label htmlFor="name">图片：</label>
            <input
              type="text"
              className="form-control"
              id="name"
              placeholder = "URL"
              value={this.state.imgLink}
              onChange={(e) => {this.handleFiledChange("imgLink", e)}}
            />
          </div>

          <div className="form-group">
            <input
              id="profileSubmit"
              type="submit"
              className="btn btn-primary "
              value="Submit"
              disabled={!this.state.name || !this.state.price || !this.state.unit || !this.state.imgLink}
            />
          </div>

        </form>
      </div>
    )
  }
}

export default AddProduct;
