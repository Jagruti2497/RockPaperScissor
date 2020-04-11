package com.internship.StonePaperScissor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.StonePaperScissor.service.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	public List<String> startGame() {
		int player1Choice=0,player2Choice=0,player3Choice=0,player4Choice=0,player1Score=0,player2Score=0,player3Score=0,player4Score=0;		
		List<String> result=new ArrayList<>();
		for(int i=0;i<50; i++){				//Total 50 rounds
			player1Choice=(int)(Math.random()*3);		//Choice of player 1
		    player2Choice=(int)(Math.random()*3);		//Choice of player 2
			player3Choice=(int)(Math.random()*3);		//Choice of player 3
			player4Choice=(int)(Math.random()*3);		//Choice of player 4
			int playersChoices[]={player1Choice,player2Choice,player3Choice,player4Choice};
			
			for(int j=0;j<playersChoices.length;j++){
				for(int k=j+1;k<playersChoices.length;k++){
					
					String winner=getWinner(playersChoices[j],playersChoices[k],j+1,k+1);
					
					result.add("Round "+(i+1)+") Player "+(j+1)+" Choice= "+getChoice(playersChoices[j])+", Player "+(k+1)+" Choice= "+getChoice(playersChoices[k])+", Winner = "+winner);
					//Following logic to calculate Final score of each player
					if(winner.equalsIgnoreCase("Player 1 WON!")){
						player1Score++;
					}else if(winner.equalsIgnoreCase("Player 2 WON!")){
						player2Score++;
					}else if(winner.equalsIgnoreCase("Player 3 WON!")){
						player3Score++;
					}else if(winner.equalsIgnoreCase("Player 4 WON!")){
						player4Score++;
					}
				}
			}
		}
		result.add("The Final Result is : ");
		result.add("Player 1 Score = "+player1Score);
		result.add("Player 2 Score = "+player2Score);
		result.add("Player 3 Score = "+player3Score);
		result.add("Player 4 Score = "+player4Score);
		return result;
	}
	
	//This method compares the choices of both players and returns the winner 
	private String getWinner(int p1Choice, int p2Choice, int player1, int player2){
		/*0= rock
		1= paper
		2=scissor*/
		if(p1Choice==0){		//If 1st player picks Rock
			if(p2Choice!=1){		//If 2nd player doesn't pick Paper(either picks Rock or Scissor)
				if(p2Choice!=0){		//If 2nd player doesn't pick Rock( picks Scissor)
					return "Player "+player1+" WON!";		//Rock beats Scissor so 1st player won
				}
				return "TIE!";		//Both pick Rock
			}
			return "Player "+player2+" WON!";		//Paper beats Rock so 2nd player won
		}
		
		if(p1Choice==1){		//If 1st player picks Paper
			if(p2Choice!=2){		//If 2nd player doesn't pick Scissor(either picks Rock or Paper)
				if(p2Choice!=1){		//If 2nd player doesn't pick Paper( picks Rock)
					return "Player "+player1+" WON!";		//Paper beats Rock so 1st player won
				}
				return "TIE!";		//Both pick Paper
			}
			return "Player "+player2+" WON!";		//Scissor beats Paper so 2nd player won
		}
		
		if(p1Choice==2){		//If 1st player picks Scissor
			if(p2Choice!=0){		//If 2nd player doesn't pick Rock(either picks Scissor or Paper)
				if(p2Choice!=2){		//If 2nd player doesn't pick Scissor( picks Paper)
					return "Player "+player1+" WON!";		//Scissor beats Paper so 1st player won
				}
				return "TIE!";		//Both pick Scissor
			}
			return "Player "+player2+" WON!";		//Rock beats Scissor so 2nd player won
		}	
		return null;
	}
	
	//This method is for getting the value of choice of the player
	private String getChoice(int choice){
		if(choice==0){
			return "ROCK ";
		}else if(choice==1){
			return "PAPER ";
		}else if(choice==2){
			return "SCISSOR ";
		}
		return "Invalid input";
	}
}
