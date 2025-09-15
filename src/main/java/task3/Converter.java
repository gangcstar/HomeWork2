package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Converter {
    public <A,B> List<B> convert(List<A> list, Function<A, B> function) {
        List<B> listConvert =   new ArrayList<>();
            for (A element : list) {
                listConvert.add(function.apply(element));
        }
        return listConvert;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
               return integer.toString();

            }
        };

        Converter converter = new Converter();
        List<String> result = converter.convert(list, function);
        System.out.println(result);

    }
}
