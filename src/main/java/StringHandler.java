import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {
	
	public static String getSubstring(String stringRegexp, String searchableText){

			Pattern p = Pattern.compile(stringRegexp); 
			Matcher m = p.matcher(searchableText);
			String result=null;
			if (m.find()) {
				result=m.group();
			}
		return result;
	}
	
	public static boolean contains(String query, String searchableText) {
		return searchableText.contains(query);
	}
	
	public static List<String> getListFromString(String string, String delimeter){
		String[] arr=string.split(delimeter);
		List<String> result=new ArrayList<String>();
		for(int i=0;i<arr.length;i++) {
			String s=arr[i];
			if(s.startsWith(" ")){
				s=s.substring(1);
			}
			result.add(s);
		}
		return result;
	}

}
