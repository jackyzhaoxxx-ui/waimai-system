import sys

file_path = r"c:\git\cc-code-master\src\main\resources\front\index.html"

with open(file_path, 'rb') as f:
    content = f.read()

# 查找第40行
lines = content.split(b'\n')
for i, line in enumerate(lines):
    if b'\xe8\x8f\xa9\xe6\x8f\x90\xe9\x98\x81' in line:  # "菩提阁" 的UTF-8编码
        print(f"Line {i+1}:")
        print(repr(line))
        print(f"Hex: {line.hex()}")
        break
