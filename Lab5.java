package Lab;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Lab5 {

	public static void main(String[] args) {
		
		String str = "qploresinazxrhqknhoilerthf";
//		String str = "abiolopniifnjiltpscql";
		
		String letters = "lion";
		
		String result = findMinWindow(str, letters);
		
		System.out.println(result);

	}

	private static String findMinWindow(String str, String letters) {
		String result = "";
		
		//Dictionary to store all letters occur
		Dictionary<Character, ArrayList<Integer>> dict = new Hashtable<Character, ArrayList<Integer>>();
		
		//Scan the str, store in dict
		for(int i=0; i<str.length(); i++) {
			char targetSymbol = str.charAt(i);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			if( dict.get(targetSymbol) != null ) {
				temp = dict.get(targetSymbol);
				temp.add(i);
				dict.put(targetSymbol, temp);
			}else {
				temp.add(i);
				dict.put(targetSymbol, temp);				//## can be optimized IF-ELSE clause
			}
		}
		System.out.println(dict);
		
		result = findMinMax(dict, str, letters);
		
		return result;
	}

	private static String findMinMax(Dictionary<Character, ArrayList<Integer>> dict, String str, String letters) {
		//Find the min distance
		int min = 99;
		int max = -1;
		
		ArrayList<Integer> examArray = dict.get(letters.charAt(0));
		min = examArray.get(0);
		max = examArray.get(0);
		
		//each run eliminate one from examArray
		while(!examArray.isEmpty()) {
			
			//exam each symbol's min max, and record it.
			//To avoid Local Peak, we also record total cost after each iteration.
			int totalCost = 0;
			for(int i=1; i<letters.length(); i++) {
				//## possible optimization - GET MIN LENGTH of DICT[i].
				ArrayList<Integer> seek = dict.get(letters.charAt(i));
				
				//each loc is the current i Symbol's occurrence location.
				//find local min
				int localMin = 99;
				for(int loc: seek) {
					int distance = Math.min(Math.abs(loc-min), Math.abs(loc-max));
					if(distance < localMin) {
						localMin = distance;
					}
					System.out.println("local min:"+localMin+", "+letters.charAt(i));
				}
				
				totalCost = max - min;
			}
			
			examArray.remove(0);
		}
		
		//Print the x->y substring from str.
		return str.substring(min, max+1);
	}
	
//	private static int calcAb

}
