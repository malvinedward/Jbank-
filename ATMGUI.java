import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class ATMGUI here.
 * 
 * @author : Malvin Edward
 * @version : 04/10/2016
 */
public class ATMGUI extends JPanel
{
    private JLabel custIdLabel;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JTextField customerIdTextField;
    private CheckboxGroup chkgroup;
    protected Checkbox savings;
    protected Checkbox investment;
    protected Checkbox lineOfCredit;
    protected Checkbox overDraft;
    private JButton deposit;
    private JButton withdraw;
    private JButton exit;
    private JTextArea display;
    private JPanel infoPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel checkBoxPanel;
    private Teller teller;
    private String custId, amount;
    protected ButtonHandler btnHan;

    /**
     * Constructor for objects of class ATMGUI
     */
    public ATMGUI()
    {
        btnHan = new ButtonHandler(this);
        buildGUI();
    }
    
    public void buildGUI(){
        custIdLabel = new JLabel("Enter customer id");
        amountLabel = new JLabel("Enter amount here: ");
        amountTextField = new JTextField("", 10);
        customerIdTextField = new JTextField("1000", 10);
        chkgroup = new CheckboxGroup();
        savings = new Checkbox("Savings", chkgroup, true);
        investment = new Checkbox("Investment", chkgroup, false);
        lineOfCredit = new Checkbox("Line Of Credit", chkgroup, false);
        overDraft = new Checkbox("Overdraft", chkgroup, false);
        deposit = new JButton("Deposit");
        deposit.addActionListener(btnHan);
        withdraw = new JButton("Withdraw");
        withdraw.addActionListener(btnHan);
        exit = new JButton("Exit");
        exit.addActionListener(btnHan);
        display = new JTextArea("Welcome", 10, 42);
        /* Creating amount panel */
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.add(custIdLabel);
        infoPanel.add(customerIdTextField);
        /* Creating checkbox panel */
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
        checkBoxPanel.add(savings);
        checkBoxPanel.add(investment);
        checkBoxPanel.add(lineOfCredit);
        checkBoxPanel.add(overDraft);
        infoPanel.add(checkBoxPanel);
        infoPanel.add(amountLabel);
        infoPanel.add(amountTextField); 
        /* Creating text panel */
        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        textPanel.add(display);
        /* Creating Button Panel */
        buttonPanel = new JPanel();
        GridLayout layout = new GridLayout(3,1);
        layout.setHgap(0);
        layout.setVgap(0);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(layout);
        buttonPanel.add(deposit);
        buttonPanel.add(withdraw);
        buttonPanel.add(exit);
        textPanel.add(buttonPanel);
        setLayout(new BorderLayout());
        add(infoPanel, "North");
        add(textPanel, "South");
    }
    
    /**Main Function 
     * 
     */
    
    public static void main(String[] args){
        ATMGUI ATMView = new ATMGUI();
        Frame frame = new Frame("ATMGUI");
        frame.add(ATMView);
        frame.pack();
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                
                System.exit(0);
            }        
        }
        );
        frame.setVisible(true);
    }
    
    /**
     * 
     */
    public JButton getDepositButton(){
        return deposit;
    }
    
    /**
     * 
     */
    public JButton getWithdrawButton(){
        return withdraw;
    }
    
    /**
     * 
     */
    public JButton getExitButton(){
        return exit;
    }
    
    public JTextArea getDisplay(){
        return display;
    }
    
    public String getCustId(){
        return customerIdTextField.getText();
    }
    
    public String getAmount(){
        return amountTextField.getText();
    }
    
    public void actionPerformed(ActionEvent e){
    }
}
