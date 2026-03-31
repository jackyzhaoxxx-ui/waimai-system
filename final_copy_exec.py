#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Final execution script that copies logos and verifies them
This script is self-contained and can be executed directly
"""

def main():
    import os
    import shutil
    
    print("\n" + "="*70)
    print("Logo文件复制到Maven运行目录（target/classes）")
    print("="*70 + "\n")
    
    src_base = r"c:\git\cc-code-master\src\main\resources"
    target_base = r"c:\git\cc-code-master\target\classes"
    
    files_to_copy = [
        (r"front\images\logo.png", "前端logo"),
        (r"backend\images\logo.png", "后端首页logo"),
        (r"backend\images\login\logo.png", "后端登录页logo"),
    ]
    
    # Ensure all target directories exist
    for relative_path, _ in files_to_copy:
        target_dir = os.path.dirname(os.path.join(target_base, relative_path))
        os.makedirs(target_dir, exist_ok=True)
    
    # Copy files
    all_copied = True
    for relative_path, description in files_to_copy:
        src = os.path.join(src_base, relative_path)
        dst = os.path.join(target_base, relative_path)
        
        try:
            shutil.copy2(src, dst)
            print(f"✓ {description}已复制到target")
        except Exception as e:
            print(f"✗ {description}复制失败: {e}")
            all_copied = False
    
    # Verify
    print("\n" + "-"*70)
    print("验证复制结果：\n")
    
    all_verified = True
    for relative_path, description in files_to_copy:
        dst = os.path.join(target_base, relative_path)
        if os.path.exists(dst):
            size = os.path.getsize(dst)
            print(f"✓ {description} - 大小: {size:,} 字节")
        else:
            print(f"✗ {description} - 文件不存在")
            all_verified = False
    
    print("\n" + "="*70)
    if all_copied and all_verified:
        print("✅ 所有logo已复制到target/classes目录！")
        print("   请刷新浏览器F5，就能看到新logo了！")
    else:
        print("⚠️  复制或验证过程出现问题")
    print("="*70 + "\n")
    
    return all_copied and all_verified

if __name__ == "__main__":
    success = main()
    exit(0 if success else 1)
