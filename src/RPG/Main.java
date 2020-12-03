package Rpg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Hero h = new Hero();
		Dungeon d = new Dungeon();
		int gameLoop = 1;

		//プロローグ

		while (gameLoop == 1) {//1以外はクリアの判定にする
			System.out.println("[城下町]");
			System.out.println(h.name + "「何をしようか？」");
			System.out.println("[1:メニュー 2:町の人と話す 3:ダンジョンへ行く "
					+ "4:宿屋へ行く5:ショップへ行く]>");
			int select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1:
				System.out.println("めぬークラス呼び出し");
				break;
			case 2:
				System.out.println("イベントクラス呼び出し");
				break;
			case 3:
				gameLoop = d.dungeonAction(h, gameLoop);
				break;
			case 4:
				System.out.println("宿屋イベントだぉ");
				break;
			case 5:
				System.out.println("ショップイベントだぉ");
			}
			if (gameLoop == 0) {
				System.out.println("〇〇「何だしんでしまうとは情けない」");
				Thread.sleep(1000);
				System.out.println("〇〇「回復しておいたからさっさと行ってこい」");
				Thread.sleep(1000);
				gameLoop = 1;
			}
			System.out.println("--------------------------------------");

		}

	}

}
