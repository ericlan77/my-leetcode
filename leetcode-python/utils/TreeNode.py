"""
二叉树调试函数
"""


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return f"TreeNode({self.val}) [left->{self.left} right->{self.right}]"


def gen_tree_from_input(vals_str: str):
    """
    input: [1,2,3]
    output: generate a tree and return root node
    In Leetcode, the input may contains "null" which is "None" in python
    """
    import ast
    valids = vals_str.replace("null", "None")
    vals = ast.literal_eval(valids)
    root = gen_tree(vals)
    return root


def to_lc_tree_str(root):  # root TreeNode -> [1,2,3,null]
    """返回层序序列化后的树字符串，可以和 leetcode 输出结果比对字符串"""
    import json
    if not root:
        return '[]'
    curnodes = [root]
    res = [root.val]
    while curnodes:
        nextnodes = []
        for node in curnodes:
            if node:
                if node.left:
                    nextnodes.append(node.left)
                    res.append(node.left.val)
                else:
                    nextnodes.append(None)
                    res.append(None)
                if node.right:
                    nextnodes.append(node.right)
                    res.append(node.right.val)
                else:
                    nextnodes.append(None)
                    res.append(None)
        curnodes = nextnodes

    while res[-1] is None:  # 最后空节点去掉
        res.pop()
    s = json.dumps(res)
    s = s.replace(" ", "")
    return s


def gen_tree(vals):
    """
    根据层序遍历结果生成二叉树并且返回 root。
    把题目中输入 null 换成 None
    vals = [1,2,3,None,5]
    """
    if not vals:
        return None
    nodemap = {}
    for i in range(len(vals)):
        if vals[i]:
            nodemap[i] = TreeNode(vals[i])
        else:
            nodemap[i] = None

    root = nodemap[0]
    for i in range(len(vals)):
        l = 2 * i + 1
        r = 2 * i + 2
        cur = nodemap.get(i, None)
        left = nodemap.get(l, None)
        right = nodemap.get(r, None)
        if cur:
            cur.left = left
            cur.right = right
    return root


root = gen_tree_from_input("[1,2,3,4,5]")
print(root)
