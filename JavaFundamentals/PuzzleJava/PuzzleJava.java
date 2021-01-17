import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public void sumGreater() {
        int[] array = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] > 10) {
                System.out.println(array[i]);
            }
        }
        System.out.println("The Sum is: " + sum);
    }

    public ArrayList<String> shuffleString() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> longerThan5 = new ArrayList<String>();
        names.add("ahmad");
        names.add("nancy");
        names.add("yasmeen");
        names.add("abd");
        names.add("kamal");
        Collections.shuffle(names);
        for (String name : names) {
            System.out.println(name);
            if (name.length() > 5) {
                longerThan5.add(name);
            }
        }
        return longerThan5;
    }
    public void letter(){
        ArrayList<Character> letters =new ArrayList<Character>();
        for (char i='a';i<'z';i++){
            letters.add(i);
        }
        Collections.shuffle(letters);
        System.out.println("the last letter is "+letters.get(letters.size()-1));
        System.out.println("the first letter is "+letters.get(0));
        if(letters.get(0)=='a'||letters.get(0)=='e'||letters.get(0)=='o'||letters.get(0)=='u'||letters.get(0)=='i'){
            System.out.println("and this letter is a vowel");
        }
    }
    public int[] randomNumbers(){
        int[] array =new int[10];
        Random r = new Random();
        for (int i=0;i<array.length;i++){
            array[i]=r.nextInt(100-55) + 55;
        }
        return array;
    }
    public void sortedNumbers(){
        int[] array =new int[10];
        Random r = new Random();
        for (int i=0;i<array.length;i++){
            array[i]=r.nextInt(100-55) + 55;
        }
        Arrays.sort(array);
        System.out.println("the minimum value is " +array[0]);
        System.out.println("the maximum value is " +array[array.length-1]);
    }
    public String randomString(){
        String string  ="";
        Random r = new Random();
        for (int i=0;i<5;i++){
            int c=r.nextInt(122-97) + 97;
            Character C=(char) c;
            String S =Character.toString(C);
            string=string.concat(S);
        }
        return string;
    }
    public ArrayList<String> arrayOfRandomString(){
        ArrayList<String> array =new ArrayList<String>();
        for(int i=0;i<5;i++){
            array.add(randomString());
        }
        return array;
}
}
