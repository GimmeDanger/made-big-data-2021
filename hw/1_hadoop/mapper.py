#!/usr/bin/env python3
"""mapper.py"""

import sys

# input comes from STDIN (standard input)
# output: (ck, mk, vk), where
#         ck -- chunk size
#         mk -- chunk mean
#         vk -- chunk var
ck = 0
mk = 0
vk = 0

# tmp vars
X = 0
X_sq = 0

for num in sys.stdin:
    x = float(num)
    X += x
    X_sq += x * x
    ck += 1

# https://en.wikipedia.org/wiki/Arithmetic_mean
mk = X / ck

# https://en.wikipedia.org/wiki/Variance#Sample_variance
vk = X_sq / ck - mk ** 2

print("{}\t{}\t{}".format(ck, mk, vk))
