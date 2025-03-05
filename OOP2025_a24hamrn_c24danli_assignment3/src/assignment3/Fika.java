package assignment3;

import java.util.ArrayList;

public class Fika {
	private ArrayList<Worker> officeList;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf", "Legolas", "Gimly" };
	private int workForce=5;// change to change amount of workers(highest 6 )
	private int simulationSpeed=1; // 1= normal speed, higher for faster speed

	public Fika() {
		officeList = new ArrayList<Worker>();
		breakRoom = new BreakRoom(simulationSpeed);
		for (int i = 0; i < workForce; i++) {
			Worker worker = new Worker(names[i], officeList, breakRoom,simulationSpeed);
			officeList.add(worker);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

}
