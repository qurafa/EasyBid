import 'bootstrap/dist/css/bootstrap.min.css'; 
import logo from './logo.svg';
import './App.css';
import AuctionItems from './components/auctionItems/AuctionItems';


function App() {
  return (
    <>
      <Routes>
        <Route path="/items" element={<AuctionItems/>}/>
      </Routes>
    </>
  );
}

export default App;
