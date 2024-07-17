/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Concepts :
 *
 * abstract class : Use when you need to share code among closely related classes and 
                   provide a common base with both abstract and concrete methods.
 * abstract method
 * "abstract" and "extends" keyword
 *
 * abstract methods cannot be declared in a non-abstract class. 
 * In Java, if a class contains at least one abstract method, 
 * the class itself must be declared abstract. This is because abstract methods do not have a body 
 * (implementation), and any class containing such methods would be incomplete and unable to instantiate
 *
 *******************************************************************************/

abstract class Account {
    double balance;
    double interestRate;
    String accountNumber;

    // Constructor to initialize opening account balance
    public Account (String inAccountNumber, double inInitialBalance, double inInterestRate) {
        balance = inInitialBalance;
        interestRate = inInterestRate;
        accountNumber = inAccountNumber;
    }

    public double getBalance() {
        return balance;
    }
    //abstract methods
    public abstract void deposit (double inAmount);
    public abstract void withdraw (double inAmount);
}

class SavingsAccount extends Account {
    double minimumBalance;

    public SavingsAccount (String inAccountNumber, double inInitialBalance, 
                           double inInterestRate, double inMinimumBalance) {
        super(inAccountNumber, inInitialBalance, inInterestRate);
        minimumBalance = inMinimumBalance;
        if (inInitialBalance < minimumBalance) {
            System.out.println("Minimumbalance of "+minimumBalance+" should be maintained");
        }
    }

    @Override public void deposit (double inAmount) {
        balance += inAmount;
    }

    @Override public void withdraw (double inAmount) {
        if (inAmount > (balance-minimumBalance)) {
            System.out.println("Minimumbalance of "+minimumBalance+" should be maintained");
        }
        else {
            balance -= inAmount;
        }
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;
    
    public CurrentAccount (String inAccountNumber, double inInitialBalance, 
                           double inInterestRate, double inOverdraftLimit) {
        super(inAccountNumber, inInitialBalance, inInterestRate);
        overdraftLimit = inOverdraftLimit;
    }

    @Override public void deposit (double inAmount) {
        balance += inAmount;
    }

    @Override public void withdraw (double inAmount) {
        if (inAmount > (balance+overdraftLimit)) {
            System.out.println("OverdraftLimit of "+overdraftLimit+" exceeded");
        }
        else {
            balance -= inAmount;
        }
    }
}

//public class Bank {
public class AbstractClassExample {  
    public static void main (String[] args) {
        Account savings = new SavingsAccount("SA000111",1000,5,500);
        Account current = new CurrentAccount("CA000111",1000,10,1000);
        
        savings.deposit(500);
        System.out.println("Savings Account Balance: " + savings.getBalance());

        current.withdraw(1200);
        System.out.println("Current Account Balance: " + current.getBalance());
    }
}