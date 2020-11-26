import java.util.ArrayList;
import java.util.List;

public class Arraymainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	collection:	(object)수집
		 	list:		목록	+ array
		 				데이터의 관리를 유동적으로
		 				
			arraylist(== vector): 	배열처럼 사용할 수 있는 목록
									선형구조 1-1-1-1-1-1
									검색 속도가 빠름
									index로 접근하고 관리된다
									0 ~ n-1
									
			linkedlist:				삽입과 삭제가 빈번하게 이루어질 때 사용			
			
			
		 	
		 */
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
//		List<Integer> list = new ArrayList<Integer>();
		
		// 추가
		arrlist.add(1001);
		arrlist.add(new Integer(1002)); // 다 같은 방식, 적는 법만 다르게 한 것
		Integer in = new Integer(1003);
		arrlist.add(in);
		
		// list size
		int len = arrlist.size();
		System.out.println("len: " + len);
		
		// 데이터 산출
		Integer outVal = arrlist.get(1);
		System.out.println("arrlist.get(1): " + outVal);
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + ": " + n);
		}
		
		for (Integer i : arrlist) {
			System.out.println(i);
		}
		
		// 원하는 위치에 추가
		Integer inum = new Integer(5002);  
		arrlist.add(1, inum); // 1번지에 5002 끼워넣기
		
		for (Integer i : arrlist) {
			System.out.println(i);
		}
		
		
		// 삭제
		
		arrlist.remove(2);
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + ": " + n);
		}
	
		// 검색
		
		int index = arrlist.indexOf(1003);
		System.out.println("indexnum = " + index);
		System.out.println(arrlist.get(index));
		
		index = -1;
		for (int i = 0; i < arrlist.size(); i++) {
			Integer value = arrlist.get(i);
			if(value == 5002) {
				index = i;
				break;
			}
		}System.out.println("find index = " + index);
		
		// 수정
		
		Integer udata = new Integer(1002);
		arrlist.set(1, udata);
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + ": " + n);
		}

		ArrayList<String> list = new ArrayList<String>();
		
		// 추가
		list.add("study");
		list.add(new String("kill"));
		String ad = new String("pil-yong");
		list.add(ad);
		
		for (int i = 0; i < list.size(); i++) {
			String n = list.get(i);
			System.out.println(i + ": " + n);
		}
		System.out.println();
		
		// 삭제
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			String n = list.get(i);
			System.out.println(i + ": " + n);
		}
		System.out.println();
		
		// 검색
		int index3 = list.indexOf("pil-yong");
		System.out.println("list indexn = " + index3);
		System.out.println(list.get(index3));
		
		index = -1;
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i);
			if(value.equals("study")) {
				index = i;
				break;
			}
		}System.out.println("find index = " + index);
		
		
		
		
		// 수정
		
		
		
		
		
	}

}
