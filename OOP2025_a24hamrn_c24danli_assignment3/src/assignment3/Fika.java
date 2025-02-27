package assignment3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika {
	private ConcurrentLinkedQueue coffeQue;
	private ArrayList<Worker> officeList;

	public Fika() {

		officeList = new ArrayList<Worker>();
		for (int i = 0; i < 5; i++) {
			Worker worker  = new Worker(" Worker " + (i+1));
			Thread thr1 = new Thread(worker);
			thr1.start();
			officeList.add(worker);
			//System.out.println(worker.GetName());
		}
		
		if(officeList.get(2).GetEnergyDepleationTime()< 30) {
			
		}
	}


	public static void main(String[] args) throws InterruptedException {
		Fika fika = new Fika();
	}

}
