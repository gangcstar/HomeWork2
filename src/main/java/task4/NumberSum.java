package task4;

import java.util.List;

public class NumberSum {
    public static void main(String[] args) {
        List<Double> doubles = List.of(5.6,1.3,12.8);
        List<Integer> integers = List.of(1,9,11,35);

        double result = sumAll(integers,doubles);
        System.out.println(result);

    }
    public static double sumAll(List<? extends Number> ... lists) {
      double sum = 0;
      for(List<? extends Number> list : lists) {
          for (Number num : list) {
              sum += num.doubleValue();
          }
      }
      return sum;
    }
}
