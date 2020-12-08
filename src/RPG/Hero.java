package Rpg;

import java.util.Random;
import java.util.Scanner;

public class Hero {
	//インスタンス生成の前に下記private int EXPの初期値を確認する
	//コンテナがその初期値に則りLevel,最大HP(=HP),最大MP(=MP),ATKを
	//決定して勇者が誕生する

	//フィールド
	private int EXP;//経験値
	private int Level;//レベル
	private int HP;//HP
	private int MP;//MP
	private int HPMAX;//最大HP
	private int MPMAX;//最大MP
	private int ATK;//最大攻撃力
	private String name;//勇者名
			//実際はプロローグでプレイヤーが初期nameを決定する
	final int LevelMAX = 30;//最大レベル
	final int EXPMAX = 349;//最大経験値
	final int EXPArray[] = {//経験値階層
		10, 10, 10, 10, 10, 10, 10, 10, 10,
		20, 20, 20, 20, 20, 20, 20,
		30, 30, 30, 30,
	};
	boolean inBattle =true;//バトル中判定

	//誕生コンテナ
	public Hero() {
		setLevel();
		setHP(getHPMAX());
		setMP(getMPMAX());
		setATK(getATK());
	}

	//Getter,Setter
	public int getEXP() {
		if(this.EXP <= EXPMAX) {
			return this.EXP;
		} else {
			return EXPMAX;
		}
	}
	public void setEXP(int EXP) {
		if(EXP <= EXPMAX && EXP >= 0) {
			this.EXP = EXP;
		} else if(EXP >= 0) {
			this.EXP = EXPMAX;
		} else {
			System.out.println("EXPの値がマイナスです！");
		}
	}
	public int restEXP() {
		//あといくつのEXPでレベルアップするか計算
		int nextEXP = 0;
		int restEXP;
		for (int j=0; j<getLevel(); j++) {
			nextEXP += EXPArray[j];
		}
		restEXP = nextEXP - getEXP();
		return restEXP;
	}
	public void checkLevelUP(int gainEXP) {
		//獲得経験値量によってレベルが上がるかどうか判定してEXPを設定
		if(gainEXP >= restEXP()) {
			//2レベル以上上がっても大丈夫！
			setEXP(getEXP() + gainEXP);
			setLevel(getEXP());
			System.out.println("レベルがあがった！");
			System.out.println("レベルが" + getLevel() + "になった！");
		}else {
			setEXP(getEXP() + gainEXP);
			setLevel(getEXP());//これはなくても大丈夫だけど保険として
		}
	}
	public int getLevel() {
		return this.Level;
	}
	public void LevelUP(int Level) {
		if(Level <= LevelMAX) {
			this.Level = Level;
		} else {
			this.Level = LevelMAX;
		}
	}
	public void setLevel() {
		//レベルSetterメソッド
		int count = 0;
		int expSUM = 0;

		while(true) {
			expSUM += EXPArray[count];
			count++;
			if(expSUM > getEXP()) {
				break;
			}
		}

		LevelUP(count);
	}
	public void setLevel(int nowEXP) {
		//レベルSetterメソッドの引数とるver
		int count = 0;
		int expSUM = 0;

		while(true) {
			expSUM += EXPArray[count];
			count++;
			if(expSUM > nowEXP) {
				break;
			}
		}
		LevelUP(count);
	}

	public int getHP() {return this.HP;}
	public void setHP(int HP) {
//		HPが0以下になるときはバトルクラスで判定するはずなので記述は見送る
//		if (HP < 0) {
//
//		}
		//最大HPを超える加算が行われる場合は最大HPになる処理に分岐
		if(HP <= getHPMAX()) {
			this.HP = HP;
		} else  {
			this.HP = getHPMAX();
		}
	}

