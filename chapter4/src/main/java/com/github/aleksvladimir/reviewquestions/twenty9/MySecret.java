package com.github.aleksvladimir.reviewquestions.twenty9;

/*
29. Which lambda can replace the MySecret class to return the same value? (Choose
all that apply)
A. caller((e) -> "Poof");
B. caller((e) -> {"Poof"});
C. caller((e) -> { String e = ""; "Poof" });
D. caller((e) -> { String e = ""; return "Poof"; });
E. caller((e) -> { String e = ""; return "Poof" });
F. caller((e) -> { String f = ""; return "Poof"; });
 */

interface Secret {
    String magic(double d);
}

class MySecret implements Secret {
    public String magic(double d) {
        return "Poof";
    }
}
