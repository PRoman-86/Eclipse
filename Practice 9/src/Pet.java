//�������� ��������
public class Pet {
	
  int age;
  float weight;
  float height;
  
  public void sleep() {
	  System.out.println ("*��������*");
  }
  
  public void eat() {
      System.out.println ("� ���� ����, ��� ��� ������!");
  }

  public String say (String aWord) { 
      String petResponse="Okay!"+aWord;
  return petResponse;
  }
}