
/**
 * a class that defines some useful funcionalities to a game of sokoban
 * 
 * @author Miguel Telhado nº56275
 * @author Miguel Borges nº58187
 */


public class Sokoban {

    public static void main(String[] args){

       int grid = 8;

       validGame(43521141, grid);
       validGame(435211412, grid);
       validGame(4352114, grid);
       validGame(43527141, grid);
       validGame(43525141, grid);
       validGame(43221141, grid);
       validGame(43121145, grid);
       validGame(43121541, grid);
       validGame(43121522, grid);
       validGame(43121152, grid);
    }

    /**
     * method to find de number of digits in a said number n
     * 
     * @requires num to be a positive integer
     * @param num the desired number
     * @return number of digits
     * 
     */
    public static int digits (int num){
        int digits = 0;

        for (int i = num; i > 0 ; i /= 10){
            digits++;
        }

        return digits; 
    }

    /**
     * method that shows how many times a certain number m occurs in n
     * 
     * @requires num to be a positive integer and {@code 0 < m <= 9}
     * @param num the base number
     * @param d the desired number
     * @return number of ocurrences
     */

    public static int ocurrencesOf (int num , int d){

        int ocurrence = 0;

        while (num > 0 ){
            if (num % 10 == d){
                ocurrence++;
            }
            num /= 10;
        }

        return ocurrence;
    }

    /**
     * method that checks if a given number is positive, only contains digits between 1 and only contains one 5
     * 
     * @param num the desired number
     * @return if the number checks all of the conditions
     */

    public static boolean isValid (int num){
        boolean isValid = false;

        if (num > 0){
            if (!contains(num, 0) && !contains(num, 6) && !contains(num, 7) && !contains(num, 8) && !contains(num, 9)){
                if (ocurrencesOf(num, 5) <= 1)
                isValid = true;
            }
        }


        return isValid;
    }

    /**
     * method the checks if a number contains a certain digit
     * 
     * @param num the desired number 
     * @param d the digit
     * @return if num contains d
     */

    public static boolean contains (int num, int d){
        boolean contains = false;

        while (num > 0 ){
            if (num % 10 == d){
                contains = true;
            }
            num /= 10;
        }

        return contains;
    }

    /**
     * method that writes a subsequence of a certain number num, that starts at the right of a certain digit d
     * 
     * @requires {@code isValid(num)}, {@code 0 < d <= 9} and {@code (occurrencesOf(num,d)==1}
     * @param num the number
     * @param d the digit
     * @return the subsequence
     */

    public static int rightSubsequence (int num , int d){

        int subSeq = 0;
        int n = num;
        int i = 1;

        while (n % 10 != d){
            i *= 10;
            n /= 10;
        }

        subSeq = num % i;
        return subSeq;
    }

    /**
     * method that checks if the sequence of digits of a number to the right of 5 represents a positive integer and the first digit of that sequence is odd or
     * the sequence of digits to the right of 5 represents an integer greater than 10 and the product of its two first digits is not a multiple of 4.
     * 
     * @requires {@code isValid(num)} and {@code occurrencesOf(num,5)==1}
     * @param num the number
     * @return if num checks the conditions 
     */

    public static boolean ableToMoveRight (int num){

        boolean able = false;
        int i = rightSubsequence(num, 5);
        int fstDig = 0;
        int secDig = 0;
        int j = 1;

        if (i != 0){

            for (int k = 1 ; k< digits(i) ; k++){
            j *= 10;
            }

            fstDig = i / j;

            if (i > 0 && fstDig % 2 != 0){
            able = true;
            }

            if(digits(i) >=2){
                
                secDig = (i % j) / (j / 10);
    
                if (i > 10 && (fstDig * secDig) % 4 != 0){
            able = true;
            }
            }

        }
        
        return able;
    }

    /**
     * method that checks {@code isValid(num)} and {@code digits(num) == numDigits}
     * 
     * @requires {@code 0 < numDigits <= 9}
     * @param num a given number
     * @param numDigits the desired number of digits
     * @return if those comnditions are true
     */

    public static boolean isValidForGrid(int num, int numDigits) {
        return isValid(num) && digits(num) == numDigits ;
    }

    public static void validGame(int num , int numDigits) {

        if (isValidForGrid(num, numDigits)){
            System.out.print("The number " + num + " is valid, ");

            if (ocurrencesOf(num, 5) == 1){
                System.out.print("5 occurs ");

                if (ableToMoveRight(num)){
                    System.out.println("and is movable to the right.");
                } else {
                    System.out.println("and is not movable to the right.");
                }
            } else {
                System.out.println("5 does not occur.");
            }
        } else {
            System.out.println("The number " + num + " is not valid.");
        }

    }

}
