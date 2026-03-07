package threading;

class Printer {
	public void print(String message) throws InterruptedException {
		System.out.print("[");
		Thread.sleep(2000);
		System.out.print(message);
		System.out.print("]");
	}
}

class Writer extends Thread {
	private Printer printer;
	private String message;
	
	public Writer(Printer printer, String message) {
		this.printer = printer;
		this.message = message;
	}
	
	public void run() {
		try {
			synchronized (printer) {
				printer.print(message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SynchronizedBasic {
	public static void main(String[] args) {
		Printer printer = new Printer();
		Writer w1 = new Writer(printer, "Java");
		Writer w2 = new Writer(printer, "Threads");
		
		w1.start();
		w2.start();
	}
}
