package Rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	int turn = 1;

	public int enCount(Hero h, ArrayList<Monster> enemy) throws Exception {//敵モンスターをランダムで1～3体まで出現させてHero
		//一人と戦わせるメソッド
		//		int ra = new Random().nextInt(3) + 1;//敵の出現数のランダム整数
		int game = 1;//Heroが倒されたかの判定
		ArrayList<Monster> defeatedMonster = new ArrayList();//倒されたモンスターを入れておく配列
		//		ArrayList<Monster> enemy = new ArrayList<>();
		//		for (int i = 0; i < ra; i++) {
		//			enemy.add(randomEnemyPick(selectFloor));//ランダムで敵と取得してくるメソッド
		//		}

		//ここから戦闘
		for (Monster m : enemy) {
			System.out.print(m.name + " ");
		}
		System.out.println("が現れた");

		while (enemy.size() > 0) {
			boolean turnThrogh = true;//コマンドでターン経過するかしないかの判定
			System.out.println("敵カウント数" + enemy.size());
			for (Monster m : enemy) {
				System.out.print(m.name + " HP[" + m.hp + "]");
			}
			System.out.println();
			System.out.println(h.getName() + "HP[" + h.getHP() + "/" + h.getHPMAX() + "]"
					+ "MP[" + h.getMP() + "/" + h.getMPMAX() + "]");
			System.out.print("[1:戦う2:回復3:モンスター図鑑4:アイテム使用5:逃げる]>");
			try {
				int command = new Scanner(System.in).nextInt();//入力したコマンドで分岐処理
				if (command == 0 || command >= 6) {
					System.out.println("ちゃんとコマンド入れてよ");
					continue;
				}
				switch (command) {
				case 1://戦う処理   ※複数モンスターがいた場合対象を選択する
					Monster target = EnemySelect.select(enemy);
					target.hp = h.attack(target);
					time();
					break;
				case 2://回復する処理
					turnThrogh = h.heal();//MPが足りない場合はターン経過なしにする
					time();
					break;
				case 3://図鑑を呼ぶ処理
					System.out.println("モンスター図鑑呼ぶ");
					time();
					turnThrogh = false;
					break;
				case 4:
					System.out.println("アイテム使用");
					turnThrogh = false;
					break;
				case 5://逃げる処理
					h.run();
					time();
					int ru = new Random().nextInt(3);//三回に一回失敗する
					if (ru == 0) {
						System.out.println("しかし回り込まれてしまった");
					} else {
						enemy.clear();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("コマンドには数字入れてね！！！！");
				this.turn -= 1;
				continue;
			}
			if (turnThrogh == false) {
				this.turn = -1;
				continue;
			}
			for (int i = 0; i < enemy.size(); i++) {
				enemy.get(i).checkAlive(h, enemy.get(i));
			}
			for (int i = 0; i < enemy.size(); i++) {
				if (enemy.get(i).getAlive() == false) { //False、配列から除外
					defeatedMonster.add(enemy.get(i));
					enemy.remove(i);
				}
			}

			System.out.println("---------------------");
			if (h.getHP() <= 0) {
				System.out.println(h.getName() + "は力尽き、目の前が真っ黒になった");
				game = 0;
				break;
			}
		}
		System.out.println("戦闘終了");
		for (Monster m : defeatedMonster) {
			System.out.println(m.name);
		}
		System.out.println("を倒した");
		//HeroEXPを計算するメソッド呼び出し
		System.out.println("---------------------");
		return game;
	}

	public void time() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

//	public Monster randomEnemyPick(int selectFloor) {
//		int r = new Random().nextInt(3);
//		Monster m = null;
//		Monster[] floorMonster = new Monster[9];
//		floorMonster = monsterList(floorMonster);
//		switch (selectFloor) {
//		case 1:
//			m = floorMonster[r];
//			break;
//		case 2:
//			m = floorMonster[(r + 3)];
//			break;
//		case 3:
//			m = floorMonster[(r + 6)];
//			break;
//		}
//		return m;
//	}
//
//	public Monster[] monsterList(Monster[] floorMonster) {
//		floorMonster[0] = new Slime("ごみ");
//		floorMonster[1] = new PoisonSlime("時代");
//		floorMonster[2] = new Slime("永遠の世界2位さん");
//		floorMonster[3] = new Slime("伝説のスーパー短パン小僧");
//		floorMonster[4] = new Slime("原子力航空母艦「エンタープライズ」");
//		floorMonster[5] = new Slime("しゅーきんぺー");
//		floorMonster[6] = new Slime("ガースー");
//		floorMonster[7] = new Slime("じょんそんぼりす");
//		floorMonster[8] = new Slime("と〇らんぷ");
//		return floorMonster;
//	}

}
