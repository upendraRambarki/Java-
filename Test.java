import java.time.*;  
import java.io.*;
import java.util.*;
import java.util.Scanner;
abstract class VehicleType implements Serializable
 { 
	private String vehicle_type;

	public VehicleType()
	{
	}
	public VehicleType(String vt)
	{
		this.setVehicle_type(vt);
	}
	public String getVehicle_type()
	{  
		return vehicle_type;  
	}  
	public void setVehicle_type(String vt)
	{  
		this.vehicle_type=vt;
	}
}
interface Color
{
	abstract String getColor();
}
interface MfgDate
{
	abstract LocalDate getMfgDate();
}
class Vehicle extends VehicleType implements Color,MfgDate,Serializable
{
	private LocalDate mfg_date;
	String color;
	
	public Vehicle(String vt,String mfg_date)
	{
		super.setVehicle_type(vt);
		this.mfg_date=LocalDate.parse(mfg_date);
		this.color="white";
	}
	public Vehicle(String vt,String mfg_date,String color)
	{
		super.setVehicle_type(vt);
		this.mfg_date=LocalDate.parse(mfg_date);
		this.color=color;
	}
	public LocalDate getMfgDate()
	{  
		return mfg_date;  
	}  
	public void setMfgDate(String mfg_date)
	{  
		this.mfg_date=LocalDate.parse(mfg_date); 
	}
	public String getVehicle_type()
	{    
		return super.getVehicle_type();
	}  
	public void setVehicle_type(String vt)
	{
			super.setVehicle_type(vt);
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString() {
		return new StringBuffer(" Vehicle_Type : ")
				.append(this.getVehicle_type()).append(" Mfg-date : ")
				.append(this.getMfgDate()).append(" Color : ")
				.append(this.getColor()).toString();
	}
}
class InvalidInputException extends Exception
{
	InvalidInputException()
	{
		
	}
}
public class Test
{
	public static void main(String args[])
	{
		Test t= new Test();
		String vt1 = "\0",mgf1,color1;
		//int n=0;
		Scanner in = new Scanner(System.in);
		ArrayList<Vehicle> ve=new ArrayList<Vehicle>();
		System.out.println("Enter no.of objects to create :");
		int n = in.nextInt();
		try
		{
						if(n<0)
			{
				InvalidInputException i = new InvalidInputException();
				throw i;
			}	
		String ch = in.nextLine();
		for(int i=1;i<=n;i++)
		{	
		try	
		{
			System.out.println("Enter the vechicle type(Eg:car,bus,etc...) of object: " +i);		
			vt1 = in.nextLine();		
			System.out.println("Enter the vechicle manufacture(YEAR-MONTH-DATE)  of the object: " +i);		
			mgf1 = in.nextLine();			 
			System.out.println("If you want to choose color of an object press ONE (or) press TWO");
			int  c; 				
			c = in.nextInt();			
			Scanner sc = new Scanner(System.in);			
			ch = in.nextLine();
			if( c == 1)
			{	
				System.out.println("Enter the vechicle color of an object:" +i);	
				color1 = sc.nextLine();
				ve.add(new Vehicle(vt1,mgf1,color1));
			}
			else{
				color1 = "white";
				ve.add(new Vehicle(vt1,mgf1,color1));
			}
		}
			catch(Exception e)
			{
				System.out.println("Enter Correct Date.");
			}
		}
		t.serializeVehicles(ve);
		t.deserializeVehicles();
	}
	catch(InvalidInputException e)
		{
			System.out.println("Number Of Vehicles Cannot be negative value");
		}	
	}
	public void serializeVehicles(ArrayList<Vehicle> v)
	{
			FileOutputStream out = null;
			ObjectOutputStream oout = null;	
		try {
				out = new FileOutputStream("Records.txt");
				oout = new ObjectOutputStream(out);
				oout.writeObject(v);
		 } catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oout != null) {
				try {
					oout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	public void deserializeVehicles()
	{
		ArrayList<Vehicle> ve = new ArrayList<>();
		try {
				FileInputStream fis = new FileInputStream("Records.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ve = (ArrayList) ois.readObject();
				ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
			for(int i=0;i<ve.size();i++){
            String s=ve.get(i).getMfgDate().toString();
			//System.out.println(s);
			LocalDate dt = LocalDate.parse(s);
			int year = dt.getYear();
			//System.out.println(year);
			if(year > 2018){
			System.out.println(ve.get(i));}
			}
	}
}