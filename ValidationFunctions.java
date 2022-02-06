package jl0131;

public class ValidationFunctions {
	
	/*
	 * validateToolCode Function
	 * Checks if the toolCode is valid
	 * @param toolCode - unique identifier for a tool instance
	 * Returns - true or false value based on whether the toolCode is valid
	 */
	public static boolean validateToolCode(String toolCode) {
		if (toolCode.equals(Constants.CHNS_TOOL.TOOL_CODE) || toolCode.equals(Constants.LADW_TOOL.TOOL_CODE)
				|| toolCode.equals(Constants.JAKD_TOOL.TOOL_CODE) || toolCode.equals(Constants.JAKR_TOOL.TOOL_CODE)) {
			return true;
		}	
		else {
			return false;
		}
	}
	
	/*
	 * validateRentalDayCount Function
	 * Checks if the rental day count is greater than 0
	 * @param rentalDayCount - amount of days that a tool will be rented
	 * Returns - true or false value based on whether the rentalDayCount is valid
	 */
	public static boolean validateRentalDayCount(int rentalDayCount) {
		if (rentalDayCount >= 1) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	/*
	 * validateDiscountPercent Function
	 * Checks if the discount percent is within 0 and 100
	 * @param discountPercent - the discounted percentage as a whole number
	 * Returns - true or false value based on whether the discount percent is valid
	 */
	public static boolean validateDiscountPercent(int discountPercent) {
		if (discountPercent >= 0 && discountPercent <= 100) {
			return true;
		}
		else {
			return false;
		}
	}
}
