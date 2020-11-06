package Rpg;

import java.util.Random;

public class Slime extends Monster {
	int pow;

	public Slime(String name) {
		super(name);
		this.name = super.name;
		this.hp = 10;
		this.pow = 5;

	}

	public void attack(Hero h) {
		int r = new Random().nextInt(5);
		switch (r) {
		case 0:
		case 1:
			waiting();
			break;
		default:
			System.out.println(this.name + "の攻撃");
			h.hp -= this.pow;
			System.out.println(h.name + "に" + this.pow + "のダメージ");
			break;
		}
	}

	public void waiting() {
		System.out.println(this.name + "はボケーっとしている");
	}

}
