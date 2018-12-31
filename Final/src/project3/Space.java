package project3;

import java.io.*;
import java.util.*;

import project3.creature.specialcreature.*;
import project3.creature.supportcreature.*;

public class Space {
	public ObjPlace [][]space;
	public int goodguys = 0;
	public int badguys = 0;
	
	public SupportCreature oldguy = null;// = new Oldguy("老爷爷",Main.Constant.Osupportplacex,Main.Constant.Osupportplacey);
	public SupportCreature snake = null;// = new Snake("蛇精",Main.Constant.Ssupportplacex,Main.Constant.Ssupportplacey);
	public SpecialCreature scorpion = null;// = new Scorpion("蝎子精",8,2);
	
	public SpecialCreature dawa = null;// = new Dawa("大娃",2,2);
	public SpecialCreature erwa = null;// = new Erwa("二娃",2,3);
	public SpecialCreature sanwa = null;// = new Sanwa("三娃",2,4);
	public SupportCreature siwa = null;// = new Siwa("四娃",2,5);
	public SupportCreature wuwa = null;// = new Wuwa("五娃",2,6);
	public SpecialCreature liuwa = null;// = new Liuwa("六娃",2,7);
	public SupportCreature qiwa = null;// = new Qiwa("七娃",2,8);
	
	public List<NormalCreature> soldier;// = new ArrayList<NormalCreature>();
	
	public Space(){
		space = new ObjPlace[Main.Constant.spacesize][10];
		for(int i = 0;i<Main.Constant.spacesize;++i)
			for(int j = 0;j<10;++j)
				space[i][j] = null;
	}
	
	void add_barrier()
	{
		for(int i = 0;i<=Main.Constant.barriernum;++i)
		{
			Random rand = new Random();
			int x = rand.nextInt(3)+3;
			int y = rand.nextInt(10);
			
			if(space[x][y] == null)
				space[x][y] = new Barrier(x,y);
		}
	}
	
	void initspace()
	{
		for(int i = 0;i<Main.Constant.spacesize;++i)
			for(int j = 0;j<10;++j)
			{
				if(space[i][j] != null)
				{
					application.Main.root.getChildren().remove(space[i][j].image);
				}
				space[i][j] = null;
			}
	}
	
	void initsoldier() {
		soldier.clear();
		int i = 0;
		for(Formation a:Formation.values())
		{
			soldier.add(new NormalCreature("喽啰",a.x,a.y,10+i));
			soldier.get(i).show();
			i++;
		}
	}
	
	void show()
	{
		initsoldier();
		snake.show();
		dawa.show();
		erwa.show();
		sanwa.show();
		siwa.show();
		wuwa.show();
		liuwa.show();
		qiwa.show();
		oldguy.show();
		scorpion.show();
	}
	
	public void init()
	{
		init_without_barrier();
		add_barrier();
	}
	
	public void init_without_barrier()
	{
		initspace();
		goodguys = 8;
		badguys = 13;
		
		delete_image(snake);
		snake = new Snake("蛇精",Main.Constant.Ssupportplacex,Main.Constant.Ssupportplacey);
		delete_image(scorpion);
		scorpion = new Scorpion("蝎子精",8,2);
		int i = 0;
		for(Formation a:Formation.values())
		{
			try {
				delete_image(soldier.get(i));
			}catch(Exception e)
			{
				
			}
			i++;
		}
		soldier = new ArrayList<NormalCreature>();
		
		delete_image(dawa);
		dawa = new Dawa("大娃",2,2);
		delete_image(erwa);
		erwa = new Erwa("二娃",2,3);
		delete_image(sanwa);
		sanwa = new Sanwa("三娃",2,4);
		delete_image(siwa);
		siwa = new Siwa("四娃",2,5);
		delete_image(wuwa);
		wuwa = new Wuwa("五娃",2,6);
		delete_image(liuwa);
		liuwa = new Liuwa("六娃",2,7);
		delete_image(qiwa);
		qiwa = new Qiwa("七娃",2,8);
		delete_image(oldguy);
		oldguy = new Oldguy("老爷爷",Main.Constant.Osupportplacex,Main.Constant.Osupportplacey);
		
		show();
	}

	void delete_image(ObjPlace temp)
	{
		if(temp != null)
		{
			application.Main.root.getChildren().remove(temp.image);
		}
	}
	
	public void start()
	{
		Thread t1 = new Thread(dawa);
		Thread t2 = new Thread(erwa);
		Thread t3 = new Thread(sanwa);
		Thread t4 = new Thread(siwa);
		Thread t5 = new Thread(wuwa);
		Thread t6 = new Thread(liuwa);
		Thread t7 = new Thread(qiwa);
		Thread t8 = new Thread(oldguy);
		Thread t9 = new Thread(snake);
		Thread t10 = new Thread(scorpion);
		Thread t11 = new Thread(soldier.get(0));
		Thread t12 = new Thread(soldier.get(1));
		Thread t13 = new Thread(soldier.get(2));
		Thread t14 = new Thread(soldier.get(3));
		Thread t15 = new Thread(soldier.get(4));
		Thread t16 = new Thread(soldier.get(5));
		Thread t17 = new Thread(soldier.get(6));
		Thread t18 = new Thread(soldier.get(7));
		Thread t19 = new Thread(soldier.get(8));
		Thread t20 = new Thread(soldier.get(9));
		Thread t21 = new Thread(soldier.get(10));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t16.start();
		t17.start();
		t18.start();
		t19.start();
		t20.start();
		t21.start();
		
		Thread t22 = new Thread(application.Main.fc);
		t22.start();
	}
}
