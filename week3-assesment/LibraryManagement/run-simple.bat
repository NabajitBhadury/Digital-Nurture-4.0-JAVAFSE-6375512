@echo off
rem Simple batch file to run Library Management System and save output
java -cp "target\classes;lib\*" org.example.Main > library-system-output.txt 2>&1
echo ✓ Library Management System executed!
echo ✓ Output saved to: library-system-output.txt
echo.
echo To view output: type library-system-output.txt
pause
