package Rpg;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {
	private int floor;//到達した階層
	private int selectFloor;//進む階層

	public Dungeon() {
		this.floor = 3;
		this.selectFloor = 1;
	}

	public int dungeonAction(Hero h, int gameLoop) throws Exception {//ダンジョンの進行メイン
		int dungeonCommand;
		int Progress = 0;//進行度
		this.selectFloor = (dungeonSelect(this.floor));//ダンジョン階層を選択
		while (Progress <= 5) {//ダンジョンでの行動は5回まで、町へ戻るはループ抜ける。
			System.out.println("現在" + this.selectFloor + "階層");
			System.out.println("進行度" + Progress);
			System.out.println(h.name + "HP[" + h.hp + "]" + "MP[" + h.mp + "]");
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
		int game = 1;
		Battle b = new Battle();
		if (r == 1) {
			game = b.enCount(h, this.selectFloor);
		} else {
			System.out.println("ダンジョンイベントだぉ");
			game = 1;
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

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int f) {
		this.floor = f;
	}

}
