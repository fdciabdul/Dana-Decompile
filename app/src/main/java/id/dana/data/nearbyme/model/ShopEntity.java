package id.dana.data.nearbyme.model;

import com.alibaba.fastjson.annotation.JSONField;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.MerchantStatusEnum;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ShopEntity {
    private String branchName;
    private String brandName;
    private String certStatus;
    private List<ContactAddressEntity> contactAddresses;
    private Map<String, String> extInfo;
    private String externalShopId;
    private boolean fullDay;
    private boolean hasDeals;
    private boolean hasMoreShops = false;
    private double latitude;
    private String logoUrl;
    private Map<String, String> logoUrlMap;
    private double longtitude;
    private String mainName;
    private List<String> mccCodes;
    private String merchantId;
    private String merchantName;
    private String merchantSizeType;
    private List<String> officeNumbers;
    private List<PromoInfoEntity> promoInfos;
    private double rating;
    private String registerSource;
    @JSONField(alternateNames = {"reviewNumbers"}, name = "reviewNumber")
    private double reviewNumber;
    private String shopDesc;
    private String shopId;
    private List<ShopOpenHourEntity> shopOpenHours;
    private MerchantStatusEnum shopStatus;
    private String shopType;
    private Long transactionDate;

    public List<String> getOfficeNumbers() {
        return this.officeNumbers;
    }

    public void setOfficeNumbers(List<String> list) {
        this.officeNumbers = list;
    }

    public boolean getFullDay() {
        return this.fullDay;
    }

    public void setFullDay(boolean z) {
        this.fullDay = z;
    }

    public List<ShopOpenHourEntity> getShopOpenHours() {
        return this.shopOpenHours;
    }

    public void setShopOpenHours(List<ShopOpenHourEntity> list) {
        this.shopOpenHours = list;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double d) {
        this.rating = d;
    }

    public double getReviewNumber() {
        return this.reviewNumber;
    }

    public void setReviewNumber(double d) {
        this.reviewNumber = d;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public List<String> getMccCodes() {
        return this.mccCodes;
    }

    public void setMccCodes(List<String> list) {
        this.mccCodes = list;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String str) {
        this.brandName = str;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String str) {
        this.branchName = str;
    }

    public String getMainName() {
        return this.mainName;
    }

    public void setMainName(String str) {
        this.mainName = str;
    }

    public String getCertStatus() {
        return this.certStatus;
    }

    public void setCertStatus(String str) {
        this.certStatus = str;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String str) {
        this.shopId = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(double d) {
        this.longtitude = d;
    }

    public String getExternalShopId() {
        return this.externalShopId;
    }

    public void setExternalShopId(String str) {
        this.externalShopId = str;
    }

    public String getShopDesc() {
        return this.shopDesc;
    }

    public void setShopDesc(String str) {
        this.shopDesc = str;
    }

    public String getShopType() {
        return this.shopType;
    }

    public void setShopType(String str) {
        this.shopType = str;
    }

    public String getRegisterSource() {
        return this.registerSource;
    }

    public void setRegisterSource(String str) {
        this.registerSource = str;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public Map<String, String> getLogoUrlMap() {
        return this.logoUrlMap;
    }

    public void setLogoUrlMap(Map<String, String> map) {
        this.logoUrlMap = map;
    }

    public List<ContactAddressEntity> getContactAddresses() {
        return this.contactAddresses;
    }

    public void setContactAddresses(List<ContactAddressEntity> list) {
        this.contactAddresses = list;
    }

    public MerchantStatusEnum getShopStatus() {
        return this.shopStatus;
    }

    public void setShopStatus(MerchantStatusEnum merchantStatusEnum) {
        this.shopStatus = merchantStatusEnum;
    }

    public List<PromoInfoEntity> getPromoInfos() {
        return this.promoInfos;
    }

    public void setPromoInfos(List<PromoInfoEntity> list) {
        this.promoInfos = list;
    }

    public String getMerchantSizeType() {
        return this.merchantSizeType;
    }

    public void setMerchantSizeType(String str) {
        this.merchantSizeType = str;
    }

    public Shop toShop() {
        Shop shop = new Shop();
        shop.setBranchName(this.branchName);
        shop.setBrandName(this.brandName);
        shop.setCertStatus(this.certStatus);
        shop.setContactAddresses(transformContactAddressEntityToContactAddress(this.contactAddresses));
        shop.setExtInfo(this.extInfo);
        shop.setExternalShopId(this.externalShopId);
        shop.setLatitude(this.latitude);
        shop.setLogoUrl(this.logoUrl);
        shop.setLogoUrlMap(this.logoUrlMap);
        shop.setLongtitude(this.longtitude);
        shop.setMainName(this.mainName);
        shop.setMccCodes(this.mccCodes);
        shop.setMerchantId(this.merchantId);
        shop.setRegisterSource(this.registerSource);
        shop.setShopDesc(this.shopDesc);
        shop.setShopId(this.shopId);
        shop.setShopStatus(this.shopStatus);
        shop.setShopType(this.shopType);
        shop.setPromoInfos(transformPromoInfoEntityToPromoInfo(this.promoInfos));
        shop.setRating(this.rating);
        shop.setReviewNumbers(this.reviewNumber);
        shop.setFullDay(this.fullDay);
        shop.setShopOpenHours(transformShopOpenHourListEntityToShopOpenHour(this.shopOpenHours));
        shop.setMerchantSizeType(this.merchantSizeType);
        shop.setMerchantName(this.merchantName);
        shop.setHasMoreShop(this.hasMoreShops);
        return shop;
    }

    private List<ContactAddress> transformContactAddressEntityToContactAddress(List<ContactAddressEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<ContactAddressEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toContactAddress());
            }
        }
        return arrayList;
    }

    private List<PromoInfo> transformPromoInfoEntityToPromoInfo(List<PromoInfoEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<PromoInfoEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toPromoInfo());
            }
        }
        return arrayList;
    }

    private List<ShopOpenHour> transformShopOpenHourListEntityToShopOpenHour(List<ShopOpenHourEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<ShopOpenHourEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShopOpenHour());
            }
        }
        return arrayList;
    }

    public boolean isHasMoreShops() {
        return this.hasMoreShops;
    }

    public void setHasMoreShops(boolean z) {
        this.hasMoreShops = z;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public Long getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Long l) {
        this.transactionDate = l;
    }

    public boolean isHasDeals() {
        return this.hasDeals;
    }

    public void setHasDeals(boolean z) {
        this.hasDeals = z;
    }
}
