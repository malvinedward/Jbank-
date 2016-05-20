
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author : Malvin Edward
 * @version : 04/16/2016
 */
public class OverDraftProtection extends Checking
{
    private Savings savingsAccount;

    /**
     * Constructor OverDraftProtection
     */
    public OverDraftProtection(Customer customer, double amount, Savings saving)
    {
        super();
        id = Integer.toString(customer.getCustID());
        setBalance(amount); 
        savingsAccount = saving;
    }
    
    /**
     * untuk fee assesment
     */
    public void feeAssessment(){
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
     * exception amount overdrawn
     */
    public void withdraw(double amount) throws AmountOverDrawnException{
        if(amount > balance + savingsAccount.getBalance() - 10){
            throw new AmountOverDrawnException(this);
            
        }
        else if(amount > balance){
            savingsAccount.withdraw(amount - balance);
            balance = 0;
            feeAssessment();
        }
        else{
            balance = balance - amount;
            feeAssessment();
        }
    }
}
