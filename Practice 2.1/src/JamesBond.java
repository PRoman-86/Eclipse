//вызывающий класс подкласса JamesBondCar
public class JamesBond {

	public static void main(String[] args) {
		JamesBondCar ownCar = new JamesBondCar();
		
        ownCar.start();
		
		int rasstoyanie; 
		rasstoyanie=ownCar.drive(5);
		
		int vremya;
		vremya=rasstoyanie/180;
		
	System.out.println("I drive "+rasstoyanie+" kilometrov za "+vremya+" hours, My name is Bond. James Bond.");
		
		ownCar.stop();

	}

}
