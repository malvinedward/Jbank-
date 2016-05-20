import java.util.*;
import java.text.*;
/**
 * Bank Class besereta method - method nya.
 * 
 * @author : Malvin Edward
 * @version : 03/26/2016
 */
public class Bank
{
    private static double creditInterestRate, investmentInterestRate,premiumInterestRate;
    private static int lastCustID, nextCustID, numOfCurrentCustomer, nextID;
    public static final int MAX_NUM_OF_CUSTOMERS = 4;
    private static String phone;
    private static Date startTime, closeTime;
    private static String website;
    public static final String BANK_NAME = "JBANK";
    public static final String BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    
    private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS];

    
    /**
     * Method constructor bank tanpa argumen
     */
    public Bank() {
    }

    /**
     * Method addCustomer menambahkan object ke array customers
     * @param customer object dari class customer
     * @return boolean
     */
        public static boolean addCustomer (Customer customer) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i] == null) {
                Customers[i] = customer;
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Method getCustomer untuk mengembalikan referensi ke object customer
     * @param custID object
     * @return object customer / null
     */
    public static Customer getCustomer (int custID) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i].getCustID() == custID) {
                return Customers[i];
            } 
        }
        return null;
    }
    
    /**
     * Method getMaxNumberOfCustomers untuk mengembalikan nilai max number dari customernya
     * @return max number of customer
     */
    public static int getMaxNumberOfCustomers() {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * Method untuk mengambil suku bunga tabungan
     * @return ratio bunga credit
     */     
    public static double getCreditRate() {
        return creditInterestRate;
    }
    
    /**
     * Method untuk mengambil suku bunga deposito
     * @return ratio bunga investasi
     */ 
    public static double getInvestmentRate() {
        return investmentInterestRate;
    }
 
    /**
     * Method untuk mengambil lama operasi
     * @return jam buka bank tersebut
     */  
    public static String getHoursOfOperation() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(startTime) + " TO " + sdf.format(closeTime);
    }
    
    /**
     * Method untuk mengambil last ID dari akun
     * @return 0
     */     
    public static int getLastID() {
        return 0;
    }
    
    /**
     * Method untuk mengambil akun keberapa sekarang
     * @return akun keberapa
     */ 
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomer;
    }

    /**
     * Method untuk mendapatkan ID berikutnya
     * @return nextCustID as lokal2
     * Variable lokal1 untuk lastID, lokal2 untuk nextID
     */     
    public static int getNextID() {
        int lokal = 0;
        if (nextCustID == 0){
            lastCustID = 1000;
            lokal = 1000;
            numOfCurrentCustomer++;
            nextCustID = lokal;
            return lokal;
        }
        else{
            
            if (numOfCurrentCustomer == MAX_NUM_OF_CUSTOMERS){
                lokal = 0;
                nextCustID = lokal;
                return lokal;
            }
            lastCustID = nextCustID;
            lokal = lastCustID + 1;
            numOfCurrentCustomer++;
            nextCustID = lokal;
            return lokal;
        }
    }
    
    /**
     * Method untuk mengambil url website
     * @return website
     */ 
    public static String getWebsite() {
        return website;
    }
    
    /**
     * Method untuk mengambil suku bunga premium
     * @return ratio bunga premi
     */ 
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    /**
     * Method untuk mengambil telphone number 
     * @return phone 
     */ 
    public static String getPhone() {
        return phone;
    }
    
    /**
     * Method untuk set suku bunga akun
     * @return credit rate
     */ 
    public static void setCreditRate(double rate) {
    }
    
    /**
     * Method untuk set suku bunga investasi
     * @param double rate
     */ 
    public static void setInvestmentRate(double rate) {
    }
    
    /**
     * Method untuk set suku bunga premium
     * @return
     */ 
    public static void setPremium(double rate) {
    }
    
    /**
     * Method mutator untuk set startTime
     * @param hour untuk jam yang ingin di set
     * @param minute untuk menit yang ingin di set
     */
    public static void setStartTime(int hour, int minute){
        startTime = new GregorianCalendar(0,0,0,hour,minute).getTime();
    }
    
    /**
     * Method mutator untuk set closeTime
     * @param hour untuk jam yang ingin di set
     * @param minute untuk menit yang ingin di set
     */
    public static void setCloseTime(int hour, int minute){
        closeTime = new GregorianCalendar(0,0,0,hour,minute).getTime();
    }
    
    public void printCustomers() {
        for (Customer c : Customers) {
            if (c != null){
                System.out.println(c);
            }
        }
    }

}