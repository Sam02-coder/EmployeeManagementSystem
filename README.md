# Employee Management System

## Description

A simple console-based Java application to manage employee information.
You can **add, view, update, delete, search, and sort employees**.
It uses **MySQL** as a database to store employee records.

---

## Features

* **Add** new employee (Name, Department, Salary)
* **View** all employees
* **Update** employee information
* **Delete** employee
* **Search** employee by name or department
* **Sort** employees by name or salary

---

## Technologies Used

* **Java (Core Java)**
* **JDBC (Java Database Connectivity)**
* **MySQL (Database)**
* **Eclipse IDE (Development)**

---

## Database Setup

1. Install **MySQL Server**.
2. Create a database:

```sql
CREATE DATABASE employee_db;
```

3. Create a table:

```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);
```

4. Update database credentials in **DBConnection.java**.

---

## How to Run

1. Open the project in **Eclipse IDE**.
2. Run **EmployeeManagementApp.java**.
3. Follow the console menu to perform operations.

---

## Sample Output

```
===== Employee Management System =====
1. Add Employee
2. View All Employees
3. Update Employee
4. Delete Employee
5. Search Employee
6. Sort Employees
7. Exit
Enter your choice: 2

--- Employee List ---
1 | John Doe | IT | 50000.0

===== Employee Management System =====
Enter your choice: 7
Exiting... 👋
```