	public int getMP() {return this.MP;}
	public void setMP(int MP) {
		if (MP < 0) {
			System.out.println("MPが負の値です！");
			//MP負の値なのに回復できるのはおかしい！
		}
		//最大MPを超える加算が行われる場合は最大MPになる処理に分岐
		if(MP <= getMPMAX()) {
			this.MP = MP;
		} else  {
			this.MP = getMPMAX();
		}
	}
	public int getHPMAX() {
		//レベルを参照して最大HPを取得する
		int baseMAXHP = 48;

		for (int i=0; i<getLevel(); i++) {
			baseMAXHP += 2;
		}

		HPMAX = baseMAXHP;
		return HPMAX;
	}
	public int getMPMAX() {
		//レベルを参照して最大MPを取得する
		int baseMAXMP = 20;

		if (getLevel() >= 17) {
			baseMAXMP = 40;
		} else if (getLevel() >= 10) {
			baseMAXMP = 30;
		}

		MPMAX = baseMAXMP;
		return MPMAX;
	}
	public int getATK() {
		//レベルを参照してATKを取得する
		int baseATK = 9;
		for (int i=0; i<getLevel(); i++) {
			baseATK++;
		}
		return baseATK;
	}
	public void setATK(int ATK) {this.ATK = ATK;}
	public String getName() {return this.name;}
	public void setName(String name) {
			if (name.length() < 7) {
				this.name = name;
			} else {
				System.out.println("文字数は6文字以内です！");
			}
		}//ここで勇者名の文字数制限や縛りを記入する



	public int attack(Monster ps) {
		int c = new Random().nextInt(4);
		if (c == 0) {
			System.out.println(this.name + "の会心の一撃");
			int cri = (int) (this.ATK * 1.5);
			ps.hp -= cri;
			System.out.println(ps.name + "に" + cri + "ダメージ");
			return ps.hp;
		} else {
			System.out.println(this.name + "の攻撃");
			ps.hp -= this.ATK;
			System.out.println(ps.name + "に" + this.ATK + "のダメージ");
			return ps.hp;
		}
	}
	public void run() {
		System.out.println("勇者は無様に逃げ出しました");
	}

	public boolean heal() {
		boolean turnthrogh = true;
		if (this.MP < 3) {
			System.out.println("MPが足りませんね！！！");
			turnthrogh = false;
		} else {
			this.MP -= 3;
			System.out.println(this.name + "は回復魔法をとなえた");
			int he = Math.min(this.HPMAX - this.HP, 20);
			this.HP += he;
			System.out.println(this.name + "は" + he + "ポイント回復");
		}
		return turnthrogh;

	}

	public void showStatus(Bag b, Weapon w, int d) {
		System.out.println("----------");
		System.out.println();

		if (getLevel() >= 20) {
			System.out.println(
				"勇者" + getName() + "　Lv" + getLevel() + "(あなたは最大レベルです)"
			);
		} else {
			System.out.println(
				"勇者" + getName() + "　Lv" + getLevel() + "(あと" + restEXP() + "EXPでLvUP)"
			);
		}

		System.out.println();
		System.out.println(
				"　　　HP:" + getHP() + "/" + getHPMAX()
					   + " MP:" + getMP() + "/" + getMPMAX()
		);
		System.out.println(
				"　　　EXP:" + getEXP() + " 所持金:" + Bag.gold
		);
		System.out.println(
				"　　　装備:" +
						w.getName() + "(ATK:" + w.getATK() + ")"
		);
		System.out.println(
				"　　　ATK:" +
				(getATK() + w.getATK()) +
				" = (" + getATK() + " + " + w.getATK() + ")"
		);
		System.out.println(
				"　　　最深到達ダンジョン階数:" + "d.floor"
		);
//		ほにゃの代わりにバトルクラスから階数フィールドの値を取得して表記する

		System.out.println();
		System.out.println("　　　　　press Enter to back");
		System.out.println("----------");

		String j;
		j = new Scanner(System.in).nextLine();
	}

}