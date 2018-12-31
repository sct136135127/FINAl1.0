package project3.creature.supportcreature;

import java.util.Random;

import javafx.scene.image.ImageView;
import project3.Main;
import project3.creature.Creature;

public class Oldguy extends SupportCreature{

	public Oldguy(String name,int x,int y)
	{
		super(name,x,y);
		blood = 3;
		maxblood = 3;
	
		dodge = 75;
		kind = true;
		
		stand = Main.Constant.oldguystand;
		attack = Main.Constant.oldguyattack;
		beattack = Main.Constant.oldguybeattack;
		dead = Main.Constant.oldguydead;
		
		image = new ImageView(stand);
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		image.setFitHeight(70);
		image.setFitWidth(70);
		
		application.Main.root.getChildren().add(image);
		num = 7;
	}
	
	public void actionskill(int x,int y)
	{
		attackflash();
		Creature temp = (Creature)application.Main.space.space[x][y];
		temp.recover(1);
		if(application.Main.saveflag == true)
			application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+x+" "+y);
	}
	
	public void prepareskill()
	{
		Random rand = new Random();
		int t;
		int skillcount = 2;
		for(int i = 0;i<12;++i)
			for(int j = 0;j<10;++j)
			{
				t = rand.nextInt(100);
				if(judgerecover(i,j)&&t>50)
				{
					actionskill(i,j);
					//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+i+" "+j);
					skillcount--;
				}
				
				if(skillcount == 0)
					break;
			}
	}
}
