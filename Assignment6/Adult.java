
public class Adult extends Ticket {
//	Field(s)
	
//	Constructor(s)
	public Adult() {}
	public Adult(String name, String rating, int day, int time, String format) {
		super(name, rating, day, time, format);
		setType("Adult");
	}
	
//	Method(s)
	@Override
	public double calculateTicketPrice() {
		double price = 10.50;
		if(getTime() >= 18)
			price = 13.50;
		if(getFormat().equals("IMAX"))
			price += 3.00;
		if(getFormat().equals("3D"))
			price += 2.50;
		price += price * 0.096;
		return price;
	}
	@Override
	public int getId() {
		return -1;
	}
	
}
