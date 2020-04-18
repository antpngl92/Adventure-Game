package Game;

public class Ring extends Items {
    
    private int restoringHealth;
	
    public Ring(int health){
        
	super(true);
	this.restoringHealth = health;
    }

    public int getRestoring(){
        
	return restoringHealth;
    }
}
