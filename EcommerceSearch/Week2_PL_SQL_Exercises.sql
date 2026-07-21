-- Scenario 1: 60+ age wale customers ko loan interest me 1% discount
BEGIN
  FOR cust IN (SELECT customer_id, loan_interest_rate FROM customers WHERE age > 60) 
  LOOP
    UPDATE customers 
    SET loan_interest_rate = loan_interest_rate - 1
    WHERE customer_id = cust.customer_id;
    
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || cust.customer_id || 
                         ' - Interest reduced by 1%. New rate: ' || (cust.loan_interest_rate - 1));
  END LOOP;
  COMMIT;
END;
/

-- Scenario 2: Balance > 10000 wale ko VIP bana do
BEGIN
  FOR cust IN (SELECT customer_id, balance FROM customers WHERE balance > 10000) 
  LOOP
    UPDATE customers 
    SET IsVIP = 'TRUE'
    WHERE customer_id = cust.customer_id;
    
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || cust.customer_id || ' promoted to VIP');
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: Next 30 days me due loans ke reminders
BEGIN
  FOR loan IN (
    SELECT c.customer_id, c.customer_name, l.loan_id, l.due_date 
    FROM customers c 
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) 
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan.customer_name || 
                         ', your loan ID ' || loan.loan_id || 
                         ' is due on ' || TO_CHAR(loan.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/