package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class DayFourUtils {

	private static Logger LOGGER = Logger.getLogger(DayFourUtils.class.getName());

	public static Map<Integer, Map<Map<Integer, Integer>, Map<Integer, Integer>>> inputToMapWithRanges(String path) {
		Map<Integer, Map<Map<Integer, Integer>, Map<Integer, Integer>>> map = new HashMap<>();
		File input = new File(path);
		try {
			Scanner s = new Scanner(input);
			int acc = 1;
			while (s.hasNext()) {
				String line = s.nextLine();
				divideIntoMaps(line.split(","), map, acc);
				acc++;
			}

		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return map;
	}

	private static void divideIntoMaps(String[] ranges, Map<Integer, Map<Map<Integer, Integer>, Map<Integer, Integer>>> map, int acc) {
		String[] firstRange = ranges[0].split("-");
		String[] secondRange = ranges[1].split("-");
		Map<Map<Integer, Integer>, Map<Integer, Integer>> outerMap = new HashMap<>();
		Map<Integer, Integer> firstMap = new HashMap<>();
		Map<Integer, Integer> secondMap = new HashMap<>();
		firstMap.put(Integer.parseInt(firstRange[0]), Integer.parseInt(firstRange[1]));
		secondMap.put(Integer.parseInt(secondRange[0]), Integer.parseInt(secondRange[1]));
		outerMap.put(firstMap, secondMap);
		map.put(acc, outerMap);
	}

}
