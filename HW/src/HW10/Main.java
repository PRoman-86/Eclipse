package HW10;

public class Main {

	public static void main(String[] args) {
		
		MonthImpl utilClass = new MonthImpl();
		
		Manager man1 = new Manager("Vasya", 35, 'M', 120.5, 12, utilClass.utilMethod(new String[] {"April", "May"}));
		man1.printer();
		
		Employee emp1 = new Employee("Sveta", 25, 'F', 120.5, utilClass.utilMethod(new String[] {"April", "May"}));
		emp1.printer();

	}
}
