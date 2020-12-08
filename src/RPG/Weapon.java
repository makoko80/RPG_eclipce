package Rpg;

import java.util.Scanner;

public class Weapon {
	//フィールド

	int equipNow;//現在装備してる武器を意味する数字
					//配列の添え字やswitch構文の条件として使用

	String equipName;//装備中の装備名
	int equipATK;//装備中の装備攻撃力
	boolean haveArray[] = //装備所持判定
			{ true, false, true, false, false, true, true };
	boolean equipArray[] = //装備装着判定
			{ true, false, false, false, false, false, false };
	String nameArray[] = //装備名
			{ "ひのきの棒", "青銅の剣", "鉄の剣",
					"鋼の剣", "チタン合金の剣", "伝説の剣", "素手" };
	int atkArray[] = //攻撃力
			{ 10, 15, 25, 35, 45, 60, 0 };
	String infoArray[] = //説明書き
			{
					"　固い檜でできた棒\n" +
							"　その辺に落ちている",
					"　青銅でできた剣\n" +
							"　文明の狼煙",
					"　青銅でできた剣\n" +
							"　文明の狼煙",
					"　鋼でできた剣\n" +
							"　練度が上がった鉄の剣",
					"　チタン合金って知ってる？\n" +
							"　まるで将棋だな",
					"　言うまでもないレジェンド\n" +
							"　但し使い手を選ぶ",
					"　生まれたままの姿"
			};

	//ゲッター、セッター
	public String getName() {
		return equipName;
	}

	public void setName(String equipName) {
		this.equipName = equipName;
	}

	public int getATK() {
		return equipATK;
	}

	public void setATK(int equipATK) {
		this.equipATK = equipATK;
	}

	//メソッド
	public void showWeapon(Hero h) {
		//武器の一覧表示
		int k;
		do {

			int count = 0;
			System.out.println("----------");
			System.out.println("【武器を選択してください】");
			System.out.println();

			for (int i = 0; i < 6; i++) {
				count++;
				if (haveArray[i] == true) {
					if (equipArray[count - 1]) {
						System.out.print("　E　");
					} else {
						System.out.print("　 　");
					}
					System.out.println(count + "," + nameArray[count - 1]);
				}
			}

			System.out.println();
			System.out.println("　　　0.戻る");
			System.out.println("----------");

			k = new Scanner(System.in).nextInt();
			switch (k) {
			case 0:
				break;
			default:
				if (haveArray[k - 1]) {
					//持ってる装備の数字を入力したとき
					System.out.println("-----------");
					if (equipArray[k - 1]) {
						System.out.println("【装備を外しますか？】");
						System.out.println();
					} else {
						System.out.println("【装備しますか？】");
						System.out.println();
					}
					if (equipArray[k - 1]) {
						System.out.print(" E　");
					} else {
						System.out.print("  　");
					}
					System.out.println(nameArray[k - 1]);
					System.out.println("攻撃力　▲　" + atkArray[k - 1]);
					System.out.print("　　");
					System.out.println((h.getATK() + getATK()) + " → " + (h.getATK() + atkArray[k - 1]));
					System.out.println();
					System.out.println(infoArray[k - 1]);
					System.out.println();
					System.out.println("　　1,Yes　2,No");
					System.out.println("-----------");

					int l;
					l = new Scanner(System.in).nextInt();
					if (l == 1) {
						if (equipArray[k - 1])
						//選択した武器が装備済みの時
						{
							//						equipArray[k-1] = false;
							unarmWeapon(k - 1);
							if ((k - 1) == 6) {
								//素手の時
								//							equipArray[k-1] = true;
								armWeapon(k - 1);
							}
							equipNow = 6;
							if ((k - 1) == 6) {
								//素手の時
								System.out.println("既に素手やんけ！");
								System.out.println("素手は外せない");
							} else {
								//何かしらの武器を装備しているとき
								System.out.println("装備を外して素手になった");
							}
						} else
						//選択した武器が装備されていないとき
						{
							if (equipNow != 7) {
								//何かしらの武器を装備しているとき
								//							equipArray[equipNow] = false;
								unarmWeapon(equipNow);
							}
							//						equipArray[k-1] = true;
							armWeapon(k - 1);
							equipNow = k - 1;
							System.out.println(nameArray[k - 1] + "を装備した！");
						}
					} else if (l == 2) {
						//2.Noを押したときは特に処理しない。
					}
				} else {
					//装備を持ってない番号を入力したとき
					System.out.println("その装備はもっていない！");
				}
			}
		} while (k != 0);
	}

	public void equipWeapon(int equipNow) {
		//Heroインスタンスが武器装備時に名前と攻撃力を設定
		setName(nameArray[equipNow]);
		setATK(atkArray[equipNow]);
	}

	//ショップ用メソッド
	public void gainWeapon(int weaponNumber) {
		haveArray[weaponNumber] = true;
	}

	public void loseWeapon(int weaponNumber) {
		haveArray[weaponNumber] = false;
	}

	//装備装着、装備解除メソッド
	public void armWeapon(int number) {
		equipArray[number] = true;
	}

	public void unarmWeapon(int number) {
		equipArray[number] = false;
	}

	public void test() {
		for (int i = 0; i < 3; i++) {
			if (haveArray[i] == true) {
				System.out.println("true ");
			} else if (haveArray[i] == false) {
				System.out.println("false ");
			}
		}
	}
}
