import java.util.Scanner;
public class Homework1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] gameRec = new int [10][4];
		int nGame = 0, nBall = 1, total = 0, score = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		for(int i = 0;i<10;i++) {
			for(int j = 0; j<4;j++) {
				gameRec[i][j] = 0;
			}
		}
		
		
		while(nGame<10) { //0<=nGame<=9
			while(nBall<3) { //1<=nBall<=2
				score = scanner.nextInt();
				total += score;
				gameRec[nGame][nBall] = score;
				//System.out.println("nGame = "+nGame+" nBall = "+nBall+" total = "+total);
				if(score == 10) { //strike
					gameRec[nGame][0] = 11; //note for strike
					if(nGame == 9) { //10th frame
						gameRec[9][2] = scanner.nextInt();
						total += gameRec[9][2];
						//System.out.println("nGame = "+nGame+" nBall = "+nBall+" total = "+total);
						gameRec[9][3] = scanner.nextInt();
						total += gameRec[9][3];
						//System.out.println("nGame = "+nGame+" nBall = "+nBall+" total = "+total);
						break;
					}
					break;
				}else if(gameRec[nGame][1]+gameRec[nGame][2] == 10) { //spare
					gameRec[nGame][0] = 12; //note for spare
					if((nGame == 9)&&(gameRec[9][1] + gameRec[9][2]==10)) {
						gameRec[9][3] = scanner.nextInt();
						total += gameRec[9][3];
						//System.out.println("nGame = "+nGame+" nBall = "+nBall+" total = "+total);
						break;
					}
				}else if(gameRec[nGame][1]+gameRec[nGame][2] != 10){ //nothing
					
					gameRec[nGame][0] = 13; //note for nothing
				}
				nBall++;
			}
			
			nBall = 1;
			nGame++;
		}
		
		for(int i = 0; i < 9;i++) {
			if(gameRec[i][0] == 11) { //strike
				if(gameRec[i+1][0] == 11) { // if next ball is strike
					total += gameRec[i+1][1] + gameRec[i+2][1];
				}else{ // if next ball is spare
					total += gameRec[i+1][1] + gameRec[i+1][2];
				}
			}else if(gameRec[i][0] == 12) { //spare
				total += gameRec[i+1][1];
			}
		}
		
		
		System.out.println(total);
		
		

	}

}
