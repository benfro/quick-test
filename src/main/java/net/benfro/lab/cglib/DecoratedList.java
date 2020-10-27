package net.benfro.lab.cglib;

import com.google.common.collect.Maps;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * A container where an object's index are held in a map
 * @param <T>
 */
public class DecoratedList<T> {

   private final HashMap<T, Integer> theMap;
   private final ArrayList<T> proxy;

   public DecoratedList(ArrayList<T> theList) {
      this.theMap = Maps.newHashMap();
      this.proxy = getProxy(theList);
      theList.forEach(e -> proxy.add(e));
   }

   private ArrayList<T> getProxy(ArrayList<T> theList) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(ArrayList.class);
      enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
         if (method.getDeclaringClass() != Object.class
                  //&& method.getReturnType() == Boolean.class
                  && method.getName().equals("add")) {
            if (args.length == 1) {
               theMap.put((T) args[0], theList.indexOf(args[0]));
            } else if (args.length == 2) {
               theMap.put((T) args[1], (Integer)args[0]);
            }
         }
         return proxy.invokeSuper(obj, args);
      });

      return (ArrayList<T>) enhancer.create();
   }

   HashMap<T, Integer> getBackingMap() {
      return theMap;
   }

   public void trimToSize() {
      proxy.trimToSize();
   }

   public void ensureCapacity(int minCapacity) {
      proxy.ensureCapacity(minCapacity);
   }

   public int size() {
      return proxy.size();
   }

   public boolean isEmpty() {
      return proxy.isEmpty();
   }

   public boolean contains(Object o) {
      return proxy.contains(o);
   }

   public int indexOf(Object o) {
      return proxy.indexOf(o);
   }

   public int lastIndexOf(Object o) {
      return proxy.lastIndexOf(o);
   }

   public Object[] toArray() {
      return proxy.toArray();
   }

   public <T1> T1[] toArray(T1[] a) {
      return proxy.toArray(a);
   }

   public T get(int index) {
      return proxy.get(index);
   }

   public T set(int index, T element) {
      return proxy.set(index, element);
   }

   public boolean add(T t) {
      return proxy.add(t);
   }

   public void add(int index, T element) {
      proxy.add(index, element);
   }

   public T remove(int index) {
      return proxy.remove(index);
   }

   public boolean remove(Object o) {
      return proxy.remove(o);
   }

   public void clear() {
      proxy.clear();
   }

   public boolean addAll(Collection<? extends T> c) {
      return proxy.addAll(c);
   }

   public boolean addAll(int index, Collection<? extends T> c) {
      return proxy.addAll(index, c);
   }

   public boolean removeAll(Collection<?> c) {
      return proxy.removeAll(c);
   }

   public boolean retainAll(Collection<?> c) {
      return proxy.retainAll(c);
   }

   public ListIterator<T> listIterator(int index) {
      return proxy.listIterator(index);
   }

   public ListIterator<T> listIterator() {
      return proxy.listIterator();
   }

   public Iterator<T> iterator() {
      return proxy.iterator();
   }

   public List<T> subList(int fromIndex, int toIndex) {
      return proxy.subList(fromIndex, toIndex);
   }

   public void forEach(Consumer<? super T> action) {
      proxy.forEach(action);
   }

   public Spliterator<T> spliterator() {
      return proxy.spliterator();
   }

   public boolean removeIf(Predicate<? super T> filter) {
      return proxy.removeIf(filter);
   }

   public void replaceAll(UnaryOperator<T> operator) {
      proxy.replaceAll(operator);
   }

   public void sort(Comparator<? super T> c) {
      proxy.sort(c);
   }

   public boolean containsAll(Collection<?> c) {
      return proxy.containsAll(c);
   }

   public <T1> T1[] toArray(IntFunction<T1[]> generator) {
      return proxy.toArray(generator);
   }

   public Stream<T> stream() {
      return proxy.stream();
   }

   public Stream<T> parallelStream() {
      return proxy.parallelStream();
   }

   public static <E> List<E> of() {
      return List.of();
   }

   public static <E> List<E> of(E e1) {
      return List.of(e1);
   }

   public static <E> List<E> of(E e1, E e2) {
      return List.of(e1, e2);
   }

   public static <E> List<E> of(E e1, E e2, E e3) {
      return List.of(e1, e2, e3);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4) {
      return List.of(e1, e2, e3, e4);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5) {
      return List.of(e1, e2, e3, e4, e5);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
      return List.of(e1, e2, e3, e4, e5, e6);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
      return List.of(e1, e2, e3, e4, e5, e6, e7);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
      return List.of(e1, e2, e3, e4, e5, e6, e7, e8);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
      return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
   }

   public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
      return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
   }

   @SafeVarargs
   public static <E> List<E> of(E... elements) {
      return List.of(elements);
   }

   public static <E> List<E> copyOf(Collection<? extends E> coll) {
      return List.copyOf(coll);
   }
}
