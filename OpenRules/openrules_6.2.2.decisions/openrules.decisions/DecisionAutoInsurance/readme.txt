OpenRules Sample Project "AutoInsurance"
=======================================

What's Being Demonstrated
-------------------------

This is a decision project that shows how to organize complex
rules-based calculations creating an auto insurance premium calculator. 
It demonstrates how to use OpenRules' data modeling mechanism
for complex data structures with internal dependencies. It also
demonstrates complex calculation methods. 

How It Is Organized
-------------------

This project consists of one main file Decision.xls and several
included files.

The Main.javat:
- creates a new policy with drivers, vehicles, and usages read from Data.xls
- creates and executes a decision based on Decision.xls.

The decision:
- execute policy validation rules and display rejection reasons (if any)
- calculates the policy premium using rules for designation of drivers
to vehicles, vehicles and drivers discounts.

The file Data.xls defines complex data structures with
cross-references. The data is used for premium calculations.

The file ValiadationRules.xls contains decision tables with policy
validation rules.

The file DiscountRules.xls contains decision tables for driver/vehicle discount rules.

The file PremiumCalculationRules.xls contains various calculation methods 
using the above rules. While it could be more natural to keep such methods
in Java (they are Java code presented in Excel tables), this sample keeps
everything in Excel to make it available without necessity to use a Java IDE.
 
How to Build
------------

The project is automatically built under Eclipse when you make changes in it.

 
What Gets Generated
-------------------

Nothing. 
 
How to Run
----------

Double-click to the AutoInsurance/run.bat to run this  console 
application and see results in a DOS view.

