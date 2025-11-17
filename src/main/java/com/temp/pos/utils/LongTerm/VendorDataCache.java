package com.temp.pos.utils.LongTerm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.temp.pos.longterm.models.*;
import com.temp.pos.models.common.DailyExchRateMdl;
import com.temp.pos.models.common.SaveFDMSTenderResultModel;
import com.temp.pos.models.longterm.LocationConfig;

public class VendorDataCache {

    // Singleton instance
    private static final VendorDataCache INSTANCE = new VendorDataCache();

    // Thread-safe storage for VendorLoginResultsModel (keyed by individualUID)
    private final Map<String, VendorLoginResultsModel> loginResultsCache = new ConcurrentHashMap<>();

    // Thread-safe storage for LTCAbbrLocationModel (list of locations)
    private final List<LTCAbbrLocationModel> locationsCache = new ArrayList<>();
    private final Object locationsLock = new Object(); // For thread-safe list operations
    private final Map<String, LTCItemButtonMenuResultsModel> menuItemsCache = new ConcurrentHashMap<>();
    private final Map<String, LocationConfigModel> locationConfigCache = new ConcurrentHashMap<>();
    private final Map<String, LTCLocationAssociatesResultsModel> locationAssociatesCache = new ConcurrentHashMap<>();
    private final Map<String, SaveTicketResultsModel> saveTicketResultsCache = new ConcurrentHashMap<>();
    private final Map<String, SaveTenderResultModel> saveTenderResultCache = new ConcurrentHashMap<>();
    private final Map<String, SaveFDMSTenderResultModel> saveFDMSTenderResultCache = new ConcurrentHashMap<>();
    private final Map<String, DailyExchRateMdl> dailyExchRateCache = new ConcurrentHashMap<>();
    private final Map<String, VendorContractSummaryResultsModel> vendorContractSummaryCache = new ConcurrentHashMap<>();
    private final Map<String, TicketLookupResult> ticketLookupCache = new ConcurrentHashMap<>();
    private final Map<String, LTCTransactionDetailsModel> transactionDetailsCache = new ConcurrentHashMap<>();
    private final Map<String, LTCSingleTransactionResultsModel> singleTransactionCache = new ConcurrentHashMap<>();
    private final Map<String, LTCSingleTransactionID> tranIdCache = new ConcurrentHashMap<>();
    private final Map<Integer, LTCLocationAssociate> locationAssoc = new ConcurrentHashMap<Integer, LTCLocationAssociate>();
    private LocationConfig locationConfig;
    private final Map<Integer, String> LTBusinessModelMap = new HashMap<Integer, String>() {{
        put(1,	"BUSFNC_ALT");
        put(2,	"BUSFNC_LNDRYCLN");
        put(3,	"BUSFNC_LNDRYCLN_WALT");
        put(4,	"BUSFNC_CASH_CARRY");
        put(5,	"BUSFNC_REPIR_CNTR");
        put(6,	"BUSFNC_PHOTO_STDIO");
        put(7,	"BUSFNC_AUTO_ENHNC");
        put(8,	"BUSFNC_SPCLT_SHOP");
        put(9,	"BUSFNC_PSVCS_W_TIPS");
        put(10,	"BUSFNC_NONAME_BRAND_FS");
    }};
    // Private constructor to prevent instantiation
    private VendorDataCache() {
    }

    // Get singleton instance
    public static VendorDataCache getInstance() {
        return INSTANCE;
    }

    // Store VendorLoginResultsModel
    public void storeLoginResult(VendorLoginResultsModel result) {
        if (result != null && result.getIndividualUID() != 0) {
            loginResultsCache.put(String.valueOf(result.getIndividualUID()), result);
        }
    }

    // Retrieve VendorLoginResultsModel by individualUID
    public VendorLoginResultsModel getLoginResult(String individualUID) {
        return loginResultsCache.get(individualUID);
    }

    // Store list of LTCAbbrLocationModel
    public void storeLocations(List<LTCAbbrLocationModel> locations) {
        if (locations != null) {
            synchronized (locationsLock) {
                locationsCache.clear(); // Clear existing data
                locationsCache.addAll(locations);
            }
        }
    }

    // Retrieve all locations
    public List<LTCAbbrLocationModel> getLocations() {
        synchronized (locationsLock) {
            return new ArrayList<>(locationsCache); // Return a copy to prevent external modification
        }
    }


