package filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharFilter {
	
	private static Pattern p;
	private static Matcher m;
	
	public static String filterAndReplace(String input){
		if(!hasSpecialChars(input)){
			return input;
		}
		else{
			StringBuilder sb = new StringBuilder(input.length());
			char c;
			for(int i = 0; i < input.length(); i++){
				c = input.charAt(i);
				switch(c){
					case '<': 
						sb.append("&lt;");
						break;
					case '>': 
						sb.append("&gt;"); 
						break; 
					case '"': 
						sb.append("&quot;"); 
						break; 
					case '&':
						sb.append("&amp;"); 
						break; 
					default:
						sb.append(c);
				}
			}
			return sb.toString();
		}
		
	}
	
	private static boolean hasSpecialChars(String input){
		p = Pattern.compile("[^\\w]", Pattern.CASE_INSENSITIVE);
		m = p.matcher(input);
		boolean foundSpecialChars = m.find();
		return foundSpecialChars;
	}
}
