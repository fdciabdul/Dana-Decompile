package id.dana.domain.sendmoney.model;

import id.dana.domain.user.CurrencyAmount;
import java.util.List;

/* loaded from: classes4.dex */
public class CouponChannelInfo {
    private long activeTime;
    private CurrencyAmount availableAmount;
    private CouponDiscountInfo couponDiscountInfo;
    private String couponId;
    private String couponName;
    private List<CouponPayMethodInfo> couponPayMethodInfos;
    private long createdTime;
    private String description;
    private long expiryTime;
    private long extendTime;
    private String iconUrl;
    private long modifiedTime;
    private String tnc;
    private CurrencyAmount totalAmount;

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

    public CurrencyAmount getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(CurrencyAmount currencyAmount) {
        this.availableAmount = currencyAmount;
    }

    public CurrencyAmount getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmount currencyAmount) {
        this.totalAmount = currencyAmount;
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

    public CouponDiscountInfo getCouponDiscountInfo() {
        return this.couponDiscountInfo;
    }

    public void setCouponDiscountInfo(CouponDiscountInfo couponDiscountInfo) {
        this.couponDiscountInfo = couponDiscountInfo;
    }

    public List<CouponPayMethodInfo> getCouponPayMethodInfos() {
        return this.couponPayMethodInfos;
    }

    public void setCouponPayMethodInfos(List<CouponPayMethodInfo> list) {
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
