package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika implements Runnable {
	private ConcurrentLinkedQueue<Worker> officeList;
	private Thread fikaThread;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf", "Legolas", "Gimli", "Aragorn", "Sauron",
			"Gollum", "Elrond", "Arwen", "Sam", "Éowyn", "Saruman", "Tom", "Boromir", "Théoden", "Bilbo", "Treebeard",
			"Shelob", "Shagrat", "Adelard", "Gríma", "Éomer", "Faramir", "Mauhúr", "Imrahil", "Lugdush", "Celeborn" };
	// "names" contain 29 names witch is the limit for "workForce" variable if you
	// need more
	// add more names in "names"
	private int timer = 20; // Change for amount of second run in the simulation
	private int workForce = 5;// change to change amount of workers(highest 29 )
	private int simulationSpeed = 1; // 1= normal speed, higher for faster speed(no negative or 0)
										// the number in simulation speed divides the normal speed 2=/2 3 =/3..... n=/n

	public Fika() {
		officeList = new ConcurrentLinkedQueue<Worker>();
		breakRoom = new BreakRoom(simulationSpeed);
		fikaThread = new Thread(this);
		fikaThread.start();
		if (workForce > 29) {
			workForce = 29;
		}
		for (int i = 0; i < workForce; i++) {
			Worker worker = new Worker(names[i], officeList, breakRoom, simulationSpeed);
			officeList.add(worker);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

	@Override
	public void run() {

		try {
			Thread.sleep(timer * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Simulation stopped");
		System.exit(0);

	}

}
