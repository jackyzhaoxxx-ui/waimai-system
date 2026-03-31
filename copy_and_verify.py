#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import os
import shutil
import hashlib

def get_file_hash(filepath):
    """计算文件MD5哈希"""
    if not os.path.exists(filepath):
        return None
    with open(filepath, 'rb') as f:
        return hashlib.md5(f.read()).hexdigest()

def copy_and_verify():
    """复制并验证logo文件"""
    src_base = r"c:\git\cc-code-master\src\main\resources"
    target_base = r"c:\git\cc-code-master\target\classes"
    
    files = [
        (r"front\images\logo.png", "前端logo"),
        (r"backend\images\logo.png", "后端首页logo"),
        (r"backend\images\login\logo.png", "后端登录页logo"),
    ]
    
    print("="*70)
    print("开始复制Logo文件到Maven运行目录")
    print("="*70)
    
    all_success = True
    
    for relative_path, description in files:
        src = os.path.join(src_base, relative_path)
        dst = os.path.join(target_base, relative_path)
        
        # 确保目标目录存在
        dst_dir = os.path.dirname(dst)
        os.makedirs(dst_dir, exist_ok=True)
        
        print(f"\n处理: {description}")
        print(f"  源: {src}")
        print(f"  目: {dst}")
        
        if not os.path.exists(src):
            print(f"  ❌ 错误: 源文件不存在")
            all_success = False
            continue
        
        try:
            # 复制文件
            shutil.copy2(src, dst)
            print(f"  ✓ 文件已复制")
            
            # 验证
            src_hash = get_file_hash(src)
            dst_hash = get_file_hash(dst)
            
            if src_hash == dst_hash:
                print(f"  ✓ 验证通过 (哈希: {src_hash[:16]}...)")
            else:
                print(f"  ❌ 验证失败: 哈希不匹配")
                all_success = False
                
        except Exception as e:
            print(f"  ❌ 复制失败: {str(e)}")
            all_success = False
    
    print("\n" + "="*70)
    if all_success:
        print("✅ 所有logo已成功复制到target/classes目录！")
        print("   请刷新浏览器F5，就能看到新logo了！")
    else:
        print("❌ 复制过程中出现错误")
    print("="*70)
    
    return all_success

if __name__ == "__main__":
    import sys
    success = copy_and_verify()
    sys.exit(0 if success else 1)
