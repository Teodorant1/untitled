package sample;

public class Main {

    public static void main(String[] args)
    {SqlMinion Paloki1 = new SqlMinion();


     Paloki1.insertworker("a",1,"a",1);
     System.out.println("record inserted successfully");
     Paloki1.insertworker("Paloki", 34, "PalokiStreet", 800);
     System.out.println("record inserted successfully");
     System.out.println(Paloki1.pullEveryone());
     System.out.println(Paloki1.pullsomeone("age","1"));
     Paloki1.changeworker(1,"age", "2");
     System.out.println(Paloki1.pullEveryone());
     Paloki1.deleteemployee(1);}
}
