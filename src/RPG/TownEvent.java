package RPG;

public class TownEvent {
	private boolean mayorFlg;
	private boolean childFlg;
	private String divinerName = "[あやしい占い師]";
	private boolean scumFlg;
	private String bunnyGirltalk = "「あーら素敵なお兄さんじゃない！」";

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
		talk(70,600,"「よく来たな「勇者」よ。」");
		talk(70,600,"「ようこそ、とぴあ城へ」");
		talk(70,1000,"「なぜ呼ばれたかわかっていると思うが。今この世界が魔王の手に落ちようとしている」");
		talk(70,1000,"「一年前に突如現れた魔王は世界を征服し始め、この城の兵士たちもほとんど魔王にやられてしまった。。」");
		talk(70,600,"「その魔王のせいで町のみなは怯えておる。。」");
		talk(70,600,"「そこでおぬしに頼みがある！」");
		talk(70,600,"「魔王の討伐をお願いしたいんじゃ！」");
		talk(70,600,"「魔王を倒してくれ！それがこの世界の願いでもあるんじゃ！」");
		talk(70,700,"<|1[任せてください] 2[無理です]|>");
		int i = new java.util.Scanner(System.in).nextInt();

			while(i == 2) {
				talk(70,600,"「な、なんじゃ聞き間違いか」");
				talk(70,600,"「最近耳が遠くての」");
				talk(70,600,"「も、もう一度聞くがいいかの？」");
				talk(70,700,"「どうか魔王を倒してくれ！それがこの世界の願いじゃどうか頼むぞ！」");
				talk(70,600,"<|1[任せてください] 2[無理です]|>");
				int j = new java.util.Scanner(System.in).nextInt();
				i = j;
			}
				if(i == 1) {
					talk(70,600,"「よく言ってくれた！！期待しておるぞ！」");
			}
				talk(70,600,"「魔王はダンジョンの最深部に潜んでおるそうじゃ」");
				talk(70,600,"「しかしくれぐれも気をつけてくれ」");
				talk(70,600,"「今までダンジョンに挑んだ冒険者はみな魔王にやられた」");
				talk(70,600,"「日に日に被害は増えおる。今はもう142万人やられたそうじゃ」");
				talk(70,600,"「だがおぬしならやってくれると信じておる」");
				talk(70,600,"「ところでまだおぬしの名前を聞いてなかったな」");
				talk(70,600,"「名はなんというのじゃ？」");

			/*public void setName(){
					while(true){
					System.out.println("[名前を入力してください(6文字以内)]");
					String name = new java.util.Scanner(System.in).nextLine();
					if(name.isEmpty()) {
						System.out.println("文字を入力してください");
					}else if(name.length() > 6) {
						System.out.println("名前が長すぎます！");
					}else {
						this.name = name;
						break;
					}
				}
			}*/
				h.setName();
				talk(70,600,"「そうか" + h.getName() + "というのか!」");
				if(h.getName().equals("ほりかつ")) {
					talk(70,600,"「ん？そういえばその名前聞いたことあるような」");
					talk(70,600,"「そうじゃ昔世界を救ったと言われる伝説の勇者と同じ名前じゃ！」");
					talk(70,600,"「これは運命か、はたまた偶然か。。」");
					talk(70,600,"「まあどちらにせよ世界の運命はおぬしにかかっておる」");
				}else if(h.getName().equals("みずき")) {
					talk(70,600,"「ん？そういえばその名前聞いたことあるような」");
					talk(70,600,"「そうじゃ昔世界を救った伝説の魔法使いと同じ名前じゃ！」");
					talk(70,600,"「これは運命か、はたまた偶然か。。」");
					talk(70,600,"「まあどちらにせよ世界の運命はおぬしにかかっておる」");
				}
				talk(70,600,"「魔王討伐期待しておるぞ！」");
				talk(70,600,"「そうじゃ！おぬしに渡したいものがある。」");

