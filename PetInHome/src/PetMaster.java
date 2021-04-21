//вызывающий класс хоз€ина домашнего животного
public class PetMaster {

	public static void main(String[] args) {
		String petReaction;
		Pet myPet=new Pet();
		myPet.eat();
		petReaction=myPet.say("Myaaaaay");
		System.out.println(petReaction);
		myPet.sleep();

	}
}
