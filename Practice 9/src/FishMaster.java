public class FishMaster {
	
 public static void main(String[] args) {
 
//Согласно заданию, создаем экземпляр объекта класса Fish
//без аргументов. В этом случае рыбка начнет с 10 метров
 Fish myFish = new Fish();
 
 myFish.dive(2); //рыбка ныряет на 2 метра глубже
 myFish.dive(); //рыбка ныряет на 5 метров глубже
 myFish.dive(97); //рыбка ныряет на 97 метров глубже
 myFish.dive(3); //рыбка ныряет на 3 метра глубже
 myFish.eat(); //кормим рыбку
 myFish.say("Я бешеная маленькая рыбка!"); //рыбка говорит
 myFish.sleep(); //рыбка спит 
 
 }
}