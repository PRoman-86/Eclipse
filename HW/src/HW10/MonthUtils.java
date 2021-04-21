package HW10;

public class MonthUtils {

	public static Month[] utilMethod(String[] namesMonthArray) {

		Month[] monthArray = new Month[namesMonthArray.length];

		for (int i = 0; i < namesMonthArray.length; i++) {

			switch (namesMonthArray[i].toString()) {

			case "January":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 15);
				break;

			case "February":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 28, 14);
				break;

			case "March":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 15);
				break;

			case "April":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 30, 13);
				break;

			case "May":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 15);
				break;

			case "June":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 30, 14);
				break;

			case "July":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 14);
				break;

			case "August":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 15);
				break;

			case "September":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 30, 14);
				break;

			case "October":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 15);
				break;

			case "November":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 30, 13);
				break;

			case "December":
				monthArray[i] = new Month(namesMonthArray[i].toString(), 31, 14);
				break;

			default:
				new Month();

			}
		}

		return monthArray;

	}

	public static Month[] getQarter(Month[] monthArray) {
		Month[] threeMonths = new Month[2];
		for (int i = 0; i < threeMonths.length; i++) {
			monthArray[i] = threeMonths[i];
		}
		return threeMonths;
	}
	
	public static Month[] getHalfYear(Month[] monthArray) {
		Month[] sixMonths = new Month[5];
		for (int i = 0; i < sixMonths.length; i++) {
			monthArray[i] = sixMonths[i];
		}
		return sixMonths;
	}
	
	public static Month[] getYear(Month[] monthArray) {
		Month[] twelveMonths = new Month[11];
		for (int i = 0; i < twelveMonths.length; i++) {
			monthArray[i] = twelveMonths[i];
		}
		return twelveMonths;
	}
	
	

}
