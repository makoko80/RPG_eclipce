package Rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

	public static void enCount(Hero h) throws Exception {
		PoisonSlime ps = new PoisonSlime("つらいむ");
		Slime s = new Slime("つらいむ");
		ArrayList<Monster> enemy = new ArrayList<>();
		enemy.add(ps);
		enemy.add(s);
		int enemyCount = 2;

		//ここから戦闘
		System.out.println(ps.name + "と" + s.name + "が現れた");
		System.out.println("　　　　　　　ｒ'￣i\r\n" +
				"　 , - ､　　　　　　　　　ﾞ‐- '\r\n" +
				"　{　　 }　　　　　　　　　　　　　r'⌒',\r\n" +
				"　`‐-‐'　　　　　 r'⌒',　　　　　!、_丿\r\n" +
				"　　◯　　　　　　ヽ-‐'　　＿＿＿\r\n" +
				"　　　　　　ｒ'⌒',　　 ,,r-‐'　　　　　`''ヽ､　　○\r\n" +
				"　　　　　　`‐-' 　／　　　　　　　　　　 ＼\r\n" +
				"　　　　　　, ､ ,,／ r‐､（･） （･）＿　　　　　'─--､,,\r\n" +
				"　　,,r-─（＿）　　ヽ、`── '　 ノ　　　　i⌒)　　 `,\r\n" +
				"　（　　　　　　　　　　`'‐──‐'´　　　　　￣　　,r‐\r\n" +
				"　　￣つ　　　　'⌒'　　　　　　　　　　　,r─‐‐''\r\n" +
				"　　 (´　　　　　　　　　　　　　　,r──'\r\n" +
				"　　　￣￣ﾞ'───--------‐'");

		while (enemyCount > 0) {
			System.out.println("ばぶるつらいむhp[" + ps.hp + "]");
			System.out.println("つらいむhp[" + s.hp + "]");
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
					Monster target = Com.com(enemy.get(0), enemy.get(1));
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
						enemyCount = 0;
						ps.alive = false;
						s.alive = false;
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("コマンドには数字入れてね！！！！");
				continue;
			}
			if (ps.hp <= 0 && ps.alive == true) {
				System.out.println(ps.name + "を倒した");
				ps.alive = false;
				enemyCount--;

			} else if (ps.alive == true) {
				ps.attack(h);
				Battle.time();
			}
			if (s.hp <= 0 && s.alive == true) {
				System.out.println(s.name + "を倒した");
				s.alive = false;
				enemyCount--;

			} else if (s.alive == true) {
				s.attack(h);
				Battle.time();
			}

			if (h.hp <= 0) {
				System.out.println(h.name + "は力尽き、その生涯を終えました");
				enemyCount = 0;
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

}
