class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        if len(nums) == 3 and sum(nums) == 0:
            return [nums]

        res = []
        nums.sort()  # sort the array first
        for i in range(len(nums) - 2):
            # if nums[i] > 0, the sum must > 0, so break
            if nums[i] > 0:
                break

            # Mind for lower bound, i must > 0
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    res.append((nums[i], nums[l], nums[r]))
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    l += 1
                    r -= 1
        return res


if __name__ == '__main__':
    nums = [0, 0, 0]
    result = Solution().threeSum(nums)
    print(result)
