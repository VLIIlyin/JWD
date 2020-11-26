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

Libraries used in this project:
log4j-api-2.14.0.jar
log4j-core-2.14.0.jar