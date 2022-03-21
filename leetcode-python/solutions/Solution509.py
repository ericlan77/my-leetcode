import time

def get_runtime(func, *args):
    start_time = time.time()
    print(func(*args))
    end_time = time.time()
    print("%s Time comsume: %s" % (func, str(end_time-start_time)))

class Solution:
    mem = {}
    def fib(self, n: int):
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fib(n-1) + self.fib(n-2)

    def fib_with_mem(self, n:int):
        if n == 0:
            return 0
        if n == 1:
            return 1
        if self.mem.get(n):
            return self.mem[n]
        s = self.fib(n-1) + self.fib(n-2)
        self.mem[n] = s
        return s

    def fib_from_bottom_to_top(self, n:int):
        dp = {0:0, 1:1}
        for i in range(2, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

if __name__ == '__main__':
    test = Solution()
    get_runtime(test.fib, 30)
    get_runtime(test.fib_with_mem, 30)
    get_runtime(test.fib_from_bottom_to_top, 30)

