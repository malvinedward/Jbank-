import java.io.*;
import java.util.*;
import java.io.Serializable;
/**
 * Write a description of class CustomerFileReader here.
 * 
 * @author Malvin Edward
 * @version 04/21/2016
 */
public class CustomerFileReader implements Serializable
{
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private File objectFile;
    /**
     * Constructor 
     */
    public CustomerFileReader()
    {
       File c = new File("tes.dat");
       try{
           fileInputStream = new FileInputStream("tes.dat");
           objectInputStream = new ObjectInputStream(fileInputStream);
       }
       catch(Exception e){
           System.out.println("CFWRCxception :" + e.getMessage());
       }    
    }
    
    /**
     * Method readCustomer untuk read file
     */
    public SortedSet<Customer> readCustomers() throws IOException{
        byte[] read;
        SortedSet<Customer> customers = new TreeSet<Customer>();
        try{
            fileInputStream = new FileInputStream("tes.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (SortedSet<Customer>)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (Exception e){
            System.out.println("CFRException :" + e.getMessage());
        }
        return customers;
                
    }
}
