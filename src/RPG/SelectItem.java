package Rpg;

public class SelectItem {
	public void selectItem(Bag b, Hero h, int j) {
		System.out.println("-----------");
		System.out.println("【これを使用しますか？】");
		System.out.println();
		System.out.println("　　　　" + b.nameArray[j - 1] + "("
				+ b.getCount(j - 1) + "有)");
		System.out.println("　　　　" + b.infoArray[j - 1]);
		System.out.println();
		System.out.println("　　　1.Yes 2.No");
		System.out.println("----------");
	}
}
