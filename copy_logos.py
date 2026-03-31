import shutil
import os

src_base = r"c:\git\cc-code-master\src\main\resources"
target_base = r"c:\git\cc-code-master\target\classes"

# 前端logo
shutil.copy(
    os.path.join(src_base, r"front\images\logo.png"),
    os.path.join(target_base, r"front\images\logo.png")
)
print("✓ 前端logo已复制到target")

# 后端首页logo
shutil.copy(
    os.path.join(src_base, r"backend\images\logo.png"),
    os.path.join(target_base, r"backend\images\logo.png")
)
print("✓ 后端首页logo已复制到target")

# 后端登录页logo
shutil.copy(
    os.path.join(src_base, r"backend\images\login\logo.png"),
    os.path.join(target_base, r"backend\images\login\logo.png")
)
print("✓ 后端登录页logo已复制到target")

print("\n✅ 所有logo已复制到target/classes目录！")
print("请刷新浏览器F5，就能看到新logo了！")
