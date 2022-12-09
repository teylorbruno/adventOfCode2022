package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class DaySixUtils {

	private static final int WORD_SIZE = 14;

	private static int charCount = 0;
	private static Logger LOGGER = Logger.getLogger(DaySixUtils.class.getName());

	public static Map<String, Integer> marker(String path) {
		Map<String, Integer> map = new HashMap<>();
		File input = new File(path);
		try {
			Scanner s = new Scanner(input);
			String line = s.nextLine();
			for (int i = 0; i <= line.length() - WORD_SIZE; i++) {
				String mark = line.substring(i, i + WORD_SIZE);
				if (!hasDuplicatedCharacter(mark.toCharArray(), mark)) {
					System.out.println(line.indexOf(mark)+WORD_SIZE);
					break;
				}
				map.put(mark, i);
			}

		} catch (FileNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		return map;
	}

	private static boolean hasDuplicatedCharacter(char[] splitted, String mark) {
		boolean hasDuplicatedChar = Boolean.FALSE;
		for (char character : splitted) {
			charCount++;
			if (mark.indexOf(character) != mark.lastIndexOf(character)) {
				hasDuplicatedChar = Boolean.TRUE;
				break;
			}
		}
		return hasDuplicatedChar;
	}

}
