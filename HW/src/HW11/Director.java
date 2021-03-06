package HW11;

public final class Director extends Employee {

	private final int PREMIUM_RATE = 9;

	public Director(String name, double baseSalary, int numberOfSubordinates) {
		this.name = name;
		this.numberOfSubordinates = numberOfSubordinates;
		this.baseSalary = baseSalary;

		System.out.println(super.getName() + " (Director)|" + super.getBaseSalary() + "|" + this.getSalary());
	}

	public int getNumberOfSubordinates() {
		return numberOfSubordinates;
	}

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
