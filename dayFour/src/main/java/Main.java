import common.DayFourUtils;

import java.util.Map;

public class Main {

	private static int ex1 = 0;
	private static int ex2 = 0;
	private static int runs = 0;


	public static void main(String[] args) {
		Map<Integer, Map<Map<Integer, Integer>, Map<Integer, Integer>>> intervals = DayFourUtils.inputToMapWithRanges("dayFour\\src\\main\\resources\\input.txt");

		intervals.forEach((k, v) -> {
			v.forEach((range1, range2) -> {
				int r1Num1 = (int) range1.keySet().toArray()[0];
				int r1Num2 = range1.get(r1Num1);
				int r2Num1 = (int) range2.keySet().toArray()[0];
				int r2Num2 = range2.get(r2Num1);
				ex1(r1Num1, r1Num2, r2Num1, r2Num2);
				ex2(r1Num1, r1Num2, r2Num1, r2Num2);
			});
		});
		System.out.println(ex1);
		System.out.println(ex2);
	}

	private static void ex2(int r1, int r2, int n1, int n2) {
		if (r1 <= n1 && r2 >= n1) {
			ex2++;
		} else if (n1 <= r1 && n2 >= r1) {
			ex2++;
		}
	}

	private static void ex1(int r1Num1, int r1Num2, int r2Num1, int r2Num2) {
		if (r1Num1 <= r2Num1 && r1Num2 >= r2Num2) {
			ex1++;
			return;
		}
		if (r2Num1 <= r1Num1 && r2Num2 >= r1Num2) {
			ex1++;
			return;
		}
	}

}
