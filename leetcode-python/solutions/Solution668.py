class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def compute_total(mid):  # total location number added
            # 比起最早的那一题[]，这题的规律性更强一些
            total = 0
            for i in range(1, m + 1):
                total += min(mid // i, n)
            return total

        l = 1
        r = m * n + 1
        while l < r:
            mid = l + (r - l) // 2
            total = compute_total(mid)
            if total >= k:
                r = mid
            else:
                l = mid + 1
        return l


if __name__ == '__main__':
    m, n, k = 2, 3, 6
    print(Solution().findKthNumber(m, n, k))
