package Lab;

import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

/*
2 5 25 3 1 6 9 7
18

12 54 25 13 31 3 16 69 100 29 36
13

2 4 5 3 1 7 6 9 0
3
 */

public class Lab2 {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		int Li = 0, Ui, Mid, Val;
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
//		a="2 4 5 3 1 7 6 9 0";
//		a="12 54 25 13 31 3 16 69 100 29 36";
//		a="2 5 25 3 1 6 9 7";
		Val = sc.nextInt();
		
		String[] b = a.split(" ");
//		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String s: b) {
			list.add(Integer.valueOf(s));
		}
		Collections.sort(list);
		
		Ui = list.size()-1;
		Mid = (Li+Ui)/2;

		binarySearch(Li,Ui,Mid,Val, 0);
		
//		int result = binarySearch(Li,Ui,Mid,Val, 0);
//		System.out.println(result);
//		if(result == 2)
//			System.out.println("found");
//		else if(result == -2)
//			System.out.println("no found");
//		else
//			System.out.println("error");
	}
	
	private static void binarySearch(int li, int ui, int mid, int val, int result) {
		//result: 0==init val, -1 == lower part, 1 == upper part, 2 == found, -2 == not found.
		
		if(val == list.get(mid)) {
			System.out.println("found");
		}
		else if(ui<li) {
			System.out.println("notfound");
		}
		else if(val<list.get(mid)) {
			result = -1;
			ui = mid-1;
			mid = (li+ui)/2;
//			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			System.out.print(result + " ");
			binarySearch(li, ui, mid, val, result);
		}else if(val>list.get(mid)){
			result = 1;
			li = mid+1;
			mid = (li+ui)/2;
//			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			System.out.print(result + " ");
			binarySearch(li, ui, mid, val, result);
		}
		
	}

	private static int Cannot_Carry_OutofRecurssion_binarySearch(int li, int ui, int mid, int val) {
		int result = 0;			//0==init val, -1 == lower part, 1 == upper part, 2 == found, -2 == not found.
		
		if(val == mid) {
			result = 2;
			return 2;
		}
		else if(ui<li)
			result = -2;
		else if(val<mid) {
			ui = mid-1;
			mid = li+ui/2;
			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			Cannot_Carry_OutofRecurssion_binarySearch(li, ui, mid, val);
		}else if(val>mid){
			li = mid+1;
			mid = li+ui/2;
			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			Cannot_Carry_OutofRecurssion_binarySearch(li, ui, mid, val);
		}
		
		return result;
	}
	
	private static int StackOverFlu_binarySearch(int li, int ui, int mid, int val) {
		int result = 0;			//0==init val, -1 == lower part, 1 == upper part, 2 == found, -2 == not found.
		
		if(val == mid)
			result = 2;
		if(ui<li)
			result = -2;
		
		if(val<mid) {
			ui = mid-1;
			mid = li+ui/2;
			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			StackOverFlu_binarySearch(li, ui, mid, val);
		}else {
			li = mid+1;
			mid = li+ui/2;
			System.out.println(li+"#"+ui+"#"+mid+"#"+val);
			StackOverFlu_binarySearch(li, ui, mid, val);
		}
		
		return result;
	}

}
