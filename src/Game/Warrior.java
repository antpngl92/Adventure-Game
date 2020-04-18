package Game;



public class Warrior extends Character {
    
    private static final long serialVersionUID = 1L;
    private int rage;
    
    public Warrior(String n){
        
        super(n, "Warrior", 56, 560, 560);
        rage = 0;
        //once rage full can use ability with hight damage
    }
    
    public int getSpecial(){
        return rage;
    }
    
    public void attackCharacter(Character c){
       super.attackCharacter(c);
       rage = rage + 3;       
    }
    
    public void specialAbility(Character ch){
        
        if(rage < 9)
            System.out.println("Sorry but you cannot use now your special ability");
        else{
            
            setDamage(getDamage()* 2);
            attackCharacter(ch);
        }
    }
}
