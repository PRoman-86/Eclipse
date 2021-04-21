/*
¬ задании требуетс€ объ€вить метод convertGrades() как статический и удалить строку
инициализации класса из метода main(), что € и сделал.

¬ итоге программа работает корректно, даже без создани€ экземпл€ра класса ReportCard
в пам€ти. ¬ывод: использу€ ключевое слово static при объ€влении метода, не об€зательно создавать
экземпл€р класса ReportCard rc=new ReportCard(), чтобы использовать метод в дальнейшем.
 */

public class ReportCard {
    public static char convertGrades (int testResult) {
    	char grade;
    	
    	if (testResult>=90) {
    		grade='A'; }
    		
    		else if (testResult>=80 && testResult<90) {
    		grade='B'; }
    		else if (testResult>=70 && testResult<80) {
    		grade='C'; }
    		else {grade='D';}
    		
    	return grade;
    }
	
	
	public static void main(String[] args) {
		
		char yourGrade=convertGrades(88);
		System.out.println("Ivanov - "+yourGrade);
		
		     yourGrade=convertGrades(23);
		System.out.println("Petrov - "+yourGrade);
		
		     yourGrade=convertGrades(95);
		System.out.println("Suvorova - "+yourGrade);

	}
}
