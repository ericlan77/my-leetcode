package utils;
/**
 * @ClassName: BinarySearch
 * @Description: 如果target在array中不存在，最终left，mid，right指针也会同时指向在一个
 * 最接近target的数array[mid]。此时如果array[mid] < target,那么right会继续执行right = mid-1，
 * 使得此时三个指针位置如情况1；如果array[mid] 》 target，那么left会继续执行left = mid + 1，如情况2
 * 情况1：              array[mid]             情况2：           array[mid]
 *                        left                                            left
 *                        mid                                     mid
 *                right                                          right
 *
 * @Author: Eric Lan
 * @Date: 2020/7/23 14:44
 **/
public class BinarySearch {

    private static int arrayLength;
    private static int epoch = 0;
    private static int lastLeft = 0;
    private static int lastRight = 0;
    public static int findTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        // 这里必须是 <=
        while (left <= right) {
            mid = left + (right - left)/2;
            printEpoch(array, left, right, mid);
            if (array[mid] == target)
                return mid;
            if (array[mid] < target)
                left = mid + 1;
            if (array[mid] > target)
                right = mid - 1;
        }
        System.out.println("End Epoch");
        printEpoch(array, left, right, mid);
        lastLeft = left;
        lastRight = right;
        return -1;
    }

    /*
    打印出二分搜索的过程
     */
    private static void printEpoch(int[] array, int left, int right, int mid){
        epoch++;
        System.out.println("-----epoch "+epoch+"-----");
        System.out.print("pos:");
        for(int i = 0; i < arrayLength; i++)
            System.out.printf("%3d",i);
        System.out.println();
        System.out.print("num:");
        for(int num: array)
            System.out.printf("%3d",num);
        System.out.println();
        System.out.print("lef:");
        for(int i = 0; i < (left)*3; i++)
            System.out.print(" ");
        System.out.println("  l");
        System.out.print("mid:");
        for(int i = 0; i < (mid)*3; i++)
            System.out.print(" ");
        System.out.println("  m");
        System.out.print("rig:");
        for(int i = 0; i < (right)*3; i++)
            System.out.print(" ");
        System.out.println("  r");
    }

    public static void main(String args[]){
        //int[] array = {1,4,7,9,13,17,21,26,29,35,44,55,65,79};
        int[] array = {1,4,7};
        arrayLength = array.length;
        int index = findTarget(array,6);
        if(index != -1)
            System.out.println("After "+epoch+" epochs, find target at pos:"+index);
        else
            System.out.println("After "+epoch+" epochs, not find target, it's between ["+lastLeft+","+lastRight+"]");
    }
}

