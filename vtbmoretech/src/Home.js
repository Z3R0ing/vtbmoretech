import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import Service from './service/Service';

// import offer_image from './image/offer-image2.png';
// import time from './image/time.png'
// import talk from './image/talk.png'
// import help from './image/help.png'

const offer_image = "fwfweg";
const time = "fwfweg";
const talk = "fwfweg";
const offhelper_image = "fwfweg";

const recipesService = new Service();

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            kitchens: []
        };
    }


    async componentDidMount() {
        // await recipesService.getKitchensHome()
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
                    <img src="../image/rect.svg" alt="..." class="px-3 py-3 img-achivements"/>
                </div>
                <div class="col-8">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-11">
                                <h5 class="card-title">Иванов Иван Иванович</h5>
                                <p class="">
                                    Developer
                                </p>
                            </div>
                            <div class="col">
                                <img src="../image/menu.svg" alt="..."/>
                            </div>
                        </div>

                        <div class="row justify-content-start mb-4">
                            <div class="col-5 col-card-count">
                                <div class="row">
                                    <div class="col col-card-count-in">
                                        <p class="card-count">Всего ачивок</p>
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
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="card border-primary">
                                    <div class="card-body text-success">
                                        <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                                    </div>
                                    <div class="card-footer bg-transparent border-primary">Имя</div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="row row-list">
            <nav class="nav-list mb-3">
                <div class="nav nav-tabs justify-content-center" id="nav-tab" role="tablist">
                    <a class="nav-link active" id="nav-achivements-tab" data-toggle="tab" href="#nav-achivements" role="tab" aria-controls="nav-achivements" aria-selected="true">Достижения</a>
                    <a class="nav-link" id="nav-nft-tab" data-toggle="tab" href="#nav-nft" role="tab" aria-controls="nav-nft" aria-selected="false">NFT</a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-achivements" role="tabpanel" aria-labelledby="nav-achivements-tab">
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="nav-nft" role="tabpanel" aria-labelledby="nav-nft-tab">
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="row no-gutters row-achivements">
                            <div class="col-1">
                                <img src="../image/rect.svg" alt="..." class="img-achivements"/>
                            </div>
                            <div class="col-7">
                                <div class="card-body">
                                    <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                    <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив бек</small></p>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="card-body">
                                    <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в 11:21</small></p>
                                </div>
                            </div>
                        </div>
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