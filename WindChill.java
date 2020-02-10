import java.util.Scanner;
public class WindChill {
	public static void main(String[] args) {
		System.out.println("Wind Chill Index Calculator");
		Scanner keys = new Scanner(System.in);
		double temp, wind;
		// Constants
		final double NUM1 = 35.74, NUM2 = 35.75, NUM3 = 0.4275, NUM4 = 0.16, NUM5 = 0.6215;
				
		System.out.print("Enter temperature in degrees Fahrenheit (must be >=-45 and <= 45): ");
		temp = keys.nextDouble();
		if(temp > 45 || temp < -45)
		{
			System.out.println("Invalid input. Program terminated.");
		} else {
		System.out.print("Enter wind speed in MPH (must be >=5 and <=60): ");
		wind = keys.nextDouble();
		if(wind < 5 || wind > 60) {
			System.out.println("Invalid input! Program terminated.");
		} else {
		// Wind chill temperature formula
		double windChill = NUM1 + (NUM5*temp) - NUM2*(Math.pow(wind, NUM4))
						+ (temp*NUM3*(Math.pow(wind, NUM4)));
				
		System.out.println("Wind chill temperature: " + windChill);
		}}
		System.out.println("Programmer: Mohammad A. Kazemivarnamkhasti");
		keys.close();
	}
}