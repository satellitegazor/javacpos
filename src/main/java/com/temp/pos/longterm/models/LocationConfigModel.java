package com.temp.pos.longterm.models;
import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class LocationConfigModel {
   private MobileBase results;
    private List<LocationConfig> configs;
    private List<LocationIndividual> individuals;
    private List<LTCHoursOfOperation> hoursOfOperations;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<LocationConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<LocationConfig> configs) {
        this.configs = configs;
    }

    public List<LocationIndividual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<LocationIndividual> individuals) {
        this.individuals = individuals;
    }

    public List<LTCHoursOfOperation> getHoursOfOperations() {
        return hoursOfOperations;
    }

    public void setHoursOfOperations(List<LTCHoursOfOperation> hoursOfOperations) {
        this.hoursOfOperations = hoursOfOperations;
    }
}