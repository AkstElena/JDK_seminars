package seminar3.task3;

/*
Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа,
содержащим любые типы данных. Итераторы обычно имеют только два метода – проверка на наличие
следующего элемента и переход к следующему элементу. Но также, особенно в других языках программирования,
возможно встретить итераторы, реализующие дополнительную логику.
 */

import java.util.Iterator;
import java.util.List;

public class MyIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(index - 1);
    }
}