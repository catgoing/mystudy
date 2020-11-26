package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HashmapmainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
			hashmap:	사전
						사과 = apple
						key = value
						String = Object
						key는 중복되지 않음
			
			Treemap:	hashmap + sorting
			
		 */
		// 이렇게 호환이 됨
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		Map<Integer, String> map = new HashMap<Integer, String>();
//		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(hMap);
		
		
		// 추가
		hMap.put(111, "백십일");
		hMap.put(new Integer(222), new String("이백이십이"));
		hMap.put(333, "삼백삼십삼");
		
		// value 취득
		String value = hMap.get(111);
		System.out.println("value: " + value);
		System.out.println();
		
		// 검색
//		있다or없다
		boolean b = hMap.containsKey(new Integer(222));
//		boolean b = hMap.containsKey(222);
		
		System.out.println(b);
		System.out.println();
		
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println(value);
		}
		System.out.println();
		
		// 모든 key값을 취득하고 value
		Iterator<Integer> it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key);
			String val = hMap.get(key);
			System.out.println(val);
			
		}
		System.out.println();
		
		
		// 수정
		hMap.replace(111, "10 + 10 + 1");
//		hMap.put(111, "110 + 1");  // 이미 있는 key 값을 다시 put하면 replace와 같은 기능을 함(수정)
		it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key);
			String val = hMap.get(key);
			System.out.println(val);
			
		}
		System.out.println();
		
		// 삭제
		hMap.remove(222);
		it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key);
			String val = hMap.get(key);
			System.out.println(val);
			
		}
		System.out.println();
		
		HashMap<String, String> haMap = new HashMap<String, String>();
		haMap.put("apple", "사과");
		haMap.put("pear", "배");
		haMap.put("grape", "포도");
		haMap.put("banana", "바나나");		
		
		// 취득
		value = haMap.get("apple");
		System.out.println(value);
		System.out.println();
		
		// 정렬 -> 트리맵으로 전환
		
		TreeMap<String, String> treeMap = new TreeMap<>(haMap); // new 이후의 제네릭은 생략 가능
		// 오름차순 keySet()
		Iterator<String> itkey = treeMap.keySet().iterator();
		
		while(itkey.hasNext()) {
			String key = itkey.next();
			System.out.println(key + " " + treeMap.get(key));
		} System.out.println();
		
		// 내림차순 descendingKeySet()
		Iterator<String> itkey1 = treeMap.descendingKeySet().iterator(); // 
		while(itkey1.hasNext()) {
			String key = itkey1.next();
			System.out.println(key + " " + treeMap.get(key));
		} System.out.println();
		
//		HashMap<Integer, MyDto> myMap = new HashMap<Integer, MyDto>();
		
		HashMap<Integer, Object> myMap = new HashMap<Integer, Object>();
//		MyDto md = new MyDto();
		
		// 추가
		myMap.put(1, new MyDto(1, "오이"));
		myMap.put(2, new MyDto(2, "당근"));
		
		
		
		// 삭제
		
		
		// 검색
//		value = ((MyDto)myMap.get(1)).getName(); 	cast 변환해서 네임값만 얻기
		value = myMap.get(1).toString();
		System.out.println("value: " + value);
		System.out.println();
		
		b = myMap.containsKey(1);
		System.out.println(b);
		System.out.println();
		
		if(myMap.containsKey(2)) {
			value = myMap.get(2).toString();
			System.out.println(value);
		}
		System.out.println();
		
		Iterator<Integer> ite = myMap.keySet().iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			System.out.println(key);
			String val = myMap.get(key).toString();
			System.out.println(val);
			
		}
			System.out.println();
		
		
		// 수정
			myMap.replace(1, new MyDto(5, "고구마"));
			ite = myMap.keySet().iterator();
			while(ite.hasNext()) {
				Integer key = ite.next();
				System.out.println(key);
				String val = myMap.get(key).toString();
				System.out.println(val);
			}
			
			
			
		
		// 출력
		
		
	}

}