package Game;

public class Barbarian extends Character {

    private static final long serialVersionUID = 1L;
    private int defence;
	    
    public Barbarian(String n){
        super(n, "Barbarian", 15, 1100, 1100);
        defence = 0;
        //His defence is second health
    }
	   
    public int getSpecial(){
        
	return defence;
    }

    public void attackCharacter(Character c){
        
	super.attackCharacter(c);
	defence = defence + 2;
    }
	    /*
	    public void specialAbility(Character ch)
	    {
	        if(defence ==0)
	        {
	            System.out.println("Sorry but you don't have any defence at the moment to use");
	        }
	        else 
	        {
	            setHealth(getHealth() + defence);
	        }
	        
	            
	    }
		*/
}
