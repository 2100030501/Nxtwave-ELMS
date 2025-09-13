import { useState } from 'react';
import { Link } from 'react-router-dom';

function Statuses() {
  const [adminId, setAdminId] = useState('');
  const [managerId, setManagerId] = useState('');
  const [employeeId, setEmployeeId] = useState('');

  const buttonStyle = {
    backgroundColor: "#f44336",
    color: "white",
    padding: "10px 20px",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer",
    textDecoration: "none",
    display: "inline-block",
    textAlign: "center",
    marginTop: "10px"
  };

  const inputStyle = {
    padding: "8px",
    margin: "10px",
    borderRadius: "5px",
    border: "1px solid #ccc"
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Statuses</h2>

      <div>
        <input
          type="number"
          placeholder="Enter Admin ID"
          value={adminId}
          onChange={(e) => setAdminId(e.target.value)}
          style={inputStyle}
        />
        <br />
        <Link to={`/statuses/admin/${adminId || 1}`} style={buttonStyle}>
          Admin Status
        </Link>
      </div>

      <div>
        <input
          type="number"
          placeholder="Enter Manager ID"
          value={managerId}
          onChange={(e) => setManagerId(e.target.value)}
          style={inputStyle}
        />
        <br />
        <Link to={`/statuses/manager/${managerId || 1}`} style={buttonStyle}>
          Manager Status
        </Link>
      </div>

      <div>
        <input
          type="number"
          placeholder="Enter Employee ID"
          value={employeeId}
          onChange={(e) => setEmployeeId(e.target.value)}
          style={inputStyle}
        />
        <br />
        <Link to={`/statuses/employee/${employeeId || 1}`} style={buttonStyle}>
          Employee Status
        </Link>
      </div>
    </div>
  );
}

export default Statuses;
