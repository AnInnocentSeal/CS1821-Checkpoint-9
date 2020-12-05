
import java.util.*;

class ExpenseItem
{
    private String description;
    private String category;
    private int amount;
    
    public ExpenseItem(String description, String category, int amount){
        this.description = description;
        this.category = category;
        this.amount = amount;
    }
        
    
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public int getAmount(){
        return amount;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }   
}

public class ExpenseSystem
{
    public static Scanner kbd = new Scanner(System.in);

    // initialize array list please Johnathan
    
    public static void main(String[] args)

    {
        ArrayList<ExpenseItem> objectlist  = new ArrayList<ExpenseItem>();
        boolean in_loop = true;
        int menu = 0;
        
        while (in_loop)
        {
            System.out.println("Choose a menu point! \n1.Edit \n2.Analysis \n3.Exit");
            menu = kbd.nextInt();
            
            switch(menu)
            {
                case 1:
                    objectlist = editMode(objectlist, kbd);
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
                    System.out.println("There is no such menu!");
                    break;
            }
        }
    }
    public static ArrayList<ExpenseItem> editMode(ArrayList objectlist, Scanner kbd)
    {
        System.out.println("Choose 1 for adding and 2 for deleteing");
        int choice = kbd.nextInt();
        switch(choice)
        {
            case 1:
                objectlist = editAdd(objectlist, kbd);
                break;
            case 2:
                objectlist = editDelete(objectlist, kbd);
                break;
            default:
                System.out.println("No menu exists");
                break;


        }
        return objectlist;
        
    }
    public static ArrayList<ExpenseItem> editAdd(ArrayList<ExpenseItem>objectlist , Scanner kbd)
    {
        System.out.println("New item description");
        String description = new String(kbd.next());
        System.out.println("New item Category");
        String category = new String(kbd.next());
        System.out.println("New item amount");
        int amount = kbd.nextInt();
        objectlist.add(new ExpenseItem(description, category, amount));
        return objectlist;
    }

    public static ArrayList<ExpenseItem> editDelete(ArrayList<ExpenseItem>objectlist, Scanner kbd)
    {
        int i = 0;
        for(ExpenseItem e : objectlist){
            System.out.println((i +1)+ ". "+ e.getDescription()+ ", "+ e.getCategory()+ ", "+ e.getAmount());
            i++;

        }
        System.out.println("Select which item to delete");
        int choice = kbd.nextInt();
        objectlist.remove(choice);

        return objectlist;
    }

    public static void analysisMode(ArrayList<ExpenseItem> objectlist)
    {
        HashMap values = new HashMap();
        boolean in_list = false;
        //creating dictionary for categories, boolean if a category is already documented or not
        
        int sumexpense = 0;
        //sum of expenses 
        int i = 0;
        for(ExpenseItem e : objectlist) //adding category or incrementing value
        {
            int amount = e.getAmount();
            String category = e.getCategory();
            
            sumexpense += amount;
            
            if (values.containsKey(category))
            {
                amount += (int)values.get(category);
                values.remove(category);
                values.put(category, amount);
            } //updating amount, removing old entry, adding updated entry
            
            else
            {
                values.put(category, amount);
            }//adding new entry
            i++;
            
        }
        
        Set<String> keys = values.keySet();
        //iterating through the dictionary with keyset
        for(String key : keys) 
        {
            System.out.println("Money spent on " + key + " : "+values.get(key) + "\n");
            //printing out each category
        }
        
        System.out.println("All money spent: " + sumexpense + "\n"); // all money spent
        
        double average = ((double)sumexpense / objectlist.size());
        System.out.println("Average spent: " + average + "\n");
        //average spent on an item
        
    }
}
