package com.citiestest.data.city.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class City implements Parcelable {

    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("city_latitude")
    @Expose
    private Double cityLatitude;
    @SerializedName("city_longitude")
    @Expose
    private Double cityLongitude;
    @SerializedName("city_spn_latitude")
    @Expose
    private Double citySpnLatitude;
    @SerializedName("city_spn_longitude")
    @Expose
    private Double citySpnLongitude;
    @SerializedName("last_app_android_version")
    @Expose
    private Integer lastAppAndroidVersion;
    @SerializedName("transfers")
    @Expose
    private Boolean transfers;
    @SerializedName("client_email_required")
    @Expose
    private Boolean clientEmailRequired;
    @SerializedName("registration_promocode")
    @Expose
    private Boolean registrationPromocode;
    @SerializedName("parent_city")
    @Expose
    private Integer parentCity;
    public final static Parcelable.Creator<City> CREATOR = new Creator<City>() {


        @SuppressWarnings({
                "unchecked"
        })
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return (new City[size]);
        }

    };

    protected City(Parcel in) {
        this.cityId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cityName = ((String) in.readValue((String.class.getClassLoader())));
        this.cityLatitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cityLongitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.citySpnLatitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.citySpnLongitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.lastAppAndroidVersion = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.transfers = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.clientEmailRequired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.registrationPromocode = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.parentCity = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public City() {
    }

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
    public int hashCode() {
        return new HashCodeBuilder()
                .append(citySpnLongitude).append(transfers)
                .append(lastAppAndroidVersion).append(cityLongitude)
                .append(registrationPromocode).append(clientEmailRequired)
                .append(cityLatitude).append(cityId)
                .append(citySpnLatitude).append(cityName)
                .append(parentCity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof City)) {
            return false;
        }
        City rhs = ((City) other);
        return new EqualsBuilder().append(citySpnLongitude, rhs.citySpnLongitude)
                .append(transfers, rhs.transfers)
                .append(lastAppAndroidVersion, rhs.lastAppAndroidVersion)
                .append(cityLongitude, rhs.cityLongitude)
                .append(registrationPromocode, rhs.registrationPromocode)
                .append(clientEmailRequired, rhs.clientEmailRequired)
                .append(cityLatitude, rhs.cityLatitude)
                .append(cityId, rhs.cityId)
                .append(citySpnLatitude, rhs.citySpnLatitude)
                .append(cityName, rhs.cityName)
                .append(parentCity, rhs.parentCity).isEquals();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cityId);
        dest.writeValue(cityName);
        dest.writeValue(cityLatitude);
        dest.writeValue(cityLongitude);
        dest.writeValue(citySpnLatitude);
        dest.writeValue(citySpnLongitude);
        dest.writeValue(lastAppAndroidVersion);
        dest.writeValue(transfers);
        dest.writeValue(clientEmailRequired);
        dest.writeValue(registrationPromocode);
        dest.writeValue(parentCity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}