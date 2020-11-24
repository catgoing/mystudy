import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dto.MemberDto;

public class Member {

	public static void main(String[] args) {

		List<MemberDto> memlist = new ArrayList<MemberDto>();
		
		// 추가
		memlist.add(new MemberDto(1, "호우명", 17));
		memlist.add(new MemberDto(2, "감자", 25));
		memlist.add(new MemberDto(3, "당근", 27));
		
		for (int i = 0; i < memlist.size(); i++) {
			System.out.println(i + "= " + memlist.get(i));
		}
		System.out.println();
		
		
		// 삭제
		
//		memlist.remove(2);
		
		// 수정
		MemberDto nm = new MemberDto(4, "고구마", 23);
		memlist.set(2, nm);
		
		for (int i = 0; i < memlist.size(); i++) {
			System.out.println(i + "= " + memlist.get(i));
		}
		
		for (MemberDto m2 : memlist) {
			System.out.println(m2.toString());
		}
		System.out.println();
		
		MemberDto updMem = memlist.get(0); // 0번지 선택
		updMem.setName("호박"); // 0번지의 이름을 변경
		
		for (MemberDto m2 : memlist) {
			System.out.println(m2.toString());
		}
		System.out.println();
		// 검색
		
//		이름
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < memlist.size(); i++) {
			MemberDto m = memlist.get(i);
				if(name.equals(m.getName())) {
					index = i;
					break;
				}
			}
		
		MemberDto m = memlist.get(index);
		System.out.println(name + ": " + m.toString());
		System.out.println();
		
		// 나이, 18세 이상 멤버
		List<MemberDto> findlist = new ArrayList<MemberDto>();
		
		for (int i = 0; i < memlist.size(); i++) {
			MemberDto m1 = memlist.get(i);
			if(m1.getAge()>=18) {
			findlist.add(m1);
			}
		}
		
		for (MemberDto m2 : findlist) {
			System.out.println(m2.toString());
		}

	}
	

}

class Search<Key, Value>{
	Key key;
	Value value;
	public Search(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
}
	

