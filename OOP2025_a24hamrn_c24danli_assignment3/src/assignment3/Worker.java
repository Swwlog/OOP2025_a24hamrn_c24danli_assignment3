package assignment3;

import java.util.ArrayList;

public class Worker implements Runnable {

	private String name;
	private int energy;
	private final int energyDepletionTime;
	private Boolean isWorking;
	private ArrayList<Worker> officeList;
	private BreakRoom breakRoom;

	public Worker(String name, ArrayList<Worker> officeList, BreakRoom breakRoom) {
		this.name = name;
		this.energy = (int) (Math.random() * (91 - 30)) + 30;
		this.energyDepletionTime = (int) ((Math.random() * (1501 - 500)) + 500);
		this.isWorking=true;
		this.officeList = officeList;
		this.breakRoom = breakRoom;
	}//test

	public int getEnergy() {
		return energy;
	}

	public int DrinkCoffe(int drink) {
		energy = energy + drink;
		System.out.println(GetName()+" drank a coffe and got "+ drink + " energy"  );
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
	public void changeStatus() {
		if (isWorking==true) {
			isWorking=false;
		}
		else {
			isWorking=true;
		}
	}

	
	public void run() {
		while(energy > 0) {
			
			try {
				Thread.sleep(energyDepletionTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			
				energy = energy - 1;
				if(isWorking==true) {
					System.out.println(GetName()+" is working with energy level "+getEnergy());	
				}
				else {
					System.out.println(GetName()+" is taking a break with energy level "+getEnergy());	
				}
				
				if (energy<30 && officeList.contains(this)) {
					breakRoom.addWorkerToCoffeQue(this);
					officeList.remove(this);
				}
				if(this.energy >= 100 && breakRoom.getList().contains(this)) {
					
				}
			}
		}
	}


