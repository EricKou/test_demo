
public class NameUtil {
	private static String nameStr1 = "马云";
	private static String nameStr2 = "章泽天";
	private static String nameStr3 = "小泉纯一郎";
	private static String nameStr4 = "尼古拉斯凯奇";
	
	public static void main(String[] args) {
		getProtectedName(nameStr1,ProtectMode.PROTECT_AFTER_FISRT);
		getProtectedName(nameStr1,ProtectMode.PROTECT_MIDDLE);
		getProtectedName(nameStr1,ProtectMode.PROTECT_FISRT);
	}

	private static String getProtectedName(String nameStr,int protectMode) {
		if(protectMode == ProtectMode.PROTECT_FISRT){
			StringBuffer sb = new StringBuffer("*");
			sb.append(nameStr.substring(1, nameStr.length()));
			System.out.println(""+sb.toString());
			return sb.toString();
		}
		if(protectMode == ProtectMode.PROTECT_MIDDLE && nameStr.length() > 2){
			StringBuffer sb = new StringBuffer(nameStr.substring(0, 1));
			for (int i = 0; i < nameStr.substring(2, nameStr.length()-1).split("").length; i++) {
				sb.append("*");
			}
			sb.append(nameStr.substring(nameStr.length()-1, nameStr.length()));
			System.out.println(""+sb.toString());
			return sb.toString();
		}
		if(protectMode == ProtectMode.PROTECT_AFTER_FISRT){
			String secondName = nameStr.substring(2,nameStr.length());
			StringBuffer sb = new StringBuffer(nameStr.substring(0,1));
			for (int i = 0; i < secondName.split("").length; i++) {
				sb.append("*");
			}
			System.out.println(""+sb.toString());
			return sb.toString();
		}
		return null;
	}
	
	public class ProtectMode{
		private static final int PROTECT_AFTER_FISRT = 1;
		private static final int PROTECT_MIDDLE = 2;
		private static final int PROTECT_FISRT = 3;
	}
}
