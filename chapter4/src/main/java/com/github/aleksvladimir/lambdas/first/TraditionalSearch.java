package com.github.aleksvladimir.lambdas.first;

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
        Since that interface’s method takes an Animal, that means the lambda parameter has to
        be an Animal. And since that interface’s method returns a boolean, we know the lambda
        returns a boolean.
        Java полагается на контекст когда выясняет что означает выражение лямбда.
        Мы пропускаем эту лямбду как второй параметр метода print().
        Этот метод ожидает CheckTrait как второй параметр.
        Поскольку мы пропускаем лямбду вместо него, Java пытается сопоставить нашу лямбду с этим интерфейсом:
            boolean test(Animal a);
        Поскольку этот метод интерфейса принимает Animal, это означает, что параметр лямбды
        должен быть Animal. И поскольку этот метод интерфейса возвращает boolean, мы знаем
        что лямбда возвращает boolean.
        * */

        // success compile
        //print(() -> true); // 0 parameters
        //print(a -> a.startsWith("test")); // 1 parameter
        //print((String a) -> a.startsWith("test")); // 1 parameter
        //print((a, b) -> a.startsWith("test")); // 2 parameters
        //print((String a, String b) -> a.startsWith("test")); // 2 parameters

        // error compile
        //print(a, b -> a.startsWith("test")); // DOES NOT COMPILE - скобки опицональны только еслиодин параметр и не объявлен тип
        //print(a -> { a.startsWith("test"); }); // DOES NOT COMPILE - пропущен return когда есть фигурные скобки
        //print(a -> { return a.startsWith("test") }); // DOES NOT COMPILE - пропущена точка с запятой когда есть фигурные скобки

        //Lambdas are allowed to access variables. Here’s an
        //example:
        boolean wantWhetherCanHop = true;
        print(animals, a -> a.canHop() == wantWhetherCanHop);
        //The trick is that they cannot access all variables. Instance and static variables are okay.
        //        Method parameters and local variables are fi ne if they are not assigned new values.
        //(a, b) -> { int a = 0; return 5; } // DOES NOT COMPILE - Since Java doesn’t allow us to redeclare "a" local variable. We tried to redeclare a, which is not allowed
        //(a, b) -> { int c = 0; return 5; }  // uses a different variable name
        print(animals, a -> {
            //int a = 0; // error compile - Variable 'a' is already defined in the scope
            return !a.canSwim();
        });
        print(animals, a -> {
            int b = 0;  // success compile
            return !a.canSwim();
        });
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
