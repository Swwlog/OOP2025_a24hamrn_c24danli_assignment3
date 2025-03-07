package assignment3;

public class BlackCoffe extends HotDrink {
	
	public BlackCoffe() {
		setEnergyAndName();
	}

@Override
public void setEnergyAndName() {
this.energy = (int) (Math.random() * (20 - 15)) + 15; 
this.name = "Black coffe";
}
}


