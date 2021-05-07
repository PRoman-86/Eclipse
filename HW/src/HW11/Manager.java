package HW11;

public final class Manager extends Employee implements IManager {

	private final int PREMIUM_RATE = 3;

	public Manager(String name, double baseSalary, int numberOfSubordinates) {
		this.name = name;
		this.numberOfSubordinates = numberOfSubordinates;
		this.baseSalary = baseSalary;

		System.out.println(super.getName() + " (Manager)|" + super.getBaseSalary() + "|" + this.getSalary());
	}

	@Override
	public int getNumberOfSubordinates() {
		return numberOfSubordinates;
	}

	@Override
	public void setNumberOfSubordinates(int numberOfSubordinates) {
		this.numberOfSubordinates = numberOfSubordinates;
	}

	@Override
	public int getSalary() {
		if (this.getNumberOfSubordinates() == 0)
			return (int) this.baseSalary;
		return (int) (this.baseSalary * (this.getNumberOfSubordinates() / 100.0 * this.PREMIUM_RATE));
	}
}
