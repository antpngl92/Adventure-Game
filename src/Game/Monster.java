package Game;

public class Monster extends Character {
    
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private int points;
 
    public Monster(String n){
        
	super(n, "Monster", 25, 750, 750);
	points = 0;
    }
	    
    public void attackCharacter(Character c){
        
	super.attackCharacter(c);
	points++;
    }
	    /*
	    public void specialAbility(Character ch)
	    {
	        if(points != 7)
	        {
	            System.out.println("Sorry but you cannot use now your special ability");
	        }
	        else 
	        {
	            setHealth(getHealth()*2);
	            attackCharacter(ch);
	        }
	        
	            
	    }
	    */
}
