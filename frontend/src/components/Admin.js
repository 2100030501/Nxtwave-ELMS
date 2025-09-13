import React, { useEffect, useState } from 'react';
const API_BASE_URL = process.env.REACT_APP_API_URL;

function Admin() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/admins`)  // ✅ Corrected fetch syntax with backticks
      .then(response => response.json())
      .then(data => setData(data))
      .catch(error => console.error('API error:', error));
  }, []);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Admin List</h2>

      <div style={styles.container}>
        {data.length === 0 ? (
          <p>Loading...</p>
        ) : (
          data.map((admin) => (
            <div key={admin.aid} style={styles.card}>
              <h3 style={styles.name}>{admin.aname}</h3>
              <p style={styles.id}>ID: {admin.aid}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

// ✅ Inline CSS styles
const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    gap: '20px',
    flexWrap: 'wrap',
    marginTop: '30px',
  },
  card: {
    backgroundColor: '#f9f9f9',
    border: '1px solid #ddd',
    borderRadius: '8px',
    padding: '20px',
    width: '200px',
    boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
    transition: 'transform 0.2s',
  },
  name: {
    margin: '0 0 10px 0',
    color: '#333',
  },
  id: {
    margin: 0,
    color: '#555',
    fontSize: '14px',
  }
};

export default Admin;
