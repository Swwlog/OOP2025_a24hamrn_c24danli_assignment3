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
	}// work

	public void addWorkerToCoffeQue(Worker worker) {
		coffeQue.add(worker);
	}

	public void removeFromQueue(Worker worker) {
		coffeQue.remove(worker);
	}

	public Worker getFirstPerson() {
		return coffeQue.peek();

	}
	
	public ConcurrentLinkedQueue getList(){
		return coffeQue;
	}

	@Override
	public void run() {
		for (;;) {

			if (coffeQue.size() > 0 && coffeMachine.getReserveSize() > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				if (coffeQue.peek() != null) {

					coffeQue.peek().DrinkCoffe(coffeMachine.getDrinkEnergy().getEnergy());
					coffeMachine.removeFirstDrink();
					System.out.println(coffeMachine.getReserveSize() + " drinks left in machine");
					if (coffeQue.peek().getEnergy() < 100) {
						coffeQue.offer(coffeQue.remove());
					} else {
						System.out.println(coffeQue.peek().GetName() + " needs to go to work");
						addWorkerToCoffeQue(coffeQue.poll());
						// add to work list
						coffeQue.remove(coffeQue.peek());

					}
				}
			}

		}
	}
}