package com.github.aleksvladimir.methodsandencapsulation.writingsimplelambdas.prdicates;

/*
Лямбды работают с интерфейсами, которые имеют только один метод.
Они называются функциональными интерфейсами,
которые могут быть использованы при функциональном программировании.
(На самом деле все гораздо сложнее, но для экзамена OCA это определение прекрасно.)

Lambdas work with interfaces that have only one method.
These are called functional interfaces—interfaces that can be used with functional programming.
(It’s actually more complicated than this, but for the OCA exam this defi nition is fine.)
 */

/*
Мы можем использовать уже имеющийся интерфейс в Java, чтобы не писать самим каждый новый
интерфейс для лямбд. Такой интерфейс называется предикатом:
    public interface Predicate<T> {
    boolean test(T t);
    }
 располагается в import java.util.function.*; мы можем исопльзовать его без необходимости
 писать дополнительный код.
*/

import com.github.aleksvladimir.methodsandencapsulation.writingsimplelambdas.first.Animal;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;

public class PredicateSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, true));
        print(animals, (Animal a) -> {
            return a.canHop();
        });
        print(animals, a -> a.canHop());
        print(animals, Animal::canHop);
     }

    private static void print(List<Animal> animals, Predicate<Animal> checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.print(animal + " ");
            }
            System.out.println();
        }
    }
}
