import java.util.*;
import java.io.*;

import java.io.Serializable;
/**
 * Write a description of class CustomerFileWriter here.
 * 
 * @author (Malvin Edward) 
 * @version (Tanggal sekian)
 */
public class CustomerFileWriter implements Serializable
{
    private File objectFile;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    /**
     * Constructor class CustomerFileWriter
     */
    public CustomerFileWriter() 
    {
       File c = new File("tes.dat");
       try{
           c.createNewFile();
           fileOutputStream = new FileOutputStream("tes.dat");
           objectOutputStream = new ObjectOutputStream(fileOutputStream);
           objectOutputStream.close();
       }
       catch(Exception e){
           System.out.println("CFWCException :" + e.getMessage());
       }
    }
    
    /**
     * Method saveCustomer for saving the Sorted Set into customers.dat file
     * @param c with SortedSet<Customer> type to be written
     */
    public void saveCustomer(SortedSet<Customer> c){
        System.out.println(c);
        try{
            fileOutputStream = new FileOutputStream("tes.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(c);
            objectOutputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
