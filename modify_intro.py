import re

file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 使用正则表达式替换介绍文字，处理可能的特殊空格
content = re.sub(
    r'简介: 菩提阁中餐厅是菩提阁点餐的独立的品牌，定位"大众\s*化的美食外送餐饮"，旨为顾客打造专业美食。',
    '简介: 外卖系统是点餐的独立品牌，定位"大众化的美食外送餐饮"，旨为顾客打造专业美食。',
    content
)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("✓ index.html介绍文字已修改完成")
