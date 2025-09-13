import React, { useEffect, useState } from 'react';

const API_BASE_URL = process.env.REACT_APP_API_URL;

function Manager() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/managers`)
      .then((response) => response.json())
      .then(setData)
      .catch((error) => console.error('API error:', error));
  }, []);

  return (
    <div style={styles.wrapper}>
      <h2 style={styles.heading}>Manager List</h2>

      <table style={styles.table}>
        <thead>
          <tr>
            <th style={styles.th}>Manager ID</th>
            <th style={styles.th}>Name</th>
            <th style={styles.th}>Status</th>
            <th style={styles.th}>Admin ID</th>
            <th style={styles.th}>Admin Name</th>
          </tr>
        </thead>
        <tbody>
          {data.length === 0 ? (
            <tr>
              <td colSpan="5" style={styles.tdCenter}>Loading...</td>
            </tr>
          ) : (
            data.map((manager) => (
              <tr key={manager.mid}>
                <td style={styles.td}>{manager.mid}</td>
                <td style={styles.td}>{manager.mname}</td>
                <td style={styles.td}>
                  <span
                    style={{
                      ...styles.status,
                      backgroundColor: manager.mstatus === 'ACTIVE' ? '#4CAF50' : '#f44336'
                    }}
                  >
                    {manager.mstatus}
                  </span>
                </td>
                <td style={styles.td}>{manager.adminId}</td>
                <td style={styles.td}>{manager.adminName}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

// ✅ CSS-in-JS styles
const styles = {
  wrapper: {
    padding: '40px',
    fontFamily: 'Arial, sans-serif'
  },
  heading: {
    textAlign: 'center',
    marginBottom: '30px'
  },
  table: {
    width: '100%',
    borderCollapse: 'collapse',
    boxShadow: '0 2px 8px rgba(0, 0, 0, 0.1)'
  },
  th: {
    backgroundColor: '#2196F3',
    color: 'white',
    padding: '12px',
    textAlign: 'left',
    border: '1px solid #ddd'
  },
  td: {
    padding: '12px',
    border: '1px solid #ddd',
    textAlign: 'left'
  },
  tdCenter: {
    padding: '12px',
    border: '1px solid #ddd',
    textAlign: 'center',
    color: '#888'
  },
  status: {
    padding: '4px 10px',
    borderRadius: '12px',
    color: 'white',
    fontWeight: 'bold',
    fontSize: '0.85rem',
    display: 'inline-block',
    minWidth: '80px',
    textAlign: 'center',
  }
};

export default Manager;
