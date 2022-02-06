package jl0131;


// Constants class - Contains all the constants for the project
public class Constants {
	
	// CHNS_TOOL class - Contains constants regarding the CHNS tool
	public final class CHNS_TOOL {
		public static final String TOOL_CODE = "CHNS";
		public static final String TOOL_TYPE = "Chainsaw";
		public static final String BRAND = "Stihl";
	}
	
	// LADW_TOOL class - Contains constants regarding the LADW tool
	public final class LADW_TOOL {
		public static final String TOOL_CODE = "LADW";
		public static final String TOOL_TYPE = "Ladder";
		public static final String BRAND = "Werner";
	}
	
	// JAKD_TOOL class - Contains constants regarding the JAKD tool
	public final class JAKD_TOOL {
		public static final String TOOL_CODE = "JAKD";
		public static final String TOOL_TYPE = "JackHammer";
		public static final String BRAND = "DeWalt";
	}
	
	// JAKR_TOOL class - Contains constants regarding the JAKR tool
	public final class JAKR_TOOL {
		public static final String TOOL_CODE = "JAKR";
		public static final String TOOL_TYPE = "JackHammer";
		public static final String BRAND = "Ridgid";
	}
	
	// LADDER_CHARGE class - Contains constants regarding ladder pricing
	public final class LADDER_CHARGE {
		public static final double DAILY_CHARGE = 1.99;
		public static final boolean WEEKDAY_CHARGE = true;
		public static final boolean WEEKEND_CHARGE = true;
		public static final boolean HOLIDAY_CHARGE = false;
	}
	
	// CHAINSAW_CHARGE class - Contains constants regarding chainsaw pricing
	public final class CHAINSAW_CHARGE {
		public static final double DAILY_CHARGE = 1.49;
		public static final boolean WEEKDAY_CHARGE = true;
		public static final boolean WEEKEND_CHARGE = false;
		public static final boolean HOLIDAY_CHARGE = true;
	}
	
	// JACKHAMMER_CHARGE class - Contains constants regarding jackhammer pricing
	public final class JACKHAMMER_CHARGE {
		public static final double DAILY_CHARGE = 2.99;
		public static final boolean WEEKDAY_CHARGE = true;
		public static final boolean WEEKEND_CHARGE = false;
		public static final boolean HOLIDAY_CHARGE = false;
	}
}
