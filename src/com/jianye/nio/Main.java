package com.jianye.nio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("audioModel");
		System.out.println(myList.toString());
		
		String str = "aas";
		List<String> generateList = getListFromStr(str, ",");
		// generateList = new ArrayList<String>();
		System.out.println(generateList);
		
		System.out.println(mergeList(myList, generateList, ","));
	}
	
	public static List<String> getListFromStr(String str, String separator) {
		List<String> resultList = new ArrayList<String>();
		String[] strArray = str.split(separator);
		int arrayLength = strArray.length;
		String strTemp = "";
		for (int i = 0; i < arrayLength; i++) {
			strTemp = strArray[i];
			if (!resultList.contains(strTemp)) {
				resultList.add(strTemp);
			}
		}
		return resultList;
	}
	
	public static String mergeList(List<String> list1, List<String> list2, String separator) {
		StringBuffer sb = new StringBuffer();
		Set<String> set = new HashSet<String>();
		if (null != list1 && list1.size() > 0) {
			set.addAll(list1);
		}
		if (null != list2 && list2.size() > 0) {
			set.addAll(list2);
		}
		int setSize = set.size();
		int count = 0;
		Iterator<String> setIterator = set.iterator();
		// 为null直接返回
		if (null == separator) {
			return sb.toString();
		}
		while (setIterator.hasNext()) {
			if (count == setSize - 1) {
				sb.append(setIterator.next());
			} else {
				sb.append(setIterator.next()).append(separator);
			}
			count++;
		}
		return sb.toString();
	}
}
