package Game;
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 
 * 
 */
public class Game{
    
    private Character playableCharacter = new Character(" ", " ", 0, 0, 0);
    private ArrayList<Character> enemies;
    private String playableCharacterName;
    private ArrayList<Health> health = new ArrayList<>();
    private boolean talkedShaman = false;
    private Weapon gift;
    @SuppressWarnings("unused")
    private boolean wEmb = false;
    @SuppressWarnings("unused")
    private boolean crownRestored = false;
    String projectPath = System.getProperty("user.dir");
    //_____________CONTAINERS_______________________________________________________________________________________________//
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiseButtonPanel, pickCharacterPanel,
    pickCharacterLabelPanel, charactersPicturePanel, charachtersButtonPickingPanle, enterYourNamePanel,
    playerStatsPanel, enemiesStatsPanel, mapPanel, healthButtonPanel;

    //________________FONTS_________________________________________________________________________________________________//
    //Customise font for the title and the creator label	
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font title2Font = new Font("Times New Roman", Font.PLAIN, 20);
    //Font for the button
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font gameFont = new Font("Times New Roman", Font.ITALIC, 26);
    Font smallerFont = new Font("Times New Roman", Font.PLAIN, 18);
    
    //__________________COMPONENTS__________________________________________________________________________________________//
    JButton startButton, choice1, choice2, choice3, choice4, buttonChar1, buttonChar2, buttonChar3, buttonChar4, 
    buttonChar5, buttonChar6, continueButton, healthButton;
    JTextArea mainTextArea, character1, character2, character3, character4, character5, character6;
    JTextField  nameTextField;
    JLabel titleNameLabel, titleNameLabel2, pickCharackterLabel, enterYourNameLabel, playerHpLabel, playerNameTypeLabel,
    playerDamageLabel, playerSpecialLabel, playerWeaponLabel, enemieHpLabel, enemieNameTypeLabel, enemieDamageLabel, 
    enemieSpecialLabel, playerPosition;
    
    //__________________LISTENERS___________________________________________________________________________________________//
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    EnterScreenHandler esHandler = new EnterScreenHandler();
    PickCharacterHandler pcHandler = new PickCharacterHandler();
    ChoiseHandler chHandler = new ChoiseHandler();
    healthCharacterHandler hChHangler = new healthCharacterHandler();
       
    //_____________________IMAGES___________________________________________________________________________________________//
    ImageIcon imageCh1, imageCh2, imageCh3, imageCh4, imageCh5, imageCh6, map;
    public static void main(String[] args){

        new Game();
    }
    
    public Game(){
        		
	//CREATE OUR WINDOW FRAME 
	window = new JFrame();
	window.setSize(850, 700);
	window.setLocation(450, 120);
	//You can close the window from the X
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	//Setting black colour for background
	window.getContentPane().setBackground(Color.black);
	//Disable the default Layout so I can use custom one 
	window.setLayout(null);
	window.setVisible(true);
	con = window.getContentPane();
		
	//CREATE A TITLE PANEL
	titleNamePanel = new JPanel();		
	titleNamePanel.setBounds(100, 100, 600, 150); //x, y, width, height
	titleNamePanel.setBackground(Color.black);
	//Create the title for the label
	titleNameLabel = new JLabel("DUNGEONS AND  MONSTERS");
	titleNameLabel.setForeground(Color.white);
	titleNameLabel.setFont(titleFont); // Setting the font of the label 
	titleNameLabel2 = new JLabel("By Anton Nyagolov");
	titleNameLabel2.setForeground(Color.white); // text colour
	titleNameLabel2.setFont(title2Font);
	 // add the title to the panel 
		
	//CREATE A BUTTON PANEL 
	startButtonPanel = new JPanel();
	startButtonPanel.setBounds(300, 400, 200, 100);
	startButtonPanel.setBackground(Color.black);		
	//Create the START button for the panel and inserting it into the panel
	startButton = new JButton("START");
	startButton.setBackground(Color.black);
	startButton.setForeground(Color.white);
	startButton.setFont(normalFont);
	startButton.addActionListener(tsHandler);
	startButton.setFocusPainted(false);
	startButton.setBorder(null);
	startButton.setActionCommand("start");
		
	//Create the continue button (load saved game) and inserting it into the panel
	continueButton = new JButton("");
	continueButton.setBackground(Color.black);
	continueButton.setForeground(Color.white);
	continueButton.setFont(normalFont);
	continueButton.addActionListener(tsHandler);
	continueButton.setFocusPainted(false);
	continueButton.setBorder(null);
	continueButton.setActionCommand("continue");
		
	// add the title to the panel 
	titleNamePanel.add(titleNameLabel);
	//Add game creator and the title
	//adds the 2 buttons - START and CONTINUE
	titleNamePanel.add(titleNameLabel2);
	startButtonPanel.add(startButton);
	startButtonPanel.add(continueButton);
		
	//Adding the title panel to the container (base) 
	con.add(titleNamePanel);
	//Adding the button panel to the container
	con.add(startButtonPanel);
		
	window.setVisible(true);
    }
	
