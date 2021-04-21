package HW10;

public final class Manager extends BaseEmployee {

	private int quantityEmployies;

	public Manager(String employeeName, int employeeAge, char employeeSex, double employeeSalaryOnDay,
			int quantityEmployies, Month[] monthsArr) {
		
		super(employeeName, employeeAge, employeeSex, employeeSalaryOnDay, monthsArr);
		this.quantityEmployies = quantityEmployies;
		this.monthsArr = monthsArr;
	}
	@Override
	public double getSalary(Month[] monthArray) {
		int allWorkDays = 0;
		for (int i = 0; i < monthArray.length; i++) {
			allWorkDays = allWorkDays + monthArray[i].getWorkDays();
		}

		double sum = allWorkDays * getEmployeeSalaryOnDay();

		return sum + 0.01 * (sum) * quantityEmployies;

	}

	public void printer() {
		System.out.println(getEmployeeName() + "|" + getEmployeeAge() + "|" + getEmployeeSex() + "|"
				+ getEmployeeSalaryOnDay() + "|" + getQuantityEmployies() + "|" + getSalary(monthsArr));
	}

	public int getQuantityEmployies() {
		return quantityEmployies;
	}

	public void setQantityEmployies(int qantityEmployies) {
		this.quantityEmployies = qantityEmployies;
	}

}
