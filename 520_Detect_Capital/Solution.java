class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstLetterUpper = false;
        boolean wholeStringUpper = false;
        boolean titleCase = false;

        for(int i=0;i<word.length();i++) {
            boolean isUpperCase = Character.isUpperCase(word.charAt(i));
			/* Check whether the first letter is upper case*/
            if(i==0) {
                firstLetterUpper = isUpperCase;
            }			
            else if(i==1) {
				/*if the first letter is upper case and second letter is lowercase that means title case */
                titleCase = !isUpperCase && firstLetterUpper;
				/*Case 3: when first and second letter is upper case */
				wholeStringUpper = isUpperCase && firstLetterUpper;
            }
            else if(((!firstLetterUpper || titleCase) && isUpperCase) 
                    || (!isUpperCase && wholeStringUpper)) {
                return false;
            }          

        }

        return true;
    }
}