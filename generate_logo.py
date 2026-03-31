from PIL import Image, ImageDraw, ImageFont
import os

base_path = r"c:\git\cc-code-master\src\main\resources"

# 前端logo - 200x200圆形
img1 = Image.new('RGB', (200, 200), color='white')
draw1 = ImageDraw.Draw(img1)
draw1.ellipse([10, 10, 190, 190], fill='#FF6B35', outline='#333333', width=2)

try:
    font_large = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 28)
    font_small = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 12)
except:
    font_large = ImageFont.load_default()
    font_small = ImageFont.load_default()

draw1.text((60, 55), "AKA", fill='white', font=font_large)
draw1.text((70, 115), "外卖", fill='white', font=font_small)
img1.save(os.path.join(base_path, r"front\images\logo.png"))
print("前端logo已生成")

# 后端首页logo - 240x80条形
img2 = Image.new('RGB', (240, 80), color='white')
draw2 = ImageDraw.Draw(img2)
draw2.rectangle([0, 0, 240, 80], fill='#2C3E50')
draw2.text((15, 15), "AKA", fill='#FF6B35', font=font_large)
draw2.text((110, 35), "外卖管理系统", fill='white', font=font_small)
img2.save(os.path.join(base_path, r"backend\images\logo.png"))
print("后端首页logo已生成")

# 后端登录页logo - 280x84
img3 = Image.new('RGB', (280, 84), color='white')
draw3 = ImageDraw.Draw(img3)
draw3.rectangle([0, 0, 280, 84], fill='#FF6B35')
draw3.text((30, 8), "AKA外卖", fill='white', font=font_large)
draw3.text((100, 50), "管理系统", fill='white', font=font_small)
img3.save(os.path.join(base_path, r"backend\images\login\logo.png"))
print("后端登录页logo已生成")

print("\n✅ 所有logo已成功生成！")
