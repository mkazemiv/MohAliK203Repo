
public class Child extends Ticket {

//	Constructor(s)
	public Child() {}
	public Child(String name, String rating, int day, int time, String format) {
		super(name, rating, day, time, format);
		setType("Child");
	}
	
//	Method(s)
	@Override
	public double calculateTicketPrice() {
		double price = 5.75;
		if(getTime() >= 18)
			price = 10.75;
		if(getFormat().equals("IMAX"))
			price += 2.00;
		if(getFormat().equals("3D"))
			price += 1.50;
		price += price * 0.096;
		if(!getRating().equals("G") && !getRating().equals("PG"))
			price = 0;
		setPrice(price);
		return price;
	}
	@Override
	public int getId() {
		return -1;
	}
	

}
