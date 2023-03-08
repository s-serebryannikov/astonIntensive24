package ru.serebryannikov.arrayListImp;

import java.util.Arrays;

/**
 * Реализация массива с изменяемым размером. Разрешается хранение любых элементов.
 * Операции size, get, set - выполняются за постоянное время.Все остальные операции выполняются за линейное время.
 * Каждый экземпляр ArrayListImp имеет емкость. Емкость — это размер массива, используемого для хранения элементов списка.
 * По мере добавления элементов в список ArrayListImp его емкость автоматически увеличивается в 2 раза.
 */
public class ArrayListImp<E> {

    /**
     * Размер массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    private E[] arr;
    private int capacity;
    private int count;

    /**
     * Создает пустой список с начальной емкостью по умолчанию.
     */
    public ArrayListImp() {
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (E[]) new Object[capacity];
    }

    /**
     * Создает пустой список с указанной начальной емкостью.
     * @param capacity - начальная емкость списка.
     */
    public ArrayListImp(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
    }

    /**
     * Возвращает элемент по индексу в этом списке.
     * @param index - индекс возвращаемого элемента.
     */
    public E get(int index) {
        if (index < 0 || index > this.count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.arr[index];
    }

    /**
     * Добавляет указанный элемент в конец этого списка.
     * @param value - Элемент который требуется добавить.
     */
    public void add(E value) {
        if (count == capacity) {
            E[] newArr = Arrays.copyOf(this.arr, this.capacity * 2);
            this.capacity *= 2;
            this.arr = newArr;
        }
        arr[count] = value;
        count++;
    }

    /**
     * Удаляет элемент в указанной позиции в этом списке. Сдвигает любые последующие элементы влево.
     * @param index - индекс элемента который требуется удалить.
     * @return возвращает элемент, который был удален из списка.
     */
    public E remove(int index) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException();
        }
        E value = this.arr[index];
        this.arr[index] = null;
        shift(index);
        this.count--;
        return value;
    }

    /**
     * Возвращает количество элементов в списке
     */
    public int size() {
        return count;
    }

    /**
     * Возвращает true, если этот список содержит указанный элемент.
     * @param value - элемент который требуется проверить
     */
    public boolean contains(E value) {
        for (E j : arr)
            if (j == value)
                return true;
        return false;
    }

    /**
     * Заменяет элемент в указанной позиции в этом списке указанным элементом.
     * @param index - индекс возвращаемого элемента
     * @param value - элемент, который будет сохранен в указанной позиции
     */
    public void set(int index, E value) {
        arr[index] = value;
    }

    /**
     * Удаляет все элементы из этого списка.
     */
    public void clear() {
        for (int i = 0; i < count; i++) {
            arr[i] = null;
        }
        capacity = DEFAULT_CAPACITY;
        count = 0;
    }

    private void shift(int index) {
        for (int i = index; i < count - 1; i++) {
            E temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
