package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BreakRoom {

	private ConcurrentLinkedQueue<Worker> coffeQue;
	private int simulationSpeed;

	public BreakRoom() {
		coffeQue = new ConcurrentLinkedQueue<Worker>();
	}

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

	{
	}
}
