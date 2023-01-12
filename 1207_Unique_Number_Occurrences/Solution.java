class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> uniqSet = new HashSet<Integer>();

        uniqSet.addAll(freq.values()); 

        return freq.size() == uniqSet.size();
    }
}