import java.util.Scanner;

public class Homework4
{
	public static int cardValueCalling(String s)
	{
		int value = 0;
		if(s.length() == 2)
		{
			value += (s.charAt(0)-'0') * 100;
			value += Math.abs(s.charAt(1)-'D');
		}
		else if(s.length() == 3)
		{
			value += (s.charAt(1)-'0'+10) * 100;
			value += Math.abs(s.charAt(2)-'D');
		}
		
		return value;
	}
	
	public static boolean cardCompare(String card1, String card2, char bestSuit, char thisRoundSuit)
	{
		if(card2.equals("xxx"))
		{
			return true;
		}
		
		char suit1 = 'x';
		int value1 = 0;
		
		char suit2 = 'x';
		int value2 = 0;
		
		if(card1.length() == 2)
		{
			suit1 = card1.charAt(1);
			value1 = card1.charAt(0)-'0';
			if(value1 == 1)
			{
				value1 = 14;
			}
		}
		else if(card1.length() == 3)
		{
			suit1 = card1.charAt(2);
			value1 = card1.charAt(1)-'0'+10;
		}
		
		if(card2.length() == 2)
		{
			suit2 = card2.charAt(1);
			value2 = card2.charAt(0)-'0';
			if(value2 == 1)
			{
				value2 = 14;
			}
		}
		else if(card2.length() == 3)
		{
			suit2 = card2.charAt(2);
			value2 = card2.charAt(1)-'0'+10;
		}
		
		
		if(suit1 == bestSuit && suit2 == bestSuit)
		{
			if(value1 > value2)
			{
				return true;
			}
			return false;
		}
		else if(suit1 != bestSuit && suit2 == bestSuit)
		{
			return false;
		}
		else if(suit1 == bestSuit && suit2 != bestSuit)
		{
			return true;
		}
		else if(suit1 != bestSuit && suit2 != bestSuit)
		{
			if(suit1 == thisRoundSuit && suit2 == thisRoundSuit)
			{
				if(value1 > value2)
				{
					return true;
				}
				return false;
			}
			else if(suit1 != thisRoundSuit && suit2 == thisRoundSuit)
			{
				return false;
			}
			else if(suit1 == thisRoundSuit && suit2 != thisRoundSuit)
			{
				return true;
			}
			else if(suit1 != thisRoundSuit && suit2 != thisRoundSuit)
			{
				if(value1 > value2)
				{
					return true;
				}
				return false;
			}
		}
		
		return true;
		
	}
	 
	public static void main(String[] argv)
	{
		Scanner scanner = new Scanner(System.in);
		String[][] cards = new String[4][13];
		int[] ans = new int[4];
		
		boolean error = false;
		
		for(int i  = 0; i < 4; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				cards[i][j] = scanner.next();
			}
		}
		
		int callingTurn = -1; //���֥h�۵P
		int choosePlayer = 0; //�������H�O��
		int passCount = 0;
		String lastCard = "0D";
		
		while(true)
		{
			callingTurn = (callingTurn+1) % 4;
			
			String s;
			s = scanner.next();
			
			if(s.equals("pass"))
			{
				passCount++;
				if(passCount == 3)
				{
					break;
				}
			}
			else
			{
				if(cardValueCalling(s) <= cardValueCalling(lastCard)) //error
				{
					error = true;
					break;
				}
				
				choosePlayer = callingTurn;
				lastCard = new String(s); //�إ߷s����
				passCount = 0;
			}

		}
		
		char bestSuit = 'x'; //���P���
		if(lastCard.length() == 2)
		{
			bestSuit = lastCard.charAt(1);
		}
		else if(lastCard.length() == 3)
		{
			bestSuit = lastCard.charAt(2);
		}
		
		
		if(error == false)
		{
			choosePlayer = (choosePlayer+1) % 4;
			
			for(int i = 0; i < 3; i++)
			{
				if(error == true)
				{
					break;
				}
				
				String[] thisRoundCard = new String[4];
				int[] playerNumber = new int[4];
				char thisRoundSuit = 'x';
				
				for(int j = 0; j < 4; j++)
				{
					thisRoundCard[j] = scanner.next();
					playerNumber[j] = (choosePlayer+j)%4;
				}
				
				if(thisRoundCard[0].length() == 2)
				{
					thisRoundSuit = thisRoundCard[0].charAt(1);
				}
				else if(thisRoundCard[0].length() == 3)
				{
					thisRoundSuit = thisRoundCard[0].charAt(2);
				}
				
				int win = 0; //�����
				String largestCard = "xxx";
				
				for(int j = 0; j < 4; j++)
				{	
					//�ˬd���a�O�_��[�ӽ����]�H�άO�_��[�o�i�P]
					boolean haveCard = false;
					boolean haveSuit = false;
					int cardIndex = 0;
					for(int k = 0; k < 13; k++)
					{
						if(cards[playerNumber[j]][k].equals(thisRoundCard[j]))
						{
							cardIndex = k;
							haveCard = true;
						}
						
						char cardSuit = 'x';
						
						if(cards[playerNumber[j]][k].length() == 2)
						{
							cardSuit = cards[playerNumber[j]][k].charAt(1);
						}
						else if(cards[playerNumber[j]][k].length() == 3)
						{
							cardSuit = cards[playerNumber[j]][k].charAt(2);
						}
						
						if(cardSuit == thisRoundSuit)
						{
							haveSuit = true;
						}
					}
					
					if(haveCard == false)
					{
						error = true;
						break;
					}
					
					if(haveSuit == true)//�p�G���o�����A���X�����O�o�Ӫ��
					{
						if(thisRoundCard[j].length() == 2)
						{
							if(thisRoundCard[j].charAt(1) != thisRoundSuit)
							{
								error = true;
								break;
							}
						}
						else if(thisRoundCard[j].length() == 3)
						{
							if(thisRoundCard[j].charAt(2) != thisRoundSuit)
							{
								error = true;
								break;
							}
						}
					}
					
					//�Q���D�֤���j
					
					if(cardCompare(thisRoundCard[j], largestCard, bestSuit, thisRoundSuit) == true)
					{
						win = playerNumber[j];
						largestCard = new String(thisRoundCard[j]);
					}

					cards[playerNumber[j]][cardIndex] = new String("xxxxx");

				}
				
				ans[win]++;
				choosePlayer = win;
			}
		}
		
		if(error == true)
		{
			while(scanner.hasNextLine())
			{
				String s = scanner.nextLine();
			}
			System.out.print("ERROR");
		}
		else
		{
			for(int i = 0; i < 4; i++)
			{
				System.out.println(ans[i]);
			}
		}
		
		
	}
	
}





