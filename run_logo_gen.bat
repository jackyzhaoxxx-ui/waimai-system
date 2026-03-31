@echo off
cd /d c:\git\cc-code-master
python generate_logo_local.py
echo.
echo Checking if files were created...
if exist "c:\git\cc-code-master\src\main\resources\front\images\logo.png" (
    echo ✓ Front logo exists
) else (
    echo ✗ Front logo not found
)
if exist "c:\git\cc-code-master\src\main\resources\backend\images\logo.png" (
    echo ✓ Backend logo exists
) else (
    echo ✗ Backend logo not found
)
if exist "c:\git\cc-code-master\src\main\resources\backend\images\login\logo.png" (
    echo ✓ Login logo exists
) else (
    echo ✗ Login logo not found
)
pause
