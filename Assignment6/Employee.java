/**
 * 
 * @author Mohammad A. Kazemivarnamkhasti
 */
public class Employee extends Ticket {

//	Field(s)
	private int id;
	
//	Constructor(s)
	public Employee() {}
	public Employee(String name, String rating, int day, int time, String format, int id, int seen) {
		super(name, rating, day, time, format, id, seen);
		this.id = id;
		setType("Employee");
	}
	
//	Method(s)
	@Override
	public double calculateTicketPrice() {
		double price;
		if(getTotalVisits() >= 2)
		{
			price = 10.50;
			if(getTime() >= 18)
				price = 13.50;
			if(getFormat().equals("IMAX"))
				price += 3.00;
			if(getFormat().equals("3D"))
				price += 2.50;
			price *= 0.5;
			price += price * 0.096;
		}
		else
			price = 0;
		setPrice(price);
		return price;
	}
	@Override
	public int getId() {
		return id;
	}
	
}
