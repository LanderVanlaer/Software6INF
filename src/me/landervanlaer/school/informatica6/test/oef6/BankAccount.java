package me.landervanlaer.school.informatica6.test.oef6;

/**
 * A class of bank accounts involving a bank code, a number,
 * a credit limit, a balance limit, a balance and a blocking facility
 *
 * @author Van Geenhoven
 * @version 1.0
 */
public class BankAccount {

    /**
     * Variable registering the bankCode that applies to all bankAccounts
     */
    private static final int bankCode = 123;
    /**
     * Variable registering the balanceLimit that applies to all bankAccounts.
     */
    private static final long balanceLimit = Long.MAX_VALUE;
    /**
     * Variable registering the creditLimit that applies to all bankAccounts.
     */
    private static long creditLimit = 0L;
    /**
     * Variable registering the number of this bankAccount
     */
    private final int number;
    /**
     * Variable registering the balance of this bankAccount.
     */
    private long balance = 0L;
    /**
     * Variable registering the blocked state of this bankAccount.
     */
    private boolean isBlocked = false;

    /**
     * Initialize this new bankAccount with a given number, given balance and given blocked state.
     *
     * @param number    The number for this new bankAccount
     * @param balance   The balance for this new bankAccount
     * @param isBlocked The blocked state of this new bankAccount.
     * @post If the given number is not negative, the initial number of this new bankAccount is
     * equal to the given number. Otherwise, its initial number is equal to 0.
     * @post If the given balance is not below the creditLimit and not above the balanceLimit, the
     * initial balance of this new bankAccount is equal to the given balance. Otherwise, its initial balance is equal to 0.
     */
    public BankAccount(int number, long balance, boolean isBlocked) {
        if(number < 0)
            number = 0;
        this.number = number;
        setBalance(balance);
        setBlocked(isBlocked);
    }

    /**
     * Initialize this new bankAccount as an unblocked account with given number and given balance.
     *
     * @param number  The number for this new bankAccount
     * @param balance The balance for this new bankAccount
     * @effect This new BankAccount is initialized in the same way as the most extended constructor,
     * except for isBlocked which is initialized as false.
     */
    public BankAccount(int number, long balance) {
        this.number = number;
        setBalance(balance);
        setBlocked(isBlocked);
    }

    /**
     * Initialize this new bankAccount as an unblocked account with given number and zero balance.
     *
     * @param number The number for this new bankAccount
     * @effect This new bankAccount is initialized in the same way a new bankAccount would be initialized
     * with the moddme constructor involving the given number as it's number and zero as its initial balance.
     */
    public BankAccount(int number) {
        this.number = number;
        setBalance(0);
    }

    /**
     * Return the bankCode that applies to all bankAccounts.
     * The bankCode identifies the bank to which all bankAccounts belong.
     */

    public static int getBankCode() {
        return bankCode;
    }

    /**
     * Return the creditLimit that applies to all bankAccounts.
     * The creditLimit expresses the lowest possible value for the balance of a bankAccount.
     */

    public static long getCreditLimit() {
        return creditLimit;
    }

    /**
     * Set the creditLimit that applies to all bankAccounts to the given creditLimit.
     *
     * @param creditLimit The new creditLimit for all bankAccounts.
     * @post If the given creditLimit is not above the creditLimit that currently applies to all bankAccounts,
     * the new creditLimit that applies to all bankAccounts is equal to the given creditLimit.
     */
    public static void setCreditLimit(long creditLimit) {
        if(creditLimit < getCreditLimit())
            BankAccount.creditLimit = creditLimit;
        else throw new IllegalArgumentException("The given creditLimit can not be above the current creditLimit");
    }

    /**
     * Return the balanceLimit that applies to all bankAccounts.
     * The balanceLimit expresses the highest possible value for the balance of a bankAccount.
     */

    public static long getBalanceLimit() {
        return balanceLimit;
    }

    /**
     * Return the number of this bankAccount.
     * The number of a bankAccount serves to distinguish that account from all other bankAccounts.
     */

    public int getNumber() {
        return this.number;
    }

    /**
     * Return the balance of this account.
     * The balance of a bankAccount expresses the amount of money available on tha account.
     */

