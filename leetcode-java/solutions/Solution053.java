package solutions;

/**
 * @author: ericlan
 * @Date: 9/13/2021,10:52 PM
 * @Description: 最大连续子序列和。
 * 1. 用动态规划，dp[i]表示在i位置能连续累积到的最大和。注意连续。
 * 转移函数为 dp[i] = max{nums[i], dp[i-1]+nums[i]}
 * 2. 在累加过程中可能出现一个全局最大值，用max变量存放。
 * 例：比如在下面例子中，-1处，能够累积的最大和就是1而不是-1或2；5处，加上dp[i-1]后累计最大和可以达到6。
 * nums  1 -4 -3  2 -1  5
 * dp[i] 1 -3 -3  2  1  6
 */
public class Solution053 {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for(int i=1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
