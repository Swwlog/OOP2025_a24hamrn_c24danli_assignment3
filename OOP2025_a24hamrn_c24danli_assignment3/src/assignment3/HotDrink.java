package assignment3;

public class HotDrink {
	int energy;
	String name;

	public HotDrink(int Coffe) {
		

		switch (Coffe) {

		case 1:
			this.energy = (int) (Math.random() * (20 - 15)) + 15;
			this.name = "black coffe";
			break;

		case 2:
			this.energy = (int) (Math.random() * (30 - 20)) + 20;
			this.name = "Cappuccino";
			break;

		case 3:
			this.energy = (int) (Math.random() * (35 - 25)) + 25;
			this.name = "Latte";
			break;
		}

		
	}

	public String getCoffeName() {
		return this.name;
	}

	public int getEnergy() {
		return this.energy;
	}

}
