package assignment3;

import java.util.ArrayList;

public class CoffeMachine {
private ArrayList<HotDrink> coffeReserv;
private HotDrink hotdrink;
	
	public CoffeMachine(){
		this.coffeReserv = new ArrayList<HotDrink>();
	}
	
	public void makeDrink() throws InterruptedException {
		
		while(coffeReserv.size() < 20) {
			
			int rand =(int) (Math.random() * (4-1)) + 1;
			hotdrink = new HotDrink(rand);
			coffeReserv.add(hotdrink);
			System.out.println(hotdrink.GetCoffeName());
			Thread.sleep(2000); // Maby change
		}
	}
	
	public String getDrink(int index)
	{
		return coffeReserv.get(index).GetCoffeName();
	}
}
