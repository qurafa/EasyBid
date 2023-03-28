import React, { Component } from 'react';
import { Container, Table } from 'reactstrap';
//import { withRouter } from 'react-router-dom'

class AuctionItemList extends Component {

    constructor(props) {
        super(props);
        this.state = {items: [], searchTitle : ""};
        this.onChangeSearchTitle = this.onChangeSearchTitle.bind(this);
    }

    componentDidMount() {
        //const { id } = ;
        console.log(this.props.match.params.id);
        // if(id == null)
        //     console.log(null);
        // else
        //     console.log(id.params.id);

        fetch('/auction/'+this.props.match.params.id);

        fetch('/auction/items')
            .then(response => response.json())
            .then(data => this.setState({items: data}));
        
    }

    onChangeSearchTitle(e) {
        const searchTitle = e.target.value;
    
        this.setState({
          searchTitle: searchTitle
        });

        fetch('/auction//items?query=' + this.state.searchTitle)
            .then(response => response.json())
            .then(data => this.setState({items: data}));
            
        this.render();//trigerring re-rendering of the system
    }

    render() {
        const {items, searchTitle} = this.state;

        const itemList = items.map(item => {
            return <tr key={item.id}>
                <td style={{whiteSpace: 'nowrap'}}>{item.name}</td>
                <td>{item.description}</td>
                <td>{item.price}</td>
                <td>{item.price}</td>
                <td>{item.auctionType}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Auction Items</h3>
                    <input
                        type="text"
                        className="form-control"
                        placeholder=""
                        value={searchTitle}
                        onChange={this.onChangeSearchTitle}/>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="10%">Name</th>
                            <th width="20%">Description</th>
                            <th width="5%">Start Price</th>
                            <th width="5%">Current Price</th>
                            <th width="20%">Auction Type</th>
                        </tr>
                        </thead>
                        <tbody>
                        {itemList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

// function searchBar () 
// {
//     const [searchInput, setSearchInput] = useState("");
   
//    const handleChange = (e) => {
//      e.preventDefault();
//      setSearchInput(e.target.value);
//    };
   
// //    if (searchInput.length > 0) {
// //        countries.filter((country) => {
// //        return country.name.match(searchInput);
// //    });
// //    }
   
//    return <div>
   
//    <input
//       type="search"
//       placeholder="Search here"
//       onChange={handleChange}
//       value={searchInput} />
//    </div>
   
   
// };

export default AuctionItemList;