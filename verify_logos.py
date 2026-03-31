import os
import hashlib

def get_file_info(path):
    """获取文件信息"""
    if os.path.exists(path):
        size = os.path.getsize(path)
        with open(path, 'rb') as f:
            md5_hash = hashlib.md5(f.read()).hexdigest()
        return size, md5_hash
    return None, None

src_base = r"c:\git\cc-code-master\src\main\resources"
target_base = r"c:\git\cc-code-master\target\classes"

files = [
    (r"front\images\logo.png", r"前端logo"),
    (r"backend\images\logo.png", r"后端首页logo"),
    (r"backend\images\login\logo.png", r"后端登录页logo"),
]

print("=" * 60)
print("Logo文件验证报告")
print("=" * 60)

all_valid = True

for relative_path, description in files:
    src = os.path.join(src_base, relative_path)
    dst = os.path.join(target_base, relative_path)
    
    src_size, src_md5 = get_file_info(src)
    dst_size, dst_md5 = get_file_info(dst)
    
    print(f"\n{description}:")
    print(f"  源文件: {src}")
    if src_size:
        print(f"    ✓ 存在，大小: {src_size} 字节，MD5: {src_md5}")
    else:
        print(f"    ✗ 不存在")
        all_valid = False
    
    print(f"  目标文件: {dst}")
    if dst_size:
        print(f"    ✓ 存在，大小: {dst_size} 字节，MD5: {dst_md5}")
    else:
        print(f"    ✗ 不存在")
        all_valid = False
    
    if src_size and dst_size and src_md5 == dst_md5:
        print(f"    ✅ 验证通过：源文件和目标文件相同")
    elif src_size and dst_size:
        print(f"    ⚠️  文件内容不同，需要复制")
        all_valid = False

print("\n" + "=" * 60)
if all_valid and src_md5 and dst_md5 and src_md5 == dst_md5:
    print("✅ 所有logo文件已成功复制到target/classes目录！")
    print("请刷新浏览器F5，就能看到新logo了！")
else:
    print("⚠️  需要执行复制操作")
print("=" * 60)
