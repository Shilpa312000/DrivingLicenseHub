import React from 'react'
import { Link } from 'react-router-dom';
import '../MajorComponents/HomePage/Home.css';
import CarouselComponent from '../MajorComponents/carousel/Carousel';;

const More = () => {
    return (
        <>

            <div className="HomeContainer">
                <div className="HomeCard">
                    <img src="https://cdn-icons-gif.flaticon.com/15401/15401352.gif" alt="Service 1" />
                    <h5>User Dashboard</h5>
                    <p>USER</p>
                    <Link to="/UserDashboard" className="btn btn-primary" style={{ width: '100%', maxWidth: '100%' }}>APPLY</Link>
                </div>
                <div className="HomeCard">
                    <img src="https://cdn.shopifycdn.net/s/files/1/0218/3187/6688/files/wholesale-contact.jpg?v=1615789002" alt="Service 1" />
                    <h5>Admin Dashboard</h5>
                    <p>ADMIN</p>
                    <Link to="/AdminDashboard" className="btn btn-primary" style={{ width: '100%', maxWidth: '100%' }}>APPLY</Link>
                </div>
            </div>

            <div className='HomeContainer' style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                <CarouselComponent />
            </div>
        </>
    );
};

export default More



