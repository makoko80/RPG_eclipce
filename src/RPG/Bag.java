package Rpg;

import java.util.Scanner;

public class Bag {
	//フィールド
	static int gold = 1000;//所持ゴールド

	final int yakusoMAX = 10;//薬草最大所持数
	final int enmakuMAX = 3;//煙幕最大所持数
	final int sakeMAX = 5;//酒最大所持数
	final int tobaccoMAX = 1;//タバコ最大所持数
	final int elixirMAX = 1;//エリクサー最大所持数

	private int stockArray[] = //所持数
			{ 8, 3, 5, 1, 1 };

	String infoArray[] = //アイテム情報
			{
					"使うとHPを10回復\n" +
							"　　　　用法容量を守ろう",
					"尋常ではない量の煙を起こす\n" +
							"　　　　戦闘から退避する際に便利",
					"気つけや嗜好品として使用される\n" +
							"　　　　使うとテンションアップ",
					"ニコチンとタールを摂取できる\n" +
							"　　　　喫煙者の必需品",
					"強力な秘薬\n" +
							"　　　　使いどころが肝要"
			};

	String nameArray[] = { //アイテム名
			"薬草",
			"煙幕",
			"酒",
			"タバコ",
			"ｴﾘｸｻｰ"
	};

	//Getter,Setter
	public int getYakuso() {
		return getCount(0);
	}

	public void setYakuso(int yakuso) {
		checkMAX(yakuso, yakusoMAX);
		this.stockArray[0] = yakuso;
	}

	public int getEnmaku() {
		return getCount(1);
	}

	public void setEnmaku(int enmaku) {
		checkMAX(enmaku, enmakuMAX);
		this.stockArray[1] = enmaku;
	}

	public int getSake() {
		return getCount(2);
	}

	public void setSake(int sake) {
		checkMAX(sake, sakeMAX);
		this.stockArray[2] = sake;
	}

	public int getTobacco() {
		return getCount(3);
	}

	public void setTobacco(int tobacco) {
		checkMAX(tobacco, tobaccoMAX);
		this.stockArray[3] = tobacco;
	}

	public int getElixir() {
		return getCount(4);
	}

	public void setElixir(int elixir) {
		checkMAX(elixir, elixirMAX);
		this.stockArray[4] = elixir;
	}

	public int getCount(int n) {
		return this.stockArray[n];
	}

	//	アイテム表示のメソッド
	public void showBag(Hero h, Bag b) {
		int i = 0;
		do {
			System.out.println("-------------");
			System.out.println("【何を使用しますか？】");
			System.out.println();
			System.out.println("　　　　1.薬草　：" + getYakuso() + "/" + yakusoMAX + "個");
			System.out.println("　　　　2.煙幕　：" + getEnmaku() + "/" + enmakuMAX + "個");
			System.out.println("　　　　3.酒　　：" + getSake() + "/" + sakeMAX + "個");
			System.out.println("　　　　4.タバコ：" + getTobacco() + "/" + tobaccoMAX + "個");
			System.out.println("　　　　5.ｴﾘｸｻｰ ：" + getElixir() + "/" + elixirMAX + "個");
			System.out.println();
			System.out.println("{アイテムNo.を入力してください}(0.戻る)>");
			System.out.println("-------------");
			System.out.println();

			i = new Scanner(System.in).nextInt();

			int k = 0;
			SelectItem si = new SelectItem();

			switch (i) {
			case 0:
				break;
			case 1:
				si.selectItem(b, h, i);

				k = new Scanner(System.in).nextInt();
				if (k == 1) {
					b.useYakuso(h);
				} else if (k == 2) {
					//何もしない
				}
				break;
			case 2:
				si.selectItem(b, h, i);

				k = new Scanner(System.in).nextInt();
				if (k == 1) {
					b.useEnmaku(h);
				} else if (k == 2) {
					//何もしない
				}
				break;
			case 3:
				si.selectItem(b, h, i);

				k = new Scanner(System.in).nextInt();
				if (k == 1) {
					b.useSake(h);
				} else if (k == 2) {
					//何もしない
				}
				break;
			case 4:
				si.selectItem(b, h, i);

				k = new Scanner(System.in).nextInt();
				if (k == 1) {
					b.useTobacco(h);
				} else if (k == 2) {
					//何もしない
				}
				break;
			case 5:
				si.selectItem(b, h, i);

				k = new Scanner(System.in).nextInt();
				if (k == 1) {
					b.useElixir(h);
				} else if (k == 2) {
					//何もしない
				}
				break;
			}
		} while (i != 0);
	}

