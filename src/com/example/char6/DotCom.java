package com.example.char6;
import java.util.ArrayList;

class DotCom {
//	int []locationCells=new int[3];
	private ArrayList<String> locationCells;
//	int numOfHits=0;
	String name;
	void setName(String s)
	{
		name=s;
	}
	void setLocationCells(ArrayList<String> cellLocations)
	{
		locationCells=cellLocations;
	}
	String checkYourself(String userInput)
	{
		String result="miss";
//		for(int i=0;i<locationCells.size();i++)
//		{
//			if(guess==Integer.parseInt(locationCells.get(i)))
//			{
//				result="hit";
//				locationCells.remove(i);
//				break;
//			}
//		}
		int index=locationCells.indexOf(userInput);
		if(index>=0)
		{
			locationCells.remove(index);
			if(locationCells.isEmpty())
			{
				result="kill";
			}
			else
			{
				result="hit";
			}
		}
//		if(locationCells.isEmpty())
//		{
//			result="kill";
//		}
		System.out.println(result);
		return result;
	}
}