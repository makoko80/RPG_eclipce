package Rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
	private int floor;//到達した階層
	private int selectFloor;//進む階層

	public Dungeon() {
		this.floor = 1;
		this.selectFloor = 1;
	}

	public int dungeonAction(Hero h, int gameLoop) throws Exception {//ダンジョンの進行メイン
		int dungeonCommand;
		int Progress = 1;//進行度
		this.selectFloor = (dungeonSelect(this.floor));//ダンジョン階層を選択
		while (Progress <= 10) {//ダンジョンでの行動は5回まで、町へ戻るはループ抜ける。
			System.out.println("現在" + this.selectFloor + "階層");
			System.out.println("進行度" + Progress);
			System.out.println(h.getName() + "HP[" + h.getHP() + "]" + "MP[" + h.getMP() + "]");
			System.out.println("コマンド選択");
			System.out.println("----------------");
			System.out.print("1[進む] 2[アイテム使用] 3[町に戻る]>");
			dungeonCommand = new Scanner(System.in).nextInt();
			switch (dungeonCommand) {
			case 1:
				gameLoop = moveOn(h, Progress);
				Progress++;

				if (gameLoop == 0) {
					Progress = 99;
				} else if (gameLoop == 2) {
					this.floor++;
					gameLoop = 1;
				}
				break;
			case 2:
				System.out.println("アイテム使用コマンド（未定義）");
				break;
			case 3:
				System.out.println("町に戻る（未定義）");
				Progress = 99;
				break;
			default:
				throw new IllegalArgumentException("1か2か3を入れてよ");

			}
		}

		return gameLoop;
	}

	public int moveOn(Hero h, int Progress) throws Exception {
		int r = new Random().nextInt(2);
		//		r = 1;//テスト
		int game = 1;
		Battle b = new Battle();
		if (r == 1 && Progress != 5 && Progress != 10) {
			int ra = new Random().nextInt(3) + 1;//敵の出現数のランダム整数
			ArrayList<Monster> enemy = new ArrayList<>();
			for (int i = 0; i < ra; i++) {
				enemy.add(randomEnemyPick(selectFloor));//ランダムで敵と取得してくるメソッド
			}
			game = b.enCount(h, enemy);
		} else {
			System.out.println("ダンジョンイベントだぉ");
			//			if (Progress == 5) {テストコード
			//				game = 2;
			//			}
			//			if (Progress == 5 && this.floor == 3) {
			//				game = 3;
			//			}
			//ダンジョンイベントを呼んでくる
		}
		return game;

	}

	public int dungeonSelect(int floor) {//進行するダンジョンを選択
		int f = 1; //選択する階層の数値
		switch (floor) {
		case 1:
			f = 1;
			break;
		case 2:
			System.out.println("どの階層に進みますか？");
			System.out.println("1:[1階層] 2:[2階層]");
			f = new Scanner(System.in).nextInt();
			break;
		case 3:
			System.out.println("どの階層に進みますか？");
			System.out.println("1:[1階層] 2:[2階層] 3:[3階層]");
			f = new Scanner(System.in).nextInt();
			break;
		}
		return f;
	}

	public Monster randomEnemyPick(int selectFloor) {
		int r = new Random().nextInt(3);
		Monster m = null;
		Monster[] floorMonster = new Monster[9];
		floorMonster = monsterList(floorMonster);
		switch (selectFloor) {
		case 1:
			m = floorMonster[r];
			break;
		case 2:
			m = floorMonster[(r + 3)];
			break;
		case 3:
			m = floorMonster[(r + 6)];
			break;
		}
		return m;
	}

	public Monster[] monsterList(Monster[] floorMonster) {
		floorMonster[0] = new Slime("ごみ");
		floorMonster[1] = new PoisonSlime("時代");
		floorMonster[2] = new Slime("永遠の世界2位さん");
		floorMonster[3] = new Slime("伝説のスーパー短パン小僧");
		floorMonster[4] = new Slime("原子力航空母艦「エンタープライズ」");
		floorMonster[5] = new Slime("しゅーきんぺー");
		floorMonster[6] = new Slime("ガースー");
		floorMonster[7] = new Slime("じょんそんぼりす");
		floorMonster[8] = new Slime("と〇らんぷ");
		return floorMonster;
	}

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int f) {
		this.floor = f;
	}

}
