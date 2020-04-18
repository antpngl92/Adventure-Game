package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Character implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private int damage;
    private int health;
    private Weapon weapon;
    private String position;
    private int maxHealth;
    private boolean dead;
    private ArrayList<Items> slots;
	    
	    
    public Character(String name, String type, int damage, int health, int mxH){
         
        this.name = name;
	this.type = type;
	this.damage = damage;
	this.health = health;
	this.weapon = null;
	this.position = "Dalanar Gate";
	this.maxHealth = mxH;
	this.dead = false;
	slots = new ArrayList<>(3);    
    }

    public void attackCharacter(Character c){
        
	Random r = new Random();
	int damage2 = r.nextInt(getDamage()) + 20;
	int tempHealth = c.getHealth();
	     
	tempHealth = tempHealth - damage2;
	c.setHealth(tempHealth);
    }
	    
    public String getType(){
        
	return type;
    }
	    
    public String getWeapon(){
        
	if(this.weapon == null)
            return "Default";
	else 
            return weapon.getType();
    }
	    
    public String getName(){
        
	return name;
    }
    
    public int getHealth(){
        
	return health;
    }
    
    public void setHealth(int health){
        
	this.health = health;
    }
	    

    public int getDamage(){
        
	return damage;
    }
	    
    public String toString(){
        
	return "Character " + getName() + " of type " + getType() + "\nDamage: " + getDamage()  + "\nHealth " + getHealth() ;
    }
	    
    public int getSpecial(){
        
	return -1;
    }
	    
    public void specialAbility(Character ch){
        
    }
	    
    protected void setDamage(int a ){
        
	this.damage = a;
    }
	    
    private static String textInput(String message){
        
	Scanner a = new Scanner(System.in);
	String input;
	System.out.println(message);
	input = a.nextLine();
	return input;
    }
	   
    public String getPositio(){
        
	return position;
    }
    
    public void setPosition(String ps){
        
	this.position = ps;
    }
   
     public void receiveDamage(int dmg){
         
	int hth = this.getHealth() - dmg;
	this.setHealth(hth);
    }
	  
    public void restoreMaxHP(){
        
	this.health = maxHealth;
    }
	   
    public int getMaxHealth(){
        
	return maxHealth;
    }
    
    public void setMaxHealth(int set){
        
	this.maxHealth = this.maxHealth + set;
    }
	  
    public boolean dead(){
        
        if(this.getHealth() <= 0 )
            dead = true;
            
        else
            dead = false;
	return dead;
    }
    
    public void takeItem(Items item){
        
	slots.add(item);
    }
    public int getSlots(){
        
	return slots.size();
    }
    public void addSlots(){
        
	slots.remove(0);
    }
}
