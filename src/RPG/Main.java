package RPG;

public class Main {

	public static void main(String[] args) throws Exception {
		Hero h = new Hero();
		Battle b = new Battle();
		//冒険（茶番）の始まりだじょー 1234!! へっぽこ　


		//				int branch = Chaban.prologue(h);
		//				if (branch == 4) {
		//					System.out.println("かもね");
		//					System.exit(0);
		//				}
		b.enCount(h);

	}

}
