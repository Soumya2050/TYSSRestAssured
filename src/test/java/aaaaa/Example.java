package aaaaa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

import org.testng.annotations.Test;

import groovyjarjarantlr4.runtime.tree.Tree;

public class Example {

	@Test
	public void ex1() {

		String name = "abcd abcd abcd abcd";
		String s[] = name.split(" ");
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length; i++) {
			if (!(map.containsKey(s[i]))) {
				map.put(s[i], 1);
			} else {
				map.put(s[i], map.get(s[i]) + 1);
			}
		}
		System.out.println(map);
	}

	@Test
	public void exp2() {
		String name = "abcd abcd abcd abcd";
		String s[] = name.split(" ");
		LinkedHashSet<String> set = new LinkedHashSet<>();

		for (int i = 0; i < s.length; i++) {
			set.add(s[i]);
		}

		for (String string : set) {
			int count = 0;
			for (int i = 0; i < s.length; i++) {
				if (string.equals(s[i])) {
					count++;
				}
			}
			System.out.println(string + "---> " + count);
		}
	}

	@Test
	public void readDataFromText() throws FileNotFoundException {

		File f = new File("C:/Users/srjen/OneDrive/Desktop/Text.txt");

		Scanner sc = new Scanner(f);
		String s = "";
		while (sc.hasNextLine()) {
			s += sc.nextLine();
		}
		sc.close();
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		String str[] = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			if (!(map.containsKey(str[i]))) {
				map.put(str[i], 1);
			} else {
				map.put(str[i], map.get(str[i]) + 1);
			}
		}
		System.out.println(map);
	}

	@Test
	public void commonCharacterBetweenTwoString() {
		String s = "soumyaranjenbnasg";
		String s1 = "smnafdxzbdvnfahvdabnAsmnhbjyhgnm ";
		TreeSet<Character> set = new TreeSet<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s.charAt(i) == s1.charAt(j)) {
					set.add(s.charAt(i));
				}
			}
		}
		System.out.println(set);

	}

	@Test
	public void commonCharacterBetweenTwoString1() {
		String s = "soumyaranjanjena", s1 = "soumyaranjanjena";

		char ch[] = s.toCharArray(), ch1[] = s1.toCharArray();
		Arrays.sort(ch);
		Arrays.sort(ch1);
		LinkedHashSet<Character> list = new LinkedHashSet<>();
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch1.length; j++) {
				if (ch[i] == ch1[j]) {
					list.add(ch[i]);
				}
			}
		}
		System.out.println(list);

	}

	@Test
	public void reverse() {
		String s = "india";// output=i1n1d1i2a1
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		for (Character character : list) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (character == s.charAt(i)) {
					
				}
			}
			System.out.println(character + "--->" + count);
		}
	}

	@Test
	public void ArrayToString() {
		
		String s[]= {"abxn","amnsc","masndc","amnsdj"};
		String str="";
		for(int i=0;i<s.length;i++)
		{
			str+=s[i];
		}
		System.out.print(str);
		System.out.println("\n");
		char ch[]=str.toCharArray();
		System.out.println(Arrays.toString(ch));
	}
}
