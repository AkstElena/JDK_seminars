package seminar4.task2;

/*
В рамках выполнения задачи необходимо:
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения.
2. Получите уникальный список Set на основании List.
3. Определите наибольший элемент (алфавитный порядок).
4. Определите наибольший элемент (по количеству букв в слове, но в обратном порядке).
5. Удалите все элементы содержащие букву ‘A’.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<String> names = new ArrayList<>();

    public static Set<String> stringSet(){
        names.add("Коля");
        names.add("Ваня");
        names.add("Марина");
        names.add("Артур");
        names.add("Василий");
        names.add("Милана");
        names.add("Виктор");
        names.add("Фаина");
        names.add("Коля");
        Set<String> set = new HashSet<>();
        set.addAll(names);
        return set;
    }

    public static String stringSort(){
        Set<String> str = stringSet();
        return str.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public static String getMaxLengthString(){
        Set<String> strMax = stringSet();
        return strMax.stream().max((Comparator.comparingInt(String::length))).orElse(null);
    }

    public static Set<String> getSetWithoutA(){
        Set<String> strSet = stringSet();
        return strSet.stream().filter(e -> !e.toLowerCase().contains("а"))
                .collect(Collectors.toSet());
    }

    public static Set<String> deleteSomeFilter() {
        Set<String> names = stringSet();
        return names.stream().filter(x -> !x.contains("А") && !x.contains("а")).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(stringSet());
        System.out.println(stringSort());
        System.out.println(getMaxLengthString());
        System.out.println(getSetWithoutA());
        System.out.println(deleteSomeFilter());
    }

}
