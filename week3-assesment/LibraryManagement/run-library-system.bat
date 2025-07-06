@echo off
echo ==============================================
echo    Library Management System - Runner
echo ==============================================
echo.

rem Set the timestamp for the output file
for /f "tokens=2-4 delims=/ " %%a in ('date /t') do (set mydate=%%c-%%a-%%b)
for /f "tokens=1-2 delims=/:" %%a in ('time /t') do (set mytime=%%a%%b)
set datetime=%mydate%_%mytime%
set outputfile=library-output-%datetime%.txt

echo Running Library Management System...
echo Output will be saved to: %outputfile%
echo.

rem Run the Java application and save output to file
echo === Library Management System Output === > %outputfile%
echo Execution started at: %date% %time% >> %outputfile%
echo. >> %outputfile%

java -cp "target\classes;lib\*" org.example.Main >> %outputfile% 2>&1

echo. >> %outputfile%
echo Execution completed at: %date% %time% >> %outputfile%

echo.
echo ✓ Application executed successfully!
echo ✓ Output saved to: %outputfile%
echo.
echo To view the output, run: type %outputfile%
pause
