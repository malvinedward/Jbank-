import java.util.*;
/**
 * Write a description of class Investment here.
 * 
 * @author : Malvin Edward 
 * @version : 03/26/2016
 */
public final class Investment extends Savings
{
   private Date startDate, endDate;
   private int term;
   private double interestRate;
    /**
     * Constructor for objects of class Investment
     */
   public Investment(Customer customer, double amount, int term)
   {
        super(customer, amount);
        setBalance(amount);
        this.term = term;
        int localTerm;
        Calendar calendar = new GregorianCalendar();
        startDate = calendar.getTime();
        if (term < 6) {
            localTerm = 6;
        } else {
            localTerm = term;
        }
        calendar.add(Calendar.MONTH, localTerm);
        endDate = calendar.getTime();
        if (term <= 6) {
            interestRate = 0.05;
        } else if (term > 6 && term <=12) {
            interestRate = 0.06;
        } else {
            interestRate = 0.07;
        }
   }
   
   /**
    * 
    */    
   public void addDailyInterest(double days) {
        double value, period;
        period = days / 365;
        value = futureBalance(balance, interestRate, 360, period);
        interestEarned = value - balance;
        balance = value;
    }
   
   /**
    * 
    */
   public void withdraw(double amount) throws AmountOverDrawnException {  
       if (balance - amount >= 100) {
           if (Calendar.getInstance().before(endDate)) {
               if ( (balance * 0.8) - amount >= 100 ) {
                   balance *= 0.8;
                   balance -= amount;
               } else {
               }
           } else {
           }
       } else {
           throw new AmountOverDrawnException(this);
           
       }
   } 
}
