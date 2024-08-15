import React from "react";
import './Header.css';

const Header = () => {
  return (
    <header>
      <div className="logo">
        <img src="https://lsrinfracon.com/wp-content/uploads/2022/12/morth-logo.png" alt="Driving License Hub Logo" />
      </div>
      <div className="title" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center',color:'black' }}>
        {/* <h1 style={{ fontFamily: 'Arial, sans-serif', fontWeight: 'bold', fontSize: '2em', color: '#007bff' }}>
          DRIVING LICENSE HUB
        </h1> */}
        <h1 style={{ fontFamily: 'Arial, sans-serif', fontWeight: 'bold', fontSize: '2em', color:'black' }}>
          DRIVING LICENSE HUB
        </h1>
      </div>
    </header>
  );
};

export default Header;




