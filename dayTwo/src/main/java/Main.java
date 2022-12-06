import common.Utils;

import java.util.Map;

public class Main {

	private static Integer player2ScoreRoundOne = 0;
	private static Integer player2ScoreRoundTwo = 0;
	private static final int LOSS = 0;
	private static final int DRAW = 3;
	private static final int WIN = 6;

	public static void main(String[] args) {
		Map<String, Integer> hands = Utils.getMapWithPatternCountFromFile("dayTwo\\src\\main\\resources\\input.txt");
		hands.forEach((k, v) -> {
			String[] hand = k.split(" ");
			String p1 = hand[0];
			String p2 = hand[1];
			playRoundOne(p1, p2, v);
			playRoundTwo(p1, p2, v);
		});
		System.out.println("Round one:" + player2ScoreRoundOne);
		System.out.println("Round two:" + player2ScoreRoundTwo);
	}

	private static void playRoundOne(String p1, String p2, int multiply) {
		Player1 p1Hand = player1Hand(p1);
		Player2 p2Hand = player2Hand(p2);
		boolean sameHand = p1Hand.getText().equalsIgnoreCase(p2Hand.getText());
		if (sameHand) {
			player2ScoreRoundOne += (p2Hand.getScore() + DRAW) * multiply;
		} else {
			if (p1Hand.getText().equalsIgnoreCase(Handz.ROCK) && p2Hand.getText().equalsIgnoreCase(Handz.SCISSORS)) {
				player2ScoreRoundOne += (p2Hand.getScore() + LOSS) * multiply;
			}
			if (p1Hand.getText().equalsIgnoreCase(Handz.ROCK) && p2Hand.getText().equalsIgnoreCase(Handz.PAPER)) {
				player2ScoreRoundOne += (p2Hand.getScore() + WIN) * multiply;
			}
			if (p1Hand.getText().equalsIgnoreCase(Handz.SCISSORS) && p2Hand.getText().equalsIgnoreCase(Handz.PAPER)) {
				player2ScoreRoundOne += (p2Hand.getScore() + LOSS) * multiply;
			}
			if (p1Hand.getText().equalsIgnoreCase(Handz.SCISSORS) && p2Hand.getText().equalsIgnoreCase(Handz.ROCK)) {
				player2ScoreRoundOne += (p2Hand.getScore() + WIN) * multiply;
			}
			if (p1Hand.getText().equalsIgnoreCase(Handz.PAPER) && p2Hand.getText().equalsIgnoreCase(Handz.SCISSORS)) {
				player2ScoreRoundOne += (p2Hand.getScore() + WIN) * multiply;
			}
			if (p1Hand.getText().equalsIgnoreCase(Handz.PAPER) && p2Hand.getText().equalsIgnoreCase(Handz.ROCK)) {
				player2ScoreRoundOne += (p2Hand.getScore() + LOSS) * multiply;
			}
		}
	}

	private static void playRoundTwo(String p1, String p2, int multiply) {
		Player1 player1 = player1Hand(p1);
		if (p2.equalsIgnoreCase("X")) {
			Player2 lossHand = determineLossHand(player1);
			player2ScoreRoundTwo += (lossHand.getScore() + LOSS) * multiply;
		}
		if (p2.equalsIgnoreCase("Y")) {
			Player2 drawHand = determineDrawHand(player1);
			player2ScoreRoundTwo += (drawHand.getScore() + DRAW) * multiply;
		}
		if (p2.equalsIgnoreCase("Z")) {
			Player2 winHand = determineWinHand(player1);
			player2ScoreRoundTwo += (winHand.getScore() + WIN) * multiply;
		}
	}

	private static Player2 determineWinHand(Player1 p1) {
		if (p1.getText().equalsIgnoreCase(Handz.SCISSORS)) {
			return Player2.ROCK;
		}
		if (p1.getText().equalsIgnoreCase(Handz.ROCK)) {
			return Player2.PAPER;
		}
		return Player2.SCISSORS;
	}

	private static Player2 determineDrawHand(Player1 p1) {
		if (p1.getText().equalsIgnoreCase(Handz.SCISSORS)) {
			return Player2.SCISSORS;
		}
		if (p1.getText().equalsIgnoreCase(Handz.ROCK)) {
			return Player2.ROCK;
		}
		return Player2.PAPER;
	}

	private static Player2 determineLossHand(Player1 p1) {
		if (p1.getText().equalsIgnoreCase(Handz.SCISSORS)) {
			return Player2.PAPER;
		}
		if (p1.getText().equalsIgnoreCase(Handz.ROCK)) {
			return Player2.SCISSORS;
		}
		return Player2.ROCK;
	}

	private interface Handz {
		String ROCK = "rock";
		String PAPER = "paper";
		String SCISSORS = "scissors";
	}

	private static enum Player1 {
		ROCK(Handz.ROCK, "A", 1),
		PAPER(Handz.PAPER, "B", 2),
		SCISSORS(Handz.SCISSORS, "C", 3);

		private String text;
		private String hand;
		private int score;

		Player1(String text, String hand, int score) {
			this.text = text;
			this.hand = hand;
			this.score = score;
		}

		private String getText() {
			return this.text;
		}

		private String getHand() {
			return this.hand;
		}

		public int getScore() {
			return score;
		}

	}

	private static enum Player2 {
		//LOSS
		ROCK(Handz.ROCK, "X", 1),
		//DRAW
		PAPER(Handz.PAPER, "Y", 2),
		//WIN
		SCISSORS(Handz.SCISSORS, "Z", 3);

		private String text;
		private String hand;
		private int score;

		Player2(String text, String hand, int score) {
			this.text = text;
			this.hand = hand;
			this.score = score;
		}

		public String getText() {
			return text;
		}

		public String getHand() {
			return hand;
		}

		public int getScore() {
			return score;
		}

	}

	public static Player1 player1Hand(String player1Hand) {
		Player1 currentHand = null;
		for (Player1 hand : Player1.values()) {
			if (player1Hand.equalsIgnoreCase(hand.getHand())) {
				currentHand = hand;
			}
		}
		return currentHand;
	}

	public static Player2 player2Hand(String player2Hand) {
		Player2 currentHand = null;
		for (Player2 hand : Player2.values()) {
			if (player2Hand.equalsIgnoreCase(hand.getHand())) {
				currentHand = hand;
			}
		}
		return currentHand;
	}


}
