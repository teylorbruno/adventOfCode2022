import common.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Map<Integer, Integer> map = Utils.getMapFromFile("dayOne\\src\\main\\resources\\input.txt");
		List<Integer> sortedMap = map.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		ex1(sortedMap);
		ex2(sortedMap);

	}

	private static void ex2(List<Integer> sortedMap) {
		int ex2 = 0;
		for (int i = 0; i < 3; i++) {
			ex2 += sortedMap.get(i);
		}
		System.out.println(ex2);
	}

	private static void ex1(List<Integer> sortedMap) {
		System.out.println(sortedMap.get(0));
	}

}
