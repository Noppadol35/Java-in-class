



public class Studen {
    //adtibude
    String name ;
    private String surname;
    private int ID;
    private double grade;
    public String setName;

    Studen(){
        name = "";
        surname = "";
        ID = 0;
        grade = 0.0;
    }
    Studen(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    //medthod


    public void setName(String newName)
    {
        this.name = newName;
    }
    public String getName(){
        return this.name;
    }

    void study(){

    }
    void Drop(){

    }
    void register(){

    }
    void addsubject(){

    }
    void printinfo()
    {
        System.out.println("Name&surname: " + name + surname);
    }
}
