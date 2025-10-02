package com.ems;

import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class EmployeeManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        int choice = 0;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Sort Employees");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) { System.out.println("❌ Name cannot be empty."); break; }

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine().trim();
                    if (dept.isEmpty()) { System.out.println("❌ Department cannot be empty."); break; }

                    System.out.print("Enter Salary: ");
                    if (!sc.hasNextDouble()) { System.out.println("❌ Invalid salary."); sc.next(); break; }
                    double salary = sc.nextDouble(); sc.nextLine();
                    if (salary <= 0) { System.out.println("❌ Salary must be > 0."); break; }

                    Employee emp = new Employee(name, dept, salary);
                    boolean added = dao.addEmployee(emp);
                    System.out.println(added ? "✅ Employee added!" : "❌ Failed to add.");
                    break;

                case 2: // View All Employees
                    List<Employee> list = dao.getAllEmployees();
                    if (list.isEmpty()) System.out.println("No employees found.");
                    else {
                        System.out.println("\n--- Employee List ---");
                        list.forEach(System.out::println);
                    }
                    break;

                case 3: // Update Employee
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    if (!dao.exists(updateId)) { System.out.println("❌ Employee not found."); break; }

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine().trim();
                    if (newName.isEmpty()) { System.out.println("❌ Name cannot be empty."); break; }

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine().trim();
                    if (newDept.isEmpty()) { System.out.println("❌ Department cannot be empty."); break; }

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble(); sc.nextLine();
                    if (newSalary <= 0) { System.out.println("❌ Salary must be > 0."); break; }

                    boolean updated = dao.updateEmployee(updateId, newName, newDept, newSalary);
                    System.out.println(updated ? "✅ Employee updated!" : "❌ Update failed.");
                    break;

                case 4: // Delete Employee
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    boolean deleted = dao.deleteEmployee(deleteId);
                    System.out.println(deleted ? "✅ Employee deleted!" : "❌ Delete failed.");
                    break;

                case 5: // Search Employee
                    System.out.println("Search by: 1.Name  2.Department");
                    int searchChoice = sc.nextInt(); sc.nextLine();
                    if (searchChoice == 1) {
                        System.out.print("Enter Name to search: ");
                        String searchName = sc.nextLine();
                        List<Employee> searchList = dao.searchByName(searchName);
                        if (searchList.isEmpty()) System.out.println("No employees found.");
                        else searchList.forEach(System.out::println);
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Department to search: ");
                        String searchDept = sc.nextLine();
                        List<Employee> searchList = dao.searchByDepartment(searchDept);
                        if (searchList.isEmpty()) System.out.println("No employees found.");
                        else searchList.forEach(System.out::println);
                    } else {
                        System.out.println("❌ Invalid choice.");
                    }
                    break;

                case 6: // Sort Employees
                    System.out.println("Sort by: 1.Name  2.Salary");
                    int sortChoice = sc.nextInt(); sc.nextLine();
                    List<Employee> sortList = dao.getAllEmployees();
                    if (sortList.isEmpty()) { System.out.println("No employees found."); break; }
                    if (sortChoice == 1) sortList.sort(Comparator.comparing(Employee::getName));
                    else if (sortChoice == 2) sortList.sort(Comparator.comparingDouble(Employee::getSalary));
                    else { System.out.println("❌ Invalid choice."); break; }
                    System.out.println("\n--- Sorted Employee List ---");
                    sortList.forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting... 👋");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
