package HW11;

public class Worker extends Employee {

	public Worker(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
		System.out.println(super.getName() + " (Worker)|" + super.getBaseSalary() + "|" + this.getSalary());

	}

	@Override
	public int getSalary() {
		return 0;
	}
}
