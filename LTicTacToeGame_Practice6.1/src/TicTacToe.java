
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TicTacToe implements ActionListener {

	public static void main(String[] args) {
		
		new TicTacToe(); } // create classTicTacToe throught variable tic, for execution method main( for launch  app) 
      
	JFrame mainFrame = new JFrame("TicTacToe");
	Button squares[][];
	Button newGameButton;
	Label score;
	Label countScore = new Label ("0:0");
	int emptySquaresLeft = 9;
	int playerScore= 0 ;
	int computerScore=0;
	
	Panel mainPanel= new Panel();
	      
			TicTacToe() {
			
			mainPanel.setLayout(new BorderLayout());
			mainPanel.setBackground (Color.CYAN);
			
			Font mainFont = new Font ("Monospased", Font.BOLD, 20);
			mainPanel.setFont(mainFont);
			
			newGameButton = new Button ("New Game");
			newGameButton.addActionListener(this);
			
			Panel topPanel = new Panel();
			topPanel.add(newGameButton);
			
				mainPanel.add(topPanel,"North");
				
				Panel centerPanel = new Panel();
				centerPanel.setFont(new Font("Monospaced", Font.BOLD,90));
				centerPanel.setLayout(new GridLayout (3,3));
				mainPanel.add(centerPanel, "Center");
				
				score = new Label ("Your Turn!");
				mainPanel.add(score,"South");
				
				
		        topPanel.add(countScore);
		       
    			//create the massive for kepping referense to te 9 buttons
				
				squares = new Button [3][3];
				// create buttons,save the referense to the buttons in massive, regisrer of listener for it, color orange, add to panel
				for (int i=0; i<3; i++) {
					for(int p=0; p<3; i++) {
					
					squares[i][p] = new Button();
					squares[i][p].addActionListener(this);
					squares[i][p].setBackground(Color.ORANGE);
					centerPanel.add(squares[i][p]);
				}
				}
					
		mainFrame.add(mainPanel);
		mainFrame.setSize(800,600);
		mainFrame.setVisible(true);
														
				}
// this metod will be implement all actions  - ActionEvent object										
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Button theButton = (Button) e.getSource ();
			//is it buttîn new game?
				if (theButton == newGameButton) {
					for (int i=0; i<3; i++) {
						for(int p=0; p<3; p++) {
						
						squares[i][p].setEnabled(true);
						squares[i][p].setLabel("");
						squares[i][p].setBackground (Color.ORANGE);
						
					}
				}
					emptySquaresLeft=9;
					score.setText("Your turn!");
					newGameButton.setEnabled(false);
					return; //exit from metod					
				}
		
					String winner = "";
					// it is the one of button
					for(int i=0; i<3; i++) {
						for(int p=0; p<3; p++) {
						
						if (theButton==squares[i][p]) {
							
							squares[i][p].setLabel("X");
							squares[i][p].setEnabled(false);
							winner = lookForWinner();
							
							if(!"".equals(winner)) {
								 endTheGame();
							}
							else {
								computerMove();
								winner = lookForWinner();
								
								if(!"".equals(winner)) {
									endTheGame();
								}
							}
						}
						
							break;
						}
						
					}//end of for
					if(winner.equals("X")) {
						score.setText("You won!");
						playerScore++;
						
					}else if (winner.equals("0")) {
						score.setText("You lost!");
						computerScore++;
					}else if (winner.equals("T")){
						score.setText("It's a tie");
					}
					countScore.setText(playerScore+":"+computerScore);
						
				}// end of method ActionPerformed
		// this is called after each move, checking if there is a winner. It checks each row,string, columnand diagonal 
		//to find three cells with the same entries
		//return  X O T  no winner yet
	
		
		String lookForWinner() {
			String theWinner = "";
			emptySquaresLeft--;
			
			if (emptySquaresLeft==0) {
				return "T"; //
			}
			
			if (!squares[0][0].getLabel().equals("")&&
					
					squares[0][0].getLabel().equals(squares[0][1].getLabel())&&
					squares[0][0].getLabel().equals(squares[0][2].getLabel())){
				
				theWinner =squares[0][0].getLabel();
				highlightWinner (0,1,2);
					
			} else if (!squares[1][0].getLabel().equals("")&&
					squares[1][0].getLabel().equals(squares[1][1].getLabel())&&
					squares[1][0].getLabel().equals(squares[1][2].getLabel())){
				
				theWinner = squares[1][0].getLabel();
				highlightWinner(3,4,5);
				
			}else if (!squares[2][0].getLabel().equals("")&&
					squares[2][0].getLabel().equals(squares[2][1].getLabel())&&
					squares[2][0].getLabel().equals(squares[2][2].getLabel())){
				
				theWinner = squares[2][0].getLabel();
				highlightWinner(6,7,8);
				
			}else if (!squares[0][0].getLabel().equals("")&&
					squares[0][0].getLabel().equals(squares[1][0].getLabel())&&
					squares[0][0].getLabel().equals(squares[2][6].getLabel())){
				
				theWinner = squares[0][0].getLabel();
				highlightWinner(0,3,6);
				
			}else if (!squares[0][1].getLabel().equals("")&&
					squares[0][1].getLabel().equals(squares[1][1].getLabel())&&
					squares[0][1].getLabel().equals(squares[1][1].getLabel())) {
				
				theWinner = squares[0] [1].getLabel();
				highlightWinner (1,4,7);
				
			}else if (!squares[0][1].getLabel().equals("")&&
					
					squares[0][1].getLabel().equals(squares[1][2].getLabel())&&
					squares[0][1].getLabel().equals(squares[2][2].getLabel())) {
				
				theWinner = squares[0][2].getLabel();
				highlightWinner(2,5,8);
				
			}else if (!squares[1][1].getLabel().equals("")&&
			
				squares[0][0].getLabel().equals(squares[1][1].getLabel()) &&
				squares[0][0].getLabel().equals(squares[2][2].getLabel())) {
					
					theWinner =squares[0][2].getLabel();
					highlightWinner(0,4,8);
					
			}else if (!squares[0][2].getLabel().equals("") &&
						
					squares[0][2].getLabel().equals(squares[1][1].getLabel())&&
					squares[0][2].getLabel().contentEquals(squares[2][0].getLabel())){
					
						theWinner = squares[1][1].getLabel();
						highlightWinner(2,4,6);
				}
			
			return theWinner;		
		}	
		
	
						void computerMove()	{ 	// this metod inplements the set of computer rules to find better move. 
							                   //if tha better move was not find - select randow square.
				 
							int selectedSquare;				//firstly computer try to find empty square along with two square  with nole
							
							selectedSquare = findEmptySquare("0");	// if it was not find he  intercepts opponents trying to do row with 3 x, 
							                                         //to set zero along with two x 						
						if (selectedSquare ==-1)							// if selected square=-1, tries to set the central square
							
							selectedSquare = findEmptySquare("X");
							
					//}
						if((selectedSquare ==-1)
									&&(squares[4].getLabel().equals("")) ){
										selectedSquare=4;
												
						}				                                  //just randow square if selected square is not -1								
						if (selectedSquare ==-1) {
						   		selectedSquare = getRandomSquare();		
							}
						   	squares[selectedSquare].setLabel("0");
						   	squares[selectedSquare].setEnabled(false);
						}


						int findEmptySquare(String player) {
							
							int weight[] = new int [9];
							for (int i=0; i<9; i++) {
								
								if(squares[i].getLabel().equals("0"))
									weight[i] = -1;
								else if (squares[i].getLabel().equals("X"))
									weight[i] = 1;
								else
									weight[i]=0;
							}
							
							int twoWeights = player.equals("0") ?-2:2;
							
							
							if (weight[0]+weight[1]+weight[2] == twoWeights){
								
								if(weight[0] == 0)
									return 0;
								else if (weight[1] ==0)
									return 1;
								else 
									return 2;
							}
							if (weight[3] +weight[4]+weight[5]==twoWeights) {
								if (weight[3]==0)
									return 3;
							else if (weight [4] == 0)
								return 4;
							else
								return 5;
							
							}
							if (weight[6] + weight[8] ==twoWeights){
							
							if (weight[6]==0)
								return 6;
							else if (weight[7]==0)
								return 7;
							else
								return 8;
							
						}
							if(weight[0]+weight[3]+weight[6] ==twoWeights) {
							if (weight[0]==0)
								return 0;
							else if (weight[3]==0)
								return 3;
							else 
								return 6;
						}
							if(weight[1]+weight[4]+weight[7]== twoWeights) {
								
								if (weight[1]==0)
									return 1;
								else if (weight [4]==0)
									return 4;
								else
									return 7;
						}
							if(weight[2]+weight[5]+weight[8] ==twoWeights) {
									if (weight [2]== 0)
										return 2;
									else if (weight[5] == 0)
										return 5;
									else
										return 8;
						}
								if(weight[0]+weight[4]+weight[8] == twoWeights) {
									if (weight[0]==0)
										return 0;
									else if (weight[4] ==0)
										return 4;
									else
										return 8;
						}
								if (weight[2]+weight[4]+weight[6]== twoWeights) {
									
									if (weight[2]== 0)
										return 2;
									else if (weight[4]==0)
										return 4;
									else 
										return 6;
								}
								return -1;
							}
																					
						
							int getRandomSquare() {
								
								boolean gotEmptySquare = false;
								int selectedSquare = -1;
								do {
									selectedSquare = (int) (Math.random() * 9);
									if (squares[selectedSquare].getLabel().equals("")){
										gotEmptySquare =true;										
									}
									}while (!gotEmptySquare);
								return selectedSquare;
							}
							void highlightWinner (int win1, int win2, int win3) {
								squares[win1].setBackground(Color.CYAN);
								squares[win2].setBackground(Color.CYAN);
								squares[win3].setBackground(Color.CYAN);
							}
							void endTheGame() {
								newGameButton.setEnabled(true);
								for (int i=0; i<9;i++) {
									squares[i].setEnabled(false);
								}
							}
								
							}








