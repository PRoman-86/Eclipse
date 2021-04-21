//домашнее животное
public class Pet {
	
  int age;
  float weight;
  float height;
  
  public void sleep() {
	  System.out.println ("*засыпает*");
  }
  
  public void eat() {
      System.out.println ("Я хочу есть, дай мне чипсов!");
  }

  public String say (String aWord) { 
      String petResponse="Okay!"+aWord;
  return petResponse;
  }
}