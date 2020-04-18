package Game;

public class Hunter extends Character {

    private static final long serialVersionUID = 1L;
    private int power;
    public Hunter(String n){
        
	super(n, "Hunter", 70, 300, 300);
	power = 0;
    }
	    
    public int getSpecial(){
        
	return power;
    }
	    
    public void attackCharacter(Character c){
        
	super.attackCharacter(c);
	power++;
    }
	    /*
	    public void specialAbility(Character ch)
	    {
	        if(power ==0 || power < 5)
	        {
	            System.out.println("Sorry but you cannot use now your special ability");
	        }
	        else 
	        {
	            setHealth(getHealth() + ch.getDamage());
	            attackCharacter(ch);
	        }
	        
	            
	    }
		*/
}
