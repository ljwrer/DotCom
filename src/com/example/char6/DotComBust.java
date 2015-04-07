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
			for(DotCom dotComTest:dotComList)
			{	
				ArrayList<String>newLocation=helper.placeDotCom(3);
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
			
		}
		void finishGame()
		{
			System.out.println(numOfGuesses);
		}
	}
