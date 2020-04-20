
public class CheckingAccount extends BankAccount {
//	Field(s)
	private static double FEE = 0.15;
//	Constructo(s)
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		setAccountNumber(getAccountNumber() + "–10");
	}
//	Method(s)
	@Override
	public boolean withdraw(double amount) {
		return super.withdraw(amount+FEE);
	}
	
}
