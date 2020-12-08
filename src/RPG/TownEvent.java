package RPG;

public class TownEvent {
	private boolean mayorFlg;
	private boolean childFlg;
	private String divinerName = "[あやしい占い師]";
	private boolean scumFlg;
	private String bunnyGirltalk = "「あーら素敵なお兄さんじゃない！」";
	/**
	 *　javaドック
	 * @param speed
	 * @param waitingTime
	 * @param text
	 * @throws Exception
	 */
	public void talk(int speed,int waitingTime,String text) throws Exception{
		 for(int i = 0 ; i < text.length();i++) {
			 Thread.sleep(speed);
			 System.out.print(text.substring(i,i + 1));
	 }
		 System.out.println("");
		 Thread.sleep(waitingTime);
	}
	public void talk2(int speed,int waitingTime,String text) throws Exception{
		 for(int i = 0 ; i < text.length();i++) {
			 Thread.sleep(speed);
			 System.out.print(text.substring(i,i + 1));
	 }

		 Thread.sleep(waitingTime);
	}

	public void opening(Hero h) throws Exception{
		title();
		System.out.println("[王様]");
		talk(80,1000,"「よく来たな「勇者」よ。」");
		talk(80,1000,"「ようこそ、とぴあ城へ」");
		talk(80,1000,"「なぜ呼ばれたかわかっていると思うが。今この世界が魔王の手に落ちようとしている」");
		talk(80,1000,"「一年前に突如現れた魔王は世界を征服し始め、この城の兵士たちもほとんど魔王にやられてしまった。。」");
		talk(80,1000,"「その魔王のせいで町のみなは怯えておる。。」");
		talk(80,1000,"「そこでおぬしに頼みがある！」");
		talk(80,1000,"「魔王の討伐をお願いしたいんじゃ！」");
		talk(80,1000,"「魔王を倒してくれ！それがこの世界の願いでもあるんじゃ！」");
		talk(80,1000,"<|1[任せてください] 2[無理です]|>");
		int i = new java.util.Scanner(System.in).nextInt();

			while(i == 2) {
				talk(80,1000,"「な、なんじゃ聞き間違いか」");
				talk(80,1000,"「最近耳が遠くての」");
				talk(80,1000,"「も、もう一度聞くがいいかの？」");
				talk(80,1000,"「どうか魔王を倒してくれ！それがこの世界の願いじゃどうか頼むぞ！」");
				talk(80,1000,"<|1[任せてください] 2[無理です]|>");
				int j = new java.util.Scanner(System.in).nextInt();
				i = j;
			}
				if(i == 1) {
					talk(80,1000,"「よく言ってくれた！！期待しておるぞ！」");
			}
				talk(80,1000,"「魔王はダンジョンの最深部に潜んでおるそうじゃ」");
				talk(80,1000,"「しかしくれぐれも気をつけてくれ」");
				talk(80,1000,"「今までダンジョンに挑んだ冒険者はみな魔王にやられた」");
				talk(80,1000,"「日に日に被害は増えおる。今はもう142万人やられたそうじゃ」");
				talk(80,1000,"「だがおぬしならやってくれると信じておる」");
				talk(80,1000,"「ところでまだおぬしの名前を聞いてなかったな」");
				talk(80,1000,"「名はなんというのじゃ？」");


				h.setName();
				talk(80,1000,"「そうか" + h.getName() + "というのか!」");
				if(h.getName().equals("ほりかつ")) {
					talk(80,1000,"「ん？そういえばその名前聞いたことあるような」");
					talk(80,1000,"「そうじゃ昔世界を救ったと言われる伝説の勇者と同じ名前じゃ！」");
					talk(80,1000,"「これは運命か、はたまた偶然か。。」");
					talk(80,1000,"「まあどちらにせよ世界の運命はおぬしにかかっておる」");
				}else if(h.getName().equals("みずき")) {
					talk(80,1000,"「ん？そういえばその名前聞いたことあるような」");
					talk(80,1000,"「そうじゃ昔世界を救った伝説の魔法使いと同じ名前じゃ！」");
					talk(80,1000,"「これは運命か、はたまた偶然か。。」");
					talk(80,1000,"「まあどちらにせよ世界の運命はおぬしにかかっておる」");
				}
				talk(80,1000,"「魔王討伐期待しておるぞ！」");
				talk(80,1000,"「そうじゃ！おぬしに渡したいものがある。」");

				talk(80,1000,"("+ h.getName() +"は図鑑を受け取った。)");
				talk(80,1000,"「これをバトル中に使えば敵の情報をその図鑑に登録することができるぞ!!」");
				talk(80,1000,"「ダンジョンは危ないから敵ごとの特徴を掴んでうまく切り抜けることが大切じゃ！」");
				talk(80,1000,"「あとじゃな、この城の城下町には冒険の手助けをする便利な施設があるから、そこで準備をすると良いぞ！」");
				talk(80,1000,"「町長には話をつけておる。町へ降りたら案内してくれるぞ！」");
				talk(80,1000,"「ワシからの話は以上じゃ良い知らせを待っておる」");
				talk(80,1000,"「さあいけ！"+h.getName()+"よ！出発の時じゃ！」");
				talk(80,1000,"こうして"+h.getName()+"は魔王を倒す旅に出ることになった");
				talk(80,1000,"(これからどんな冒険が待ち受けているのか。)");
				talk(80,1000,h.getName()+"は期待と不安を持ちながら城下に降りた");
				System.out.println("[町長]");
				talk(70,800,"「お！君は"+h.getName()+"だね。お会いできて嬉しいよ王様から話は聞いている!」");
				talk(70,800,"「私はこの町長だ。王様から勇者の冒険の手助けをするように頼まれているよ!」");
				talk(70,800,"「この城下には武器屋、アイテム屋、宿屋があるよ!」");
				talk(80,1000,"「武器屋は敵と戦うための強い装備を」");
				talk(70,800,"「アイテム屋は体力が減った時に回復できる薬草などが買えるよ！」");
				talk(80,1000,"「宿屋は一日休憩してバッチリ満タン回復さ！」");
				talk(80,1000,"「ダンジョンで危うく倒れそうになったら戻ってきて休むといい！」");
				talk(80,1000,"「こんな感じで勇者様の冒険はこっちでサポートするから魔王討伐お任せしましたぞ！ハッハッハ」");
	}
	public void NPC(Hero h, Bag b) throws Exception{ //引数にHEROとBAG
		label:while(true) {
		talk(100,600,"<誰と話しますか>");
		System.out.println("<|1[町長] 2[夢を語る子供] 3["+divinerName+"] 4[社会の底辺] 5[バニーガール]|>");
		int i = new java.util.Scanner(System.in).nextInt();
			switch(i) {
				case 1:
					Mayor(h,b);//BAG
					continue;
				case 2:
					Child();
					continue;
				case 3:
					Diviner(h);
					continue;
				case 4:
					Scum(h,b);//BAG
					continue;
				case 5:
					BunnyGirl(h);
					continue;
				default:
					break label;
			}
		}
	}
	public void Mayor(Hero h,Bag b) throws Exception{ //バックインスタンスを引数に

		if( this.mayorFlg == false) {
			System.out.println("[町長]");
			talk(80,1000,"「おおまたお会いしましたな"+h.getName()+"冒険は順調ですかな？」");
			talk(80,1000,"「そうだ！こないだアイテム屋の店主にあまりものとしてもらった薬草があるんだ！」");
			talk(80,1000,"「よかったら役立てくれ！」");
			talk(80,1000,h.getName()+"は薬草をもらった");
			//薬草を貰う
			b.setYakuso(b.getYakuso()+1);
			talk(80,1000,"「魔王討伐はみんなが願っている」");
			talk(80,1000,"「よろしく頼みますぞハッハッハ」");
		}else {
			System.out.println("[町長]");
			talk(80,1000,"「魔王討伐はみんなが願っている」");
			talk(80,1000,"「よろしく頼みますぞハッハッハ」");
		}
		this.mayorFlg = true;
	}
	public void Child() throws Exception{
		if(this.childFlg == false) {
			System.out.println("[夢を語る子供]");
			talk(80,1000,"「僕ね大きくなったらね、偉くなるんだ！！」");
			talk(80,1000,"「偉くなったら王様になれるかもしれないんだよ！」");
			talk(80,1000,"「そしたらね、僕が魔王の代わりに世界を征服するんだ！」");
		}else {
			System.out.println("[夢を語る子供]");
			talk(80,1000,"「征服したらどんな気分かな♪」");
		}
		this.childFlg = true;

	}

