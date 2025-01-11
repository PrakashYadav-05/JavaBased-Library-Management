import java.util.ArrayList;
/**
 * Create a vistor class to keep record in Library
 */
public class Visitor
{
    // instance variables - replace the example below with your own
    private String name;
    private String lastName;
    private int timeDuration;
    private ArrayList<ElectronicResource> onlineBook;
    /**
     * Constructor for objects of class Visitor
     * with defined parameters with String and interger values
     */
    public Visitor(String name, String lastName, int timeDuration)
    {
        this.name = name;
        this.lastName = lastName;
        this.timeDuration = timeDuration;
        this.onlineBook = new ArrayList<ElectronicResource>();
    }
    //getter and Setter method for all fields
    public String getName()
    {
        return name;
    }
    public String getLastname()
    {
        return lastName;
    }
    public int getTimeDuration(int timeDuration)
    {
        return timeDuration;
    }
    public void setTimeDuration(int timeDuration)
    {
        if(timeDuration <=3 ){
            this.timeDuration  =  timeDuration;
        }
        else
        {
            System.out.println("Access duration can not be greater than 3 days!");
        }
    }
}
