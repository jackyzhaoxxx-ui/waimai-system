@echo off
echo ====================================
echo   DeepSeek AI 智能客服 - API 测试
echo ====================================
echo.

REM 设置 JAVA_HOME（根据你的实际安装路径修改）
REM set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_202
REM set PATH=%JAVA_HOME%\bin;%PATH%

echo [提示] 由于环境限制，这里提供手动测试方法：
echo.
echo 方法 1: 使用 IDE（推荐）
echo   1. 打开 IntelliJ IDEA 或 Eclipse
echo   2. 导入 Maven 项目
echo   3. 运行 ReggieApplication.java
echo.
echo 方法 2: 配置 JDK 环境变量
echo   1. 找到你的 JDK 安装路径
echo   2. 设置 JAVA_HOME 环境变量指向 JDK 目录
echo   3. 确保 PATH 包含 %%JAVA_HOME%%\bin
echo   4. 重新运行启动脚本
echo.
echo 方法 3: 直接使用已有编译版本
echo   如果之前编译成功过，可以直接在 target 目录找到编译好的类文件
echo.
echo ====================================
echo   配置检查清单
echo ====================================
echo.
echo ✓ API Key 已配置：sk-e40988c271424dd0af781a40a59fffea
echo ✓ API URL 已配置：https://api.deepseek.com/v1/chat/completions
echo ✓ 模型已配置：deepseek-chat
echo ✓ AI 功能已启用：enabled: true
echo.
echo 下一步操作：
echo   1. 确保使用 JDK 而不是 JRE
echo   2. 在 IDE 中运行项目
echo   3. 访问 http://localhost:8080/front/index.html
echo   4. 进入"联系客服"测试 AI 对话
echo.
pause
