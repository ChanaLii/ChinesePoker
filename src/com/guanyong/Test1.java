package com.guanyong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Test1 {
	
	/**
	 * 模拟斗地主洗牌、发牌并排序
	 * @param args
	 */
	public static void main(String[] args) {
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"红桃","黑桃","方块","梅花"};
		//用键值对存储已排序的标准牌库
		HashMap<Integer, String> hm = new HashMap<>();
		//用List集合跟踪"键"
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0;
		//由小→大存储扑克牌
		for(String s1 : num){
			for(String s2 : color){
				hm.put(index, s2.concat(s1));
				list.add(index);
				index++;
			}
		}
		//将大小王添加到双列集合中
		hm.put(index, "小王");   //将52索引添加到集合中
		list.add(index);
		index++;
		hm.put(index, "大王");   //将53集合添加到结合中
		list.add(index);
		//System.out.println(list);
		
		//洗牌
		Collections.shuffle(list);
		//发牌，实际上随机发的是list集合中的值，TreeSet自动将值按大小排序
		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> player3 = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		for(int i = 0; i < list.size(); i++){
			if (i >= list.size()-3) {
				dipai.add(list.get(i));
			}else if (i%3==0) {
				player1.add(list.get(i));
			}else if (i%3==1) {
				player2.add(list.get(i));
			}else {
				player3.add(list.get(i));
			}
		}
		
		lookPoker(hm, player1, "魑魅");
		lookPoker(hm, player2, "魍魉");
		lookPoker(hm, player3, "郭靖");
		lookPoker(hm, dipai, "底牌");

		
	}
	/**
	 * 看牌
	 * 1、返回值类型void
	 * 2、参数列表：
	 * 	HashMap是由小到大排序的标准牌库。
	 * 	TreeSet是存储里List集合的随机数。
	 * 	String name是玩家名称
	 */
	public static void lookPoker(HashMap<Integer, String> hashMap,TreeSet<Integer> treeSet,String name){
		System.out.print(name + "的牌面是:");
		for(Integer integer : treeSet){
			System.out.print(hashMap.get(integer)+"、");
		}
		System.out.println("");
	}
}
