public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
        /// Tests for capVowelsLowRest: 
        /// System.out.println(capVowelsLowRest("Hello World"));
        System.out.println(capVowelsLowRest("One two tHRee world"));
        /// System.out.println(capVowelsLowRest("vowels are fun"));
        /// System.out.println(capVowelsLowRest("intro"));
        /// System.out.println(capVowelsLowRest("yellow"));
        
    }

    public static String capVowelsLowRest (String string) {
        String ans = ""; 
        for (int i = 0; i < string.length(); i++) {
            /// First we check if the letter we are currently looking at is Uppercase
            /// If it is, we will also want to check that it is not a vowel
            /// If it is a vowel --> save as is
            /// If it isn't a vowel --> remove 32 and change to lowercase
            if (string.charAt(i) <= 90 && string.charAt(i) >= 65) {
                if(isUpperVowel(string.charAt(i))==false) {
                    ans = ans + (char) (string.charAt(i) + 32); 
                } else {
                    ans = ans + string.charAt(i); 
                }
            } else {
                if (isLowerVowel(string.charAt(i))) {
                    ans = ans + (char) (string.charAt(i) - 32);
                } else {
                    ans = ans + string.charAt(i); 
                }
            }
        }
        return ans;
    }

    public static boolean isLowerVowel (char a) {
        /// Checks whether a given character is a vowel or not. 
        /// If it is a vowel, returns the same vowel but in upper case
        if (a == 'a' || a == 'e' || a == 'i' ||a == 'o' || a == 'u') {
            return true; 
        }
        return false;   
    }

    public static boolean isUpperVowel (char a) {
        /// Checks whether a given character is a vowel or not. 
        /// If it is a vowel, returns the same vowel but in upper case
        if (a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                return true; 
            }
        return false;   
    }

    

    public static String camelCase (String string) {
        // Write your code here:
        return "";
    }

    public static int[] allIndexOf (String string, char chr) {
        // Write your code here:
        return new int[1];
    }
}
