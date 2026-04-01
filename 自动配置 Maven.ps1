# 自动下载并配置 Maven 的脚本
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   自动下载并配置 Maven" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""

# 1. 下载 Maven
Write-Host "[1/4] 正在下载 Maven 3.9.6..." -ForegroundColor Yellow

$downloadUrl = "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
$mavenZipPath = "$env:TEMP\apache-maven-3.9.6-bin.zip"
$mavenInstallPath = "C:\Program Files\Apache\maven"

try {
    # 下载 Maven
    Invoke-WebRequest -Uri $downloadUrl -OutFile $mavenZipPath
    Write-Host "✓ Maven 下载完成" -ForegroundColor Green
} catch {
    Write-Host "✗ 下载失败，请检查网络连接" -ForegroundColor Red
    Write-Host "  可以手动下载：$downloadUrl" -ForegroundColor Gray
    exit 1
}

# 2. 解压 Maven
Write-Host "[2/4] 正在解压 Maven..." -ForegroundColor Yellow

try {
    # 创建安装目录
    if (-not (Test-Path $mavenInstallPath)) {
        New-Item -ItemType Directory -Path $mavenInstallPath | Out-Null
    }
    
    # 解压文件
    Expand-Archive -Path $mavenZipPath -DestinationPath $mavenInstallPath -Force
    Write-Host "✓ Maven 解压完成" -ForegroundColor Green
} catch {
    Write-Host "✗ 解压失败" -ForegroundColor Red
    exit 1
}

# 3. 配置环境变量
Write-Host "[3/4] 正在配置环境变量..." -ForegroundColor Yellow

$mavenBinPath = "$mavenInstallPath\apache-maven-3.9.6\bin"

try {
    # 获取当前 PATH 环境变量
    $currentPath = [Environment]::GetEnvironmentVariable("Path", "User")
    
    # 检查是否已存在
    if ($currentPath -notlike "*$mavenBinPath*") {
        # 添加 Maven 到 PATH
        $newPath = $currentPath + ";" + $mavenBinPath
        [Environment]::SetEnvironmentVariable("Path", $newPath, "User")
        Write-Host "✓ 环境变量配置完成" -ForegroundColor Green
    } else {
        Write-Host "✓ Maven 已在环境变量中" -ForegroundColor Green
    }
} catch {
    Write-Host "✗ 环境变量配置失败" -ForegroundColor Red
    Write-Host "  请手动将以下路径添加到系统 PATH 环境变量：" -ForegroundColor Gray
    Write-Host "  $mavenBinPath" -ForegroundColor Gray
    exit 1
}

# 4. 验证安装
Write-Host "[4/4] 验证 Maven 安装..." -ForegroundColor Yellow

try {
    # 重新加载环境变量
    $env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")
    
    # 验证 Maven
    $mvnVersion = & "$mavenBinPath\mvn.cmd" -version 2>&1 | Select-Object -First 1
    Write-Host "✓ Maven 安装成功！" -ForegroundColor Green
    Write-Host "  $mvnVersion" -ForegroundColor Cyan
} catch {
    Write-Host "✗ 验证失败" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "   Maven 配置完成！" -ForegroundColor Green
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "下一步操作：" -ForegroundColor Yellow
Write-Host "  1. 关闭当前 PowerShell 窗口" -ForegroundColor White
Write-Host "  2. 重新打开 PowerShell" -ForegroundColor White
Write-Host "  3. 执行：mvn spring-boot:run" -ForegroundColor White
Write-Host ""
Write-Host "或者在 IDE 中直接运行 ReggieApplication.java" -ForegroundColor White
Write-Host ""
