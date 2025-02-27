package assignment3;

public class HotDrink {
	int energy;
	String name;

	public HotDrink(int Coffe) {
		// this.Name = name;

		switch (Coffe) {

		case 1:
			this.energy = (int) (Math.random() * (20 - 15)) + 15;
			this.name = "black coffe";
			break;

		case 2:
			this.energy = (int) (Math.random() * (30 - 20)) + 20;
			this.name = "Cappuccino";
			// System.out.println("Made a Cappuccino whit " + this.energy + " energy
			// level");
			break;

		case 3:
			this.energy = (int) (Math.random() * (35 - 25)) + 25;
			this.name = "Latte";
			// System.out.println("Made a Latte whit " + this.energy + " energy level");
			break;
		}

		//System.out.println("Made a " + this.name + " whit " + this.energy + " energy level");
	}

	public String GetCoffeName() {
		return this.name;
	}

	public int getEnergy() {
		return this.energy;
	}

}
