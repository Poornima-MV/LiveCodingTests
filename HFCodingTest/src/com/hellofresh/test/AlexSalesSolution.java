package com.hellofresh.test;
import java.util.*;

/**
 * Submitted solution
 * @author Poornima Vadakeyil
 *
 */
public class AlexSalesSolution {
	
	public static void main(String[] customerBillInput) {
		
		
		System.out.println("Alex can serve ---"+ salesDecision(customerBillInput));
	}

	private static Boolean salesDecision(String[] customerBillInput) {
		
		Boolean canSell = true;
		
		ArrayList<Integer> billList = new ArrayList<Integer>();
		Arrays.stream(customerBillInput).forEach( x -> billList.add(Integer.parseInt(x)) );
		
		/**billList.add(5);
		billList.add(5);
		billList.add(10);
		
		billList.add(20);
		billList.add(50);
		billList.add(10);
		billList.add(20);
		billList.add(10);
		billList.add(5);
		billList.add(10);*/
		Integer amountRecieved =0;
		
		for(int i=0 ; i<billList.size(); i++) {
			Integer payBack=0;
			if(billList.get(i)/5!=1) {
				if(amountRecieved==0) {
					canSell=false;
					break;
				}else {
					payBack = ((billList.get(i)/5)-1)*5;
					if(amountRecieved < payBack) {
						
							canSell=false;
							break;
						
						
					}
				}
				amountRecieved = (amountRecieved+billList.get(i))-payBack;
			}else {
				amountRecieved = (amountRecieved+billList.get(i));
			}
		}
		
		return canSell;
	}

}
