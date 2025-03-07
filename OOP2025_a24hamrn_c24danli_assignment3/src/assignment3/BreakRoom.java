package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BreakRoom implements Runnable {

	private ConcurrentLinkedQueue<Worker> coffeQue;
	private CoffeMachine coffeMachine;
	private int simulationSpeed;

	public BreakRoom(int simulationSpeed) {
		coffeQue = new ConcurrentLinkedQueue<Worker>();
		this.simulationSpeed = simulationSpeed;
		coffeMachine = new CoffeMachine(simulationSpeed);
		Thread thr3 = new Thread(this);
		thr3.start();
	}// work

	public void addWorkerToCoffeQue(Worker worker) {
		if (worker == null)
			return;
		coffeQue.add(worker);
	}

	public void removeFromQueue(Worker worker) {
		coffeQue.remove(worker);
	}

	public ConcurrentLinkedQueue getList() {
		return coffeQue;
	}

	@Override
	public void run() {
		for (;;) {

			if (coffeQue.size() > 0 && coffeMachine.getReserveSize() > 0) {
				try {
					Thread.sleep(1000 / simulationSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}
				if (coffeQue.peek() != null) {

					coffeQue.peek().drinkCoffe(coffeMachine.getDrinkEnergy().getEnergy());
					coffeMachine.removeFirstDrink();
					System.out.println(coffeMachine.getReserveSize() + " drinks left in machine");
					coffeQue.offer(coffeQue.remove());
				}
			}
		}
	}
}
