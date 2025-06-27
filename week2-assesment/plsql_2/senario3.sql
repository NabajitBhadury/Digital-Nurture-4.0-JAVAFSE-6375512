CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN NUMBER,
    p_TargetAccountID IN NUMBER,
    p_Amount          IN NUMBER
) IS
    v_SourceBalance NUMBER;
BEGIN
    FROM ACCOUNTS
    WHERE AccountID = p_SourceAccountID
    FOR UPDATE;

    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    UPDATE ACCOUNTS
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_SourceAccountID;

    UPDATE ACCOUNTS
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_TargetAccountID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_Amount || ' from Account ' || p_SourceAccountID || ' to Account ' || p_TargetAccountID);
END;
/
