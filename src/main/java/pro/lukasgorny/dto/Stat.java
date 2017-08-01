package pro.lukasgorny.dto;

import com.google.gson.annotations.SerializedName;

import pro.lukasgorny.enums.PUBGSeason;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-30.
 */
public class Stat {
    private String partition;

    private String label;

    private String subLabel;

    private String field;

    private String category;

    @SerializedName("ValueInt")
    private Integer integerValue;

    @SerializedName("ValueDec")
    private Double decimalValue;

    @SerializedName("value")
    private String stringValue;

    private Integer rank;

    private Double percentile;

    private String displayValue;

    private transient PUBGSeason season;

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(Double decimalValue) {
        this.decimalValue = decimalValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getPercentile() {
        return percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public PUBGSeason getSeason() {
        return season;
    }

    public void setSeason(PUBGSeason season) {
        this.season = season;
    }
}
