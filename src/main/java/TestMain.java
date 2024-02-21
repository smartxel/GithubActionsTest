

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consecutiveCharOccurance();
	//	getConsecutiveCharCount();
	//	getDistinctVowelCount();
	//	reverseStringDemo();
		// printTriangle();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String input = scanner.nextLine().toLowerCase(); // Convert the input to lowercase to make the comparison
															// case-insensitive
		scanner.close();

		int distinctVowelCount = getDistinctVowelCount(input);
		System.out.println("Distinct vowel count: " + distinctVowelCount);

		String str = "one two";

		String[] arr = str.split(" ");

		for (int i = 0; i < arr.length; i++) {
			String reverseString = "";
			for (int j = arr[i].length() - 1; j >= 0; j--) {
				reverseString = reverseString + arr[i].charAt(j);

			}
			System.out.print(reverseString + " ");
		}

		String s1 = "mmmy name is prashant";
		char[] c1 = s1.toCharArray();
		int vowel1 = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s1.charAt(i + 1)) {

				vowel1++;

			} else {
				vowel1 = 1;
			}
			System.out.println(s1.charAt(i) + "" + vowel1);
		}

		String s = "my name is prashant";
		char[] c = s.toCharArray();
		int vowel = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u')

				vowel++;

		}

		System.out.println("Vowels: " + vowel);

		String str1 = "my name is prashant";
		String[] strArray = { "a", "e", "i", "o", "u" };

		for (int i = 0; i < str1.length(); i++) {
			int count = 0;
			for (int j = 0; j < strArray.length; j++) {
				System.out.println("i :" + String.valueOf(str1.charAt(i)));
				System.out.println("j :" + strArray[j]);
				if (strArray[j].equals(String.valueOf(str1.charAt(i)))) {
					count = count++;
					System.out.println(count);
					break;
				}

			}

		}

	}

	public static void reverseStringDemo() {

		String str = "prashant nimbalkar";

		String[] strArray = str.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			String reverseString = "";
			// System.out.println("str arr: "+strArray[i]);
			for (int j = strArray[i].length() - 1; j >= 0; j--) {
				reverseString = reverseString + strArray[i].charAt(j);
			}
			System.out.print(reverseString + " ");
		}

	}

	public static void printTriangle() {

		for (int r = 5; r > 1; r--) {
			for (int c = r; c > 1; c--) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	private static int getDistinctVowelCount(String str) {
		Set<Character> vowels = new HashSet<>();
		for (char ch : str.toCharArray()) {
			if (isVowel(ch)) {
				vowels.add(ch);
			}
		}
		return vowels.size();
	}

	private static boolean isVowel(char ch) {
		return "aeiou".indexOf(ch) != -1;
	}

	public static void getDistinctVowelCount() {
		String str = "my name is prashant";

		str.toLowerCase();

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		int count = 0;

		for (Character character : set) {
			if (character == 'a' | character == 'e' | character == 'i' | character == 'o' | character == 'u') {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void getConsecutiveCharCount() {

		String str = "bbaaaabbbccdddaaee";
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count = count + 1;
				} else {
					count = 1;
				}
			}
			System.out.print(str.charAt(i) + "" + count);
		}

		Map<Character, Integer> map = new HashMap<>();

		char[] ch = str.toCharArray();
		for (char c : ch) {
			if (map.containsKey(c)) {
				int charCount = map.get(c);
				map.put(c, charCount + 1);
			} else {
				map.put(c, 1);
			}

		}
		System.out.println("MAP :: " + map);
	}

	public static void consecutiveCharOccurance() {
		String str = "aabbbccddbb";
		int count = 1;
		for(int i = 0; i < str.length()-1; i++) {
		    if(str.charAt(i) == str.charAt(i+1)) {
		        count++;
		    } else {
		        System.out.println(count+ ""+str.charAt(i));
		        count = 1;
		    }
		}
		System.out.print(count+""+str.charAt(str.length()-1));
	}

}
