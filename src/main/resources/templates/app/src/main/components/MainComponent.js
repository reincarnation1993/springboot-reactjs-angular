import React from "react";
import {Link, Route, Switch} from "react-router-dom";
import {Avatar, Breadcrumb, Dropdown, Layout, Menu, message} from "antd";
import {DesktopOutlined, LaptopOutlined, NotificationOutlined, PieChartOutlined, UserOutlined} from "@ant-design/icons";
import ProductListComponent from "./product/ProductListComponent";
import DashBoardComponent from "./dashboard/DashboardComponent";

const {SubMenu} = Menu;
const {Header, Content, Sider} = Layout;

const menu = (
    <Menu onClick={handleMenuClick} className="dropdownSetting">
        <Menu.Item key="1">
            <UserOutlined/>
            1st menu item
        </Menu.Item>

        <hr/>

        <Menu.Item key="2">
            <UserOutlined/>
            2nd menu item
        </Menu.Item>

        <Menu.Item key="3">
            <UserOutlined/>
            3rd item
        </Menu.Item>
    </Menu>
);

function handleMenuClick(e) {
    message.info("Click on menu item.");
    console.log("click", e);
}

export default class MainComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            collapsed: false,
            tabSelected: this.props.defaultSelectedKeys
        };
    }

    render() {
        return (
            <Layout
                style={{
                    minHeight: "100vh"
                }}
            >
                <Header className="header">
                    <div
                        className="logo"
                        style={{
                            float: "left",
                            width: "150px"
                        }}
                    >
            <span
                style={{
                    fontFamily: "'Libre Barcode 128 Text', cursive",
                    color: "#e6e6e6",
                    fontSize: "45px"
                }}
            >
              pharmacy
            </span>
                    </div>

                    <Menu
                        theme="dark"
                        mode="horizontal"
                        defaultSelectedKeys={["2"]}
                        style={{
                            lineHeight: "64px"
                        }}
                    >
                        <Menu.Item key="1">nav 1</Menu.Item>

                        <Menu.Item key="2">nav 2</Menu.Item>

                        <Menu.Item key="3">nav 3</Menu.Item>

                        <Menu.Item key="4">nav 4</Menu.Item>

                        <div
                            style={{
                                float: "right"
                            }}
                        >
                            <Dropdown overlay={menu} trigger={["click"]}>
                                <a
                                    className="ant-dropdown-link"
                                    onClick={e => e.preventDefault()}
                                >
                                    <Avatar
                                        className="avatarSetting"
                                        shape="square"
                                        size="large"
                                        icon={<UserOutlined/>}
                                    />
                                </a>
                            </Dropdown>
                        </div>
                    </Menu>
                </Header>

                <Layout>
                    <Sider width={200} className="site-layout-background">
                        <Menu
                            mode="inline"
                            defaultSelectedKeys={this.state.tabSelected}
                            defaultOpenKeys={["sub1"]}
                            style={{
                                height: "100%",
                                borderRight: 0
                            }}
                        >
                            <Menu.Item key="13">
                                <PieChartOutlined/>

                                <span>Option 1</span>
                            </Menu.Item>

                            <Menu.Item key="14">
                                <DesktopOutlined/>

                                <span>Option 2</span>
                            </Menu.Item>

                            <SubMenu
                                key="sub1"
                                title={
                                    <span>
                    {" "}
                                        <UserOutlined/>
                    subnav 1{" "}
                  </span>
                                }
                            >
                                <Menu.Item key="1">
                                    <Link className="linkStyles " to="/home">
                                        Dashboard
                                    </Link>
                                </Menu.Item>

                                <Menu.Item key="2">
                                    <Link className="linkStyles" to="/products">
                                        Products
                                    </Link>
                                </Menu.Item>

                                <Menu.Item key="3">option3</Menu.Item>

                                <Menu.Item key="4">option4</Menu.Item>
                            </SubMenu>

                            <SubMenu
                                key="sub2"
                                title={
                                    <span>
                    {" "}
                                        <LaptopOutlined/>
                    subnav 2{" "}
                  </span>
                                }
                            >
                                <Menu.Item key="5">option5</Menu.Item>

                                <Menu.Item key="6">option6</Menu.Item>

                                <Menu.Item key="7">option7</Menu.Item>

                                <Menu.Item key="8">option8</Menu.Item>
                            </SubMenu>

                            <SubMenu
                                key="sub3"
                                title={
                                    <span>
                    {" "}
                                        <NotificationOutlined/>
                    subnav 3{" "}
                  </span>
                                }
                            >
                                <Menu.Item key="9">option9</Menu.Item>

                                <Menu.Item key="10">option10</Menu.Item>

                                <Menu.Item key="11">option11</Menu.Item>

                                <Menu.Item key="12">option12</Menu.Item>
                            </SubMenu>
                        </Menu>
                    </Sider>

                    <Layout
                        style={{
                            padding: "0 24px 24px"
                        }}
                    >
                        <Breadcrumb
                            style={{
                                margin: "16px 0"
                            }}
                        >
                            <Breadcrumb.Item>Home</Breadcrumb.Item>

                            <Breadcrumb.Item>List</Breadcrumb.Item>

                            <Breadcrumb.Item>App</Breadcrumb.Item>
                        </Breadcrumb>

                        <Content
                            className="site-layout-background"
                            style={{
                                padding: 24,
                                margin: 0,
                                minHeight: 280
                            }}
                        >
                            <Switch>
                                <Route path="/home" component={DashBoardComponent}/>

                                <Route path="/products" component={ProductListComponent}/>
                            </Switch>
                        </Content>
                    </Layout>
                </Layout>
            </Layout>
        );
    }
}