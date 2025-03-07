package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CoffeMachine implements Runnable {
	private ConcurrentLinkedQueue<HotDrink> coffeReserv;
	private HotDrink hotdrink;
	private int simulationSpeed;

	public CoffeMachine(int simulationSpeed) {
		this.coffeReserv = new ConcurrentLinkedQueue<HotDrink>();
		this.simulationSpeed=simulationSpeed;
		Thread thr4 = new Thread(this);
		thr4.start();
	}



	public int getReserveSize() {
		return coffeReserv.size();
	}
	
	public HotDrink getFirstDrink() {
		return coffeReserv.peek();
	}
	
	public void removeFirstDrink() {
		coffeReserv.remove();
	}

	@Override
	public void run() {
		for (;;) {
			while (coffeReserv.size() < 20) {

				try {
					Thread.sleep(2000/simulationSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int rand = (int) (Math.random() * (4 - 1)) + 1;
				switch(rand) {
				case 1:
					hotdrink = new Latte();
					coffeReserv.add(hotdrink);
					System.out.println(hotdrink.getCoffeName() + " created. Coffe Machine has " + getReserveSize()
							+ " drinks in reserve.");
					System.out.println("---------------------------------------------------------------------------------");
					break;
				case 2:
					hotdrink = new Cappuccino();
					coffeReserv.add(hotdrink);
					System.out.println(hotdrink.getCoffeName() + " created. Coffe Machine has " + getReserveSize()
							+ " drinks in reserve.");
					System.out.println("---------------------------------------------------------------------------------");
					break;
				case 3:
					hotdrink = new BlackCoffe();
					coffeReserv.add(hotdrink);
					System.out.println(hotdrink.getCoffeName() + " created. Coffe Machine has " + getReserveSize()
							+ " drinks in reserve.");
					System.out.println("---------------------------------------------------------------------------------");
					break;
				}
				
				
			}

		}
	}
}