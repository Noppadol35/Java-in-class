
import java.util.Scanner; //import scanner class

public class ComputArea {
  public static void main(String[] args) {
    //Comput first area
    Scanner sc  = new Scanner(System.in); //create scanner object
    double radius = 10;
    final double PI = 3.14159; //declare constant
    double i ;

    int x = (int)(5/2.0); //excasting
    System.out.println("In value x = " + x);
    //float a = 1.0f; declare float usering >> f << recomment use double
    //double a = 1.0; double this a  big data type

    int z = Integer.parseInt("100"); //convert string to int
    double DB = Double.parseDouble("100"); //convert string to double
    System.out.println("string to int/double = " + z + DB);
    //int a = (int)(5.0/2); // 2.5 >> 2 Problem this a code cann't use a double in int but actually use (int)(args);

    //boolean lightON = true; 0 Flase 1 True

    
    System.out.print("Enter a number for radius: "); //system output display
    i = sc.nextDouble(); //read input from user
    double area = ++i * radius * PI; 
    
    

    System.out.println("The area = " + String.format("%.3f", area)); //system output display
  }
}