    public void createGameScreen(String startOrContinue){
        
        //Start game panel set to invisible 
	pickCharacterPanel.setVisible(false);
	pickCharacterLabelPanel.setVisible(false);
	charactersPicturePanel.setVisible(false);
	charachtersButtonPickingPanle.setVisible(false);
				
        //SETTING PANNEL FOR THE MAIN TEXT OF THE GAME
	mainTextPanel = new JPanel();
	mainTextPanel.setBounds(100, 240, 600,250);
	mainTextPanel.setBackground(Color.black);
	con.add(mainTextPanel);
			
	//Creating and inserting the text area into the panel 
	mainTextArea = new JTextArea("This is the main text area");
	mainTextArea.setBounds(100, 100, 600, 250);
	mainTextArea.setBackground(Color.black);
	mainTextArea.setForeground(Color.white);
	mainTextArea.setFont(gameFont);
	mainTextArea.setEditable(false); 
	mainTextArea.setLineWrap(true); //It squeeze the text if is long
	mainTextPanel.add(mainTextArea);
					
	//SETTING PANNEL FOR THE 4 BUTTONS 
	choiseButtonPanel = new JPanel();
	choiseButtonPanel.setBounds(250, 500, 300, 150);
	choiseButtonPanel.setBackground(Color.black);
	choiseButtonPanel.setLayout(new GridLayout(4,1));
	con.add(choiseButtonPanel);
			
	//Creating and inserting the buttons into the panel
	choice1 = new JButton("choice1");
	choice1.setBackground(Color.black);
	choice1.setForeground(Color.white);
	choice1.setFont(normalFont);
	choice1.setFocusPainted(false);
	choice1.addActionListener(chHandler);
	choice1.setActionCommand("c1");
	choiseButtonPanel.add(choice1);
			
	choice2 = new JButton("choice2");
	choice2.setBackground(Color.black);
	choice2.setForeground(Color.white);
	choice2.setFont(normalFont);
	choice2.setFocusPainted(false);
	choice2.addActionListener(chHandler);
	choice2.setActionCommand("c2");
	choiseButtonPanel.add(choice2);
	
	choice3 = new JButton("choice3");
	choice3.setBackground(Color.black);
	choice3.setForeground(Color.white);
	choice3.setFont(normalFont);
	choice3.setFocusPainted(false);
	choice3.addActionListener(chHandler);
	choice3.setActionCommand("c3");
	choiseButtonPanel.add(choice3);
	
	choice4 = new JButton("choice4");
	choice4.setBackground(Color.black);
	choice4.setForeground(Color.white);
	choice4.setFont(normalFont);
	choice4.setFocusPainted(false);
	choice4.addActionListener(chHandler);
	choice4.setActionCommand("c4");
	choiseButtonPanel.add(choice4);
		
	//SETTING PANEL FOR THE STATS OF THE PLAYABLE CHARACTER
	playerStatsPanel = new JPanel();
	playerStatsPanel.setBounds(50, 0, 200, 200);
	playerStatsPanel.setLayout(new GridLayout(6,1));
	playerStatsPanel.setBackground(Color.black);
	con.add(playerStatsPanel);
			
	//SETTING PANEL FOR THE STATS OF THE ENEMIES CHARACTER
	enemiesStatsPanel = new JPanel();
	enemiesStatsPanel.setBounds(650, 0, 200, 150);
	enemiesStatsPanel.setLayout(new GridLayout(4, 1));
	enemiesStatsPanel.setBackground(Color.black);
	con.add(enemiesStatsPanel);
			
	//SETTING PANEL FOR THE MAP 
	mapPanel = new JPanel();
	mapPanel.setBounds(250, 0, 300, 400);
	mapPanel.setLayout(new GridLayout(2, 1));
	mapPanel.setBackground(Color.black);
	con.add(mapPanel);
			
	//SETTING THE PANEL FOR THE HEALTH BUTTON
	healthButtonPanel = new JPanel();
	healthButtonPanel.setLayout(new GridLayout(1, 6, 10, 10));
	healthButtonPanel.setBounds(10, 500, 200, 80);
	healthButtonPanel.setBackground(Color.black);
	healthButtonPanel.setVisible(false);
	con.add(healthButtonPanel);
	//Creating and inserting the health button
	healthButton = new JButton("Health: " + playableCharacter.getSlots());
	healthButton.setBackground(Color.black);
	healthButton.setForeground(Color.white);
	healthButton.setFont(smallerFont);
	healthButton.setFocusPainted(false);
	healthButton.addActionListener(chHandler);
	healthButton.setActionCommand("c4");
	healthButton.addActionListener(hChHangler);
	healthButtonPanel.add(healthButton);
			
			
	//Creates and adds the label of playable character type and name
	playerNameTypeLabel = new JLabel(playableCharacter.getType() + " " + playableCharacter.getName());
	playerNameTypeLabel.setFont(smallerFont);
	playerNameTypeLabel.setForeground(Color.white);
	playerStatsPanel.add(playerNameTypeLabel);
	//Creates and adds the label of playable character HP
	playerHpLabel = new JLabel("HP: " + playableCharacter.getHealth());
	playerHpLabel.setFont(smallerFont);
	playerHpLabel.setForeground(Color.white);
	playerStatsPanel.add(playerHpLabel);
	//Creates and adds the label of playable character damage
	playerDamageLabel = new JLabel("Damage: " + playableCharacter.getDamage());
	playerDamageLabel.setFont(smallerFont);
	playerDamageLabel.setForeground(Color.white);
	playerStatsPanel.add(playerDamageLabel);
	//Creates and adds the label of playable character special 
	playerSpecialLabel = new JLabel("Special: " + playableCharacter.getSpecial());
	playerSpecialLabel.setFont(smallerFont);
	playerSpecialLabel.setForeground(Color.white);
	playerStatsPanel.add(playerSpecialLabel);
	//Creates and adds the label of playable character weapon
	playerWeaponLabel = new JLabel("Weapon: " + playableCharacter.getWeapon() );
	playerWeaponLabel.setFont(smallerFont);
	playerWeaponLabel.setForeground(Color.white);
	playerStatsPanel.add(playerWeaponLabel);
	//Creates and adds the label of player position 
	playerPosition= new JLabel("Position: " + playableCharacter.getPositio());
	playerPosition.setFont(smallerFont);
	playerPosition.setForeground(Color.white);
	playerStatsPanel.add(playerPosition);
			
	//Creates and adds the label of enemies name and type
	enemieNameTypeLabel = new JLabel("");
	enemieNameTypeLabel.setFont(smallerFont);
	enemieNameTypeLabel.setForeground(Color.white);
	enemiesStatsPanel.add(enemieNameTypeLabel);
	//Creates and adds the label of enemies HP
	enemieHpLabel = new JLabel("");
	enemieHpLabel.setFont(smallerFont);
	enemieHpLabel.setForeground(Color.white);
	enemiesStatsPanel.add(enemieHpLabel);
	//Creates and adds the label of enemies damage
	enemieDamageLabel = new JLabel("");
	enemieDamageLabel.setFont(smallerFont);
	enemieDamageLabel.setForeground(Color.white);
	enemiesStatsPanel.add(enemieDamageLabel);
	//Creates and adds the label of enemies special
	enemieSpecialLabel = new JLabel("");
	enemieSpecialLabel.setFont(smallerFont);
	enemieSpecialLabel.setForeground(Color.white);
	enemiesStatsPanel.add(enemieSpecialLabel);
		
        
	//Importing the map image and adding it to the panel
	map = new ImageIcon(projectPath + "/src/pic/MAP.png");
					
	JLabel mapLabel = new JLabel(map);
	mapPanel.add(mapLabel);
    }
	
	
    public void pickCharacterScreen(){
				
	//make invisible previous menu screen (set character name)
	enterYourNamePanel.setVisible(false);
	enterYourNameLabel.setVisible(false);
	
	//JPanel for the characters images
	charactersPicturePanel = new JPanel();
	charactersPicturePanel.setBounds(100, 100, 650,300);
	charactersPicturePanel.setBackground(Color.black);
	con.add(charactersPicturePanel);
		
	//JPanel for the status of the characters
	pickCharacterPanel = new JPanel();
	pickCharacterPanel.setBounds(100, 400, 650,100);
	pickCharacterPanel.setBackground(Color.black);
	con.add(pickCharacterPanel);
		
	//JPanel for the text Label "pick character:"
	pickCharacterLabelPanel = new JPanel();
	pickCharacterLabelPanel.setBounds(100, 0, 650, 80);
	pickCharacterLabelPanel.setBackground(Color.black);
	con.add(pickCharacterLabelPanel);
		
	//JPanel for the buttons to pick character
	charachtersButtonPickingPanle = new JPanel();
	charachtersButtonPickingPanle.setLayout(new GridLayout(1, 6, 10, 10));
	charachtersButtonPickingPanle.setBounds(100, 500, 650, 50);
	charachtersButtonPickingPanle.setBackground(Color.black);
	con.add(charachtersButtonPickingPanle);
		
	//JButton to pick Warrior
	buttonChar1 = new JButton("Warrior");
	buttonChar1.setBackground(Color.black);
	buttonChar1.setForeground(Color.white);
	charachtersButtonPickingPanle.setBounds(100, 500, 650, 50);
	buttonChar1.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar1);
		
