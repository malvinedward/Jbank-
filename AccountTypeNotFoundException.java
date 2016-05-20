
/**
 * Write a description of class AccountTypeNotFoundException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountTypeNotFoundException extends Exception
{
    private char acctType;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char c)
    {
        super("account does not exist");
        acctType = c;
    }
    
    public String getMessage(){
        switch(acctType){
            case 'S':
            return "Savings " + super.getMessage();
            case 'I':
            return "Investment " + super.getMessage();
            case 'L':
            return "Line of Credit " + super.getMessage();
            case 'O':
            return "Overdraft Protection " + super.getMessage();
        }
        return null;
    }
}
