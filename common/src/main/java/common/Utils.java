package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Utils {

	private static Logger LOGGER = Logger.getLogger(Utils.class.getName());

	public static Map<Integer, Integer> getMapFromFile(String path) {
		Map<Integer, Integer> map = new HashMap<>();
		File input = new File(path);
		Scanner s = null;
		try {
			s = new Scanner(input);
			int i = 0;
			int helper = 0;
			while (s.hasNext()) {
				String line = s.nextLine();
				if (!line.equals("")) {
					helper += Integer.parseInt(line);
				} else {
					map.put(i, helper);
					i++;
					helper = 0;
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return map;
	}

}
