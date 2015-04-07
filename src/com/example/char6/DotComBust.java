package com.example.char6;

import java.util.ArrayList;

public class DotComBust {
		int numOfGuesses=0;
		ArrayList<DotCom>dotComList=new ArrayList<DotCom>();
		GameHelper helper=new GameHelper();
		void setUpGame()
		{
			DotCom one=new DotCom();
			DotCom two=new DotCom();
			DotCom three=new DotCom();
			one.setName("Go2.com");
			dotComList.add(one);
			two.setName("Pets.com");
			dotComList.add(two);
			three.setName("AskMe.com");
			dotComList.add(three);
			System.out.println("Your goal is to sink three");
			System.out.println("Pets.com,Go2.com,AskMe.com");
			System.out.println("Try to sink them all in the fewest number of guesses");
			for(DotCom dotComTest:dotComList)
			{	
				ArrayList<String>newLocation=helper.placeDotCom(3);
				System.out.println(newLocation);
				dotComTest.setLocationCells(newLocation);
			}
		}
		void startPlaying()
		{
			while(!dotComList.isEmpty())
			{
				String userGuess=helper.getUserInput("Enter a guess");
				checkUserGuess(userGuess);
			}
			finishGame();
		}
		void checkUserGuess(String userGuess)
		{
			numOfGuesses++;
			String result="miss";
			for(DotCom dotComToTest:dotComList)
			{
				result=dotComToTest.checkYourself(userGuess);
				if(result.equals("hit"))
				{
					break;
				}
				if(result.equals("kill"))
				{
					dotComList.remove(dotComToTest);
					break;
				}
			}
			System.out.println(result);
		}
		void finishGame()
		{
			System.out.println("All Dot Coms are dead! Your stock is now worthless.");
			if(numOfGuesses<=18)
			{
				System.out.println("It only took you "+numOfGuesses+" guesses.");
				System.out.println("You got out before your options sank.");
			}
			else
			{
				System.out.println("Took you long enough. "+numOfGuesses+" guesses.");
				System.out.println("Fish are dancing with your options.");
			}
		}
		public static void main(String[] args){
			DotComBust game=new DotComBust();
			game.setUpGame();
			game.startPlaying();
		}
	}
