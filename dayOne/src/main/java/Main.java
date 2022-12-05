import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		File input = new File("dayOne\\src\\main\\resources\\input.txt");
		try {
			Scanner s = new Scanner(input);
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