    public void storeMenuItems(LTCItemButtonMenuResultsModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            menuItemsCache.put(result.getResults().getUserId(), result);
        }
    }

    public LTCItemButtonMenuResultsModel getMenuItems(String userId) {
        return menuItemsCache.get(userId);
    }

    public void storeLocationConfig(LocationConfigModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            locationConfigCache.put(result.getResults().getUserId(), result);
        }
        locationConfig = result.getConfigs().get(0);
    }

    public LocationConfigModel getLocationConfig(String userId) {
        return locationConfigCache.get(userId);
    }

    public LocationConfig getLocationConfig() {
        return locationConfig;
    }

    public void storeLocationAssociates(LTCLocationAssociatesResultsModel result) {
        result.getAssociates().forEach(k -> {
            locationAssoc.put(k.getAssociateId(), k);
        });
    }

    public LTCLocationAssociate getLocationAssociates(int userId) {
        return locationAssoc.get(userId);
    }

    public void storeSaveTicketResults(SaveTicketResultsModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            saveTicketResultsCache.put(result.getResults().getUserId(), result);
        }
    }

    public SaveTicketResultsModel getSaveTicketResults(String userId) {
        return saveTicketResultsCache.get(userId);
    }

    public void storeSaveTenderResult(SaveTenderResultModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            saveTenderResultCache.put(result.getResults().getUserId(), result);
        }
    }

    public SaveTenderResultModel getSaveTenderResult(String userId) {
        return saveTenderResultCache.get(userId);
    }

    public void storeSaveFDMSTenderResult(SaveFDMSTenderResultModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            saveFDMSTenderResultCache.put(result.getResults().getUserId(), result);
        }
    }

    public SaveFDMSTenderResultModel getSaveFDMSTenderResult(String userId) {
        return saveFDMSTenderResultCache.get(userId);
    }

    public void storeDailyExchRate(DailyExchRateMdl result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            dailyExchRateCache.put(result.getResults().getUserId(), result);
        }
    }

    public DailyExchRateMdl getDailyExchRate(String userId) {
        return dailyExchRateCache.get(userId);
    }

    public void storeVendorContractSummary(VendorContractSummaryResultsModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            vendorContractSummaryCache.put(result.getResults().getUserId(), result);
        }
    }

    public VendorContractSummaryResultsModel getVendorContractSummary(String userId) {
        return vendorContractSummaryCache.get(userId);
    }

    public void storeTicketLookup(TicketLookupResult result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            ticketLookupCache.put(result.getResults().getUserId(), result);
        }
    }

    public TicketLookupResult getTicketLookup(String userId) {
        return ticketLookupCache.get(userId);
    }

    public void storeTransactionDetails(LTCTransactionDetailsModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            transactionDetailsCache.put(result.getResults().getUserId(), result);
        }
    }

    public LTCTransactionDetailsModel getTransactionDetails(String userId) {
        return transactionDetailsCache.get(userId);
    }

    public void storeSingleTransaction(LTCSingleTransactionResultsModel result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            singleTransactionCache.put(result.getResults().getUserId(), result);
        }
    }

    public LTCSingleTransactionResultsModel getSingleTransaction(String userId) {
        return singleTransactionCache.get(userId);
    }

    public void storeTranId(LTCSingleTransactionID result) {
        if (result != null && result.getResults() != null && result.getResults().getUserId() != null) {
            tranIdCache.put(result.getResults().getUserId(), result);
        }
    }

    public LTCSingleTransactionID getTranId(String userId) {
        return tranIdCache.get(userId);
    }

    public void clear() {
        loginResultsCache.clear();
        synchronized (locationsLock) {
            locationsCache.clear();
        }
        menuItemsCache.clear();
        locationConfigCache.clear();
        locationAssociatesCache.clear();
        saveTicketResultsCache.clear();
        saveTenderResultCache.clear();
        saveFDMSTenderResultCache.clear();
        dailyExchRateCache.clear();
        vendorContractSummaryCache.clear();
        ticketLookupCache.clear();
        transactionDetailsCache.clear();
        singleTransactionCache.clear();
        tranIdCache.clear();
    }
}






























//Written by Krishanu Tandle