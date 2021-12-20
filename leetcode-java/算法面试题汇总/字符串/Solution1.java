package 算法面试题汇总.字符串;

/**
 * @author: ericlan
 * @Date: 2021/12/16,21:38
 * @Description:
 */
public class Solution1 {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++ ;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "A mannama";
        System.out.println(Solution1.isPalindrome(test));
    }
}
