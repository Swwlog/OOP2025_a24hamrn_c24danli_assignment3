package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BreakRoom implements Runnable {

	private ConcurrentLinkedQueue<Worker> coffeQue;
	private CoffeMachine coffeMachine;
	public BreakRoom() {
		coffeQue = new ConcurrentLinkedQueue<Worker>();
		coffeMachine = new CoffeMachine();
		Thread thr3 = new Thread(this);
		thr3.start();
	}
	
	
	public void addWorkerToCoffeQue(Worker worker) {
		coffeQue.add(worker);
	}
	
	
	
	
	

	@Override
	public void run() {
		for (;;) {
			
				if ( coffeQue.size() > 0 && coffeMachine.getReserveSize() > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					coffeQue.peek().DrinkCoffe(coffeMachine.getDrinkEnergy().getEnergy());
					if(coffeQue.peek().getEnergy()<100) {
						coffeQue.offer(coffeQue.remove());
					}
					else {
						addWorkerToCoffeQue(coffeQue.remove());
						
					}
					

			}

		}
	}
}