package assignment3;

import java.util.ArrayList;

public class Worker implements Runnable {

	private String name;
	private int energy;
	private final int energyDepletionTime;
	private ArrayList<Worker> officeList;
	private BreakRoom breakRoom;
	private Thread thr1;
	private int simulationSpeed;

	public Worker(String name, ArrayList<Worker> officeList, BreakRoom breakRoom, int simulationSpeed) {
		this.name = name;
		this.energy = (int) (Math.random() * (91 - 30)) + 30;
		this.energyDepletionTime = (int) ((Math.random() * (1501 - 500)) + 500);
		this.officeList = officeList;
		this.breakRoom = breakRoom;
		this.simulationSpeed =simulationSpeed;
		thr1 = new Thread(this);
		thr1.start();
	}

	public int getEnergy() {
		return energy;
	}

	public int DrinkCoffe(int drink) {
		energy = energy + drink;
		System.out.println(GetName() + " drank a coffe and got " + drink + " energy");
		return energy;
	}

	public String GetName() {
		return name;
	}

	public void decreceEnery() {
		energy = energy - 1;
	}

	public int GetEnergyDepleationTime() {
		return energyDepletionTime;
	}

	public void run() {
		while (energy > 0) {

			try {
				Thread.sleep(energyDepletionTime/simulationSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			energy = energy - 1;
			if (officeList.contains(this)) {
				System.out.println(GetName() + " is working with energy level " + getEnergy());
			} else {
				System.out.println(GetName() + " is taking a break with energy level " + getEnergy());
			}

			if (energy < 30 && officeList.contains(this)) {
				breakRoom.addWorkerToCoffeQue(this);
				System.out.println(this.GetName() + " moved to breakroom");
				System.out.println(breakRoom.getList().size());
				officeList.remove(this);
			}
			if (energy >= 100 && breakRoom.getList().contains(this)) {
				officeList.add(this);
				System.out.println(this.GetName() + " moved to work");
				breakRoom.removeFromQueue(this);
			}

		}
		breakRoom.removeFromQueue(this);
		thr1.interrupt();
		// stoppa run
	}
}
