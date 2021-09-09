import java.util.HashMap;
/**
 * 初始化HashMap，对于罗马字母，当前字母对应数值大于右边的，那么在总数里加上当前
 * 字母对应的数值；如果当前字母对应数值小于右边，在总数里减去当前字母对应的数值。
 * XIII = 8, XIV = 14
 */
public class Solution013 {
    HashMap<Character, Integer> map = new HashMap<>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length()-1; i++){
            int cur = map.get(s.charAt(i));
            ans = (cur >= map.get(s.charAt(i+1)) ? ans + cur : ans -cur);
        }
        ans += map.get(s.charAt(s.length()-1));
        return ans;
    }
}
