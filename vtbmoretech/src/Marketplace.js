import React, { Component } from 'react';
import Service from './service/Service';

import './css/pages/mp.css'

import arrow from './image/arrow.svg'
import rect from './image/rect.svg'

const service = new Service();

class Marketplace extends Component {

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
                    <div class="row row-list">
                        <nav class="nav-list mb-3">
                            <div class="nav nav-tabs justify-content-center" id="nav-tab" role="tablist">
                                <a class="nav-link active px-5" id="nav-achivements-tab" data-toggle="tab" href="#nav-achivements"
                                    role="tab" aria-controls="nav-achivements" aria-selected="true">
                                    Товары
                                </a>
                                <a class="nav-link px-5" id="nav-nft-tab" data-toggle="tab" href="#nav-nft" role="tab"
                                    aria-controls="nav-nft" aria-selected="false">
                                    NFT
                                </a>
                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-achivements" role="tabpanel"
                                aria-labelledby="nav-achivements-tab">
                                <div class="col-3">
                                    <div class="card mb-3">
                                        <div class="row row-cat">
                                            <button onclick="rotate('pointerType')" class="btn col-md-10" type="button"
                                                data-toggle="collapse" data-target="#collapseType" aria-expanded="true"
                                                aria-controls="collapseType">
                                                <div class="row">
                                                    <div class="col-md-9 col-9 colPadding">
                                                        <p class="nameCategory">Категории</p>
                                                    </div>
                                                    <div class="col-md-2 col colPadding">
                                                        <img class="pointer" src={arrow} name="pointerType" />
                                                    </div>
                                                </div>
                                            </button>
                                        </div>
                                        <div class="row offset-md-2 mb-3">
                                            <div class="collapse show" id="collapseType">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="catRadio" id="catRadio1"
                                                        value="Футболки" />
                                                    <label class="form-check-label" for="catRadio1">Футболки</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="catRadio" id="catRadio2"
                                                        value="Шарфы" />
                                                    <label class="form-check-label" for="catRadio2">Шарфы</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="catRadio" id="catRadio3"
                                                        value="Кофе" />
                                                    <label class="form-check-label" for="catRadio3">Кофе</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="catRadio" id="catRadio4"
                                                        value="Тренинги" />
                                                    <label class="form-check-label" for="catRadio4">Тренинги</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="catRadio" id="catRadio5"
                                                        value="Скидки на курсы" />
                                                    <label class="form-check-label" for="catRadio5">Скидки на курсы</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row justify-content-center">
                                            <div class="col-8 col-button-update-category mb-3">
                                                <button id="buttonUpdate">
                                                    Обновить
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="nav-nft" role="tabpanel" aria-labelledby="nav-nft-tab">
                                <div class="card mb-3">
                                    <div class="row no-gutters row-achivements">
                                        <div class="col-1">
                                            <img src={rect} class="img-achivements" />
                                        </div>
                                        <div class="col-7">
                                            <div class="card-body">
                                                <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                                <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив
                                                    бек</small>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="card-body">
                                                <p class="card-text"><small class="text-muted">Дата получения 08 окт 2022 в
                                                    11:21</small></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card mb-3">
                                    <div class="row no-gutters row-achivements">
                                        <div class="col-1">
                                            <img src={rect} class="img-achivements" />
                                        </div>
                                        <div class="col-7">
                                            <div class="card-body">
                                                <h5 class="card-title">Кто-нибудь, поставьте бек</h5>
                                                <p class="card-text"><small class="text-muted">Выиграйте хакатон, заложив
                                                    бек</small>
                                                </p>
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

export default Marketplace;