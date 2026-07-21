-- Scenario 1: Process Monthly Interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END;
/
-- Scenario 2: Calculate Monthly Installment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_amount NUMBER,
    p_rate NUMBER,
    p_years NUMBER
) RETURN NUMBER IS
    v_monthly NUMBER;
    v_months NUMBER := p_years * 12;
    v_rate NUMBER := p_rate / 100 / 12;
BEGIN
    v_monthly := p_amount * v_rate / (1 - POWER(1 + v_rate, -v_months));
    RETURN v_monthly;
END;
/


    -- Scenario 3: Has Sufficient Balance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accountID NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_accountID;
    RETURN v_balance >= p_amount;
END;
/

-- Scenario 1: Calculate Age
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
