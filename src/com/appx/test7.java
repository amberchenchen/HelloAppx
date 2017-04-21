package com.appx;

public class test7 {

	public static void main(String[] args) {
		
		int[] price1 = {3,5,10,20,80,70,40,1};
		int[] price2 = {80,70,40,3,2,1};
		getProfit(price1);
		getProfit(price2);

	}
	
	public static void getProfit(int[] price)
	{
		int lowNum = price[0];
		int profit=0;
		for(int i=1;i<price.length;i++)
		{
			int curProfit = price[i]-lowNum;
			if(curProfit>profit){
				profit = curProfit;
			}
						
			if(lowNum>price[i]){
				lowNum = price[i];
			}								
		}
		System.out.println(profit);
	}

}
