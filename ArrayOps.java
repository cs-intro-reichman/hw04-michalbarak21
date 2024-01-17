public class ArrayOps {
    public static void main(String[] args) {
        /// Creating tests based on the tests shown in the assingment

        /// Tests for findMissingInt: 
        /// System.out.println(findMissingInt(new int [] {0, 1, 3})); 
        /// System.out.println(findMissingInt(new int [] {0, 1, 3, 2, 4, 6}));
        /// System.out.println(findMissingInt(new int [] {1}));
        /// System.out.println(findMissingInt(new int [] {0}));
        /// System.out.println(findMissingInt(new int [] {2, 3, 1}));


        /// Tests for secondMaxValue: 
        /// System.out.println(secondMaxValue(new int[] {6, 9, 4, 7, 3, 4}));
        /// System.out.println(secondMaxValue(new int[] {1, 2, 3, 4, 5}));
        /// System.out.println(secondMaxValue(new int[] {5, 4, 3, 2, 1}));
        /// System.out.println(secondMaxValue(new int[] {2, 8, 3, 7, 8}));
        /// System.out.println(secondMaxValue(new int[] {-1, -2, 3, -4, -5}));
        /// System.out.println(secondMaxValue(new int[] {202, 48, 13, 8, 7}));


        //// Tests for containTheSameElements: 
        /// System.out.println(containsTheSameElements(new int[] {1, 2, 1, 1, 2}, new int[] {2, 1})); 
        /// System.out.println(containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3})); 
        /// System.out.println(containsTheSameElements(new int[] {1, 2, 3}, new int[] {1, 2, 3, 3, 2, 1})); 
        /// System.out.println(containsTheSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5, 7})); 
        
        /// Tests for hasElement:
        /// System.out.println(hasElement(new int [] {1, 2, 3, 4}, -1));
        /// System.out.println(hasElement(new int [] {1, 2, 3, 4}, 5));
        
        /// Tests for isSorted: 
        /// System.out.println(isSorted(new int[] {7, 5, 4, 3, -12}));
        /// System.out.println(isSorted(new int[] {1, 2, 3})); 
        /// System.out.println(isSorted(new int[] {1, -2, 3})); 
        /// System.out.println(isSorted(new int[] {1, 1, 500}));
        /// System.out.println(isSorted(new int[] {1, 3, 2})); 


    }
    
    public static int findMissingInt (int [] array) {
        /// Creates a new array in the length of the array given by the user 
        /// Puts zeros for each spot in the new array
        int [] lenArray = new int[array.length]; 
        for (int i = 0; i < lenArray.length; i++) {
            lenArray[i] = 0; 
        }
        /// a condition to cover the case that the given array is of length 1: 
        if (array.length == 1) {
            if (array[0] == 0) {
                return 1; 
            } else {
                return 0; 
            }
        }
        /// Create the defualt item returned (in case user gives array {0})
        int ans = 0;
        for (int i = 0; i < lenArray.length; i++) {
            /// Goes over each of the integers in the range and checks whether it can be found in the given array
            /// If yes --> changes the matching idx of lenArray to 1
            /// If no --> this must be our missing index, therefore we will change the value of ans to idx    
            if (inArray(array, i)) {
                lenArray[i] = 1;
                /// System.out.println("index " + i + " is in the array");  
            } else {
                ans = i;
                /// System.out.println("index " + i + " is not in the array");
            }
        }
        return ans;
    }

    public static boolean inArray (int [] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return true; 
            }
        }
        return false; 
    }

    public static int secondMaxValue(int [] array) {
        /// 
        int ans = Math.min(array[0], array[1]);  
        int max = Math.max(array[0], array[1]);
        int max_count = 0; 
        for (int i = 0; i < array.length; i++) {
            /// A loop that find the maximal value of the array
            if (array[i] > max) { 
                    max = array[i];   
                } 
            }
        for (int i = 0; i< array.length; i++) {
            if (array[i] == max) {
                max_count++;
            }
        }
        if (max_count > 1) {
            return max; 
        }
        for (int i = 0; i < array.length; i++) {
            /// A loop that finds the second largest value in the array
            /// Special case - the maximal value in the array apears twice --> in this case we want ans to be equal to the maximal value
            if (array[i] > ans && array[i] != max) {
                ans = array[i];
            }
        }
        return ans;
        }  
        
    public static boolean containsTheSameElements(int [] array1,int [] array2) { 
        /// Step 1: go over each element in array1 and check if array2 has the same element
        /// if yes --> continue to the next element in array 1
        /// if no --> return false       
        for (int i = 0; i < array1.length; i++) {
            if (hasElement(array2, array1[i]) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasElement(int [] array, int check) {
        /// Checks if an integer is contained in an array
        for (int i = 0; i < array.length; i++) {
            if (array[i] == check) {
                return true;
            }
        }
        return false; 
    }

    public static boolean isSorted(int [] array) {
        if (high_low_Sorted(array)) {
            return true; 
        } else if (low_high_Sorted(array)) {
            return true;
        }
        return false;
    }


    public static boolean high_low_Sorted(int [] array) {
        boolean ans = true; 
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1]) {
                ans = false;
            }
        }
        return ans;  
    }


    public static boolean low_high_Sorted(int [] array) {
        boolean ans = true; 
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                ans = false;
            }
        }
        return ans;  
    }

}
