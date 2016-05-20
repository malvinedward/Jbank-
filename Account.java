import java.math.*;
import java.lang.*;
/**
 * Account Class beserta beberapa methodnya.
 * 
 * @author : Malvin Edward
 * @version : 03/26a/2016
 */

public abstract class Account
{
    protected double balance;
    protected String id;
    
    /**
     * Method overriding toString function
     * @param ID akun
     */
    public String toString(int ID){
        return String.format(ID + "");
    }
    
    /**
     * Method deposit untuk tambah uang ke akun
     * @param amount tipe data double
     */
    public boolean deposit(double amount) {
        if (amount < 0){
            return false;
        }
        else {
            balance += amount;
            return true;
        }
    }
    
    
    /**
     * Method untuk mengambil balance akun
     * @return balance akun
     */     
    public double getBalance() {
        return balance;
    }

    /**
     * Method untuk mengambil ID akun
     * @return ID akun
     */    
    public String getId() {
        return id;
    }

    /**
     * Method untuk memasukkan balance ke akun
     * @param amount tipe data double
     */     
    public void setBalance(double amount) {
        balance = amount; // assigns the balance of account
    }

    
    /**
     * Method withdraw untuk ambil uang dari akun
     * @param amount tipe data double
     */ 
    public abstract void withdraw(double amount) throws AmountOverDrawnException;
    
    /**
     * 
     */
    protected static double futureBalance(double balance, double rate, double compound, double period) {
        MathContext mc = new MathContext(3);
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
}