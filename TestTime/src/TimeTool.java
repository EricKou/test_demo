import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class TimeTool {
	private static final String FORMAT_YMD = "yyyyMMdd";
	private static final String FORMAT_YMDHMS = "yyyyMMddHHmmss";
	
	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}

	/*public static String getCurrentTime() {
		return getCurrentTime(FORMAT_YMDHMS);
	}*/
	
	public static String getCurrentDate() {
		return getCurrentTime(FORMAT_YMD);
	}
	
	public static String getCurrentTimeStamp() {
		return getCurrentTime(FORMAT_YMDHMS);
	}
	
	public static String getCurrentTime() {
		return getCurrentTime(FORMAT_YMDHMS);
	}
	
	public static void test(){
		List<String> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		list.add("小刘");
		list.add("男");
		list.add("15");
		map.put("person", list);
		System.out.println("======"+map);
	}
	public static void main(String[] args) {
		/*String t1 = getCurrentTime("yyyyMMddHHmmss");
		String t2 = getCurrentTime("yyyyMMdd");
		String t3 = getCurrentTime("HHmmss");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);*/
		test();
	}
}
