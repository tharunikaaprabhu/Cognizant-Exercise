import com.example.BankAccount;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100);
        System.out.println("Setup complete");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("Teardown complete");
    }

    @Test
    public void testDeposit() {
        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(30);

        assertEquals(70, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalanceThrowsException() {
        account.withdraw(200);

    }
}
