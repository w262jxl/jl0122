package jl0131;

import java.util.Calendar;

public class Checkout {
	
	// Private variables
	private String toolCode;
	private int discountPercent;
	private int rentalDayCount;
	private String checkOutDate;
	private int chargeDays;
	
	// Checkout Constructor
	public Checkout() {
	}
	
	// ToolCode Getter
	public String getToolCode() {
		return toolCode;
	}

	// ToolCode Setter
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	// DiscountPercent Getter
	public int getDiscountPercent() {
		return discountPercent;
	}

	// DiscountPercent Setter
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	// RentalDayCount Getter
	public int getRentalDayCount() {
		return rentalDayCount;
	}

	// RentalDayCount Setter
	public void setRentalDayCount(int rentalDayCount) {
		this.rentalDayCount = rentalDayCount;
	}

	// CheckOutDate Getter
	public String getCheckOutDate() {
		return checkOutDate;
	}

	// CheckOutDate Setter
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	// ChargeDays Getter
	public int getChargeDays() {
		return chargeDays;
	}
	
	//ChargeDays Setter
	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}
	
	// Validating Properties
	public boolean validateProperties() {
		return (ValidationFunctions.validateToolCode(toolCode) &&
				ValidationFunctions.validateRentalDayCount(rentalDayCount) &&
				ValidationFunctions.validateDiscountPercent(discountPercent));
	}
	
	// Generating Rental Agreement
	public void generateRentalAgreement() {
		this.setChargeDays(0);
		printToolInfo();
		printDateInfo();
		printChargeInfo();
	}
	
	// Printing information regarding the tool
	private void printToolInfo() {
		System.out.println("\nTool Code: " + toolCode);
		
		// Switch statement for the various tool codes
		switch(toolCode) {
		case Constants.CHNS_TOOL.TOOL_CODE:
			System.out.println("Tool Type: " + Constants.CHNS_TOOL.TOOL_TYPE);
			System.out.println("Tool Brand: " + Constants.CHNS_TOOL.BRAND);
			break;
		case Constants.LADW_TOOL.TOOL_CODE:
			System.out.println("Tool Type: " + Constants.LADW_TOOL.TOOL_TYPE);
			System.out.println("Tool Brand: " + Constants.LADW_TOOL.BRAND);
			break;
		case Constants.JAKD_TOOL.TOOL_CODE:
			System.out.println("Tool Type: " + Constants.JAKD_TOOL.TOOL_TYPE);
			System.out.println("Tool Brand: " + Constants.JAKD_TOOL.BRAND);
			break;
		case Constants.JAKR_TOOL.TOOL_CODE:
			System.out.println("Tool Type: " + Constants.JAKR_TOOL.TOOL_TYPE);
			System.out.println("Tool Brand: " + Constants.JAKR_TOOL.BRAND);
			break;
		}
	}
	
	// Printing information regarding the dates
	private void printDateInfo() {
		System.out.println("Rental Days: " + rentalDayCount);
		try {
			String[] dateArray = splitDateFromInput();
			Calendar calendar = Calendar.getInstance();
			System.out.println("Check out Date: " + formatDateOutput(dateArray[1], dateArray[0], dateArray[2]));
			calendar.clear();
			calendar.set(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]));
			
			boolean chargableDay;
			String toolType = getToolType();
			
			// For loop to increment each day - will check for weekend and holiday charges
			for(int i = 0; i < rentalDayCount; i++) {
				chargableDay = true;
				calendar.add(Calendar.DATE, 1);
				
				// Checks for weekend charges if applicable
				if (toolType == Constants.CHNS_TOOL.TOOL_TYPE || toolType == Constants.JAKD_TOOL.TOOL_TYPE) {
					if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
						chargableDay = false;
					}
				}
				
				// Checks for holiday charges if applicable
				if ((toolType == Constants.LADW_TOOL.TOOL_TYPE || toolType == Constants.JAKD_TOOL.TOOL_TYPE) && chargableDay == true) {
					if (calendar.get(Calendar.MONTH) == 9 && calendar.get(Calendar.DAY_OF_MONTH) < 8 
							&& calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
						chargableDay = false;
					}
					if (calendar.get(Calendar.MONTH) == 7) {
						chargableDay = checkForIndependenceDayHoliday(calendar);
					}
				}
				
				// Increment chargable days
				if (chargableDay) {
					this.setChargeDays(this.getChargeDays() + 1);
				}
			}
			
			System.out.println("Due Date: " + formatDateOutput(String.valueOf(calendar.get(Calendar.DATE)), 
					String.valueOf(calendar.get(Calendar.MONTH)), String.valueOf(calendar.get(Calendar.YEAR))));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Formats the date for output
	private String formatDateOutput(String day, String month, String year) {
		if (day.length() == 1) {
			day = "0" + day;
		}
		if (month.length() == 1) {
			month = "0" + month;
		}
		return month + "/" + day + "/" + year;
	}
	
	// Splits the date to differentiate between year, month, and day
	private String[] splitDateFromInput() {
		return checkOutDate.split("/");
	}
	
	// Returns the tool type from the given tool code
	private String getToolType() {
		if (toolCode == Constants.CHNS_TOOL.TOOL_CODE) {
			return Constants.CHNS_TOOL.TOOL_TYPE;
		} 
		else if (toolCode == Constants.LADW_TOOL.TOOL_CODE) {
			return Constants.LADW_TOOL.TOOL_TYPE;
		}
		else if (toolCode == Constants.JAKD_TOOL.TOOL_CODE) {
			return Constants.JAKD_TOOL.TOOL_TYPE;
		}
		else {
			return Constants.JAKR_TOOL.TOOL_TYPE;
		}
	}
	
	// Checks for the Independence Day Holiday
	private boolean checkForIndependenceDayHoliday(Calendar calendar) {
		if (calendar.get(Calendar.DATE) == 4 && (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY 
				&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
			return false;
		}
		else if (calendar.get(Calendar.DATE) == 3 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			return false;
		}
		else if (calendar.get(Calendar.DATE) == 5 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Prints information regarding charges
	private void printChargeInfo() {
		String toolType = getToolType();
		double dailyCharge;
		if (toolType == Constants.CHNS_TOOL.TOOL_TYPE) {
			System.out.println("Daily rental charge: $" + String.valueOf(Constants.CHAINSAW_CHARGE.DAILY_CHARGE));
			dailyCharge = Constants.CHAINSAW_CHARGE.DAILY_CHARGE;
		}
		else if (toolType == Constants.LADW_TOOL.TOOL_TYPE) {
			System.out.println("Daily rental charge: $" + String.valueOf(Constants.LADDER_CHARGE.DAILY_CHARGE));
			dailyCharge = Constants.LADDER_CHARGE.DAILY_CHARGE;
		}
		else {
			System.out.println("Daily rental charge: $" + String.valueOf(Constants.JACKHAMMER_CHARGE.DAILY_CHARGE));
			dailyCharge = Constants.JACKHAMMER_CHARGE.DAILY_CHARGE;
		}
		System.out.println("Charge days: " + String.valueOf(this.getChargeDays()));
		double preDiscountCharge = calculatePreDiscountCharge(dailyCharge);
		System.out.println("Pre-discount charge: " + String.valueOf(preDiscountCharge));
		System.out.println("Discount percent: " + this.getDiscountPercent() + "%");
		double discountAmount = calculateDiscountAmount(preDiscountCharge);
		System.out.println("Discount amount: " + String.valueOf(discountAmount));
		System.out.println("Final charge: " + String.valueOf(calculateFinalCharge(preDiscountCharge, discountAmount)));
	}
	
	// Calculates the pre-discounted charge
	private double calculatePreDiscountCharge(double dailyCharge) {
		double preDiscountCharge = dailyCharge * this.getChargeDays();
		return Math.round(preDiscountCharge * 100.0) / 100.0;
	}
	
	// Calculates the discounted amount
	private double calculateDiscountAmount(double preDiscountCharge) {
		double discountAmount = preDiscountCharge * (this.discountPercent / 100.0);
		return Math.round(discountAmount * 100.0) / 100.0;
	}
	
	// Calculates the final charge
	private double calculateFinalCharge(double preDiscountCharge, double discountAmount) {
		return Math.round((preDiscountCharge - discountAmount) * 100.0) / 100.0;
	}
}
