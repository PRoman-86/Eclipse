public class Fish extends Pet {
	
 int currentDepth=0;
 final int DEFAULT_DIVING = 5;
 
 public int dive(){
 currentDepth=currentDepth + DEFAULT_DIVING;
 if (currentDepth > 100){
 System.out.println("� ��������� ����� � " +
 " �� ���� ������ ������ 100 ������");
 currentDepth=currentDepth - DEFAULT_DIVING;
 }else{
 System.out.println("���������� �� " +
 DEFAULT_DIVING + " �");
 System.out.println("� �� " + currentDepth +
" ������ ���� ������ ����");
 }
return currentDepth;
}
 
 public int dive(int howDeep){
 currentDepth=currentDepth + howDeep;
 if (currentDepth > 100){
 System.out.println("� ��������� ����� � " +
 " �� ���� ������ ������ 100 ������");
 currentDepth=currentDepth - howDeep;
 }else{
 System.out.println("���������� �� "+howDeep+" �.");
 System.out.println("� �� " + currentDepth +
 " �. ���� ������ ����");
 }
return currentDepth;
}
 
 public String say(String something) {
	 System.out.println("*������� ������*");
	 return "�� �� ������, ��� ���� �� ����� ��������?";
	}
 public void eat() {
	 System.out.println("*����� ������� ��������*");
 }
 
	// constructor
  public Fish(int startingPosition){
	currentDepth=startingPosition;
	 }
  /*
   �������� �������, ��������� ������������� ����������� ���
   ����������, � ������������� �������� ���������� currentDepth
   ������ 10, ����� ��� �������� ������� � ������ ����������,
   ��������� ������� ����� ���� ����� 10 ������.
   */
  public Fish() {
	  currentDepth=10;
  }
  
	 }