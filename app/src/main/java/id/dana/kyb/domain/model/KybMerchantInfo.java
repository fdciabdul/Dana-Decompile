package id.dana.kyb.domain.model;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.animation.ScanQrLoyaltyActivity;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010.\u001a\u00020\u0011\u0012\b\b\u0002\u0010/\u001a\u00020\u0011\u0012\b\b\u0002\u00100\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010RJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0013J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0013Jè\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00112\b\b\u0002\u00100\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b9\u0010\u0004R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b;\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b=\u0010\u0004R\u001a\u0010'\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010>\u001a\u0004\b?\u0010\u0007R\u001a\u0010(\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010>\u001a\u0004\b@\u0010\u0007R\u001a\u0010)\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010>\u001a\u0004\bA\u0010\u0007R\u001a\u0010*\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010>\u001a\u0004\bB\u0010\u0007R\u001a\u0010+\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\bC\u0010\u0007R\u001a\u0010/\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010:\u001a\u0004\bD\u0010\u0013R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\bE\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\bF\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\bG\u0010\u0004R\u001a\u0010$\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\bH\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\bI\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\bJ\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\bK\u0010\u0013R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010L\u001a\u0004\bM\u0010\u000fR\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010L\u001a\u0004\bN\u0010\u000fR\u001a\u00100\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010<\u001a\u0004\bO\u0010\u0004R\u001a\u0010.\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010:\u001a\u0004\bP\u0010\u0013"}, d2 = {"Lid/dana/kyb/domain/model/KybMerchantInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Z", "component11", "component12", "component13", "component14", "", "Lid/dana/kyb/domain/model/MerchantContractInfo;", "component15", "()Ljava/util/List;", "component16", "Lid/dana/domain/nearbyme/model/MoneyView;", "component17", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "merchantQrCode", "merchantName", "merchantType", "merchantId", "balance", "businessAvatarUrl", "merchantStatus", ScanQrLoyaltyActivity.KEY_NMID, "pendingBalance", "faceAuthActivated", "faceAuthEligible", "faceAuthEnrolled", "freezeFundIn", "freezeFundOut", "signedContracts", "unsignedContracts", "usedAmount", "limitAmount", "urgencyLevel", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;ZZZZZLjava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)Lid/dana/kyb/domain/model/KybMerchantInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalance", "Ljava/lang/String;", "getBusinessAvatarUrl", "Z", "getFaceAuthActivated", "getFaceAuthEligible", "getFaceAuthEnrolled", "getFreezeFundIn", "getFreezeFundOut", "getLimitAmount", "getMerchantId", "getMerchantName", "getMerchantQrCode", "getMerchantStatus", "getMerchantType", "getNmid", "getPendingBalance", "Ljava/util/List;", "getSignedContracts", "getUnsignedContracts", "getUrgencyLevel", "getUsedAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;ZZZZZLjava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybMerchantInfo {
    private final MoneyView balance;
    private final String businessAvatarUrl;
    private final boolean faceAuthActivated;
    private final boolean faceAuthEligible;
    private final boolean faceAuthEnrolled;
    private final boolean freezeFundIn;
    private final boolean freezeFundOut;
    private final MoneyView limitAmount;
    private final String merchantId;
    private final String merchantName;
    private final String merchantQrCode;
    private final String merchantStatus;
    private final String merchantType;
    private final String nmid;
    private final MoneyView pendingBalance;
    private final List<MerchantContractInfo> signedContracts;
    private final List<MerchantContractInfo> unsignedContracts;
    private final String urgencyLevel;
    private final MoneyView usedAmount;

    public KybMerchantInfo() {
        this(null, null, null, null, null, null, null, null, null, false, false, false, false, false, null, null, null, null, null, 524287, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantQrCode() {
        return this.merchantQrCode;
    }

    /* renamed from: component10  reason: from getter */
    public final boolean getFaceAuthActivated() {
        return this.faceAuthActivated;
    }

    /* renamed from: component11  reason: from getter */
    public final boolean getFaceAuthEligible() {
        return this.faceAuthEligible;
    }

    /* renamed from: component12  reason: from getter */
    public final boolean getFaceAuthEnrolled() {
        return this.faceAuthEnrolled;
    }

    /* renamed from: component13  reason: from getter */
    public final boolean getFreezeFundIn() {
        return this.freezeFundIn;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getFreezeFundOut() {
        return this.freezeFundOut;
    }

    public final List<MerchantContractInfo> component15() {
        return this.signedContracts;
    }

    public final List<MerchantContractInfo> component16() {
        return this.unsignedContracts;
    }

    /* renamed from: component17  reason: from getter */
    public final MoneyView getUsedAmount() {
        return this.usedAmount;
    }

    /* renamed from: component18  reason: from getter */
    public final MoneyView getLimitAmount() {
        return this.limitAmount;
    }

    /* renamed from: component19  reason: from getter */
    public final String getUrgencyLevel() {
        return this.urgencyLevel;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMerchantType() {
        return this.merchantType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getBalance() {
        return this.balance;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBusinessAvatarUrl() {
        return this.businessAvatarUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final String getMerchantStatus() {
        return this.merchantStatus;
    }

    /* renamed from: component8  reason: from getter */
    public final String getNmid() {
        return this.nmid;
    }

    /* renamed from: component9  reason: from getter */
    public final MoneyView getPendingBalance() {
        return this.pendingBalance;
    }

    public final KybMerchantInfo copy(String merchantQrCode, String merchantName, String merchantType, String merchantId, MoneyView balance, String businessAvatarUrl, String merchantStatus, String nmid, MoneyView pendingBalance, boolean faceAuthActivated, boolean faceAuthEligible, boolean faceAuthEnrolled, boolean freezeFundIn, boolean freezeFundOut, List<MerchantContractInfo> signedContracts, List<MerchantContractInfo> unsignedContracts, MoneyView usedAmount, MoneyView limitAmount, String urgencyLevel) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(merchantType, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(merchantStatus, "");
        Intrinsics.checkNotNullParameter(usedAmount, "");
        Intrinsics.checkNotNullParameter(limitAmount, "");
        Intrinsics.checkNotNullParameter(urgencyLevel, "");
        return new KybMerchantInfo(merchantQrCode, merchantName, merchantType, merchantId, balance, businessAvatarUrl, merchantStatus, nmid, pendingBalance, faceAuthActivated, faceAuthEligible, faceAuthEnrolled, freezeFundIn, freezeFundOut, signedContracts, unsignedContracts, usedAmount, limitAmount, urgencyLevel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybMerchantInfo) {
            KybMerchantInfo kybMerchantInfo = (KybMerchantInfo) other;
            return Intrinsics.areEqual(this.merchantQrCode, kybMerchantInfo.merchantQrCode) && Intrinsics.areEqual(this.merchantName, kybMerchantInfo.merchantName) && Intrinsics.areEqual(this.merchantType, kybMerchantInfo.merchantType) && Intrinsics.areEqual(this.merchantId, kybMerchantInfo.merchantId) && Intrinsics.areEqual(this.balance, kybMerchantInfo.balance) && Intrinsics.areEqual(this.businessAvatarUrl, kybMerchantInfo.businessAvatarUrl) && Intrinsics.areEqual(this.merchantStatus, kybMerchantInfo.merchantStatus) && Intrinsics.areEqual(this.nmid, kybMerchantInfo.nmid) && Intrinsics.areEqual(this.pendingBalance, kybMerchantInfo.pendingBalance) && this.faceAuthActivated == kybMerchantInfo.faceAuthActivated && this.faceAuthEligible == kybMerchantInfo.faceAuthEligible && this.faceAuthEnrolled == kybMerchantInfo.faceAuthEnrolled && this.freezeFundIn == kybMerchantInfo.freezeFundIn && this.freezeFundOut == kybMerchantInfo.freezeFundOut && Intrinsics.areEqual(this.signedContracts, kybMerchantInfo.signedContracts) && Intrinsics.areEqual(this.unsignedContracts, kybMerchantInfo.unsignedContracts) && Intrinsics.areEqual(this.usedAmount, kybMerchantInfo.usedAmount) && Intrinsics.areEqual(this.limitAmount, kybMerchantInfo.limitAmount) && Intrinsics.areEqual(this.urgencyLevel, kybMerchantInfo.urgencyLevel);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.merchantQrCode;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.merchantName.hashCode();
        int hashCode3 = this.merchantType.hashCode();
        int hashCode4 = this.merchantId.hashCode();
        MoneyView moneyView = this.balance;
        int hashCode5 = moneyView == null ? 0 : moneyView.hashCode();
        String str2 = this.businessAvatarUrl;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        int hashCode7 = this.merchantStatus.hashCode();
        String str3 = this.nmid;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        MoneyView moneyView2 = this.pendingBalance;
        int hashCode9 = moneyView2 == null ? 0 : moneyView2.hashCode();
        boolean z = this.faceAuthActivated;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.faceAuthEligible;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.faceAuthEnrolled;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        boolean z4 = this.freezeFundIn;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        boolean z5 = this.freezeFundOut;
        int i5 = z5 ? 1 : z5 ? 1 : 0;
        List<MerchantContractInfo> list = this.signedContracts;
        int hashCode10 = list == null ? 0 : list.hashCode();
        List<MerchantContractInfo> list2 = this.unsignedContracts;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + hashCode10) * 31) + (list2 != null ? list2.hashCode() : 0)) * 31) + this.usedAmount.hashCode()) * 31) + this.limitAmount.hashCode()) * 31) + this.urgencyLevel.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybMerchantInfo(merchantQrCode=");
        sb.append(this.merchantQrCode);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", merchantType=");
        sb.append(this.merchantType);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", businessAvatarUrl=");
        sb.append(this.businessAvatarUrl);
        sb.append(", merchantStatus=");
        sb.append(this.merchantStatus);
        sb.append(", nmid=");
        sb.append(this.nmid);
        sb.append(", pendingBalance=");
        sb.append(this.pendingBalance);
        sb.append(", faceAuthActivated=");
        sb.append(this.faceAuthActivated);
        sb.append(", faceAuthEligible=");
        sb.append(this.faceAuthEligible);
        sb.append(", faceAuthEnrolled=");
        sb.append(this.faceAuthEnrolled);
        sb.append(", freezeFundIn=");
        sb.append(this.freezeFundIn);
        sb.append(", freezeFundOut=");
        sb.append(this.freezeFundOut);
        sb.append(", signedContracts=");
        sb.append(this.signedContracts);
        sb.append(", unsignedContracts=");
        sb.append(this.unsignedContracts);
        sb.append(", usedAmount=");
        sb.append(this.usedAmount);
        sb.append(", limitAmount=");
        sb.append(this.limitAmount);
        sb.append(", urgencyLevel=");
        sb.append(this.urgencyLevel);
        sb.append(')');
        return sb.toString();
    }

    public KybMerchantInfo(String str, String str2, String str3, String str4, MoneyView moneyView, String str5, String str6, String str7, MoneyView moneyView2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List<MerchantContractInfo> list, List<MerchantContractInfo> list2, MoneyView moneyView3, MoneyView moneyView4, String str8) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        Intrinsics.checkNotNullParameter(moneyView4, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.merchantQrCode = str;
        this.merchantName = str2;
        this.merchantType = str3;
        this.merchantId = str4;
        this.balance = moneyView;
        this.businessAvatarUrl = str5;
        this.merchantStatus = str6;
        this.nmid = str7;
        this.pendingBalance = moneyView2;
        this.faceAuthActivated = z;
        this.faceAuthEligible = z2;
        this.faceAuthEnrolled = z3;
        this.freezeFundIn = z4;
        this.freezeFundOut = z5;
        this.signedContracts = list;
        this.unsignedContracts = list2;
        this.usedAmount = moneyView3;
        this.limitAmount = moneyView4;
        this.urgencyLevel = str8;
    }

    @JvmName(name = "getMerchantQrCode")
    public final String getMerchantQrCode() {
        return this.merchantQrCode;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getMerchantType")
    public final String getMerchantType() {
        return this.merchantType;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getBalance")
    public final MoneyView getBalance() {
        return this.balance;
    }

    @JvmName(name = "getBusinessAvatarUrl")
    public final String getBusinessAvatarUrl() {
        return this.businessAvatarUrl;
    }

    @JvmName(name = "getMerchantStatus")
    public final String getMerchantStatus() {
        return this.merchantStatus;
    }

    @JvmName(name = "getNmid")
    public final String getNmid() {
        return this.nmid;
    }

    @JvmName(name = "getPendingBalance")
    public final MoneyView getPendingBalance() {
        return this.pendingBalance;
    }

    @JvmName(name = "getFaceAuthActivated")
    public final boolean getFaceAuthActivated() {
        return this.faceAuthActivated;
    }

    @JvmName(name = "getFaceAuthEligible")
    public final boolean getFaceAuthEligible() {
        return this.faceAuthEligible;
    }

    @JvmName(name = "getFaceAuthEnrolled")
    public final boolean getFaceAuthEnrolled() {
        return this.faceAuthEnrolled;
    }

    @JvmName(name = "getFreezeFundIn")
    public final boolean getFreezeFundIn() {
        return this.freezeFundIn;
    }

    @JvmName(name = "getFreezeFundOut")
    public final boolean getFreezeFundOut() {
        return this.freezeFundOut;
    }

    @JvmName(name = "getSignedContracts")
    public final List<MerchantContractInfo> getSignedContracts() {
        return this.signedContracts;
    }

    @JvmName(name = "getUnsignedContracts")
    public final List<MerchantContractInfo> getUnsignedContracts() {
        return this.unsignedContracts;
    }

    public /* synthetic */ KybMerchantInfo(String str, String str2, String str3, String str4, MoneyView moneyView, String str5, String str6, String str7, MoneyView moneyView2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List list, List list2, MoneyView moneyView3, MoneyView moneyView4, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : moneyView, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : moneyView2, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? false : z2, (i & 2048) != 0 ? false : z3, (i & 4096) != 0 ? false : z4, (i & 8192) != 0 ? false : z5, (i & 16384) != 0 ? null : list, (i & 32768) != 0 ? null : list2, (i & 65536) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView3, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView4, (i & 262144) != 0 ? "" : str8);
    }

    @JvmName(name = "getUsedAmount")
    public final MoneyView getUsedAmount() {
        return this.usedAmount;
    }

    @JvmName(name = "getLimitAmount")
    public final MoneyView getLimitAmount() {
        return this.limitAmount;
    }

    @JvmName(name = "getUrgencyLevel")
    public final String getUrgencyLevel() {
        return this.urgencyLevel;
    }
}
