# PowerShell script to download Spring Framework JAR files
# Run this script to download the required Spring dependencies

$springVersion = "5.3.21"
$libDir = "lib"
$outputFile = "download-log.txt"

# Create lib directory if it doesn't exist
if (!(Test-Path $libDir)) {
    New-Item -ItemType Directory -Path $libDir
}

# Start logging
$timestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
"=== Spring JAR Download Log ===" | Out-File -FilePath $outputFile
"Download started at: $timestamp" | Out-File -FilePath $outputFile -Append
"" | Out-File -FilePath $outputFile -Append

Write-Host "Downloading Spring Framework JAR files..."
"Downloading Spring Framework JAR files..." | Out-File -FilePath $outputFile -Append

# List of required Spring JAR files
$jarUrls = @(
    "https://repo1.maven.org/maven2/org/springframework/spring-core/$springVersion/spring-core-$springVersion.jar",
    "https://repo1.maven.org/maven2/org/springframework/spring-context/$springVersion/spring-context-$springVersion.jar",
    "https://repo1.maven.org/maven2/org/springframework/spring-beans/$springVersion/spring-beans-$springVersion.jar",
    "https://repo1.maven.org/maven2/org/springframework/spring-aop/$springVersion/spring-aop-$springVersion.jar",
    "https://repo1.maven.org/maven2/org/springframework/spring-expression/$springVersion/spring-expression-$springVersion.jar",
    "https://repo1.maven.org/maven2/org/springframework/spring-webmvc/$springVersion/spring-webmvc-$springVersion.jar",
    "https://repo1.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar"
)

foreach ($url in $jarUrls) {
    $fileName = Split-Path $url -Leaf
    $filePath = Join-Path $libDir $fileName
    
    Write-Host "Downloading $fileName..."
    "Downloading $fileName..." | Out-File -FilePath $outputFile -Append
    
    try {
        Invoke-WebRequest -Uri $url -OutFile $filePath -UseBasicParsing
        Write-Host "✓ Downloaded $fileName" -ForegroundColor Green
        "✓ Downloaded $fileName - SUCCESS" | Out-File -FilePath $outputFile -Append
    } catch {
        Write-Host "✗ Failed to download $fileName" -ForegroundColor Red
        Write-Host "Error: $($_.Exception.Message)" -ForegroundColor Red
        "✗ Failed to download $fileName - ERROR: $($_.Exception.Message)" | Out-File -FilePath $outputFile -Append
    }
}

$endTimestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
Write-Host "`nAll Spring JAR files downloaded to 'lib' directory!"
Write-Host "Now you can run your project using:"
Write-Host "java -cp `"target\classes;lib\*`" org.example.Main" -ForegroundColor Yellow

"" | Out-File -FilePath $outputFile -Append
"All Spring JAR files downloaded to 'lib' directory!" | Out-File -FilePath $outputFile -Append
"Download completed at: $endTimestamp" | Out-File -FilePath $outputFile -Append
"" | Out-File -FilePath $outputFile -Append
"To run the project, use:" | Out-File -FilePath $outputFile -Append
"java -cp `"target\classes;lib\*`" org.example.Main" | Out-File -FilePath $outputFile -Append

Write-Host "`nDownload log saved to: $outputFile" -ForegroundColor Cyan
