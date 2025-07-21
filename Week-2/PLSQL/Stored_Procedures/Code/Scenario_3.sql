CREATE OR REPLACE PROCEDURE TransferFunds (
  from_account IN NUMBER,
  to_account   IN NUMBER,
  amount       IN NUMBER
) IS
  insufficient_balance EXCEPTION;
  current_balance NUMBER;
BEGIN
  SELECT Balance INTO current_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;

  IF current_balance < amount THEN
    RAISE insufficient_balance;
  END IF;

  UPDATE Accounts
  SET Balance = Balance - amount
  WHERE AccountID = from_account;

  UPDATE Accounts
  SET Balance = Balance + amount
  WHERE AccountID = to_account;

  COMMIT;

EXCEPTION
  WHEN insufficient_balance THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

EXEC TransferFunds(201, 202, 3000); 