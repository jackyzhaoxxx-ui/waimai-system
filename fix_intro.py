#!/usr/bin/env python
# -*- coding: utf-8 -*-

file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

# 读取文件
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 直接替换文本
old_text = '简介: 菩提阁中餐厅是菩提阁点餐的独立的品牌，定位"大众 化的美食外送餐饮"，旨为顾客打造专业美食。'
new_text = '简介: 外卖系统是点餐的独立品牌，定位"大众化的美食外送餐饮"，旨为顾客打造专业美食。'

if old_text in content:
    content = content.replace(old_text, new_text)
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(content)
    print("✓ index.html介绍文字已修改完成")
else:
    print("✗ 未找到原始文本，尝试另一种方法...")
    # 备用方案：查找并显示实际的文本
    lines = content.split('\n')
    for i, line in enumerate(lines):
        if '菩提阁中餐厅' in line:
            print(f"第 {i+1} 行找到:")
            print(repr(line))
