package filter;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    /**
     * Применяет действие из фильтра к каждому элементу массива
     *
     * @param array массив с элементами, может быть любого типа
     * @param filter объект класса, который реализует интерфейс {@link Filter}
     * @return обновлённый массив, в котором к каждому элементу применено действие
     * @throws IllegalArgumentException если {@code array} или {@code filter} равен {@code null}
     */
    public static <T> T[] filter(T[] array, Filter<T> filter) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр не может быть null");
        }

        // Создаем новый массив того же типа
        T[] result = Arrays.copyOf(array, array.length);

        // Применяем фильтр к каждому элементу
        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        Filter<Integer> doubleFilter = n -> n * 2;
        numbers = filter(numbers, doubleFilter);
        System.out.println(Arrays.toString(numbers));

        String[] strings = {"FIRST", "first", "FIRst"};
        Filter<String> allUppercaseFilter = n -> n.toUpperCase(Locale.ROOT);
        strings = filter(strings, allUppercaseFilter);
        System.out.println(Arrays.toString(strings));

        Filter<String> allToLowerCase = n -> n.toLowerCase(Locale.ROOT);
        strings = filter(strings, allToLowerCase);
        System.out.print(Arrays.toString(strings));
    }
}


