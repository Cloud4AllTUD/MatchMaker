OpenRules Sample Project "HelloCustomer"
=======================================

What's Being Demonstrated
-------------------------

This is a basic rules project that shows how rules defined in Excel files. 
It also shows how to define data types and test data in Excel tables
and test basic rule services.

How It Is Organized
-------------------

This project does not include Java code at all. All rules are located in the 
folder "rules". The main xls-file "Main.xls" is placed directly in the source
folder "rules/main". Its location is defined in the file build.properties as:

main.xls.file=file:rules/main/Main.xls

Its main method "main" is described using the following property:

main.xls.method=main

There are two more included Excel files "Data.xls" and "Rules.xls":
1) Data.xls  defines datatypes App and Customer in simples Excel tables
2) Rules.xls with two decision tables defineGreeting and defineSalutation.  

While we could keep all files in the folder "rules" (or even to place all tables
from these files directly in the file Hello.xls) for demonstration purposes
we decided to put these files into the folder "rules/include". The information
where include-files are located is kept inside the main xls file Hello.xls. 
Look at the table "Environment" inside Hello.xls. It refers to the include 
files as:
	
	../include/Data.xls
	../include/Rules.xls

It means that the included file are described relatively to the location of
the main file Hello.xls - in our case this location is the folder "rules/main".

An alternative way to define included files in the table "Environment" is to 
introduce an additional property "include.path" as "file:rules/include/" and 
inside the property "include" use the names of the included files in corner 
brakets:

	<Data.xls>
	<Rules.xls>
	
Note. If you use Eclipse, it is more practical to keep main xls-file in "source"
folders while included xls-files should be placed in simple (non-source) folders.
It is important because Eclipse's plugin tries automatically to validate all
xls-files in source folders and produces errors if any. 

How to Build
------------

You can make changes using Excel only. After saving Excel files no rebuild is
required. 

How to Run
----------

Execute the target "run" from build.xml. In Windows, just double-click to 
the run.bat to run this console application and see results in a DOS view.

Dependencies
------------
This project depends on openrules.config that is supposed to be at the
same directory level as the project HelloCustomer.

