OpenRules Sample Project "DecisionHelloDB"
============================================

What's Being Demonstrated
-------------------------

This is a basic rules project is similar to DecsionHello but customers 
are being received from a database using two simple JDBC interfaces 
included in the project com.openrules.tools. 


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

The test data comes from a database (see db/TestDB.mdb) that should be added to the system Data Sources
under the name "TestDB". We assume that this database is created using an RDBMS such
as MS Access. It should contain a table "Customers" with teh following fields:

- CustomerName
- MaritalStatus
- Gender
- Age.

There two different DB interfaces:
1) TestDB.java and Main.java that is based on DbUtil
2) MainDatabaseIterator that is based on DatabaseIterator.


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
same directory level as the project DecisionHelloDB.

