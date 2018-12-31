package project3;

import application.Main;

public class Analyser implements Runnable{

	protected static final Object lock2 = new Object();
	
	Analyser()
	{
	}
	@Override
	public void run() {
		synchronized (lock2) {
			for(int i = 0;i<Main.fc.recorder.size();i = i + 1)
			{
				System.out.println(Main.fc.recorder.get(i));
				analysis(Main.fc.recorder.get(i));
				try {
					Thread.sleep(500);
				}catch(Exception e)
				{
					
				}
				
			}
		}
	}
	
	public void analysis(String rl)
	{
		String name = rl.split(" ")[0];
		if(name.equals("Dawa"))
		{
			String t = rl.split(" ")[1];
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			if(t.equals("move"))
			{
				Main.space.dawa.move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.dawa.actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
		else if(name.equals("Erwa"))
		{
			String t = rl.split(" ")[1];
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			if(t.equals("move"))
			{
				Main.space.erwa.move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.erwa.actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
		else if(name.equals("Sanwa"))
		{
			String t = rl.split(" ")[1];
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			if(t.equals("move"))
			{
				Main.space.sanwa.move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.sanwa.actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
		else if(name.equals("Siwa"))
		{
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			Main.space.siwa.actionskill(Integer.valueOf(x),Integer.valueOf(y));
		}
		else if(name.equals("Wuwa"))
		{
			//System.out.println("Wuwa");
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			Main.space.wuwa.actionskill(Integer.valueOf(x),Integer.valueOf(y));
		}
		else if(name.equals("Liuwa"))
		{
			String t = rl.split(" ")[1];
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			if(t.equals("move"))
			{
				Main.space.liuwa.move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.liuwa.actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
		else if(name.equals("Qiwa"))
		{
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			Main.space.qiwa.actionskill(Integer.valueOf(x),Integer.valueOf(y));
		}
		else if(name.equals("Oldguy"))
		{
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			Main.space.oldguy.actionskill(Integer.valueOf(x),Integer.valueOf(y));
		}
		else if(name.equals("Snake"))
		{
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			Main.space.snake.actionskill(Integer.valueOf(x),Integer.valueOf(y));
		}
		else if(name.equals("Scorpion"))
		{
			String t = rl.split(" ")[1];
			String x = rl.split(" ")[2];
			String y = rl.split(" ")[3];
			if(t.equals("move"))
			{
				Main.space.scorpion.move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.scorpion.actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
		else						//soldier
		{
			String t = rl.split(" ")[2];
			String n = rl.split(" ")[1];
			String x = rl.split(" ")[3];
			String y = rl.split(" ")[4];
			if(t.equals("move"))
			{
				Main.space.soldier.get(Integer.valueOf(n)-10).move(Integer.valueOf(x),Integer.valueOf(y));
			}
			else
			{
				Main.space.soldier.get(Integer.valueOf(n)-10).actionattack(Integer.valueOf(x),Integer.valueOf(y));
			}
		}
	}
}