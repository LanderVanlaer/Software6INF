package me.landervanlaer.school.informatica6.test.oef6;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class collecting tests for the class of bankAccounts
 *
 * @author Van Geenhoven
 * @version 1.0
 */
public class BankAccountTest {

    /**
     * Class variables referencing bank accounts that do not change
     * during the entire test case.
     */
    private static BankAccount accountBalance300, accountBalance500,
            blockedAccount;
    /**
     * Instance variable referencing bank accounts that may change during
     * individual tests.
     */
    private BankAccount accountBalance1000;

    /**
     * Set up an immutable test fixture.
     *
     * @post The variable accountBalance300 references a new bankAccount
     * with a balance of 300.
     * @post The variable accountBalance500 references a new bankAccount
     * with a balance of 500.
     * @post the variable blockedAccount references a new blocked
     * bankAccount.
     */
    @BeforeClass
    public static void setUpImmutableFixture() {
        accountBalance300 = new BankAccount(1234567, 300);
        accountBalance500 = new BankAccount(7654321, 500);
        blockedAccount = new BankAccount(2121212, 333, true);
    }

    /**
     * Set up a mutable test fixture.
     *
     * @post The variable accountBalance1000 references a new
     * bankAccount with a balance of 100.
     */
    @Before
    public void setUpMutableFixture() {
        accountBalance1000 = new BankAccount(1111111, 1000);
    }

    @Test
    public void withdraw_LegalCase() {
        accountBalance1000.withdraw(200);
        assertEquals(800, accountBalance1000.getBalance());
    }

    @Test
    public void withdraw_NegativeAmount() {
        accountBalance1000.withdraw(-1200);
        assertEquals(1000L, accountBalance1000.getBalance());
    }

    @Test
    public void withdraw_BalanceOverflow() {
        accountBalance1000.withdraw(Long.MAX_VALUE);
        assertEquals(1000L, accountBalance1000.getBalance());
    }

    @Test
    public void withdraw_BlockedAccount() {
        long oldBalance = blockedAccount.getBalance();
        blockedAccount.withdraw(200);
        assertEquals(oldBalance, blockedAccount.getBalance());
    }

    @Test
    public void hasHigherBalanceThanAccount_EffectiveCase() {
        assertTrue(accountBalance500.hasHigherBalanceThan(accountBalance300))
        ;
    }

    @Test
    public void hasHigherBalanceThanAccount_NonEffectiveCase() {
        assertFalse(accountBalance500.hasHigherBalanceThan(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBalanceLimit_IllegalCase() throws Exception {
        BankAccount.setCreditLimit(10);
    }

    @Test
    public void constructor() {
        BankAccount bankAccount = new BankAccount(0, 1000, true);
        assertEquals(0, bankAccount.getNumber());
        assertEquals(1000, bankAccount.getBalance());
        assertTrue(bankAccount.isBlocked());
    }
}
