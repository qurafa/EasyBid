import React, { useEffect, useState } from 'react'
import { Container, Row, Col, Card, Table } from 'react-bootstrap'
import { get } from '../service/AuctionItemsService'




const AuctionItems = () => {


    const [auctionItems, setAuctionItems] = useState([])


    const getAuctionItems = () => {
        get("/items")
            .then(res => {
                console.log(res.data)
                setAuctionItems(res.data)
            })
            .catch(err => console.log(err))
    }


    useEffect(() => {

        getAuctionItems() // called the method each time when the page is loaded

    }, [])




    console.log(employees)

    return (
        <>

            <Container>
                <Row>
                    <Col>
                        <Card>
                            <Card.Header>Item List</Card.Header>
                            <Card.Body>
                                <Table striped bordered hover size="sm">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Description</th>
                                            <th>Price</th>
                                            <th>Auction Type</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {
                                            auctionItems?.map(auctionItems => {
                                                return (
                                                    <tr key={auctionItems.id}>
                                                        <td>{auctionItems.name}</td>
                                                        <td>{auctionItems.description}</td>
                                                        <td>{auctionItems.price}</td>
                                                        <td>{auctionItems.auctiontype}</td>
                                                    </tr>
                                                )
                                            })
                                        }
                                    </tbody>
                                </Table>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>



        </>
    )
}

export default AuctionItems
