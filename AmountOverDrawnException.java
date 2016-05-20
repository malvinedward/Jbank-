
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @author (Malvin Edward) 
 * @version (20/5/2016)
 */
public class AmountOverDrawnException extends Exception
{
    private Account acctType;

    /**
     * Constructor AmountOverDrawnException
     */
    public AmountOverDrawnException(Account c)
    {
        super("Insufficient funds");
        acctType = c;
    }

    /**
     * get message
     */
    public String getMessage(){
        if(acctType instanceof Investment){
            return super.getMessage() + " in Investment Account";
        }
        else if(acctType instanceof Savings){
            return super.getMessage() + " in Savings Account";
        }
        else if(acctType instanceof LineOfCredit){
            return super.getMessage() + " in Line-Of-Credit Account";
        }
        else if(acctType instanceof OverDraftProtection){
            return super.getMessage() + " in Overdraft Protect Account";
        }
        else{
            return "none";
        }
    }
}
