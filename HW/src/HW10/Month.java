package HW10;

public final class Month {

	private String nameMonth;
	private int allDays;
	private int workDays;

	public Month(String nameMonth, int allDays, int workDays) {

		this.nameMonth = nameMonth;
		this.allDays = allDays;
		this.workDays = workDays;
		
	}
	
	public Month() {
		System.out.println("Incorrect Input");
	}

	public String getNameMonth() {
		return nameMonth;
	}

	public int getAllDays() {
		return allDays;
	}

	public int getWorkDays() {
		return workDays;
	}

}
