
/**
 * Write a description of class CustomerNotFoundException here.
 * 
 * @author Malvin Edward
 * @version 04/27/2016
 */
public class CustomerNotFoundException extends Exception
{
    /**
     * Constructor for objects of class CustomerNotFoundException
     */
    public CustomerNotFoundException(int id)
    {
        super("Customer ID" + id + "Not Found");
    }
}
