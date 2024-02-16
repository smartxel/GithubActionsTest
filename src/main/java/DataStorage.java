import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

	static Map<String, List<String>> map = new HashMap<String, List<String>>();

	public static Map<String, List<String>> getMap() {
		return map;
	}

	public static void setMap(String key, List<String> value) {
		map.put(key, value);
	}

}
