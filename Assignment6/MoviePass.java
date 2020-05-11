/**
 * 
 * @author Mohammad A. Kazemivarnamkhasti
 */
import java.util.*;

public class MoviePass extends Ticket {

//	Field(s)
	private int id;
	
//	Constructor(s)
	public MoviePass() {}

	public MoviePass(String name, String rating, int day, int time, String format, int id, int totalVisits, int timesSeen, int visitsPerDay) {
		super(name, rating, day, time, format, id, totalVisits, timesSeen, visitsPerDay);
		this.id = id;
		setType("MoviePass");
	}
	
//	Method(s)
	@Override
	public double calculateTicketPrice() {
		double price;
		
		if(getTotalVisits() < 1 && getFormat().equals("NONE"))
			price = 9.99;
		else
		{
			if(getVisitsPerDay() < 1 && getFormat().equals("NONE") && getTimesSeen() < 1)
			{
				price = 0;
			}
			else
			{
				price = 10.50;
				if(getTime() >= 18)
					price = 13.50;
				if(getFormat().equals("IMAX"))
					price += 3.00;
				if(getFormat().equals("3D"))
					price += 2.50;
				price += price * 0.096;
			}
		}
		setPrice(price);
		return price;
	}
	@Override
	public int getId() {
		return id;
	}
	
}
