import AppRouter from './components/app-router';
import { BrowserRouter } from 'react-router-dom';
import Footer from './components/footer';
import Header from './components/header';
import React from 'react';
import style from './style.module.scss';

const App = () => {
  return (
    // JSX (JavaScript and XML)
    <div>
      <BrowserRouter>
        <Header />
        <div className={style.page} >
          <AppRouter />
        </div>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
