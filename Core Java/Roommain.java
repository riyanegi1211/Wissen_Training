class Room
{
	int length;
	int width;

	Room()
	{
		System.out.println("==========");
	}
	Room(String str)
	{
		System.out.println("Area");
	}
	Room(int length,int width)
	{
		this.length=length;
		this.width=width;
		this.area();
	}
	public void area()
	{
		System.out.println(length*width);
	}
}
public class Roommain
{
	public static void main(String args[])
	{
		Room r1=new Room(30,40);
		Room r1=new Room(20,40);
		Room r1=new Room(10,40);		
	}
}