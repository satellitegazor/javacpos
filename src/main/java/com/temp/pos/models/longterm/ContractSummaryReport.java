package com.temp.pos.models.longterm;

import java.util.List;

public class ContractSummaryReport {
      private List<ContractSummaryGrouped> heading;
    private List<ContractTransactionDetail> details;

    public List<ContractSummaryGrouped> getHeading() {
        return heading;
    }

    public void setHeading(List<ContractSummaryGrouped> heading) {
        this.heading = heading;
    }

    public List<ContractTransactionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ContractTransactionDetail> details) {
        this.details = details;
    }
}
