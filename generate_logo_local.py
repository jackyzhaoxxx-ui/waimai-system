#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from PIL import Image, ImageDraw, ImageFont
import os

# 创建logo - 前端首页用（小尺寸，圆形）
def create_front_logo():
    """创建前端首页logo - 小尺寸圆形"""
    width, height = 200, 200
    img = Image.new('RGB', (width, height), color='white')
    draw = ImageDraw.Draw(img)
    
    # 绘制圆形背景
    draw.ellipse([10, 10, 190, 190], fill='#FF6B35', outline='#333333', width=2)
    
    # 添加文字
    try:
        font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 28)
    except:
        font = ImageFont.load_default()
    
    text = "AKA"
    bbox = draw.textbbox((0, 0), text, font=font)
    text_width = bbox[2] - bbox[0]
    text_height = bbox[3] - bbox[1]
    x = (width - text_width) // 2
    y = (height - text_height) // 2 - 20
    
    draw.text((x, y), text, fill='white', font=font)
    
    # 添加小字
    try:
        small_font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 12)
    except:
        small_font = ImageFont.load_default()
    
    small_text = "外卖"
    bbox2 = draw.textbbox((0, 0), small_text, font=small_font)
    text_width2 = bbox2[2] - bbox2[0]
    x2 = (width - text_width2) // 2
    y2 = y + 40
    
    draw.text((x2, y2), small_text, fill='white', font=small_font)
    
    return img

# 创建logo - 后端首页用（条形logo）
def create_backend_logo():
    """创建后端首页logo - 条形"""
    width, height = 240, 80
    img = Image.new('RGB', (width, height), color='white')
    draw = ImageDraw.Draw(img)
    
    # 绘制背景
    draw.rectangle([0, 0, width, height], fill='#2C3E50')
    
    # 添加文字
    try:
        font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 32)
        small_font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 14)
    except:
        font = ImageFont.load_default()
        small_font = ImageFont.load_default()
    
    text = "AKA"
    bbox = draw.textbbox((0, 0), text, font=font)
    text_width = bbox[2] - bbox[0]
    x = 15
    y = (height - (bbox[3] - bbox[1])) // 2 - 5
    
    draw.text((x, y), text, fill='#FF6B35', font=font)
    
    # 添加描述文字
    desc_text = "外卖管理系统"
    bbox2 = draw.textbbox((0, 0), desc_text, font=small_font)
    x2 = x + text_width + 10
    y2 = y + 15
    
    draw.text((x2, y2), desc_text, fill='white', font=small_font)
    
    return img

# 创建logo - 登录页用（正方形logo）
def create_login_logo():
    """创建后端登录页logo"""
    width, height = 280, 84
    img = Image.new('RGB', (width, height), color='white')
    draw = ImageDraw.Draw(img)
    
    # 绘制背景圆角矩形效果
    draw.rectangle([0, 0, width, height], fill='#FF6B35')
    
    try:
        font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 36)
        small_font = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 16)
    except:
        font = ImageFont.load_default()
        small_font = ImageFont.load_default()
    
    # 主文字
    text = "AKA外卖"
    bbox = draw.textbbox((0, 0), text, font=font)
    text_width = bbox[2] - bbox[0]
    x = (width - text_width) // 2
    y = 10
    
    draw.text((x, y), text, fill='white', font=font)
    
    # 副标题
    desc = "管理系统"
    bbox2 = draw.textbbox((0, 0), desc, font=small_font)
    text_width2 = bbox2[2] - bbox2[0]
    x2 = (width - text_width2) // 2
    y2 = 50
    
    draw.text((x2, y2), desc, fill='white', font=small_font)
    
    return img

# 保存到指定位置
def main():
    base_path = r"c:\git\cc-code-master\src\main\resources"
    
    # 确保目录存在
    os.makedirs(os.path.join(base_path, r"front\images"), exist_ok=True)
    os.makedirs(os.path.join(base_path, r"backend\images\login"), exist_ok=True)
    
    # 前端logo
    front_logo = create_front_logo()
    front_path = os.path.join(base_path, r"front\images\logo.png")
    front_logo.save(front_path)
    print(f"✓ 已生成前端logo: {front_path}")
    
    # 后端首页logo
    backend_logo = create_backend_logo()
    backend_path = os.path.join(base_path, r"backend\images\logo.png")
    backend_logo.save(backend_path)
    print(f"✓ 已生成后端首页logo: {backend_path}")
    
    # 后端登录页logo
    login_logo = create_login_logo()
    login_path = os.path.join(base_path, r"backend\images\login\logo.png")
    login_logo.save(login_path)
    print(f"✓ 已生成后端登录页logo: {login_path}")
    
    print("\n所有logo已生成完成！")

if __name__ == "__main__":
    main()
