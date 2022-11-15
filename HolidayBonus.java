public class HolidayBonus {
	
	
	public static double[] calculateHolidayBonus(double[][] arr1, double high, double low, double other) {
		
	
		double[] bonus = new double[arr1.length]; 
		
		
		
		
		int highestIndex; 
		int lowestIndex; 
		
		
		for (int col = 0; col < 10; col++) {
			highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, col); 
			lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, col); 
			
		
			if (highestIndex != -1 && arr1[highestIndex][col] > 0)
				bonus[highestIndex] += high; 
			
			if (lowestIndex != -1 && arr1[lowestIndex][col] > 0 && highestIndex != lowestIndex)
				bonus[lowestIndex] += low; 
			
			for (int count = 0; count < bonus.length; count++) {
				if(count != highestIndex && count != lowestIndex && col < arr1[count].length) {
					
					
					if (arr1[count][col] > 0)
						bonus[count] += other; 
				}
			}
		}
		
		
		return bonus; 
		
	}
	
	public static double calculateTotalHolidayBonus(double[][] arr1, double highest, double lowest, double num) {
		double[] bonus; 
		bonus = calculateHolidayBonus(arr1, highest, lowest, num); 
		
		double total = 0; 
		for (int count = 0; count < bonus.length; count++) {
			total += bonus[count];
		}
		return total; 
	}
}