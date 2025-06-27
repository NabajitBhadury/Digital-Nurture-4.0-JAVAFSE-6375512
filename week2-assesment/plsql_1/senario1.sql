DECLARE
    CURSOR c_senior_loans IS
        SELECT l.LoanID, l.InterestRate
        FROM LOANS l
        JOIN CUSTOMERS c ON l.CustomerID = c.CustomerID
        WHERE c.Age > 60;

BEGIN
    FOR rec IN c_senior_loans LOOP
        UPDATE LOANS
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID ' || rec.LoanID);
    END LOOP;

    COMMIT;
END;
/
