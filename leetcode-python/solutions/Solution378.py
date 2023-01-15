class Solution:
    def kthSmallest(self, matrix, k) -> int:
        l = matrix[0][0]
        r = matrix[-1][-1]
        while l < r:
            m = l + (r - l) // 2
            total = 0
            for row in matrix:
                total += self.upper_bound(row, m)
            if total >= k:  # here is lower_bound
                r = m
            else:
                l = m + 1
        return l

    def upper_bound(self, arr, target):
        l = 0
        r = len(arr)
        while l < r:
            m = l + (r - l) // 2
            if arr[m] > target:
                r = m
            else:
                l = m + 1
        return l


if __name__ == '__main__':
    matrix = [[1, 5, 9], [10, 11, 13], [12, 13, 15]]
    k = 8
    print(Solution().kthSmallest(matrix, k))
