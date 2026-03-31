import shutil
import os

# Execute logo copy
src_base = r"c:\git\cc-code-master\src\main\resources"
target_base = r"c:\git\cc-code-master\target\classes"

# Create directories if needed
os.makedirs(os.path.join(target_base, r"front\images"), exist_ok=True)
os.makedirs(os.path.join(target_base, r"backend\images\login"), exist_ok=True)

# Copy files
files = [
    (r"front\images\logo.png", r"前端logo"),
    (r"backend\images\logo.png", r"后端首页logo"),
    (r"backend\images\login\logo.png", r"后端登录页logo"),
]

for relative_path, description in files:
    src = os.path.join(src_base, relative_path)
    dst = os.path.join(target_base, relative_path)
    shutil.copy(src, dst)
    print(f"✓ {description}已复制到target")

print("\n✅ 所有logo已复制到target/classes目录！")
print("请刷新浏览器F5，就能看到新logo了！")
