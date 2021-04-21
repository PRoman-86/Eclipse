import java.util.Date;

public class Score {

	 private String firstName;
	 private String lastName;
	 private int score;
	 private Date playDate;
	 /*
	  ƒобавл€ем, согласно заданию, конструктор, содержащий четыре аргумента,
	  передающих данные переменным, вместо четырех сеттеров. —еттеры
	  закомментим, чтобы нагл€дно были видны изменени€ в коде.
	  */
	 Score(String firstName, String lastName, int score, Date playDate) {
		 this.firstName=firstName;
		 this.lastName=lastName;
		 this.score=score;
		 this.playDate=playDate;
	 }
	 
	 public String getFirstName() {
	 return firstName;
	 }
	 
	 //public void setFirstName(String firstName) {
	 //this.firstName = firstName;
	 //}
	 
	 public String getLastName() {
	 return lastName;
	 }
	 
	 //public void setLastName(String lastName) {
	 //this.lastName = lastName;
	 //}
	 
	 public int getScore() {
	 return score;
	 }
	 
	 //public void setScore(int score) {
	 //this.score=score;
	 //}
	 
	 public Date getPlayDate() {
	 return playDate;
	 }
	 
	 //public void setPlayDate(Date playDate) {
	 //this.playDate=playDate;
	 //}
	 
	// ќбъедин€ем все атрибуты в строку (String)
	// и в конце добавл€ем символ перевода на новую строку.
	// Ётот метод удобно использовать, если вызывающий класс
	// хочет за один раз распечатать все значени€, например
	// System.out.println(myScore.toString());
	 
	 public String toString() {
	 String scoreString = firstName + " " +
	 lastName + " " + score + " " + playDate +
	 System.getProperty("line.separator"); //переводит курсор(каретку) на новую строку
	 return scoreString;
	 }
	}