import common.DayFiveUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		DayFiveUtils.inputToGrid("dayFive\\src\\main\\resources\\input.txt");
		Map<Integer, LinkedList<String>> grid = DayFiveUtils.getGrid();
		List<List<Integer>> instructions = DayFiveUtils.getInstructions();
		stackIt(grid, instructions);
		grid.forEach((k, v) -> System.out.println(k + " " + v));
	}

	private static void stackIt(Map<Integer, LinkedList<String>> grid, List<List<Integer>> instructions) {
		instructions.forEach(instruction -> {
			int quantity = instruction.get(0);
			int originColumn = instruction.get(1);
			int destinationColumn = instruction.get(2);
			LinkedList<String> l = new LinkedList<>();
			for (int i = 1; i <= quantity; i++) {
				String removed = grid.get(originColumn).pop();
				l.addLast(removed);
				//grid.get(destinationColumn).push(removed);
			}
			grid.get(destinationColumn).addAll(0, l);
		});
	}
}
