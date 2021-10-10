#!/usr/bin/env python
"""reducer.py"""

import sys

# input comes from STDIN (standard input)

# input: (ck mk vk), where
#         ck -- chunk size
#         mk -- chunk mean
#         vk -- chunk var
#         \t -- separator

# output: (c, m, v), where
#         c - size
#         m - mean
#         v - var

c = 0
m = 0
v = 0

for line in sys.stdin:
    ck, mk, vk = line.split('\t', 2)
    ck = float(ck)
    mk = float(mk)
    vk = float(vk)
    v = (c * v + ck * vk) / (c + ck) + c * ck * ((m - mk) / (c + ck)) ** 2
    m = (c * m + ck * mk) / (c + ck)
    c = c + ck

print(f'{c}\t{m}\t{v}')
