package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {



    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int count = 0;
        input = input.toLowerCase() + " "; // Make case insensitive and add a space to check the last word.

        for (int i = 0; i < input.length() - 1; i++) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);

            if ((current == 'y' || current == 'z') && !Character.isLetter(next)) {
                count++;
            }

        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String result = "";
        for (int i = 0; i < base.length(); i++) {
            if (i > base.length() - remove.length()) {
                result += base.substring(i, base.length());
                break;
            } else {
                String substring = base.substring(i, i + remove.length());
                if (!(substring.equalsIgnoreCase(remove))) {
                    result += base.charAt(i);
                } else {
                    i = i + remove.length() - 1;
                }
            }
        }

        return result;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
            int is = 0;
            int not = 0;

            for(int i = 0; i <= input.length() - 3; i++) {
                if(input.substring(i, i + 2).equals("is")) {
                    is++;
                } else if(input.substring(i, i + 3).equals("not")) {
                    not++;
                }
            }

            if(input.length() >= 2 && input.substring(input.length() - 2).equals("is"))
                is++;

            Boolean result = is == not;

        return result;
    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean result = true;
        if(input == "") return result;

        if(input.length() <= 2 && !input.equals("gg")) {
            return false;
        }

        for(int i = 1; i < input.length()-1; i++)
        {
            if(input.charAt(i) == 'g')
            {
                if(!(input.charAt(i-1) == 'g' || input.charAt(i+1) == 'g'))
                {
                    result = true;
                    break;
                }
            }
            else if((i == input.length()-2) && (input.charAt(i+1) == 'g') &&
                    (input.charAt(i) != 'g'))
            {
                result = false;
                break;
            }
        }
        return result;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int trippleCounter = 0;

        // Loop over each character in the input string (skip the last 3 to prevent going out of bounds)
        for(int i = 0;i < input.length() - 3; i++) {
            // Get the current char in the string + the next 3
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            char c3 = input.charAt(i + 2);

            // Check if all 4 characters are equal
            if(c1 == c2 && c2 == c3) {
                trippleCounter++; // Increase the counter
            }
        }

        return trippleCounter;
    }
}
