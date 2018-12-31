package project3.creature.specialcreature;

import java.util.Random;

import javafx.scene.image.ImageView;
import project3.Main;
import project3.creature.Creature;

public class Erwa extends SpecialCreature{

	public Erwa(String name,int x,int y)
	{
		super(name,x,y);
		damage = 1;
		blood = 3;
		maxblood = 3;
		
		dodge = 50;
		kind = true;
		
		stand = Main.Constant.erwastand;
		attack = Main.Constant.erwaattack;
		beattack = Main.Constant.erwabeattack;
		dead = Main.Constant.erwadead;
		
		image = new ImageView(stand);
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		image.setFitHeight(70);
		image.setFitWidth(70);
		
		application.Main.root.getChildren().add(image);
		num = 1;
	}
	
	public boolean attack()				//攻击范围 3 九宫格
	{	
		boolean attackflag = false;
		temp:
		for(int i = y-3;i<y+3;++i)
			for(int j = x-3;j<x+3;++j)
			{
				if(i<0||i>11||j<0||j>11)
					continue;
				
				if(judgeattack(j,i))
				{
					actionattack(j,i);
					//application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+j+" "+i);
					
					attackflag = true;
					break temp;
				}
			}
		
		return attackflag;
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
