# Java-
Sem 4 Ca3


Question 4:
Write a program to create following scenario: abstract class VehicleType having: private field:  vehicle_type  (Eg:  scooter, car, bus) Use parameterized constructor to initialize the attribute. Make setter & getter methods for the attribute. 
An interface Color having:  
 default method: getColor()   which returns color (default: “white”) of vehicle 
 
An interface MfgDate having: 
 abstract method:      getMfgDate()      will be used to return manufacturing date of vehicle 
 
Now create a class Vehicle which inherits MfgDate, Color & VehicleType and having: 
 private field:  mfg_date  to store the manufacturing date of vehicle Use parameterized constructor to initialize the attribute. Make setter & getter methods for the attribute. 
Create Test class having main() method in which you have to make at least 5 objects of the Vehicle class and store them in ArrayList. Create another method named serializeVeh
which will store all objects in a file named “Records.txt”. Now make another method named deserializeVehicles() which will read and display all those objects from the file whose manufacturing-date is > 2018. 
 
Note:  Don’t make any separate instance variable other than the ones specified in above scenario. Also mfg_date variable is to be taken as LocalDate object rather than String object. Also, make use proper exception handling by using inbuilt exception-classes and also make your own custom exception class to deal with the exceptions such as user entering a negative no.
