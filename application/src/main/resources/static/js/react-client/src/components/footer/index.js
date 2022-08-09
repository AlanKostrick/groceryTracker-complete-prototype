import React from 'react';
import style from './style.module.scss';

const Footer = () => {
    return (
        <div className={style.footer}>
            <small> &copy; codelaborators 2022</small>
            <ul className={style.socialList}>
                <li>GitHub</li>
                <li>LinkedIn</li>
            </ul>
        </div>
    )
}

export default Footer;