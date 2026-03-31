file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

with open(file_path, 'rb') as f:
    data = f.read()

# 查找"菩提阁中餐厅"的UTF-8字节序列
search_bytes = '菩提阁中餐厅是菩提阁点餐的独立的品牌'.encode('utf-8')
replace_bytes = '外卖系统是点餐的独立品牌'.encode('utf-8')

if search_bytes in data:
    data = data.replace(search_bytes, replace_bytes)
    print("✓ 已替换主文本")
else:
    print("✗ 未找到搜索字节")

# 处理"大众 化"的情况 - 寻找"大众"后跟任意空白然后"化"
import re
pattern = '大众\s+化'.encode('utf-8')
replace = '大众化'.encode('utf-8')
data = re.sub(pattern, replace, data)
print("✓ 已处理空格")

with open(file_path, 'wb') as f:
    f.write(data)

print("✓ index.html介绍文字已修改完成")
