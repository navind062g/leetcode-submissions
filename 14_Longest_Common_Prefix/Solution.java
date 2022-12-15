class Solution {
    public String longestCommonPrefix(String[] strs) {
        //first get the smallest length of string in the array
        int smallestLen = Integer.MAX_VALUE;
        String output = "";
        for(String str: strs) {
            if(str.length() < smallestLen) {
                smallestLen = str.length();
            }
        }

        if(smallestLen == Integer.MAX_VALUE) {
            return output;
        }
        //run a loop to iterate using smallest length
        //compare the characters from the start of each string
        //store the character in new output string
        for(int i=0;i<smallestLen;i++) {
            boolean firstRun = true;
            char prefixChar = '0';
            for(String str: strs) {
                if(firstRun) {
                    prefixChar = str.charAt(i);
                    firstRun = false;
                    output += prefixChar;                 
                }
                else if(str.charAt(i) != prefixChar) {
                    return i==0 ? "" : output.substring(0, i);
                }
                
            }
        }

        //return the output string
        return output;
    }
}