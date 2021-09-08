import java.util.HashMap;

public class Solution001 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums ={3,2,4};
        int target = 6;
        for(int i: twoSum(nums, target)){
            System.out.println(i);
        }
    }
}
