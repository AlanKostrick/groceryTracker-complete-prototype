import React, { useEffect, useState } from 'react';

import Axios from 'axios';
import style from './style.module.scss';

const GroceryListScreen = () => {

  const [loadingList, setLoadingList] = useState(true),
    [list, setList] = useState(null);

  const [cartTotal, setCartTotal] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const result = await Axios('http://localhost:8080/list-items');
      console.log(result);
      setList(result.data);
    }

    if (list) {
      setLoadingList(false);
    }



    const timer = setTimeout(() => {
      !list && fetchData();
    }, 10);
    return () => clearTimeout(timer);

    // eslint-disable-next-line
  }, [list]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await Axios('http://localhost:8080/list-items/total-price');
      console.log(result);
      setCartTotal(result.data);
    }

    fetchData();

  }, [cartTotal, list]);

  const handleDelete = (itemId) => {
    Axios.delete(`http://localhost:8080/list-items/${itemId}/delete-item`).then((response) => {
      console.log('Delete successful');
      console.log('DATA', response.data);
      setList(response.data);
    });
  }

  const handleSelectUpdate = (item) => {
    console.log('ITEM', item);
    const userData = {
      name: item.itemName,
      isSelected: !item.selected
    }
    Axios.put(`http://localhost:8080/list-items/${item.id}/select-item`, userData).then((response) => {
      console.log('Update successful');
      console.log('DATA', response.data);
      setList(response.data);
    });
  }


  return (
    <div>
      <h2>My Grocery List</h2>
      {loadingList ? <h3>Loading ...</h3> :
        <div>
          <h2>Perishable Items</h2>
          <ul className={style.itemsContainer}>
            {list.map(item => (
              <div key={item.id}>
                <h3 className={item.selected ? style.selected : null} onClick={() => handleSelectUpdate(item)}>{item.name}</h3>
                <p>Subtotal: {item.subTotal}</p>
                <button onClick={() => handleDelete(item.id)}>x</button>
              </div>
            ))}
          </ul>
        </div>
      }
      <h2>Cart Total: {cartTotal} </h2>
    </div>
  );
}

export default GroceryListScreen;