	//アイテム使用のメソッド
	public void useYakuso(Hero h) {
		if (h.inBattle) {//バトル中
			if (getYakuso() > 0) {
				//薬草があるとき
				if (h.getHP() < h.getHPMAX()) {
					//ダメージを受けているとき
					int kizu = h.getHPMAX() - h.getHP();
					if (kizu < 10) {
						//ダメージが一桁のとき
						setYakuso(getYakuso() - 1);
						h.setHP(h.getHP() + kizu);
						System.out.println("HPが" + kizu + "回復した！");
						System.out.println("HPが最大の" + h.getHPMAX() + "になった！");
					} else {
						//ダメージが二桁以上の時
						setYakuso(getYakuso() - 1);
						h.setHP(h.getHP() + 10);
						System.out.println("HPが10回復した！");
						System.out.println("HP:" + h.getHP() + "/" + h.getHPMAX());
					}
				} else {
					//無傷のとき
					System.out.println("HPは十分にある。元気だから使わなくていいかな。");
				}

			} else {
				//薬草がないとき
				System.out.println("薬草がないため回復できない！");
			}
		} else {//バトル外
			if (getYakuso() > 0) {
				if (h.getHP() < h.getHPMAX()) {
					int kizu = h.getHPMAX() - h.getHP();
					if (kizu < 10) {
						setYakuso(getYakuso() - 1);
						h.setHP(h.getHP() + kizu);
						System.out.println("HPが" + kizu + "回復した！");
						System.out.println("HPが最大の" + h.getHPMAX() + "になった！");
					} else {
						setYakuso(getYakuso() - 1);
						h.setHP(h.getHP() + 10);
						System.out.println("HPが10回復した！");
						System.out.println("HP:" + h.getHP() + "/" + h.getHPMAX());
					}
				} else {
					System.out.println("HPは十分にある。元気だから使わなくていいかな。");
				}
			} else {
				System.out.println("薬草がないため回復できない！");
			}
		}
	}

	public void useEnmaku(Hero h) {
		if (h.inBattle) {
			if (getEnmaku() > 0) {
				setEnmaku(getEnmaku() - 1);
				//			h.run(); 逃げるを確定で実行できるような処理を実装
			} else {
				System.out.println("煙幕を持っていない");
			}
		} else {
			if (getEnmaku() > 0) {
				setEnmaku(getEnmaku() - 1);
				System.out.println("煙幕を使用した！");
				System.out.println("煙たくなっただけだった");
			} else {
				System.out.println("煙幕を持っていない");
			}
		}
	}

	public void useSake(Hero h) {
		if (h.inBattle) {
			if (getSake() > 0) {
				setSake(getSake() - 1);
				System.out.println("戦闘中に酒を飲んだ！");
				System.out.println("歌でも歌いたい様ないい気分だ！");
			} else {
				System.out.println("酒を持っていない");
			}
		} else {
			if (getSake() > 0) {
				setSake(getSake() - 1);
				System.out.println("昼から酒を飲んだ！");
				System.out.println("陽気な気分になった！");
			} else {
				System.out.println("酒を持っていない");
			}
		}
	}

	public void useTobacco(Hero h) {
		if (h.inBattle) {
			if (getTobacco() > 0) {
				setTobacco(getTobacco() - 1);
				System.out.println("戦闘中に喫煙した！");
				System.out.println("ふぅ…落ち着いてきた");
			} else {
				System.out.println("タバコを切らしている");
			}
		} else {
			if (getTobacco() > 0) {
				setTobacco(getTobacco() - 1);
				System.out.println("路上喫煙に踏み切った！");
				System.out.println("周りの視線が痛い！");
			} else {
				System.out.println("タバコを切らしている");
			}
		}
	}

	public void useElixir(Hero h) {
		if (h.inBattle) {
			if (getElixir() > 0) {
				setElixir(getElixir() - 1);
				h.setHP(h.getHPMAX());
				h.setMP(h.getMPMAX());
				System.out.println("エリクサーを使用した！");
				System.out.println("HPとMPが全回復した！");
			} else {
				System.out.println("エリクサーを持っていない");
			}
		} else {
			if (getElixir() > 0) {
				System.out.println("エリクサーはあるものの…もったいない気がする");
			} else {
				System.out.println("エリクサーを持っていない");
			}
		}
	}

	public void checkMAX(int i, int MAX) {
		//		何かイベント上でアイテムが増えるときは必ず
		//		このメソッドを実行する→Setterに含めておいた
		if (i > MAX) {
			System.out.println("所持数がいっぱいだ！");
			i = MAX;
			System.out.println("持ちきれないアイテムは溢れてしまった！");
		}
	}
}
