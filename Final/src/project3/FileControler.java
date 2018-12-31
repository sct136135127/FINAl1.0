package project3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import application.Main;

public class FileControler implements Runnable{
	public List<String> recorder = new ArrayList<String>();
	
	public FileControler() {
		recorder.clear();
	}
	
	public void openfile(File file)
	{
		application.Main.space.init_without_barrier();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader); 
			String line = "";  
	        line = br.readLine(); 
	        
	        while (line != null) {  
	        	recorder.add(line);
                line = br.readLine(); // 一次读入一行数据  
            } 
	        
	        br.close();
		}catch(Exception e)
		{
			
		}
		
		Analyser t1 = new Analyser();
		Thread t = new Thread(t1);
		t.start();
	}
	
	public void savefile()
	{
		try {
			 //File writename = new File(".\\output.txt");
			File writename = new File("/Users/mylifefile/Desktop/output.txt");
	         writename.createNewFile(); // 创建新文件  
	         BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	         
	         for(int i = 0;i<recorder.size();++i)
	        	 out.write(recorder.get(i)+"\n"); 
	         
	         out.flush();   
	         out.close(); 
		}catch(Exception e)
		{
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.space.goodguys >0&&Main.space.badguys >0)
		{
			try {
				Thread.sleep(2000);
			}catch(Exception e)
			{
				
			}
		}
		
		savefile();
	}
}
