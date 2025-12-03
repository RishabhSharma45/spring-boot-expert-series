Chapter 2 — When, Where & How?

📌 When & Where Java Started
Started at Sun Microsystems, 1991
Released publicly in 1995
Built initially for consumer electronics
Later adopted for enterprise systems, mobile devices, and the web

HOW Java Works (The Core Mechanisms)
1. How Java Became Platform Independent
First, why C/C++ are not platform independent:
In C/C++, code compiles directly to machine code, which is OS-specific.

Windows → .exe
Linux → .out

Even the system libraries differ:

#include <windows.h>
This code can never run on Linux.

Now see Java’s approach
class Solution {
    public static void main(String[] args){
        System.out.println("Rishabh");
    }
}


When compiled:

javac Solution.java → Solution.class (bytecode)


This bytecode:
Is OS-independent
Does NOT depend on any system library
Can run anywhere JVM exists

Windows JVM ≠ Linux JVM
But both understand the same bytecode.

Java Execution Flow
C/C++ → Machine Code
Java  → Bytecode → JVM → Machine Code

✔ That’s why Java is platform independent.

2. How Java Became Safe & Secure

Why C/C++ is unsafe?

Pointers → direct memory access
Buffer overflow
Manual memory management
Dangling pointers
No runtime checks
No sandbox environment

Example:

char name[5];
strcpy(name, "RISHABH");  // buffer overflow

How Java Handles All of This

❌ No pointers

✔ Automatic memory management

✔ Array bound checks → ArrayIndexOutOfBoundsException

✔ Bytecode verification

✔ Security Manager (sandboxing)

✔ JVM as a protection layer

✔ No direct access to system memory

Java code always runs inside JVM, never directly on OS.

3. Java Automatic Memory Management
Java Memory Model
+----------------------+
|      STACK           |
+----------------------+
|      HEAP            |
+----------------------+

Stack:

Local variables

Primitive values

Method calls (fast)

Heap:

Objects

Arrays

Strings
(Managed by Garbage Collector)

Object Lifecycle
Student s = new Student();
s = null;


JVM sees:

❌ no live reference
✔ mark object as garbage

Garbage Collection Process

1️⃣ Mark → find reachable objects
2️⃣ Sweep → remove unreachable
3️⃣ Compact → remove gaps and rearrange memory

This keeps memory optimized without manual free().
