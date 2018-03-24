import java.io.*;
public class TestDiskUsage {

	//Assignment one, SYSC2100, Gabriele Sarwar, 101010867


		public static void main(String[] args) {
		
			File myfile = new File("C:\\Users\\User\\Desktop\\Math-3705"); //a file in my comp
			long c=diskUsage(myfile); // call the diskusage method
			System.out.println(c); // print the total size 
			
			
		}
		
		//QUESTION 1 PART 1 Of ASSIGNMENT 1
		// a recursive Java program to find the total disk usage (in bytes) of the portion 
		//of a file system.
		//@Param the file he or she chooses
		///@return the total size of root file
		
		public static long diskUsage(File root) {
			long TotalSize = 0; //stores the size in bytes
			if (root.exists() == false) { //if its not a valid root exit
				return -1;
			}
			int size = root.listFiles().length; //total size of root
			File[] filelist = new File[size]; //array of files
			filelist = root.listFiles();//a list of files in the root
			
			for(int i=0; i<size; i++) {
				if(filelist[i].isFile()){ // if its a file add to total size
					TotalSize = TotalSize + filelist[i].length();
					}
				else {	//if its not a file recall function on the folders		
					TotalSize = TotalSize + diskUsage(filelist[i]);
					}
			}
			return TotalSize;
		}
		
}

