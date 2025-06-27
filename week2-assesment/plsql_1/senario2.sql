DECLARE
    CURSOR c_high_balance IS
        SELECT CustomerID
        FROM CUSTOMERS
        WHERE Balance > 10000;

BEGIN
    FOR rec IN c_high_balance LOOP
        UPDATE CUSTOMERS
        SET IsVIP = 'Y'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' promoted to VIP.');
    END LOOP;

    COMMIT;
END;
/
