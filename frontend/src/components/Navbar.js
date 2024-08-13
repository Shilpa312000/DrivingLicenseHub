import React from 'react';
import { Link } from 'react-router-dom';
import './Assests/logo.png'
import './Navbar.css'; // Import CSS for styling

function Navbar() {
  return (
    <div>
    <nav className="navbar">
      <div className="navbar-container">
        <Link to="/" className="navbar-logo"><img src="logo.png"></img></Link>
        <ul className="navbar-menu">
          <li className="navbar-item">
            <Link to="/" className="navbar-link">Home</Link>
          </li>
          <li className="navbar-item">
            <Link to="/login" className="navbar-link">Login</Link>
          </li>
          <li className="navbar-item">
            <Link to="/applicationform" className="navbar-link">ApplicationForm</Link>
          </li>
        </ul>
      </div>
    </nav>
    </div>
  );
}

export default Navbar;
