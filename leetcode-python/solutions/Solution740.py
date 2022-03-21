"""
This problem is related to 198.rob_house. If you take x, then
you can't taske x-1 and x+1, just like "you can't rob neighbor's
-house", and the sum(x) is the money stored in house-x in rob-house.
"""
class Solution:
    def deleteAndEarn(self, nums):
        maxVal = max(nums)
        Sum = [0]  * maxVal
        for val in nums:
            Sum[val-1] += val

        def rob(nums):
            n = len(nums)
            if n == 1:
                return nums[0]
            first, second = nums[0], max(nums[0], nums[1])
            for i in range(2, n):
                first, second = second, max(first+nums[i], second)
            return second

        return rob(Sum)
