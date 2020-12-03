package Rpg;

import java.util.Random;

public class Hero {
	String name;
	int hp;
	final int FULLHP = 50;
	final int FULLMP = 20;
	int mp;
	int pow;

	public Hero() {
		this.name = "ハロルド";
		this.hp = 10;
		this.mp = 5;
		this.pow = 10;
	}

	public int attack(Monster ps) {
		int c = new Random().nextInt(4);
		if (c == 0) {
			System.out.println(this.name + "の会心の一撃");
			int cri = (int) (this.pow * 1.5);
			ps.hp -= cri;
			System.out.println(ps.name + "に" + cri + "ダメージ");
			return ps.hp;
		} else {
			System.out.println(this.name + "の攻撃");
			ps.hp -= this.pow;
			System.out.println(ps.name + "に" + this.pow + "のダメージ");
			return ps.hp;
		}
	}

	public void waiting() {
		System.out.println(this.name + "は余裕ぶっこいている");
	}

	public boolean heal() {
		boolean turnthrogh = true;
		if (this.mp < 3) {
			System.out.println("MPが足りませんね！！！");
			turnthrogh = false;
		} else {
			this.mp -= 3;
			System.out.println(this.name + "は回復魔法をとなえた");
			int he = Math.min(this.FULLHP - this.hp, 20);
			this.hp += he;
			System.out.println(this.name + "は" + he + "ポイント回復");
		}
		return turnthrogh;

	}

	public void run() {
		System.out.println("勇者は無様に逃げ出しました");
	}

}
