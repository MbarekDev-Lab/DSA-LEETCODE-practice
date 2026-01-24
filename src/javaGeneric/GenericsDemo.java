package javaGeneric;

import java.util.ArrayList;
import java.util.List;

/* =====================================================
 * Generic Interface
 * =====================================================
 */
interface Container<T> {
    void add(T item);

    T get();
}

/**
 * =====================================================
 * Java Generics
 * =====================================================
 * This file demonstrates:
 * - Generic classes
 * - Bounded type parameters
 * - Wildcards (?, extends, super)
 * - Generic interfaces
 * - Multiple type parameters
 */

public class GenericsDemo {

    static void main(String[] args) {

        /* ---------------------------------------------
         * Generic Class Example
         * ---------------------------------------------
         */
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();

        stringBox.add("mbarek");
        integerBox.add(1);

        for (String s : stringBox.getAll()) {
            System.out.println(s);
        }

        for (Integer i : integerBox.getAll()) {
            System.out.println(i);
        }

        /* ---------------------------------------------
         * Bounded Type Parameter (extends Number)
         * ---------------------------------------------
         */
        Calculator<Double> calc = new Calculator<>(5.5);
        System.out.println("Square: " + calc.square());

        /* ---------------------------------------------
         * Wildcards Examples
         * ---------------------------------------------
         */
        List<Integer> numbers = new ArrayList<>();
        Calculator.addIntegers(numbers);

        Calculator.printList(numbers);
        System.out.println("Sum: " + Calculator.sum(numbers));
    }

    /*
        mbarek
        1
        Square: 30.25
        10
        20
        Sum: 30.0
     */
}

/* =====================================================
 * Generic Class
 * =====================================================
 * T can be any reference type
 */
class Box<T> {
    private final List<T> values = new ArrayList<>();

    public void add(T value) {
        values.add(value);
    }

    public List<T> getAll() {
        return values;
    }
}

/* =====================================================
 * Bounded Generics (T extends Number)
 * =====================================================
 * Restricts T to Number or its subclasses
 */
class Calculator<T extends Number> {

    private final T number;

    Calculator(T number) {
        this.number = number;
    }

    /* ---------------------------------------------
     * Lower bounded wildcard (? super Integer)
     * Allows adding Integer values
     * ---------------------------------------------
     */
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    /* --------------------------------------------
     * Upper bounded wildcard (? extends Number)
     * Read only access to Number types
     * ---------------------------------------------
     */
    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    /* ---------------------------------------------
     * Unbounded wildcard (?)
     * Accepts any type
     * ---------------------------------------------
     */
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }
}

/* =====================================================
 * Multiple Type Parameters
 * =====================================================
 */
class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

/* =====================================================
 * Generic Interface Implementation
 * =====================================================
 */
class StringContainer implements Container<String> {

    private String item;

    @Override
    public void add(String item) {
        this.item = item;
    }

    @Override
    public String get() {
        return item;
    }
}
