package Game;


public class Health extends Items{
    
    private int healthCharacter;
    @SuppressWarnings("unused")
    private String healthPosition;
    
    public Health(String position){
        
        super(true);
        healthCharacter = 150;
        healthPosition = position;
    }
    
    public int useHealth(Character ch) {
        
	int health = ch.getHealth();
	health = health + healthCharacter;
	return health;
    }

    public int getHealthCharacter(){
        
	return healthCharacter;
    }
}
