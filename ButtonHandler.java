    import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class ButtonHandler here.
 * 
 * @author : Malvin Edward
 * @version : 04/10/2016
 */
public class ButtonHandler implements ActionListener
{
    ATMGUI atmgui;
    Teller teller;
    Customer c, cust;
    Savings s;
    LineOfCredit l;
    OverDraftProtection o;
    Investment i;
    /**
     * Constructor for objects of class ATMController
     */
    public ButtonHandler(ATMGUI atmgui){
        this.atmgui = atmgui;
        cust = new Customer();
        cust.setName("Malvin", "d");
        Savings saving = new Savings(cust, 1000);
        Investment invest = new Investment(cust, 1500, 12);
        LineOfCredit loc = new LineOfCredit(cust, 2000, 1000);
        OverDraftProtection odp = new OverDraftProtection(cust, 3000, saving);
        try{
            cust.addAccount(saving);
            cust.addAccount(invest);
            cust.addAccount(loc);
            cust.addAccount(odp);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    public void actionPerformed(ActionEvent e){
       
       if(e.getActionCommand().equals("Deposit")){
           atmgui.getDisplay().setText(atmgui.getCustId() + " saves an amount of money: Rp " + atmgui.getAmount());
           try{
               if(atmgui.savings.getState()){
                   s = new Savings(c,Double.parseDouble(atmgui.getAmount()));
                   c.addAccount(s);
                   atmgui.getDisplay().append("\nSaving account created successfuly.");
                }
               else if(atmgui.investment.getState()){
                   i = new Investment(c,Double.parseDouble(atmgui.getAmount()),12);
                   c.addAccount(i);
                   atmgui.getDisplay().append("\nInvestment account created successfuly.");
                }
               else if(atmgui.lineOfCredit.getState()){
                   l = new LineOfCredit(c, Double.parseDouble(atmgui.getAmount()), 1000);
                   c.addAccount(l);
                   atmgui.getDisplay().append("\nLine of credit account created successfuly.");
                }
               else if(atmgui.overDraft.getState()){
                   o = new OverDraftProtection(c, Double.parseDouble(atmgui.getAmount()), s);
                   c.addAccount(o);
                   atmgui.getDisplay().append("\nOver Draft account created successfuly.");
                }
            }
            
            catch(AccountTypeAlreadyExistsException a){
                atmgui.getDisplay().append("\nAccountTypeAlreadyExistsException : " + a.getMessage());
            }
            catch(AccountTypeNotFoundException b){
                atmgui.getDisplay().append("\nAccountTypeNotFoundException : " + b.getMessage());
            }
       }
       else if(e.getActionCommand().equals("Withdraw")){
           atmgui.getDisplay().setText(atmgui.getCustId() + " withdraws an amount of money: Rp " + atmgui.getAmount()
           + "\n" ); 
           try{
               s.withdraw(Double.parseDouble(atmgui.getAmount()));
            }
            catch(AmountOverDrawnException c){
                atmgui.getDisplay().append("\nAmountOverDrawnException : " + c.getMessage());
            }
       }
       else if(e.getActionCommand().equals("Exit")){
           displayMessage("You are exitting, goodbye!");
           System.exit(0);
       }
             
    }
    
    /**
     * 
     */
    public void errorHandler(){
        
    }
  
    /**
     * 
     */
    public static void displayMessage(String message){
        Frame frame = new Frame("Dialog");
        JOptionPane.showMessageDialog(frame,message);   
    }
}
