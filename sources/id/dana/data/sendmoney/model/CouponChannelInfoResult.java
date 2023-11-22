package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import java.util.List;

/* loaded from: classes4.dex */
public class CouponChannelInfoResult {
    private long activeTime;
    private CurrencyAmountResult availableAmount;
    private CouponDiscountInfoResult couponDiscountInfo;
    private String couponId;
    private String couponName;
    private List<CouponPayMethodInfoResult> couponPayMethodInfos;
    private long createdTime;
    private String description;
    private long expiryTime;
    private long extendTime;
    private String iconUrl;
    private long modifiedTime;
    private String tnc;
    private CurrencyAmountResult totalAmount;

    public String getCouponId() {
        return this.couponId;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public String getCouponName() {
        return this.couponName;
    }

    public void setCouponName(String str) {
        this.couponName = str;
    }

    public CurrencyAmountResult getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(CurrencyAmountResult currencyAmountResult) {
        this.availableAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmountResult currencyAmountResult) {
        this.totalAmount = currencyAmountResult;
    }

    public long getActiveTime() {
        return this.activeTime;
    }

    public void setActiveTime(long j) {
        this.activeTime = j;
    }

    public long getExpiryTime() {
        return this.expiryTime;
    }

    public void setExpiryTime(long j) {
        this.expiryTime = j;
    }

    public long getExtendTime() {
        return this.extendTime;
    }

    public void setExtendTime(long j) {
        this.extendTime = j;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public void setModifiedTime(long j) {
        this.modifiedTime = j;
    }

    public CouponDiscountInfoResult getCouponDiscountInfo() {
        return this.couponDiscountInfo;
    }

    public void setCouponDiscountInfo(CouponDiscountInfoResult couponDiscountInfoResult) {
        this.couponDiscountInfo = couponDiscountInfoResult;
    }

    public List<CouponPayMethodInfoResult> getCouponPayMethodInfos() {
        return this.couponPayMethodInfos;
    }

    public void setCouponPayMethodInfos(List<CouponPayMethodInfoResult> list) {
        this.couponPayMethodInfos = list;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getTnc() {
        return this.tnc;
    }

    public void setTnc(String str) {
        this.tnc = str;
    }
}
