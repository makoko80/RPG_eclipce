package RPG;
public class DungeonEvent {

private int Adventurer;
private int Aotanuki;
private int Adventurer2;
private int Pirate;
private int LegendSword;
private int LegendSwordFlg;
private int LastBoss;

Battle b = new Battle();

public void talk(int speed,int waitingTime,String text) throws Exception{
		 for(int i = 0 ; i < text.length();i++) {
			 Thread.sleep(speed);
			 System.out.print(text.substring(i,i + 1));
	 }
		 System.out.println("");
		 Thread.sleep(waitingTime);
}

	public int subEvent(Hero h,Bag b) throws Exception {
		int r = new java.util.Random().nextInt(8);
		switch(r) {
			case 0:
				//宝箱を見つける
			case 1:

				double p = Math.random();
				if(p >= 0.9) {//酒をゲット
					talk(80,1000,h.getName()+"は宝箱を見つけた！！");
					talk(80,1000,"中には酒が入っていた！");
					talk(80,1000,h.getName()+"は酒をバッグにしまった。");
					b.setSake(b.getSake() + 1);

				}else if(0.9 > p && p >= 0.6){//煙幕をゲット
					talk(80,1000,h.getName()+"は宝箱を見つけた！！");
					talk(80,1000,"中には煙幕が入っていた！");
					talk(80,1000,h.getName()+"は煙幕をバッグにしまった。");
					b.setEnmaku(b.getEnmaku() + 1);
				}else {//薬草をゲット
					talk(80,1000,h.getName()+"は宝箱を見つけた！！");
					talk(80,1000,"中には薬草が入っていた！");
					talk(80,1000,h.getName()+"は薬草をバッグにしまった。");
					b.setYakuso(b.getYakuso() + 1);
				}
				break;
			case 2:


			case 3:
				//お金を拾う(10〜20G)
				int i = new java.util.Random().nextInt(10)+10;
				talk(80,1000,h.getName() + "は"+i+"G拾った");
				Bag.gold += i;
			break;
			case 4:
				//道端の石で転ぶ(-5ダメージ)
				talk(80,1000,h.getName()+"は道端の石で転んだ");
				talk(80,1000,h.getName()+"は５ダメージ受けた！");
				h.setHp(h.getHp() - 5);

			break;
			case 5:
				//道中の足湯に使った(HP10回復)h.setHp(getHp() - 10);
				talk(80,1000,h.getName()+"は道中の足湯に浸かった");
				talk(80,1000,h.getName()+"はHPを10回復した！");
				h.setHp(h.getHp() + 10);
			break;
			case 6:

			break;
			case 7:
				int j = new java.util.Random().nextInt(5);
				if(j ==0) {
					talk(80,1000,"世の中はいつ平和になるのだろうか。。");
				}else if(j ==1) {
					talk(80,1000,"今回M-1決勝はどうなるだろうか。。");
				}else if(j ==2) {
					talk(80,1000,h.getName()+"はゴミを拾った");
				}else if(j ==3) {
					talk(80,1000,"ネズミチューチュちちくり合っている。");
				}else if(j == 4) {
					talk(80,1000,"勇者は今日見た夢を思い出した");
				}
			break;

		}
		return 1;
	}

