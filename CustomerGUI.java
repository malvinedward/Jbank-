import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * GUI for Customer
 * 
 * @author Malvin Edward
 * @version 28/04/2016
 */
public class CustomerGUI extends JFrame
{
    private JButton cancelBtn;
    private JButton saveBtn;
    private JTextField idField;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField dobField;
    private JComboBox<String> accountList;
    
    /**
     * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI()
    {
        cancelBtn = new JButton();
        saveBtn = new JButton();
        
        idField = new JTextField();
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        addressField = new JTextField();
        cityField = new JTextField();
        stateField = new JTextField();
        zipField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        dobField = new JTextField();
        
        String[] acctList = 
        {
            "Checking/OverDraft",
            "Line Of Credit",
            "Savings",
            "Investment",
            "Other"
        };
        
        accountList = new JComboBox<>(acctList);
        
        buildGUI();
    }
    
    public void buildGUI()
    {
        this.setTitle("Customer Input & Update");
        this.setSize(600,300);
        this.setResizable(false);
        
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(600,300));
        pane.setBackground(new Color(192,192,192));
        
        cancelBtn.setPreferredSize(new Dimension(100,35));
        cancelBtn.setBackground(new Color(214,217,223));
        cancelBtn.setForeground(new Color(0,0,0));
        cancelBtn.setEnabled(true);
        cancelBtn.setFont(new Font("sansserif",0,12));
        cancelBtn.setText("Cancel");
        cancelBtn.setVisible(true);
        cancelBtn.setActionCommand("cancel");
        
        saveBtn.setPreferredSize(new Dimension(150,35));
        saveBtn.setBackground(new Color(214,217,223));
        saveBtn.setForeground(new Color(0,0,0));
        saveBtn.setEnabled(true);
        saveBtn.setFont(new Font("sansserif",0,12));
        saveBtn.setText("Save & Return");
        saveBtn.setVisible(true);
        saveBtn.setActionCommand("save");
        
        idField.setPreferredSize(new Dimension(100,35));
        idField.setBackground(new Color(255,255,255));
        idField.setForeground(new Color(0,0,0));
        idField.setEnabled(true);
        idField.setFont(new Font("sansserif",0,12));
        idField.setText("1000");
        idField.setVisible(true);
        
        lastNameField.setPreferredSize(new Dimension(200,35));
        lastNameField.setBackground(new Color(255,255,255));
        lastNameField.setForeground(new Color(0,0,0));
        lastNameField.setEnabled(true);
        lastNameField.setFont(new Font("sansserif",0,12));
        lastNameField.setText("Last Name");
        lastNameField.setVisible(true);
        
        firstNameField.setPreferredSize(new Dimension(200,35));
        firstNameField.setBackground(new Color(255,255,255));
        firstNameField.setForeground(new Color(0,0,0));
        firstNameField.setEnabled(true);
        firstNameField.setFont(new Font("sansserif",0,12));
        firstNameField.setText("First Name");
        firstNameField.setVisible(true);
        
        addressField.setPreferredSize(new Dimension(360,35));
        addressField.setBackground(new Color(255,255,255));
        addressField.setForeground(new Color(0,0,0));
        addressField.setEnabled(true);
        addressField.setFont(new Font("sansserif",0,12));
        addressField.setText("Address");
        addressField.setVisible(true);
        
        cityField.setPreferredSize(new Dimension(200,35));
        cityField.setBackground(new Color(255,255,255));
        cityField.setForeground(new Color(0,0,0));
        cityField.setEnabled(true);
        cityField.setFont(new Font("sansserif",0,12));
        cityField.setText("City");
        cityField.setVisible(true);
        
        stateField.setPreferredSize(new Dimension(100,35));
        stateField.setBackground(new Color(255,255,255));
        stateField.setForeground(new Color(0,0,0));
        stateField.setEnabled(true);
        stateField.setFont(new Font("sansserif",0,12));
        stateField.setText("State");
        stateField.setVisible(true);
        
        zipField.setPreferredSize(new Dimension(100,35));
        zipField.setBackground(new Color(255,255,255));
        zipField.setForeground(new Color(0,0,0));
        zipField.setEnabled(true);
        zipField.setFont(new Font("sansserif",0,12));
        zipField.setText("Zip Code");
        zipField.setVisible(true);
        
        phoneField.setPreferredSize(new Dimension(150,35));
        phoneField.setBackground(new Color(255,255,255));
        phoneField.setForeground(new Color(0,0,0));
        phoneField.setEnabled(true);
        phoneField.setFont(new Font("sansserif",0,12));
        phoneField.setText("Phone");
        phoneField.setVisible(true);
        
        emailField.setPreferredSize(new Dimension(200,35));
        emailField.setBackground(new Color(255,255,255));
        emailField.setForeground(new Color(0,0,0));
        emailField.setEnabled(true);
        emailField.setFont(new Font("sansserif",0,12));
        emailField.setText("Email");
        emailField.setVisible(true);
        
        dobField.setPreferredSize(new Dimension(100,35));
        dobField.setBackground(new Color(255,255,255));
        dobField.setForeground(new Color(0,0,0));
        dobField.setEnabled(true);
        dobField.setFont(new Font("sansserif",0,12));
        dobField.setText("DOB");
        dobField.setVisible(true);
        
        accountList.setPreferredSize(new Dimension(255,35));
        accountList.setBackground(new Color(255,255,255));
        accountList.setForeground(new Color(0,0,0));
        accountList.setEnabled(true);
        accountList.setFont(new Font("sansserif",0,12));
        accountList.setVisible(true);
        
        pane.add(cancelBtn);
        pane.add(saveBtn);
        pane.add(idField);
        pane.add(lastNameField);
        pane.add(firstNameField);
        pane.add(addressField);
        pane.add(cityField);
        pane.add(stateField);
        pane.add(zipField);
        pane.add(phoneField);
        pane.add(emailField);
        pane.add(dobField);
        pane.add(accountList);
        
        this.add(pane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    public int getID()
    {
        return Integer.parseInt(idField.getText());
    }
    
    public String getLastName()
    {
        return lastNameField.getText();
    }
    
    public String getFirstName()
    {
        return firstNameField.getText();
    }
    
    public String getAddress()
    {
        return addressField.getText();
    }
    
    public String getCity()
    {
        return cityField.getText();
    }
    
    public String getStateAddress()
    {
        return stateField.getText();
    }
    
    public String getZipCode()
    {
        return zipField.getText();
    }
    
    public String getPhone()
    {
        return phoneField.getText();
    }
    
    public String getEmail()
    {
        return emailField.getText();
    }
    
    public String getDOB()
    {
        return dobField.getText();
    }
    
    public String getAcctType()
    {
        return accountList.getSelectedItem().toString();
    }
    
    public static void main(String[] args)
    {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerGUI();
            }
        });
    }
}
