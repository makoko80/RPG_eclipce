package RPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

	public void enCount(Hero h) throws Exception {
		int ra = new Random().nextInt(3) + 1;//敵の出現数のランダム整数

		ArrayList<Monster> enemy = new ArrayList<>();
		for (int i = 0; i < ra; i++) {
			enemy.add(randomEnemyPick());//ランダムで敵と取得してくるメソッド
		}

		//ここから戦闘
		for (Monster m : enemy) {
			System.out.print(m.name + " ");
		}
		System.out.println("が現れた");

		while (enemy.size() > 0) {
			System.out.println("敵カウント数" + enemy.size());
			for (Monster m : enemy) {
				System.out.print(m.name + " HP[" + m.hp + "]");
			}
			System.out.println();
			System.out.println(h.name + "HP[" + h.hp + "/" + h.FULLHP + "]");
			System.out.print("[1:戦う2:回復3:様子を見る4:逃げる]>");
			try {
				int command = new Scanner(System.in).nextInt();//入力したコマンドで分岐処理
				if (command == 0 || command >= 5) {
					System.out.println("ちゃんとコマンド入れてよ");
					continue;
				}
				switch (command) {
				case 1://戦う処理   ※複数モンスターがいた場合対象を選択する
					Monster target = Com.com(enemy);
					target.hp = h.attack(target);
					Battle.time();
					break;
				case 2://回復する処理
					h.heal();
					Battle.time();
					break;
				case 3://様子を見る処理
					h.waiting();
					Battle.time();
					break;
				case 4://逃げる処理
					h.run();
					Battle.time();
					int ru = new Random().nextInt(3);//三回に一回失敗する
					if (ru == 0) {
						System.out.println("しかし回り込まれてしまった");
					} else {
						for (int i = 0; i < enemy.size(); i++) {
							enemy.get(i).alive = false;
							enemy.remove(i);
						}
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("コマンドには数字入れてね！！！！");
				continue;
			}
			for (int i = 0; i < enemy.size(); i++) {
				boolean b = enemy.get(i).checkAlive(h, enemy.get(i));
				if (b == false) {
					enemy.remove(i);
				}
			}

			if (h.hp <= 0) {
				System.out.println(h.name + "は力尽き、その生涯を終えました");
				break;
			}
		}
		System.out.println("戦闘終了");
	}

	public static void time() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public Monster randomEnemyPick() {
		int r = new Random().nextInt(3);
		if (r == 0) {
			PoisonSlime ps = new PoisonSlime("つらいむ");
			return ps;
		} else {
			Slime s = new Slime("つらいむ");
			return s;
		}
	}

}