	public int dEvent(int progress,int floor ,Hero h,Bag b,Weapon w) throws Exception{//戻り値(敵に負けたときや買った時)を返すこと BAGも引数にいれる
		//Weaponインスタンス
		if(progress == 5 && floor == 1 ) { //さすらい勇者
			if( Adventurer == 0) {
				talk(80,1000,"ダンジョンを進んでいると目の前で一人の男がモンスターと戦っている");
				talk(80,1000,"バシュ!ドンッ！パシュッ！");
				talk(80,1000,"男は華麗な動きであっさりとモンスターをやっつけた");
				System.out.println("[さすらい冒険者]");
				talk(80,1000,"「あれ君も冒険者？」");
				talk(80,1000,"男はこっちをむいて話しかけてきた");
				System.out.println("[さすらい冒険者]");
				talk(80,1000,"「もしかして魔王を倒しにきたのかい？」");
				talk(80,1000,"「僕もそうさ。」");
				talk(80,1000,"「まっ、だけど魔王を倒すのは俺だけどな！」");
				talk(80,1000,"「しかし君は見た感じ強そうだけど無理はするなよ！」");
				talk(80,1000,"「ここのダンジョンは階層が上がってくるほど、だんだん強くなってくるからね！」");
				talk(80,1000,"「そうだ！君はまだダンジョンにきたばっかりだと思うから良いものあげるよ！」");
				talk(70,1000,"勇者は薬草をもらった");
				//薬草を貰うメソッド薬草
				b.setYakuso(b.getYakuso + 1);
				talk(80,1000,"「ダンジョンは危ないからね。体力が無くなったらこれで回復するといいよ！」");
				talk(80,1000,"「じゃあもういくよ！また会えるといいね！」");
				talk(80,1000,"さすらい勇者はダンジョンの奥地へと進んで行った");
				this.Adventurer = 1;


			}else if(this.Adventurer == 1) {
				talk(70,300,h.getName()+"はここで前にあった冒険者のことを思い出した");
			}
		return 1;
		}
		if(progress ==10 && floor == 1 ) { //青たぬき
			if( this.Aotanuki == 0) {

				talk(80,1000,"(そろそろこの階層も終わりかな)");
				talk(80,1000,h.getName()+"がそう思い始めた時");
				talk(80,1000,"突如目の前にピンク色の扉が現れた");
				talk(80,1000,"「ガチャ」っと扉が開き中から謎の青いタヌキが出てきた。");
				talk(80,1000,"球状の頭部と胴体、体は青色で顔面と腹部は白色になっている。");
				talk(80,1000,"｢な、なんだこのタヌキは」");
				talk(80,1000,"青いタヌキはすごい形相で睨みつき怒鳴りあげた");
				System.out.println("[アオタヌキ]");
				talk(80,1000,"「僕は狸じゃない！」");
				talk(80,1000,"青いタヌキは襲いかかってきた");

				//戦闘
				int judge = b.enCount(h);//モンスター型も入れる
				//バトル終了
				if(judge == 0) {
					this.Aotanuki = 1;
					return 0;
				}
				talk(80,1000,"青いタヌキはこっぱみじんに壊れた");
				talk(80,1000,"どうやらこいつはロボットだったようだ。。");
				talk(80,1000,"まあ気にせず次に進むか。。");
				talk(80,1000,h.getName()+"は前に進んだ");
				this.Aotanuki = 2;
				return 2;//return

			}else if(this.Aotanuki == 1) {
				System.out.println("[アオタヌキ]");
				talk(80,1000,"あれ？こないだ殺ったはずなのに？");
				talk(80,1000,"しつこいなぁ今度は八つ裂きにしてどら焼き代わりのデザートにしてやろうかい？");
				talk(80,1000,"青いタヌキは襲いかかってきた");
				//戦闘
				int judge = b.enCount(h);//モンスター型も入れる
				//バトル終了
				if(judge == 0) {
					this.Aotanuki = 1;
					return 0;
				}
				talk(80,1000,"青いタヌキはこっぱみじんに壊れた");
				talk(80,1000,"どうやらこいつはロボットだったようだ。。");
				talk(80,1000,"まあ気にせず次に進むか。。");
				talk(80,1000,h.getName()+"は前に進んだ");
				this.Aotanuki = 2;
				return 2;//return

			}else {
				talk(80,1000,"青いタヌキの残骸が残っている");
				return 1;
			}

		}
		if(progress ==5 && floor == 2 ) { //さすらい勇者２
			if( this.Adventurer2 == 0) {
				talk(80,1000,"(前に会った冒険者が倒れている)");
				talk(80,1000,"[さすらい冒険者]「き、君は前に会った。。」");
				talk(80,1000,"「実はここの魔物が強くて。。このザマさ。。」");
				talk(80,1000,"「もう俺は動く体力がない」");
				talk(80,1000,"「薬草があれば、、どうにかなるんだが、、」");
				talk(80,1000,"「そ、そうだ君薬草を持っていないかい？」");
				talk(80,1000,"「そうすれば町に戻る体力くらいは回復できる！」");
				talk(80,1000,"1[薬草を渡す] 2[渡さない]");
				int i = new java.util.Scanner(System.in).nextInt();
				switch(i) {
				case 1:
					this.AEvent(h,b);

					break;
				case 2:
					talk(80,1000,"<本当に渡さなくていいですか>");
					talk(80,1000,"1[渡す] 2[渡さない]");
					int q = new java.util.Scanner(System.in).nextInt();
					if(q == 1) {
						this.AEvent(h,b);
						break;
					}else if(q == 2){
						talk(80,1000,"あぁぁぁぁぁぁぁ！！！");
						talk(80,1000,"さすらいの冒険者は死亡した");
						talk(80,1000,"(ん？、冒険者のポケットに何か入っているな)");
						talk(80,1000,"(何かすごい物が入っているぞ？)");
						talk(80,1000,h.getName() + "はエリクサーを手に入れた");
							//エリクサーを手に入れる
						b.setElixir(b.getElixir() + 1);
						talk(80,1000,"(これはHPとMPが完全回復するアイテムじゃないか！)");
						talk(80,1000,"(なんでこれを使わなかったんだろう。。)");
						talk(80,1000,"(ま、考えても仕方ないしいいか。)");
						talk(80,1000,h.getName()+"は心を無にして前に進んだ");

					}
					break;

				}
				this.Adventurer2 = 1;

			}else if(Adventurer2 == 1) {

			}
			return 1;
		}
		if(progress ==10 && floor == 2 ) { //海賊
			if( this.Pirate == 0) {
				talk(80,1000,"目の前に赤い服をきた男が後ろ向きで立っている");
				talk(80,1000,"男は麦わら帽子を被り左目の下に傷がついている");
				talk(80,1000,"男は振り向き自分を見た途端近づいてきた");
				System.out.println("[ゴム海賊]");
				talk(80,1000,"「ん？おまえ誰だ？」");
				talk(80,1000,"「ふーん"+h.getName() +"っていうのか」");
				talk(80,1000,"「俺か？俺はムフィ海賊王になる男だ！」");
				talk(70,1000,"「ところでよ。ここにおれの仲間たちも一緒に来ているんだけど。おまえ知ってるか？」");
				talk(80,1000,"1[俺が倒した] 2[知らない]");
				int i = new java.util.Scanner(System.in).nextInt();
				if(i == 1) {

					System.out.println("[ゴム海賊]");
					talk(80,1000,"「。。」");
					talk(80,1000,"「てめぇよくもうちの仲間を。ぜってーに許さねぇ」");
					talk(80,1000,"「ゴムゴ◯のーピストル！」");
					talk(80,1000,"シュバッ!");
					talk(80,1000,h.getName()+"は間一髪でかわした");
					talk(80,1000,"「うちの仲間を泣かせるような奴は」");
					talk(80,1000,"「絶対に許さない!!」");
					talk(80,1000,"「ムフィは襲いかかってきた」");

				} else {
					talk(80,1000,"「そっか！ならいいや！」");
					talk(80,1000,"「そういえばよ俺今めちゃくちゃイライラしているからよちょっと殴ってもいいか？」");
					talk(80,1500,"1[むり] 2[いいよ]");
					talk(80,1000,"「いやおまえの考える時間なんて与えないから」");
					talk(80,1000,"「ゴムゴ◯のーピストル！」");
					talk(80,1000,"シュバッ!");
					talk(80,1000,h.getName()+"は間一髪でかわした");
					talk(80,1000,"「おお！おまえよく避けたな」");
					talk(80,1000,"「じゃあ今度はどうだ！」");
					talk(80,1000,"ムフィは襲いかかってきた");
				}
				//戦闘
				int judge = b.enCount(h);//モンスター型も入れる
				//バトル終了
				if(judge == 0) {
					this.Pirate = 1;
					return 0;
				}

				talk(80,1000,"「うぐっうぐっ。」(ゴム海賊は泣き出した)");
				talk(80,1000,"「何が海賊王だ！！俺は！弱い！！」");
				talk(80,1000,"「もうおまえなんかあっちいけ！！」");
				talk(80,1000,"("+h.getName()+"は前に進んだ)");
				this.Pirate = 2;
				return 2;//return ;

			}else if(this.Pirate == 1) {
				talk(80,1000,"ん？またおまえか？いいぞいくらでも戦ってやるぞ！");
				talk(80,1000,"ムフィは襲いかかってきた");

				//戦闘
				int judge = b.enCount(h);//モンスター型も入れる
				//バトル終了
				if(judge == 0) {
					this.Pirate = 1;
					return 0;
				}
				talk(80,1000,"「うぐっうぐっ。」(ゴム海賊は泣き出した)");
				talk(80,1000,"「何が海賊王だ！！俺は！弱い！！」");
				talk(80,1000,"「もうおまえなんかあっちいけ！！」");
				talk(80,1000,h.getName()+"は前に進んだ");
				this.Pirate = 2;
				return 2;//return h;

			}else {
				talk(80,1000,"「うぐっうぐっ。」");
				talk(80,1000,"ゴム海賊はまだ泣いている");
				return 1;
			}

		}
		if(progress ==5 && floor == 3 ) { //伝説の剣
			if(this.LegendSword == 0) {
				talk(80,1000,"(ん？)");
				talk(70,800,h.getName()+"はダンジョンを進んでいると何か違和感を感じた");
				talk(80,1000,"(あそこの壁何かおかしい)");
				talk(70,1000,"ダンジョンの壁の一部に一見ではわからないような小さいボタンのような物がついている");
				talk(80,1000,h.getName()+"はボタンを触って見た");
				talk(200,600,"ゴゴゴゴゴゴッ");
				talk(80,1000,"なんと！目の前の壁が崩れ始めた！");
				talk(80,1000,h.getName()+"は崩れ去った壁の奥を見てみると2つ道が続いている");
				talk(80,1000,"(この先に何かあるかもしれない。)");
				talk(80,1000,"<先に進みますか？>");
				talk(80,1000,"1[はい] 2[いいえ]");
				LEvent(h,w);
			}else if(this.LegendSword == 1) {
				talk(80,1000,"(ここは前にきた分かれ道があった場所だ)");
				talk(80,1000,"(この先にはきっと何か意味のあるものが隠されてる気がする。)");
				talk(80,1000,"<先に進みますか？>");
				talk(80,1000,"1[はい] 2[いいえ]");
				LEvent(h,w);
			}else {

			}
			return 1;
		}

		if(progress ==10 && floor == 3 ) { //ラスボス
			if( this.LastBoss == 0) {
				talk(80,1000,"勇者は魔王の邪悪な気を感じていた。");
				talk(80,1000,"(きっとこの先に魔王がいる)");
				talk(80,1000,"(正真正銘これが最後の戦いになる。。) ");
				talk(70,1000,h.getName()+"は足を思い切り踏みしめ前に進んだ。");
				System.out.println("[魔王]");
				talk(80,1000,"待ちわびたぞ勇者よ。全てをぶつけて来い、散り散りに砕いてくれるわ！ ");
				talk(80,1000,"この世界は私が支配してやる！");
				talk(80,1000,"(来るっ！)");
				talk(80,1000,"魔王が襲いかかってきた!");
				//戦闘
				int judge = b.enCount(h);//モンスター型も入れる
				//バトル終了
				if(judge == 0) {
				 	LastBoss = 1;
					return 0;

				LastBoss2(h);//モンスター型も入れる



			}else if(LastBoss == 1) {
				System.out.println("[魔王]");
				talk(80,1000,"ん？おまえは前に八つ裂きにしてやった雑魚じゃないか！");
				talk(80,1000,"運の良い奴め生きていたのか！");
				talk(80,1000,"いいだろう今度こそあの世に送ってやろうグハハハ！");
				talk(80,1000,"魔王が襲いかかってきた");
				//戦闘
				int judge = b.enCount(h);
				//バトル終了
				if(judge == 0) {
				 	this.LastBoss = 1;
					return 0;
				}else if(judge == 1){
					this.LastBoss2();
				}

				LastBoss2(h);
			}
			return 1;
		}
		return 1;
	}
	public void LEvent(Hero h ,Weapon w) throws Exception{ //Weaponも引数にいれる。w.haveLegend();
			int j = new java.util.Scanner(System.in).nextInt();
				if(j == 1) {
					label1: while(true) {
						talk(80,1000,"<左か右に道が分かれている。どちらに進みますか？>");
						talk(80,1000,"1[左] 2[右]3[諦めてダンジョンを進める]");
						int s = new java.util.Scanner(System.in).nextInt();
							if(s == 1) {
								talk(80,1000,h.getName()+"は左に進んだ");
								talk(80,1000,"また右と左に分かれ道がある");
								talk(80,1000,"<どちらに進みますか？>");
								talk(80,1000,"1[左] 2[右]");
								int t = new java.util.Scanner(System.in).nextInt();
								switch(t) {
								case 1:
									talk(80,1000,h.getName()+"は左に進んだ");
									talk(80,1000,"また左と右に分かれ道がある");
									talk(80,1000,"<どちらに進みますか？>");
									talk(80,1000,"1[左] 2[右]");
									int u = new java.util.Scanner(System.in).nextInt();
									switch(u) {
									case 1:
										talk(80,1000,h.getName()+"は左に進んだ");
										talk(80,1000,"なんと！最初の入り口に戻ってきた！");
										talk(80,1000,"(ここは何か不思議な力が働いているようだ。)");
										talk(80,1000,"(正しい方に進めば先に行けるのだろうか。)");
										continue label1;
									case 2:
										talk(80,1000,h.getName()+"は右に進んだ");
										talk(80,1000,"なんと！");
										talk(80,1000,"そこには輝かしい祭壇があった。");
										talk(80,1000,h.getName()+"が祭壇に入るとそこには神々しい剣が置かれている");
										talk(80,1000,"(この剣からは聖なる力を感じる)");
										talk(80,1000,h.getName()+"は剣を手に取った");
										talk(80,1000,"すると剣先がまばゆく光った");
										talk(80,1000,"(これはきっと伝説の勇者が使った剣だ。)");
										talk(80,1000,"(ものすごい力をこの剣は秘めている)");
										talk(80,1000,"(そういえばこの近くにモンスターはいなかったな。。)");
										talk(80,1000,"(きっとこの剣の聖なる力にはモンスターは近づくことができないのだろう)");
										talk(80,1000,"(よしこれがあれば魔王を倒すことができる！)");
										talk(70,1000,h.getName()+"は伝説の剣を手に入れた！");
										talk(70,1000,"伝説の剣を装備しますか？");
										talk(70,1000,"|1[はい] 2[いいえ]|");
										//勇者の剣を手に入れるメソッド
										w.haveLegend();
										//装備
										w.equipLegend();

										talk(80,1000,"勇者は最初の分かれ道のところに戻った");
										talk(80,1000,"(魔王の邪悪な力がどんどん近づいているのを感じる)");
										talk(80,1000,"(もうすぐ決戦は近い)");
										talk(80,1000,"(でもこの剣があれば。。)");
										talk(80,1000,h.getName()+"伝説の剣を携えて前に進んだ");
										LegendSword = 2;
										break label1;

							}
							case 2:
								talk(80,1000,h.getName()+"は右に進んだ");
								talk(80,1000,"なんと！最初の入り口に戻ってきた！");
								talk(80,1000,"(ここは何か不思議な力が働いているようだ。)");
								talk(80,1000,"(正しい方に進めば先に行けるのだろうか。)");
								continue label1;
							}
						}else if(s == 2) {
							talk(80,1000,h.getName()+"は右に進んだ");
							talk(80,1000,"なんと！最初の入り口に戻ってきた！");
							talk(80,1000,"(ここは何か不思議な力が働いているようだ。)");
							talk(80,1000,"(正しい方に進めば先に行けるのだろうか。)");

							continue label1;

						}else{
							talk(80,1000,h.getName()+"は入り口に戻り、元の道を進んだ");
							LegendSword = 1;
							break label1;
						}
					}

				}else {
					talk(80,1000,h.getName()+"は気にせず元の道を進んだ");
					this.LegendSword = 1;
				}

	}
	public void AEvent(Hero h ,Bag b) throws Exception{ // BAG型もいれる
		talk(80,1000,h.getName()+"は薬草を渡した");
		//薬草を渡す
		talk(70,1000,"さすらいの冒険者は回復した");
		System.out.println("[さすらい冒険者]");
		talk(80,1000,"「ありがとう！おかげで助かったよ！これでまた戦えるぞ！」");
		talk(70,1000,"「これはお礼さ。使ってくれ！」");
		//エリクサーを貰う
		System.out.println("[さすらい冒険者]");
		talk(70,800,"「これは最強のアイテムでHPとMPを完全回復できるんだ！」");
		talk(70,800,"「だけど貴重なアイテムだから使い所は考えてね！」");
		talk(70,800,"「え？これを使えば回復できただって？」");
		talk(70,800,"「いやー俺結局ゲームクリアまで貴重なアイテム使わないたちでさ。」");
		talk(70,800,"「すっかり持っていたの忘れてたよ。アハハ」");
		talk(70,800,"「あっそうだ」");
		talk(70,1000,"「これはいわゆるおとぎ話というか。信憑性のある話ではないのだが。。」");
		talk(70,1200,"「実はこのダンジョンの奥深くには昔世界を救った勇者が使ったと言われる。伝説の剣が眠っているらしい」");
		talk(70,800,"「理由はわからないが世界が平和になった後このダンジョンに隠したとされている」");
		talk(70,800,"「どうやら普通じゃわからないように工夫しているらしいが」");
		talk(70,800,"「それでよ！実は俺その伝説の勇者とやらが残したメモっていうのを持っているんだ！」");
		talk(70,800,"「でもこのメモにはよ<左><左><右>としか書いてないんだ。」");
		talk(70,800,"<左><左><右>");
		talk(80,1000,"「あーだめだ！さっぱりなんのことかわからん！」");
		talk(80,1000,"「まっ、今日は俺体ボロボロだし一旦町に帰ろうかな。」");
		talk(80,1000,"「わからんこと考えても疲れるしな。じゃあ俺はもういくわ！」");
		talk(80,1000,"さすらいの冒険者は帰って行った");
		talk(80,1000,"(<左><左><右>  か。覚えておこう)");
		talk(80,1000,h.getName()+"は前に進んだ");
	}
	public int LastBoss2(Hero h)throws Exception {

		talk(100,600,"ウォォォォォォ!!");
		talk(80,1000,"や、やるではないか。なら私の真の力を見せてやろう！！");
		talk(200,600,"ゴゴゴゴゴゴゴゴゴ！");
		talk(80,1000,"(なんだこの禍々しいオーラは！！)");
		talk(80,1000,"魔王の力が増幅している！！");
		talk(70,800,"はははこれが我の真の力よ。しかしこの力を出すのは１０００年ぶりだ");
		talk(80,1000,"「ここまで苦戦させたのはおまえが久しい。。」");
		talk(70,800,"「どうじゃ？我の仲間にならないか？我の味方になれば世界の半分をやろう。」" );
		talk(80,1000,"1[お前の仲間になるものか！] 2[仲間になろう]");
		int i = new java.util.Scanner(System.in).nextInt();
			while(true) {
			if(i == 1) {
			talk(80,1000,"「なんだと？世界がいらぬと言うのか。。じゃあ我の手でひねり潰してくれるわ！！」");
			//→第２形態と戦闘
			int judge = b.enCount(h);//モンスター型も入れる
			//バトル終了
			if(judge == 0) {
				this.LastBoss = 1;
				return 0;
			}

			return 3; //仮
			}else if(i != 1) {
				talk(80,1000,"本当に仲間になりますか？");
				System.out.println("<1[はい] 2[いいえ]>");
				int a = new java.util.Scanner(System.in).nextInt();
				if(a == 1) {
					talk(80,1000,"「はっはっは、じゃあおまえは今日から仲間じゃ！」");
					talk(80,1000,"「勇者は闇に包まれ、魔王に操られる魔物になった」");
					talk(80,1000,"GAMEOVER");
					this.LastBoss = 1;
					return 0;
				}if(a != 1) {
					i = 1;
					continue;
				}
			}
		}
	}
	public void ending(Hero h) throws Exception{
		System.out.println("[魔王]");
		talk(80,1000,"「バ、バカなぁあ！！私が負けるなんて！！」");
		talk(100,700,"「グァぁぁぁぁぁぁぁぁぁぁぁぁぁぁぁぁぁぁぁ！」");
		talk(70,1000,"魔王は闇と共に消えていった。");
		talk(70,1500,"魔王の消滅共に世界から闇は消え去った。");

		System.out.println("[王様]");
		talk(70,1000,"「よくやった"+h.getName()+"よ！！よく帰ってきた！！お主のおかげでこの世界が平和になった！」");
		talk(70,1000,"「さあ！さあ！宴を用意しておるぞ！さあ今夜は眠れぬぞ！！」");
		talk(100,700,"「ブル︎ウゥオフェィィイ！」");
		talk(70,2000,"こうして世界に平穏が訪れた。。");
		talk(70,2000,"しかし我々は迫りくる新たな恐怖があることを知るよしもなかった");
		talk(80,1000,"THE END");
		credit();
	}
	public void credit() throws Exception{
		talk(200,600,"はい,ではエンドロールいきまーす！！");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");


		System.out.print("							  ");
		talk(70,0,"ド◯クエ風RPG");
		a();
		System.out.print("								");
		talk(70,0,"<制作期間>");
		System.out.print("						    ");
		talk(70,0,"2020/11/11〜12/10");
		a();

		System.out.print("						  		  ");
		talk(70,0,"<制作> ");
		System.out.print("						  	   ");
		talk(70,0,"株式会社とぴあ");
		a();

		System.out.print("                         	  ");
		talk(70,0,"<ヒーローデザイン>");
		System.out.print("                           		");
		talk(70,0,"チームのみんな");
		a();

		System.out.print("						");
		talk(70,0,"<バトルデザイン・ダンジョンデザイン>");
		System.out.print("								 	");
		talk(70,0,"鈴木真");
		a();

		System.out.print("				    	");
		talk(70,0,"<メニューデザイン・ショップデザイン>");
		System.out.print("							    	");
		talk(70,0,"高野健人");
		a();

		System.out.print("					      	   ");
		talk(70,0,"<モンスターデザイン>");
		System.out.print("						        	 ");
		talk(70,0,"柴田萌");
		a();

		System.out.print("						   	     ");
		talk(70,0,"<シナリオライター>");
		System.out.print("						   	   	    ");
		talk(70,0,"野澤 諒伍");
		a();
		b();

	}
	public void a() throws Exception{
		for(int i = 0;i < 20;i++){
			Thread.sleep(200);
			System.out.println("");
		}
	}
	public void b() throws Exception{
		talk(0,100,"　　　　　　＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　＊＊＊＊　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊　＊＊＊＊　　　　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊　　　　＊＊＊　＊＊＊　　　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　　　　＊＊＊　　　　　　　＊＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊　　　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　　＊＊＊＊＊＊　　　　　　＊＊＊＊＊＊＊＊＊　　　　＊＊＊＊＊　　　　　　　＊＊＊＊＊　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　　＊＊＊＊＊＊＊　　　　　＊＊＊　　＊＊＊＊　　　＊＊＊　　　　　　　　　　＊＊＊＊　　　　　　　　　＊＊＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　　＊＊＊　＊＊＊　　　　　＊＊＊　　＊＊＊＊　　　＊＊＊＊＊＊＊　　　　　　＊＊＊＊　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　　　　　＊＊＊＊　＊＊＊　　　　　＊＊＊　　＊＊＊＊　　　＊＊＊＊＊＊＊＊　　　　　＊＊＊＊　　　　　　　＊＊＊　＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　　＊＊＊＊＊＊＊＊＊　　　　　　＊＊＊　＊＊＊　　　　　＊＊＊　　＊＊＊＊　　　＊＊＊　　＊＊＊＊　　　　＊＊＊＊　　　　　　＊＊＊＊　＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　　　＊＊＊＊＊＊＊＊　　　　　　＊＊＊＊＊＊＊　　　　　＊＊＊　　＊＊＊＊　　　＊＊＊　　＊＊＊＊　　　　＊＊＊＊　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　");
		talk(0,100,"　　　　　　＊＊＊＊＊＊　　　　　　　　＊＊＊＊＊　　　　　　＊＊＊　　＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　　＊＊＊　　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　");

		talk(0,100,"　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　＊＊＊　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　＊＊＊　　　　　　＊＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　　　＊＊＊　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　＊＊＊＊＊＊＊　　　　＊＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊　　　　　＊＊＊＊＊＊　　　　　＊＊＊＊＊＊＊＊　　");
		talk(0,100,"　　＊＊＊＊＊＊＊　　　　＊＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊　　　　＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　");
		talk(0,100,"　　　　＊＊＊　　　　　　＊＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　　　　　＊＊＊＊　　　　　＊＊＊　　　　　　＊＊＊＊　　　＊＊＊＊　　＊＊＊　　　　＊＊＊＊＊＊＊＊＊　");
		talk(0,100,"　　　　＊＊＊　　　　　　　＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　　　＊＊＊＊＊＊　　　　　＊＊＊　　　　　　＊＊＊＊　　　＊＊＊＊　　＊＊＊＊　　　＊＊＊　　＊＊＊　　");
		talk(0,100,"　　　　＊＊＊　　　　　　　＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　＊＊＊＊＊＊＊＊　　　　　＊＊＊　　　　　　＊＊＊＊　　　＊＊＊＊　　＊＊＊＊　　　＊＊＊　　＊＊＊　　");
		talk(0,100,"　　　　＊＊＊＊　　　　　　＊＊＊　　＊＊＊　　　　　＊＊＊＊　　　　　＊＊＊　＊＊＊＊　　　　　＊＊＊＊　　　　　＊＊＊＊　　　＊＊＊＊　　＊＊＊＊　　　＊＊＊　　＊＊＊　　");
		talk(0,100,"　　　　＊＊＊＊＊　　　　　＊＊＊＊＊＊＊＊＊　　　　＊＊＊＊　　　　＊＊＊＊　＊＊＊＊　　　　　＊＊＊＊＊　　　　＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　＊＊＊　　＊＊＊　　");
		talk(0,100,"　　　　＊＊＊＊＊　　　　　＊＊＊＊＊＊＊＊　　　　　＊＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　　＊＊＊＊＊　　　　＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　＊＊＊　　＊＊＊　　");
		talk(0,100,"　　　　　＊＊＊＊　　　　　　＊＊＊＊　＊＊　　　　　　＊＊＊＊　　　　＊＊＊＊＊＊＊＊　　　　　　＊＊＊＊　　　　＊＊＊　　　　　　＊＊＊＊＊　　　　　　＊＊＊　　＊＊＊　　");

		talk(0,100,"　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　　＊＊　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊＊＊　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊＊＊　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　＊＊＊＊　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊＊＊　　　　　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　　　＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　＊＊＊　＊＊＊＊　　　　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　＊＊＊＊＊＊＊　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(0,100,"　　　＊＊＊＊＊　　　　　　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
	}

}
