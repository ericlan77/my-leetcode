class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"Node({self.val})"

    __repr__ = __str__


N = Node = ListNode


def to_list(head: ListNode) -> ListNode:
    """
    transfer linkedlist to int[]
    """
    res = []
    cur_node = head
    while cur_node:
        res.append(cur_node.val)
        cur_node = cur_node.next
    return res


def gen_list(nums: list[int]) -> ListNode:
    """
    transfer int[] to linkedlist
    """
    if not nums:
        return ListNode()
    head = ListNode(nums[0])
    pre = head
    for i in range(1, len(nums)):
        node = ListNode(nums[i])
        pre.next = node
        pre = node
    return head


def print_list(head: ListNode):
    cur = head
    res = ""
    while cur:
        res += f"{cur.val}->"
        cur = cur.next
    res += "nil"
    print(res)


if __name__ == '__main__':
    node = gen_list([1, 2, 3, 4])
    print_list(node)
    print(to_list(node))
