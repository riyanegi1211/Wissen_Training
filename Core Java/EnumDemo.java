enum Gender
{
    MALE, FEMALE
}

class Person
{
    String name;
    int age;
    String gender;

    public Person(String name, int age, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void display()
    {
        System.out.println("\nName: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
    }
}

public class EnumDemo {
    public static void main(String args[])
    {
        Person p1 = new Person("Raju", 25, Gender.MALE);
        Person p2 = new Person("Manju", 35, Gender.FEMALE);
        Person p3 = new Person("Sanju", 30, Gender.MALE);

        p1.display();
        p2.display();
        p3.display();
    }
}
