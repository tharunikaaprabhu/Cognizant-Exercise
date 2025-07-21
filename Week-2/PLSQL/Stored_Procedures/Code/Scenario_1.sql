CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT AccountID, Balance FROM SavingsAccounts) LOOP
    UPDATE SavingsAccounts
    SET Balance = acc.Balance + (acc.Balance * 0.01)
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE('Updated Account ' || acc.AccountID || 
                         ': New Balance = ' || (acc.Balance + acc.Balance * 0.01));
  END LOOP;
  COMMIT;
END;
/

EXEC ProcessMonthlyInterest;
