package assignment3;

public class Latte extends HotDrink{

	public Latte() {
			setEnergyAndName();
		}

@Override
public void setEnergyAndName() {
    this.energy = (int) (Math.random() * (35 - 25)) + 25; 
    this.name = "Latte";
}
}