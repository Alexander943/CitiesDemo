package com.citiestest.data.city.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class City {

    @PrimaryKey
    @SerializedName("city_id")
    private Integer cityId;
    @SerializedName("city_name")
    private String cityName;
    @SerializedName("city_latitude")
    private Double cityLatitude;
    @SerializedName("city_longitude")
    private Double cityLongitude;
    @SerializedName("city_spn_latitude")
    private Double citySpnLatitude;
    @SerializedName("city_spn_longitude")
    private Double citySpnLongitude;
    @SerializedName("last_app_android_version")
    private Integer lastAppAndroidVersion;
    @SerializedName("transfers")
    private Boolean transfers;
    @SerializedName("client_email_required")
    private Boolean clientEmailRequired;
    @SerializedName("registration_promocode")
    private Boolean registrationPromocode;
    @SerializedName("parent_city")
    private Integer parentCity;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(Double cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    public Double getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(Double cityLongitude) {
        this.cityLongitude = cityLongitude;
    }

    public Double getCitySpnLatitude() {
        return citySpnLatitude;
    }

    public void setCitySpnLatitude(Double citySpnLatitude) {
        this.citySpnLatitude = citySpnLatitude;
    }

    public Double getCitySpnLongitude() {
        return citySpnLongitude;
    }

    public void setCitySpnLongitude(Double citySpnLongitude) {
        this.citySpnLongitude = citySpnLongitude;
    }

    public Integer getLastAppAndroidVersion() {
        return lastAppAndroidVersion;
    }

    public void setLastAppAndroidVersion(Integer lastAppAndroidVersion) {
        this.lastAppAndroidVersion = lastAppAndroidVersion;
    }

    public Boolean getTransfers() {
        return transfers;
    }

    public void setTransfers(Boolean transfers) {
        this.transfers = transfers;
    }

    public Boolean getClientEmailRequired() {
        return clientEmailRequired;
    }

    public void setClientEmailRequired(Boolean clientEmailRequired) {
        this.clientEmailRequired = clientEmailRequired;
    }

    public Boolean getRegistrationPromocode() {
        return registrationPromocode;
    }

    public void setRegistrationPromocode(Boolean registrationPromocode) {
        this.registrationPromocode = registrationPromocode;
    }

    public Integer getParentCity() {
        return parentCity;
    }

    public void setParentCity(Integer parentCity) {
        this.parentCity = parentCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof City)) return false;

        City city = (City) o;

        return new EqualsBuilder()
                .append(getCityId(), city.getCityId())
                .append(getCityName(), city.getCityName())
                .append(getCityLatitude(), city.getCityLatitude())
                .append(getCityLongitude(), city.getCityLongitude())
                .append(getCitySpnLatitude(), city.getCitySpnLatitude())
                .append(getCitySpnLongitude(), city.getCitySpnLongitude())
                .append(getLastAppAndroidVersion(), city.getLastAppAndroidVersion())
                .append(getTransfers(), city.getTransfers())
                .append(getClientEmailRequired(), city.getClientEmailRequired())
                .append(getRegistrationPromocode(), city.getRegistrationPromocode())
                .append(getParentCity(), city.getParentCity())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCityId())
                .append(getCityName())
                .append(getCityLatitude())
                .append(getCityLongitude())
                .append(getCitySpnLatitude())
                .append(getCitySpnLongitude())
                .append(getLastAppAndroidVersion())
                .append(getTransfers())
                .append(getClientEmailRequired())
                .append(getRegistrationPromocode())
                .append(getParentCity())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityLatitude=" + cityLatitude +
                ", cityLongitude=" + cityLongitude +
                ", citySpnLatitude=" + citySpnLatitude +
                ", citySpnLongitude=" + citySpnLongitude +
                ", lastAppAndroidVersion=" + lastAppAndroidVersion +
                ", transfers=" + transfers +
                ", clientEmailRequired=" + clientEmailRequired +
                ", registrationPromocode=" + registrationPromocode +
                ", parentCity=" + parentCity +
                '}';
    }
}