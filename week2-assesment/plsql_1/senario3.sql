DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, l.CustomerID, l.DueDate, c.Name
        FROM LOANS l
        JOIN CUSTOMERS c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name ||
                             ' (ID: ' || rec.CustomerID || ') has Loan ID ' || rec.LoanID ||
                             ' due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/
