package test_map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Stu> map = new HashMap<String,Stu>();
		
		for (int i=0;i<21000;i++){
			map.put(String.valueOf(i), new Stu("Stu" + i,i) );
//			System.out.println(i);
		}
//		System.out.println(map.get("2000").getAge());
		
	}
}



