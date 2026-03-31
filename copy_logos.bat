@echo off
REM Copy logo files to Maven target directory

echo Copying logo files...

REM Create target directories if they don't exist
if not exist "target\classes\front\images" mkdir "target\classes\front\images"
if not exist "target\classes\backend\images\login" mkdir "target\classes\backend\images\login"

REM Copy front logo
copy "src\main\resources\front\images\logo.png" "target\classes\front\images\logo.png"
echo ✓ 前端logo已复制到target

REM Copy backend home page logo
copy "src\main\resources\backend\images\logo.png" "target\classes\backend\images\logo.png"
echo ✓ 后端首页logo已复制到target

REM Copy backend login page logo
copy "src\main\resources\backend\images\login\logo.png" "target\classes\backend\images\login\logo.png"
echo ✓ 后端登录页logo已复制到target

echo.
echo ✅ 所有logo已复制到target/classes目录！
echo 请刷新浏览器F5，就能看到新logo了！
