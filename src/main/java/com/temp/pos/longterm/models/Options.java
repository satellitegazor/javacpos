package com.temp.pos.longterm.models;

public class Options {
    public enum LogEventTypes {
        Critical, Exception, Warning, OK, Information
    }

    public enum CardType {
        Visa, MasterCard, Discover, AmericanExpress, MilStar, MilStarRefund, GiftCard
    }

    public enum RegistrationKeys {
        Creds, SharedKey, FldDelim, FldNbr
    }

    public enum AuthorizationKeys {
        Creds, SharedKey, FldDelim, FldNbr
    }

    public enum HTTPAccessType {
        HttpGet, HttpPost, HttpPut, HttpDelete
    }

    public enum ExchangeRegions {
        Headquarters, Central, Eastern, Europe, Pacific, Western, Logistics
    }

    public enum SystemEmailType {
        Exception, Database, Notification
    }

    public enum FeeType {
        Flat, Commission, Undetermined
    }

    public enum StartOrEOD {
        DayStarted, EndOfDay
    }

    public enum ReportRollupLevel {
        Region, Exchange, Vendor, Event, All
    }

    public enum ReturnCodePrefix {
        Success, Warning, Error, Exception
    }

    public enum LoginKeys {
        Creds, SharedKey, FldDelim, FldNbr
    }
}