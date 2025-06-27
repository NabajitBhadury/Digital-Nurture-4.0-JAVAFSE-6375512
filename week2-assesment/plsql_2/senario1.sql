CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE SAVINGS_ACCOUNTS
    SET Balance = Balance * 1.01;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
END;
/
