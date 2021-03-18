package Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class duplicateOccurence {

    static void printduplicate(String str)
    {
        List<String> parts = Pattern.compile(" ")
                .splitAsStream(str)
                .collect(Collectors.toList());
        parts.forEach(s-> System.out.println(s));
        Map<String, Integer> map= parts.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.summingInt(val -> 1)));
        System.out.println("map: " + map);



    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "I am I in Hyderabad Hyd in";
        duplicateOccurence.printduplicate(str);

    }

}
