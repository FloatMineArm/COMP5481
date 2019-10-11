package Lab;

import java.util.*;

/*
 * Test cases:
 * 				//432876126
 * 				//513467882134
				//49927398716
 */

public class Lab1 {

	public static void main(String[] args) {
		/* TODO
		 * Step 1: Double the value of alternate digits of the credit card number beginning with the second
digit from the right (the rightmost digit is the check digit.)

Step 2: Add the individual digits comprising the products obtained in Step 1 to each of the
unaffected digits in the original number.

Step 3: The total obtained in Step 2 must be a number ending in zero (30, 40, 50, etc.) for the
account number to be validated. The total mod 10 = 0. 
		 */
		Scanner sc = new Scanner(System.in);
		
		String creditNum = sc.next();
		
		int result[] = new int[2];
		result = improvedCredit(creditNum);
		
		if(result[0]%10 == 0) {
			System.out.println("VALID");
		}
		else {
//			System.out.println(result[0]);
			int counter = 0;
			while((result[0]+counter)%10 != 0) {
				counter++;
			}
			System.out.println("INVALID "+((result[1]+counter)%10));
		}
	}

	private static int[] improvedCredit(String creditNum) {
		//int[] num & int num[] SAME?
		int result[] = new int[2];
		result[0] = 0;
	
		int length = creditNum.length();
		result[1] = Integer.parseInt(Character.toString(creditNum.charAt(length-1)));
		if(length%2 != 0) {
			for(int i=length-1; i>=0; i--) {
				if(i%2 == 0) {
					result[0] += creditNum.charAt(i) - '0';
				}
				else {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					int product = Integer.parseInt(s) *2;
					if(product>9) {
						result[0] += product%10;
						result[0] += product/10;
					}else {
						result[0] += product;
					}
				}
			}
		} else {
			for(int i=length-1; i>=0; i--) {
				if(i%2 != 0) {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					result[0] += Integer.parseInt(s);
				}
				else {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					int product = Integer.parseInt(s) *2;
					if(product>9) {
						result[0] += product%10;
						result[0] += product/10;
					}else {
						result[0] += product;
					}
				}
			}
		}
		
		return result;
		
	}
	
	private static void printEverySecond(String creditNum) {
		int[] num = new int[creditNum.length() /2];
		//int[] num & int num[] SAME?
		
		int j = 0;
		int length = creditNum.length();
		if(length%2 != 0) {
			for(int i=length-1; i>=0; i--) {
				if(i%2 == 0)
					continue;
				else {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					num[j] = Integer.parseInt(s);
					j++;
				}
			}
		} else {
			for(int i=length-1; i>=0; i--) {
				if(i%2 != 0)
					continue;
				else {
					char a = creditNum.charAt(i);
					System.out.println("@: "+a);
					String s = Character.toString(a);
					num[j] = Integer.parseInt(s);
					j++;
				}
			}
		}
		
		for(int i: num)
			System.out.print(i+" ++ ");
	}

	private static int[] calcCredit(String creditNum) {
		//int[] num & int num[] SAME?
		int result[] = new int[2];
		result[0] = 0;
	
		int length = creditNum.length();
		result[1] = Integer.parseInt(Character.toString(creditNum.charAt(length-1)));
		if(length%2 != 0) {
			for(int i=length-1; i>=0; i--) {
				if(i%2 == 0) {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					result[0] += Integer.parseInt(s);
				}
				else {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					int product = Integer.parseInt(s) *2;
					if(product>9) {
						result[0] += product%10;
						result[0] += product/10;
					}else {
						result[0] += product;
					}
				}
			}
		} else {
			for(int i=length-1; i>=0; i--) {
				if(i%2 != 0) {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					result[0] += Integer.parseInt(s);
				}
				else {
					char a = creditNum.charAt(i);
					String s = Character.toString(a);
					int product = Integer.parseInt(s) *2;
					if(product>9) {
						result[0] += product%10;
						result[0] += product/10;
					}else {
						result[0] += product;
					}
				}
			}
		}
		
		return result;
		
	}
}
