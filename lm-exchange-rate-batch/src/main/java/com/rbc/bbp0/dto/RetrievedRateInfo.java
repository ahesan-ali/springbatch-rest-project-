package com.rbc.bbp0.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RetrievedRateInfo {
    @JsonProperty("RbcSellFwdRateFormat")
    public int rbcSellFwdRateFormat;
    @JsonProperty("CapMktBuyFwdRate")
    public int capMktBuyFwdRate;
    @JsonProperty("ContractEffDate")
    public int contractEffDate;
    @JsonProperty("CapMktSellFwdRate")
    public int capMktSellFwdRate;
    @JsonProperty("LinkUpdDate")
    public int linkUpdDate;
    @JsonProperty("RetrievedRateEffDate")
    public int RetrievedRateEffDate;
    @JsonProperty("FwdRateEntryTime")
    public int fwdRateEntryTime;
    @JsonProperty("OptionDate")
    public int optionDate;
    @JsonProperty("CapMktSellRateSatus")
    public String capMktSellRateSatus;
    @JsonProperty("FwdStaleTimestamp")
    public FwdStaleTimestamp fwdStaleTimestamp;
    @JsonProperty("RBCBuyFwdRateStatus")
    public String rbcBuyFwdRateStatus;
    @JsonProperty("FwdValueMatureDate")
    public int FwdValueMatureDate;
    @JsonProperty("FwdOptionDate")
    public int FwdOptionDate;
    @JsonProperty("RBCSellRate")
    public Double rbcSellRate;
    @JsonProperty("CapMktBUyRateFormat")
    public int capMktBuyRateFormat;
    @JsonProperty("CapMktSellFwdRateFormat")
    public int capMktSellFwdRateFormat;
    @JsonProperty("FwdContractEffDate")
    public int fwdContractEffDate;
    @JsonProperty("RBCSellRateFormat")
    public int rbcSellRateFormat;
    @JsonProperty("FwdRateEntryDate")
    public int fwdRateEntryDate;
    @JsonProperty ("CapMktSellRate")
    public int capMktSellrate;
    @JsonProperty("RBCSellFwdRate")
    public int rbcSellFwdRate;
    @JsonProperty ("PVRRateKey")
    public String pvrRateKey;
    @JsonProperty ("CapMktBUyRate")
    public int capMktBuyRate;
    @JsonProperty ("RBCBuyRate")
    public Double rbcBuyRate;
    @JsonProperty ("RateEntryDate")
    public int rateEntryDate;
    @JsonProperty ("StaleTimestamp")
    public StaleTimestamp staleTimestamp;
    @JsonProperty ("ReciprocalFlag")
    public String reciprocalFlag;
    @JsonProperty("CapMktSellRateFormat")
    public int capMktSellRateFormat;
    @JsonProperty("FwdAdjType")
    public String fwdAdjType;
    @JsonProperty("LinkUpdTime")
    public int linkUpdTime;
    @JsonProperty("LinkStatus")
    public String linkStatus;
    @JsonProperty ("RbcBuyFwdRateFormat")
    public int rbcBuyFwdRateFormat;
    @JsonProperty ("RateLastUpdTimestamp")
    public RateLastUpdTimestamp rateLastUpdTimestamp;
    @JsonProperty("ValueMatureDate")
    public int valueMatureDate;
    @JsonProperty("RbcSellRateStatus")
    public String rbcSellRateStatus;
    @JsonProperty("CapMktBuyRateStatus")
    public String capMktBuyRateStatus;
    @JsonProperty("RbcBuyRateStatus")
    public String rbcBuyRateStatus;
    @JsonProperty("CapMktBuyFwdRateStatus")
    public String capMktBuFwdRateStatus;
    @JsonProperty("RbcBuyFwdRate")
    public int rbcBuyFwdRate;
    @JsonProperty("FwdRateLastUpdTimestamp")
    public FwdRateLastUpdTimestamp fwdRateLastUpdTimestamp;
    @JsonProperty("RBCSellFwdRateStatus")
    public String rbcSellFwdRateStatus;
    @JsonProperty("RbcBuyRateFormat")
    public int rbcBuyRateFormat;
    @JsonProperty("CapMktBuyFwdRateFormat")
    public int capMktBuyFwdRateFormat;
    @JsonProperty("CapMktSellFwdRateStatus")
    public String capMktSellFwdRateStatus;
    @JsonProperty ("RetrivedFwdRateEffDate")
    public int retrivedFwdRateEffDate;
    @JsonProperty ("RateEntryTime")
    public int rateEntryTime;
}
