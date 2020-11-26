package cls;

import inter.WriteMode;

public class WriterClass {
	
	public void writerMethod(WriteMode wm) {
		wm.write();
//		if(wm instanceof Ballpen) {		// 이렇게 길게 하기 싫으면 각각 클래스에 erase나 delete 추가해주면 됨
//			((Ballpen)wm).erase();
//		} else {
//			((Pencil)wm).delete();
//		}
	}

}
