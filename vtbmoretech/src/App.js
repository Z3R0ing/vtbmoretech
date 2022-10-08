import React, { Component } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Header from './components/Header'
import Footer from './components/Footer'

import Home from './Home'

import './App.css';
 
class App extends Component {
  render() {
    return (
        <div className="App">
            <div className="content">
					<BrowserRouter>

						<Header />

						<Routes>
							<Route exact path="/" element={<Home />} />
							{/* <Route path="/kitchen/all" element={<Kitchens />} />
							<Route path="/recipe/all" element={<Recipes />} />
							<Route path="/kitchen/:slug" element={<Kitchen />} />
							<Route path="/recipe/:slug" element={<Recipe />} /> */}
						</Routes>

						<Footer />
                        
					</BrowserRouter>
            </div>
        </div>
    );
  }
}

export default App;
