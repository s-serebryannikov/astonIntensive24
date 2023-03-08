package ru.serebryannikov.arrayListImp;

import java.util.Comparator;

/**
 * Класс для выполнения быстрой сортировки (quickSort) списка ArrayListImp<E>.
 */
public class SotrUtil {

    /**
     * Сортирует указанный список в соответствии с порядком, заданным указанным компаратором.
     * Все элементы в списке должны быть взаимно сравнимы с использованием указанного компаратора
     * (то есть c.compare(e1, e2) не должен вызывать исключение ClassCastException для любых элементов e1 и e2 в списке).
     * @param arrayListImp - список для сортировки
     * @param comparator - компаратор для определения порядка списка.
     */
    public static <T> void quickSort(ArrayListImp<T> arrayListImp, Comparator<T> comparator) {
        quickSort(arrayListImp, comparator, 0, arrayListImp.size() - 1);
    }

    /**
     * Сортирует указанный список в порядке возрастания в соответствии с
     * естественным порядком расположения его элементов.
     * Все элементы в списке должны реализовывать интерфейс Comparable.
     * @param arrayListImp - список для сортировки
     */
    public static <T extends Comparable<T>> void quickSort(ArrayListImp<T> arrayListImp) {
        quickSort(arrayListImp, 0, arrayListImp.size() - 1);
    }

    private static <T> void quickSort(ArrayListImp<T> list, Comparator<T> comparator, int f, int t) {
        int from = f;
        int to = t;

        if (to > from) {
            T pivot = list.get((from + to) / 2);
            while (from <= to) {
                while (from < t && comparator.compare(list.get(from), pivot) < 0) {
                    from += 1;
                }
                while (to > f && comparator.compare(list.get(to), pivot) > 0) {
                    to -= 1;
                }
                if (from <= to) {
                    swap(list, from, to);
                    from += 1;
                    to -= 1;
                }
            }
            if (f < to) quickSort(list, comparator, f, to);
            if (from < t) quickSort(list, comparator, from, t);
        }
    }

    private static <T extends Comparable<T>> void quickSort(ArrayListImp<T> list, int left, int right) {
        int ll = left;
        int rr = right;

        if (rr > ll) {
            T pivot = list.get((ll + rr) / 2);
            while (ll <= rr) {
                while (ll < right && list.get(ll).compareTo(pivot) < 0) {
                    ll += 1;
                }
                while (rr > left && list.get(rr).compareTo(pivot) > 0) {
                    rr -= 1;
                }
                if (ll <= rr) {
                    swap(list, ll, rr);
                    ll += 1;
                    rr -= 1;
                }
            }
            if (left < rr) quickSort(list, left, rr);
            if (ll < right) quickSort(list, ll, right);
        }
    }

    private static <T> void swap(ArrayListImp<T> arrayListImp, int left, int right) {
        T temp = arrayListImp.get(left);
        arrayListImp.set(left, arrayListImp.get(right));
        arrayListImp.set(right, temp);
    }
}
