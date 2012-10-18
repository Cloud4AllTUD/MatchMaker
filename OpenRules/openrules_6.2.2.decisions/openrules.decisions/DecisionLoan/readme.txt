OpenRules Sample Project "Loan1"
===============================

What's Being Demonstrated
-------------------------

This basic rules project demonstrates business rules for loan pre-qualification.
This Demo implements a use case provided by KPI, http://www.kpiusa.com.

How It Is Organized
-------------------

This project contains only one main xls-file rules/Load1.xls that includes:
1) Business glossary including datatypes LoanRequest and Customer, and also
several standard lists 
2) Test data
3) Two family of rules for income validation and debt research
4) a launching method main().

There are several more worksheets that demonstrate different implementations of 
the rules family 212. You may read more about use of natural language expressions
at http://openrules.com/docs/NL.htm). These rules tables are commented out 
(there is "//" in front of the key word "Rules"). 

The rules are launched from a Java program presented in the class
Main.java.

How to Build
------------

You can make changes using Excel only. After saving Excel files no rebuild is
required. 

How to Run
----------

Double-click to the run.bat to run this console application and see
results in a DOS view.

Dependencies
------------
This project depends on openrules.config that is supposed to be at the
same directory level as this project.

