
public class JamesBond {

	public static void main(String[] args) {
			JamesBondCar ownCar=new JamesBondCar();
			ownCar.start();
			int way;
			way=ownCar.drive(5);
			int time=way/180;
			System.out.println("I am James Bond and I am driving with speed 180km/h "+way+" during the "+time+" hours");
			
			ownCar.stop();
	}

}
