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
                                <a class="nav-item nav-link mr-4" to="/">Главная</a>
                                <a class="nav-item nav-link mr-4" to="">Новости</a>
                                <a class="nav-item nav-link mr-4" to="">Потратить</a>
                                <a class="nav-item nav-link mr-4" to="">Заработать </a>
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

{/* <header>
    <nav className="container navbar navbar-expand-lg navbar-light ">
        <h1 className="navbar-brand title" to="">
            <img src={logo} alt="logo" />
            RecipeForAll
        </h1>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse justify-content-md-center" id="navbarNavAltMarkup">
            <div className="navbar-nav header-link">
                <Link className="nav-item nav-link" to="/">Главная</Link>
                <Link className="nav-item nav-link" to="/kitchen/all">Кухни</Link>
                <Link className="nav-item nav-link" to="/recipe/all">Рецепты</Link>
            </div>
        </div>
    </nav>
</header> */}