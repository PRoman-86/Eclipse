package HW10;

public abstract class BaseEmployee {

	protected String employeeName;
	protected int employeeAge;
	protected char employeeSex;
	protected double employeeSalaryOnDay;
	protected Month[] monthsArr;

	public BaseEmployee(String employeeName, int employeeAge, char employeeSex, double employeeSalaryOnDay,
			Month[] monthsArr) {
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeSex = employeeSex;
		this.employeeSalaryOnDay = employeeSalaryOnDay;
		this.monthsArr = monthsArr;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public char getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(char employeeSex) {
		this.employeeSex = employeeSex;
	}

	public double getEmployeeSalaryOnDay() {
		return employeeSalaryOnDay;
	}

	public void setEmployeeSalaryOnDay(double employeeSalaryOnDay) {
		this.employeeSalaryOnDay = employeeSalaryOnDay;
	}

	public Month[] getMonthsArr() {
		return monthsArr;
	}

	public void setMonthsArr(Month[] monthsArr) {
		this.monthsArr = monthsArr;
	}

	double getSalary(Month[] monthArray) {
		// TODO Auto-generated method stub
		return 0;
	}

}
