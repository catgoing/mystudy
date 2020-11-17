import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FilewriteClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// file write, write는 파일이 없으면 새로 생성함
		File file = new File("d:/tmp/test.txt");
		
		/*
		// 한 문자씩 쓰기, 이전 내용은 삭제됨
		FileWriter fw = new FileWriter(file);
		fw.write("안녕" + "\n");
		fw.close(); // 반드시 써야 함. 안 쓰면 기입 안 됨.
		*/
		
		/*
		// 추가쓰기
		FileWriter fw = new FileWriter(file, true);
		fw.write("안녕" + "\n");
		fw.close(); // 반드시 써야 함. 안 쓰면 기입 안 됨.
		*/
		
		// 문장으로 쓰기
		FileWriter fw = new FileWriter(file, true);	// 파일 오브젝트 생성
		BufferedWriter bw = new BufferedWriter(fw);	// 한 문장으로
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print("안녕");
		pw.println(" 하이하이");
		pw.println("반갑다");
		
		pw.close();
		bw.close();
		fw.close();

	}

}
