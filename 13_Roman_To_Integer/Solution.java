class Solution {
    public int romanToInt(String s) {

        if(s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> numerals = new HashMap<>();
        Map<Character, List<Character>> rareCombo = new HashMap<>();

        //add all the symobols and values first into the map
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);

        rareCombo.put('I', Arrays.asList('V', 'X'));
        rareCombo.put('X', Arrays.asList('L', 'C'));
        rareCombo.put('C', Arrays.asList('D', 'M'));

        //now iterate over the string s by going through characters
        //for each character found add it to the sum of the numbers
        //use the map to get the number with symobols
        int sum = 0;
        char previousSymbol = 'N';
        for(char symbol:s.toCharArray()) {
            int numericalValue = numerals.get(symbol);
            if(previousSymbol != 'N' 
                && rareCombo.get(previousSymbol)!= null 
                && rareCombo.get(previousSymbol).contains(symbol)) {
                //if the higher symbol comes up that is previous sum is less than number of the symbol
                //instead of adding, subtract the sum from the number
                numericalValue = numericalValue - 2 * numerals.get(previousSymbol);
            }
            sum = sum + numericalValue;
            previousSymbol = rareCombo.get(symbol) != null ? symbol : 'N';
        }        

        //at the end, return the sum
        return sum;
    }
}