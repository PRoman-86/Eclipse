public class Fish extends Pet {
	
 int currentDepth=0;
 final int DEFAULT_DIVING = 5;
 
 public int dive(){
 currentDepth=currentDepth + DEFAULT_DIVING;
 if (currentDepth > 100){
 System.out.println("Я маленькая рыбка и " +
 " не могу нырять глубже 100 метров");
 currentDepth=currentDepth - DEFAULT_DIVING;
 }else{
 System.out.println("Погружаюсь на " +
 DEFAULT_DIVING + " м");
 System.out.println("Я на " + currentDepth +
" метров ниже уровня моря");
 }
return currentDepth;
}
 
 public int dive(int howDeep){
 currentDepth=currentDepth + howDeep;
 if (currentDepth > 100){
 System.out.println("Я маленькая рыбка и " +
 " не могу нырять глубже 100 метров");
 currentDepth=currentDepth - howDeep;
 }else{
 System.out.println("Погружаюсь на "+howDeep+" м.");
 System.out.println("Я на " + currentDepth +
 " м. ниже уровня моря");
 }
return currentDepth;
}
 
 public String say(String something) {
	 System.out.println("*пускает пузыри*");
	 return "Ты не знаешь, что рыбы не умеют говорить?";
	}
 public void eat() {
	 System.out.println("*рыбка всосала червячка*");
 }
 
	// constructor
  public Fish(int startingPosition){
	currentDepth=startingPosition;
	 }
  /*
   Согласно заданию, добавляем перегруженный конструктор без
   аргументов, и устанавливаем значение переменной currentDepth
   равное 10, чтобы при создании объекта с пустым аргументом,
   стартовая позиция рыбки была равна 10 метрам.
   */
  public Fish() {
	  currentDepth=10;
  }
  
	 }