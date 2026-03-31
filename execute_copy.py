#!/usr/bin/env python3
import shutil
import os
import sys

try:
    src_base = r"c:\git\cc-code-master\src\main\resources"
    target_base = r"c:\git\cc-code-master\target\classes"

    # 前端logo
    src1 = os.path.join(src_base, r"front\images\logo.png")
    dst1 = os.path.join(target_base, r"front\images\logo.png")
    
    # 后端首页logo
    src2 = os.path.join(src_base, r"backend\images\logo.png")
    dst2 = os.path.join(target_base, r"backend\images\logo.png")
    
    # 后端登录页logo
    src3 = os.path.join(src_base, r"backend\images\login\logo.png")
    dst3 = os.path.join(target_base, r"backend\images\login\logo.png")

    # 检查源文件是否存在
    print("检查源文件...")
    for src in [src1, src2, src3]:
        if os.path.exists(src):
            print(f"  ✓ 源文件存在: {src}")
        else:
            print(f"  ✗ 源文件不存在: {src}")
            sys.exit(1)

    # 创建目标目录
    print("\n创建目标目录...")
    for dst in [dst1, dst2, dst3]:
        dst_dir = os.path.dirname(dst)
        os.makedirs(dst_dir, exist_ok=True)
        print(f"  ✓ 目录已准备: {dst_dir}")

    # 复制文件
    print("\n复制文件...")
    shutil.copy(src1, dst1)
    print("  ✓ 前端logo已复制到target")

    shutil.copy(src2, dst2)
    print("  ✓ 后端首页logo已复制到target")

    shutil.copy(src3, dst3)
    print("  ✓ 后端登录页logo已复制到target")

    # 验证复制
    print("\n验证复制结果...")
    for dst in [dst1, dst2, dst3]:
        if os.path.exists(dst):
            size = os.path.getsize(dst)
            print(f"  ✓ 文件存在且大小为: {size} 字节 - {dst}")
        else:
            print(f"  ✗ 文件验证失败: {dst}")
            sys.exit(1)

    print("\n✅ 所有logo已成功复制到target/classes目录！")
    print("请刷新浏览器F5，就能看到新logo了！")
    
except Exception as e:
    print(f"\n❌ 错误: {str(e)}")
    import traceback
    traceback.print_exc()
    sys.exit(1)
