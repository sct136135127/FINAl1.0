package project3.creature;

import java.util.Random;

import application.Main;
import javafx.scene.image.*;
import project3.ObjPlace;

public class Creature extends ObjPlace  implements Runnable{
	public int blood;			//当前血量
	public int maxblood;			//满血量
	public int num;
	
	public int damage;			//攻击力
	public int dodge;			//被命中概率
	public boolean kind;			//阵营 
	
	public boolean alive = true;	//存活标志
	
	public String stand;
	public String attack;
	public String beattack;
	public String dead;
	
	protected static final Object lock = new Object();
	public static int actionnum = 0;

	protected Creature(String name,int x,int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		barrierjudge = false;
	}
	
	public void show()
	{
		Main.space.space[x][y] = this;
	}
	
	public void dead()
	{
		this.alive = false;
		Main.space.space[x][y] = null;
		
		if(kind == true)
			Main.space.goodguys--;
		else
			Main.space.badguys--;
		
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70+30);
		image.setFitHeight(40);
		image.setFitWidth(40);
		image.setImage(new Image(dead));
	}
	
	public void suffer(int sufferdamage)		//受伤
	{
		beattackedflash();	
		
		blood = blood - sufferdamage;
		if(blood <=0)
		{
			try {
				
				Thread.sleep(200);
				
				}catch(Exception e)
				{
					System.out.println("sleep failed");
				}
			//System.out.println(Main.space.goodguys+","+Main.space.badguys);
			dead();
		}
	}
	
	public void recover(int recoverblood)		//回复
	{
		blood = blood + recoverblood;
		if(blood > maxblood)
			blood = maxblood;
		
	}
	
	public void beattackedflash()			//被攻击动画
	{
		image.setImage(new Image(beattack));
		try {
			
		Thread.sleep(200);
		
		}catch(Exception e)
		{
			System.out.println("sleep failed");
		}
		
		image.setImage(new Image(stand));
	}
	
	public void attackflash()			//攻击或施法动画
	{
		image.setImage(new Image(attack));
		try {
			
		Thread.sleep(500);
		
		}catch(Exception e)
		{
			System.out.println("sleep failed");
		}
		
		image.setImage(new Image(stand));
	}
	
	public void run() {
		// TODO Auto-generated method stub
		synchronized (lock) {
			while(Main.space.goodguys >0&&Main.space.badguys >0)
			{	
				//System.out.println(this.getClass().getSimpleName());
				//System.out.println(this.num);
				if(actionnum == num&this.alive == true)
				{
					Random rand = new Random();
					if(actionnum <8)
						actionnum = rand.nextInt(13)+8;
					else
						actionnum = rand.nextInt(8);
					
					action();
					
					lock.notifyAll();
					try {
						Thread.sleep(300);
					}catch(Exception e)
					{}
				}
				else if(actionnum == num&&this.alive == false)
				{
					if(actionnum == 20)
						actionnum = 7;
					else if(actionnum == 7)
						actionnum = -1;
					
					actionnum++;
					
					lock.notifyAll();
					try {
						Thread.sleep(300);
					}catch(Exception e)
					{}
				}
				else
				{
					try
					{
						lock.wait();
					}catch(Exception e)
					{}
				}
			}
		}
	}
	
	public void action()
	{
		System.out.println("creature func");
	}
}
