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