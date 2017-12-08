
/**
 * Write a description of class People here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class People
{
    
    private ArrayList<Person> persons;
    private Person[] tempArray = {new Person("Sophie Mcfarland", 18, false), new Person("Charlie Knottenbelt", 20, true), new Person("Julian Goh", 17, true), new Person("Dom White", 20, true)};
    
    public People()
    {
        persons = new ArrayList<Person>();
        for (Person stuff : tempArray){
            persons.add(stuff);
        }
    }
    
    public int oldest(){
        int highest = 0;
        String name;
        for (Person person : persons){
            if (highest < person.getAge()){
                highest = person.getAge();
            }
        }
        return highest;
    }
    
    public String nameOldest(){
        int highest = 0;
        String name = "";
        for (Person person : persons){
            if (highest < person.getAge()){
                highest = person.getAge();
                name = person.getName();
            }
        }
        return name;
    }
    
    public int totalAge(){
        int total = 0;
        for (Person person : persons){
            total += person.getAge();
        }
        return total;
    }
    
    public double avgAge(){
        return totalAge()/persons.size();
    }
    
    public double stdevAge(){
        double sum = 0;
        for (Person person : persons){
            sum += Math.pow(person.getAge() - avgAge(),2)/persons.size();
        }
        return Math.sqrt(sum);
    }
    
    public void addPerson(Person newPerson){
        persons.add(newPerson);
    }
    
    public void doEverything(){
        System.out.println("Oldest person is: " + oldest());
        System.out.println("Name of oldest person is: " + nameOldest());
        System.out.println("Total age is: " + totalAge());
        System.out.println("Average age is: " + avgAge());
        System.out.println("Standard deviation is: " + stdevAge());
    }
    
    public ArrayList<Person> least18(){
        ArrayList<Person> yr18 = new ArrayList<Person> ();
        for (Person person : persons) {
            if (person.getAge() >= 18 ){
                yr18.add(person);
            }
        }
        return yr18;
    }
    
    public ArrayList<Person> allOldest(){
       int highest = 0;
        ArrayList<Person> names = new ArrayList<Person> ();
        for (Person person : persons){
            if (highest < person.getAge()){
                highest = person.getAge();
                names.clear();
            }
            if(highest == person.getAge()){
                names.add(person);
            }
        }
       return names;
    }
    
    public ArrayList<Person> notOldest(){
        ArrayList<Person> youngest = new ArrayList<Person>(persons);
        for (Person person : allOldest()){
            youngest.remove(person);
        }
        return youngest;
    }
    
    public double medianAge(){
        double median = 0;
        ArrayList<Person> youngest = new ArrayList<Person>(persons);
        for (int i = 0; i < ((persons.size()-1)/2); i++){
            youngest = removeOldest(youngest);
        }
        if(persons.size() % 2 == 0){
            median = oldest(youngest).getAge();
            youngest = removeOldest(youngest);
            return (median + oldest(youngest).getAge())/2;
        } else {
            return oldest(youngest).getAge();
        }
    }
    
    public Person oldest(ArrayList<Person> listToCheck){
        int highest = 0;
        Person name = null;
        for (Person person : listToCheck){
            if (highest < person.getAge()){
                highest = person.getAge();
                name = person;
            }
        }
        return name;
    }
    
    public ArrayList<Person> removeOldest(ArrayList<Person> listToCheck){
        ArrayList<Person> youngest = new ArrayList<Person>(listToCheck);
        youngest.remove(oldest(listToCheck));
        return youngest;
    }
    
    public int modeAge(){
        int mode = 0;
        int temp = 0;
        int count = 0;
        int modeCount = 0;
        
        for(int i = 0; i < persons.size(); i++){
            temp = persons.get(i).getAge();
            count = 0;
            
            for(int j = i+1; j < persons.size(); j++){
                if(temp == persons.get(j).getAge()){
                    count++;
                }
            }
            if(count >= modeCount){
                mode = temp;
                modeCount = count;
            }
        }
        return mode;
    }
    
}

