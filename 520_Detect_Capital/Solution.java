class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstLetterUpper = false;
        boolean wholeStringUpper = false;
        boolean titleCase = false;

        for(int i=0;i<word.length();i++) {
            boolean isUpperCase = Character.isUpperCase(word.charAt(i));
            if(i==0 && isUpperCase) {
                firstLetterUpper = true;
            }
            else if(i==1 && !isUpperCase && firstLetterUpper) {
                titleCase = true;
            }
            else if(i>0 && isUpperCase && firstLetterUpper && !titleCase && !wholeStringUpper) {
                wholeStringUpper = true;
            }
            else if(i>0 && 
                    (((!firstLetterUpper || titleCase) && isUpperCase) 
                    || (!isUpperCase && wholeStringUpper))) {
                return false;
            }          

        }

        return true;
    }
}