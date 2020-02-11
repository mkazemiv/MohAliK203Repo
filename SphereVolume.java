import java.util.Scanner;
public class SphereVolume { 
	public static void main(String[] args) { 

		System.out.println("This program prints the volume of a "
							+ "sphere with a diameter given by the user.");
		Scanner keys = new Scanner(System.in);
		System.out.print("Enter a diameter: ");
		double diameter = keys.nextDouble();
		double radius = diameter/2;
		double volume = (4.0/3) * (Math.PI) * Math.pow(radius, 3);
		System.out.println("Volume: " +volume);
		keys.close();
	} 
}