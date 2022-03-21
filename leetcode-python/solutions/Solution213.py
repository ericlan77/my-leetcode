class Solution:
    """
    因为最后到底是从0出发还是从1出发我们不确定。
    所以要保留两种出发条件。
    从0出发，但是最多的抢劫money只能停留在dp[n-2]，即倒数第二个位置
    从1出发，最后可以停在dp[n-1]（倒数第一个位置）和dp[n-2]（倒数第二个位置）
    """
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        n = len(nums)
        dp_0 = [0] * len(nums)
        dp_0[0] = nums[0]
        # 虽然不能走到index1，但是dp[1]仍然表示在index1能累计到最多money,
        # 即在index只能累计到index0位置的money。
        # nums[1]表示的money不能参与累计
        dp_0[1] = nums[0]
        for i in range(2, n-1):
            dp_0[i] = max(dp_0[i-1], dp_0[i-2] + nums[i])

        dp_1 = [0] * len(nums)
        # nums[0]表示的money不能参与累计
        dp_1[0] = 0
        dp_1[1] = nums[1]
        for i in range(2, n):
            dp_1[i] = max(dp_1[i-1], dp_1[i-2] + nums[i])
        dp_1_max = max(dp_1[n-1], dp_1[n-2])
        return max(dp_0[n-2], dp_1_max)