    public long getBalance() {
        return this.balance;
    }

    /**
     * Set the balance of this BankAccount to the given balance.
     *
     * @param balance the balance to be set
     * @post if the given balance is not below the creditLimit for all BankAccounts,
     * and if the balance is not higher than the balanceLimit for all BankAccounts,
     * the new balance of this BankAccount is set to the given balance
     */
    private void setBalance(long balance) {
        if((balance >= getCreditLimit()) && (balance <= getBalanceLimit()))
            this.balance = balance;
    }

    /**
     * Check whether this bankAccount has a higher balance than the given amount of money.
     *
     * @param amount The amount of money to compare with.
     * @return True if and only if the balance of this bank account
     * is greater than the given account
     */
    public boolean hasHigherBalanceThan(long amount) {
        return this.getBalance() > amount;
    }

    /**
     * Check whether this bankAccount has a higher balance than the other bankAccount
     *
     * @param other The bankAccount to compare with.
     * @return True if and only if the other bank account is effective,
     * and if this bank account has a higher balance than the balance
     * of the other bank account.
     */
    public boolean hasHigherBalanceThan(BankAccount other) {
        return (other != null && this.hasHigherBalanceThan(other.getBalance()));
    }

    /**
     * Deposit the given amount of money to this bankAccount.
     *
     * @param amount The amount of money to be deposited.
     * @post If the given amount of money is positive, and if the old balance of
     * this account is incremented with the given amount of money is not above the
     * balance limit, the new balance of this bank account is equal to the old balance
     * of this bank account incremented with the given amount of money.
     */
    public void deposit(long amount) {
        if(amount > 0 && (this.getBalance() + amount) < BankAccount.getBalanceLimit()) {
            this.setBalance(this.getBalance() + amount);
        }

    }

    /**
     * Withraw the given amount of money from this bankAccount.
     *
     * @param amount The amount of money to be withdrawn.
     * @post If the given amount of money is positive, and if this bank account is not blocked
     * and if the old balance of this bank account decremented with the given amount of
     * money is not below the credit limit, the new balance of this bank account is equal to
     * the old balance of this bank account decremented with the given amount of money.
     */
    public void withdraw(long amount) {
        if(amount > 0 && !this.isBlocked() && ((this.getBalance() - amount) > BankAccount.getCreditLimit()))
            this.setBalance(this.getBalance() - amount);

    }

    /**
     * Transfer the given amount of money from this bankAccount to the given destination account.
     *
     * @param amount      The amount of money to be transferred.
     * @param destination The bankAccount to transfer the money to.
     * @effect If the given destination account is effective and not the same as
     * the bank account, and if this bank account is not blocked, and if the old
     * balance of this bank account decremented with the given amount of money is not
     * below the credit limit, and if the old balance of the given destination account
     * is incremented with the given amount of money is not above the balance limit,
     * the given amount of money is withdrawn from this bank account, and deposited
     * to the given destination account.
     */
    public void transferTo(long amount, BankAccount destination) {
        if(amount > 0 && destination != null && destination != (this) && !this.isBlocked() && (this.getBalance() - amount) > BankAccount.getCreditLimit() && destination.getBalance() + amount < BankAccount.getBalanceLimit()) {
            this.withdraw(amount);
            destination.deposit(amount);
        }
    }

    /**
     * Check whether this bankAccount is blocked.
     * Some methods have no effect when invoked against blocked accounts.
     */
    public boolean isBlocked() {
        return this.isBlocked;
    }

    /**
     * Set the blocked state of this bankAccount according to the given flag.
     *
     * @param flag The new blocked state for this bankAccount.
     * @post The new blocked state of this bankAccount is equal to the given flag.
     */
    public void setBlocked(boolean flag) {
        this.isBlocked = flag;
    }

    /**
     * Block this bankAccount
     *
     * @effect The blocked state of this bankAccount is set to true.
     */
    public void block() {
        setBlocked(true);
    }

    /**
     * Unblock this bankAccount
     *
     * @effect The blocked state of this bankAccount is set to false.
     */
    public void unblock() {
        setBlocked(false);
    }
}

