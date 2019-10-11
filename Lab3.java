package Lab;

import java.util.*;
/*
6
kjahfkasdhnfkj neravnwaevo qoegj ehg oiqjrvoirjtvkjreovj
elwrj qerj kljeqlkg let jglkjerklgltejhglk gt glt rgtrklltr lk tgjjtv
i
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,e,,,,,,,,,,,,,,,,,,,,,,,,,,,
........................................................t
t..........................................................
3

26
.zzzzzzzzzzzzzzzzzzzzzzzzzzzz
yyyyyyyyyyyyyyyyyyyyyyyyyyy
,xxxxxxxxxxxxxxxxxxxxxxxxxx
wwwwwwwwwwwwwwwwwwwwwwwww
vvvvvvvvvvvvvvvvvvvvvvvv
uuuuuuuuuuuuuuuuuuuuuuu
tttttttttttttttttttttt
.sssssssssssssssssssss
rrrrrrrrrrrrrrrrrrrr
qqqqqqqqqqqqqqqqqqq
pppppppppppppppppp
ooooooooooooooooo
nnnnnnnnnnnnnnnn
mmmmmmmmmmmmmmm
llllllllllllll
kkkkkkkkkkkkk
jjjjjjjjjjjj
iiiiiiiiiii
hhhhhhhhhh
ggggggggg
ffffffff
eeeeeee
dddddd
ccccc
bbbb
aaa
3
 
1
zyxdifeoa
1

2
abcd
z z. z,z. z z. z,z.
1

3
a a. a,a.
bc   bc
abcd  abcd  abcd
2

1
abababababababababa
3
 */

public class Lab3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// input n
		int n = sc.nextInt();
		sc.nextLine();
		
		// n Strings;
		String[] rawString = new String[n];
		for(int i=0; i<n; i++) {
			rawString[i] = sc.nextLine();
//			System.out.println("rawString is: "+rawString[i]);
		}
		
		// n-gram checker
		int checker = sc.nextInt();
		sc.nextLine();
		
// ==== EXTRA TEST CASES ====
//		int n = 1;
//		String[] rawString = {"zyxdifeoa"};						//when "dcba", why graph is updated as: {b=1, a=1, d=1, c=1}??
//		int checker = 1;
		
//		int n = 2;
//		String[] rawString = {"abcd", "z z. z,z. z z. z,z."};
//		int checker = 1;
		
//		int n = 3;
//		String[] rawString = {"a a. a,a.", "bc   bc", "abcd  abcd  abcd"};
//		int checker = 2;
		
//		int n = 3;
//		String[] rawString = {"cdef cdef", "bc bc bc", "uabiugabeivabwlwfih"};
//		int checker = 2;
		
//		int n = 1;
//		String[] rawString = {"abababababababababa"};
//		int checker = 3;
		
//		int n = 1; -- tie cases
//		String[] rawString = {"ababababababababab"};
//		int checker = 3;
		
		switch(checker) {
		case 1:
			Unigram(rawString);
			break;
		case 2:
			Bigram(rawString);
			break;
		case 3:
			Trigram(rawString);
			break;
		default:
//			System.out.print("Opss, Error - Invalid input.");	
		}

	}

	private static void Trigram(String[] rawString) {
		String result = "[";							// "[" is greater than "z"(int: 90)
		//structure - Dictionary
		Dictionary<String, Integer> dic = new Hashtable<String, Integer>();
		for(String lines: rawString) {
			for(int i=0; i+2<lines.length(); i++) {								//##update
				String targetUnigram = lines.substring(i, i+3);					//##update
				
				//handle SEPERATOR, eg " "<OR> , <OR> . 
				if(targetUnigram.contains(" ")||targetUnigram.contains(",")||targetUnigram.contains("."))
					continue;
				
				if(dic.get(targetUnigram) != null) {
					int temp = dic.get(targetUnigram);
					temp++;
					dic.put(targetUnigram, temp);
				}else {
					dic.put(targetUnigram, 1);
				}
			}
		}
//		System.out.println(dic);
		
		int max = -1;
		for(Enumeration e = dic.keys(); e.hasMoreElements();) {
			String nextElem = (String) e.nextElement();
			
			//tie IN-A-LOOP inspection											//##update
			if(dic.get(nextElem) == max) {
				for(int i=0; i<nextElem.length(); i++) {
					if(nextElem.charAt(i) == result.charAt(i))
						continue;
					if(nextElem.charAt(i) < result.charAt(i)) {
						result = nextElem;
						break;
					}
				}
			}

			if(dic.get(nextElem) > max) {
				max = dic.get(nextElem);
				result = nextElem;
			}
//			System.out.println(dic.get(nextElem)+"now result is: "+result);
		}
		
		System.out.print("Trigram "+result);
		
	}

	private static void Bigram(String[] rawString) {
		String result = "[";							// "[" is greater than "z"(int: 90)
		//structure - Dictionary
		Dictionary<String, Integer> dic = new Hashtable<String, Integer>();
		for(String lines: rawString) {
			for(int i=0; i+1<lines.length(); i++) {								//##update
				String targetUnigram = lines.substring(i, i+2);					//##update
				
				//handle SEPERATOR, eg " "<OR> , <OR> . 
				if(targetUnigram.contains(" ")||targetUnigram.contains(",")||targetUnigram.contains("."))
					continue;
				
				if(dic.get(targetUnigram) != null) {
					int temp = dic.get(targetUnigram);
					temp++;
					dic.put(targetUnigram, temp);
				}else {
					dic.put(targetUnigram, 1);
				}
			}
		}
//		System.out.println(dic);
		
		int max = -1;
		for(Enumeration e = dic.keys(); e.hasMoreElements();) {
			String nextElem = (String) e.nextElement();
			
			//tie IN-A-LOOP inspection											//##update
			if(dic.get(nextElem) == max) {
				for(int i=0; i<nextElem.length(); i++) {
					if(nextElem.charAt(i) == result.charAt(i))
						continue;
					if(nextElem.charAt(i) < result.charAt(i)) {
						result = nextElem;
						break;
					}
				}
			}

			if(dic.get(nextElem) > max) {
				max = dic.get(nextElem);
				result = nextElem;
			}
//			System.out.println(dic.get(nextElem)+"now result is: "+result);
		}
		
		System.out.print("Bigram "+result);
		
	}

	private static void Unigram(String[] rawString) {
		
		String result = "[";							// "[" is greater than "z"(int: 90)
		//structure - Dictionary
		Dictionary<String, Integer> dic = new Hashtable<String, Integer>();
		for(String lines: rawString) {
			for(int i=0; i<lines.length(); i++) {
				String targetUnigram = lines.substring(i, i+1);
				//handle SEPERATOR, eg " "<OR> , <OR> . 
				if(targetUnigram.contains(" ")||targetUnigram.contains(",")||targetUnigram.contains("."))
					continue;
				if(dic.get(targetUnigram) != null) {
					int temp = dic.get(targetUnigram);
					temp++;
					dic.put(targetUnigram, temp);
				}else {
					dic.put(targetUnigram, 1);
				}
			}
		}
//		System.out.println(dic);
		
		int max = -1;
		for(Enumeration i = dic.keys(); i.hasMoreElements();) {
			String nextElem = (String) i.nextElement();
			if(dic.get(nextElem) == max && nextElem.charAt(0) < result.charAt(0))
				//tie
				result = nextElem;
			if(dic.get(nextElem) > max) {
				max = dic.get(nextElem);
				result = nextElem;
			}
//			System.out.println(dic.get(nextElem)+"now result is: "+result);
		}
		
		System.out.print("Unigram "+result);
		
	}

}
