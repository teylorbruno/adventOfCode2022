package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class DayThreeUtils {

	private static Logger LOGGER = Logger.getLogger(DayThreeUtils.class.getName());
	private final static Map<String, Integer> PRIORITIES_MAP = new HashMap<String, Integer>() {{
		put("a", 1);
		put("b", 2);
		put("c", 3);
		put("d", 4);
		put("e", 5);
		put("f", 6);
		put("g", 7);
		put("h", 8);
		put("i", 9);
		put("j", 10);
		put("k", 11);
		put("l", 12);
		put("m", 13);
		put("n", 14);
		put("o", 15);
		put("p", 16);
		put("q", 17);
		put("r", 18);
		put("s", 19);
		put("t", 20);
		put("u", 21);
		put("v", 22);
		put("w", 23);
		put("x", 24);
		put("y", 25);
		put("z", 26);
		put("A", 27);
		put("B", 28);
		put("C", 29);
		put("D", 30);
		put("E", 31);
		put("F", 32);
		put("G", 33);
		put("H", 34);
		put("I", 35);
		put("J", 36);
		put("K", 37);
		put("L", 38);
		put("M", 39);
		put("N", 40);
		put("O", 41);
		put("P", 42);
		put("Q", 43);
		put("R", 44);
		put("S", 45);
		put("T", 46);
		put("U", 47);
		put("V", 48);
		put("W", 49);
		put("X", 50);
		put("Y", 51);
		put("Z", 52);
	}};

	public static Map<String, Integer> getPrioritiesMap() {
		return PRIORITIES_MAP;
	}

	public static Map<String, String> convertFileIntoMap(String path) {
		Map<String, String> map = new HashMap<>();
		File input = new File(path);
		try {
			Scanner s = new Scanner(input);
			while (s.hasNext()) {
				String line = s.nextLine();
				String firstHalf = line.substring(0, (line.length()) / 2);
				String secondHalf = line.substring(line.length() / 2);
				map.put(firstHalf, secondHalf);
			}

		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return map;
	}

	public static Map<String, List<String>> convertFileIntoMapWithList(String path) {
		Map<String, List<String>> map = new HashMap<>();
		File input = new File(path);
		try {
			Scanner s = new Scanner(input);
			int acc = 0;
			String key = "";
			while (s.hasNext()) {
				String line = s.nextLine();
				if (acc == 0) {
					map.put(line, new ArrayList<>());
					key = line;
					acc++;
				} else if (acc == 1) {
					map.get(key).add(line);
					acc++;
				} else {
					map.get(key).add(line);
					acc = 0;
					key = "";
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return map;
	}

}
