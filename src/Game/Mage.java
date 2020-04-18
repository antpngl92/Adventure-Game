package Game;

public class Mage extends Character {

    private static final long serialVersionUID = 1L;
    private int mana;
    public Mage(String n){
            
        super(n, "Mage", 40, 600, 600);
        mana = 0;
        //increasing the mana faster than others   
    }
	    
    public int getSpecial(){
        
        return mana;
    }
	    
    public void attackCharacter(Character c){
        
	super.attackCharacter(c);
	mana++;
    }
	    
    public void specialAbility(Character ch){
        
	if(mana ==0 || mana < 5)
            System.out.println("Sorry you don't have any mana");
	else{
	    System.out.println(getType() + " "  +  getName() + " attached you with Frost Blast" );
	    setDamage(getDamage() + mana);
	    attackCharacter(ch);
        }
    }

}
