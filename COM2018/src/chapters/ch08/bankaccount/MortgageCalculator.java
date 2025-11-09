package chapters.ch08.bankaccount;

public class MortgageCalculator {
	
	BankAccountSpecification bankAccount;
	
	public MortgageCalculator(BankAccountSpecification b) {
		bankAccount = b;
	}
	
	public void makeMortgagePayment(int amount) {
		if (bankAccount.withdraw(amount))
			System.out.println(amount + "원 지불 완료");
		else
			System.out.println("잔고 부족");
	}

}
