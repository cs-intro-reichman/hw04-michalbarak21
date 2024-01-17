import java.util.Arrays;

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
        /// System.out.println(capVowelsLowRest("One two tHRee world"));
        /// System.out.println(capVowelsLowRest("vowels are fun"));
        /// System.out.println(capVowelsLowRest("intro"));
        /// System.out.println(capVowelsLowRest("yellow"));
        
        /// Tests for camelCase: 
        /// System.out.println(camelCase("Hello World"));
        /// System.out.println(camelCase("HELLO    world"));
        /// System.out.println(camelCase("  tWo wordS  "));
        /// System.out.println(camelCase("world"));
        /// System.out.println(camelCase("   Intro to coMPUter sCIEncE   "));

        /// Tests for allIndexOf: 

        /// System.out.println(Arrays.toString(allIndexOf("Hello World", 'l')));  // output: {2, 3, 9}
        /// System.out.println(Arrays.toString(allIndexOf("Hello worLd",'l'))); // output: {2, 3}
        /// System.out.println(Arrays.toString(allIndexOf("Hello world",'o'))); // output: {4, 7}
        /// System.out.println(Arrays.toString(allIndexOf("Hello world",' '))); // output: {5}
        /// System.out.println(Arrays.toString(allIndexOf("Hello world",'d'))); // output: {10}
        /// System.out.println(Arrays.toString(allIndexOf("MMMM",'M')));

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
        /// First step we will find the index of the first word 
        /// The first word is the only word that it's first letter isn't capitol, so we will deal with it outside of the loop
        String ans = ""; 
        int first_idx = firstLetterIdx(string);
        ans = ans + lowerCase(string.charAt(first_idx)); 
        for (int i = first_idx + 1; i < string.length(); i++) {
            /// check 1 in the loop: is the current char a first letter of a new word? 
            /// if it is --> uppercase and add to answer 
            /// check 2 in the loop: is the current char a space?
            /// if it is --> skip it 
            /// if none of the above is true - it must be a char in the middle of a word
            /// therefore we want to lowercase it
            if (string.charAt(i-1) == ' ') {
                ans = ans + upperCase(string.charAt(i));
            } else if (string.charAt(i) == ' ') {
                ans = ans; 
            } else {
                ans = ans + lowerCase(string.charAt(i)); 
            }

        }
        return ans;
    }

    public static String clearSpaces (String string) {
        String ans = ""; 
        /// in this loop we get rid of all the spaces
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                ans = ans + string.charAt(i); 
            } 
        }
        return ans;
    }

    public static char upperCase (char i) {
        /// gets a char object and returns it in uppercase
        if (i >= 65 &&  i <= 90) {
            return i; 
        }
        return (char) (i - 32); 
    }

    public static char lowerCase (char i) {
        /// gets a char object and returns it in lowercase 
        if (i >= 97 &&  i <= 122) {
            return i; 
        }
        return (char) (i + 32); 
    }

    public static Integer firstLetterIdx (String string) {
        /// Finds the index of the first character that isn't a space
        int ans = 0; 
        for (int i = 0; i < string.length(); i++ ) {
            if (string.charAt(i) != ' ') {
                return i; 
            }
        }
        return ans; 
    }



    public static int [] allIndexOf (String string, char chr) {
        /// First run is to determine how big should the answer array should be
        int num_of_idx = 0; 
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                num_of_idx++; 
            }
        }
        int[] ans = new int [num_of_idx];   
        /// In this run we check if the current char in the string matches the given char
        /// If yes --> add current idx to the answer array
        /// Else --> continue to the next character in the string
        int idx_arr = 0;
        for (int i = 0; i < string.length(); i++) {  
            if ((char) string.charAt(i) == chr) {
                ans[idx_arr] = i; 
                idx_arr++;
            }
        }
        return ans;
    }
}
