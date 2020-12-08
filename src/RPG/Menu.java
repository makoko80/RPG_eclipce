package Rpg;

import java.util.Scanner;

public class Menu {
	public void menu() {
		Bag b = new Bag();
		Weapon w = new Weapon();
		Hero h = new Hero();
//		MonsterBook mb = new MonsterBook();
//		実際インスタンス化はメインクラスで行うためテスト用

		Shop s = new Shop();//ショップクラスはMenuで使われない
		int floor = 1;//ダンジョンインスタンスの.floor

		while(true) {
			//Weaponの名前と攻撃力を再設定
			w.equipWeapon(w.equipNow);
			//HeroのもつWeaponを再設定

			System.out.println("----------");
			System.out.println();
			System.out.println
					("【任意のメニューを選択してください】");
			System.out.println();
			System.out.println
					("①.ステータス ②.アイテム ③.装備 ④.図鑑");
			System.out.println();
			System.out.println("----------");

			int i = new Scanner(System.in).nextInt();
			switch (i) {
				case 1:
					h.showStatus(b, w, floor);
					break;
				case 2:
					b.showBag(h, b);
					break;
				case 3:
					w.showWeapon(h);
					break;
				case 4:
					System.out.println();
					System.out.println("！！！！！！！！！！！！！");
					System.out.println("!【図鑑処理の画面表示】!");
					System.out.println("！！！！！！！！！！！！！");
					System.out.println();
//					mb.showMonsterBook();とか？
					break;
				case 0://Shopテスト用選択肢（臨時）
					s.goItemShop(b);
					break;
			}
		}
}


//			case 1:
//				s.goItemShop(b);
//				break;
//			case 2:
//
//				System.out.println();
//				System.out.println("！！！！！！！！！！！！！");
//				System.out.println("!【この処理はまだ未完成】!");
//				System.out.println("！！！！！！！！！！！！！");
//				System.out.println();
//
//				s.goWeaponShop(w);
//				break;
}

