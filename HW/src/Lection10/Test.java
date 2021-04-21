package Lection10;

public class Test {

    public static void main(String[] args) {

        Employee a = new Employee("Jane", "Engineer", 80000);
        Employee b = new Employee("Mary", "Senior Engineer", 110000);
        Employee c = new Employee("Mike", "Sales Manager", 100000);

        Employee[] employees = {a, b, c};

        int salarySum = Salary.getSum(employees);
        System.out.println("Sum of salaries of employees: " +salarySum);
    }
}
