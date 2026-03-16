package threading;

class ChildThread extends Thread {
	public ChildThread() {}
	
	public ChildThread(ThreadGroup group) {
		super(group, "dummy");
	}

	public void run() {
		Thread currThread = Thread.currentThread();
		System.out.println("child_thread: " + currThread);

		for(int i=1; i<=100; i++) {
			System.out.println("Child: " + i);
		}
	}
}

class ConfirmRunnable implements Runnable {
	@Override
	public void run() {
		Thread currThread = Thread.currentThread();
		System.out.println("confirm_runnable_thread: " + currThread);

		for(int i=1; i<=100; i++)
			System.out.println("Child2: " + i);
	}
}


public class ThreadingBasic {

	public static void main(String[] args) {
		Thread currThread = Thread.currentThread();
		System.out.println("main_thread: " + currThread);

		ThreadGroup group = new ThreadGroup("mycustom_group");
		ChildThread t = new ChildThread(group);
		t.setName("ChildThread");
		t.setPriority(1);
		

		// will execute run in new thread and return at the same time
		t.start(); 
		
		ConfirmRunnable obj = new ConfirmRunnable();
		Thread t2 = new Thread(group, obj);
		t2.setName("ConfirmRunnableThread");
		t2.setPriority(10);
		
		// will execute the run method of class which confirms the Runnable protocol
		t2.start();
		
		for(int i=1; i<=5; i++) {
			ChildThread locThread = new ChildThread();
			locThread.setName("LocalThread");
			locThread.setPriority(7);

			locThread.start();
		}

		for(int i=1; i<=100; i++)
			System.out.println("Main: " + i);
	}
}
