package Rpg;

import java.util.Random;

public class PoisonSlime extends Slime {
	int ra;

	public PoisonSlime(String name) {
		super(name);
		this.name = "バブル" + this.name;
		this.hp += 15;
		this.pow += 3;

	}

	public void attack(Hero h) {
		this.ra = new Random().nextInt(5);
		switch (ra) {
		case 0:
			super.waiting();
			break;
		case 1:
			System.out.println(this.name + "のどくどく");
			int dmg = h.FULLHP / 5;
			h.hp -= dmg;
			System.out.println(h.name + "は" + dmg + "のダメージを受けた");
			break;
		default:
			super.attack(h);
			break;
		}

	}

	public void aa() {
		System.out.println("　　　　　　　ｒ'￣i\r\n" +
				"　 , - ､　　　　　　　　　ﾞ‐- '\r\n" +
				"　{　　 }　　　　　　　　　　　　　r'⌒',\r\n" +
				"　`‐-‐'　　　　　 r'⌒',　　　　　!、_丿\r\n" +
				"　　◯　　　　　　ヽ-‐'　　＿＿＿\r\n" +
				"　　　　　　ｒ'⌒',　　 ,,r-‐'　　　　　`''ヽ､　　○\r\n" +
				"　　　　　　`‐-' 　／　　　　　　　　　　 ＼\r\n" +
				"　　　　　　, ､ ,,／ r‐､（･） （･）＿　　　　　'─--､,,\r\n" +
				"　　,,r-─（＿）　　ヽ、`── '　 ノ　　　　i⌒)　　 `,\r\n" +
				"　（　　　　　　　　　　`'‐──‐'´　　　　　￣　　,r‐\r\n" +
				"　　￣つ　　　　'⌒'　　　　　　　　　　　,r─‐‐''\r\n" +
				"　　 (´　　　　　　　　　　　　　　,r──'\r\n" +
				"　　　￣￣ﾞ'───--------‐'");
	}

}
