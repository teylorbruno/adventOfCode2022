import common.DayThreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<Map<String, Integer>> sameLetterList = new ArrayList<>();
		List<Map<String, Integer>> anotherSameLetterList = new ArrayList<>();
		Map<String, String> rucksackEx1 = DayThreeUtils.convertFileIntoMap("dayThree\\src\\main\\resources\\input.txt");
		Map<String, List<String>> rucksackEx2 = DayThreeUtils.convertFileIntoMapWithList("dayThree\\src\\main\\resources\\input.txt");
		exercise1(sameLetterList, rucksackEx1);
		exercise2(rucksackEx2, anotherSameLetterList);
	}

	private static void exercise2(Map<String, List<String>> rucksackEx2, List<Map<String, Integer>> prioritiesLetterList) {
		rucksackEx2.forEach((k, v) -> {
			for (String character : k.split("")) {
				if (v.get(0).contains(character) && v.get(1).contains(character)) {
					Map<String, Integer> result = new HashMap<>();
					result.put(character, DayThreeUtils.getPrioritiesMap().get(character));
					prioritiesLetterList.add(result);
					return;
				}
			}
		});
		sumAllPriorities("EX2:",prioritiesLetterList);
	}

	private static void exercise1(List<Map<String, Integer>> sameLetterList, Map<String, String> splitedStringsMap) {
		splitedStringsMap.forEach((k, v) -> {
			String[] keySplitted = k.split("");
			for (String character : keySplitted) {
				if (v.contains(character)) {
					Map<String, Integer> sameLetterMap = new HashMap<>();
					sameLetterMap.put(character, DayThreeUtils.getPrioritiesMap().get(character));
					sameLetterList.add(sameLetterMap);
					//System.out.println(k + " - " + v + " [" + character + "]");
					return;
				}
			}
		});
		sumAllPriorities("EX1:",sameLetterList);
	}

	private static void sumAllPriorities(String exercise,List<Map<String, Integer>> sameLetterList) {
		int total = 0;
		for (Map stringIntegerMap : sameLetterList) {
			total += (Integer) stringIntegerMap.values().iterator().next();
		}
		System.out.println(exercise + total);
	}

}
