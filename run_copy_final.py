#!/usr/bin/env python3
import os
import shutil
import sys
from datetime import datetime

def execute_copy():
    src_base = r"c:\git\cc-code-master\src\main\resources"
    target_base = r"c:\git\cc-code-master\target\classes"
    
    files = [
        (r"front\images\logo.png", "前端logo"),
        (r"backend\images\logo.png", "后端首页logo"),
        (r"backend\images\login\logo.png", "后端登录页logo"),
    ]
    
    print("\n" + "="*80)
    print(" Logo文件复制到Maven运行目录（target/classes）")
    print("="*80 + "\n")
    
    success_count = 0
    
    for relative_path, description in files:
        src = os.path.join(src_base, relative_path)
        dst = os.path.join(target_base, relative_path)
        dst_dir = os.path.dirname(dst)
        
        try:
            # Create target directory
            os.makedirs(dst_dir, exist_ok=True)
            
            # Check source exists
            if not os.path.exists(src):
                print(f"✗ {description} - 源文件不存在: {src}")
                continue
            
            # Copy file
            shutil.copy2(src, dst)
            
            # Verify
            if os.path.exists(dst):
                src_size = os.path.getsize(src)
                dst_size = os.path.getsize(dst)
                mtime = datetime.fromtimestamp(os.path.getmtime(dst))
                
                if src_size == dst_size:
                    print(f"✓ {description}")
                    print(f"  源: {src}")
                    print(f"  目: {dst}")
                    print(f"  大小: {src_size:,} 字节 | 时间: {mtime}")
                    success_count += 1
                else:
                    print(f"✗ {description} - 文件大小不匹配")
            else:
                print(f"✗ {description} - 目标文件不存在")
                
        except Exception as e:
            print(f"✗ {description} - 错误: {str(e)}")
    
    print("\n" + "="*80)
    if success_count == len(files):
        print("✅ 所有logo已成功复制到target/classes目录！")
        print("   请刷新浏览器F5，就能看到新logo了！")
        return True
    else:
        print(f"⚠️  仅有 {success_count}/{len(files)} 个文件成功复制")
        return False
    print("="*80 + "\n")

if __name__ == "__main__":
    success = execute_copy()
    sys.exit(0 if success else 1)
