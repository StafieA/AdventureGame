import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
	private static Map<Integer,Location> locations = new HashMap<Integer,Location>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String,Integer> tempExit = new HashMap<String,Integer>();
		locations.put(0, new Location(0,"you are standing in front of the computer learnig java",tempExit));
		
		
		tempExit = new HashMap<String,Integer>();
		tempExit.put("w", 2);
		tempExit.put("E",3);
		tempExit.put("S",4);
		tempExit.put("N",5);
		locations.put(1, new Location(1,"you are standing at the end of the road before a small brick",tempExit));
	
		//System.out.println(tempExit);
		tempExit = new HashMap<String,Integer>();
		tempExit.put("N",5);
		locations.put(2, new Location(2,"you are at the top of hill",tempExit));
	
		tempExit = new HashMap<String,Integer>();
		tempExit.put("W",1);
		locations.put(3, new Location(3,"you are inside of bulding,a top house",tempExit));
	
		tempExit = new HashMap<String,Integer>();
		tempExit.put("N",1);
		tempExit.put("W",2);
		locations.put(4, new Location(4,"you are in a valley beside stream",tempExit));
	
		tempExit = new HashMap<String,Integer>();
		tempExit.put("S",1);
		tempExit.put("W",2);
		locations.put(5, new Location(5,"you are in the forest",tempExit));
	
	//	System.out.println(locations.get(1).getExits());
		
		Map<String,String> vocabulary = new HashMap<String,String>();
		vocabulary.put("Quit", "Q");
		vocabulary.put("North", "N");
		vocabulary.put("South", "S");
		vocabulary.put("East", "E");
		vocabulary.put("West", "W");
		
		int loc=1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc==0) {
				break;
			}
			Map <String,Integer> exits = locations.get(loc).getExits();
		//	System.out.println(locations.get(loc).getExits());
			System.out.print("Available exits are ");
			for(String exit : exits.keySet()) {
			   System.out.print(exit + ", ");
			}
				System.out.println();
				
			String direction = scanner.nextLine().toUpperCase();
			if(direction.length()>1)
			{
				String[] words = direction.split(" ");
				for(String word : words)
				{
					if(vocabulary.containsKey(word)) {
					direction = vocabulary.get(word);
						break;
					}
				}
			}
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			}else {
				System.out.println("you cannot go in that direction");
			}
			
		}
		scanner.close();
	}
        
}
