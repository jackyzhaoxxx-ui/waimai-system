# 智能客服模块 - 快速启动脚本
# 适用于 Windows PowerShell

Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   智能客服模块 - 快速启动脚本" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""

# 1. 检查 Java 环境
Write-Host "[1/5] 检查 Java 环境..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "✓ Java 已安装: $javaVersion" -ForegroundColor Green
} catch {
    Write-Host "✗ 错误：未检测到 Java 环境，请先安装 JDK 1.8+" -ForegroundColor Red
    exit 1
}

# 2. 检查 Maven 环境
Write-Host "[2/5] 检查 Maven 环境..." -ForegroundColor Yellow
try {
    $mavenVersion = mvn -version 2>&1 | Select-Object -First 1
    Write-Host "✓ Maven 已安装：$mavenVersion" -ForegroundColor Green
} catch {
    Write-Host "✗ 错误：未检测到 Maven 环境，请先安装 Maven" -ForegroundColor Red
    exit 1
}

# 3. 检查 MySQL 服务
Write-Host "[3/5] 检查 MySQL 服务..." -ForegroundColor Yellow
try {
    $mysqlService = Get-Service -Name "MySQL*" -ErrorAction SilentlyContinue
    if ($mysqlService -and $mysqlService.Status -eq "Running") {
        Write-Host "✓ MySQL 服务正在运行" -ForegroundColor Green
    } else {
        Write-Host "⚠ MySQL 服务未运行，请手动启动 MySQL" -ForegroundColor Yellow
        Write-Host "  提示：可以在服务管理器中启动 MySQL 服务" -ForegroundColor Gray
    }
} catch {
    Write-Host "⚠ 未找到 MySQL 服务，请确认数据库已安装" -ForegroundColor Yellow
}

# 4. 编译项目
Write-Host "[4/5] 编译项目..." -ForegroundColor Yellow
Write-Host "  执行：mvn clean install -DskipTests" -ForegroundColor Gray

$projectPath = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $projectPath

Start-Process -FilePath "mvn" -ArgumentList "clean", "install", "-DskipTests" -Wait -NoNewWindow

if ($LASTEXITCODE -eq 0) {
    Write-Host "✓ 编译成功！" -ForegroundColor Green
} else {
    Write-Host "✗ 编译失败，请检查错误信息" -ForegroundColor Red
    Write-Host "  提示：可能是依赖下载失败，可以手动打开 IDE 导入 Maven 项目" -ForegroundColor Gray
    exit 1
}

# 5. 启动应用
Write-Host "[5/5] 启动 Spring Boot 应用..." -ForegroundColor Yellow
Write-Host ""
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   准备启动应用" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "启动命令：" -ForegroundColor Yellow
Write-Host "  mvn spring-boot:run" -ForegroundColor White
Write-Host ""
Write-Host "或者在 IDE 中运行 ReggieApplication.java 主类" -ForegroundColor White
Write-Host ""
Write-Host "启动成功后，访问地址：" -ForegroundColor Green
Write-Host "  http://localhost:8080/front/index.html" -ForegroundColor Cyan
Write-Host ""
Write-Host "下一步操作：" -ForegroundColor Yellow
Write-Host "  1. 登录系统（如果没有账号请先注册）" -ForegroundColor White
Write-Host "  2. 点击右上角用户头像进入个人中心" -ForegroundColor White
Write-Host "  3. 点击'联系客服'开始体验" -ForegroundColor White
Write-Host ""
Write-Host "测试问题推荐：" -ForegroundColor Yellow
Write-Host "  • 配送费多少钱？" -ForegroundColor White
Write-Host "  • 有什么优惠活动？" -ForegroundColor White
Write-Host "  • 推荐几个招牌菜" -ForegroundColor White
Write-Host ""
Write-Host "按任意键继续启动应用..." -ForegroundColor Gray
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

Write-Host ""
Write-Host "正在启动应用，请稍候..." -ForegroundColor Yellow
Write-Host ""

# 启动 Spring Boot 应用（后台运行）
Start-Process -FilePath "mvn" -ArgumentList "spring-boot:run" -NoNewWindow

Write-Host "✓ 应用已启动！" -ForegroundColor Green
Write-Host ""
Write-Host "查看日志输出（关闭此窗口不会停止应用）：" -ForegroundColor Yellow
Write-Host "  应用将在 http://localhost:8080 启动" -ForegroundColor Cyan
Write-Host ""
Write-Host "如需停止应用，请在任务管理器中结束 java.exe 进程" -ForegroundColor Red
Write-Host ""

# 等待 5 秒后打开浏览器
Start-Sleep -Seconds 5

Write-Host "即将打开浏览器..." -ForegroundColor Yellow
Start-Process "http://localhost:8080/front/index.html"

Write-Host ""
Write-Host "祝你使用愉快！🎉" -ForegroundColor Green
Write-Host ""
