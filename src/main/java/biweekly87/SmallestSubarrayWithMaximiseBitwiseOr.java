package biweekly87;

import java.util.Arrays;

public class SmallestSubarrayWithMaximiseBitwiseOr {

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] store = new int[31];
        Arrays.fill(store, -1);
        for(int i = n-1; i >= 0; --i){
            int temp = nums[i];
            for(int j = 0; j < 31; ++j){
                if((temp & 1) == 1){
                    store[j] = i;
                }
                temp >>= 1;
            }

            int maxVal = Integer.MIN_VALUE;
            for(int val: store){
                maxVal = Math.max(maxVal, val);
            }
            if(maxVal == -1){
                ans[i] = 1;
            }else{
                ans[i] = maxVal - i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,1,3};
        int[] ans = smallestSubarrays(nums);
        for(int i:ans){
            System.out.print(i+" ");
        }

        int[] nums1 = {1,2};
        int[] ans1 = smallestSubarrays(nums1);
        for(int i:ans1){
            System.out.print(i+" ");
        }
    }
}
