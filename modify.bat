@echo off
setlocal enabledelayedexpansion

set "file=c:\git\cc-code-master\src\main\resources\front\index.html"

for /f "usebackq delims=" %%a in ("!file!") do (
    set "line=%%a"
    if "!line:菩提阁中餐厅=!" neq "!line!" (
        set "line=!line:菩提阁中餐厅是菩提阁点餐的独立的品牌=外卖系统是点餐的独立品牌!"
    )
    echo !line!
) > temp.html

move /y temp.html "!file!"
echo Modified successfully
