import React from 'react';
import { Link } from 'react-router-dom';
import '../components/Navbar'


function Home() {
  return (
    <div>
      <h1>Welcome to the Driving License Application</h1>
      <p>
        <Link to="/apply">Start Your Application</Link>
      </p>
    </div>
  );
}

export default Home;
