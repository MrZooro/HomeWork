package filter;

public interface Filter<T> {
    /**
     * Применяет фильтр к элементу
     */
    T apply(T o);
}