	public void Diviner(Hero h) throws Exception{
		System.out.println("["+this.divinerName+"]");
		talk(80,1000,"「私はこの町の占い師。人々を導くものです。占って行きましょうか？10Gいただきます」");
		talk(80,1000,"<|1[はい]2[いいえ]|>");
		int i = new java.util.Scanner(System.in).nextInt();
		if(i == 1) {
			//10G払う
			talk(80,1000,h.getName()+"は10G払った");
			Bag.money -= 10;
			int r = new java.util.Random().nextInt(3);
				switch(r) {
				case 0:
					talk(80,1000,"「..むむ見えます！あなたはきっと魔王を倒すでしょう」");
					break;
				case 1:
					talk(80,1000,"「..むむ見えます！あなたにはこれから哀しい運命が待ち受けていますね」");
					break;
				case 2:
					talk(80,1000,"「..むむ見えます！あなたは、、、きっと良いことがあるでしょう」");
					break;
				}
			this.divinerName = "[インチキ占い師]";
		}else {
			talk(80,1000,"「さよなら」");
		}

	}
	public void Scum(Hero h,Bag b) throws Exception{ //引数にBAGも渡す
		if(this.scumFlg == false) {
			System.out.println("[社会の底辺]");
			talk(80,1000,"「お金をくれ！俺は働きたくないんだ！100Gくれ！」");
			talk(80,1000,"<|1[お金をあげる] ２[あげない]|>");
			int i = new java.util.Scanner(System.in).nextInt();
			if(i == 1) {
				talk(80,1000,h.getName()+"は100G払った");
				//お金を払うメソッド
				Bag.money -= 100;
				talk(80,1000,"「さすが！お礼にこれあげる」");
				talk(80,1000,h.getName()+"は薬草をもらった");
				//タバコを貰うメソッド
				b.setTobacco(b.getTobacco() + 1);
				talk(80,1000,"「やっぱお金はたかるに限るぜ！ヤッホーい！」");
				this.scumFlg = true;
			}if(i == 2) {
				talk(80,1000,"「なら50Gで!」") ;
				talk(80,1000,"<|1[お金をあげる] ２[あげない]|>");
				int j = new java.util.Scanner(System.in).nextInt();
				if(j == 1) {
					talk(80,1000,h.getName()+"は50G払った");
				//お金を払うメソッド
					Bag.money -= 50;
					talk(80,1000,"「さすが！お礼にこれあげる！」");
					talk(80,1000,h.getName()+"はタバコをもらった");
				//タバコを貰うメソッド
					b.setTobacco(b.getTobacco() + 1);
					talk(80,1000,"「やっぱお金はたかるに限るぜ！ヤッホーい！」");
					this.scumFlg = true;
				}else if(j == 2) {
					talk(80,1000,"「ケチかよ。。」");
				}
			}
		}else {
			System.out.println("[社会の底辺]");
			talk(80,1000,"「あっ君は金づるじゃん！」");
			talk(80,1000,"「こないだはお金くれてありがとね！！」");
		}
	}
	public void BunnyGirl(Hero h) throws Exception{
		System.out.println("[バニーガール]");
		talk(80,1000,"「"+bunnyGirltalk+"ぱ◯ぱふはいかが？たったの20Gよ。」") ;
		talk(80,1000,"<|1[お願いします] 2[結構です]|>");
		int i = new java.util.Scanner(System.in).nextInt();
		if(i == 1) {
			talk(80,1000,h.getName()+"は20G払った");
			//お金を払う
			Bag.money -= 20;
			talk(80,1000,"「じゃあ最高の体験を味あわせてア・ゲ・ル♡」");
			talk(80,1000,"「◯×△◯×△◯×△◯×△」");
			talk(80,1000,"「△◯×△◯×△◯×△」");
			talk(80,1000,"「×△◯×△◯×△◯×△」") ;
			talk(80,1000,h.getName()+"は言葉に表せない体験をした。");
			talk(80,1000,"「どうだった？私のぱ◯ぱふ、よかったらまたきてね♡」");
			talk(80,1000,"勇者の経験値が１上がった");
			//勇者の経験値が上がるメソッド
			h.setEXP(h.getEXP()+1);

		}else {
			talk(80,1000,"「あら残念♪」");
			talk(80,1000,"「また気になったら遊びにきてね♪」");

		}
		this.bunnyGirltalk ="「あら♪こないだの素敵なお兄さんじゃない！」";
	}

