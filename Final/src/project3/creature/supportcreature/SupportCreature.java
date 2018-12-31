package project3.creature.supportcreature;

import java.util.Random;

import application.Main;
import project3.creature.Creature;

public class SupportCreature extends Creature{
	protected SupportCreature(String name,int x,int y)
	{
		super(name,x,y);
	}

	public void action()
	{
		prepareskill();
	}
	
	public void prepareskill()
	{
		
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
	
	public boolean judgerecover(int tx,int ty)		//判断是否回复
	{
		if(Main.space.space[tx][ty] != null&&Main.space.space[tx][ty].barrierjudge == false)
		{
			Creature t = (Creature)Main.space.space[tx][ty];
			if(t.alive == true&&t.kind == this.kind&&t.blood<t.maxblood)
				return true;
		}
		
		return false;
	}
	
	public void actionskill(int x,int y)
	{
		System.out.println("Father funcj");
	}
}
