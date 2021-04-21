//вызывающий класс ’оз€ин јвтомобил€
public class CarOwner {

	public static void main(String[] args) {
		
		Car ownCar=new Car();
		
		ownCar.start();
		
		int rasstoyanie; 
		rasstoyanie=ownCar.drive(5);
		
		int vremya;
		vremya=rasstoyanie/60;
		
	System.out.println("I drive "+rasstoyanie+" kilometrov za "+vremya+" hours");
		
		ownCar.stop();
		

	}

}
