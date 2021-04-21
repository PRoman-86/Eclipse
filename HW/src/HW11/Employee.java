package HW11;

public abstract class Employee {

	protected int numberOfSubordinates;
	protected String name;
	protected double baseSalary;
	protected double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public abstract int getSalary();

}
