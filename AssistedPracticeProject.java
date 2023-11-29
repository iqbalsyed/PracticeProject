package phase1project;

public class inheritance {
	public void methodA()
    {
	System.out.println("Base class method");
	}
}
class B extends inheritance{
	   public void methodB()
	   {
	     System.out.println("Child class method");
	   }
	   public static void main(String args[])
	   {
	     B obj = new B();
	     obj.methodA(); //calling super class method
	     obj.methodB(); //calling local method
	   }
}
class Z extends B{
	   public void methodZ()
	   {
	     System.out.println("class Z method");
	   }
	   public static void main(String args[])
	   {
	     Z obj = new Z();
	     obj.methodA(); //calling grand parent class method
	     obj.methodB(); //calling parent class method
	     obj.methodZ(); //calling local method
	  }
}