				talk(70,1000,"("+ h.getName() +"は図鑑を受け取った。)");
				talk(70,600,"「これをバトル中に使えば敵の情報をその図鑑に登録することができるぞ!!」");
				talk(70,1000,"「ダンジョンは危ないから敵ごとの特徴を掴んでうまく切り抜けることが大切じゃ！」");
				talk(70,1000,"「あとじゃな、この城の城下町には冒険の手助けをする便利な施設があるから、そこで準備をすると良いぞ！」");
				talk(70,600,"「町長には話をつけておる。町へ降りたら案内してくれるぞ！」");
				talk(70,600,"「ワシからの話は以上じゃ良い知らせを待っておる」");
				talk(70,600,"「さあいけ！"+h.getName()+"よ！出発の時じゃ！」");
				talk(70,600,"こうして"+h.getName()+"は魔王を倒す旅に出ることになった");
				talk(70,600,"(これからどんな冒険が待ち受けているのか。)");
				talk(70,600,h.getName()+"は期待と不安を持ちながら城下に降りた");
				System.out.println("[町長]");
				talk(70,800,"「お！君は"+h.getName()+"だね。お会いできて嬉しいよ王様から話は聞いている!」");
				talk(70,800,"「私はこの町長だ。王様から勇者の冒険の手助けをするように頼まれているよ!」");
				talk(70,800,"「この城下には武器屋、アイテム屋、宿屋があるよ!」");
				talk(70,600,"「武器屋は敵と戦うための強い装備を」");
				talk(70,800,"「アイテム屋は体力が減った時に回復できる薬草などが買えるよ！」");
				talk(70,600,"「宿屋は一日休憩してバッチリ満タン回復さ！」");
				talk(70,600,"「ダンジョンで危うく倒れそうになったら戻ってきて休むといい！」");
				talk(70,1000,"「こんな感じで勇者様の冒険はこっちでサポートするから魔王討伐お任せしましたぞ！ハッハッハ」");
	}
	public void NPC(Hero h) throws Exception{ //引数にHEROとBAG
		label:while(true) {
		talk(100,600,"<誰と話しますか>");
		System.out.println("<|1[町長] 2[夢を語る子供] 3["+divinerName+"] 4[社会の底辺] 5[バニーガール]|>");
		int i = new java.util.Scanner(System.in).nextInt();
			switch(i) {
				case 1:
					Mayor(h);//BAG
					continue;
				case 2:
					Child();
					continue;
				case 3:
					Diviner(h);
					continue;
				case 4:
					Scum(h);//BAG
					continue;
				case 5:
					BunnyGirl(h);
					continue;
				default:
					break label;
			}
		}
	}
	public void Mayor(Hero h) throws Exception{ //バックインスタンスを引数に

		if( this.mayorFlg == false) {
			System.out.println("[町長]");
			talk(70,600,"「おおまたお会いしましたな"+h.getName()+"冒険は順調ですかな？」");
			talk(70,1000,"「そうだ！こないだアイテム屋の店主にあまりものとしてもらった薬草があるんだ！」");
			talk(70,600,"「よかったら役立てくれ！」");
			talk(70,1000,h.getName()+"は薬草をもらった");
			//薬草を貰う b.setYakuso(b.getYakuso()+1);
			talk(70,600,"「魔王討伐はみんなが願っている」");
			talk(70,600,"「よろしく頼みますぞハッハッハ」");
		}else {
			System.out.println("[町長]");
			talk(70,600,"「魔王討伐はみんなが願っている」");
			talk(70,600,"「よろしく頼みますぞハッハッハ」");
		}
		this.mayorFlg = true;
	}
	public void Child() throws Exception{
		if(this.childFlg == false) {
			System.out.println("[夢を語る子供]");
			talk(70,600,"「僕ね大きくなったらね、偉くなるんだ！！」");
			talk(70,600,"「偉くなったら王様になれるかもしれないんだよ！」");
			talk(70,600,"「そしたらね、僕が魔王の代わりに世界を征服するんだ！」");
		}else {
			System.out.println("[夢を語る子供]");
			talk(70,600,"「征服したらどんな気分かな♪」");
		}
		this.childFlg = true;

	}

	public void Diviner(Hero h) throws Exception{
		System.out.println("["+this.divinerName+"]");
		talk(70,600,"「私はこの町の占い師。人々を導くものです。占って行きましょうか？10Gいただきます」");
		talk(70,600,"<|1[はい]2[いいえ]|>");
		int i = new java.util.Scanner(System.in).nextInt();
		if(i == 1) {
			//10G払う
			talk(70,600,h.getName()+"は10G払った");
			int r = new java.util.Random().nextInt(3);
				switch(r) {
				case 0:
					talk(70,600,"「..むむ見えます！あなたはきっと魔王を倒すでしょう」");
					break;
				case 1:
					talk(70,600,"「..むむ見えます！あなたにはこれから哀しい運命が待ち受けていますね」");
					break;
				case 2:
					talk(70,600,"「..むむ見えます！あなたは、、、きっと良いことがあるでしょう」");
					break;
				}
			this.divinerName = "[インチキ占い師]";
		}else if(i == 2) {
			talk(70,600,"「さよなら」");
		}

	}
	public void Scum(Hero h) throws Exception{ //引数にBAGも渡す
		if(this.scumFlg == false) {
			System.out.println("[社会の底辺]");
			talk(70,600,"「お金をくれ！俺は働きたくないんだ！100Gくれ！」");
			talk(70,600,"<|1[お金をあげる] ２[あげない]|>");
			int i = new java.util.Scanner(System.in).nextInt();
			if(i == 1) {
				talk(70,600,h.getName()+"は100G払った");
				//お金を払うメソッド
				talk(70,600,"「さすが！お礼にこれあげる」");
				talk(70,1000,h.getName()+"は薬草をもらった");
				//タバコを貰うメソッド
				talk(70,600,"「やっぱお金はたかるに限るぜ！ヤッホーい！」");
				this.scumFlg = true;
			}if(i == 2) {
				talk(70,600,"「なら50Gで!」") ;
				talk(70,600,"<|1[お金をあげる] ２[あげない]|>");
				int j = new java.util.Scanner(System.in).nextInt();
				if(j == 1) {
					talk(70,600,h.getName()+"は50G払った");
				//お金を払うメソッド
					talk(70,600,"「さすが！お礼にこれあげる！」");
					talk(70,600,h.getName()+"はタバコをもらった");
				//タバコを貰うメソッドb.setTobacco(b.getTobacco() + 1);
					talk(70,600,"「やっぱお金はたかるに限るぜ！ヤッホーい！」");
					this.scumFlg = true;
				}else if(j == 2) {
					talk(70,600,"「ケチかよ。。」");
				}
			}
		}else {
			System.out.println("[社会の底辺]");
			talk(70,600,"「あっ君は金づるじゃん！」");
			talk(70,600,"「こないだはお金くれてありがとね！！」");
		}
	}
	public void BunnyGirl(Hero h) throws Exception{
		System.out.println("[バニーガール]");
		talk(70,600,"「"+bunnyGirltalk+"ぱ◯ぱふはいかが？たったの20Gよ。」") ;
		talk(70,600,"<|1[お願いします] 2[結構です]|>");
		int i = new java.util.Scanner(System.in).nextInt();
		if(i == 1) {
			talk(70,600,h.getName()+"は20G払った");
			//お金を払う Bag.money -= 20;
			talk(70,600,"「じゃあ最高の体験を味あわせてア・ゲ・ル♡」");
			talk(70,600,"「◯×△◯×△◯×△◯×△」");
			talk(70,600,"「△◯×△◯×△◯×△」");
			talk(70,1000,"「×△◯×△◯×△◯×△」") ;
			talk(70,600,h.getName()+"は言葉に表せない体験をした。");
			talk(70,600,"「どうだった？私のぱ◯ぱふ、よかったらまたきてね♡」");
			talk(70,1000,"勇者の経験値が１上がった");
			//勇者の経験値が上がるメソッド h.setEXP(h.getEXP()+1);

		}else if(i != 2) {
			talk(70,600,"「あら残念♪」");
			talk(70,600,"「また気になったら遊びにきてね♪」");

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
