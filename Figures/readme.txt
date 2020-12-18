Updated bug from class "SquareFactory" method "createAndPrintTriangle". New method "createAndPrintSquare" now available.
Updated implementation:
created FigureStrategyInterface with 2 children classes which realized Singleton pattern.
For triangle figure used Enum class strategy.
For square figure used simple class.

Created classes "MultiAngleFigure" and "MultiAngleFactory" where implemented possibility to create several figures with 
number of points >=4 and <=6 (implementation can be easily modified with such way so number of points will be unlimitted).
Updated class "Square" which now is Singleton class (in "SquareFactory" class in array exists two objects and points generated
randomly -> as result in log file logs will be the same).
Updated packaging structure. Now it implemented with such way so figure objects will be created only from factory classes.

Updated implementation:
now there is possibility set array length for figures from Main.
Added new exception classes.
Added pre and post processor classes. 
PreProcessor works with points before creation of object and check if points are equals.
PostProcessor works with figures. Return true if figure is valid.

Updated implementation.
Added new factory classes for figures with post/pre processors.
Added new interface with can work with collection of figures (create, update, delete).

Updated implementation. Added functionality of multi criteria search using Builder pattern.

Libraries used in this project:
log4j-api-2.14.0.jar
log4j-core-2.14.0.jar