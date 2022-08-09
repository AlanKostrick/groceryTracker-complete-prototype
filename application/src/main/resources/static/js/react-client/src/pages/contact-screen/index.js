import React from 'react';
import phoneIcon from '../../assets/contact.png';

const ContactScreen = () => {
    return (
        <div>
            <img src={phoneIcon} alt='phone icon' />
            <h2>Contact Us</h2>
            <article>
                <h4>Contact Us Today!</h4>
                <p>(555) 555-5555</p>
            </article>
        </div>
    );
}

export default ContactScreen;