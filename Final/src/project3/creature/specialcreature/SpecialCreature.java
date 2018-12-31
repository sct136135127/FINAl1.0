package project3.creature.specialcreature;

import java.util.Random;

import application.Main;
import project3.creature.Creature;

public class SpecialCreature extends Creature{
	protected SpecialCreature(String name,int x,int y)
	{
		super(name,x,y);
	}
	
	public void action()
	{
		if(!prepareattack())					//转型
		{
			this.preparemove();
		}
	}
	
	protected int findenemy()							//确定敌人方向
	{
		int flag = 0;
		for(int i = 0;i<12;++i)
		{
			for(int j = 0;j<10;++j)
			{
				if(Main.space.space[i][j] != null&&Main.space.space[i][j].barrierjudge == false)
				{
					Creature t = (Creature)Main.space.space[i][j];
					if(t.alive&&t.kind != this.kind)
					{
						if(i>=x&&j<=y)
							flag = 1;
						else if(i>=x&&j>y)
							flag = 4;
						else if(i<x&&j>y)
							flag = 3;
						else if(i>=x&&j<=y)
							flag = 2;
					}
				}
			}
		}
		return flag;
	}
	
	public void preparemove()						//准备移动
	{
	
	}
	
	public void move(int x1,int y1) {			//移动
		//save
		Main.space.space[x][y] = null;
		Main.space.space[x1][y1] = this;
		
		this.x = x1;
		this.y = y1;
		
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		
		if(Main.saveflag == true)
			application.Main.fc.recorder.add(this.getClass().getSimpleName()+" move "+x+" "+y);
		//System.out.println(this.getClass().getSimpleName()+" move "+x+" "+y);
		//update
	};
	
	public boolean attack()
	{
		System.out.println("father func");
		return true;
	}
	
	public boolean prepareattack()				
	{
		//return false;
		return this.attack();
	}
	
	public boolean judgeattack(int tx,int ty)		//判断是否攻击
	{
		if(Main.space.space[tx][ty] != null&&Main.space.space[tx][ty].barrierjudge == false)
		{
			Creature t = (Creature)Main.space.space[tx][ty];
			if(t.alive == true&&t.kind != this.kind)
				return true;
		}
		
		return false;
	}
	
	public void actionattack(int x,int y)		//直接造成伤害
	{
		attackflash();
		Creature t = (Creature)Main.space.space[x][y];
		t.suffer(damage);
		if(Main.saveflag == true)
			application.Main.fc.recorder.add(this.getClass().getSimpleName()+" attack "+x+" "+y);
	}
}

