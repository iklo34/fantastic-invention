public class Bank {
    public static void main(String[] args) {
        Currency usd = new Currency("USD",1);
        Currency eur = new Currency("EURO",1.2);
        Currency pound = new Currency("British pound",1.45);

        RegularUser Max = new RegularUser("Max","max13@gmail.com");
        RegularUser David = new RegularUser("David","davi142@gmail.com");
        PremiumUser Jamal = new PremiumUser("Jamal","Jam17@gmail.com");

        BankAccount f363473 = new BankAccount(Max,usd,1.2,-1000,300);
        BankAccount f356774 = new BankAccount(David,pound,1.2,-1000,300);
        BankAccount f111111 = new BankAccount(Jamal,usd,1.5,-3000,500);
        BankAccount f222222 = new BankAccount(Jamal,eur,1.5,-3000,1000);

        f356774.DepositMoney(100,pound);
        f356774.WithdrawMoney(142,usd);
        f356774.ConvertBalance(usd);
        f356774.ShowBalance();
        f222222.ConvertBalance(pound);
        Max.setActivity(23);
        Jamal.setPremiumStat(true);
        f363473.DepositMoney(24252,pound);
        f111111.ChangeCreditLimit(-3200);
        f222222.ChangeInterestRate(1.23);

        f111111.displayAccountInfo();
        f222222.displayAccountInfo();
        f356774.displayAccountInfo();
        f363473.displayAccountInfo();
    }
}
class Currency{
    String cod;
    double Ex_rate;
    public Currency(String cod,double Ex_rate){
        this.cod = cod;
        this.Ex_rate = Ex_rate;
    }
}
class User implements UserType{
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void info() {
        System.out.println("Name is: "+name);
        System.out.println("Email is:"+email);
    }
}
interface UserType{
    void info();
}
class RegularUser extends User{
    int activity;

    public RegularUser(String name, String email) {
        super(name, email);
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    @Override
    public void info() {
        super.info();
    }
}
class PremiumUser extends User{
    public PremiumUser(String name, String email) {
        super(name, email);
    }

    @Override
    public void info() {
        super.info();
    }
    boolean premiumStat;

    public void setPremiumStat(boolean premiumStat) {
        this.premiumStat = premiumStat;
    }
}
class BankAccount{
    Currency currency;
    User owner;
    double interestRate;
    double creditLimit;
    double balance;

    public BankAccount(User owner,Currency currency ,double interestRate, double creditLimit, double balance) {
        this.currency = currency;
        this.owner = owner;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.balance = balance;
    }
    void displayAccountInfo() {
        System.out.println("Account owner: " + owner.name);
        System.out.println("Currency: " + currency.cod);
        System.out.println("Balance: " + balance + " " + currency.cod);
        System.out.println("Interest rate: " + interestRate + "%");
        System.out.println("Credit limit: " + creditLimit + " " + currency.cod);
    }

    public void DepositMoney(double amount, Currency currency1){
        if (currency!=currency1){
            balance += (amount * currency1.Ex_rate) / currency.Ex_rate;
            System.out.println("Your deposit: "+amount +" "+currency1.cod);
            System.out.println("Now your balance is:" + balance+" "+currency.cod);
        }
        else {
            balance+=amount;
            System.out.println("Your deposit: "+amount +" "+currency1.cod);
            System.out.println("Now your balance is:" + balance+" "+currency.cod);
        }
    }
    public void WithdrawMoney(double amount, Currency currency1){
        if (balance-(amount*currency1.Ex_rate)/currency.Ex_rate>=creditLimit){
            if (currency!=currency1){
                balance -= (amount * currency1.Ex_rate) / currency.Ex_rate;
                System.out.println("Your withdraw: "+amount +" "+currency1.cod);
                System.out.println("Now your balance is:" + balance+" "+currency.cod);
            }
            else {
                balance-=amount;
                System.out.println("Your withdraw: "+amount +" "+currency1.cod);
                System.out.println("Now your balance is:" + balance+" "+currency.cod);
            }
        }
        else System.out.println("Insufficient funds");
    }

    public void ChangeInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void ChangeCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public void ShowBalance(){
        System.out.println("Your balance is: "+balance+" "+currency.cod);
    }
    public void ConvertBalance(Currency currencyTar){
        currency.cod=currencyTar.cod;
        balance=(balance*currency.Ex_rate)/currencyTar.Ex_rate;
        System.out.println("Your balance was converted to "+currencyTar.cod);
    }
}
