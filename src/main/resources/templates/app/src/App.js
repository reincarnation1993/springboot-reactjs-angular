import React from 'react';
import './assets/css/App.css';
import MainComponent from "./main/components/MainComponent";
import LoginComponent from "./main/components/login/LoginComponent";
import {Route, Switch} from 'react-router-dom';

function MainComponentWithIndex() {
    const productIndex = ["1"];
    return <MainComponent defaultSelectedKeys={productIndex}/>;
}

function App() {
    return (
        <div className="container-fluid">
            <Switch>
                <Route exact path={["/", "/login"]} component={LoginComponent}/>
                <MainComponentWithIndex/>
            </Switch>
        </div>
    );
}

export default App;
