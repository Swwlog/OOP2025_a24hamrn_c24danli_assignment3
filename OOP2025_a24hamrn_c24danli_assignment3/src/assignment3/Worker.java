package assignment3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	private String name;
	private int energy;
	private final int energyDepletionTime;
	private ConcurrentLinkedQueue<Worker> officeList;
	private BreakRoom breakRoom;
	private CoffeMachine coffeMachine;
	private Thread thr1;
	private Thread thr2;
	private int simulationSpeed;

	public Worker(String name, ConcurrentLinkedQueue<Worker> officeList, BreakRoom breakRoom, int simulationSpeed, CoffeMachine coffeMachine) {
		this.name = name;
		this.energy = (int) (Math.random() * (91 - 30)) + 30;
		this.energyDepletionTime = (int) ((Math.random() * (1501 - 500)) + 500);
		this.officeList = officeList;
		this.breakRoom = breakRoom;
		this.simulationSpeed = simulationSpeed;
		this.coffeMachine = coffeMachine;
		thr1 = new Thread(this);
		thr1.start();
	}

	public int getEnergy() {
		return energy;
	}

	public int drinkCoffe(HotDrink drink) {
		energy = energy + drink.getEnergy();
		System.out.println(getName() + " drank a " + drink.getCoffeName() +  " and got " + drink.getEnergy() + " energy");
		return energy;
	}

	public String getName() {
		return name;
	}

	public void decreceEnery() {
		energy = energy - 1;
	}

	public int getEnergyDepleationTime() {
		return energyDepletionTime;
	}

	public void run() {
		while (energy > 0) {

			
			if(breakRoom.getList().peek() == this && coffeMachine.getReserveSize() > 0) {
				
				try {
					thr1.sleep(1000/simulationSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				drinkCoffe(coffeMachine.getDrinkEnergy());
				coffeMachine.removeFirstDrink();
				System.out.println(this.name + " " + breakRoom.getList().size());
				breakRoom.getList().offer(breakRoom.getList().remove());
			}
			
			try {
				thr1.sleep(energyDepletionTime / simulationSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			energy = energy - 1;
			
			
			if (officeList.contains(this)) {
				System.out.println(getName() + " is working with energy level " + getEnergy());
			} else {
				System.out.println(getName() + " is taking a break with energy level " + getEnergy());
			}

			if (energy < 30 && officeList.contains(this)) {
				breakRoom.addWorkerToCoffeQue(this);
				System.out.println(this.getName() + " moved to breakroom");
				officeList.remove(this);
			}
			if (energy >= 100 && breakRoom.getList().contains(this)) {
				officeList.add(this);
				System.out.println(this.getName() + " moved to work");
				breakRoom.removeFromQueue(this);
			}

		}
		System.out.println(this.getName() + " whent home");
		breakRoom.removeFromQueue(this);
		thr1.interrupt();
	}
}
