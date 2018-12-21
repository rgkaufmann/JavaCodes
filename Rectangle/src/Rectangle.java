import java.awt.geom.*;
import java.util.*;
 
class Rectangle {
    public Rectangle() {
    }
    
    public void input(ArrayList myRect) {
    	System.out.println("We need four vertices for our rectangle.");
    	System.out.println("Please provide them in consecutive order.");
    	Scanner in = new Scanner(System.in);
    	for (char ch = 'A'; ch <= 'D'; ch++) {
    		System.out.print("Give me the x coordinate for point " + ch + ": ");
    		double x = in.nextDouble();
    		System.out.print("Give me the y coordinate for point " + ch + ": ");
    		double y = in.nextDouble();
    		Point2D.Double myPoint = new Point2D.Double(x, y);
    		myRect.add(myPoint);
    	}
    }
    
    public void output(ArrayList myRect) {
    	for (char ch = 'A'; ch <='F'; ch++) {
    		Point2D.Double pt = (Point2D.Double)myRect.get(ch - 65);
    		System.out.println("Point " + ch + " is (" + pt.getX() + ", " + pt.getY() + ")");
    	}
    }
    
    public double calculateArea (ArrayList myRect) {
    	Point2D.Double ptA = (Point2D.Double)myRect.get(0);
    	Point2D.Double ptB = (Point2D.Double)myRect.get(1);
    	Point2D.Double ptC = (Point2D.Double)myRect.get(2);
    	Point2D.Double ptD = (Point2D.Double)myRect.get(3);
    	double base = ptA.distance(ptB);
    	double height = ptA.distance(ptD);
    	return base * height;
    }
    
    public void input5thPoint(ArrayList myRect) {
    	boolean X = true;
    	boolean Coordinate = false;
    	boolean entered = false;
    	String SameCoor = "";
    	Scanner in = new Scanner(System.in);
    	Point2D.Double ptA = (Point2D.Double)myRect.get(0);
    	Point2D.Double ptB = (Point2D.Double)myRect.get(1);
    	double x = 0;
    	double y = 0;    	
    	
    	System.out.println("Please input a 5th point between A and B.");
    	
    	while (!entered){
    		System.out.print("Which coordinate is the same in both point A and point B? ");
    		SameCoor = in.next();
    		if (SameCoor.equalsIgnoreCase("x")) {
    			X = true;
    			entered = true;
    		}
    		else if (SameCoor.equalsIgnoreCase("y")){
    			X = false;
    			entered = true;
    			}
    			else{
    				System.out.println("Enter either x or y.");
    				entered = false;
    			}
    	}
    		
    	while (Coordinate == false) {
    		System.out.print("Give me the x coordinate for point F: ");
    		x = in.nextDouble();
    		System.out.print("Give me the y coordinate for point F: ");
    		y = in.nextDouble();
    	
    		if (X)
    			if (x == ptA.getX() && x == ptB.getX())
    				Coordinate = true;
    			else if (x != ptA.getX() || x != ptB.getX())
    				Coordinate = false;
    		else
    			if (y == ptA.getY() && y == ptB.getY())
    				Coordinate = true;
    			else if (y != ptA.getY() || y != ptB.getY())
    				Coordinate = false;
    	}
    	
    	Point2D.Double myPoint = new Point2D.Double(x,y);
    	myRect.add(myPoint);
    }
    
    public double calculateTriangleArea(ArrayList myRect) {
    	Point2D.Double ptA = (Point2D.Double)myRect.get(0);
    	Point2D.Double ptB = (Point2D.Double)myRect.get(1);
    	Point2D.Double ptC = (Point2D.Double)myRect.get(2);
    	Point2D.Double ptD = (Point2D.Double)myRect.get(3);
    	Point2D.Double ptF = (Point2D.Double)myRect.get(4);
    	double base = ptA.distance(ptF);
    	double height = ptA.distance(ptD);
    	return (1/2)*(base * height);
    }
    
    public static void main(String[] args) {
		Rectangle app = new Rectangle();
		ArrayList myRectangle = new ArrayList();
		app.input(myRectangle);
		app.input5thPoint(myRectangle);
		app.output(myRectangle);
		double area = app.calculateArea(myRectangle);
		System.out.printf("%s%5.2f", "The area of the rectange is ", area);
		double Triarea = app.calculateTriangleArea(myRectangle);
		System.out.printf("%s%5.2f", "The area of the ABD triangle is ", Triarea);
	}
}


