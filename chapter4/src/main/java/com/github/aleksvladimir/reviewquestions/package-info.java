/**
 * Appendix A. Answers to Review Questions
 */

/*

26. What is the result of the following class?
A. This code is correct. Line 8 creates a lambda expression that checks if the age is less
than 5. Since there is only one parameter and it does not specify a type, the parentheses
around the type parameter are optional. Line 10 uses the Predicate interface, which
declares a test() method.

27. C. The interface takes two int parameters. The code on line 7 attempts to use them as
if one is a StringBuilder. It is tricky to use types in a lambda when they are implicitly
specified. Remember to check the interface for the real type.

28. A, D, F. removeIf() expects a Predicate, which takes a parameter list of one parameter using the specified type. Options B and C are incorrect because they do not use the
return keyword. It is required inside braces for lambda bodies. Option E is incorrect
because it is missing the parentheses around the parameter list. This is only optional
for a single parameter with an inferred type

 */

package com.github.aleksvladimir.reviewquestions;