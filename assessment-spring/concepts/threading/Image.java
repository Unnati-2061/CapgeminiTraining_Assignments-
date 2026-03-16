package threading;

import java.util.ArrayList;
import java.util.List;

class AsyncDownloader {
	public void download(String image) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("AsyncDownloader: downloading " + image + "...");
			}
		};
		
		t.start();
	}
}

class SyncDownloader {
	public void download(String image) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("SyncDownloader: downloading " + image + "...");
	}
}

class ThreadedDownloader extends Thread {
	private String image;
	
	ThreadedDownloader(String image) {
		super();
		this.image = image;
	}
	
	public void run() { download(this.image); }
	
	public void download(String image) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ThreadedDownloader: downloading " + image + "...");
	}
}

public class ImageDownloader {
	public static void main(String[] args) throws InterruptedException {
		String images[] = {
			"image1",
			"image2",
			"image3"
		};
		
		// AsyncDownloader will automatically download using threads
//		for(int i=0; i<images.length; i++) {
//			AsyncDownloader loader = new AsyncDownloader();
//			loader.download(images[i]);
//		}
//		System.out.println("All images downloaded by AsyncDownloader.");
//		
//		// SyncDownloader will download in order(sync)
//		for(int i=0; i<images.length; i++) {
//			SyncDownloader loader = new SyncDownloader();
//			String image = images[i];
//
//			Thread t = new Thread() {
//				public void run() {
//					loader.download(image);
//				}
//			};
//
//			t.start();
//		}
//		System.out.println("All images downloaded by SyncDownloader.");
		
		
		// ThreadedDownloader
		List<Thread> downloadThreads = new ArrayList<>();
		for(int i=0; i<images.length; i++) {
			ThreadedDownloader loader = new ThreadedDownloader(images[i]);
			downloadThreads.add(loader);
			loader.start();
		}
		
		for(Thread t: downloadThreads) t.join();
		System.out.println("All images downloaded by ThreadedDownloader.");
	}
}
