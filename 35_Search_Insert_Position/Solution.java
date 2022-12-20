class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int middle = (left + right) / 2;

        if(left > right) {
            return left;
        }

        if(target > nums[middle]) {
            //search on the right side of the middle array
            return binarySearch(nums, middle+1, right, target);
        }
        else if(target < nums[middle]) {
            return binarySearch(nums, left, middle-1, target);
        }
        else {
            return middle;
        }
    }
}