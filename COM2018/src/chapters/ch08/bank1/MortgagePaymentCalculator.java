package chapters.ch08.bank1;

public class MortgagePaymentCalculator {
	
	private BankAccountSpecification bankAccount;
	
	/** Constructor
	 * @param account - 사용 계좌 */
	public MortgagePaymentCalculator(BankAccountSpecification account) {
		bankAccount = account;
	}
	
	/** */
	public void makeMortgagePayment(int amount) {
		if (bankAccount.withdraw(amount))
			System.out.println(amount + "원 지불");
		else
			System.out.println("잔고 부족");
	}
}

