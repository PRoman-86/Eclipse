//класс Автомобиль
public class Car {
	
	
   public void start() {
	   System.out.println ("Starting");
   }
   
   public void stop() {
	   System.out.println ("Stopping");
   }
   
   public int drive(int howlong) {
	   int distance=howlong*60;
	   
	   return distance;
   }
   
}
