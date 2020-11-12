package lecture_practice.lec_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StringSorts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please input numbers of string");
        int n = input.nextInt();
        List<String> strings = new ArrayList<>();
        System.out.println("please input strings");
        for(int i = 0; i < n; ++i){
            strings.add(input.next());
        }

        strings.sort((o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        }
        );
        for(String str: strings){
            System.out.println(str);
        }
    }
}
