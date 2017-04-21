package com.appx;

public interface Flyable {
	int i=100;
	void fly();

}

interface Eatable{
	void eat();
}

interface FlyEat extends Flyable , Eatable{
	
}
abstract class MyCar{
	
	abstract void fiy();
	
}

//#2 加上 abstract 
abstract class YourCar extends MyCar{
	//public void fiy(){} #1
}
