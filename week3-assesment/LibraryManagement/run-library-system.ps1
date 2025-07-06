# PowerShell script to run Library Management System and save output
param(
    [string]$OutputFile = "library-output.txt"
)

Write-Host "===============================================" -ForegroundColor Green
Write-Host "    Library Management System - Runner" -ForegroundColor Green  
Write-Host "===============================================" -ForegroundColor Green
Write-Host ""

$timestamp = Get-Date -Format "yyyy-MM-dd_HH-mm-ss"
if ($OutputFile -eq "library-output.txt") {
    $OutputFile = "library-output-$timestamp.txt"
}

Write-Host "Running Library Management System..." -ForegroundColor Yellow
Write-Host "Output will be saved to: $OutputFile" -ForegroundColor Cyan
Write-Host ""

# Create output file with header
$startTime = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
@"
=== Library Management System Output ===
Execution started at: $startTime

"@ | Out-File -FilePath $OutputFile

try {
    # Run the Java application and capture output
    $output = java -cp "target\classes;lib\*" org.example.Main 2>&1
    
    # Write output to file
    $output | Out-File -FilePath $OutputFile -Append
    
    # Also display on console
    Write-Host "Application Output:" -ForegroundColor Green
    Write-Host "==================" -ForegroundColor Green
    $output | ForEach-Object { Write-Host $_ }
    
    $endTime = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
    "`nExecution completed at: $endTime" | Out-File -FilePath $OutputFile -Append
    
    Write-Host ""
    Write-Host "✓ Application executed successfully!" -ForegroundColor Green
    Write-Host "✓ Output saved to: $OutputFile" -ForegroundColor Green
    Write-Host ""
    Write-Host "To view the saved output, run: Get-Content $OutputFile" -ForegroundColor Yellow
    
} catch {
    $errorMsg = "Error occurred: $($_.Exception.Message)"
    Write-Host $errorMsg -ForegroundColor Red
    $errorMsg | Out-File -FilePath $OutputFile -Append
}
