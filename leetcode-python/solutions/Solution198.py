class Solution:
    mem = {}
    def rob(self, nums):
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])  # Be careful here
        for i in range(2, n):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        return max(dp[n-1], dp[n-2])

    # 自顶向下的方法，通过递归。但是会超时，仅展示思路。
    def rob_topdown(self, nums):
        n = len(nums)-1
        if n == 0:
            return nums[0]
        self.mem = {}
        self.mem[0] = nums[0]
        self.mem[1] = max(nums[0], nums[1])  # Be careful here
        self.dp(n, nums)
        return max(self.mem[n], self.mem[n-1])

    def dp(self, n, nums):
        if n == 0 or n == 1:
            return self.mem[n]
        if self.mem.get(n):
            return self.mem.get(n)
        self.mem[n] = max(self.dp(n-1, nums), self.dp(n-2, nums) + nums[n])
        return self.mem[n]

if __name__ == '__main__':
    test = Solution()
    nums = [2,1,1,2]
    print(test.rob_topdown(nums))
