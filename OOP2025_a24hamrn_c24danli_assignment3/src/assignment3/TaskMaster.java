package assignment3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskMaster {
	private ConcurrentLinkedQueue coffeQue;
	private ArrayList<Worker> workList;
	
	public TaskMaster() {
		
		workList = new ArrayList<Worker>();
		for (int i=0; i<5; i++) {
			Worker worker = new Worker("karl");
			worker.run();
			workList.add(worker);
			System.out.println(worker.GetName());
		}
	}
	

}
