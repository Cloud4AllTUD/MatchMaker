OpenRules Sample Project "DecisionUpSell"
========================================

What's Being Demonstrated
-------------------------

This decision model demonstrates how complex up-sell rules 
can be organized in simple rule families tables. While the presented rules are using
financial products,  lists of products and services can be easily adjust
to any industry. 

How It Is Organized
-------------------

This project contains only one main xls-file rules/DecisionUpSell.xls that includes:
1) Decision table that defines 3 decisions:
- Define Customer Profile
- Define Up-Sell Products
- Show Results
2) Business glossary that describe needed fact types for business concepts Customer
and Response
3) Two rule families
- DefineCustomerProfile
- DefienUpSellProducts that deals with multiple choices of products and uses such 
operators as "Is One Of", "Include", "Do not include", "Are"
4) Test Data that shows how to define arrays.


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

