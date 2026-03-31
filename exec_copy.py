import os
import shutil

# Direct execution
src_base = r"c:\git\cc-code-master\src\main\resources"
target_base = r"c:\git\cc-code-master\target\classes"

print("\n" + "="*70)
print("Logo文件复制到Maven运行目录（target/classes）")
print("="*70 + "\n")

# Create directories
os.makedirs(os.path.join(target_base, r"front\images"), exist_ok=True)
os.makedirs(os.path.join(target_base, r"backend\images\login"), exist_ok=True)

# Copy front logo
src1 = os.path.join(src_base, r"front\images\logo.png")
dst1 = os.path.join(target_base, r"front\images\logo.png")
shutil.copy2(src1, dst1)
print("✓ 前端logo已复制到target")

# Copy backend home logo
src2 = os.path.join(src_base, r"backend\images\logo.png")
dst2 = os.path.join(target_base, r"backend\images\logo.png")
shutil.copy2(src2, dst2)
print("✓ 后端首页logo已复制到target")

# Copy backend login logo
src3 = os.path.join(src_base, r"backend\images\login\logo.png")
dst3 = os.path.join(target_base, r"backend\images\login\logo.png")
shutil.copy2(src3, dst3)
print("✓ 后端登录页logo已复制到target")

# Verify
print("\n" + "-"*70)
print("验证复制结果：\n")

for path, name in [(dst1, "前端logo"), (dst2, "后端首页logo"), (dst3, "后端登录页logo")]:
    if os.path.exists(path):
        size = os.path.getsize(path)
        print(f"✓ {name} - 大小: {size:,} 字节")
    else:
        print(f"✗ {name} - 文件不存在")

print("\n" + "="*70)
print("✅ 所有logo已复制到target/classes目录！")
print("   请刷新浏览器F5，就能看到新logo了！")
print("="*70 + "\n")