	//JButton to pick Mage
	buttonChar2 = new JButton("Mage");
	buttonChar2.setBackground(Color.black);
	buttonChar2.setForeground(Color.white);
	buttonChar2.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar2);
		
	//JButton to pick Barbarian
	buttonChar3 = new JButton("Barbarian");
	buttonChar3.setBackground(Color.black);
	buttonChar3.setForeground(Color.white);
	buttonChar3.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar3);
		
	//JButton to pick Hunter
	buttonChar4 = new JButton("Hunter");
	buttonChar4.setBackground(Color.black);
	buttonChar4.setForeground(Color.white);
	buttonChar4.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar4);
		
	//JButton to pick Assassin
	buttonChar5 = new JButton("Assassin");
	buttonChar5.setBackground(Color.black);
	buttonChar5.setForeground(Color.white);
	buttonChar5.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar5);
		
	//JButton to pick Monster
	buttonChar6 = new JButton("Monster");
	buttonChar6.setBackground(Color.black);
	buttonChar6.setForeground(Color.white);
	buttonChar6.setFont(smallerFont);
	charachtersButtonPickingPanle.add(buttonChar6);
		
	//Warrior Image
	imageCh1 = new ImageIcon(projectPath + "/src/pic/Warrior.jpg");
	JLabel ch1 = new JLabel(imageCh1);
	charactersPicturePanel.add(ch1);
	//Mage Image
	imageCh2 = new ImageIcon(projectPath + "/src/pic/Mage.jpg");
	JLabel ch2 = new JLabel(imageCh2);
	charactersPicturePanel.add(ch2);
	//barbarian Image
	imageCh3 = new ImageIcon(projectPath + "/src/pic/Barbarian.jpg");
	JLabel ch3 = new JLabel(imageCh3);
	charactersPicturePanel.add(ch3);
	//Hunter Image
	imageCh4 = new ImageIcon(projectPath + "/src/pic/Hunter.jpg");
	JLabel ch4 = new JLabel(imageCh4);
	charactersPicturePanel.add(ch4);
	//Assassin Image
	imageCh5 = new ImageIcon(projectPath + "/src/pic/Assasin.jpg");
	JLabel ch5 = new JLabel(imageCh5);
	charactersPicturePanel.add(ch5);
	//Monster Image
	imageCh6 = new ImageIcon(projectPath + "/src/pic/Monster.jpg");
	JLabel ch6 = new JLabel(imageCh6);
	charactersPicturePanel.add(ch6);
		
		
	pickCharackterLabel = new JLabel("Pick a Character:");
	pickCharackterLabel.setForeground(Color.white);
	pickCharackterLabel.setFont(titleFont); // Setting the font of the label 
	pickCharacterLabelPanel.add(pickCharackterLabel);
		
	character1 = new JTextArea("Warrior \nDamage:56 \nHealth:560 \nrage:0");
	character1.setBounds(100, 100, 100, 250);
	character1.setBackground(Color.black);
	character1.setForeground(Color.white);
	character1.setLineWrap(true); //It squeeze the text if is long
	character1.setFont(smallerFont);
	pickCharacterPanel.add(character1);
		
	character2 = new JTextArea("Mage \nDamage:40 \nHealth:600 \nmana:0");
	character2.setBounds(100, 100, 100, 250);
	character2.setBackground(Color.black);
	character2.setForeground(Color.white);
	character2.setLineWrap(true); //It squeeze the text if is long
	character2.setFont(smallerFont);
	pickCharacterPanel.add(character2);
		
	character3 = new JTextArea("Barbarian \nDamage:15 \nHealth:1100 \ndefence:0");
	character3.setBounds(100, 100, 100, 250);
	character3.setBackground(Color.black);
	character3.setForeground(Color.white);
	character3.setLineWrap(true); //It squeeze the text if is long
	character3.setFont(smallerFont);
	pickCharacterPanel.add(character3);
		
	character4 = new JTextArea("Hunter \nDamage:70 \nHealth:300 \npower:0");
	character4.setBounds(100, 100, 100, 250);
	character4.setBackground(Color.black);
	character4.setForeground(Color.white);
	character4.setLineWrap(true); //It squeeze the text if is long
	character4.setFont(smallerFont);
	pickCharacterPanel.add(character4);
		
	character5 = new JTextArea("Assasin \nDamage:60 \nHealth:400 \nblur:0");
	character5.setBounds(100, 100, 100, 250);
	character5.setBackground(Color.black);
	character5.setForeground(Color.white);
	character5.setLineWrap(true); //It squeeze the text if is long
	character5.setFont(smallerFont);
	pickCharacterPanel.add(character5);
		
	character6 = new JTextArea("Monster \nDamage:25 \nHealth:700 \npoints:0");
	character6.setBounds(100, 100, 100, 250);
	character6.setBackground(Color.black);
	character6.setForeground(Color.white);
	character6.setLineWrap(true); //It squeeze the text if is long
	character6.setFont(smallerFont);
	pickCharacterPanel.add(character6);
		
	buttonChar1.addActionListener(pcHandler);
	buttonChar2.addActionListener(pcHandler);
	buttonChar3.addActionListener(pcHandler);
	buttonChar4.addActionListener(pcHandler);
	buttonChar5.addActionListener(pcHandler);
	buttonChar6.addActionListener(pcHandler);
    }
	
    public void enterYourNameScreen(){
        
	titleNamePanel.setVisible(false);
	startButtonPanel.setVisible(false);
	
	enterYourNamePanel = new JPanel();
	enterYourNamePanel.setLayout(new GridBagLayout());
	enterYourNamePanel.setBounds(100, 100, 650,100);
	enterYourNamePanel.setBackground(Color.black);
	con.add(enterYourNamePanel);
		
	enterYourNameLabel = new JLabel("Enter Your Character Name:");
	enterYourNameLabel.setForeground(Color.white);
	enterYourNameLabel.setFont(normalFont);
	enterYourNamePanel.add(enterYourNameLabel);
		
	nameTextField = new JTextField(10);
	enterYourNamePanel.add(nameTextField);		
	nameTextField.addActionListener(esHandler);
    }
	
    private void townGateDolanar(){
	
        health.add(0, new Health("healthCave"));
	health.add(1, new Health("healthRuttheranVillage"));
	if(enemies.get(0).dead() == true)
            health.get(0).setSpawn(false);
		
	titleNamePanel.setVisible(false);
	startButtonPanel.setVisible(false);
		 
	playableCharacter.setPosition("Dalanar Gate");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	mainTextArea.setText("You are at the gate of Dalanaar.\nA guard is standing in"
				+ " front of you.\n\nWhat do you do?");
	choice1.setText("Talk to the guard");
	choice2.setText("Attack the guard");
	choice3.setText("");
	choice4.setText("Leave");
    }
	
    private void talkGuardDolanar(){  
		
	playableCharacter.setPosition("Guard Dalanar");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	mainTextArea.setText("Guard: Hello " + playableCharacter.getType() + ". \n"
				+ "I have never seen your face. \nI am sorry but we cannot let stranger "
				+ "enter in our town!" );
		
	choice1.setText(">");
	choice2.setText(""); //Here a question why could be added for extra engagement
	choice3.setText("");
	choice4.setText("");
    }
	
    private void attackGuardDolanar(){
        
        playableCharacter.setPosition("Attack Guard Dalanar");
        playerPosition.setText("Position: " + playableCharacter.getPositio());
		
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard!.\n"
				+ "You receive 100 damage!");
        playableCharacter.receiveDamage(100);
        playerHpLabel.setText("HP: " + playableCharacter.getHealth());
        youAreDead();
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    private void leaveDolanar(){
        
	playableCharacter.setPosition("Leave Dalanar");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	mainTextArea.setText("There is a dark forest in front of you."
				+ "\nNot many people have survived crossing this forest."
				+ "\nWhat do you do?");
	choice1.setText("Enter Forest");
	choice2.setText("Back to Dalanal");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void forest(){	

        playableCharacter.setPosition("Forest");
        playerPosition.setText("Position: " + playableCharacter.getPositio());
		
        if(playableCharacter.getHealth() < playableCharacter.getMaxHealth())
            mainTextArea.setText("There is a river. You drink water and rest at \nthe river side.\n\nYour HP is recovered\nWhat do you do?");
        else
            mainTextArea.setText("There is a river. You drink water and rest at \nthe river side. \nWhat do you do?");
        playableCharacter.restoreMaxHP();
        playerHpLabel.setText("HP: " + playableCharacter.getHealth());
            
	choice1.setText("Go ahead");
        choice2.setText("Go back To Dalanar");
        choice3.setText("");
        choice4.setText("");
    }
	
    private void forestExit(){
        
        playableCharacter.setPosition("Forest Exit");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	mainTextArea.setText("You survived the dark forest!\n\nThere are two ways to go now:"
				+ "\nGo to the Mountains or \nRut'theran Village");
	
	choice1.setText("Mountains");
	choice2.setText("Rut'theran Villag");
	choice3.setText("Go back to Forest");
	choice4.setText("");
    }
	
    private void mountain(){
		
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	if(enemies.get(0).dead() == false ){
            
            playableCharacter.setPosition("Mountains");
            mainTextArea.setText("You encounter " + enemies.get(0).getType() + "!");
            setEnemieStatBar(true,  0);
            
            choice1.setText("Attack");
            choice2.setText("Run Forest");
            choice3.setText("Run Desert");
            choice4.setText("");
	}
	else {
            
            setEnemieStatBar(false,  0);
            mountainEnemiDead();
	}
    }

    private void fightMountainEnemie(){
        
	playableCharacter.setPosition("Mountains Fight");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	playableCharacter.attackCharacter(enemies.get(0));
		
	setEnemieStatBar(true,  0);
	enemies.get(0).attackCharacter(playableCharacter);
		
	mainTextArea.setText("You attacked " + enemies.get(0).getName() + "\n" + enemies.get(0).getName() + " attacked you");
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
	if(enemies.get(0).dead() == true){
            
            mainTextArea.setText(enemies.get(0).getName() + " is dead.");
            setEnemieStatBar(false,  0);
            mountainEnemiDead();
	}
    }
	
    private void youAreDead(){
		
	if(playableCharacter.dead() == true){
            
            mainTextArea.setText("You are dead. There is nothing else you can do. \n");
            playableCharacter.setPosition("Dead");
            playerPosition.setText("Position: " + playableCharacter.getPositio());
			
            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
	}
    }
	
    private void mountainEnemiDead(){
        
	playableCharacter.setPosition("Mountains Enemy Dead");
	playerPosition.setText("Position: Mountains" );
	mainTextArea.setText("You killed " + enemies.get(0).getName() + "\nWhere do you want to go?");
		
	choice1.setText("Cave");
	choice2.setText("Forest");
	choice3.setText("Desert");
	choice4.setText("");
    }
	
    private void cave(){
	
	playableCharacter.setPosition("Cave");
	playerPosition.setText("Position: " + playableCharacter.getPositio() );
	if(health.get(0).getSpawn() == true)
            caveHelth();
	else{
            mainTextArea.setText("Where do you want to go?");
            choice1.setText("Honor Hold");
            choice2.setText("Mountain");
            choice3.setText("");
            choice4.setText("");
	}
    }
	
    private void caveHelth(){
        
	playableCharacter.setPosition("CaveHealth");
	mainTextArea.setText("You found health item.\nYou can use it or take it with you.\nWhat do you want to do?");
		
	choice1.setText("Take it");
	choice2.setText("Use it");
	choice3.setText("Leave it");
	choice4.setText("");
    }
    
    private void caveHealthTaken(){
        
	playableCharacter.takeItem(health.get(0));
	healthButton.setText("Health: " + playableCharacter.getSlots());
	healthButtonPanel.setVisible(true);
		
	health.get(0).setSpawn(false);
	playableCharacter.setPosition("caveHealthTaken");
	playerPosition.setText("Position: Cave" );
	mainTextArea.setText("The health is in your inventory.\nYou can use it whenever you want");
	
	healthButtonPanel.setVisible(true);
	cave();
    }
    
    private void useHealth(){
		
	if(playableCharacter.getMaxHealth() == playableCharacter.getHealth()){
            
            playableCharacter.setPosition("CaveHealthCannotBeUsed");
            mainTextArea.setText("Your health is full.\nYou can only take or leave the health");
	
            choice1.setText("Take it");
            choice2.setText("Leave it");
            choice3.setText("");
            choice4.setText("");
	}
	else{
            
            playableCharacter.setPosition("CaveHealthUsed");
            playableCharacter.setHealth(playableCharacter.getHealth() + health.get(0).getHealthCharacter());
            playerHpLabel.setText("HP: " + playableCharacter.getHealth());
            health.get(0).setSpawn(false);
            mainTextArea.setText("Your health got restored by " + health.get(0).getHealthCharacter()
					+ "\nWhere do you want to go?");
			
            choice1.setText("Honor Hold");
            choice2.setText("Mountain");
            choice3.setText("");
            choice4.setText("");
	}
    }
    
    private void leaveHealth(){
        
	health.get(0).setSpawn(false);
	cave();
    }
	
    private void honorHold(){
        
	playableCharacter.setPosition("Honor Hold");
	playerPosition.setText("Position: " + playableCharacter.getPositio());
	mainTextArea.setText("You arrived in a small mistical village \npopulated with Shamans.You see \nthe oldest shaman"
				+ " in front of you. \n\nWhat do you do?");
			
	choice1.setText("Talk to the shaman");
	choice2.setText("Attack the shaman");
	choice3.setText("");
	choice4.setText("Go Back Cave");
    }
	
    private void talkShamanHonorHold(){
        
	playableCharacter.setPosition("Shaman Honor hold");
	playerPosition.setText("Position: Honor Hold" );
	mainTextArea.setText("Shaman: Hello. "
			+ "I have heard you have \ndefeated " + enemies.get(0).getName() + ", thank you." + ".\nA mistick monster"
			+ " have been terrorizing our world for decades. This monster \nholds "
			+ "the Dalanar's princess magic \ncrown.The monster lives around the ocean." );
	talkedShaman = true;
		
	choice1.setText(">");
	choice2.setText(""); 
	choice3.setText("");
	choice4.setText("");
    }
	
    private void attackShamanHonorHold(){
        
	playableCharacter.setPosition("Attack Shaman Honor Hold");
	playerPosition.setText("Position: Honor Hold");
		
	mainTextArea.setText("The shaman teleported behind you and \ncasted you with a black spell .\n"
				+ "You receive 200 damage!");
	playableCharacter.receiveDamage(200);
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void caveAfterShaman(){
        
	if(talkedShaman == false)
            cave();
	else if(enemies.get(1).dead() == true)
            cave();
	else
            attackedInTheCave();
    }
	
    private void attackedInTheCave(){
        
	playableCharacter.setPosition("Cave Attack Enemy");
	mainTextArea.setText("A  " + enemies.get(1).getType() + " has been fowoling you "
				+ "all the way \nfrom the forest.\nWhat do you do?");
	setEnemieStatBar(true,  1);
			
	choice1.setText("Attack");
	choice2.setText("Run Honor Hold");
	choice3.setText("Run Mountain");
	choice4.setText("");
    }
	
    private void fightCaveEnemy(){
		
        playerPosition.setText("Position: Cave " );
	playableCharacter.attackCharacter(enemies.get(1));
	setEnemieStatBar(true,  1);
	enemies.get(1).attackCharacter(playableCharacter);
		
	mainTextArea.setText("You attacked " + enemies.get(1).getName() + "\n" + enemies.get(1).getName() + " attacked you");
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
		
	choice1.setText("Attack");
	choice2.setText("Run Honor Hold");
	choice3.setText("Run Mountain");
	choice4.setText("");
	if(enemies.get(1).dead() == true){
            
            mainTextArea.setText(enemies.get(1).getName() + " is dead.");
            setEnemieStatBar(false,  1);
            caveEnemiDead();
	}
    }
	
    private void caveEnemiDead(){
        
	playableCharacter.setPosition("Cave Enemy Dead");
	playerPosition.setText("Position: Cave");
	mainTextArea.setText("You killed " + enemies.get(1).getName() + " and he dropped \na ring."
				+ "\nWhat do you do?");
	enemies.get(1).dead();
	
        choice1.setText("Take Ring");
	choice2.setText("Leave");
	choice3.setText("");
	choice4.setText("");
    }
    
    private void takeCaveRing(){
        
	Ring growthShaper = new Ring(200);
	playableCharacter.setPosition("CaveRingTaken");
	playerPosition.setText("Position: Cave");
	mainTextArea.setText("You took Growthshaper Ring and your \nmaximum Healt is increased"
				+ "by " + growthShaper.getRestoring() +  "  hp.\nWhat do you want to do?");
	playableCharacter.setMaxHealth(growthShaper.getRestoring());
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	playableCharacter.takeItem(growthShaper);
		
	growthShaper.setSpawn(false);
		
	choice1.setText("Go Honor Hold");
	choice2.setText("Go Mountain");
	choice3.setText("");
	choice4.setText("");
    }
    
    private void leaveCaveRing(){
        
	playableCharacter.setPosition("CaveRingLeft");
	mainTextArea.setText("Where do you want to go?");
		
	choice1.setText("Honor Hold");
	choice2.setText("Mountain");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void desert(){
	
        if(enemies.get(2).dead() == false){
            
            playableCharacter.setPosition("Desert");
            playerPosition.setText("Position: Desert");
            mainTextArea.setText("You cannot see anything due to sand storm.\nSuddently, you see a shadow in front of you"
					+ "  \n\nWhat do you do?");
			
            choice1.setText("Go talk to the shadow");
            choice2.setText("Go Mountain");
            choice3.setText("Go Rut'theran Village");
            choice4.setText("");
	}
	else{
            
            playableCharacter.setPosition("DesertNoShadow");
            playerPosition.setText("Position: Desert");
            mainTextArea.setText("It is hot here!\n\nWhat do you do?");
				
            choice1.setText("Go Nethergarde");
            choice2.setText("Go Mountain");
            choice3.setText("Go Rut'theran Village");
            choice4.setText("");
	}
    }
	
    private void attackGuardian(){
        
	playableCharacter.setPosition("talkShadow");
	mainTextArea.setText("Hello " + playableCharacter.getName() + ", my name is " + enemies.get(2).getName() 
				+"\nI am one of the Mistikal Monster Guardians. \nThere is no way I am letthing you pass \nthrough the Desserd."
				+ "I will kill you fast!  \nWhat do you do?");
		
	setEnemieStatBar(true,  2);
		
	choice1.setText("Attack");
	choice2.setText("Run Honor Hold");
	choice3.setText("Run Mountain");
	choice4.setText("");
    }
	
    private void fightDeserdGuardian(){
        
	playerPosition.setText("Position: Desert" );
	playableCharacter.attackCharacter(enemies.get(2));
		
	setEnemieStatBar(true,  2);
	enemies.get(2).attackCharacter(playableCharacter);
		
	mainTextArea.setText("You attacked " + enemies.get(2).getName() + "\n" + enemies.get(2).getName() + " attacked you");
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
		
	choice1.setText("Attack");
	choice2.setText("Run Honor Hold");
	choice3.setText("Run Mountain");
	choice4.setText("");
	if(enemies.get(2).dead() == true){
            
            mainTextArea.setText(enemies.get(2).getName() + " is dead.");
            setEnemieStatBar(false,  2);
            deserdEnemiDead();
	}
    }
	
    private void deserdEnemiDead(){
        
	playableCharacter.setPosition("Deserd Enemy Dead");
	playerPosition.setText("Position: Cave");
	mainTextArea.setText("You killed " + enemies.get(2).getName() + " .\nWhat do you do?");
	enemies.get(2).dead();
		
	choice1.setText("Go Nethergarde");
	choice2.setText("Go Rut'ther Village");
	choice3.setText("Go Mountains");
	choice4.setText("");
    }
	
    private void ruttheranVillage(){
		
	if(enemies.get(0).dead() == true && enemies.get(1).dead() == true && enemies.get(2).dead() == true && gift.getSpawn() == true){
            
            playableCharacter.setPosition("Rut'ther Village");
            playerPosition.setText("Position: Rut'ther Village");
				
            mainTextArea.setText("Hello " + playableCharacter.getName() + ", every body talks about "
				+ "\nhow brave you are. Plese accept this \n" + gift.getType() +  " as a gift of gratefulness from \nour village.");
            playableCharacter.takeItem(gift);
            playableCharacter.setDamage(playableCharacter.getDamage() + gift.getDmg());
            playerWeaponLabel.setText("Weapon: " + gift.getType());
            playerDamageLabel.setText("Damage: " + playableCharacter.getDamage());
            gift.setSpawn(false);
            choice1.setText("Go Desert");
            choice2.setText("Go Forest");
            choice3.setText("");
            choice4.setText("");
	}
	else{
            playableCharacter.setPosition("Rut'ther Village");
            playerPosition.setText("Position: Rut'ther Village");
            mainTextArea.setText("A small normal village. \nNothing to do here yet.\n\nWhat do you do?");
			
            choice1.setText("Go Desert");
            choice2.setText("Go Forest");
            choice3.setText("");
            choice4.setText("");
	}
    }
	
    private Weapon createWeapon(){
        
	String type = "";
	int dmg = 0;
		
	if(playableCharacter.getType().equalsIgnoreCase("warrior")) {type = "Long Sword"; dmg = 15; }
	if(playableCharacter.getType().equalsIgnoreCase("mage")) {type = "Ancient Wand"; dmg = 25; }
	if(playableCharacter.getType().equalsIgnoreCase("barbarian")) {type = "Thunderbolt Hammer"; dmg = 25; }
	if(playableCharacter.getType().equalsIgnoreCase("hunter")) {type = "Ricirus Dagger"; dmg = 60; }
	if(playableCharacter.getType().equalsIgnoreCase("monster")) {type = "Axe"; dmg = 30; }
	
        Weapon temp = new Weapon(type, dmg);
	return temp;
    }
	
    private void nethergarde(){
        
	playableCharacter.setPosition("Nethergarde");
	playerPosition.setText("Position: Nethergarde");
	mainTextArea.setText("What is this place!?!?.\nThere are bodies and wouldned people everywhere around you."
				+ "  \n\nWhat do you do?");
		
	choice1.setText("Inspect the place");
	choice2.setText("Go Desert");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void inspectingNethergrade(){
        
	if(enemies.get(3).dead() == true){
            
            playerPosition.setText("Position: NethergardeKilled");
            playableCharacter.setPosition("NethergardeKilled");
            mainTextArea.setText("You help some survived people.\n\nWhat do you do after?");
			
            choice1.setText("Go Ocean");
            choice2.setText("Go Desert");
            choice3.setText("");
            choice4.setText("");
	}
	else{
            
            playableCharacter.setPosition("NethergardeInspecting");
            playerPosition.setText("Position: Nethergarde");
            setEnemieStatBar(true,  3);
            mainTextArea.setText("Walking between the bodies you see a \n" + enemies.get(3).getType()+ "!?!?.This one however, is stronger \nthan the others."
            			+ "  \n\nWhat do you do?");
		
            choice1.setText("Attack");
            choice2.setText("Go Desert");
            choice3.setText("");
            choice4.setText("");
	}
    }
    
    private void attackNethergrade(){
        
	enemies.get(3).setDamage(enemies.get(3).getDamage() + 5);
	playerPosition.setText("Position: Nethergrade" );
	playableCharacter.attackCharacter(enemies.get(3));
	setEnemieStatBar(true,  3);
	enemies.get(3).attackCharacter(playableCharacter);
		
	mainTextArea.setText("You attacked " + enemies.get(3).getName() + "\n" + enemies.get(3).getName() + " attacked you");
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
		
	choice1.setText("Attack");
	choice2.setText("Run Honor Hold");
	choice3.setText("Run Mountain");
	choice4.setText("");
	if(enemies.get(3).dead() == true){
            
            mainTextArea.setText(enemies.get(3).getName() + " is dead.");
            setEnemieStatBar(false,  3);
            netheergrageEnemyDead();
	}
    }
    
    private void netheergrageEnemyDead(){
        
	playableCharacter.setPosition("netheergrageEnemyDead");
	mainTextArea.setText(enemies.get(3).getName() + " droped a \nRune of The Darkening!"
				+ " If you embed it into \nyour " + gift.getType()  + " it will increase " + 
				" your \ndamage with 50%. \n\nWhat do you do?");
		
	choice1.setText("Emded it!");
	choice2.setText("Leave it");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void embedWeapon(){
        
	playableCharacter.setPosition("embedWeapon");
	mainTextArea.setText("You embedded your " + gift.getType() + ".\n\nWhat do you do?");
	double tempDmg = playableCharacter.getDamage();
	tempDmg = tempDmg * 0.5;
	int value  = (int) tempDmg;
	wEmb = true;
	playableCharacter.setDamage(playableCharacter.getDamage() + value);
	playerDamageLabel.setText("Damage: " + playableCharacter.getDamage());
		
	choice1.setText("Go Ocean");
	choice2.setText("Go Desert");
	choice3.setText("");
	choice4.setText("");
    }
	
    private void ocean(){
        
        if(enemies.get(4).dead() == true){
            
            playableCharacter.setPosition("OceanDead");
            playerPosition.setText("Position: Ocean");
            mainTextArea.setText("There is a beautiful view of the ocean in front of you!\n\nWhat do you do?");
			
            choice1.setText("Teleport Dalanar");
            choice2.setText("Go Nethergarde");
            choice3.setText("");
            choice4.setText("");
	}
	else{
            
            playableCharacter.setPosition("Ocean");
            playerPosition.setText("Position: Ocean");
            mainTextArea.setText("Where am I ?!?\nSudently you teleported deep into the ground"
					+ "\nThere is fire everywhere and million of dead \nfaces watching you.\n\nWhat do you do?");
			
            choice1.setText("Walk forward");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
	}
    }
    
    private void underground(){
        
	enemies.get(4).setDamage(enemies.get(4).getDamage() + 30);
	enemies.get(4).setHealth(enemies.get(4).getHealth() + 100);
		
	playableCharacter.setPosition("underground");
	playerPosition.setText("Undefined");
	mainTextArea.setText(enemies.get(4).getName() + ": Hahaha. I can't believe my \neyes. The great " + playableCharacter.getName() + " who "
				+ "everyone \ntalks about. You are not getting alive out \nof here " + playableCharacter.getType() + ", say your finall words!");
		
	setEnemieStatBar(false,  4);
	
	choice1.setText("Attack");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
    }
    
    private void finalBossFight(){
        
	playerPosition.setText("Final Boss");
	playableCharacter.attackCharacter(enemies.get(4));
	setEnemieStatBar(true,  4);
	enemies.get(4).attackCharacter(playableCharacter);
		
	mainTextArea.setText("You attacked " + enemies.get(4).getName() + "\n" + enemies.get(4).getName() + " attacked you");
	playerHpLabel.setText("HP: " + playableCharacter.getHealth());
	youAreDead();
		
	choice1.setText("Attack");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
	if(enemies.get(4).dead() == true){
            
            mainTextArea.setText(enemies.get(4).getName() + " is dead.");
            setEnemieStatBar(false,  3);
            finalBossDead();
            crownRestored = true;
	}
    }
    
    private void finalBossDead()
	{
	playableCharacter.setPosition("done");
	playerPosition.setText("Position: Ocean");
	mainTextArea.setText("You  killed the Monster!!! \nGo and give the crown to the princess now!");
		
	choice1.setText("Teleport to Dalanar");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
    }
    
    private void theEnd(){
        
	mainTextArea.setText("\n\n\t<THE END> ");
    }

    private void dalanarEnd(){
        
	playableCharacter.setPosition("DalanarDone");
	playerPosition.setText("Position: Dalanar Gates");
	mainTextArea.setText("Guard: Hello " + playableCharacter.getType() + ". \n"
			+ "I have heard that you have killed the Monster \nand restored the crown back!"
			+ "\nPlease sir, our princess is waiting for you." );
	choice1.setText("Enter Dalanar");
	choice2.setText(""); //Here a question why could be added for extra engagement
	choice3.setText("");
	choice4.setText("");
    }
	
	
    //This method is called whenever an enemy is encounter and displays enemies status on the 
    //right up corner. 
    //It has boolean which says - display (true) or do not display(false)
    //and index which indicates which character status from the ArrayList to print
    public void setEnemieStatBar(boolean set,  int index){
        
	if(set == true){
            
            enemieNameTypeLabel.setText(enemies.get(index).getName() + " " + enemies.get(index).getType());
            enemieHpLabel.setText("HP: " + enemies.get(index).getHealth());
            enemieDamageLabel.setText("Damage " + enemies.get(index).getDamage());
            enemieSpecialLabel.setText("Special: " + enemies.get(index).getSpecial());
	}
	if(set == false){
            
            enemieNameTypeLabel.setText("");
            enemieHpLabel.setText("");
            enemieDamageLabel.setText("");
            enemieSpecialLabel.setText("");
	}
    }
	

    //method that initialise the enemies for the whole game
    //it creates an array list and then removes the enemies that 
    //maches the same character you picked
    //it then shuffles the array so every time you 
    //encounter a character the enemies will be different 
    private void initialiseEnemies(Character ch){
        
	enemies = new ArrayList<>(0);
	enemies.add(new Warrior("Lord Serpentis"));
	enemies.add(new Assasin("Maiev Shadowsong"));
	enemies.add(new Barbarian("Mankrik"));
	enemies.add(new Hunter("Illidan Stormrage"));
	enemies.add(new Mage("Sargeras"));
	enemies.add(new Monster("Vol’jin"));
		
	for(int i = 0; i < enemies.size(); i++){
            if(ch.getType().equals(enemies.get(i).getType()))
                enemies.remove(i);
	}
	Collections.shuffle(enemies);
	gift = createWeapon();
    }
	
	
	
	
	
    /////////////////////////LISTENERS/////////////////////////////////////////////
    //Listener for the very first buttons Start or Continue
    class TitleScreenHandler implements ActionListener{
        
	public void actionPerformed(ActionEvent evt){
            
            String yourChoice = evt.getActionCommand();
            if(yourChoice.equals("start"))
                enterYourNameScreen();
            else if(yourChoice.equals("continue"))
		createGameScreen("continue");
	}
    }

    //Listener for the text are that gets the name that a player 
    //may want to use for its character 
    class EnterScreenHandler implements ActionListener{
        
	public void actionPerformed(ActionEvent evt){
            
            playableCharacterName = nameTextField.getText();
            pickCharacterScreen();
	}
    }
	
    class healthCharacterHandler implements ActionListener{
        
	public void actionPerformed(ActionEvent evt){
            
            if(playableCharacter.getHealth() == playableCharacter.getMaxHealth())
                mainTextArea.setText("Your health is full!");
            else if(playableCharacter.getMaxHealth() - playableCharacter.getHealth() < health.get(0).getHealthCharacter()){
                
		mainTextArea.setText("Your health got restored by " + (playableCharacter.getMaxHealth() - playableCharacter.getHealth()));
		health.get(0).useHealth(playableCharacter);
		playerHpLabel.setText("HP: " + playableCharacter.getHealth());
		playableCharacter.addSlots();
		healthButton.setText("Health: " + playableCharacter.getSlots());
		if(playableCharacter.getSlots() == 0)
                    healthButton.setVisible(false);
            }
            else{
                
		mainTextArea.setText("Your health got restored by " + health.get(0).getHealthCharacter());
		playableCharacter.setHealth(health.get(0).useHealth(playableCharacter));
		playerHpLabel.setText("HP: " + playableCharacter.getHealth());
		playableCharacter.addSlots();
		healthButton.setText("Health: " + playableCharacter.getSlots());
		if(playableCharacter.getSlots() == 0)
                    healthButton.setVisible(false);
		
            }
	}
    }
	
    //Listener for when picking character to play with before starting the game 
    class PickCharacterHandler implements ActionListener{
        
	public void actionPerformed(ActionEvent evt){
            
            if(evt.getSource() == buttonChar1 )
                playableCharacter = new Warrior(playableCharacterName);
            else if(evt.getSource() == buttonChar2 )
		playableCharacter = new Mage(playableCharacterName);
            else if(evt.getSource() == buttonChar3 )
		playableCharacter = new Barbarian(playableCharacterName);
            else if(evt.getSource() == buttonChar4 )
		playableCharacter = new Hunter(playableCharacterName);
            else if(evt.getSource() == buttonChar5 )
		playableCharacter = new Assasin(playableCharacterName);
            else if(evt.getSource() == buttonChar6 )
		playableCharacter = new Monster(playableCharacterName);
            initialiseEnemies(playableCharacter);
            createGameScreen("start");
            townGateDolanar();
	}
    }
		
	
    //Listener for the InGame 4 buttons they check first position and considering
    //possition they open different methods which methods are different scenarios of the 
    //game
    private class ChoiseHandler implements ActionListener{
        
	public void actionPerformed(ActionEvent evt){
            
            String yourChoice = evt.getActionCommand();
            if(playableCharacter.getPositio().equalsIgnoreCase("Dalanar Gate")){
                
		if(yourChoice.equals("c1")) 
                    talkGuardDolanar(); //talk to Guard at Dalanar
		else if(yourChoice.equals("c2")) 
                    attackGuardDolanar(); //attacks Guard at Dalanar
		else if(yourChoice.equals("c3")){}
		else if(yourChoice.equals("c4")) 
                    leaveDolanar();//leaves Dalanar
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Guard Dalanar")){
                
		if(yourChoice.equals("c1")) 
                    townGateDolanar();
		else if(yourChoice.equals("c2")) {}
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equals("Save Game")){
                
		if(yourChoice.equals("c1")) 
                    townGateDolanar();
		else if(yourChoice.equals("c2")) {}
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Attack Guard Dalanar")){
                
		if(yourChoice.equals("c1")) 
                    townGateDolanar(); //back to Dalanar Gates
		else if(yourChoice.equals("c2")) {}
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Leave Dalanar")){
                
		if(yourChoice.equals("c1")) 
                    forest();
		else if(yourChoice.equals("c2"))
                    townGateDolanar(); //goes back to the gate of Dalanar
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Forest")){
                
                if(yourChoice.equals("c1")) 
                    forestExit();
		else if(yourChoice.equals("c2"))
                    leaveDolanar();//goes back to the exit of Dalanar
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Forest Exit")){
                
		if(yourChoice.equals("c1")) 
                    mountain();
		else if(yourChoice.equals("c2"))
                    ruttheranVillage();
		else if(yourChoice.equals("c3")) 
                    forest(); //goes back to the forest
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Mountains")){
                				
		if(yourChoice.equals("c1")) 
                    fightMountainEnemie();
		else if(yourChoice.equals("c2"))
                    forestExit();
		else if(yourChoice.equals("c3")) 
                    desert();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Mountains Fight")){
                
		if(yourChoice.equals("c1")) 
                    fightMountainEnemie();
		else if(yourChoice.equals("c2"))
                    forestExit();
		else if(yourChoice.equals("c3"))
                    desert();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Mountains Enemy Dead")){
                
		if(yourChoice.equals("c1")) 
                    cave();
		else if(yourChoice.equals("c2"))
                    forestExit();
		else if(yourChoice.equals("c3"))
                    desert();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Cave")){
                
		if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3"))
                    desert();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveHealth")){
                
		if(yourChoice.equals("c1")) 
                    caveHealthTaken();
		else if(yourChoice.equals("c2"))
                    useHealth();
		else if(yourChoice.equals("c3"))
                    leaveHealth();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveHealthUsed")){
                
		if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveHealthCannotBeUsed")){
                
		if(yourChoice.equals("c1")) 
                    caveHealthTaken();
		else if(yourChoice.equals("c2"))
                    leaveHealth();
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Honor Hold")){
                
		if(yourChoice.equals("c1")) 
                    talkShamanHonorHold();
		else if(yourChoice.equals("c2"))
                    attackShamanHonorHold();
		else if(yourChoice.equals("c3")) {}
                else if(yourChoice.equals("c4")) 
                    caveAfterShaman();
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Shaman Honor hold")){
                
		if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2")) {}
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Attack Shaman Honor Hold")){
                
		if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2")) {}
		else if(yourChoice.equals("c3")) {}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveFight")){
                
		if(yourChoice.equals("c1")) 
                    fightCaveEnemy();
		else if(yourChoice.equals("c2"))
                    honorHold();
		else if(yourChoice.equals("c3"))
                    mountain();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Cave Enemy Dead")){
                
		if(yourChoice.equals("c1")) 
                    takeCaveRing();
		else if(yourChoice.equals("c2"))
                    leaveCaveRing();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveRingTaken")){
                if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("CaveRingLeft")){
                
		if(yourChoice.equals("c1")) 
                    honorHold();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Cave Attack Enemy")){
                
		if(yourChoice.equals("c1")) 
                    fightCaveEnemy();
		else if(yourChoice.equals("c2"))
                    honorHold();
		else if(yourChoice.equals("c3"))
                    mountain();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Desert")){
                
		if(yourChoice.equals("c1")) 
                    attackGuardian();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3"))
                    ruttheranVillage();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("talkShadow")){
                
		if(yourChoice.equals("c1")) 
                    fightDeserdGuardian();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3"))
                    ruttheranVillage();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Deserd Enemy Dead")){
                
		if(yourChoice.equals("c1")) 
                    nethergarde();
		else if(yourChoice.equals("c2"))
                    ruttheranVillage();
		else if(yourChoice.equals("c3"))
                    mountain();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("DesertNoShadow")){
                
		if(yourChoice.equals("c1")) 
                    nethergarde();
		else if(yourChoice.equals("c2"))
                    mountain();
		else if(yourChoice.equals("c3"))
                    ruttheranVillage();
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Rut'ther Village")){
                
		if(yourChoice.equals("c1")) 
                    desert();
		else if(yourChoice.equals("c2"))
                    forest();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Nethergarde")){
                
		if(yourChoice.equals("c1")) 
                    inspectingNethergrade();
		else if(yourChoice.equals("c2"))
                    desert();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("NethergardeInspecting")){
                
		if(yourChoice.equals("c1")) 
                    attackNethergrade();
		else if(yourChoice.equals("c2"))
                    desert();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("netheergrageEnemyDead")){
                
		if(yourChoice.equals("c1")) 
                    embedWeapon();
		else if(yourChoice.equals("c2"))
                    nethergarde();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("embedWeapon")){
                
		if(yourChoice.equals("c1")) 
                    ocean();
		else if(yourChoice.equals("c2"))
                    desert();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("Ocean")){
                
		if(yourChoice.equals("c1")) 
                    underground();
		else if(yourChoice.equals("c2")){}
                else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("underground")){
                
                if(yourChoice.equals("c1")) 
                    finalBossFight();
		else if(yourChoice.equals("c2")){}
                else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("done")){
                
                if(yourChoice.equals("c1")) 
                    dalanarEnd();
		else if(yourChoice.equals("c2")){}
                else if(yourChoice.equals("c3")){}
		else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("DalanarDone")){
                
                if(yourChoice.equals("c1")) 
                    theEnd();
		else if(yourChoice.equals("c2")){}
                else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("NethergardeKilled")){
                
                if(yourChoice.equals("c1")) 
                    ocean();
		else if(yourChoice.equals("c2"))
                    desert();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
            else if(playableCharacter.getPositio().equalsIgnoreCase("OceanDead")){
                
                if(yourChoice.equals("c1")) 
                    dalanarEnd();
		else if(yourChoice.equals("c2"))
                    nethergarde();
		else if(yourChoice.equals("c3")){}
                else if(yourChoice.equals("c4")) {}
            }
	}		
    }

}