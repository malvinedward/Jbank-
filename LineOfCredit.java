    import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Write a description of class LineOfCredit here.
 * 
 * @author : Malvin Edward
 * @version : 03/26/2016
 */
public class LineOfCredit extends Checking
{
    private double creditBalance, creditLimit;  

    /**
     * Constructor for objects of class LineOfCredit
     */
    public LineOfCredit(Customer customer, double amount, double limit)
    {
        super();
        id = Integer.toString(customer.getCustID());
        setBalance(amount);
        creditBalance = limit;
        creditLimit = limit;
    }
    
    /**
     * 
     */
    public double getCreditBalance(){
        return creditBalance;
    }
    
    /**
     * 
     */
    public double getCreditLimit(){
        return creditLimit;
    }
    
    /**
     * 
     */
    public void setCreditBalance(double amount){
        creditBalance = amount;
    }
    
    /**
     * 
     */
    public void setCreditLimit(double amount){
        creditLimit = amount;
    }
    
    /**
     * 
     */
    public void feeAssessment(){
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance;
        double period = (double)days/365; 
        System.out.println(period);
        double amt = Math.pow(deficit * (1 + .21 / 365), (365*period));
        monthlyFee = amt - deficit;
        System.out.println(monthlyFee);
    }
    
    /**
     * 
     */
    public void withdraw (double amount) throws AmountOverDrawnException{
        if(amount > balance + creditBalance){
            throw new AmountOverDrawnException(this);
            /*try{
                throw new AmountOverDrawnException(this);
            }
            catch(AmountOverDrawnException e){
                System.out.println(e.getMessage());
            }*/
        }
        else if (amount > balance){
            creditBalance -= (amount - balance);
            balance = 0;
        }
        else{
            balance = balance - amount;
        }
    }
}
