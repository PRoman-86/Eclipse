//Программа перевода результатов тестов из балльной системы в буквенную

public class ReportCard {
    public char convertGrades (int testResult) {
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
		ReportCard rc=new ReportCard ();
		
		char yourGrade=rc.convertGrades(88);
		System.out.println("Ivanov - "+yourGrade);
		
		     yourGrade=rc.convertGrades(23);
		System.out.println("Petrov - "+yourGrade);
		
		     yourGrade=rc.convertGrades(95);
		System.out.println("Suvorova - "+yourGrade);

	}
}
	
    
            	 
