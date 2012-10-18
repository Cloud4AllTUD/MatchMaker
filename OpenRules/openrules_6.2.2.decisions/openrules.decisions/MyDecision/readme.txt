OpenRules Sample Project "DecisionHelloJava"
============================================

What's Being Demonstrated
-------------------------

This is a basic rules project that demonstrates how to develop a very simple 
application that should decide how to greet a customer during different 
times of the day. The proper “decision model” might be a part of an 
interactive voice response (IVR) system.  For example, if a customer 
Robinson is a married woman and local time is 14:25, we want our decision 
model to produce a greeting like "Good Afternoon, Mrs. Robinson!"

This project is similar to the project "DecisionHello: with one difference:
test objects are defined in Java instead of in Excel. Rules and Glossary
remain the same.

How It Is Organized
-------------------

This project contains one main xls-file rules/main/Decision.xls and 2 included files:
- rules/include/Gloassary.xls
- rules/include/Rules.xls.

Decison.xls contains an Environment table that describes the project structure and 
also refers to the standard template DecisionTemplates.xls that is located in the
standard project openriles.config (3 levels higher than Decision.xls). The
Environment table also contains a reference (import.java) to Java classes that
define test Java objects Customer and Response.

The main decision "DetermineCustomerGreeting" consists of three decisions:
- Define Current Time
- Define Greeting Word
- Define Salutation Word

The proper rule families are located in the file Rules.xls. The file Glossary.xls
describes all fact types used in the rule families with related business 
concepts (Customer and Response) and attributes.

The test data comes from Java, so there is no file like Data.xls. The table 
"DecisionObject" in the main file Decision.xls maps business concepts to 
Java-based test objects described in src/hello/Customer.java and 
src/hello/Response.java. The standard Java class Main.java creates concrete
instances for Customer and Response, creates and executes 
the Decision "DetermineCustomerGreeting". 

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
same directory level as the project DecisionHello.

