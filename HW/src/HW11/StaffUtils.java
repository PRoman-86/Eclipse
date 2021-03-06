package HW11;

public class StaffUtils {

	public static String searchByName(IEmployee[] employeeArr, String searchName) {
		for (int i = 0; i < employeeArr.length; i++) {
			if (employeeArr[i].getName().equals(searchName))
				return employeeArr[i].getName();
		}

		return "Not Found";
	}

	public static String searchBySubstringName(IEmployee[] employeeArr, String searchSubName) {
		int index;
		for (int i = 0; i < employeeArr.length; i++) {
			index = employeeArr[i].getName().indexOf(searchSubName);
			if (index > 0)
				return employeeArr[i].getName();
		}

		return "Not Found";
	}

	public static double salariesSum(IEmployee[] employeeArr) {
		double sum = 0;
		for (int i = 0; i < employeeArr.length; i++) {
			sum = sum + employeeArr[i].getSalary();
		}

		return sum;
	}

	public static double lowestWage(IEmployee[] employeeArr) {
		double minValue = Double.MAX_VALUE;
		for (int i = 0; i < employeeArr.length; i++) {
			if (minValue > employeeArr[i].getSalary())
				minValue = employeeArr[i].getSalary();
		}

		return minValue;
	}

	public static double highestWage(IEmployee[] employeeArr) {
		double maxValue = Double.MIN_VALUE;
		for (int i = 0; i < employeeArr.length; i++) {
			if (maxValue < employeeArr[i].getSalary())
				maxValue = employeeArr[i].getSalary();
		}

		return maxValue;
	}

	public static int minManagers(Manager[] managerArr) {
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < managerArr.length; i++) {
			if (minValue > managerArr[i].getNumberOfSubordinates())
				minValue = managerArr[i].getNumberOfSubordinates();
		}

		return minValue;
	}

	public static int maxManagers(Manager[] managerArr) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < managerArr.length; i++) {
			if (maxValue < managerArr[i].getNumberOfSubordinates())
				maxValue = managerArr[i].getNumberOfSubordinates();
		}

		return maxValue;
	}

	public static double maxPremiumForManagers(Manager[] managerArr) {
		double maxValue = Double.MIN_VALUE;
		double currentDifference;
		for (int i = 0; i < managerArr.length; i++) {
			currentDifference = managerArr[i].getSalary() - managerArr[i].getBaseSalary();
			if (maxValue < currentDifference)
				maxValue = currentDifference;
		}

		return maxValue;
	}

	public static double minPremiumForManagers(Manager[] managerArr) {
		double minValue = Double.MAX_VALUE;
		double currentDifference;
		for (int i = 0; i < managerArr.length; i++) {
			currentDifference = managerArr[i].getSalary() - managerArr[i].getBaseSalary();
			if (minValue > currentDifference)
				minValue = currentDifference;
		}

		return minValue;
	}

}
