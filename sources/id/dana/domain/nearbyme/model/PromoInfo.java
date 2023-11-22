package id.dana.domain.nearbyme.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.user.CurrencyAmount;
import id.dana.requestmoney.BundleKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u009c\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010.R\"\u0010\u001e\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u00102R\"\u0010\u001d\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010/\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u00102R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00105\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u00108R$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010<R$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010<R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00105\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u00108R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u0010.R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010.R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010.R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010+\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u0010."}, d2 = {"Lid/dana/domain/nearbyme/model/PromoInfo;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/user/CurrencyAmount;", "component10", "()Lid/dana/domain/user/CurrencyAmount;", "", "Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "component11", "()Ljava/util/List;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()J", "component9", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "prizeType", "promoDescription", "promoValue", "promoType", "paymentMethods", "minTransactionAmount", "endDate", "beginDate", BundleKey.MAXIMUM_AMOUNT, "limitRule", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/user/CurrencyAmount;JJLid/dana/domain/user/CurrencyAmount;Ljava/util/List;)Lid/dana/domain/nearbyme/model/PromoInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "setActivityId", "(Ljava/lang/String;)V", "J", "getBeginDate", "setBeginDate", "(J)V", "getEndDate", "setEndDate", "Ljava/util/List;", "getLimitRule", "setLimitRule", "(Ljava/util/List;)V", "Lid/dana/domain/user/CurrencyAmount;", "getMaxAmount", "setMaxAmount", "(Lid/dana/domain/user/CurrencyAmount;)V", "getMinTransactionAmount", "setMinTransactionAmount", "getPaymentMethods", "setPaymentMethods", "getPrizeType", "setPrizeType", "getPromoDescription", "setPromoDescription", "getPromoType", "setPromoType", "getPromoValue", "setPromoValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/user/CurrencyAmount;JJLid/dana/domain/user/CurrencyAmount;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PromoInfo {
    private String activityId;
    private long beginDate;
    private long endDate;
    private List<PromoLimitInfo> limitRule;
    private CurrencyAmount maxAmount;
    private CurrencyAmount minTransactionAmount;
    private List<String> paymentMethods;
    private String prizeType;
    private String promoDescription;
    private String promoType;
    private String promoValue;

    public PromoInfo() {
        this(null, null, null, null, null, null, null, 0L, 0L, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component10  reason: from getter */
    public final CurrencyAmount getMaxAmount() {
        return this.maxAmount;
    }

    public final List<PromoLimitInfo> component11() {
        return this.limitRule;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPrizeType() {
        return this.prizeType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPromoDescription() {
        return this.promoDescription;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPromoValue() {
        return this.promoValue;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPromoType() {
        return this.promoType;
    }

    public final List<String> component6() {
        return this.paymentMethods;
    }

    /* renamed from: component7  reason: from getter */
    public final CurrencyAmount getMinTransactionAmount() {
        return this.minTransactionAmount;
    }

    /* renamed from: component8  reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    /* renamed from: component9  reason: from getter */
    public final long getBeginDate() {
        return this.beginDate;
    }

    public final PromoInfo copy(String activityId, String prizeType, String promoDescription, String promoValue, String promoType, List<String> paymentMethods, CurrencyAmount minTransactionAmount, long endDate, long beginDate, CurrencyAmount maxAmount, List<PromoLimitInfo> limitRule) {
        return new PromoInfo(activityId, prizeType, promoDescription, promoValue, promoType, paymentMethods, minTransactionAmount, endDate, beginDate, maxAmount, limitRule);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoInfo) {
            PromoInfo promoInfo = (PromoInfo) other;
            return Intrinsics.areEqual(this.activityId, promoInfo.activityId) && Intrinsics.areEqual(this.prizeType, promoInfo.prizeType) && Intrinsics.areEqual(this.promoDescription, promoInfo.promoDescription) && Intrinsics.areEqual(this.promoValue, promoInfo.promoValue) && Intrinsics.areEqual(this.promoType, promoInfo.promoType) && Intrinsics.areEqual(this.paymentMethods, promoInfo.paymentMethods) && Intrinsics.areEqual(this.minTransactionAmount, promoInfo.minTransactionAmount) && this.endDate == promoInfo.endDate && this.beginDate == promoInfo.beginDate && Intrinsics.areEqual(this.maxAmount, promoInfo.maxAmount) && Intrinsics.areEqual(this.limitRule, promoInfo.limitRule);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.activityId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.prizeType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.promoDescription;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.promoValue;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.promoType;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        List<String> list = this.paymentMethods;
        int hashCode6 = list == null ? 0 : list.hashCode();
        CurrencyAmount currencyAmount = this.minTransactionAmount;
        int hashCode7 = currencyAmount == null ? 0 : currencyAmount.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.endDate);
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.beginDate);
        CurrencyAmount currencyAmount2 = this.maxAmount;
        int hashCode8 = currencyAmount2 == null ? 0 : currencyAmount2.hashCode();
        List<PromoLimitInfo> list2 = this.limitRule;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + m) * 31) + m2) * 31) + hashCode8) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoInfo(activityId=");
        sb.append(this.activityId);
        sb.append(", prizeType=");
        sb.append(this.prizeType);
        sb.append(", promoDescription=");
        sb.append(this.promoDescription);
        sb.append(", promoValue=");
        sb.append(this.promoValue);
        sb.append(", promoType=");
        sb.append(this.promoType);
        sb.append(", paymentMethods=");
        sb.append(this.paymentMethods);
        sb.append(", minTransactionAmount=");
        sb.append(this.minTransactionAmount);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", beginDate=");
        sb.append(this.beginDate);
        sb.append(", maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", limitRule=");
        sb.append(this.limitRule);
        sb.append(')');
        return sb.toString();
    }

    public PromoInfo(String str, String str2, String str3, String str4, String str5, List<String> list, CurrencyAmount currencyAmount, long j, long j2, CurrencyAmount currencyAmount2, List<PromoLimitInfo> list2) {
        this.activityId = str;
        this.prizeType = str2;
        this.promoDescription = str3;
        this.promoValue = str4;
        this.promoType = str5;
        this.paymentMethods = list;
        this.minTransactionAmount = currencyAmount;
        this.endDate = j;
        this.beginDate = j2;
        this.maxAmount = currencyAmount2;
        this.limitRule = list2;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "setActivityId")
    public final void setActivityId(String str) {
        this.activityId = str;
    }

    @JvmName(name = "getPrizeType")
    public final String getPrizeType() {
        return this.prizeType;
    }

    @JvmName(name = "setPrizeType")
    public final void setPrizeType(String str) {
        this.prizeType = str;
    }

    @JvmName(name = "getPromoDescription")
    public final String getPromoDescription() {
        return this.promoDescription;
    }

    @JvmName(name = "setPromoDescription")
    public final void setPromoDescription(String str) {
        this.promoDescription = str;
    }

    @JvmName(name = "getPromoValue")
    public final String getPromoValue() {
        return this.promoValue;
    }

    @JvmName(name = "setPromoValue")
    public final void setPromoValue(String str) {
        this.promoValue = str;
    }

    @JvmName(name = "getPromoType")
    public final String getPromoType() {
        return this.promoType;
    }

    @JvmName(name = "setPromoType")
    public final void setPromoType(String str) {
        this.promoType = str;
    }

    public /* synthetic */ PromoInfo(String str, String str2, String str3, String str4, String str5, List list, CurrencyAmount currencyAmount, long j, long j2, CurrencyAmount currencyAmount2, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? new CurrencyAmount() : currencyAmount, (i & 128) != 0 ? 0L : j, (i & 256) == 0 ? j2 : 0L, (i & 512) != 0 ? new CurrencyAmount() : currencyAmount2, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getPaymentMethods")
    public final List<String> getPaymentMethods() {
        return this.paymentMethods;
    }

    @JvmName(name = "setPaymentMethods")
    public final void setPaymentMethods(List<String> list) {
        this.paymentMethods = list;
    }

    @JvmName(name = "getMinTransactionAmount")
    public final CurrencyAmount getMinTransactionAmount() {
        return this.minTransactionAmount;
    }

    @JvmName(name = "setMinTransactionAmount")
    public final void setMinTransactionAmount(CurrencyAmount currencyAmount) {
        this.minTransactionAmount = currencyAmount;
    }

    @JvmName(name = "getEndDate")
    public final long getEndDate() {
        return this.endDate;
    }

    @JvmName(name = "setEndDate")
    public final void setEndDate(long j) {
        this.endDate = j;
    }

    @JvmName(name = "getBeginDate")
    public final long getBeginDate() {
        return this.beginDate;
    }

    @JvmName(name = "setBeginDate")
    public final void setBeginDate(long j) {
        this.beginDate = j;
    }

    @JvmName(name = "getMaxAmount")
    public final CurrencyAmount getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "setMaxAmount")
    public final void setMaxAmount(CurrencyAmount currencyAmount) {
        this.maxAmount = currencyAmount;
    }

    @JvmName(name = "getLimitRule")
    public final List<PromoLimitInfo> getLimitRule() {
        return this.limitRule;
    }

    @JvmName(name = "setLimitRule")
    public final void setLimitRule(List<PromoLimitInfo> list) {
        this.limitRule = list;
    }
}
