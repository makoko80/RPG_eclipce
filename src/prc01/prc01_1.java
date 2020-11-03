package prc01;

public class prc01_1 {
	public static int[] makeProblem(int num) {
		int[] newNum = new int[num];
		for (int i = 0; i < newNum.length; i++) {
			newNum[i] = new java.util.Random().nextInt(3);
		}
		return newNum;

	}

	public static void main(String[] args) {
		int[] problem = makeProblem(3);
		for (int i = 0; i < problem.length; i++) {
			switch (problem[i]) {
			case 0:
				System.out.println("問題1");
				break;
			case 1:
				System.out.println("問題2");
				break;
			case 2:
				System.out.println("問題3");
				break;
			}
		}

	}

}
