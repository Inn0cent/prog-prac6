
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    
    private String name;
    private int age;
    private boolean isMale;
    private String job = null;
    private boolean alive;
    
    public Person(String name, int age, boolean isMale)
    {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        alive = true;
    }
    
    public void setJob(String newJob){
        job = newJob;
    }
    
    public String toString(){
        return "My name is " + getFirstname() + " and I am " + age + " years old.";
    }
    
    public String getSurname(){
        return name.split(" ")[1];
    }
    
    public String getFirstname(){
        return name.split(" ")[0];
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getJob(){
        if (job == null){
            return "Unemployed";
        } else {
            return job;
        }
    }
}
