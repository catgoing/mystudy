package dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import student.Student;

public class Studentdao {
Scanner sc = new Scanner(System.in);
	
	
//	Student stuarr[] = null;
	private List<Student> list = new ArrayList<Student>();
	private int membernum;
	
	
	public Studentdao() {
		membernum=0;
		
		list.add(new Student(1,"홍길동",100,90,80)); 
		list.add(new Student(2,"이동국",200,80,70));
		list.add(new Student(3,"강호동",300,70,60));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i + "= " + list.get(i));
//		}
//		System.out.println();
	}
	
	// CRUD
	// 추가, 삭제, 검색, 수정
	public void insert() {
		System.out.print("number: ");
		int number = sc.nextInt();
		System.out.print("name: ");
		String name = sc.next();
		
		System.out.print("lang: ");
		int lang = sc.nextInt();
		System.out.print("math: ");
		int math = sc.nextInt();
		System.out.print("eng: ");
		int eng = sc.nextInt();
		
		
		
		
		list.add(new Student(number, name, lang, math, eng));
		membernum++;
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "= " + list.get(i));
		}
		System.out.println();
	}
	
	
	
	public void delete() {
		System.out.print("삭제할 이름?: ");
		String name = sc.next();
		
		int index = -1;
		List<Student> flist = new ArrayList<Student>();
		
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if(name.equals(s.getName())) {
					index = i;
					break;
				}
			}
		
		if(index != -1) {
			list.remove(index);
			System.out.println("데이터를 삭제하였습니다");
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
	}
	
	public void select() {
		System.out.print("검색할 이름: ");
		String name = sc.next();
		
		int index = -1;
		List<Student> flist = new ArrayList<Student>();
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if(name.equals(s.getName())) {
					flist.add(s);
					break;
				}
			}
		
		if(!flist.isEmpty()) {
			System.out.println("검색된 데이터는 >> ");
			for (int i = 0; i < flist.size(); i++) {
				System.out.println(flist.get(i).toString());
			}
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
		
	}
	
	public void update() {
		System.out.print("정보를 수정할 이름: ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if(name.equals(s.getName())) {
					index = i;
					break;
				}
			}
		
		if(index == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
			System.out.print("number: ");
			int number = sc.nextInt();
			System.out.print("name: ");
			name = sc.next();
			
			System.out.print("lang: ");
			int lang = sc.nextInt();
			System.out.print("math: ");
			int math = sc.nextInt();
			System.out.print("eng: ");
			int eng = sc.nextInt();
			
//			Student s = list.get(index);
//			s.setNumber(number);
//			s.setName(name);
//			s.setLang(lang);
//			s.setMath(math);
//			s.setEng(eng);
			
			
			list.set(index, new Student(number, name, lang, math, eng)); 
			System.out.println(list.get(index));
		
	}
	
	public void allprint() {
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(list.get(i));
			
			
//			List<Student> sortlist = new ArrayList<Student>( list );

			
			
			}
		}
	
	
	public void sorting() {
		
		LinkedList<Student> sortlist = new LinkedList<Student>();
		
		for (Student s : list) {
			sortlist.add(s);
		}
		
		
		Student stu = null;
		for (int j = 0; j < sortlist.size() - 1; j++) {
			for (int j2 = j + 1; j2 < sortlist.size(); j2++) {
				int num1 = sortlist.get(j).getEng();
				int num2 = sortlist.get(j2).getEng();
				
				if(num1 > num2) {
					stu = sortlist.get(j);
					sortlist.set(j, sortlist.get(j2));
					sortlist.set(j2, stu);
				}
				
			}
		}
		
		System.out.println("정렬된 영어점수(내림) >> ");
		for (int i = 0; i < sortlist.size(); i++) {
			Student s = sortlist.get(i);
			System.out.println(s);
					
			
		}

	}
	

	
	
	
	public void sortProc(Student arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].getEng()<arr[j].getEng()) {
					swap(arr, i, j);
				}
			}
		}
		
	}
	
	public void swap(Student arr[], int i, int j) {
		Student temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
}
