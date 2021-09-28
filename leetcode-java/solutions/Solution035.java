package solutions;

/**
 * @author: ericlan
 * @Date: 9/13/2021,12:07 AM
 * @Description:
 */
public class Solution035 {
    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1])
            return nums.length;
        if(target < nums[0])
            return 0;

        int left = 0;
        int right = nums.length;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        return left;
    }
}
