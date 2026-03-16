package filehandling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaDirectoryInfo {
	public static void main(String[] args) {		
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Enter folder: ");
			String dirPath = sc.nextLine();
			
			File dir = new File(dirPath);
			
			if (!dir.exists()) {
				System.out.println("Direction does not exists!");
				return;
			} else if (!dir.isDirectory()) {
				System.out.println("Not a directory!");
				return;
			}
			
			
			File[] files = dir.listFiles();
			
			if (files == null) {
				System.out.println("Directory is empty!");
				return;
			}
			
			// filter out .java files from list of files
			List<File> filtered = new ArrayList<>();
			
			for(File f: files) {
				if (f.isFile() && f.getName()
								   .toLowerCase()
								   .endsWith(".java")) {
					filtered.add(f);
				}
			}
			
			// sort them according to their file-size
			// in descending
			Collections.sort(filtered, (f1, f2) -> {
				return (int) (f2.length() - f1.length());
			});
			
			for (File f : filtered) {
				// %-40s : String column, 40 characters wide, left-aligned (-)
				System.out.printf("%-40s (%d bytes)%n",
								  f.getName(),
								  f.length());
		    }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
