package RPG;

public class Main {

	public static void main(String[] args) throws Exception {
		Hero h = new Hero();
		Battle b = new Battle();
		DungeonEvent d = new DungeonEvent();
		TownEvent t = new TownEvent();
		t.NPC(h);

	}

}
