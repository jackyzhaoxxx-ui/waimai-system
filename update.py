# encoding: utf-8
with open(r'c:\git\cc-code-master\src\main\resources\front\index.html', 'r', encoding='utf-8') as f:
    lines = f.readlines()

# 找到包含"菩提阁中餐厅"的行并修改
for i, line in enumerate(lines):
    if '菩提阁中餐厅' in line:
        lines[i] = line.replace('菩提阁中餐厅是菩提阁点餐的独立的品牌', '外卖系统是点餐的独立品牌')
        lines[i] = lines[i].replace('大众 化', '大众化')
        print(f"已修改第 {i+1} 行")

with open(r'c:\git\cc-code-master\src\main\resources\front\index.html', 'w', encoding='utf-8') as f:
    f.writelines(lines)

print("✓ index.html介绍文字已修改完成")
