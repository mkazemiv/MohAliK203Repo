public class SavingsAccount extends BankAccount {
//	Field(s)
	private double rate = 0.025;
	private int savingsNumber = 0;
	String accountNumber;
//	Constructor(s)
	public SavingsAccount(String name, double balance) {
		super(name, balance);
		accountNumber = super.getAccountNumber() +"–"+ savingsNumber;
	}
	public SavingsAccount(SavingsAccount Account, double amount) {
		super(Account, amount);
		savingsNumber = Account.savingsNumber+1;
		accountNumber = super.getAccountNumber() +"–"+ savingsNumber;
	}
//	Method(s)
	public void postInterest() {
		super.deposit(getBalance()*(rate/12));
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
