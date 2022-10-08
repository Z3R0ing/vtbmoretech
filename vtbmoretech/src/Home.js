import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import Service from './service/Service';

import './css/pages/lk.css'

import menu from './image/menu.svg'
import rect from './image/rect.svg'

const service = new Service();

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            kitchens: []
        };
    }


    async componentDidMount() {
        // await service.getKitchensHome()
        //     .then(response => {
        //         this.setState({ kitchens: response });
        //         console.log(response);
        //     })
    }

    render() {
        return (
            <div>

                <div class="row justify-content-center background-color-notification my-3">
                    <article class="px-4 py-2">
                        Какое-то событие проходит сегодня с 15:00 до 18:00
                    </article>
                </div>

                <div class="container">
                    <div class="card my-5 background-color-card">
                        <div class="row no-gutters">
                            <div class="col-4 col-flex justify-content-center">
                                <img src={rect} class="px-3 py-3 img-achivements" />
                            </div>
                            <div class="col-8">
                                <div class="card-body">
                                    <div class="row mb-3">
                                        <div class="col-md-11 text-left">
                                            <h2 class="card-title">Иванов Иван Иванович</h2>
                                            <h6>Developer</h6>
                                        </div>
                                        <div class="col-md">
                                            <img src={menu} />
                                        </div>
                                    </div>

                                    <div class="row justify-content-start mb-4">
                                        <div class="col-5 col-card-count">
                                            <div class="row">
                                                <div class="col col-card-count-in">
                                                    <p class="card-count">Всего NFT</p>
                                                </div>
                                                <div class="col col-card-count-in">
                                                    <p class="card-count">628</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-5 col-card-count">
                                            <div class="row">
                                                <div class="col col-card-count-in">
                                                    <p class="card-count">Монеток</p>
                                                </div>
                                                <div class="col col-card-count-in">
                                                    <p class="card-count">25</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row row-cols-6">
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                        <div class="col mb-4">
                                            <div class="card border-primary">
                                                <div class="card-body text-success">
                                                    <img src={rect} class="img-achivements" />
                                                </div>
                                                <div class="card-footer bg-transparent border-primary">Имя</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center text-center">
                        <h2 class="mb-0 col-md-12">Мои NFT</h2>
                        <div class="row justify-content-center my-nfts my-3">
                            <div class="col-md-2 px-0 mx-3 mb-3 card">
                                <img class="card-img-top" src={rect}/>
                                <div class="card-body">
                                    <p class="card-text">Card title</p>
                                </div>
                            </div>
                            <div class="col-md-2 px-0 mx-3 mb-3 card">
                                <img class="card-img-top" src={rect}/>
                                <div class="card-body">
                                    <p class="card-text">Card title</p>
                                </div>
                            </div>
                            <div class="col-md-2 px-0 mx-3 mb-3 card">
                                <img class="card-img-top" src={rect}/>
                                <div class="card-body">
                                    <p class="card-text">Card title</p>
                                </div>
                            </div>
                            <div class="col-md-2 px-0 mx-3 mb-3 card">
                                <img class="card-img-top" src={rect}/>
                                <div class="card-body">
                                    <p class="card-text">Card title</p>
                                </div>
                            </div>
                            <div class="col-md-2 px-0 mx-3 mb-3 card">
                                <img class="card-img-top" src={rect}/>
                                <div class="card-body">
                                    <p class="card-text">Card title</p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        )
    }
}

export default Home;