# These test cases can be run with mvn install

*** Settings ***
Documentation   Testing if the program works as intended
Resource        ../Common_Resource.robot

*** Variables ***
${mainClass}    com.pjwstk.Application

*** Test Cases ***
Path to main class should be correct
    ${result} =  Check Path  ${mainClass}
    Should contain  ${result}   target\\classes\\${mainClass}

Should return warning if no arguments are provided
    ${result} =  Run Java Class  ${mainClass}
    Should be equal as strings     ${result}   Error: Amount of input parameters must be either 3 or 4\nCan you build figure from provided sides?\nfalse

Should return true when given 3 identical sides
    ${result} =  Run Java Class With Args  ${mainClass}   1 1 1
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return true when given a valid triangle #1
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 1
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return true when given a valid triangle #2
    ${result} =  Run Java Class With Args  ${mainClass}   3 4 5
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return false when given an invalid triangle #1
    ${result} =  Run Java Class With Args  ${mainClass}   2 3 15
    Should be equal as strings     ${result}   Can you build figure from provided sides?\nfalse

Should return true when given four indentical sides (square)
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 2 2
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return true when given four indentical sides (rectangle)
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 4 4
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return false when you can't make a figure (one side way too long)
    ${result} =  Run Java Class With Args  ${mainClass}   2 3 4 200
    Should be equal as strings     ${result}   Can you build figure from provided sides?\nfalse

Should return true when given four valid sides (trapezoid)
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 2 4
    Should be equal as strings     ${result}   Can you build figure from provided sides?\ntrue

Should return false when given four invalid sides (trapezoid)
    ${result} =  Run Java Class With Args  ${mainClass}   2 22 2 442
    Should be equal as strings     ${result}   Can you build figure from provided sides?\nfalse