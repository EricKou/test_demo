import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class TimerUtil {
	private static final String FORMAT = "yyyyMMdd";
	public static void main(String[] args) {
		//getTime("20150805113024");
		
		//{requestData = "{"checkType" : "2", "memberTelphone" : "18201145070"}"}
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
        System.out.println("现在的年份:" + year);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static String getTime(String timeStr) {
		Calendar cal = Calendar.getInstance();
       /* cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);// 星期减1 
        Date resultDate = cal.getTime(); // 结果  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("前一周:" + sdf.format(resultDate));*/
        
       /* cal.add(Calendar.DATE, -1);// 日期减1
        Date resultDate = cal.getTime(); // 结果  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("前一天:" + sdf.format(resultDate));*/
        
       /* cal.add(Calendar.DAY_OF_WEEK, -2);// 日期减1
        Date resultDate = cal.getTime(); // 结果 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("前两天:" + sdf.format(resultDate));*/
        
       
         
        //20140102113024
       /* System.out.println("传递的年份："+timeStr.substring(0, 4));
        System.out.println("传递的年月日："+timeStr.substring(0, 8));
        System.out.println("传递的格式化之后的年月日："+timeStr.substring(0, 4)+"-"+timeStr.substring(4, 6)+"-"+timeStr.substring(6, 8));
       */
		
//        System.out.println("现在的年份:" + year);
       /*System.out.println("sdf:" + sdf.format(resultDate));*/
       /* System.out.println("现在的月份为:" + month);
        System.out.println("现在的号为:" + date);
        System.out.println("现在的号为:" + dayOfMonth);
        System.out.println("现在是星期:" + dayOfWeek);
        System.out.println("现在过了的天数为:" + dayOfYear);
        System.out.println("现在几点:" + hour);
        System.out.println("现在几点:" + hourOfDay);
        System.out.println("现在几分:" + minute);
        System.out.println("现在几秒:" + second);
        System.out.println("现在几毫秒:" + millisecond);
        System.out.println("本月最后一天是:" + maxDate);*/
		//String timeString = timeStr.substring(0, 4)+"-"+timeStr.substring(4, 6)+"-"+timeStr.substring(6, 8);
		String timeString = timeStr.substring(0, 4)+timeStr.substring(4, 6)+timeStr.substring(6, 8);
		System.out.println(timeString);
		//0730-0806之间的所有的日期  前后都是开区间
		String dateString;
		if(timeString.equals(getCurrentTime(FORMAT))){
			System.out.println("时间："+timeStr.substring(8, 10)+":"+timeStr.substring(10, 12));
			dateString = timeStr.substring(8, 10)+":"+timeStr.substring(10, 12);
			return dateString;
		}
		if (timeString.equals(getYesterday(cal))) {
			System.out.println("昨天");
			dateString = "昨天";
			return dateString;
		}
		dateString = getDays(cal, timeString);
		if(dateString != null){
			return dateString;
		}
		dateString = timeStr.substring(0, 4)+"-"+timeStr.substring(4, 6)+"-"+timeStr.substring(6, 8);
		return dateString;
		
	}
	
	
	private static String getDays(Calendar cal,String timeString) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
		cal.add(Calendar.DATE, -1);
//		int b = p_end.getTime().getDay();
		Date fdate;
		List<String> list = new ArrayList<String>();
//		Long fTime = p_end.getTime().getTime() + b * 24 * 3600000;
		Long fTime = cal.getTime().getTime();
		for (int a = 1; a <= 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a - 1, sdf.format(fdate));
		}
		System.out.println("====="+list);
		
		for (String str : list) {
			if(timeString.equals(str)){
				return getWeek(timeString, cal);
			}
		}
		return null;
	}

	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}
	
	private static String getLastWeek(Calendar cal){
		cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);// 星期减1 
		cal.add(Calendar.DATE, -1);// 星期减1 
        Date resultDate = cal.getTime(); // 结果  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("前一周最后一天前一天:" + sdf.format(resultDate));
		return sdf.format(resultDate);
	}
	
	private static String getYesterday(Calendar cal){
		cal.add(Calendar.DAY_OF_WEEK, -1);// 日期减1
        Date resultDate = cal.getTime(); // 结果 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("前一天:" + sdf.format(resultDate));
        return sdf.format(resultDate);
	}
	
	private static String getWeek(String time,Calendar cal){
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int week_index = 0;
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			date1 = sdf.parse(time);
			cal.setTime(date1);
			week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("周几:" + weeks[week_index]);
		return weeks[week_index];
	}
}
