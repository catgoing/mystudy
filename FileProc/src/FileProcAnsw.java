import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProcAnsw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 생성
		String filename = "hello";
		File f = createf(filename); // File f = 를 하는 이유??
		
		// 쓰기
		String str[] = {"안녕하세요", "건강하세요", "성공하세요"};
		boolean b = data(f, str);
		if(b) {
			System.out.println("데이터가 저장되었습니다");
		}else {
			System.out.println("파일 데이터가 저장되지 않았습니다");
		}
		
		// 읽기
		String datas[] = dataload(f);
		for (String s : datas) {
			System.out.println(s);
		}
		

	}
	
	//생성
	static File createf(String filename) {
		File f = new File("d:/tmp/" + filename + ".txt");
		
		if(f.exists()){
			System.out.println(filename + ".txt 파일이 존재합니다");
			
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("파일 생성 성공");
		}
		
		return f;
	}
	
	//쓰기
	static boolean data(File f, String datas[]) {
		
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);	// 한 문장으로
			PrintWriter pw = new PrintWriter(bw);
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
				}
			pw.close();
			
		} catch (IOException e) {
			return false;
		}	// 파일 오브젝트 생성
		
		return true;
	}

	//읽기
	static String[] dataload(File f) {
		String datas[] = null;
		
		try {
			FileReader fr = new FileReader(f);
			
			
			// 데이터의 수?
			int count = 0;
			String str;
			BufferedReader br = new BufferedReader(fr);
			
				while((str = br.readLine()) != null) {
					count++;
				}
				br.close();
				
				//데이터 수에 맞게 할당
				datas = new String[count];
				
				
				br = new BufferedReader(fr); // 파일포인터의 초기화
				fr = new FileReader(f);
				int i = 0;
				while((str = br.readLine()) != null) {
					datas[i] = str;
					i++;
				}
				br.close();
			
						
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
		
		

	
}

