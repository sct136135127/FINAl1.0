package project3.creature.specialcreature;

import java.util.Random;

import javafx.scene.image.ImageView;
import project3.Main;
import project3.creature.Creature;

public class Dawa extends SpecialCreature{

	public Dawa(String name,int x,int y)
	{
		super(name,x,y);
		damage = 2;
		blood = 4;
		maxblood = 4;
		
		dodge = 75;
		kind = true;
		
		stand = Main.Constant.dawastand;
		attack = Main.Constant.dawaattack;
		beattack = Main.Constant.dawabeattack;
		dead = Main.Constant.dawadead;
		
		image = new ImageView(stand);
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		image.setFitHeight(70);
		image.setFitWidth(70);
		
		application.Main.root.getChildren().add(image);
		num = 0;
	}
	
	public boolean attack()				//攻击范围 上下左右
	{
		Random rand = new Random();
		int probability = rand.nextInt(100);
		
		if(y>0&&judgeattack(x,y-1))
		{
			Creature t = (Creature)application.Main.space.space[x][y-1];
			if(probability < t.dodge)
			{
				actionattack(x,y-1);
				//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+x+" "+(y-1));
			}
			else
				attackflash();
		}
		else if(y<9&&judgeattack(x,y+1))
		{
			Creature t = (Creature)application.Main.space.space[x][y+1];
			if(probability < t.dodge)
			{
				actionattack(x,y+1);
				//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+x+" "+(y+1));
			}
			else
				attackflash();
		}
		else if(x<11&&judgeattack(x+1,y))
		{
			Creature t = (Creature)application.Main.space.space[x+1][y];
			if(probability < t.dodge)
			{
				actionattack(x+1,y);
				//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+(x+1)+" "+(y));
			}
			else
				attackflash();
		}
		else if(x>0&&judgeattack(x-1,y))
		{
			Creature t = (Creature)application.Main.space.space[x-1][y];
			if(probability < t.dodge)
			{
				actionattack(x-1,y);
				//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+(x-1)+" "+(y));
			}	
			else
				attackflash();
		}
		else
			return false;
		
		return true;
	}
	
	public void preparemove()						//准备移动
	{
		int flag  = findenemy();
		
		if(x<11&&application.Main.space.space[x+1][y] == null&&(flag == 1||flag == 4))
		{
			move(x+1,y);
			//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" move "+(x+1)+" "+(y));
		}
		else if(y>0&&application.Main.space.space[x][y-1] == null&&(flag == 1||flag == 2))
		{
			move(x,y-1);
			//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" move "+x+" "+(y-1));
		}
		else if(y<9&&application.Main.space.space[x][y+1] == null&&(flag == 3||flag == 4))
		{
			move(x,y+1);
			//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" move "+x+" "+(y+1));
		}
		else if(x>0&&application.Main.space.space[x-1][y] == null&&(flag == 2||flag == 3))
		{
			move(x-1,y);
			//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" move "+(x-1)+" "+(y));
		}
		else 
		{
			
		}
	}
}
