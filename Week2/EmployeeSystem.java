// Employee class
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

// EmployeeManagement class
class EmployeeManagement {
    Employee[] employees;
    int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee e) {
        if (size < employees.length) {
            employees[size++] = e;
        } else {
            System.out.println("Array full, cannot add more employees.");
        }
    }

    // Search Employee by ID
    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    // Traverse Employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                employees[i] = employees[size - 1]; // Replace with last
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

// Main driver class
public class EmployeeSystem {
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        em.addEmployee(new Employee(2, "Bob", "Developer", 55000));
        em.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        System.out.println("All Employees:");
        em.traverseEmployees();

        System.out.println("\nSearch Employee with ID 2:");
        System.out.println(em.searchEmployee(2));

        System.out.println("\nDeleting Employee with ID 1...");
        em.deleteEmployee(1);

        System.out.println("\nEmployees after deletion:");
        em.traverseEmployees();
    }
}
