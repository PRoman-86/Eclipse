public class FishMaster {
	
 public static void main(String[] args) {
 
//�������� �������, ������� ��������� ������� ������ Fish
//��� ����������. � ���� ������ ����� ������ � 10 ������
 Fish myFish = new Fish();
 
 myFish.dive(2); //����� ������ �� 2 ����� ������
 myFish.dive(); //����� ������ �� 5 ������ ������
 myFish.dive(97); //����� ������ �� 97 ������ ������
 myFish.dive(3); //����� ������ �� 3 ����� ������
 myFish.eat(); //������ �����
 myFish.say("� ������� ��������� �����!"); //����� �������
 myFish.sleep(); //����� ���� 
 
 }
}