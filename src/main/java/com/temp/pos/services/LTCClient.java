package com.temp.pos.services;

import com.temp.pos.models.common.DailyExchRateMdl;
import com.temp.pos.models.common.ExchCardTndr;
import com.temp.pos.models.common.SaveFDMSTenderResultModel;
import com.temp.pos.longterm.models.LTCItemButtonMenuResultsModel;
import com.temp.pos.longterm.models.LTCLocationAssociatesResultsModel;
import com.temp.pos.longterm.models.LTCPOSTicketSplit;
import com.temp.pos.longterm.models.LTCSingleTransactionID;
import com.temp.pos.longterm.models.LTCSingleTransactionResultsModel;
import com.temp.pos.longterm.models.LTCTransactionDetailsModel;
import com.temp.pos.longterm.models.LTCVendorLocationsResultModel;
import com.temp.pos.longterm.models.LocationConfigModel;
import com.temp.pos.longterm.models.SaveTenderResultModel;
import com.temp.pos.longterm.models.SaveTicketResultsModel;
import com.temp.pos.longterm.models.TicketLookupResult;
import com.temp.pos.longterm.models.TicketTender;
import com.temp.pos.longterm.models.VendorContractSummaryResultsModel;
import com.temp.pos.utils.WebApiConstants;
import com.temp.pos.utils.LongTerm.VendorDataCache;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class LTCClient {
    
    private static final Logger logger = LoggerFactory.getLogger(LTCClient.class);
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final VendorDataCache cache;
    HttpHeaders hdr = new HttpHeaders();

    public LTCClient() {
        this.restTemplate = new RestTemplate();;
        this.baseUrl = (WebApiConstants.baseUrl.endsWith("/") ? WebApiConstants.baseUrl : WebApiConstants.baseUrl + "/");
        this.cache = VendorDataCache.getInstance();
        
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        hdr.setContentType(MediaType.APPLICATION_JSON);
        hdr.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        restTemplate.setMessageConverters(messageConverters);
    }

    public LTCItemButtonMenuResultsModel getMenuItem(String uid, int locationUID, int contractUID,
                                                     int facilityUID, int businessFunctionUID, int salesCatUID,
                                                     int departmentUID, int active) {
        String url = baseUrl + "ltc/GetMenuItem";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("pLocationUID", locationUID)
                .queryParam("pContractUID", contractUID)
                .queryParam("pFacilityUID", facilityUID)
                .queryParam("pBusinessFunctionUID", businessFunctionUID)
                .queryParam("pSalesCatUID", salesCatUID)
                .queryParam("pDepartmentUID", departmentUID)
                .queryParam("pActive", active);

        logger.info("Initiating GetMenuItem API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, locationUID={}, contractUID={}, facilityUID={}, businessFunctionUID={}, salesCatUID={}, departmentUID={}, active={}",
                WebApiConstants.getGuid, uid, locationUID, contractUID, facilityUID, businessFunctionUID, salesCatUID, departmentUID, active);

        try {
            ResponseEntity<LTCItemButtonMenuResultsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCItemButtonMenuResultsModel.class
            );
            logger.info("GetMenuItem API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: itemCount={}", response.getBody().getItemButtonMenuResults().size());

            cache.storeMenuItems(response.getBody());
            logger.info("Stored GetMenuItem response in cache");
            

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetMenuItem API: {}", e.getMessage(), e);
            throw new RuntimeException("GetMenuItem API call failed", e);
        }
    }

    public LocationConfigModel getLocationConfigs(int uid, int lid, int dbVal) {
        String url = baseUrl + "ltc/GetLocationConfigs";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("lid", lid)
                .queryParam("DBVal", dbVal);

        logger.info("Initiating GetLocationConfigs API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, lid={}, DBVal={}", WebApiConstants.getGuid, uid, lid, dbVal);

        try {
            ResponseEntity<LocationConfigModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LocationConfigModel.class
            );
            logger.info("GetLocationConfigs API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: success={}", response.getBody().getResults().isSuccess());

            cache.storeLocationConfig(response.getBody());
            logger.info("Stored GetLocationConfigs response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetLocationConfigs API: {}", e.getMessage(), e);
            throw new RuntimeException("GetLocationConfigs API call failed", e);
        }
    }

    public LTCLocationAssociatesResultsModel getLocationAssociates(int lid, String uid, int active) {
        String url = baseUrl + "ltc/GetLocationAssociates";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("lid", lid)
                .queryParam("uid", uid)
                .queryParam("active", active);

        logger.info("Initiating GetLocationAssociates API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, lid={}, uid={}, active={}", WebApiConstants.getGuid, lid, uid, active);

        try {
            ResponseEntity<LTCLocationAssociatesResultsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCLocationAssociatesResultsModel.class
            );
            logger.info("GetLocationAssociates API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: associateCount={}", response.getBody().getAssociates().size());

            cache.storeLocationAssociates(response.getBody());
            logger.info("Stored GetLocationAssociates response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetLocationAssociates API: {}", e.getMessage(), e);
            throw new RuntimeException("GetLocationAssociates API call failed", e);
        }
    }

    public SaveTicketResultsModel saveSplitPayments(String uid, int dbVal, LTCPOSTicketSplit model) {
        String url = baseUrl + "ltc/SaveSplitPayments";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("DBVal", dbVal);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LTCPOSTicketSplit> request = new HttpEntity<>(model, headers);

        logger.info("Initiating SaveSplitPayments API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, DBVal={}, model={}", WebApiConstants.getGuid, uid, dbVal, model);

        try {
            ResponseEntity<SaveTicketResultsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.PUT,
                    request,
                    SaveTicketResultsModel.class
            );
            logger.info("SaveSplitPayments API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: posAuthNumber={}", response.getBody().getPOSAuthNumber());

            cache.storeSaveTicketResults(response.getBody());
            logger.info("Stored SaveSplitPayments response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call SaveSplitPayments API: {}", e.getMessage(), e);
            throw new RuntimeException("SaveSplitPayments API call failed", e);
        }
    }

    public SaveTenderResultModel saveTender(String uid, String appType, boolean fromLinuxTab, TicketTender tender) {
        String url = baseUrl + "ltc/SaveTender";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("appType", appType)
                .queryParam("bFromLinuxTab", fromLinuxTab);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TicketTender> request = new HttpEntity<>(tender, headers);

        logger.info("Initiating SaveTender API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, appType={}, bFromLinuxTab={}, tender={}", WebApiConstants.getGuid, uid, appType, fromLinuxTab, tender);

        try {
            ResponseEntity<SaveTenderResultModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.PUT,
                    request,
                    SaveTenderResultModel.class
            );
            logger.info("SaveTender API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: ticketTenderId={}", response.getBody().getData().getTicketTenderId());

            cache.storeSaveTenderResult(response.getBody());
            logger.info("Stored SaveTender response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call SaveTender API: {}", e.getMessage(), e);
            throw new RuntimeException("SaveTender API call failed", e);
        }
    }

    public SaveFDMSTenderResultModel saveFDMSTender(String uid, String appType, int transactionId, ExchCardTndr fdmsTender) {
        String url = baseUrl + "ltc/SaveFDMSTender";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("appType", appType)
                .queryParam("TransactionId", transactionId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ExchCardTndr> request = new HttpEntity<>(fdmsTender, headers);

        logger.info("Initiating SaveFDMSTender API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, appType={}, transactionId={}, fdmsTender={}", WebApiConstants.getGuid, uid, appType, transactionId, fdmsTender);

        try {
            ResponseEntity<SaveFDMSTenderResultModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.PUT,
                    request,
                    SaveFDMSTenderResultModel.class
            );
            logger.info("SaveFDMSTender API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: ticketTenderId={}", response.getBody().getData().getTicketTenderId());

            cache.storeSaveFDMSTenderResult(response.getBody());
            logger.info("Stored SaveFDMSTender response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call SaveFDMSTender API: {}", e.getMessage(), e);
            throw new RuntimeException("SaveFDMSTender API call failed", e);
        }
    }

    public DailyExchRateMdl getDailyExchRate(int locationId, String busDate, String uid) {
        String url = baseUrl + "ltc/GetDailyExchRate";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("LocationId", locationId)
                .queryParam("BusDate", busDate)
                .queryParam("uid", uid);

        logger.info("Initiating GetDailyExchRate API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, locationId={}, busDate={}, uid={}", WebApiConstants.getGuid, locationId, busDate, uid);

        try {
            ResponseEntity<DailyExchRateMdl> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    DailyExchRateMdl.class
            );
            logger.info("GetDailyExchRate API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: success={}", response.getBody().getResults().isSuccess());

            cache.storeDailyExchRate(response.getBody());
            logger.info("Stored GetDailyExchRate response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetDailyExchRate API: {}", e.getMessage(), e);
            throw new RuntimeException("GetDailyExchRate API call failed", e);
        }
    }

    public DailyExchRateMdl saveDailyExchRate(int locationId, LocalDate busDate, double exchangeRate,
                                              double oneUSDRate, boolean isOneUSD, double oneFCurrRate,
                                              String foreignCurrCode, int cliTimeVar, int uid, int dbVal) {
        String url = baseUrl + "ltc/SaveDailyExchRate";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("LocationId", locationId)
                .queryParam("BusDate", busDate)
                .queryParam("ExchangeRate", exchangeRate)
                .queryParam("OneUSDRate", oneUSDRate)
                .queryParam("IsOneUSD", isOneUSD)
                .queryParam("OneFCurrRate", oneFCurrRate)
                .queryParam("ForeignCurrCode", foreignCurrCode)
                .queryParam("CliTimeVar", cliTimeVar)
                .queryParam("uid", uid)
                .queryParam("DBVal", dbVal);

        logger.info("Initiating SaveDailyExchRate API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, locationId={}, busDate={}, exchangeRate={}, oneUSDRate={}, isOneUSD={}, oneFCurrRate={}, foreignCurrCode={}, cliTimeVar={}, uid={}, DBVal={}",
                WebApiConstants.getGuid, locationId, busDate, exchangeRate, oneUSDRate, isOneUSD, oneFCurrRate, foreignCurrCode, cliTimeVar, uid, dbVal);

        try {
            ResponseEntity<DailyExchRateMdl> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.PUT,
                    null,
                    DailyExchRateMdl.class
            );
            logger.info("SaveDailyExchRate API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: success={}", response.getBody().getResults().isSuccess());

            cache.storeDailyExchRate(response.getBody());
            logger.info("Stored SaveDailyExchRate response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call SaveDailyExchRate API: {}", e.getMessage(), e);
            throw new RuntimeException("SaveDailyExchRate API call failed", e);
        }
    }

    public VendorContractSummaryResultsModel getVendorContractSummary(int cid, int lid, int assocUID,
                                                                     String fNum, String fDt, String tDt, String uid,
                                                                     int dbVal, boolean frgnCurr) {
        String url = baseUrl + "ltc/GetVendorContractSummary";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("cid", cid)
                .queryParam("lid", lid)
                .queryParam("assocUID", assocUID)
                .queryParam("fNum", fNum)
                .queryParam("fDt", fDt)
                .queryParam("tDt", tDt)
                .queryParam("uid", uid)
                .queryParam("DBVal", dbVal)
                .queryParam("FrgnCurr", frgnCurr);

        logger.info("Initiating GetVendorContractSummary API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, cid={}, lid={}, assocUID={}, fNum={}, fDt={}, tDt={}, uid={}, DBVal={}, FrgnCurr={}",
                WebApiConstants.getGuid, cid, lid, assocUID, fNum, fDt, tDt, uid, dbVal, frgnCurr);

        try {
            ResponseEntity<VendorContractSummaryResultsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    VendorContractSummaryResultsModel.class
            );
            logger.info("GetVendorContractSummary API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: headingCount={}, detailsCount={}",
                    response.getBody().getSummary().getHeading().size(),
                    response.getBody().getSummary().getDetails().size());

            cache.storeVendorContractSummary(response.getBody());
            logger.info("Stored GetVendorContractSummary response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetVendorContractSummary API: {}", e.getMessage(), e);
            throw new RuntimeException("GetVendorContractSummary API call failed", e);
        }
    }

    public TicketLookupResult getTicketLookup(int uid, int lid, int ticketNum, String phone,
                                             String fname, String lname) {
        String url = baseUrl + "ltc/GetTicketLookup";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("lid", lid)
                .queryParam("ticketnum", ticketNum)
                .queryParam("phone", phone)
                .queryParam("fname", fname)
                .queryParam("lname", lname);

        logger.info("Initiating GetTicketLookup API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, lid={}, ticketnum={}, phone={}, fname={}, lname={}",
                WebApiConstants.getGuid, uid, lid, ticketNum, phone, fname, lname);

        try {
            ResponseEntity<TicketLookupResult> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    TicketLookupResult.class
            );
            logger.info("GetTicketLookup API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: success={}", response.getBody().getResults().isSuccess());

            cache.storeTicketLookup(response.getBody());
            logger.info("Stored GetTicketLookup response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetTicketLookup API: {}", e.getMessage(), e);
            throw new RuntimeException("GetTicketLookup API call failed", e);
        }
    }

    public LTCTransactionDetailsModel getTransactionDetails(String uid, int transactionID,
                                                            String customerFirstName, String customerLastName,
                                                            String customerPhone, int contractUID, int locationUID,
                                                            int facilityUID, int departmentUID, String source,
                                                            int customerUID) {
        String url = baseUrl + "ltc/GetTransactionDetails";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("pTransactionID", transactionID)
                .queryParam("pCustomerFirstName", customerFirstName)
                .queryParam("pCustomerLastName", customerLastName)
                .queryParam("pCustomerPhone", customerPhone)
                .queryParam("pContractUID", contractUID)
                .queryParam("pLocationUID", locationUID)
                .queryParam("pFacilityUID", facilityUID)
                .queryParam("pDepartmentUID", departmentUID)
                .queryParam("pSource", source)
                .queryParam("pCustomerUID", customerUID);

        logger.info("Initiating GetTransactionDetails API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, transactionID={}, customerFirstName={}, customerLastName={}, customerPhone={}, contractUID={}, locationUID={}, facilityUID={}, departmentUID={}, source={}, customerUID={}",
                WebApiConstants.getGuid, uid, transactionID, customerFirstName, customerLastName, customerPhone, contractUID, locationUID, facilityUID, departmentUID, source, customerUID);

        try {
            ResponseEntity<LTCTransactionDetailsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCTransactionDetailsModel.class
            );
            logger.info("GetTransactionDetails API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: success={}", response.getBody().getResults().isSuccess());

            cache.storeTransactionDetails(response.getBody());
            logger.info("Stored GetTransactionDetails response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetTransactionDetails API: {}", e.getMessage(), e);
            throw new RuntimeException("GetTransactionDetails API call failed", e);
        }
    }

    public LTCSingleTransactionResultsModel getSingleTransaction(String uid, int transactionID,
                                                                boolean isCancelled, int cancelTypeId,
                                                                String cancelOtherRsn, int cliTimeVar, int partPayID) {
        String url = baseUrl + "ltc/GetSingleTransaction";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("uid", uid)
                .queryParam("pTransactionID", transactionID)
                .queryParam("pIsCancelled", isCancelled)
                .queryParam("pCancelTypeId", cancelTypeId)
                .queryParam("pCancelOtherRsn", cancelOtherRsn)
                .queryParam("CliTimeVar", cliTimeVar)
                .queryParam("pPartPayID", partPayID);

        logger.info("Initiating GetSingleTransaction API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, uid={}, transactionID={}, isCancelled={}, cancelTypeId={}, cancelOtherRsn={}, cliTimeVar={}, partPayID={}",
                WebApiConstants.getGuid, uid, transactionID, isCancelled, cancelTypeId, cancelOtherRsn, cliTimeVar, partPayID);

        try {
            ResponseEntity<LTCSingleTransactionResultsModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCSingleTransactionResultsModel.class
            );
            logger.info("GetSingleTransaction API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: ticketId={}", response.getBody().getTicket().getTicketId());

            cache.storeSingleTransaction(response.getBody());
            logger.info("Stored GetSingleTransaction response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetSingleTransaction API: {}", e.getMessage(), e);
            throw new RuntimeException("GetSingleTransaction API call failed", e);
        }
    }

    public LTCSingleTransactionID getTranId(int ticketNum, int locationId) {
        String url = baseUrl + "ltc/GetTranId";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("TicketNum", ticketNum)
                .queryParam("LocationId", locationId);

        logger.info("Initiating GetTranId API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, ticketNum={}, locationId={}", WebApiConstants.getGuid, ticketNum, locationId);

        try {
            ResponseEntity<LTCSingleTransactionID> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCSingleTransactionID.class
            );
            logger.info("GetTranId API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: transactionId={}", response.getBody().getTransactionId());

            cache.storeTranId(response.getBody());
            logger.info("Stored GetTranId response in cache");

            return response.getBody();

        } catch (Exception e) {
            logger.error("Failed to call GetTranId API: {}", e.getMessage(), e);
            throw new RuntimeException("GetTranId API call failed", e);
        }
    }

    public LTCVendorLocationsResultModel getVendorLocations(String vid, String uid, int cliTimeVar) {
        String url = baseUrl + "common/GetVendorLocations";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("guid", WebApiConstants.getGuid)
                .queryParam("vid", vid)
                .queryParam("uid", uid)
                .queryParam("CliTimeVar", cliTimeVar);

        logger.info("Initiating GetVendorLocations API call to {}", builder.toUriString());
        logger.debug("Parameters: guid={}, vid={}, uid={}, cliTimeVar={}", WebApiConstants.getGuid, vid, uid, cliTimeVar);

        try {
            ResponseEntity<LTCVendorLocationsResultModel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    LTCVendorLocationsResultModel.class
            );
            logger.info("GetVendorLocations API call successful, status: {}", response.getStatusCode());
            logger.debug("Response: locationCount={}", response.getBody().getLocations().size());

            cache.storeLocations(response.getBody().getLocations());
            logger.info("Stored GetVendorLocations response in cache");

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to call GetVendorLocations API: {}", e.getMessage(), e);
            throw new RuntimeException("GetVendorLocations API call failed", e);
        }
    }
}