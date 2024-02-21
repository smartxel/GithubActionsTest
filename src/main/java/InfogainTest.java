import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfogainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
		int[] intValue = { '1', '2', '3', '4', '5', '4', '2' };
		
		List list = Arrays.asList(intValue);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != list.get(i + 1)) {
				list.add(list.get(i));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("list : " + list.get(i));
		}
		
		

		Map<String, String> map = new HashMap<String, String>();
		Set<Entry<String, String>> map1 = map.entrySet();

		for (Entry<String, String> entry : map1) {

			System.out.println(entry.getValue());
		}

//		List<Integer> list = new ArrayList<Integer>();

		
	}

	public static void test() {

		String str = "PrashantNNN";
		String resultStrr = "";

		for (int i = 0; i < str.length(); i++) {
			Character ch = null;

			if (ch.isLowerCase(str.charAt(i))) {

				resultStrr = resultStrr + str.charAt(i);

			} else {

			}

		}

		System.out.println("resultStrr :: " + resultStrr);

	}
}
