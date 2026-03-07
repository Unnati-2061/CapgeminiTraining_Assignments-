package threading;

import java.util.ArrayList;
import java.util.List;

class VecSumThread extends Thread {
	private List<Integer> vecA, vecB;
	private List<Integer> vecSum;
	private int index;
	
	public VecSumThread(List<Integer> vecA, List<Integer> vecB, int index) {
		this.vecA = vecA;
		this.vecB = vecB;
		this.vecSum = new ArrayList<>();
		this.index = index;
	}
	
	public List<Integer> getVecSum() {
		return vecSum;
	}
	
	public int getIndex() { return index; }

	public void run() {
		if (vecA.size() != vecB.size()) {
			System.out.println("Invalid dimention for vector sum");
			return;
		}
		
		for(int i=0; i<vecA.size(); i++)
			vecSum.add(vecA.get(i) + vecB.get(i));
	}
}

public class MatrixAddition {
	public static void main(String[] args) throws InterruptedException {
		List<List<Integer>> matrixA = new ArrayList<>(List.of(
			new ArrayList<>(List.of(1, 2, 3, 4)),
			new ArrayList<>(List.of(5, 6, 7, 8)),
			new ArrayList<>(List.of(9, 8, 7, 6)),
			new ArrayList<>(List.of(5, 4, 3, 2)),
			new ArrayList<>(List.of(1, 9, 2, 8))
		));

		List<List<Integer>> matrixB = new ArrayList<>(List.of(
			new ArrayList<>(List.of(5, 6, 7, 8)),
			new ArrayList<>(List.of(1, 2, 3, 4)),
			new ArrayList<>(List.of(9, 8, 7, 6)),
			new ArrayList<>(List.of(1, 9, 2, 8)),
			new ArrayList<>(List.of(5, 4, 3, 2))
		));
		
		List<List<Integer>> result = new ArrayList<>();

		List<VecSumThread> threads = new ArrayList<>();
		
		System.out.println("Starting vector-sum threads on matrix A and B");
		for(int i=0; i<matrixA.size(); i++) {
			VecSumThread addThread = new VecSumThread(matrixA.get(i),
													  matrixB.get(i),
													  i);
			threads.add(addThread);
			System.out.println("Started vec-sum thread on row: " + (i+1));
			addThread.start();
		}
		
		for(Thread t: threads) t.join();
	
		System.out.println("All threads has done calculating the sum.");
		for(VecSumThread t: threads) {
			result.add(t.getIndex(), t.getVecSum());
		}
		
		System.out.println("Result: ");
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}

}
