CUSTOMERS(
    CustomerID    NUMBER PRIMARY KEY,
    Name          VARCHAR2(100),
    Age           NUMBER,
    Balance       NUMBER,
    IsVIP         CHAR(1)
);

LOANS(
    LoanID        NUMBER PRIMARY KEY,
    CustomerID    NUMBER REFERENCES CUSTOMERS(CustomerID),
    InterestRate  NUMBER,
    DueDate       DATE
);
