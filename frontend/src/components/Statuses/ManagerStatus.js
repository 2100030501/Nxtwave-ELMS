import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Statuses from '../Statuses';

const API_BASE_URL = process.env.REACT_APP_API_URL;

function ManagerStatus() {
  const { mid } = useParams(); // dynamic manager id
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/statuses/manager/${mid}`)
      .then((response) => response.json())
      .then((resp) => {
        const items = Array.isArray(resp) ? resp : (resp ? [resp] : []);
        setData(items);
      })
      .catch((error) => console.error('API error:', error));
  }, [mid]);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Manager Status</h2>
      <Statuses />

      {data.length > 0 ? (
        <table
          style={{
            margin: "20px auto",
            borderCollapse: "collapse",
            width: "95%",
            maxWidth: "1200px",
            boxShadow: "0px 4px 8px rgba(0,0,0,0.1)"
          }}
        >
          <thead style={{ backgroundColor: "#f44336", color: "white" }}>
            <tr>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Status ID</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Manager Status</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Request Text</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Requested Date</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Employee ID</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Employee Name</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Manager ID</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Manager Name</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Admin ID</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Admin Name</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item, idx) => (
              <tr
                key={idx}
                style={{ backgroundColor: idx % 2 === 0 ? "#f9f9f9" : "#fff" }}
              >
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.sid}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.mstatus}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.ereqText}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.requestedDate}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.empId}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.empName}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.managerId}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.managerName}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.adminId}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{item.adminName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No statuses found.</p>
      )}
    </div>
  );
}

export default ManagerStatus;
