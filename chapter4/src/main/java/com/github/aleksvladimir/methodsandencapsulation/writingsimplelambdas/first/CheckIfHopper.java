package com.github.aleksvladimir.methodsandencapsulation.writingsimplelambdas.first;

public class CheckIfHopper implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}
