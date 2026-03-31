#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re

file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

print("原始内容检查:")
if '菩提阁中餐厅' in content:
    print("✓ 找到'菩提阁中餐厅'")
    
    # 使用多个替换来处理可能的空格问题
    # 第一步：替换主要的文字部分
    content = content.replace(
        '菩提阁中餐厅是菩提阁点餐的独立的品牌，',
        '外卖系统是点餐的独立品牌，'
    )
    
    # 第二步：处理可能的空格问题
    content = re.sub(r'大众\s+化', '大众化', content)
    
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(content)
    
    print("✓ index.html介绍文字已修改完成")
else:
    print("✗ 未找到目标文字")
