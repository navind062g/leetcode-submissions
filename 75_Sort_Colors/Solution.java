class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int current = 0;
        int p2 = nums.length - 1;

        while(current<=p2) {
            int temp;
            if(nums[current] == 0) {
                temp = nums[current];
                nums[current++] = nums[p0];
                nums[p0++] = temp;
            }
            else if(nums[current] == 2) {
                temp = nums[current];
                nums[current] = nums[p2];
                nums[p2--] = temp;
            }
            else {
                current++;
            }
        }
    }
}