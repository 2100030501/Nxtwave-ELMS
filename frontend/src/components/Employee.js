import React, { useEffect, useState } from 'react';

const API_BASE_URL = process.env.REACT_APP_API_URL;

function Employee() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/employees`)
      .then((response) => response.json())
      .then(setData)
      .catch((error) => console.error('API error:', error));
  }, []);

  return (
    <div style={styles.wrapper}>
      <h2 style={styles.heading}>Employee List</h2>

      <table style={styles.table}>
        <thead>
          <tr>
            <th style={styles.th}>Employee ID</th>
            <th style={styles.th}>Name</th>
            <th style={styles.th}>Request Status</th>
            <th style={styles.th}>Manager ID</th>
            <th style={styles.th}>Manager Name</th>
          </tr>
        </thead>
        <tbody>
          {data.length === 0 ? (
            <tr>
              <td colSpan="5" style={styles.tdCenter}>Loading...</td>
            </tr>
          ) : (
            data.map((employee) => (
              <tr key={employee.eid}>
                <td style={styles.td}>{employee.eid}</td>
                <td style={styles.td}>{employee.ename}</td>
                <td style={styles.td}>
                  <span
                    style={{
                      ...styles.reqBadge,
                      backgroundColor: employee.ereq ? '#4CAF50' : '#f44336'
                    }}
                  >
                    {employee.ereq ? 'Requested' : 'Not Requested'}
                  </span>
                </td>
                <td style={styles.td}>{employee.managerId}</td>
                <td style={styles.td}>{employee.managerName}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

const styles = {
  wrapper: {
    padding: '40px',
    fontFamily: 'Arial, sans-serif',
  },
  heading: {
    textAlign: 'center',
    marginBottom: '30px',
  },
  table: {
    width: '100%',
    borderCollapse: 'collapse',
    boxShadow: '0 2px 8px rgba(0, 0, 0, 0.1)',
  },
  th: {
    backgroundColor: '#673ab7',
    color: 'white',
    padding: '12px',
    textAlign: 'left',
    border: '1px solid #ddd',
  },
  td: {
    padding: '12px',
    border: '1px solid #ddd',
    textAlign: 'left',
  },
  tdCenter: {
    padding: '12px',
    border: '1px solid #ddd',
    textAlign: 'center',
    color: '#888',
  },
  reqBadge: {
    padding: '4px 10px',
    borderRadius: '12px',
    color: 'white',
    fontWeight: 'bold',
    fontSize: '0.85rem',
    display: 'inline-block',
    minWidth: '110px',
    textAlign: 'center',
  },
};

export default Employee;
