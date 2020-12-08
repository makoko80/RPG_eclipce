package Rpg;

import java.util.Random;

public class Slime extends Monster {
	int pow;

	public Slime(String name) {
		super(name);
		this.pow = 10;

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
			h.setHP(h.getHP() - this.pow);
			System.out.println(h.getName() + "に" + this.pow + "のダメージ");
			break;
		}
	}

	public void waiting() {
		System.out.println(this.name + "はボケーっとしている");
	}

}
