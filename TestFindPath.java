import java.io.File;

public class TestFindPath {

	public static void main(String[] args) {
		File myfile = new File("C:\\Users\\User\\Desktop\\Math-3705"); //a file in my comp
		find(myfile,"HUB.txt"); //call the find method
	}
	public static void find(File root, String name) {
		//beginning of code is same as first function for part 1
		if (root.exists() == false) {
			System.out.println("not a file");
		}
		if (root.exists() == true) {
		int size = root.listFiles().length;
		File[] filelist = new File[size];
		filelist = root.listFiles();
		for(int i=0; i<size; i++) {
			if(filelist[i].isFile()){				
				if(filelist[i].getName().equals(name)) {//if the file has same name as given name
				System.out.println("the path of " + name + " is in " + filelist[i].toString()); //output only that file
				}
			}
			else {			
				find(filelist[i],name); // if its not a file we recall function at that folder
			}
		}
	  }
   }

}
