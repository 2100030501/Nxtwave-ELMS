import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Statuses from '../Statuses';

const API_BASE_URL = process.env.REACT_APP_API_URL;

function AdminStatus() {
  const { aid } = useParams(); // dynamic admin id
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`${API_BASE_URL}/statuses/admin/${aid}`)
      .then((res) => res.json())
      .then((resp) => {
        // Normalize response to array (handles single object or array)
        const items = Array.isArray(resp) ? resp : (resp ? [resp] : []);
        setData(items);
      })
      .catch((error) => console.error('API error:', error));
  }, [aid]);

  return (
    <div style={{ textAlign: "center", marginTop: "40px" }}>
      <h2>Admin Status</h2>
      <Statuses />

      {data.length > 0 ? (
        <table style={{
          margin: "18px auto",
          borderCollapse: "collapse",
          width: "92%",
          maxWidth: "1200px",
          boxShadow: "0 6px 18px rgba(0,0,0,0.08)",
          fontFamily: "Arial, sans-serif"
        }}>
          <thead style={{ backgroundColor: "#f44336", color: "#fff" }}>
            <tr>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Admin ID</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Admin Name</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Employee ID</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Employee Name</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Request Text</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Manager ID</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Manager Name</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Manager Status</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Requested Date</th>
              <th style={{ border: "1px solid #e0e0e0", padding: "10px 12px", textAlign: "left" }}>Status ID</th>
            </tr>
          </thead>

          <tbody>
            {data.map((item, idx) => (
              <tr key={idx} style={{ backgroundColor: idx % 2 === 0 ? "#fafafa" : "#ffffff" }}>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.adminId ?? item.aid ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.adminName ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.empId ?? item.employeeId ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.empName ?? item.employeeName ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.ereqText ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.managerId ?? item.mid ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.managerName ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.mstatus ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.requestedDate ?? "-"}</td>
                <td style={{ border: "1px solid #eee", padding: "10px 12px" }}>{item.sid ?? "-"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p style={{ marginTop: 24 }}>No statuses found for admin <strong>{aid}</strong>.</p>
      )}
    </div>
  );
}

export default AdminStatus;
