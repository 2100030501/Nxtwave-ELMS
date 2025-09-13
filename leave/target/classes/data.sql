-- Insert Admins
INSERT INTO admins (aname) VALUES ('Alice Johnson');
INSERT INTO admins (aname) VALUES ('Bob Williams');

-- Insert Managers (linked to Admins)
INSERT INTO managers (mname, mstatus, aid) VALUES ('Charles Brown', 'ACTIVE', 1);
INSERT INTO managers (mname, mstatus, aid) VALUES ('Diana Miller', 'ACTIVE', 1);
INSERT INTO managers (mname, mstatus, aid) VALUES ('Edward Davis', 'INACTIVE', 2);

-- Insert Employees (linked to Managers)
INSERT INTO employees (ename, ereq, mid) VALUES ('Frank Harris', TRUE, 1);
INSERT INTO employees (ename, ereq, mid) VALUES ('Grace Lee', FALSE, 1);
INSERT INTO employees (ename, ereq, mid) VALUES ('Henry Martin', TRUE, 2);
INSERT INTO employees (ename, ereq, mid) VALUES ('Ivy Nelson', FALSE, 3);

-- Insert Statuses (leave requests)
INSERT INTO statuses (eid, mid, aid, mstatus, ereq_text, requested_date)
VALUES (1, 1, 1, 'APPROVED', 'Family function leave for 2 days', '2025-09-01');

INSERT INTO statuses (eid, mid, aid, mstatus, ereq_text, requested_date)
VALUES (2, 1, NULL, 'PENDING', 'Medical leave request', '2025-09-03');

INSERT INTO statuses (eid, mid, aid, mstatus, ereq_text, requested_date)
VALUES (3, 2, 1, 'REJECTED', 'Personal leave for travel', '2025-09-05');

INSERT INTO statuses (eid, mid, aid, mstatus, ereq_text, requested_date)
VALUES (4, 3, 2, 'APPROVED', 'One day casual leave', '2025-09-07');
