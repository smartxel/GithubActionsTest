
public class InterviewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consecutiveCharacterOccurance();
	}

	public static void consecutiveCharacterOccurance() {

		String str = "aabbbccddbbd";
		int count = 1;

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length() - 1; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				} else {
					count = 1;

				}
				
			}
			System.out.print(count + "" + str.charAt(i));
		}

		// System.out.print(str.charAt(str.length()-1)+);
	}

}
