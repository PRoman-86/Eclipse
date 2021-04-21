
public class CarOwner {

	public static void main(String[] args) {
		Car ownCar=new Car();
		ownCar.start();
		int way;
		way=ownCar.drive(5);
		int time=way/60;
		System.out.println("I am driving with speed 60km/h "+way+" during the "+time+" hours");
		
		ownCar.stop();
}
}