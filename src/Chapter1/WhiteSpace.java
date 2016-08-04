package Chapter1;

/**
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 the string has sufficient space at the end of the string to hold the additional
 characters, and that you are given the "true" length of the string. (Note: if implementing
 in Java, please use a character array so that you can perform this operation
 in place.)
 EXAMPLE
 Input:  "Mr John Smith    "
 Output: "Mr%20Dohn%20Smith"

 Can do this in two passes: 1) count number of white spaces in the string, which will allow
 you to calculate the #of actual spaces in the string and the #of trailing space at the end.

 2) In second pass, begin copying the "last actual character" in the string to the end of the string
 (in this case, char array, since strings in java are immutable). When you encounter an actual space
 in the string, copy 0 then 2 then % to the string in the next 3 spaces. Decrement the count by 3, and
 continue.

 O(2n) time complexity, which reduces to O(n)

 If we were truly doing this "in place" (i.e. strings were mutable in java) we could do this in O(1) extra space
 but since we need to convert the string to a char array it will require O(n) extra space, where n is the
 length of the string.
 */
public class WhiteSpace {
    public static void main(String[] args) {
        System.out.println("Mr John Smith    : " + whiteSpace("Mr John Smith    "));
        System.out.println("W  a  t        : " + whiteSpace("W  a  t        "));
        System.out.println("      : " + whiteSpace("      "));

    }

    public static String whiteSpace(String s) {
        int totalSpaces = 0;
        char[] charArray = s.toCharArray();
        for(char c : charArray) {
            if(c == ' ') {
                totalSpaces++;
            }
        }
        int numSpaces = totalSpaces / 3;
        int trailingSpaces = totalSpaces - numSpaces;
        int insertionPoint = charArray.length - 1;
        for(int i = insertionPoint - trailingSpaces; i >= 0; i--) {
            char currentChar = charArray[i];
            if(currentChar == ' ') {
                charArray[insertionPoint] = '0';
                charArray[insertionPoint - 1] = '2';
                charArray[insertionPoint - 2] = '%';
                insertionPoint -= 3;
            } else {
                charArray[insertionPoint] = currentChar;
                insertionPoint--;
            }
        }
        return new String(charArray);
    }

}
