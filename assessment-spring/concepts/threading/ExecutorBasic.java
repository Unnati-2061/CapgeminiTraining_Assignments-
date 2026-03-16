package threading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorBasic {
	public static void main(String[] args) {
		ExecutorService singleThread = Executors.newSingleThreadExecutor();
		singleThread.submit(() -> {
			for(int i=1; i<=40; i++)
				System.out.println("thread " + i);
		});
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		Callable<Integer> call = () -> {
			Thread.sleep(4000);
			return new Random().nextInt();
		};
		
		Future<Integer> future = singleThread.submit(call);
	}

}
