package com.guanyong;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
	
	/**
	 * 分析：
	 * 1、创建一个集合对象，将扑克牌存储进去
	 * 2、洗牌
	 * 3、发牌，每人17张，底牌3张单独看 
	 */
	public static void main(String[] args) {
		//1、创建两个数组
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] color = {"红桃","黑桃","方块","梅花"};
		//2、创建集合存储54张牌
		ArrayList<String> poker = new ArrayList<>();
		//3、组合花色和数字，并存储
		for(String str1 : num){
			for(String str2 : color){
				poker.add(str2.concat(str1));
			}
		}
		//4、大小王没有花色，要单独添加
		poker.add("大王");
		poker.add("小王");
		//5、洗牌，打乱元素的排列顺序
		Collections.shuffle(poker);
		//6、发牌,需要4个集合分别存储玩家的牌、底牌
		ArrayList<String> player1 = new ArrayList<>();
		ArrayList<String> player2 = new ArrayList<>();
		ArrayList<String> player3 = new ArrayList<>();
		ArrayList<String> dipai = new ArrayList<>();
		//当i=poker.size()-3、poker.size()-2、poker.size()-1，即i=52、53、54的时候给dipai
		//当i%3=0、3、6、9...给player1
		//当i%3=1、4、7、10...给player2
		//其余情况给player3
		for(int i = 0; i < poker.size(); i++){
			if (i>=poker.size()-3) {
				dipai.add(poker.get(i));
			}else if (i%3==0) {
				player1.add(poker.get(i));
			}else if (i%3==1) {
				player2.add(poker.get(i));
			}else {
				player3.add(poker.get(i));
			}
		}
		
		System.out.println("魑魅的牌面是:"+player1);
		System.out.println("魍魉的牌面是:"+player2);
		System.out.println("郭靖的牌面是:"+player3);
		System.out.println("底牌是："+dipai);

	}
}
