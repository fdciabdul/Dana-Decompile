package id.dana.mybills.domain.model;

import com.alibaba.griver.api.constants.GriverEvents;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bX\u0010YJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004JÜ\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u0004R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u00105R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00105R$\u0010'\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u00108\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010;R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00102\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u00105R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00102\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u00105R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00102\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u00105R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u00105R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00102\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u00105R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00102\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u00105R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u00105R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u00105R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00102\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u00105R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00102\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u00105R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00102\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u00105R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u00105R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00102\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u00105R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00102\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u00105"}, d2 = {"Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "component17", "()Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "title", "subscriptionDayOfMonth", "goodsId", "billerId", "bizType", "recurringType", "subscriptionIntervalType", "subscriptionIntervalValue", "subscriptionHourOfDay", "subscriptionMonthOfYear", "message", BioUtilityBridge.SECURITY_ID, "validateData", CashierKeyParams.VERIFICATION_METHOD, "sendStrategy", "phoneNumber", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;)Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillerId", "setBillerId", "(Ljava/lang/String;)V", "getBizType", "setBizType", "Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "getExtendInfo", "setExtendInfo", "(Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;)V", "getGoodsId", "setGoodsId", "getMessage", "setMessage", "getPhoneNumber", "setPhoneNumber", "getRecurringType", "setRecurringType", "getSecurityId", "setSecurityId", "getSendStrategy", "setSendStrategy", "getSubscriptionDayOfMonth", "setSubscriptionDayOfMonth", "getSubscriptionHourOfDay", "setSubscriptionHourOfDay", "getSubscriptionIntervalType", "setSubscriptionIntervalType", "getSubscriptionIntervalValue", "setSubscriptionIntervalValue", "getSubscriptionMonthOfYear", "setSubscriptionMonthOfYear", "getTitle", GriverEvents.EVENT_SET_TITLE, "getValidateData", "setValidateData", "getVerificationMethod", "setVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateSubscriptionRequest {
    private String billerId;
    private String bizType;
    private CreateSubscriptionExtendInfo extendInfo;
    private String goodsId;
    private String message;
    private String phoneNumber;
    private String recurringType;
    private String securityId;
    private String sendStrategy;
    private String subscriptionDayOfMonth;
    private String subscriptionHourOfDay;
    private String subscriptionIntervalType;
    private String subscriptionIntervalValue;
    private String subscriptionMonthOfYear;
    private String title;
    private String validateData;
    private String verificationMethod;

    public CreateSubscriptionRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10  reason: from getter */
    public final String getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    /* renamed from: component11  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component12  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component14  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component15  reason: from getter */
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    /* renamed from: component16  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component17  reason: from getter */
    public final CreateSubscriptionExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBillerId() {
        return this.billerId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSubscriptionIntervalType() {
        return this.subscriptionIntervalType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSubscriptionIntervalValue() {
        return this.subscriptionIntervalValue;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    public final CreateSubscriptionRequest copy(String title, String subscriptionDayOfMonth, String goodsId, String billerId, String bizType, String recurringType, String subscriptionIntervalType, String subscriptionIntervalValue, String subscriptionHourOfDay, String subscriptionMonthOfYear, String message, String securityId, String validateData, String verificationMethod, String sendStrategy, String phoneNumber, CreateSubscriptionExtendInfo extendInfo) {
        return new CreateSubscriptionRequest(title, subscriptionDayOfMonth, goodsId, billerId, bizType, recurringType, subscriptionIntervalType, subscriptionIntervalValue, subscriptionHourOfDay, subscriptionMonthOfYear, message, securityId, validateData, verificationMethod, sendStrategy, phoneNumber, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateSubscriptionRequest) {
            CreateSubscriptionRequest createSubscriptionRequest = (CreateSubscriptionRequest) other;
            return Intrinsics.areEqual(this.title, createSubscriptionRequest.title) && Intrinsics.areEqual(this.subscriptionDayOfMonth, createSubscriptionRequest.subscriptionDayOfMonth) && Intrinsics.areEqual(this.goodsId, createSubscriptionRequest.goodsId) && Intrinsics.areEqual(this.billerId, createSubscriptionRequest.billerId) && Intrinsics.areEqual(this.bizType, createSubscriptionRequest.bizType) && Intrinsics.areEqual(this.recurringType, createSubscriptionRequest.recurringType) && Intrinsics.areEqual(this.subscriptionIntervalType, createSubscriptionRequest.subscriptionIntervalType) && Intrinsics.areEqual(this.subscriptionIntervalValue, createSubscriptionRequest.subscriptionIntervalValue) && Intrinsics.areEqual(this.subscriptionHourOfDay, createSubscriptionRequest.subscriptionHourOfDay) && Intrinsics.areEqual(this.subscriptionMonthOfYear, createSubscriptionRequest.subscriptionMonthOfYear) && Intrinsics.areEqual(this.message, createSubscriptionRequest.message) && Intrinsics.areEqual(this.securityId, createSubscriptionRequest.securityId) && Intrinsics.areEqual(this.validateData, createSubscriptionRequest.validateData) && Intrinsics.areEqual(this.verificationMethod, createSubscriptionRequest.verificationMethod) && Intrinsics.areEqual(this.sendStrategy, createSubscriptionRequest.sendStrategy) && Intrinsics.areEqual(this.phoneNumber, createSubscriptionRequest.phoneNumber) && Intrinsics.areEqual(this.extendInfo, createSubscriptionRequest.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.title;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.subscriptionDayOfMonth;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.billerId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.bizType;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.recurringType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.subscriptionIntervalType;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.subscriptionIntervalValue;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.subscriptionHourOfDay;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.subscriptionMonthOfYear;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.message;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.securityId;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.validateData;
        int hashCode13 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.verificationMethod;
        int hashCode14 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.sendStrategy;
        int hashCode15 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.phoneNumber;
        int hashCode16 = str16 == null ? 0 : str16.hashCode();
        CreateSubscriptionExtendInfo createSubscriptionExtendInfo = this.extendInfo;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + (createSubscriptionExtendInfo != null ? createSubscriptionExtendInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateSubscriptionRequest(title=");
        sb.append(this.title);
        sb.append(", subscriptionDayOfMonth=");
        sb.append(this.subscriptionDayOfMonth);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", billerId=");
        sb.append(this.billerId);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", subscriptionIntervalType=");
        sb.append(this.subscriptionIntervalType);
        sb.append(", subscriptionIntervalValue=");
        sb.append(this.subscriptionIntervalValue);
        sb.append(", subscriptionHourOfDay=");
        sb.append(this.subscriptionHourOfDay);
        sb.append(", subscriptionMonthOfYear=");
        sb.append(this.subscriptionMonthOfYear);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", sendStrategy=");
        sb.append(this.sendStrategy);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public CreateSubscriptionRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, CreateSubscriptionExtendInfo createSubscriptionExtendInfo) {
        this.title = str;
        this.subscriptionDayOfMonth = str2;
        this.goodsId = str3;
        this.billerId = str4;
        this.bizType = str5;
        this.recurringType = str6;
        this.subscriptionIntervalType = str7;
        this.subscriptionIntervalValue = str8;
        this.subscriptionHourOfDay = str9;
        this.subscriptionMonthOfYear = str10;
        this.message = str11;
        this.securityId = str12;
        this.validateData = str13;
        this.verificationMethod = str14;
        this.sendStrategy = str15;
        this.phoneNumber = str16;
        this.extendInfo = createSubscriptionExtendInfo;
    }

    public /* synthetic */ CreateSubscriptionRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, CreateSubscriptionExtendInfo createSubscriptionExtendInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "", (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : createSubscriptionExtendInfo);
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        this.title = str;
    }

    @JvmName(name = "getSubscriptionDayOfMonth")
    public final String getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    @JvmName(name = "setSubscriptionDayOfMonth")
    public final void setSubscriptionDayOfMonth(String str) {
        this.subscriptionDayOfMonth = str;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "setGoodsId")
    public final void setGoodsId(String str) {
        this.goodsId = str;
    }

    @JvmName(name = "getBillerId")
    public final String getBillerId() {
        return this.billerId;
    }

    @JvmName(name = "setBillerId")
    public final void setBillerId(String str) {
        this.billerId = str;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        this.bizType = str;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "setRecurringType")
    public final void setRecurringType(String str) {
        this.recurringType = str;
    }

    @JvmName(name = "getSubscriptionIntervalType")
    public final String getSubscriptionIntervalType() {
        return this.subscriptionIntervalType;
    }

    @JvmName(name = "setSubscriptionIntervalType")
    public final void setSubscriptionIntervalType(String str) {
        this.subscriptionIntervalType = str;
    }

    @JvmName(name = "getSubscriptionIntervalValue")
    public final String getSubscriptionIntervalValue() {
        return this.subscriptionIntervalValue;
    }

    @JvmName(name = "setSubscriptionIntervalValue")
    public final void setSubscriptionIntervalValue(String str) {
        this.subscriptionIntervalValue = str;
    }

    @JvmName(name = "getSubscriptionHourOfDay")
    public final String getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    @JvmName(name = "setSubscriptionHourOfDay")
    public final void setSubscriptionHourOfDay(String str) {
        this.subscriptionHourOfDay = str;
    }

    @JvmName(name = "getSubscriptionMonthOfYear")
    public final String getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    @JvmName(name = "setSubscriptionMonthOfYear")
    public final void setSubscriptionMonthOfYear(String str) {
        this.subscriptionMonthOfYear = str;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "setMessage")
    public final void setMessage(String str) {
        this.message = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        this.validateData = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "setSendStrategy")
    public final void setSendStrategy(String str) {
        this.sendStrategy = str;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @JvmName(name = "getExtendInfo")
    public final CreateSubscriptionExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(CreateSubscriptionExtendInfo createSubscriptionExtendInfo) {
        this.extendInfo = createSubscriptionExtendInfo;
    }
}
