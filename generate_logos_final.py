#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import sys
import os

try:
    from PIL import Image, ImageDraw, ImageFont
    print("[INFO] PIL library loaded successfully")
except ImportError as e:
    print(f"[ERROR] Failed to import PIL: {e}")
    sys.exit(1)

base_path = r"c:\git\cc-code-master\src\main\resources"

# Ensure directories exist
os.makedirs(os.path.join(base_path, r"front\images"), exist_ok=True)
os.makedirs(os.path.join(base_path, r"backend\images\login"), exist_ok=True)
print("[INFO] Directories created")

# Front logo - 200x200 circle
try:
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
    
    path1 = os.path.join(base_path, r"front\images\logo.png")
    img1.save(path1)
    print(f"[SUCCESS] Front logo generated: {path1}")
except Exception as e:
    print(f"[ERROR] Failed to generate front logo: {e}")

# Backend home page logo - 240x80
try:
    img2 = Image.new('RGB', (240, 80), color='white')
    draw2 = ImageDraw.Draw(img2)
    draw2.rectangle([0, 0, 240, 80], fill='#2C3E50')
    
    try:
        font_large = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 28)
        font_small = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 12)
    except:
        font_large = ImageFont.load_default()
        font_small = ImageFont.load_default()
    
    draw2.text((15, 15), "AKA", fill='#FF6B35', font=font_large)
    draw2.text((110, 35), "外卖管理系统", fill='white', font=font_small)
    
    path2 = os.path.join(base_path, r"backend\images\logo.png")
    img2.save(path2)
    print(f"[SUCCESS] Backend logo generated: {path2}")
except Exception as e:
    print(f"[ERROR] Failed to generate backend logo: {e}")

# Backend login page logo - 280x84
try:
    img3 = Image.new('RGB', (280, 84), color='white')
    draw3 = ImageDraw.Draw(img3)
    draw3.rectangle([0, 0, 280, 84], fill='#FF6B35')
    
    try:
        font_large = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 28)
        font_small = ImageFont.truetype("C:\\Windows\\Fonts\\simhei.ttf", 12)
    except:
        font_large = ImageFont.load_default()
        font_small = ImageFont.load_default()
    
    draw3.text((30, 8), "AKA外卖", fill='white', font=font_large)
    draw3.text((100, 50), "管理系统", fill='white', font=font_small)
    
    path3 = os.path.join(base_path, r"backend\images\login\logo.png")
    img3.save(path3)
    print(f"[SUCCESS] Login logo generated: {path3}")
except Exception as e:
    print(f"[ERROR] Failed to generate login logo: {e}")

print("\n[INFO] Verification:")
if os.path.exists(os.path.join(base_path, r"front\images\logo.png")):
    print("✓ Front logo exists")
else:
    print("✗ Front logo not found")

if os.path.exists(os.path.join(base_path, r"backend\images\logo.png")):
    print("✓ Backend logo exists")
else:
    print("✗ Backend logo not found")

if os.path.exists(os.path.join(base_path, r"backend\images\login\logo.png")):
    print("✓ Login logo exists")
else:
    print("✗ Login logo not found")

print("\n✅ Logo generation completed!")
