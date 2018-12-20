import java.util.Scanner;
import java.lang.Math;

public class Fourier {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String function = new String();
		String der = new String();
		String con = new String();

		do {
			System.out.println("Enter a function in terms of x to take its derivative:");
			function = scan.next();

			der = derivative(function);

			System.out.println("The derivative is " + der + ".");

			System.out.println("Do you want to enter another function?");
			con = scan.next();
		} while (con.equals("yes"));
	}

	public static String derivative(String function) {
		final String add = "+";
		final String sub = "-";
		final String mul = "*";
		final String div = "/";
		final String exp = "^";
		final String sin = "sin(";
		final String cos = "cos(";
		final String tan = "tan(";
		final String csc = "csc(";
		final String sec = "sec(";
		final String cot = "cot(";
		final String log = "log(";
		final String nlg = "ln(";
		final String[] num = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		int i = 0;
		int j = 0;
		double coef = 0;

		String derive = new String();
		
		if (function.contains(mul)){
			derive = derivative(function.substring(0, function.indexOf(mul))) + mul + function.substring(function.indexOf(mul) + 1) + add + derivative(function.substring(function.indexOf(mul) + 1)) + mul + function.substring(0, function.indexOf(mul));
		}
		else if (function.contains(sub)){
			derive = derivative(function.substring(0, function.indexOf(sub))) + sub + derivative(function.substring(function.indexOf(sub) + 1));
		}
		else if (function.contains(add)){
			derive = derivative(function.substring(0, function.indexOf(add))) + add + derivative(function.substring(function.indexOf(add) + 1));
		}
		else if (function.contains(sin)){
			if (!function.contains(exp)){
				if (Double.valueOf(derivative(function.substring(function.indexOf("(") + 1, function.length() - 1))) == 1)
					derive = cos + function.substring(function.indexOf("(") + 1);
				else if (Double.valueOf(derivative(function.substring(function.indexOf("(") + 1, function.length() - 1))) == 0)
					derive = "0";
				else
					derive = derivative(function.substring(function.indexOf("(") + 1, function.length() - 1)) + cos + function.substring(function.indexOf("(") + 1);
			}
			else
				derive = derivative(function.substring(function.indexOf("(") + 1, function.length() - 1)) + cos + function.substring(function.indexOf("(") + 1);
		}
		else if (function.contains(cos)){
			if (!function.contains(exp)){
				if (Double.valueOf(derivative(function.substring(function.indexOf("(") + 1, function.length() - 1))) == 1)
					derive = "-" + sin + function.substring(function.indexOf("(") + 1);
				else if (Double.valueOf(derivative(function.substring(function.indexOf("(") + 1, function.length() - 1))) == 0)
					derive = "0";
				else
					derive = derivative(function.substring(function.indexOf("(") + 1, function.length() - 1)) + "-" + sin + function.substring(function.indexOf("(") + 1);
			}
			else
				derive = derivative(function.substring(function.indexOf("(") + 1, function.length() - 1)) + "-" + sin + function.substring(function.indexOf("(") + 1);
		}
		else if (function.contains(exp)){
			while (derive.equals("") || i<10){
				if (function.contains(num[i])){
					for (j = 0; j < 10; j++){
						if (function.startsWith(num[j])){
							coef = Double.valueOf(function.substring(0,function.indexOf("x")));
							coef *= Double.valueOf(function.substring(function.indexOf(exp)+1));
							if (Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")))-1 == 0)
								derive = String.valueOf(coef);
							else if (Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")))-1 == 1)
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp));
							else
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp)) + exp + String.valueOf(Double.valueOf(function.substring(function.indexOf(exp)+1))-1);
							j = 20;
						}
					}
					if (j == 10){
						if (function.contains(")")){
							coef = Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")));
							if (Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")))-1 == 0)
								derive = String.valueOf(coef);
							else if (Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")))-1 == 1)
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp));
							else
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp)) + exp + String.valueOf(Double.valueOf(function.substring(function.indexOf(exp)+1, function.indexOf(")")))-1);
						}
						else{
							coef = Double.valueOf(function.substring(function.indexOf(exp)+1));
							if (Double.valueOf(function.substring(function.indexOf(exp)+1))-1 == 0)
								derive = String.valueOf(coef);
							else if (Double.valueOf(function.substring(function.indexOf(exp)+1))-1 == 1)
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp));
							else
								derive = String.valueOf(coef) + function.substring(function.indexOf("x"), function.indexOf(exp)) + exp + String.valueOf(Double.valueOf(function.substring(function.indexOf(exp)+1))-1);
						}
					}
				}
				i++;
			}
		}
		else if (function.contains("x")){
			if (function.startsWith("x")){
				derive = "1";
			}
			else{
				derive = function.substring(0, function.indexOf("x"));
			}
		}
		else{
			derive = "0";
		}
		
		return derive;
	}
}