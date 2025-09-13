import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
//import React, { useEffect, useState } from "react";

import Navbar from "./components/Navbar";
import Register from "./components/Register";
import Home from "./components/Home";
import Admin from "./components/Admin";
import Employee from "./components/Employee";
import Manager from "./components/Manager";
import Statuses from "./components/Statuses";
import EmployeeStatus from "./components/Statuses/EmployeeStatus";
import ManagerStatus from "./components/Statuses/ManagerStatus";
import AdminStatus from "./components/Statuses/AdminStatus";

//const API_BASE_URL = process.env.REACT_APP_API_URL;

function App() {
 

  //onsole.log(data);

  return (
    <Router>
      <div>
        {/* Debug API output */}
        {/* <pre>{JSON.stringify(data, null, 2)}</pre> */}

        <Navbar />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/about" element={<h2>About Page</h2>} />
          <Route path="/managers" element={<Manager />} />
          <Route path="/admins" element={<Admin />} />
          <Route path="/employees" element={<Employee />} />
          
          {/* Statuses Main Page */}
          <Route path="/statuses" element={<Statuses />} />

          {/* Dynamic routes with IDs */}
          <Route path="/statuses/employee/:eid" element={<EmployeeStatus />} />
          <Route path="/statuses/manager/:mid" element={<ManagerStatus />} />
          <Route path="/statuses/admin/:aid" element={<AdminStatus />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
