package assignment3;

import java.util.ArrayList;

public class Fika {
	private ArrayList<Worker> officeList;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf", "Legolas", "Gimly" };

	public Fika() {
		officeList = new ArrayList<Worker>();
		breakRoom = new BreakRoom();
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker(names[i], officeList, breakRoom);
			officeList.add(worker);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

}
