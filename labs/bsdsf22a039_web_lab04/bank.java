import java.util.*;

class InsufficientFundsException extends Exception
{
	private double withdrawalamount;
	private double availablebalance;

	public InsufficientFundsException (double wa, double ab){
        withdrawalamount = wa;   
        availablebalance = ab;
    }

	public String toString(){
	    return "Withdrawel amount "+withdrawalamount+ " is greater than available balance"+availablebalance;
    }
}

class BankAccount{
    private String accountNumber;
    private double balance;

    public BankAccount(String an, double b){
        accountNumber = an;
        balance = b;
    }

    public void deposit(double amount){
        if (amount>0.0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        } 
        else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount > balance){
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Available Balance: " + (balance));
    }
}

public class bank {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        BankAccount account = new BankAccount("123456", 500.0);
        
        System.out.print("Enter amount to withdraw: ");
        double amount = obj.nextDouble();
        
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful");
        } 
        catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.toString());
        } 
        finally {
            System.out.println("Transaction complete.");
        }
        
    }
}
