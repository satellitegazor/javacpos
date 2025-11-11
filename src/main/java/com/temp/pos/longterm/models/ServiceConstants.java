package com.temp.pos.longterm.models;

public class ServiceConstants {
    public static class Lengths {
        public static final int REGION_ID_L = 2;
        public static final int EXCH_ID_LONG_L = 10;
        public static final int EXCH_ID_SHORT_L = 4;
    }

    public static class Misc {
        public static final String BI_MAIN_EXCH_SUFFIX = "9999";
        public static final int STARTING_EARN_REV_DATA_DATE_MONTH = 2;
        public static final int STARTING_EARN_REV_DATA_DATE_DAY = 1;
        public static final int EARNINGS_INDEX = 0;
        public static final int REVENUE_INDEX = 1;
        public static final int MILSTAR_USERS_INDEX = 0;
        public static final int DIVIDENDS_INDEX = 0;
        public static final int PHONE_NUMBER_LENGTH = 10;
    }

    public static class Directories {
        public static final String EXTERNALS = "~/App_Data";
    }

    public static class Files {
        public static final String EARNINGS_REVENUE_FILENAME = "Daily_NetEarn_TotRev.txt";
        public static final String MILSTAR_USERS_FILENAME = "MilStarAccounts.txt";
        public static final String DIVIDENDS_FILENAME = "Dividends.txt";

        public static final String VENDORS_FILENAME = "Vendors.json";
        public static final String VENDOR_EVENTS_FILENAME = "VendorEvents.json";
        public static final String ASSOCIATE_EXCHANGE_FILENAME = "AssocExch.json";
    }

    public static class Configuration {
        public static final String FMF_REFRESH_JOB = "FMF_REFRESH_JOB";
        public static final String FMF_REFRESH_JOB_LAST_RUN = "FMF_REFRJOB_LASTRUN";
    }
}