package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.ContactAddress;

/* loaded from: classes2.dex */
public class ContactAddressEntity {
    private String address1;
    private String address2;
    private String area;
    private String city;
    private String contactAddressId;
    private String contactAddressType;
    private String country;
    private boolean defaultAddress;
    private String extendInfo;
    private String province;
    private boolean verified;
    private String zipcode;

    public String getContactAddressId() {
        return this.contactAddressId;
    }

    public void setContactAddressId(String str) {
        this.contactAddressId = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String str) {
        this.zipcode = str;
    }

    public String getContactAddressType() {
        return this.contactAddressType;
    }

    public void setContactAddressType(String str) {
        this.contactAddressType = str;
    }

    public boolean isDefaultAddress() {
        return this.defaultAddress;
    }

    public void setDefaultAddress(boolean z) {
        this.defaultAddress = z;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }

    public ContactAddress toContactAddress() {
        ContactAddress contactAddress = new ContactAddress();
        contactAddress.setAddress1(this.address1);
        contactAddress.setAddress2(this.address2);
        contactAddress.setArea(this.area);
        contactAddress.setCity(this.city);
        contactAddress.setContactAddressId(this.contactAddressId);
        contactAddress.setContactAddressType(this.contactAddressType);
        contactAddress.setCountry(this.country);
        contactAddress.setDefaultAddress(this.defaultAddress);
        contactAddress.setExtendInfo(this.extendInfo);
        contactAddress.setProvince(this.province);
        contactAddress.setVerified(this.verified);
        contactAddress.setZipcode(this.zipcode);
        return contactAddress;
    }
}
