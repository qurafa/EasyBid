import React, { Component } from 'react';

class App extends Component {
  state = {
    auctionItems: []
  };

  async componentDidMount() {
    const response = await fetch('/auction/items');
    const body = await response.json();
    this.setState({auctionItems: body});
  }

  render() {
    const {auctionItems} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
              <h2>AuctionItems</h2>
              {auctionItems.map(item =>
                  <div key={item.id}>
                    {item.name} {item.description} {item.price} {item.auctionType}
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;

// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;
