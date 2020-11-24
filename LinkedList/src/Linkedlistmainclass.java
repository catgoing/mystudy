import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Linkedlistmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 	arraylist:	검색,	대입
		 	
		 	linkedlist:	실시간 추가.삭제가 빠름
		 	
		 */
		
		Vector<String> vec = new Vector<String>();
		vec.add(new String("hello"));
		
		vec.add(0, "world");
		vec.size();
		
		LinkedList<String> list = new LinkedList<String>(); // -> 링크드리스트
//		List<String> list = new LinkedList<String>();  -> 어레이리스트
		list.add("Tigers");
		list.add("Giants");
		list.add("Twins");
		
		
		// 맨 앞에 element를 추가 -> 0번지로 감
		list.addFirst("Lions");	// Linkedlist에만 있음, Arraylist에는 없는 기능
		
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		
		list.addLast("규백");
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		
//		ArrayList<String> alist = new ArrayList<String>(list);		// -> 검색이 필요할 때 linkedlist -> arraylist로 전환
//		LinkedList<String> llist = new LinkedList<String>(alist);	// -> 삽입, 삭제가 필요할 때 arraylist -> linkedlist로 전환
		
		// iterator:	반복자(=포인터) 	0x10		0x14
//										0번지			1번지
		
		Iterator<String> it;
		it = list.iterator();
		
		while(it.hasNext()) { 	// it이 값을 가진 동안 차례대로 대입하여 while 반복
			String value = it.next();
			System.out.println("it: " + value);
		}

	}

}
