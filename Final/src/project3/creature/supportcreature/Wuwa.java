package project3.creature.supportcreature;

import java.util.Random;

import javafx.scene.image.ImageView;
import project3.Main;
import project3.creature.Creature;

public class Wuwa extends SupportCreature{

	public Wuwa(String name,int x,int y)
	{
		super(name,x,y);
		blood = 3;
		maxblood = 3;
	
		dodge = 50;
		kind = true;
		
		stand = Main.Constant.wuwastand;
		attack = Main.Constant.wuwaattack;
		beattack = Main.Constant.wuwabeattack;
		dead = Main.Constant.wuwadead;
		
		image = new ImageView(stand);
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		image.setFitHeight(70);
		image.setFitWidth(70);
		
		application.Main.root.getChildren().add(image);
		num = 4;
	}
	
	public void actionskill(int x,int y)
	{
		attackflash();
		//System.out.println(x+" "+y);
		Creature temp = (Creature)application.Main.space.space[x][y];
		temp.suffer(2);
		if(application.Main.saveflag == true)
			application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+x+" "+y);
	}
	
	public void prepareskill()
	{
		Random rand = new Random();
		int t = rand.nextInt(100);
		if(t>30&&t<=60)
		{
			int skillcount = 1;
			for(int i = 0;i<12;++i)
				for(int j = 0;j<10;++j)
				{
					t = rand.nextInt(100);
					if(judgeattack(i,j)&&t>50)
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
}
