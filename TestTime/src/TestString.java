import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;


public class TestString {
	public static void main(String[] args) {
		/*String a = "login_01.html";
		String b = "login_01_ol.html";
		String d = "ol_login_01.html";
		String c = "ol/login_01.html";
		if(b.contains(a)){
			System.out.println(b+",匹配成功");
		}
		if(c.contains(a)){
			System.out.println(c+",匹配成功");
		}
		if(d.contains(a)){
			System.out.println(d+",匹配成功");
		}*/ 
		String md5 = "85:93:4F:0F:92:E6:2C:11:76:9F:52:2C:A1:02:39:22";
		System.out.println("输出："+md5.toLowerCase());
		String m = md5.toLowerCase().replace(":", "");
		System.out.println("sign:"+m);
	}
	
}
