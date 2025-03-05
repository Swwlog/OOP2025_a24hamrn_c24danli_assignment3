package assignment3;

import java.util.ArrayList;

public class CoffeMachine implements Runnable{
private ArrayList<HotDrink> coffeReserv;
private HotDrink hotdrink;
	
	public CoffeMachine(){
		this.coffeReserv = new ArrayList<HotDrink>();
		Thread thr4 = new Thread(this);
		thr4.start();
	}
	
	//public void makeDrink() throws InterruptedException {
		
		
	
	
	public String getDrinkName(int index)
	{
		return coffeReserv.get(index).GetCoffeName();
	}
	public int getReserveSize() {
		return coffeReserv.size();
	}
	public HotDrink getDrinkEnergy()
	{
		return coffeReserv.getFirst();
}

	@Override
	public void run() {
		for(;;) {
			while(coffeReserv.size() < 20) {
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				int rand =(int) (Math.random() * (4-1)) + 1;
				hotdrink = new HotDrink(rand);
				coffeReserv.add(hotdrink);
				System.out.println(hotdrink.GetCoffeName()+" created. Coffe Machine has "+ getReserveSize()+" drinks in reserve.");
		}
		
	}
}
}