package lecture_practice.lec_03;

import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please input string");
        String str = input.next();
        Map<Character, Integer> count = new HashMap<>();
        for(Character character : str.toCharArray()){
            if(count.containsKey(character)){
                count.put(character, count.get(character)+1);
            }
            else{
                count.put(character, 1);
            }
        }
        List<Map.Entry<Character, Integer>> countList = new ArrayList<>(count.entrySet());
        countList.sort(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Character, Integer> entry: countList){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
