class Solution:
    def shipWithinDays(self, weights, days) -> int:
        l = max(weights)
        r = sum(weights) + 1
        while l < r:
            m = l + (r - l) // 2
            days_needed = self.compute_days_needed(weights, m)
            # g(m)
            if days_needed <= days:
                r = m
            else:
                l = m + 1
        return l

    def compute_days_needed(self, weights, cap):  # O(n)
        day_cargo = 0
        days_needed = 0
        for i in range(len(weights) - 1):
            if day_cargo + weights[i] > cap:   # count(x)
                days_needed += 1
                day_cargo = weights[i]
            else:
                day_cargo += weights[i]
        # 边界条件，最后要处理一次count(x), 可以单独拿出来
        if day_cargo + weights[-1] > cap:
            days_needed += 2
        else:
            days_needed += 1
        return days_needed


if __name__ == '__main__':
    weights = [1,2,3,1,1]
    days = 4
    print(Solution().shipWithinDays(weights, days))
