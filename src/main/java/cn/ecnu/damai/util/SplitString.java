package cn.ecnu.damai.util;

import java.util.ArrayList;

public class SplitString {
	public static ArrayList<String> splitString(String str, String spstr){
		if(str == null || spstr == null) {
			return null;
		}
		ArrayList<String> arraylist = new ArrayList();
		String[] list = str.split(spstr);
		for (int i = 0; i < list.length; i++) {
			arraylist.add(list[i]);
		}
		return arraylist;
	}
}
