# This file is located in "robot" folder

*** Settings ***
Documentation   CommonResource file with KWs
Library         OperatingSystem

*** Variables ***
${SRC_PATH}    %{user.dir}\\target\\classes\\

*** Keywords ***
Check Path
    [Arguments]  ${class_name}  ${output}=${SRC_PATH}${class_name}
    Log     Running: ${output}    WARN
    [return]    ${output}

Run Java Class
    [Arguments]  ${class_name}  ${path}=${SRC_PATH}
    ${output}=   Run    java -cp ${path} ${class_name}
    Log     ${output}   WARN
    [return]    ${output}

Run Java Class With Args
    [Arguments]  ${class_name}  ${args}     ${path}=${SRC_PATH}
    ${output}=   Run    java -cp ${path} ${class_name} ${args}
    Log     ${output}   WARN
    [return]    ${output}