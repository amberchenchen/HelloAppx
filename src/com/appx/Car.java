package com.appx;


class MyPoint implements Comparable<MyPoint>{
	static int count=0;
	int x;
	int y;
	private int z;
	public String toSting(){
		return getLocation();
	}
	
	public static int getCount(){
		return count;
	}
	
	//Constructor
	MyPoint(){
		//x = y = -1;
		this(6,8);
//		hashCode();
		//System.out.println("MyPoint()");
	}
	@Override
	public int hashCode()
	{
		return 1;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return true;
	}
//	
	//帶參數建構子
	MyPoint(int i){
		x = y = i;
		//System.out.println("MyPoint(int i)");
	}
	
	MyPoint(int x,int y){
		this.x = x;
		this.y = y;
		count++;
		//print();
		//System.out.println("MyPoint(int x,int y)");
	}
	
	private void setZ(int i){
		z=i;
	}
	
	public void setX(int i){
		x=i;
	}
	
	int getX(){
		return x;
	}
	
	public void setY(int i){
		y=i;
	}
	
	int getY(){
		return y;
	}
	
	public void print(){
		System.out.println(getLocation()); 
	}
	
	public String getLocation()
	{
		return "[" + x + "," + y + "] ";
	}
	
	public String toString(){
		return getLocation();
	}

	@Override
	public int compareTo(MyPoint o) {
		if(this.x>o.x){
			return 1;
		}
		else if(this.x<o.x){
			return -1;
		}
		
		return 0;
	}
	
}

class Car {
	
	String brand;
	int eission;
	double cp;
	int speed;
	boolean hasAirbag;
	int price;
	
	void speedup(){
		speed +=10;
	}
	
	void speeddown(){
		if(speed-10<0){
			speed=0;
		}
		else{
			speed -=10;
		}
	}
	

}
