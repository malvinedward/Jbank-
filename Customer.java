import java.util.regex.*;
import java.util.Date;
import java.text.*;
import java.io.Serializable;
/**
 * Customer Class dengan method - method nya.
 * 
 * @author : Malvin Edward 
 * @version : 03/26/2016
 */
public class Customer implements Serializable, Comparable<Customer>
{
    private String cityAddress,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode;
    private int custId,numberOfCurrentAccounts;
    private Date dateOfBirth;
    private Account a;
    private Account[] accounts = new Account[4];
    private Pattern p;
    private Matcher m;
    private static final String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    
    
    /**
     * 
     */
    public Customer(){
        custId = Bank.getNextID();
    }
    
    /**
     * Method constructor dengan beberapa parameter lebih banyak
     * @param fname nama depan
     * @param lname nama belakang
     * @param dob tanggal lahir
     */ 
    public Customer(String firstName, String lastName, Date dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        custId = Bank.getNextID();
    }
    
    /**
     * Method untuk mendapatkan address customer
     * @return address lengkap 
     */ 
    public String getAddress() {
        return streetAddress + " " + cityAddress + " " + zipOrPostalCode;
    }
    
    /**
     * Method untuk mendapatkan akun customer
     * @return accounts
     */ 
    public Account getAccount(char type) throws AccountTypeNotFoundException{
        Account acc = null;
        Boolean prog = true;
        for (Account a: accounts ) {
            while(prog){
                switch (type) {
                    case 'S':
                    if(a instanceof Savings) {
                        acc = a;
                        prog = false;
                    }
                    else{
                        prog = false;
                        throw new AccountTypeNotFoundException('S');
                    }
                    break;
                    case 'L':
                    if(a instanceof LineOfCredit) {
                        acc = a;
                        prog = false;
                    }
                    else
                    {
                        prog = false;
                        throw new AccountTypeNotFoundException('L');
                    }
                    break;
                    case 'O': 
                    if(a instanceof OverDraftProtection) {
                        acc = a;
                        prog = false;
                    }
                    else
                    {
                        prog = false;
                        throw new AccountTypeNotFoundException('O');
                    }
                    break;
                    case 'I':
                    if(a instanceof Investment) {
                        acc = a;
                        prog = false;
                    }
                    else
                    {
                        prog = false;
                        throw new AccountTypeNotFoundException('I');
                    }
                }   
            }
        }
        return acc;
    }
    
    /**
     * Method untuk mendapatkan email customer
     * @return email
     */ 
    private String getEmail() {
        return email;
    }
    
    /**
     * Method untuk mendapatkan nama customer
     * @return nama lengkap customer
     */ 
    public String getCustomerName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Method untuk mendapatkan jumlah akun
     * @return jumlah punya seorang customer
     */ 
    public int getNumOfAccounts() {
        return numberOfCurrentAccounts;
    }
    
    /**
     * Method untuk mendapatkan telphone number customer
     * @return telphone number
     */ 
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Method untuk set alamat seorang customer
     * @param street nama jalan
     * @param city nama kota
     * @param code kode pos
     */ 
    public void setAddress(String street, String city, String code) {
        streetAddress = street;
        cityAddress = city;
        zipOrPostalCode = code;
    }
    
    /**
     * Method untuk set email address customer
     * @param emailAddress alamat email customer
     */ 
    public boolean setEmail(String emailAddress) {
        p = Pattern.compile(regex);
        m = p.matcher(emailAddress);
        if (m.matches()){
            email = emailAddress;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Method untuk set nama seorang customer
     * @param lname nama belakang
     * @param cfname nama depan
     */ 
    public void setName(String lname, String cfname) {
        firstName = cfname;
        lastName = lname;
    }
    
    /**
     * Method untuk set phone number customer
     * @param phoneNum nomor telpon customer
     */ 
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
        
    /**
     * Method untuk set customer id
     * @param customer id
     */
    public void setCustId(int custId){
        this.custId = custId;
    }
    
    /**
     * Method untuk get tanggal lahir seorang customer
     */
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    
    /**
     * Method getCustID untuk mengembalikan customer ID dari seorang customer
     * @return custID dari customer tersebut
     */
    public int getCustID(){
        return custId;
    }
    
    /**
     * Method addAccount untuk menambahkan akun ke dalam customer
     * @param balance berisikan saldo
     * @param type merupakan tipe akun yang dibuat
     */
    public boolean addAccount(Account acc) throws AccountTypeAlreadyExistsException, AccountTypeNotFoundException{
        boolean accountAdded = false, sameType = false;
        int index = -1;
        if ( numberOfCurrentAccounts < 5 ){
            for (int i = 0; i < 4; i++){
                if (accounts[i] == null && index == -1){
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getClass() == (acc.getClass())){
                        if(acc instanceof Investment){
                            throw new AccountTypeAlreadyExistsException('I');
                        }
                        else if(acc instanceof Savings){
                            throw new AccountTypeAlreadyExistsException('S');
                        }
                        else if(acc instanceof LineOfCredit){
                            throw new AccountTypeAlreadyExistsException('L');
                        }
                        else if(acc instanceof OverDraftProtection){
                            throw new AccountTypeAlreadyExistsException('O');
                        }
                        
                        /*try{
                            throw new AccountTypeAlreadyExistsException('S');
                        }
                        catch(AccountTypeAlreadyExistsException e){
                            System.out.println(e.getMessage());
                        }*/
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1){
                if(acc instanceof OverDraftProtection && getAccount('S') == null){
                    throw new AccountTypeNotFoundException('S');
                }
                else{
                    accounts[index] = acc;
                    accountAdded = true;
                    numberOfCurrentAccounts++;
                }
            }
        }
        return accountAdded;
    }
    
    /**
     * Method removeAccount menghapus akun dari customer
     * @return boolean true or false
     */
    public boolean removeAccount(char type) {
        Account acc = null;
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) {
            switch (type) {
                case 'S':
                if ( accounts[i] instanceof Savings) {
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                    break;
                }
                case 'L':
                if ( accounts[i] instanceof LineOfCredit) {
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                    break;
                }
                case 'O':
                if ( accounts[i] instanceof OverDraftProtection) {
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                    break;
                }
                case 'I': 
                if ( accounts[i] instanceof Investment) {
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                    break;
                }
            }
            
            if (accounts[i] == null && accountRemoved) {
                if ( i != 3) {
                    acc = accounts[i];
                    accounts[i] = accounts [i+1];
                    accounts [i+1] = acc;
                }
            }
        }
        return accountRemoved;
    }
    
    /**
     * Method compareTo overriding the comparable implement
     * 
     */
    public int compareTo(Customer other) {
        return Integer.compare(this.custId, other.custId);
    }
    
}