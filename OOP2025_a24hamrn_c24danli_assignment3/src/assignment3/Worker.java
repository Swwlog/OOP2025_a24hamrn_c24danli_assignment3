package assignment3;

public class Worker {

	private String name;
	private int energy;
	private final int energyDepletionTime;

	public Worker(String name) {
		this.name = name;
		this.energy =(int)Math.random()*(91-30)+30;
		this.energyDepletionTime = (int)((Math.random()*(1501-500))+500);
		
	}
	public int ShowEnergy() {
		return energy;
	}
	public int DrinkCoffe(int drink) {
		energy= energy+drink;
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
}
