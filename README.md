# Introduction

This is part of a timed assessment to assess my java skills. The project can be built using Gradle.

# Anagram Checker 
Develop a program to accept a username and 2 text values and return an indicator whether the values are an anagram.
A word is an anagram of another word if both use the same letters in the same quantity, but arranged differently.  For example 'friend' and 'finder'.
The delivered program should compile and run.  Include appropriate usage documentation.  Please state any assumptions you have made.

# Requirements
* For the first release, input values with the following must be: spaces, numbers. 
* Each time values and results are processed, they should be written to the following: an extranl file, and a cache (i.e. an Array). 
* Other developers must be able to change code safetly; protect your code with tests. 
* The file should be appended to, not overwritten. 
* Support teams must be able to deal with issues; this can be achieved with good logging. 
* Improve performance by checking new requests against the cache, prior to processing.
* The input values in the file and cache should be unique.
* Validate that the inputs do not have special characters
* The solution must have the ability to easily add further validations over time – could you use a Factory pattern?
* Upon start-up, populate the cache with the previous results stored in the file.
