package assignment3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika implements Runnable {
	private ConcurrentLinkedQueue<Worker> coffeQue;
	private ArrayList<Worker> officeList;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf","Legolas","Gimly" };
	public Fika() {
		Thread thr2 = new Thread(this);
		thr2.start();
		officeList = new ArrayList<Worker>();
		breakRoom = new BreakRoom();
		try {
			thr2.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker(names[i]);
			Thread thr1 = new Thread(worker);
			thr1.start();
			officeList.add(worker);
			// System.out.println(worker.GetName());
		}

	}
	
	public void addWorkerToWorkList(Worker worker) {
		officeList.add(worker);
	}
	
	public void changeRoom() {
		if (breakRoom.getFirstPerson().getEnergy() >= 100) {
			officeList.add(breakRoom.getFirstPerson());
			System.out.println(breakRoom.getFirstPerson().GetName() + " whent back to work");
			breakRoom.removeFromQueue(breakRoom.getFirstPerson());
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
			
			if(breakRoom.getFirstPerson() != null) {
				changeRoom();
			}
			
			for (int i = 0; i < officeList.size(); i++) {
				if (officeList.get(i).getEnergy() < 30) {
					officeList.get(i).changeStatus();
					System.out.println("Moved" + officeList.get(i).GetName());
					breakRoom.addWorkerToCoffeQue(officeList.get(i));
					officeList.remove(i);
				}
			}
		}

	}

}
