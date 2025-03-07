package assignment3;

public class Cappuccino extends HotDrink {

	public Cappuccino() {
		setEnergyAndName();
	}

	@Override
	public void setEnergyAndName() {
		this.energy = (int) (Math.random() * (30 - 20)) + 20;
		this.name = "Cappuccino";
	}
}
