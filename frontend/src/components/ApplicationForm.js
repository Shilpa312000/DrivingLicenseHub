import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './ApplicationForm.module.css';

function ApplicationForm() {
  const [formData, setFormData] = useState({
    name: '',
    dateOfBirth: '',
    address: '',
    licenseType: ''
  });

  const [loading, setLoading] = useState(false); // To handle loading state
  const [error, setError] = useState(null); // To handle error state

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);

    try {
      const response = await fetch('https://your-backend-api.com/applications', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        // Optionally, you can display a success message or handle the response data
        navigate('/dashboard');
      } else {
        const errorData = await response.json();
        throw new Error(errorData.message || 'Something went wrong');
      }
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className={styles.formContainer}>
      <h2>Driving License Application Form</h2>
      <form onSubmit={handleSubmit}>
        <div className={styles.formGroup}>
          <label>Name:</label>
          <input type="text" name="name" value={formData.name} onChange={handleChange} required />
        </div>
        <div className={styles.formGroup}>
          <label>Date of Birth:</label>
          <input type="date" name="dateOfBirth" value={formData.dateOfBirth} onChange={handleChange} required />
        </div>
        <div className={styles.formGroup}>
          <label>Address:</label>
          <input type="text" name="address" value={formData.address} onChange={handleChange} required />
        </div>
        <div className={styles.formGroup}>
          <label>License Type:</label>
          <select name="licenseType" value={formData.licenseType} onChange={handleChange} required>
            <option value="">Select...</option>
            <option value="car">Car</option>
            <option value="motorcycle">Motorcycle</option>
          </select>
        </div>
        <button type="submit" disabled={loading}>
          {loading ? 'Submitting...' : 'Submit'}
        </button>
        {error && <p className={styles.error}>{error}</p>}
      </form>
    </div>
  );
}

export default ApplicationForm;
