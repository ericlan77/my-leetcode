# python 根据 key，value 排序字典
from collections import OrderedDict

d = {'d': 4, 'a': 1, 'b': 2, 'c': 3}
# dict sort by **key** and reverse
print(dict(sorted(d.items()))) # {'a': 1, 'b': 2, 'c': 3, 'd': 4}
d = dict(sorted(d.items(), reverse=True))  # {'d': 4, 'c': 3, 'b': 2, 'a': 1}
print(d)

# dict sort by **value** and reverse
dict(sorted(d.items(), key=lambda kv: kv[1]))  # {'a': 1, 'b': 2, 'c': 3, 'd': 4}
dict(sorted(d.items(), key=lambda kv: kv[1], reverse=True))  # {'d': 4, 'c': 3, 'b': 2, 'a': 1}

# 获取字典对应的最大值对应的 key,value
mydict = {'A': 4, 'B': 10, 'C': 0, 'D': 87}
maximum = max(mydict, key=mydict.get)  # Just use 'min' instead of 'max' for minimum.
maxk, maxv = maximum, mydict[maximum]
# 或者
maxk, maxv = max(mydict.items(), key=lambda k: k[1])

# 支持默认值的有序字典 (OrderedDict and defaultdict)  (注意是 key 插入顺序不是字典序)
# https://stackoverflow.com/questions/6190331/how-to-implement-an-ordered-default-dict
od = OrderedDict()  # collections.OrderedDict()
od[0] = 1
od[0] = od.get(0, 0) + 1  # 间接实现了 defaultdict(int) ，同时保持了插入字典的 key 顺序
