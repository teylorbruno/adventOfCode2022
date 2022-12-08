package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class DayFiveUtils {

	private static Logger LOGGER = Logger.getLogger(DayFiveUtils.class.getName());
	private static HashMap<Integer, LinkedList<String>> grid = new HashMap<Integer, LinkedList<String>>(9) {{
		put(1, new LinkedList<>());
		put(2, new LinkedList<>());
		put(3, new LinkedList<>());
		put(4, new LinkedList<>());
		put(5, new LinkedList<>());
		put(6, new LinkedList<>());
		put(7, new LinkedList<>());
		put(8, new LinkedList<>());
		put(9, new LinkedList<>());
	}};

	private static List<List<Integer>> instructions = new ArrayList<>();

	public static void inputToGrid(String path) {
		File input = new File(path);
		try {
			Scanner s = new Scanner(input);
			int accumulator = 0;
			while (s.hasNext()) {
				String currentLine = s.nextLine();
				if (accumulator < 8) {
					List<String> stringsToSave = new ArrayList<>();
					for (int i = 0; i <= currentLine.length() - 3; i += 4) {
						String crate;
						if (i == currentLine.length() - 3) {
							crate = currentLine.substring(i).trim();
						} else {
							crate = currentLine.substring(i, i + 4).trim();
						}

						stringsToSave.add(crate);
					}
					grid.forEach((k, v) -> {
						v.addLast(stringsToSave.get(k - 1));
					});
					grid.forEach((k, v) -> {
						v.forEach(str -> {
							if (str.equals("")) {
								v.remove(str);
							}
						});
					});
				} else if (accumulator > 9) {
					String[] helperArray = currentLine.split(" ");
					List<Integer> crate = new ArrayList<>();
					for (String num : helperArray) {
						try {
							int n = Integer.parseInt(num);
							crate.add(n);
						} catch (Exception e) {
						}
					}
					instructions.add(crate);
				}
				accumulator++;
			}
		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
	}

	public static Map<Integer, LinkedList<String>> getGrid() {
		return grid;
	}

	public static List<List<Integer>> getInstructions() {
		return instructions;
	}
}
