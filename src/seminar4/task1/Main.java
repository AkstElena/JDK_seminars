package seminar4.task1;

/*
В рамках выполнения задачи необходимо:
1. Создайте коллекцию мужских и женских имён с помощью интерфейса List.
2. Отсортируйте коллекцию в алфавитном порядке.
3. Отсортируйте коллекцию по количеству букв в слове.
4. Разверните коллекцию.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = createListNames();
        System.out.println(names);

        System.out.println(sortByAlphabet(names));
        System.out.println(sortByLengthLineLambda(names));

        System.out.println(sortByLengthLine(names));

        System.out.println(reverseList(names));
    }

    private static List<String> sortByAlphabet(List<String> list) {
        List<String> result = new ArrayList<>(list);
        result.sort(null);
        return result;
    }

    private static List<String> sortByLengthLine(List<String> list) {
        List<String> result = new ArrayList<>(list);
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.length() - o2.length(); - решение для чисел
                return Integer.compare(o1.length(), o2.length());
            }
        });
        return result;
    }

    private static List<String> sortByLengthLineLambda(List<String> list) {
        List<String> result = new ArrayList<>(list);
//        result.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        result.sort(Comparator.comparing((String::length)));
        return result;
    }


    private static List<String> reverseList(List<String> list) {
        List<String> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    private static List<String> createListNames() {
        List<String> list = new ArrayList<>();
        list.add("Константин");
        list.add("Василий");
        list.add("Семён");
        list.add("Кирилл");
        list.add("Артём");
        list.add("Сергей");
        list.add("Татьяна");
        list.add("Елена");
        list.add("Наталья");
        list.add("Ирина");
        list.add("Светлана");

        return list;
    }
}
