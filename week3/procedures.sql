-- Scenario 1: Process Monthly Interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END;
/
-- Scenario 2: Update Employee Bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;
END;
/
-- Scenario 3: Transfer Funds
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_sourceAccount IN NUMBER,
    p_targetAccount IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_sourceAccount;

    IF v_balance >= p_amount THEN
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_sourceAccount;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_targetAccount;

        INSERT INTO Transactions(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (SEQ_TRANS.NEXTVAL, p_sourceAccount, SYSDATE, p_amount, 'Transfer');

        INSERT INTO Transactions(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (SEQ_TRANS.NEXTVAL, p_targetAccount, SYSDATE, p_amount, 'Transfer');
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;
END;
/
