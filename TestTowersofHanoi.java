
public class TestTowersofHanoi {

	public static void main(String[] args) {
		
		solveTowers(4, "left", "middle","right"); //call the solvetowers method
	}
	//QUESTION 3 for assignment 1, program that solves tower of hoani
		//@param nummberof disks he or she chooses, the A source post character, A destination post character, and A character to use for the other post.
		
		public static void solveTowers(int numberofdiscs, String start, String spare, String end) {
		       if (numberofdiscs == 1) {
		           System.out.println("move disk" + numberofdiscs + " from "+ start + " to " + end);
		       }
		       else if(numberofdiscs<1){
		    	   System.out.print("u need at least one disk");
		    	   return;   
		       } 
		       else {
		    	   solveTowers(numberofdiscs - 1, start, end, spare);
		           System.out.println("move disk" + numberofdiscs + " from " + start + " to " + end);
		           solveTowers(numberofdiscs - 1, spare, start, end);
		       }
		   }

}
