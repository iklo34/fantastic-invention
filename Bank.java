package trybymyself;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    public static void main(String[] args) {
        Currency usd = Currency.getInstance("USD", 1);
        Currency eur = Currency.getInstance("EURO", 1.2);
        Currency pound = Currency.getInstance("British pound", 1.45);

        RegularUser Max = new RegularUser("Max", "max13@gmail.com");
        RegularUser David = new RegularUser("David", "davi142@gmail.com");
        PremiumUser Jamal = new PremiumUser("Jamal", "Jam17@gmail.com");

        BankAccount f363473 = new BankAccount(Max, usd, 1.2, -1000, 300);
        BankAccount f356774 = new BankAccount(David, pound, 1.2, -1000, 300);
        BankAccount f111111 = new BankAccount(Jamal, usd, 1.5, -3000, 500);
        BankAccount f222222 = new BankAccount(Jamal, eur, 1.5, -3000, 1000);

        f356774.setDepositWithdrawStrategy(
                f356774.getCurrency() == pound ? new SameCurrencyStrategy() : new DifferentCurrencyStrategy()
        );

        f356774.DepositMoney(100, pound);
        f356774.WithdrawMoney(142, usd);
        f356774.ConvertBalance(eur);
        f356774.ShowBalance();

        f363473.DepositMoney(24252, pound);
        f111111.ChangeCreditLimit(-3200);
        f222222.ChangeInterestRate(1.23);

        f111111.displayAccountInfo();
        f222222.displayAccountInfo();
        f356774.displayAccountInfo();
        f363473.displayAccountInfo();
    }
}

class Currency {
    private static final Map<String, Currency> instances = new HashMap<>();

    String cod;
    double Ex_rate;

    private Currency(String cod, double Ex_rate) {
        this.cod = cod;
        this.Ex_rate = Ex_rate;
    }

    public static Currency getInstance(String cod, double Ex_rate) {
        return instances.computeIfAbsent(cod, k -> new Currency(cod, Ex_rate));
    }

    public double getExchangeRate() {
        return Ex_rate;
    }
}

interface DepositWithdrawStrategy {
    void execute(BankAccount account, double amount);
}

class SameCurrencyStrategy implements DepositWithdrawStrategy {
    @Override
    public void execute(BankAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }
}

class DifferentCurrencyStrategy implements DepositWithdrawStrategy {
    @Override
    public void execute(BankAccount account, double amount) {
        Currency currency = account.getCurrency();
        account.setBalance(account.getBalance() + (amount * account.getConversionRate()) / currency.getExchangeRate());
    }
}

class User implements UserType {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void info() {
        System.out.println("Name is: " + name);
        System.out.println("Email is:" + email);
    }
}

interface UserType {
    void info();
}

class RegularUser extends User {
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

class PremiumUser extends User {
    boolean premiumStat;

    public PremiumUser(String name, String email) {
        super(name, email);
    }

    @Override
    public void info() {
        super.info();
    }

    public void setPremiumStat(boolean premiumStat) {
        this.premiumStat = premiumStat;
    }
}

class BankAccount {
    private Currency currency;
    private final User owner;
    private double interestRate;
    private double creditLimit;
    private double balance;

    private DepositWithdrawStrategy depositWithdrawStrategy;
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(User owner, Currency currency, double interestRate, double creditLimit, double balance) {
        this.currency = currency;
        this.owner = owner;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.depositWithdrawStrategy = new SameCurrencyStrategy();
    }

    void displayAccountInfo() {
        System.out.println();
        System.out.println("Account owner: " + owner.name);
        System.out.println("Currency: " + currency.cod);
        System.out.println("Balance: " + balance + " " + currency.cod);
        System.out.println("Interest rate: " + interestRate + "%");
        System.out.println("Credit limit: " + creditLimit + " " + currency.cod);
        System.out.println();
    }

    public void DepositMoney(double amount, Currency currency1) {
        depositWithdrawStrategy.execute(this, amount);
        System.out.println("Your deposit: " + amount + " " + currency1.cod);
        System.out.println("Now your balance is:" + balance + " " + currency.cod);
    }

    public void WithdrawMoney(double amount, Currency currency1) {
        double withdrawalAmount = (amount * currency1.getExchangeRate()) / currency.getExchangeRate();

        if (balance - withdrawalAmount >= creditLimit) {
            depositWithdrawStrategy.execute(this, -withdrawalAmount);
            System.out.println("Your withdraw: " + amount + " " + currency1.cod);
            System.out.println("Now your balance is:" + balance + " " + currency.cod);
        } else {
            System.out.println("Insufficient funds");
        }
    }


    public void ChangeInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void ChangeCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void ShowBalance() {
        System.out.println("Your balance is: " + balance + " " + currency.cod);
    }

    public void ConvertBalance(Currency currencyTar) {
        balance = (balance * currency.getExchangeRate()) / currencyTar.getExchangeRate();
        currency.cod=currencyTar.cod;
        System.out.println("Your balance was converted to " + currencyTar.cod);
    }

    public double getBalance() {
        return balance;
    }

    public double getConversionRate() {
        return currency.getExchangeRate();
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setDepositWithdrawStrategy(DepositWithdrawStrategy strategy) {
        this.depositWithdrawStrategy = strategy;
    }
}
