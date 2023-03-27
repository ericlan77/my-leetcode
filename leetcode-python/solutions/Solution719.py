class Solution:
    def smallestDistancePair(self, nums, k) -> int:
        def calculate(m):
            count = 0
            slow = 0
            fast = 0
            while slow < len(nums) or fast < len(nums):
                while fast < len(nums) and nums[fast] - nums[slow] <= m:
                    fast += 1  # move fast pointer
                count += fast - slow - 1  # count pairs
                slow += 1  # move slow pointer
            return count

        nums.sort()
        l = 0
        # search space [min(nums), max(nums)+1)
        r = nums[-1] - nums[0] + 1
        while l < r:
            m = l + (r - l) // 2
            count = calculate(m)
            if count >= k:
                r = m
            else:
                l = m + 1
        return l


if __name__ == '__main__':
    nums = [1, 6, 1]
    k = 3
    print(Solution().smallestDistancePair(nums, k))
