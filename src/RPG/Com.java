package RPG;

import java.util.ArrayList;
import java.util.Scanner;

public class Com {
	public static Monster com(ArrayList<Monster> m) {

		if (m.size() == 1) {
			return m.get(0);
		} else if (m.size() == 2) {
			System.out.println("攻撃対象を選んでくださいNE");
			System.out.print("1:[" + m.get(0).name + "]" + "2:[" + m.get(1).name + "]>");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
				return m.get(0);
			} else if (c == 2) {
				return m.get(1);
			} else {
				throw new IllegalArgumentException("1か2を入れてよ");
			}
		} else if (m.size() == 3) {
			System.out.println("攻撃対象を選んでくださいNE");
			System.out.print("1:[" + m.get(0).name + "]" + "2:[" + m.get(1).name + "]"
					+ "3:[" + m.get(2).name + "]>");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
				return m.get(0);
			} else if (c == 2) {
				return m.get(1);
			} else if (c == 3) {
				return m.get(2);
			} else {
				throw new IllegalArgumentException("1か2か3を入れてよ");
			}
		}
		return m.get(0);

	}
	//		if (m.alive == false) {
	//			return m1;
	//		} else if (m1.alive == false) {
	//			return m;
	//		}
	//		System.out.println("攻撃対象を選んでくださいNE");
	//		System.out.print("1:[" + m.name + "]" + "2:[" + m1.name + "]>");
	//		int c = new Scanner(System.in).nextInt();
	//		if (c == 1) {
	//			return m;
	//		} else if (c == 2) {
	//			return m1;
	//		} else {
	//			throw new IllegalArgumentException("1か2を入れてよ");
	//		}

}
