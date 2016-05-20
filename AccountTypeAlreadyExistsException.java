
/**
 * Write a description of class AccountTypeAlreadyExistsException here.
 * 
 * @author (Malvin Edward) 
 * @version (20/5/2016)
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    private char acctType;

    /**
     * Constructor AccountTypeAlreadyExistsException
     */
    public AccountTypeAlreadyExistsException(char c)
    {
        super("Unable to create duplicate account of type");
        acctType = c;
    }

    /**
     * Untuk meng getmessage
     */
    public String getMessage(){
        switch(acctType){
            case 'S':
            return super.getMessage() + " savings";
            case 'I':
            return super.getMessage() + " Investment";
            case 'L':
            return super.getMessage() + " Line of Credit";
            case 'O':
            return super.getMessage() + " Overdraft Protection";
        }
        return null;
    }
}
