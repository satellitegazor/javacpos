package com.temp.pos.models.longterm;

public class CommonConstants {
    public static final int ZIP_LEN = 9;

    public static class Misc {
        public static final String HTML_BODY_TAG = "{@HTML_BODY}";
    }

    public static class RegularExpressions {
        public static final String HTTP_URL = "^(http|https)\\://[a-zA-Z0-9\\-\\.]\\+\\.[a-zA-Z]{2,3}(/\\S*)?$";
        public static final String USERNAME = "^\\w\\w{0,9}$";
        public static final String ALPHANUMERIC = "^[A-Za-z0-9]*$";
        public static final String ALPHANUMERICUNDERSCORE = "^[A-Z0-9_]{1,}$";
        public static final String USINTLPHONENUMBER = "^[+]?([0-9]*[\\.\\s\\-\\(\\)]|[0-9]+){3,24}$";
        public static final String EMAILADDRESS = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        public static final String EMAILADDRESSES = "(([a-zA-Z0-9_\\-\\.] +)@ ((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)(\\s*;\\s*|\\s*$))*";
        public static final String CURRENCY = "^\\$?\\d+(\\.(\\d{2}))?$";
        public static final String ZIPCODE = "^\\d{5}$|^\\d{5}-\\d{4}$|^\\d{9}$";
        public static final String INFORMALCASENUMBER = "^I\\-{1}\\d{4}(\\-{1}\\d{4})?$";
        public static final String DATE = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        public static final String ONE_BAR = "^..\\|{1}..$";
        public static final String REFERENCE_DESCRIPTION = "^[A-Za-z0-9\\-_\\,\\.\\;\\: \\/]*$";
        public static final String NAME_OR_EMPTY = "^[A-Za-z\\'\\- ]*?$";
        public static final String EEOC_NUMBER = "^[A-Za-z0-9\\-\\_]*$";
    }
}