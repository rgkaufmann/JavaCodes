import java.util.Scanner;
import java.lang.Math;

public class FourierSeriesGenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String function = new String();
		String constant = new String();
		String cosCoefficient = new String();
		String sinCoefficient = new String();

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

	public static String derivative (String function) {
		final String add = "+";
		final String sub = "-";
		final String mul = "*";
		final String div = "/";
		final String exp = "^";
		final String sin = "sin";
		final String cos = "cos";
		final String tan = "tan";
		final String csc = "csc";
		final String sec = "sec";
		final String cot = "cot";
		final String log = "log";
		final String nlg = "ln";
		final String[] num = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		String derive = new String();

		if (function.contains(add)){
			derive = derivative(function.substring(0, function.indexOf(add))) + 
			   add + derivative(function.substring(function.indexOf(add)+1));
			return derive;
		}
		else if (function.contains(sub)){
			derive = derivative(function.substring(0, function.indexOf(sub))) +
			   sub + derivative(function.substring(function.indexOf(sub)+1));
			return derive;
		}
		else if (function.contains(mul)){
			derive = function.substring(function.indexOf(mul)+1) +
			   mul + derivative(function.substring(0, function.indexOf(mul))) +
			   add + function.substring(0, function.indexOf(mul)) +
			   mul + derivative(function.substring(function.indexOf(mul)+1));
			return derive;
		}
		else if (function.contains(div)){
			derive = function.substring(function.indexOf(div)+1) +
			   mul + derivative(function.substring(0, function.indexOf(div))) +
			   sub + function.substring(0, function.indexOf(div)) +
			   mul + derivative(function.substring(function.indexOf(div)+1)) +
			   div + function.substring(function.indexOf(div)+1) + exp + "2";
			return derive;
		}
		else if (function.contains("x")){
			derive = "1";
			return derive;
		}
		else {
			derive = "0";
			return derive;
		}
	}
}

