class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int low = i+1;
                int high = nums.length-1;
                //int sum = 0-nums[i];
                while(low<high) {
                    int sum = nums[i]+nums[low]+nums[high];
                    if(sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        //skip the duplicates
                        while(low<high) {
                            if(nums[low] != nums[low+1]) break;
                            low++;
                        }
                         //skip the duplicates
                        while(low<high) {
                            if(nums[high] != nums[high-1]) break;
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(sum > 0) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }

        return result;
    }
}