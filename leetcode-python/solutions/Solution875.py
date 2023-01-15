class Solution:
    def minEatingSpeed(self, piles, h) -> int:
        # [l, r)
        l = 1
        r = max(piles) + 1
        while l < r:
            m = l + (r - l) // 2
            times = 0
            for p in piles:  # o(n)
                times += (p + m - 1) // m  # 向上取整
            if times <= h:  # g(m)
                r = m  # 往小区间。注意：在[l, r)区间里，越往左的部分对应的times越大
            else:
                l = m + 1  # 往大区间
        return l


if __name__ == '__main__':
    piles = [3, 6, 7, 11]
    h = 8
    print(Solution().minEatingSpeed(piles, h))
