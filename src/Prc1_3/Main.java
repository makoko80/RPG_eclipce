package Prc1_3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		//1～10の整数値を持つリストを用意
		for (int i = 0; i <= 5; i++) {
			list.add(i);
		}
		//                if(list.add(i)) {
		//                	System.out.println("aaaa");
		//        }
		//リストを表示（確認用）

		//shuffleメソッドで上で作ったリストをシャッフル
		Collections.shuffle(list);

		//ランダムにした結果を表示
		System.out.println(list);
		

	}

}
