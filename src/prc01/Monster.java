package Rpg;

public abstract class Monster {
	int hp;
	String name;
	boolean alive = true;

	public Monster(String name) {
		this.name = name;
		this.hp = 45;
	}

	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

}
