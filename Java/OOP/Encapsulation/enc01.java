class BankAccount {
    // Private variables: Cannot be accessed directly outside this class
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    // Getter for Account Number (Read-only access)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for Balance
    public double getBalance() {
        return balance;
    }

    // Setter for Balance with validation rules (Controlled modification)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
