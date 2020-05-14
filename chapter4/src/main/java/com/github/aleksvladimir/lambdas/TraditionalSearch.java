package com.github.aleksvladimir.lambdas;

import java.util.List;
import java.util.ArrayList;

public class TraditionalSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        print(animals, new CheckIfHopper());    // pass class that does check
        print(animals, a -> a.canHop());        // pass lambda that does check
        print(animals, a -> a.canSwim());
        print(animals, a -> !a.canSwim());

        /*
        Java relies on context when figuring out what lambda expressions mean.
        We are passing this lambda as the second parameter of the print() method.
        That method expects a CheckTrait as the second parameter.
        Since we are passing a lambda instead, Java tries to map our lambda to that interface:
            boolean test(Animal a);
        Java полагается на контекст когда выясняет что означает выражение лямбда.
        Мы пропускаем эту лямбду как второй параметр метода print().
        Этот метод ожидает CheckTrait как второй параметр.
        Поскольку мы пропускаем лямбду вместо него, Java пытается сопоставить нашу лямбду с этим интерфейсом:
            boolean test(Animal a);
        * */
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) { // the general check
                System.out.print(animal + " ");
            }
            System.out.println();
        }
    }
}
