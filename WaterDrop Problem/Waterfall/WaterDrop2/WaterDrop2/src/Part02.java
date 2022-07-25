import java.util.Arrays;
import java.util.Scanner;

public class Part02 {

	public static void main(String[] args) {
		double inputValue = 100;
        double [] bucketArray = {0,0,0,0,0,0,0};

		int[][] pattern =  {
				{ 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 1, 1, 0, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0, 1 },
	            { 0, 0, 0, 0, 0, 0, 0 },
			};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Position for Water dropping:");
		int position=sc.nextInt() - 1;
		bucketArray[position] = inputValue;
		
		double [] calculatedCurrent=new double []{0,0,0,0,0,0,0};
		double [] tempCalculated=new double [] {0,0,0,0,0,0,0};
		
 	
		double percentage;
		
		for(int i=0; i< pattern.length;i++) {
			for(int j=0;j<bucketArray.length;j++) {
				if(bucketArray[j]>0) {
					percentage=bucketArray[j];
					if(pattern[i][j]==1) {
						//Turn Right
						for(int k=j;k<pattern.length;k++) {
							if(pattern[i][k]==0 && pattern[i-1][j+1]!=1) {
								calculatedCurrent[k]=calculatedCurrent[k]+percentage/2;
								calculatedCurrent[j]=0;
								break;
							}
						}
						//Turn Left
						for(int k=j;k>=0;k--) {
							if(pattern[i][k]==0 && pattern[i-1][j-1]!=1) {
								calculatedCurrent[k]=calculatedCurrent[k]+percentage/2;
								calculatedCurrent[j]=0;
								break;
							}
						}
						calculatedCurrent[j]=0;
					}
					else {
						calculatedCurrent[j]=percentage;
					}
				}
			}
			if(!Arrays.equals(tempCalculated,calculatedCurrent)) {
				bucketArray=calculatedCurrent;
				tempCalculated=calculatedCurrent;
			}
			//bucketArray=calculatedCurrent;
		}
		
		System.out.println("Result:");
        for (double bucket: bucketArray ) {
            System.out.print(bucket+ ", ");
        }
    }
	
	

    
	

}
