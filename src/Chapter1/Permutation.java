package Chapter1;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 * Initial thoughts: A permutation is another combination of the string. so:
 * "twa" is a permutation of "wat".
 *
 * In order for a string to be a permutation of the other, it must have the same length
 * and it must have the same number of each character.
 *
 * We should write a method that counts the number of unique characters in each string,
 * then ensures that the second string has each unique character as well.
 *
 * OR what if we just cast each char to an integer, then summed the chars together?
 * If each sum is the same, then we will know we have permutations! Order doesn't matter
 * for permutations, we aren't looking for a particular permutation we are just looking for
 * any permutation.
 *
 * This algorithm performs with O(n) time complexity and O(1) additional space (for storing the sums and interim
 * values of the streams of ints).
 *
 * Another potential solution would be to sort each string, then compare the strings, but that would require
 * O(nlog(n)) time complexity for the sorting, and would require us converting to an array and back again, which
 * is unnecessary space
 *
 *
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("wat", "twa")); //permutations
        System.out.println(isPermutation("chars", "sahcr")); //longer permutations
        System.out.println(!isPermutation("chars", "chars")); //same string not permutation
        System.out.println(!isPermutation("hues", "long")); //different strings
        System.out.println(!isPermutation("wat", "hi")); //different length
        System.out.println(!isPermutation("", "")); //empty strings not permutations
    }

    public static boolean isPermutation(String s, String t) {
        //if lengths aren't equal, can't be permutation
        //if the strings are equal, they are not permutations
        if(s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int sSum = sumChars(s);
        int tSum = sumChars(t);

        return sSum == tSum;
    }

    private static int sumChars(String s) {
        return s
                .chars()
                .reduce(0, (sum, e) -> sum += e);
    }
}
