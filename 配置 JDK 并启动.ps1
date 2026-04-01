# 配置 JDK 环境并启动智能客服
# 解决 "No compiler is provided" 错误

Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   配置 JDK 环境并启动智能客服" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""

# 1. 设置 JAVA_HOME
$javaHome = "C:\Program Files\Java\jdk1.8.0_202"
Write-Host "[1/4] 设置 JAVA_HOME = $javaHome" -ForegroundColor Yellow
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", $javaHome, "User")
Write-Host "✓ JAVA_HOME 已设置" -ForegroundColor Green
Write-Host ""

# 2. 更新 PATH
Write-Host "[2/4] 更新 PATH 环境变量..." -ForegroundColor Yellow
$currentPath = [System.Environment]::GetEnvironmentVariable("PATH", "User")
$newPath = "$javaHome\bin;$currentPath"
[System.Environment]::SetEnvironmentVariable("PATH", $newPath, "User")
Write-Host "✓ PATH 已更新（包含 JDK bin 目录）" -ForegroundColor Green
Write-Host ""

# 3. 验证配置
Write-Host "[3/4] 验证 Java 配置..." -ForegroundColor Yellow
$javaExe = "$javaHome\bin\javac.exe"
if (Test-Path $javaExe) {
    Write-Host "✓ 找到 javac 编译器：$javaExe" -ForegroundColor Green
    
    # 获取版本信息
    $javacVersion = & "$javaExe" -version 2>&1
    Write-Host "  版本：$javacVersion" -ForegroundColor Gray
} else {
    Write-Host "✗ 错误：未找到 javac.exe" -ForegroundColor Red
    Write-Host "  请检查 JDK 是否正确安装" -ForegroundColor Yellow
    exit 1
}
Write-Host ""

# 4. 编译并启动项目
Write-Host "[4/4] 编译项目..." -ForegroundColor Yellow
Write-Host ""

# 使用新设置的 JAVA_HOME 运行 Maven
$env:JAVA_HOME = $javaHome
$env:PATH = "$javaHome\bin;$env:PATH"

# 编译项目
mvn clean compile -DskipTests

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "✓ 编译成功！" -ForegroundColor Green
    Write-Host ""
    Write-Host "正在启动 Spring Boot 应用..." -ForegroundColor Yellow
    Write-Host ""
    
    # 启动应用
    mvn spring-boot:run
} else {
    Write-Host ""
    Write-Host "✗ 编译失败，请检查错误信息" -ForegroundColor Red
    Write-Host ""
    Write-Host "提示：" -ForegroundColor Yellow
    Write-Host "  1. 确认 JDK 安装路径正确" -ForegroundColor White
    Write-Host "  2. 关闭此窗口，重新打开 PowerShell 后再试" -ForegroundColor White
    Write-Host "  3. 或者直接在 IDE 中运行 ReggieApplication.java" -ForegroundColor White
}

Write-Host ""
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   配置完成" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "下次启动时，可以直接运行：" -ForegroundColor Yellow
Write-Host "  .\启动智能客服.ps1" -ForegroundColor White
Write-Host ""
Write-Host "或者在 IDE 中直接运行 ReggieApplication.java" -ForegroundColor White
Write-Host ""
