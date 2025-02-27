package assignment3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika {
	private ConcurrentLinkedQueue coffeQue;
	private ArrayList<Worker> workList;

	public Fika() {

		workList = new ArrayList<Worker>();
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker("karl");
			worker.run();
			workList.add(worker);
			System.out.println(worker.GetName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

}
