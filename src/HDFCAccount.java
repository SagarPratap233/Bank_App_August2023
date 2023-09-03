import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{

    private String name;
    private String accountNo;
    private final String IFSCCode = "HDFC2323";
    private String Password;
    private double balance;
    private final double rateOfInterest = 7.1;

    //default constructor
    public HDFCAccount() {
    }

    //all-parameter constructor
    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.Password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.Password.equals(password))
        {
            return "Your balance is: "+ this.balance;
        }
        return "Your password incorrect";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount added successfully: "+ this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.Password.equals(password))
        {
            if(this.balance<amount)
            {
                return "Insufficent Balance";
            }
            else
            {
                balance -= amount;
                return "Amount is deducted successfully. New Balance is: "+ this.balance;
            }
        }

        return "Incorrect Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.Password.equals(oldPassword))
        {
            this.Password = newPassword;
            return "Password is changed successfully";
        }
        return "Incorrect Original Password";
    }

    @Override
    public double calculateInterest(int year) {
        return(this.balance*year*rateOfInterest)/100;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", Password='" + Password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
