package RPG;

import java.util.Scanner;

public class Chaban {

	public static void time(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {

		}
	}

	public static int prologue(Hero h) {
		int t = 750;
		int t1 = 1000;
		Charcter king = new Charcter("おーさま");
		int select;
		System.out.println(king.name + "「よくぞ参ったゆーしゃ" + h.name + "よ」");
		time(t);
		System.out.println(king.name + "「・・・で魔王倒してほしいんだけど」");
		time(t);
		System.out.println("    ・");
		time(t);
		System.out.println("    ・");
		time(t);
		System.out.println("    ・");
		time(t);
		System.out.println(king.name + "に協力して魔王を倒しますか？");
		System.out.print("[1:はい2:いいえ]>");
		select = new Scanner(System.in).nextInt();
		if (select == 2) {
			System.out.println(king.name + "「何と！わしの言うことが利けぬと申すか！」");
			time(t);
			System.out.println(king.name + "「もうよい！貴様は下がっておれ！わしが出撃する！」");
			time(t);
			System.out.println("※主人公が王様になりました");
			System.out.println("続く");
			return 4;

		} else {
			System.out.println(king.name + "「それでこそゆーしゃじゃ」");
			time(t1);
			System.out.println(king.name + "「我が国の伝説の装備をそなたに授けよう」");
			time(t1);
			System.out.println(king.name + "「何が出るかはお楽しみじゃが」");
			time(t1);
			System.out.println(king.name + "「リセマラとかしないでね❤」");
			time(t1);
			System.out.println(h.name + "は宝箱を開けた");
			time(t);
			System.out.println("    ・");
			time(t);
			System.out.println("    ・");
			time(t);
			System.out.println("    ・");
			time(t1);

			return new java.util.Random().nextInt(3);
		}

	}

}
