/**
 * @author Mohammad A. Kazemivarnamkhasti
 */
abstract public class Ticket {

//	Field(s)
	enum Format {
		IMAX, THREE_D, NONE
	}
	private double price;
	private int id, time, day, totalVisits, timesSeen, visitsPerDay;
	private String name, rating, format, type;

//	Constructor(s)
	public Ticket() {}

	public Ticket(String name, String rating, int day, int time, String format) {
		this.name = name;
		this.rating = rating;
		this.day = day;
		this.time = time;
		this.format = format;
	}

	public Ticket(String name, String rating, int day, int time, String format, int id, int totalVisits) {
		this.name = name;
		this.rating = rating;
		this.day = day;
		this.time = time;
		this.format = format;
		this.id = id;
		this.totalVisits = totalVisits;
	}

	public Ticket(String name, String rating, int day, int time, String format, int id, int totalVisits, int timesSeen,
			int visitsPerDay) {
		this.name = name;
		this.rating = rating;
		this.day = day;
		this.time = time;
		this.format = format;
		this.id = id;
		this.totalVisits = totalVisits;
		this.timesSeen = timesSeen;
		this.visitsPerDay = visitsPerDay;
	}

//	Method(s)
	/**
	 * 
	 * @return
	 */
	abstract public double calculateTicketPrice();

	/**
	 * 
	 * @return
	 */
	abstract public int getId();

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param p
	 */
	public void setPrice(double p) {
		price = p;
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public void setTime(int t) {
		time = t;
	}

	/**
	 * 
	 * @return time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * 
	 * @return totalVisits
	 */
	public int getTotalVisits() {
		return totalVisits;
	}

	/**
	 * 
	 * @return visitsPerDay
	 */
	public int getVisitsPerDay() {
		return visitsPerDay;
	}

	/**
	 * 
	 * @param d
	 */
	public void setDay(int d) {
		day = d;
	}

	/**
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @return
	 */
	public int getTimesSeen() {
		return timesSeen;
	}

	/**
	 * 
	 * @param n
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param r
	 */
	public void setRating(String r) {
		rating = r;
	}

	/**
	 * 
	 * @return
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * 
	 * @param f
	 */
	public void setFormat(String f) {
		format = f;
	}

	/**
	 * 
	 * @return
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 
	 * @param t
	 */
	public void setType(String t) {
		type = t;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		String p = String.format("%.2f", Math.round(getPrice()*100)/100.0);
		return getType() + "-" + getId() + " " + getFormat() + " Movie: " + getName() + " Rating: " + getRating()
				+ " Day: " + getDay() + " Time: " + getTime() + " Price: $" + p;
	}

}