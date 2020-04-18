package Game;

public class Weapon extends Items{
    
    private int damage;
    private String type;
	   
    public Weapon(String type, int dmg){
        
	super(true);
	this.type = type;
	this.damage = dmg;
    }
	   
    public int equipItem(Character ch){
        
        int dmg = ch.getDamage();
	dmg = dmg + this.damage;
	return dmg;
    }
	   
    public String getType(){
        
	return type;
   }
	   
    public int getDmg(){
        
	return damage;
    }
}
