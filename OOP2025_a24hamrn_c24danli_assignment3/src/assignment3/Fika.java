package assignment3;

import java.util.ArrayList;

public class Fika {
	private ArrayList<Worker> officeList;
	BreakRoom breakRoom;
	private static String[] names = { "Frodo", "Merry", "Pippin", "Gandalf", "Legolas", "Gimli","Aragorn","Sauron"
					,"Gollum","Elrond","Arwen","Sam","Éowyn","Saruman","Tom","Boromir","Théoden","Bilbo","Treebeard"
					,"Shelob","Shagrat","Adelard","Gríma","Éomer","Faramir","Mauhúr","Imrahil","Lugdush","Celeborn"};
							// "names" contain 29 names witch is the limit for "workForce" variable if you need more
							//	add more names in "names"
	private int workForce=20;// change to change amount of workers(highest 29 )
	private int simulationSpeed=1; // 1= normal speed, higher for faster speed(no negative or 0)
									// the number in simulation speed divides the normal speed 2=/2 3 =/3..... n=/n
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
