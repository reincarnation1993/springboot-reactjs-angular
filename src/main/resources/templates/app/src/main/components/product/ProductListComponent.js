import React from 'react';
import axios from "axios";
import {Table} from "antd";
import GetCookieByNameService from "../../services/GetCookieByNameService";

const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        render: text => <a>{text}</a>,
        width: 150,
    },
    {
        title: 'Key',
        dataIndex: 'key',
        key: 'age',
        width: 80,
    },
    {
        title: 'Address',
        dataIndex: 'address',
        key: 'address 1',
        ellipsis: true,
    },
];

export default class ProductListComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
        };
    }

    componentDidMount() {
        let jwtToken = GetCookieByNameService.getCookie('accessToken');
        console.log(jwtToken);
        axios({
            method: 'GET',
            url: 'http://localhost:8080/api/products',
            responseType: 'json',
            headers: {
                Authorization: `Bearer ${jwtToken}`,
            }
        }).then(response => {
            switch (response.data.status) {
                case '200':
                    this.setState({products: response.data.data});
                    break;
                case '400':
                    break;
                case '500':
                    break;
                default:
                    break;
            }
        }).catch(error => {
            console.error(error)
        });
    }

    render() {
        return (
            <main>
                <Table columns={columns} dataSource={this.state.products}/>
            </main>
        );
    }
}