import React from 'react';
import {Button, Checkbox, Col, Form, Input, message, Row} from 'antd';
import axios from 'axios';
import {Redirect} from "react-router-dom";

export default class LoginComponent extends React.Component {
    constructor(props) {
        super(props);

        /* css */
        this.styleWrapForm = {
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            height: '95vh',
        };
        this.formStyle = {
            width: '500px',
            border: '1px solid lightGray',
            borderRadius: '3px',
            padding: '30px 30px 5px 30px',
        };

        /* state */
        this.state = {
            formLayout: 'vertical',
            redirectStatus: false,
        };

        /* bind function */
        this.loginAction = this.loginAction.bind(this);
        this.onSubmitSuccess = this.onSubmitSuccess.bind(this);
        this.onSubmitFailed = this.onSubmitFailed.bind(this);
        this.redirectToProduct = this.redirectToProduct.bind(this);
    }

    /* Function */
    loginAction = () => {
        console.log("fuck you");
    };

    redirectToProduct = () => {
        return <Redirect to='/home'/>
    };

    onSubmitSuccess = async (values) => {
        console.log('Success:', values);
        const formData = new FormData();
        formData.append("username", values.username);
        formData.append("password", values.password);
        axios({
            method: 'POST',
            url: 'http://localhost:8080/api/checkLogin',
            responseType: 'json',
            data: formData
        }).then(response => {
            switch (response.data.status) {
                case '200':
                    document.cookie = "accessToken=" + response.data.data
                        + ";max-age=" + 30 * 24 * 60 * 60;
                    document.cookie = "username=john.smith";
                    this.setState({redirectStatus: true}, () => {
                        message.success('Login success');
                    });
                    break;
                case '400':
                    message.warning('Couldn\'t find your Account');
                    this.setState({redirectStatus: false});
                    break;
                case '500':
                    message.error('Login error');
                    this.setState({redirectStatus: false});
                    break;
                default:
                    this.setState({redirectStatus: false});
                    break;
            }
        }).catch(error => {
            console.error(error);
        });
    };

    onSubmitFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    render() {
        if (this.state.redirectStatus) {
            return this.redirectToProduct();
        }
        const formItemLayout =
            this.state.formLayout === 'vertical'
                ? {
                    labelCol: {
                        span: 8,
                    },
                    wrapperCol: {
                        span: 24,
                    },
                }
                : null;
        const buttonItemLayout =
            this.state.formLayout === 'vertical'
                ? {
                    wrapperCol: {
                        span: 24,
                        offset: 0,
                    },
                }
                : null;
        return (
            <div className="row">
                <div className="col-md-12" style={this.styleWrapForm}>
                    <Form
                        {...formItemLayout}
                        style={this.formStyle}
                        layout={this.state.formLayout}
                        initialValues={{
                            layout: this.state.formLayout,
                            remember: true
                        }}
                        onFinish={this.onSubmitSuccess}
                        onFinishFailed={this.onSubmitFailed}
                    >
                        <Form.Item
                            label="Username"
                            name="username"
                            rules={[
                                {
                                    required: true,
                                    message: 'Please input your username!',
                                },
                            ]}
                        >
                            <Input onChange={this.handleChange}/>
                        </Form.Item>
                        <Form.Item
                            label="Password"
                            name="password"
                            rules={[
                                {
                                    required: true,
                                    message: 'Please input your password!',
                                },
                            ]}
                        >
                            <Input.Password/>
                        </Form.Item>
                        <Row>
                            <Col span={12}>
                                <Form.Item name="remember" valuePropName="checked" {...formItemLayout}>
                                    <Checkbox>Remember me</Checkbox>
                                </Form.Item>
                            </Col>
                            <Col span={12}>
                                <Form.Item name="remember" valuePropName="checked" {...formItemLayout}>
                                    <a className="login-form-forgot" href="#" style={{float: 'right'}}>
                                        Forgot password
                                    </a>
                                </Form.Item>
                            </Col>
                        </Row>
                        <Form.Item {...buttonItemLayout}>
                            <Button type="primary" htmlType="submit" style={{width: '100%'}}>
                                Login
                            </Button>
                            <span style={{paddingTop: '5px', display: 'block'}}>
                                Or <Button type="link" onClick={() => this.loginAction()} style={{padding: '0',}}>
                                register now!
                            </Button>
                            </span>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        );
    }
}