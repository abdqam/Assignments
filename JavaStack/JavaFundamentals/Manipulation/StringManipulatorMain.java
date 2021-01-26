public class StringManipulatorMain {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);
        System.out.println("--------------------");

        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c);
        System.out.println("--------------------");

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer charIndex = manipulator.getIndexOrNull(word, subString);
        Integer stringIndex = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(charIndex); // 2
        System.out.println(stringIndex);
        System.out.println("--------------------");

        String stringConcat = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(stringConcat);
    }
}
