import React, { Component } from 'react';
import { Link } from 'react-router-dom'

import '../css/header.css'

import logo from '../image/logo.svg'
import sign_out from '../image/user.svg';

class Header extends Component {
    render() {
        return (
            <div>
                <header class="mb-5 mt-3">
                    <nav class="container navbar navbar-expand-lg navbar-light">
                        <a class="navbar-brand title col-1" to="#">
                            <img src={logo} alt="logo" id="logo" />
                        </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-md-center" id="navbarNavAltMarkup">
                            <div class="navbar-nav header-link">
                                <Link class="nav-item nav-link mr-4" to="/">Главная</Link>
                                <Link class="nav-item nav-link mr-4" to="/">Новости</Link>
                                <Link class="nav-item nav-link mr-4" to="/mp">Потратить</Link>
                                <Link class="nav-item nav-link mr-4" to="/">Заработать </Link>
                            </div>
                        </div>
                        <div class="sign">
                            <a to="">
                                <img src={sign_out} alt="sign" />
                            </a>
                        </div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default Header;