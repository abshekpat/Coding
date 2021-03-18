package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mystreams {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> name = new ArrayList<>();
        name.add("Abhijeet");
        name.add("Don");
        name.add("Akshay");
        name.add("Adam");
        name.add("Ram");
        startwithA(name);
        lengthGEFour(name);

    }

    private static void lengthGEFour(ArrayList<String> name) {
        // TODO Auto-generated method stub
        name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

        Stream<String> ls = name.stream().filter(s->s.startsWith("A")).limit(1);
        ls.forEach(s->System.out.println(s));

        List<String> ar = name.stream().filter(s->s.length()>4).map(s->s.toLowerCase()).collect(Collectors.toList());
        for (String s: ar) {
            System.out.println(s);
        }

    }


    private static void startwithA(ArrayList<String> name) {
        // TODO Auto-generated method stub
        long c = name.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

    }

}
