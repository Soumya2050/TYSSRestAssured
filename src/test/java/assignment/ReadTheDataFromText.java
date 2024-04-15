package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ReadTheDataFromText {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("C:/Users/srjen/OneDrive/Desktop/Text.txt");
		
		Scanner sc = new Scanner(f);
		String str="";
		while(sc.hasNextLine())
		{
			str=sc.nextLine();
		}
		String s[]=str.split(" ");
		LinkedHashMap<String, Integer>map = new LinkedHashMap<>();
		for(int i=0;i<s.length;i++)
		{
			if(!(map.containsKey(s[i]))) {
				map.put(s[i], 1);
			}else {
				map.put(s[i], map.get(s[i])+1);
			}
		}
		System.out.println(map);
	}

}
