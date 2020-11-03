package Rpg;

public abstract class Monster {
	int hp;
	String name;
	boolean alive;

	public Monster(String name) {
		this.name = name;
		this.hp = 50;
		this.alive = true;
	}

	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

	public abstract void attack(Hero h);

	private void die() {
		System.out.println(this.name + "を倒した");
		this.alive = false;
	}

	public boolean checkAlive(Hero h, Monster enemy) {
		if (this.hp > 0 && this.alive == true) {
			this.attack(h);
		} else if (this.alive == true) {
			this.die();
			return false;
		}
		return true;
	}

}
