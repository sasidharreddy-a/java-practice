package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AnagramsTogether {

	public static void main(String[] args) {
		AnagramsTogether anagramsTogether = new  AnagramsTogether();
		String[] str = {"act","god","cat","dog","tac"};
		anagramsTogether.printAnagramsTogether(str);
		anagramsTogether.listOfAnagrams(str);
	}

	private void listOfAnagrams(String[] str) {
		Map<String,List<String>> map = new HashMap<>();
		List<String> ls = new ArrayList<>();
         for(String s : str) {
        	 Optional<String> op = Arrays.stream(s.split("")).sorted().reduce(String::concat);
        	 String ss = op.get();
        	 if(map.containsKey(ss)) {
        		 map.get(ss).add(s);
        	 }else {
        		 ls= new ArrayList<String>();
        		 ls.add(s);
        		 map.put(ss, ls);
        	 }    	 
         }
         System.out.println(map.values());
	}

	class Word{
		String str;int index;

		public Word(String str, int index) {
			this.str = str;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Word [str=" + str + ", index=" + index + "]";
		}
		
		
		
	}
	
	static class comparatorStr implements Comparator<Word>{

		@Override
		public int compare(Word w1, Word w2) {
			// TODO Auto-generated method stub
			return w1.str.compareTo(w2.str);
		}
		
	}
	private void printAnagramsTogether(String str[]) {
		// TODO Auto-generated method stub
        Word[] warr = new Word[str.length];
        Word[] warrSort = new Word[str.length];
		for(int i=0;i<str.length;i++) {
			warr[i]=new Word(str[i],i);
			char[] c = str[i].toCharArray();
			Arrays.sort(c);
			warrSort[i]=new Word(String.valueOf(c),i);
		}
		Arrays.sort(warrSort,new comparatorStr());
		List<String> li = new ArrayList<>();
		for(int i=0;i<warrSort.length;i++) {
			li.add(warr[warrSort[i].index].str);
		}
		li.forEach(w->System.out.println(w));
	}
}
