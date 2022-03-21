class Solution:
    def longestPalindrome(self, s: str):
        max_len = 0
        ans = ""
        for i in range(len(s)):
            cur_len, cur_str = max(self.palindrome(s, i, i),
                          self.palindrome(s, i, i + 1))
            if cur_len > max_len:
                max_len = cur_len
                ans = cur_str
        return ans

    def palindrome(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1, s[l+1: r]


if __name__ == '__main__':
    test = Solution()
    assert test.longestPalindrome("babad") == "bab"
    assert test.longestPalindrome("cbbd") == "bb"
