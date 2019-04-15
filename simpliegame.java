package Game;

import java.util.*;

public class simpliegame {
	public static void main(String[] args) {
		// Scanner 类来获取用户的输入;
		//创建 Scanner 对象
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入游戏人数(阿拉伯数字): ");
		int playernum=0;		 
		if (sc.hasNextInt()) {
		playernum = sc.nextInt();
		} else {
			// 输入错误的信息
			System.out.println("输入的不是整数！");
			}
		String[] name=new String[playernum];
		//设置点券数组
		int[] volume=new int[playernum];
		int[] score=new int[playernum];
		//本轮循环状态
		int[] stop=new int[playernum];
		System.out.println("------请设置游戏初始信息------");
		for(int i=0; i<playernum; i++){
		System.out.println("请设置第"+(i+1)+"位玩家的姓名(一个单词,中间不能有空格):");
		name[i] = sc.next();
		System.out.println("请设置第"+(i+1)+"位玩家的点券数:");
		if (sc.hasNextInt()) {
			volume[i] = sc.nextInt();
			} else {
				// 输入错误的信息
				System.out.println("输入的不是整数！");
				}		 		
		score[i] = 0;
		stop[i]=1;
		}
		System.out.println("------输出玩家初始信息------");
		for(int i=0; i<playernum; i++){
			System.out.println("第"+(i+1)+"位玩家的姓名: "+name[i]);
			System.out.println("第"+(i+1)+"位玩家的点券: "+volume[i]);
			System.out.println("第"+(i+1)+"位玩家的分数: "+score[i]+"\n");
	 }
		System.out.println("游戏玩家总人数:"+playernum);		 
		int x=0;
		//骰子1和骰子2的值
	    int num1=0,num2=0;
	    //玩家本轮获得分数
	    int sum=0;
	    //点券最多的玩家的数组的下标	   
	    int max=0;
	    //崩溃玩家被判给本轮冠军的分数
	    int addscore=0; 
	    //本轮冠军的编号
	    int maxscore=0;
	    //找出点券最多的玩家
	   //先第一个玩家开始查找
	    for(int i = 1; i < playernum; i++) {
		    if(volume[max] < volume[i]){
	    	max=i;	
	    	}
				 i++;
	    }
		System.out.println("第"+(max+1)+"位玩家的点券最多: "+volume[max]+"\n");
		//先设置循环变量run的值为true
		Boolean run = true;
		//游戏开始
		while (run){	    	 
	  		System.out.println("第"+x+"轮");
			for(int i = 0; i < playernum; i++) {
				 //当玩家选择不停止或玩家崩溃前
				while(stop[max] != 0){
					// 注意不要写成(int)Math.random()*3，这个结果为0，因为先执行了强制转换
				 num1 = (int) (Math.random() * 6+1);  
				    System.out.println("骰子1的点数：" + num1);
				    num2 = (int) (Math.random() * 6+1);  
				    System.out.println("骰子2的点数：" + num2);
				//如果两个骰子的点数相同
				    if(num1==num2){
					 sum=num1*num2*2;
					 //如果玩家得分小于40
					 if(sum<40){
					 score[max]+=sum; 
					    System.out.println("第"+(max+1)+"位玩家的分数: "+score[max]+"\n");
					 }
 				 }else if(num1%2==0||num2%2==0){  //如果两个骰子有一个为偶数
					 sum=num1*num2;
					 score[max]+=sum; 
					    System.out.println("第"+(max+1)+"位玩家的分数: "+score[max]+"\n");
				 }else if(num1%2==1&&num2%2==1){  //如果两个骰子都是奇数
					 sum=num1*num2-(num1+1)-(num2+1);
					 score[max]+=sum; 
					    System.out.println("第"+(max+1)+"位玩家的分数: "+score[max]+"\n");
				 }				 				   
				    System.out.println("------输出"+name[max]+"玩家第"+x+"轮信息------");				 
					System.out.println("第"+(max+1)+"位玩家的姓名: "+name[max]);
					System.out.println("第"+(max+1)+"位玩家的点券: "+volume[max]);
					System.out.println("第"+(max+1)+"位玩家的分数: "+score[max]+"\n");				
					//当第一个达到1000分时停止游戏
					if(score[max]>100){
						//循环变量run变为false
						run = false;
						break;
					 }
 
					//得分低于40时玩家可以选择终止本轮比赛
					if(sum<40){
						System.out.println("是否再次滚动(1表示是，0表示否)： ");				
						stop[max] = sc.nextInt();
						System.out.println("是否再次滚动(1表示是，0表示否)： "+stop[max]);						
					}  //得分等于40时，玩家可以得到玩家总人数的40倍的分值
					else if(sum==40){
						 sum = playernum*40;
						 score[max] = sum;
						 System.out.println("第"+(max+1)+"位玩家的分数: "+score[max]+"\n");
						//跳出本轮比赛，开始下轮比赛
						 continue;
					}  //得分大于40时，分数归0
					else {
						addscore = score[max];
						 score[max] = -1;  //把崩溃玩家的分数设置为-1，防止多次使用
						stop[max] = 0;  //本轮循环状态结束					
						System.out.println("崩溃的"+name[max]+"玩"+score[max]+"家的"+addscore+"分"+name[max]);						

					}					  
			 	}	
				if(score[max] > 100){
					run = false;
					break;
				 } 
				//如果玩家达到最末，就从第一的位置开始，直到所有玩家都进行了本次轮询
				//否则顺时针左移
				 if(max==playernum-1)
				    { 
				    	max = 0;
				    }else{
				    max++;
				    } 			 
 			}
			if(score[max] > 100){
				run = false;
				break;
			 } 
			//找到本次轮询最高分，判断有无崩溃玩家
			for(int j = 1; j < playernum; j++){
				if(score[maxscore]<score[j]){
					maxscore = j;
				}	
				}
			for(int v=0;v<playernum;v++){
				if(score[v] == -1){
					score[maxscore] += addscore;				 
			System.out.println("崩溃的"+name[v]+"玩家的"+addscore+"分被判给本轮最高得分"+name[maxscore]+"玩家\n该玩家最终得分： "+score[maxscore]);						
				score[v] = 0;  //把崩溃玩家分数设置为0
				}
			}
			//最高得分大于1000，结束游戏
			if(score[maxscore] > 100){
				run = false;
				break;
			 } 
			x++;  //进行下次轮询 
	  	     }		 	  	  						
		System.out.println("------输出玩家初始信息------");
			for(int i=0; i<playernum; i++){
				System.out.println("第"+(i+1)+"位玩家的姓名: "+name[i]);
				System.out.println("第"+(i+1)+"位玩家的点券: "+volume[i]);
				System.out.println("第"+(i+1)+"位玩家的分数: "+score[i]+"\n");
		 }
		System.out.println("游戏总人数:"+playernum);
		System.out.print("game over!");
		sc.close();
	}	 
}
