package Student;

public class Student {
	
	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	public int sum;
	public double avg;
	public int n1,n2,n3;
	
	
	
	public void name(String str) {
		name = str;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal(int n1, int n2, int n3) {
		// getTotal 자체가 값을 가진 변수가 되어야 하기 때문에 return값이 필요.
//		호출형식: System.out.println(getTotal); -> 리턴값 필요
//		호출형식: s.getTotal(); -> 리턴값 불필요
		sum = n1+n2+n3;
		return sum;
	}
	public double getAverage() {
//		avg = (double)sum/3; 
//		return avg;
		return (double)sum/3;
	}
	
	public void avera() {
		System.out.println("avg: "+ (double)(sum/3));
	}
	

}
