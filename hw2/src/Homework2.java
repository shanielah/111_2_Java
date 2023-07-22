import java.util.Scanner;
public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int startIndex = 1, sum = 0;
		boolean jump = false;
		if((n>0)&&(n<1000000000)) { //correct input
			
			int[] arr = new int [n];
			while(startIndex<((n+1)/2)) {			
				for(int i = 0; jump == false; i++) {
					arr[i] = startIndex+i;
					sum+=startIndex+i;
					if(sum == n) {
						for(int j=0;j<i;j++) {
							System.out.print(arr[j]+"+");
						}
						System.out.println(arr[i]);
					}else if(sum>n){
						jump = true;
					}
				}
				
				startIndex++;
				sum = 0;
				jump = false;
				
			}
			System.out.println(n); //print n itself
		}else { //incorrect input
			System.out.println("E");
		}
	}
}
