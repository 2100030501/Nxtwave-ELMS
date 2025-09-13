import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Statuses from '../Statuses';

const API_BASE_URL = process.env.REACT_APP_API_URL;

function EmployeeStatus() {
  const { eid } = useParams(); // dynamic employee id
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/statuses/employee/${eid}`)
      .then((response) => response.json())
      .then((data) => setData(data))
      .catch((error) => console.error('API error:', error));
  }, [eid]);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Employee Status</h2>
      <Statuses />

      {data.length > 0 ? (
        <table
          style={{
            margin: "20px auto",
            borderCollapse: "collapse",
            width: "95%",
            boxShadow: "0px 4px 8px rgba(0,0,0,0.1)"
          }}
        >
          <thead style={{ backgroundColor: "#f44336", color: "white" }}>
            <tr>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Status ID</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Manager Status</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Employee Request</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Requested Date</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Employee ID</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Employee Name</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Manager ID</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Manager Name</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Admin ID</th>
              <th style={{ border: "1px solid #ddd", padding: "10px" }}>Admin Name</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item, idx) => (
              <tr
                key={idx}
                style={{
                  backgroundColor: idx % 2 === 0 ? "#f9f9f9" : "#fff"
                }}
              >
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.sid}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.mstatus}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.ereqText}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.requestedDate}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.empId}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.empName}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.managerId}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.managerName}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.adminId}</td>
                <td style={{ border: "1px solid #ddd", padding: "10px" }}>{item.adminName}</td>
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

export default EmployeeStatus;
