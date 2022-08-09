import React, { useEffect, useState } from 'react';

import Axios from 'axios';
import style from './style.module.scss';

const HomeScreen = () => {

    const [loadingNonPerishables, setLoadingNonPerishables] = useState(true),
        [perishables, setPerishables] = useState(null),
        [loadingPerishables, setLoadingPerishables] = useState(true),
        [nonPerishables, setNonperishables] = useState(null);


    useEffect(() => {
        const fetchData = async () => {
            const result = await Axios('http://localhost:8080/perishables');
            setPerishables(result.data);
        }
        //if perishables are no longer null, loading becomes false
        if (perishables) {
            setLoadingPerishables(false);
        }


        //delay by one second and ONLY fetch when perishables are null
        const timer = setTimeout(() => {
            !perishables && fetchData(); //if perishables is NULL fetch the data 
        }, 100);
        return () => clearTimeout(timer);

        // eslint-disable-next-line
    }, [perishables]);


    // create the useEffect for the non-perishables GET REQUEST
    useEffect(() => {
        const fetchData = async () => {
            const result = await Axios('http://localhost:8080/non-perishables');
            setNonperishables(result.data);
        }
        //if non-perishables are no longer null, loading becomes false
        if (nonPerishables) {
            setLoadingNonPerishables(false);
        }


        //delay by one second and ONLY fetch when non-perishables are null
        const timer = setTimeout(() => {
            !nonPerishables && fetchData(); //if non-perishables are NULL fetch the data 
        }, 100);
        return () => clearTimeout(timer);

        // eslint-disable-next-line
    }, [nonPerishables]);

    const handleSubmit = (e, name, quantity, price) => {
        e.preventDefault();
        const userData = {
            name: name,
            subTotal: quantity * price,
            isSelected: false
        };

        Axios.post('http://localhost:8080/list-items/add-item', userData).then((response) => {
            console.log(response.status);
            console.log('DATA', response.data);
        });
    };


    return (
        <div>
            {loadingPerishables ? <h3>Loading ...</h3> :
                <div>
                    <h2>Perishable Items</h2>
                    <ul className={style.itemsContainer}>
                        {perishables.map(perishableItem => (
                            <div key={perishableItem.id}>
                                <img src={perishableItem.imageUrl} alt='' />
                                <h3>{perishableItem.name}</h3>
                                <p>Quantity: {perishableItem.quantity}</p>
                                <p>Price: {perishableItem.price}</p>
                                <p>Days to Expire: {perishableItem.daysToExpiration}</p>
                                <form onSubmit={(e) => handleSubmit(e, perishableItem.name, perishableItem.quantity, perishableItem.price)}>
                                    <button type="submit">Add to Grocery List</button>
                                </form>
                            </div>
                        ))}
                    </ul>
                </div>
            }
            {loadingNonPerishables ? <h3>Loading ...</h3> :
                <div>
                    <h2>Non-Perishable Items</h2>
                    <ul className={style.itemsContainer}>
                        {nonPerishables.map(nonPerishableItem => (
                            <div key={nonPerishableItem.id}>
                                <img src={nonPerishableItem.imageUrl} alt='' />
                                <h3>{nonPerishableItem.name}</h3>
                                <p>Quantity: {nonPerishableItem.quantity}</p>
                                <p>Price: {nonPerishableItem.price}</p>
                                <p>Days to Expire: {nonPerishableItem.daysToExpiration}</p>
                                <form onSubmit={(e) => handleSubmit(e, nonPerishableItem.name, nonPerishableItem.quantity, nonPerishableItem.price)}>
                                    <button type="submit">Add to Grocery List</button>
                                </form>
                            </div>
                        ))}
                    </ul>
                </div>
            }
        </div>
    );
}

export default HomeScreen;