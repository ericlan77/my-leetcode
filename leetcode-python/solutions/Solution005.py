class Solution:
    res = ""
    def helloworld(self):
        print("hello world!")

    def longestPalindrome(self, s: str) -> str:
        global res
        # init
        dp = [[0] * len(s) for i in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = 1

        for i in range(len(s)):
            left = right = i
            # check for odd
            self.checkPalindrome(s, left, right, dp)
            # check for even
            self.checkPalindrome(s, left, right + 1, dp)
        return res

    def checkPalindrome(self, s, left, right, dp):
        global res
        # check if out of index
        if left - 1 > 0 and right + 1 < len(s):
            # check if palindrome
            if s[left - 1] == s[right + 1] and dp[left][right] == 1:
                dp[left - 1][right + 1] = 1
                substr = s[left - 1:right + 1 + 1]
                if right - left + 1 > len(res):
                    res = substr
                self.checkPalindrome(s, left - 1, right + 1, dp)
            else:
                dp[left - 1][right + 1] = 0
                return
        else:
            return

Solution().helloworld()
print(Solution().longestPalindrome("aaa"))
