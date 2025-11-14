# KMP String Matching Algorithm Implementation

This repository contains a clean and efficient implementation of the **Knuth-Morris-Pratt (KMP)** string matching algorithm in Java. The project is structured for clarity, readability, and academic use, with comprehensive documentation in multiple languages.

Algorithm Overview

The **KMP algorithm** finds all occurrences of a pattern within a text string in linear time:
- **Time Complexity**: O(n + m)
- **Space Complexity**: O(m)
- **Key Feature**: Uses the LPS (Longest Prefix Suffix) array to avoid backtracking in the text.

Ideal for large-scale text processing and algorithmic analysis.

Test Cases

The implementation has been tested on three types of input:
1. **Short Pattern**: `"ABABCABAB"` in small text
2. **Medium Text**: Search for `"M5 F90"` in car-related descriptions
3. **Long Text**: Simulated real-world data with repeated keywords

All tests confirm correct match detection without false positives.

 How to Run

Prerequisites
- Java 8 or higher
- Terminal or command line

Steps
1. Compile the code:
   ```bash
   javac src/main/java/KMPMatcher.java
