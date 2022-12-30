# 排序嵌套 list
l = [('a', 1), ('c', 2), ('b',3)]
sorted(l, key=lambda p:p[0]) # 根据第1个值排序，[('a', 1), ('b', 3), ('c', 2)]
sorted(l, key=lambda p:p[1]) # 根据第2个值排序，[('a', 1), ('c', 2), ('b', 3)]
print(l)

# 同时获取最大值的下标和值
l = [1,2,5,4,3]
maxi, maxval = max(enumerate(l), key=lambda iv: iv[1]) # 2, 5
print(maxi, maxval)

# python3 排序list自定义函数(python2 直接用 cmp 参数， python3 需要用 cmp_to_key 转成 key 参数)
from functools import cmp_to_key
nums = [3,2,1,4,5]
sorted(nums, key=cmp_to_key(lambda a,b: a-b) ) # [1 ,2 ,3, 4, 5]
sorted(nums, key=cmp_to_key(lambda a,b: b-a) ) # [5, 4, 3, 2, 1]

# 一行代码判断列表是否有序
issorted = all(l[i] <= l[i+1] for i in range(len(l) - 1))

# python3 一行代码求前缀和
from itertools import accumulate
presums = list(accumulate([1,2,3])) # [1, 3, 6]

# 一行代码求矩阵元素总和 https://stackoverflow.com/questions/10713150/how-to-sum-a-2d-array-in-python
matrix = [[1,2],[3,4]]
allsum = sum(map(sum, matrix)) # 或者 allsum = sum((sum(row) for row in matrix))