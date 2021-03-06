package HW10;

public final class Employee extends BaseEmployee {

	public Employee(String employeeName, int employeeAge, char employeeSex, double employeeSalaryOnDay,
			Month[] monthsArr) {
		super(employeeName, employeeAge, employeeSex, employeeSalaryOnDay, monthsArr);

	}

	@Override
	public double getSalary(Month[] monthArray) {
		int allWorkDays = 0;
		for (int i = 0; i < monthArray.length; i++) {
			allWorkDays = allWorkDays + monthArray[i].getWorkDays();
		}

		return allWorkDays * getEmployeeSalaryOnDay();

	}

	public void printer() {
		System.out.println(getEmployeeName() + "|" + getEmployeeAge() + "|" + getEmployeeSex() + "|"
				+ getEmployeeSalaryOnDay() + "|" + getSalary(monthsArr));
	}
	@Override
	public String getEmployeeName() {
		return employeeName;
	}
	@Override
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public int getEmployeeAge() {
		return employeeAge;
	}
	@Override
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	@Override
	public char getEmployeeSex() {
		return employeeSex;
	}
	@Override
	public void setEmployeeSex(char employeeSex) {
		this.employeeSex = employeeSex;
	}
	@Override
	public double getEmployeeSalaryOnDay() {
		return employeeSalaryOnDay;
	}
	@Override
	public void setEmployeeSalaryOnDay(double employeeSalaryOnDay) {
		this.employeeSalaryOnDay = employeeSalaryOnDay;
	}

}
