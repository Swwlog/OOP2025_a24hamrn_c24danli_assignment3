package assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika implements Runnable {
	private CoffeMachine coffeMachine;
	private ConcurrentLinkedQueue<Worker> officeList;
	private Thread fikaThread;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf", "Legolas", "Gimli", "Aragorn", "Sauron",
			"Gollum", "Elrond", "Arwen", "Sam", "Éowyn", "Saruman", "Tom", "Boromir", "Théoden", "Bilbo", "Treebeard",
			"Shelob", "Shagrat", "Adelard", "Gríma", "Éomer", "Faramir", "Mauhúr", "Imrahil", "Lugdush", "Celeborn" };
	// "names" contain 29 names witch is the limit for "workForce" variable if you
	// need more add more names in "names"
	
	private int simulationTime = 20; // The amount of seconds the simulation runs for
	private int workForce = 4;       // change to change amount of workers
	private int simulationSpeed = 1; // 1= normal speed, higher for faster speed(no negative or 0)
									 // the number in simulationSpeed divides the normal speed 2=/2 3 =/3..... n=/n

	public Fika() {
		
		if(simulationSpeed < 1) {
			simulationSpeed = 1;
		}
		
		if (workForce > names.length) {
			workForce = names.length;
		}
		
		officeList = new ConcurrentLinkedQueue<Worker>();
		breakRoom = new BreakRoom();
		coffeMachine = new CoffeMachine(simulationSpeed);
		fikaThread = new Thread(this);
		fikaThread.start();
		
		
		for (int i = 0; i < workForce; i++) {
			Worker worker = new Worker(names[i], officeList, breakRoom, simulationSpeed, coffeMachine);
			officeList.add(worker);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

	@Override
	public void run() {

		try {
			Thread.sleep(simulationTime * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Simulation stopped");
		System.exit(0);

	}

}
