
/**
 * @author mohal
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketManager implements MovieTicketManagerInterface {

//	Field(s)
	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

//	Constructor(s)
	public MovieTicketManager() {}

//	Method(s)
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		double price = 0;
		Ticket tik = null;
		switch (type) {
		case "Adult":
			Adult ad = new Adult(movieN, rating, d, t, f);
			tik = ad; // Adult object is casted to Ticket
			price = ad.calculateTicketPrice();
			break;
		case "Child":
			Child ch = new Child(movieN, rating, d, t, f);
			tik = ch; // Child object is casted to Ticket
			price = ch.calculateTicketPrice();
			break;
		case "Employee":
			Employee em = new Employee(movieN, rating, d, t, f, id, numVisits(id));
			tik = em; // Employee object is casted to Ticket
			price = em.calculateTicketPrice();			
			break;
		case "MoviePass":
			MoviePass mp = new MoviePass(movieN, rating, d, t, f, id, numVisits(id), numThisMovie(id, movieN),
					numMoviesToday(id, d));
			tik = mp; // MoviePass object is casted to Ticket
			price = mp.calculateTicketPrice();			
		}
		tik.setPrice(price);
		ticketList.add(tik);
		return price;
	}

	@Override
	public ArrayList<String> get3DTickets() {
		ArrayList<String> threeDeez = new ArrayList<String>();
		sortByDay();
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getFormat() == "3D")
				threeDeez.add(ticketList.get(i).toString());
		}
		return threeDeez;
	}

	public ArrayList<String> getAllTickets() {
		ArrayList<String> allTickets = new ArrayList<String>();
		sortByDay();
		for (int i = 0; i < ticketList.size(); i++) {
			allTickets.add(ticketList.get(i).toString());
		}
		return allTickets;
	}

	public ArrayList<String> getMoviePassTickets() {
		ArrayList<String> mp = new ArrayList<String>();
		sortById();
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getType().equals("MoviePass"))
				mp.add(ticketList.get(i).toString());
		}
		return mp;
	}

	public double totalSalesMonth() {
		double sales = 0.00;
		for (int i = 0; i < ticketList.size(); i++)
		{
			sales += ticketList.get(i).getPrice();
		}
		sales = Math.round(sales * 100) / 100.0;
		return sales;
	}

	public String monthlySalesReport() {
		double adultS = 0, childS = 0, employeeS = 0, movieP = 0;	// total sales per type
		int ad = 0, ch = 0, emp = 0, mp = 0;	// counters for each type
		for (int i = 0; i < ticketList.size(); i++)
		{
			if(ticketList.get(i).getType().equals("Adult"))
			{
				adultS += ticketList.get(i).getPrice();
				ad++;
			}
			else if(ticketList.get(i).getType().equals("Child"))
			{
				childS += ticketList.get(i).getPrice();
				ch++;
			}
			else if(ticketList.get(i).getType().equals("Employee"))
			{
				employeeS += ticketList.get(i).getPrice();
				emp++;
			}
			else//if(ticketList.get(i).getFormat().equals("MoviePass"))
			{
				movieP += ticketList.get(i).getPrice();
				mp++;
			}
		}
		adultS = Math.round(adultS * 100) / 100.0;
		childS = Math.round(childS * 100) / 100.0;
		employeeS = Math.round(employeeS * 100) / 100.0;
		movieP = Math.round(movieP * 100) / 100.0;
		String a = String.valueOf(adultS);
		if(adultS == 0)
			a = "0.00";
		String c = String.valueOf(childS);
		if(childS == 0)
			c = "0.00";
		String e = String.valueOf(employeeS);
		if(employeeS == 0)
			e = "0.00";
		String m = String.valueOf(movieP);
		if(movieP == 0)
			m = "0.00";
		String report = 
				"\tMonthly Sales Report\n\n"
				+"\t\tSales\tNumber\n"
				+"ADULT\t\t$" +a+ "\t" +ad+ "\n"
				+"CHILD\t\t$" +c+ "\t" +ch+ "\n"
				+"EMPLOYEE\t$" +e+ "\t" +emp+ "\n"
				+"MOVIEPASS\t$" +m+ "\t" +mp+ "\n"
				+"\nTotal Monthly Sales: $" + totalSalesMonth();
		return report;
	}

	public int numMoviesToday(int id, int date) { // Number of movies watch per day
		int times = 0;
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getId() == id && ticketList.get(i).getDay() == date)
				times++;
		}
		return times;
	}

	public int numThisMovie(int id, String movie) { // Number of times a specific movie has been watched
		int thisMovie = 0;
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getId() == id && ticketList.get(i).getName().equals(movie))
				thisMovie++;
		}
		return thisMovie;
	}

	public int numVisits(int id) { // Number of total movies watched/visits to theater
		int visits = 0;
		for (int i = 0; i < ticketList.size(); i++) {
			if (ticketList.get(i).getId() == id)
				visits++;
		}
		return visits;
	}

	public void readFile(File file) throws FileNotFoundException {
		// Fields for each element of each ticket to be read
		int day, time, id;

		// Scanner object for file
		Scanner read = new Scanner(file);

		// ArrayList of Strings, holds each line of file
		ArrayList<String> lines = new ArrayList<String>();
		while (read.hasNextLine()) {
			lines.add(read.nextLine());
		}

		// lines is split up into individual 'items', parsed, and assigned to
		// appropriate fields
		String[] tempA = null;
		for (int i = 0; i < lines.size(); i++) {
			tempA = lines.get(i).split(":");
			day = Integer.parseInt(tempA[2]);
			time = Integer.parseInt(tempA[3]);
			id = Integer.parseInt(tempA[6]);
			addTicket(tempA[0], tempA[1], day, time, tempA[4], tempA[5], id);
		}
//		Book Club:PG13:1:13:IMAX:Employee:45678
//		movieN	 : r  : d:t: f :   type  : id ;
		read.close();
	}

	private void sortByDay() {
		Ticket temp;
		for (int i = 1; i < ticketList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (ticketList.get(j).getDay() < ticketList.get(j - 1).getDay()) {
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j - 1));
					ticketList.set(j - 1, temp);
				}
			}
		}
	}

	private void sortById() {
		Ticket temp;
		for (int i = 1; i < ticketList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (ticketList.get(j).getId() < ticketList.get(j - 1).getId()) {
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j - 1));
					ticketList.set(j - 1, temp);
				}
			}
		}
	}
//	El Fin
}