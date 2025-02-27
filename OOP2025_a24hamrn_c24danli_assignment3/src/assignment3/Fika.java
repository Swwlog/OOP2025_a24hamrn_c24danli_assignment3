package assignment3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika implements Runnable {
	private ConcurrentLinkedQueue<Worker> coffeQue;
	private ArrayList<Worker> officeList;

	public Fika() {
		Thread thr2 = new Thread(this);
		thr2.start();
		officeList = new ArrayList<Worker>();
		coffeQue = new ConcurrentLinkedQueue<Worker>();
		try {
			thr2.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker(" Worker " + (i + 1));
			Thread thr1 = new Thread(worker);
			thr1.start();
			officeList.add(worker);
			// System.out.println(worker.GetName());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

	@Override
	public void run() {
		for (;;) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < officeList.size(); i++) {
				if (officeList.get(i).getEnergy() < 30) {
					System.out.println("Moved" + officeList.get(i).GetName());
					coffeQue.add(officeList.get(i));
					officeList.remove(i);
				}
			}
		}

	}

}
