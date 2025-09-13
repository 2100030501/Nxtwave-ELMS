import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css"; // keep styles separately

function Navbar() {
  return (
    <nav className="navbar">
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/register">Register</Link></li>
        <li><Link to="/admins">Admin</Link></li>
        <li><Link to="/managers">Manager</Link></li>
        <li><Link to="/employees">Employee</Link></li>
        <li><Link to="/statuses">Status</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;

