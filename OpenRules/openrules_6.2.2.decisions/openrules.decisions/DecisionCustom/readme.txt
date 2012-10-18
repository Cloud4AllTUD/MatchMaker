OpenRules Sample Project "DecisionCustom"
========================================

What's Being Demonstrated
-------------------------

This decision model demonstrates how to add custom decision tables based
on custom decision templates. It uses a decision table called "DecisionTableCustom" 
created based on an additional project-specific template "DecisionTableCustomTemplate"
described in the file "DecisionTableCustomTemplates.xls". 

How to Build
------------

The project is automatically built under Eclipse when you make changes in it.
When used outside Eclipse, use compile.bat (executes target "compile.java" 
from build.xml) to validate and build the application.

How to Run
----------

Double-click to the run.bat (executes target "run" from build.xml) to run this 
console application and see results in a DOS view.
File build.properties allows you to change the name of the main Java file and 
main xls-file and methods without re-compilation.

Dependencies
------------
This project depends on openrules.config that is supposed to be at the
same directory level as this project.

