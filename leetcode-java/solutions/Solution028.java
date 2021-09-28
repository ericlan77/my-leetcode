package solutions;

/**
 * @author: ericlan
 * @Date: 9/13/2021,12:00 AM
 * @Description:
 */
public class Solution028 {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    //TODO: use KMP algorithm

    public static void main(String[] args) {
        System.out.println(strStr("hello","1l"));
        System.out.println(strStr("hello","aa"));
    }
}
