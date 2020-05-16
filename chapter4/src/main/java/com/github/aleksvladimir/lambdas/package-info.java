/**
 * Package for practice by "Writing Simple Lambdas".
 * "In this section, we’ll cover an example of why lambdas are helpful,
 * the syntax of lambdas, and how to use predicates."
 *
 * @author Vladimir Aleksandrov (aleksvladimir@list.ru)
 * @version $Id$
 * @since 0.1
 */

/**
 * Summary.
 * Lambda expressions, or lambdas, allow passing around blocks of code.
 * The full syntax looks like (String a, String b) -> { return a.equals(b); }.
 * The parameter types can be omitted.
 * When only one parameter is specified without a type, the parentheses can also be omitted.
 * The braces and return statement can be omitted for a single statement, making
 * the short form (a -> a.equals(b)).
 * Lambdas are passed to a method expecting an interface with one method.
 * Predicate is a common interface. It has one method named test
 * that returns a boolean and takes any type.
 * The removeIf() method on ArrayList takes a Predicate.
 */

package com.github.aleksvladimir.lambdas;