	public void title() throws Exception{
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(1,0,"　　　　　　＊＊＊　　　　　　　　　　　　　　　＊＊＊　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　");
		talk(1,0,"　　　　　　＊＊＊＊　　　　＊＊　　　　　　　＊＊　　　　　　　　　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　　　＊＊　　　　　＊＊　　　　　　　　　　　　＊＊　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊　　　　　　　　　　　　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　＊＊＊＊＊＊　　　＊＊　　　　　　　　　　　　　　＊＊　　　　　　　　　＊＊＊　　　＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊　＊＊＊＊＊＊＊＊＊＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　＊＊＊　　　　　＊＊　　　　　　　　　　　　　　＊＊　　　　　　　　＊＊＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　＊＊　　　　＊＊＊　　　　　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　　＊＊　　　　＊＊　　　　　　　　　　　　　　　　＊＊　　　　　　　＊＊＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　＊＊　　　　＊＊＊　　　　　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊＊　　　　　　　　　＊＊　　　　　　　　　　　　　　　　＊＊　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　　　　　　　＊＊　＊＊＊＊＊＊＊＊＊＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊＊＊＊　　　　　　　＊＊　　　　　　　　　　　　　　　　＊＊　　　　　＊＊＊＊　　　　＊＊＊　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　　　　＊＊　＊　　＊＊＊　　　＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊＊＊＊＊＊　　　　　＊＊　　　　　　　　　　　　　　　　＊＊　　　　＊＊＊＊　　　　＊＊＊　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　　　　＊＊　＊　　＊＊＊　　　＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　＊＊＊＊　　　　＊＊　　　　　　　　　　　　　　　　＊＊　　　＊＊＊＊　　　　　＊＊＊　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　＊＊　＊　　＊＊＊　　　＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　＊＊＊＊　　　＊＊　　　　　　　　　　　　　　　　＊＊　　＊＊＊＊　　　　　＊＊＊　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　＊＊　＊＊＊＊＊＊＊＊＊＊　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　　＊＊＊　　　　＊＊　　　　　　　　　　　　　　＊＊　　　　＊　　　　　　＊＊＊＊　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　　＊＊　　　　＊＊＊　　　　　＊＊　　");
		talk(1,0,"　　　　　　　＊＊＊　　　　　　　　　　　＊＊　　　　　　　　　　　　　　＊＊　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　＊＊＊＊");
		talk(1,0,"　　　　　　　＊＊＊　　　　　　　　　　　　＊＊　　　　　　　　　　　　＊＊　　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　＊＊＊");
		talk(1,0,"　　　　　　　＊＊＊　　　　　　　　　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　　　　　　＊＊＊　　　　　　　　　＊＊＊　　　　＊＊＊＊＊　　　　＊＊＊");
		talk(1,0,"　　　　　　　＊＊＊　　　　　　　　　　　　　＊＊＊　　　　　　　　＊＊＊　　　　　　　　　＊＊＊＊　　　　　　　　　　　　＊　　　　　　＊＊＊　　　　＊＊　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　");
		talk(1,0,"　　　　　　　＊＊＊　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　＊＊＊＊　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　＊＊　＊＊＊＊　　　　　＊＊＊＊＊＊　");
		talk(1,0,"　　　　　　　＊＊　　　　　　　　　　　　　　　　　＊＊＊＊＊＊　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　　＊　　　　　　　　　　　　　＊＊　　");

		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊　　　　　　　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　＊＊＊＊　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　＊＊＊＊　　　　　　　　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　＊＊＊　　　　　　　　＊＊＊　　　　　　　　　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　＊＊＊　　　　　　　＊＊＊　　　　　　　　　　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　＊＊＊　　　　　　　＊＊＊　　　　　　　　　　　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　＊＊＊＊　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　＊＊＊　　　＊＊＊＊＊＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊　　　　　　　　　　　＊＊＊　　　＊＊＊＊　　　　　　　　＊＊＊　　　＊＊＊＊＊＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊　　　　　　　　　＊＊＊　　　　　　　　＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　＊＊＊　　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　＊＊＊　　　　　　　　＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　＊＊＊　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　＊＊＊＊　　　　　　　＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　＊＊＊　　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　＊＊＊　　　　　　　＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　＊＊＊＊　　　　＊＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　＊＊＊　　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊＊＊＊　　　　");
		talk(1,0,"　　　　　　　　　　　　　　　　　　　　　　　　　＊＊＊　　　　　＊＊＊　　　　　　　　　＊＊＊　　　　　　　　　　　　　　　　　　　　＊＊＊＊＊＊＊　　　　　");
		System.out.print("																		");
		talk(1,0,"<|Press The ENTER|>");
		System.out.print("																																				");
		System.out.print("制作：とぴあ株式会社 ©2020︎");
		String i = new java.util.Scanner(System.in).nextLine();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}



}
