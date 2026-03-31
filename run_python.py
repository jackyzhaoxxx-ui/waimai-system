#!/usr/bin/env python3
import subprocess
import sys
import os

os.chdir(r"c:\git\cc-code-master")
result = subprocess.run([sys.executable, "copy_logos.py"], capture_output=True, text=True)
print(result.stdout)
if result.stderr:
    print("STDERR:", result.stderr)
print(f"Return code: {result.returncode}")
