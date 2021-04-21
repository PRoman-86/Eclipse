package Lection10;

public class Employee extends Person {

    private String title;
    private int salary;

    public Employee() {
        System.out.println("Employee 1st constructor");
    }

    public Employee(String name, String title, int salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
        System.out.println("Employee 2nd constructor");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isSameName(Employee employee) {
        return employee.getName().equals(this.name);
    }
}
