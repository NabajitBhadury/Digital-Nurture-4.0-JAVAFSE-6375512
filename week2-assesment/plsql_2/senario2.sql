CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPct   IN NUMBER
) IS
BEGIN
    UPDATE EMPLOYEES
    SET Salary = Salary * (1 + p_BonusPct / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_BonusPct || '% applied to department: ' || p_Department);
END;
/
