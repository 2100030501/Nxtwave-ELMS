DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS managers;
DROP TABLE IF EXISTS admins;

CREATE TABLE admins (
    aid INT PRIMARY KEY AUTO_INCREMENT,
    aname VARCHAR(100) NOT NULL
);

CREATE TABLE managers (
    mid INT PRIMARY KEY AUTO_INCREMENT,
    mname VARCHAR(100) NOT NULL,
    mstatus VARCHAR(50),
    aid INT,
    CONSTRAINT fk_manager_admin FOREIGN KEY (aid) REFERENCES admins(aid)
);

CREATE TABLE employees (
    eid INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(100) NOT NULL,
    ereq BOOLEAN,
    mid INT,
    CONSTRAINT fk_employee_manager FOREIGN KEY (mid) REFERENCES managers(mid)
);

CREATE TABLE statuses (
    sid INT PRIMARY KEY AUTO_INCREMENT,
    eid INT NOT NULL,
    mid INT NOT NULL,
    aid INT,
    mstatus VARCHAR(50),
    ereq_text VARCHAR(255),
    requested_date DATE,
    CONSTRAINT fk_status_employee FOREIGN KEY (eid) REFERENCES employees(eid),
    CONSTRAINT fk_status_manager FOREIGN KEY (mid) REFERENCES managers(mid),
    CONSTRAINT fk_status_admin FOREIGN KEY (aid) REFERENCES admins(aid)
);
