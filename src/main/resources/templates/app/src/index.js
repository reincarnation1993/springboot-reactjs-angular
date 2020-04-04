import React from 'react';
import ReactDOM from 'react-dom';
import './assets/css/index.css';
import App from './App';
import {BrowserRouter} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
import 'popper.js/dist/umd/popper.min';
import 'bootstrap/dist/js/bootstrap.min';

const AppRouter =
    <BrowserRouter>
        <App/>
    </BrowserRouter>;

ReactDOM.render(AppRouter, document.getElementById('root'));
