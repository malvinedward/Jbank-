import java.text.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
/**
 * Teller Class
 * 
 * @author : Malvin Edward
 * @version : 03/26/2016
 */
public class Teller
{    
    private static Date dateOfBirth;
    private static MathContext mc = new MathContext(3);
    private ATMGUI atmgui;
    private Frame frame;
    private ButtonHandler controller;
    private Customer customer;
    private SortedSet<Customer> customers = new TreeSet<Customer>();
    private CustomerFileReader cfr;
    private CustomerFileWriter cfw;
    
    
    /**
     * Main Function
     * 
     */
    public static void main (String[] args){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Teller teller = new Teller();
        try{
            teller.createNewCustomer("Malvin", "Edward", formatter.parse("10/12/1995"));
            teller.createNewCustomer("Pepi","Edward", formatter.parse("01/17/1998"));
        }
        catch(ParseException e){
            System.out.println("Exception :" + e.getMessage());
        }
        teller.cfw.saveCustomer(teller.customers);
        try{
            SortedSet<Customer> c = teller.cfr.readCustomers();
            System.out.println(c);
            System.out.println(teller.getCustomer(1001));
            System.out.println(teller.getCustomer2(c,1000));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Method constructor Teller
     */
    public Teller(){
        cfw = new CustomerFileWriter();
        cfr = new CustomerFileReader();
       }
       
    /**
     * Method create customer from teller class
     * @param fname the name of customer
     * @param lname last name of customer
     * @param dob consists their born date
     */
    public void createNewCustomer(String fname, String lname, Date dob){
        customer = new Customer(fname, lname, dob);
        customers.add(customer);
    }
    
    /**
     * Method getCustomer untuk iterasi sorted set
     * @param custId
     */
    public Customer getCustomer(int custId) throws CustomerNotFoundException{
        Customer c = null;
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            c = it.next();
            if(c.getCustID() == custId){
                break;
            }
        }
        return c;
    }
    
    /**
     * Method getCustomer2 untuk iterasi sorted set
     */
    public Customer getCustomer2(SortedSet<Customer> a, int id){
        Customer c = null;
        Iterator<Customer> it = a.iterator();
        while(it.hasNext()){
            c = it.next();
            if(c.getCustID() == id){
                break;
            }
        }
        return c;
    }

}
