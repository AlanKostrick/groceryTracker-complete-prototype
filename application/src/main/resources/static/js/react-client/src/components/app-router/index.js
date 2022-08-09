import { Route, Switch } from 'react-router-dom';

import ContactScreen from '../../pages/contact-screen';
import GroceryListScreen from '../../pages/grocery-list-screen';
import HomeScreen from '../../pages/home-screen';
import React from 'react';

const AppRouter = () => {
    return (
        <Switch>
            <Route exact path={'/'} component={HomeScreen} />
            <Route exact path={'/contact'} component={ContactScreen} />
            <Route exact path={'/grocery-list'} component={GroceryListScreen} />
        </Switch>
    );
}

export default AppRouter;