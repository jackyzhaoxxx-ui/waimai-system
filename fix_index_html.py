#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import re

file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

# 读取文件内容
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 打印原始内容中的部分（调试）
print("=== 原始文件内容 ===")
if '菩提阁中餐厅是菩提阁点餐的独立的品牌' in content:
    print("✓ 找到搜索字符串1")
else:
    print("✗ 未找到搜索字符串1")

# 替换1：将"菩提阁中餐厅是菩提阁点餐的独立的品牌"替换为"外卖系统是点餐的独立品牌"
content = content.replace('菩提阁中餐厅是菩提阁点餐的独立的品牌', '外卖系统是点餐的独立品牌')
print("✓ 已替换文本1")

# 替换2：将"大众 化"（含任意空格）替换为"大众化"
# 使用正则表达式处理任意空白字符
content = re.sub(r'大众\s+化', '大众化', content)
print("✓ 已处理空格")

# 写回文件
with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("✓ 文件已成功修改！")

# 验证修改
print("\n=== 验证修改 ===")
with open(file_path, 'r', encoding='utf-8') as f:
    verify_content = f.read()
    
if '外卖系统是点餐的独立品牌' in verify_content:
    print("✓ 修改1已验证：找到新文本")
else:
    print("✗ 修改1未成功")
    
if '菩提阁中餐厅' not in verify_content:
    print("✓ 修改1已验证：旧文本已删除")
else:
    print("✗ 旧文本仍然存在")

if '大众化的美食' in verify_content and '大众 化' not in verify_content:
    print("✓ 修改2已验证：空格已处理")
else:
    print("✗ 修改2未成功")

print("\n✓ 所有修改已完成！")
