package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		if(str.charAt(1) == '\\') {
			if(str.charAt(2)=='n') {
				return '\n';
			}else if (str.charAt(2)=='t') {
				return '\t';
			}
			str = str.replaceAll("\\\\", "");
			str = str.replaceAll("'", "");
			int n = Integer.parseInt(str);
			return (char) n;
		}
		return str.charAt(1);
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
		
	}

	
}
