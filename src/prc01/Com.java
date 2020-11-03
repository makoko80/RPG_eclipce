package Rpg;

import java.util.Scanner;

public class Com {

	public static Monster com(Monster m, Monster m1) {
		if (m.alive == false) {
			return m1;
		} else if (m1.alive == false) {
			return m;
		}
		System.out.println("攻撃対象を選んでくださいNE");
		System.out.print("1:[" + m.name + "]" + "2:[" + m1.name + "]>");
		int c = new Scanner(System.in).nextInt();
		if (c == 1) {
			return m;
		} else if (c == 2) {
			return m1;
		} else {
			throw new IllegalArgumentException("1か2を入れてよ");
		}

	}

}
