package Game;

public class Assasin extends Character {

    private static final long serialVersionUID = 1L;
    private int blur; //evade attack
    
    public Assasin(String n){
        
      super(n, "Assasin", 60, 400, 400);
      blur = 0;
        //miss is it at damage given in random attacks
    }
    
    public int getSpecial(){
        return blur;
    }
    
    public String toString(){
        return super.toString() + "\nThe special ability of this character is " + 
         " to evade attack. The current blur is at " + getSpecial(); 
    }
    
    public void attackCharacter(Character c){
       super.attackCharacter(c);
       blur++;
  
    }
    /*
    public void specialAbility(Character ch)
    {
        if(blur ==0)
        {
            System.out.println("Sorry but you cannot use now your special ability");
        }
        else 
        {
            setHealth(getHealth() + blur);
            attackCharacter(ch);
        }
        
            
    }
	*/
}
