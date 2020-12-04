import java.util.Scanner;
import java.util.ArrayList;
import java.util.Dictionary;

public class ExpenseItem
{
    //Mayson Gayle
}

public class ExpenseSystem
{
    public static Scanner kbd = new Scanner(System.in);
    // initialize array list please Johnathan
    
    public static void main(String[] args)
    {
        boolean in_loop = true;
        int menu = kbd.nextInt();
        
        while (in_loop)
        {
            System.out.prinln("Choose a menu point! \n1.Edit \n2.Analysis \n3.Exit")
            switch(menu)
            {
                case 1:
                    //edit method here (Johnathan Dew)
                    break;
                
                case 2:
                    //analysis method here (Peter Kozma)
                    analysisMode(objectlist);
                    break;
                
                case 3:
                    System.out.println("Goodbye!");
                    in_loop = false;
                    break;
                
                default:
                    System.out.println("There is no such menu!")
                    break;
            }
        }
    }
    
    public static void analysisMode(ArrayList objectlist)
    {
        Dictionary<String, int> values = new Hashtable<String, int>();
        boolean in_list = false;
        //creating dictionary for categories, boolean if a category is already documented or not
        
        int sumexpense = 0;
        //sum of expenses 
        
        for(int i = 0; i < objectlist.length; i++) //adding category or incrementing value
        {
            int amount = getAmount(objectlist[i]);
            String category = getCategory(objectlist[i]);
            
            sumvalue += amount;
            
            if (values.containsKey(category))
            {
                amount += values.get(category);
                values.remove(category);
                values.put(category, amount);
            } //updating amount, removing oldentry, adding updated entry
            
            else
            {
                values.put(category, amount);
            }//adding new entry
            
        }
        
        Set keys = values.keySet();
        //iterating through the dictionary with keyset
        for(String key : keys) 
        {
            System.out.println("Money spent on" + key + " : "+values.get(key) + "\n");
            //printing out each category
        }
        
        System.out.println("All money spent: " + sumexpense + "\n"); // all money spent
        
        double average = ((double)sumexpense / objectlist.length);
        System.out.println("Average spent: " + average + "\n");
        //average spent on an item
        
    }
}
