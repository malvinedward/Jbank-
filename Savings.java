/**
 * Write a description of class Savings here.
 * 
 * @author : Malvin Edward
 * @version : 04/16/2016
 */
public class Savings extends Account
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer customer, double amount)
    {
        super();
        setBalance(amount);
        id = Integer.toString(customer.getCustID());
    }

    /**
     * @param amount
     */
    public void withdraw (double amount) throws AmountOverDrawnException{
        if (balance - amount >= 10) {
            balance -= amount;
        } else {
            throw new AmountOverDrawnException(this);
            
        }
    }
    
    /**
     * 
     */
    public void addDailyInterest(int days){
        double value, period, f;
        period = (double)days / 365;
        value = futureBalance(balance, 0.03, 360, period);
        interestEarned = value - balance;
        balance += interestEarned;
    }
    
    /**
     * 
     */
    public double getInterestEarned(){
        return interestEarned;
    }
    
    /**
     * 
     */
    public double getBalance(){
        return balance;
    }
}
