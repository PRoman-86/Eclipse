package HW11;

public abstract class Employee implements IEmployee {

	protected int numberOfSubordinates;
	protected String name;
	protected double baseSalary;
	protected double salary;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getBaseSalary() {
		return baseSalary;
	}

	@Override
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public abstract int getSalary();

}
