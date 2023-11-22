package id.dana.kyb.data.repository.source.network.result;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.animation.ScanQrLoyaltyActivity;
import id.dana.kyb.data.model.MerchantContractInfoResult;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\t\u0012\b\b\u0002\u00100\u001a\u00020\t\u0012\b\b\u0002\u00101\u001a\u00020\t\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bX\u0010YJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0082\u0002\u00105\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\b\u0002\u0010(\u001a\u00020\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010+\u001a\u00020\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\b\b\u0002\u00100\u001a\u00020\t2\b\b\u0002\u00101\u001a\u00020\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:J\u0010\u0010<\u001a\u00020;HÖ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b>\u0010\u0004R\u0017\u0010$\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b$\u0010?\u001a\u0004\b@\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010\u0004R\u001a\u0010/\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010C\u001a\u0004\bD\u0010\u000bR\u001a\u00100\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010C\u001a\u0004\bE\u0010\u000bR\u001a\u00101\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010C\u001a\u0004\bF\u0010\u000bR\u001a\u0010-\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010C\u001a\u0004\bG\u0010\u000bR\u001a\u0010.\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010C\u001a\u0004\bH\u0010\u000bR\u001a\u0010+\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010C\u001a\u0004\bI\u0010\u000bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010A\u001a\u0004\bJ\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010?\u001a\u0004\bK\u0010\bR\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010A\u001a\u0004\bL\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bM\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010A\u001a\u0004\bN\u0010\u0004R\u001a\u0010(\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010A\u001a\u0004\bO\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010A\u001a\u0004\bP\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\bQ\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010?\u001a\u0004\bR\u0010\bR\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010S\u001a\u0004\bT\u0010\u001dR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010S\u001a\u0004\bU\u0010\u001dR\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010A\u001a\u0004\bV\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010?\u001a\u0004\bW\u0010\b"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component11", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "component12", "()Z", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "", "Lid/dana/kyb/data/model/MerchantContractInfoResult;", "component7", "()Ljava/util/List;", "component8", "component9", "merchantQrCode", "merchantName", "merchantType", "merchantId", "balance", "businessAvatarUrl", "signedContracts", "unSignedContracts", "merchantStatus", ScanQrLoyaltyActivity.KEY_NMID, "pendingBalance", "kybLoanAvailable", "kybLoanPartnerName", "freezeFundIn", "freezeFundOut", "faceAuthActivated", "faceAuthEligible", "faceAuthEnrolled", "usedAmount", "limitAmount", "urgencyLevel", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ZLjava/lang/String;ZZZZZLid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getBalance", "Ljava/lang/String;", "getBusinessAvatarUrl", "Z", "getFaceAuthActivated", "getFaceAuthEligible", "getFaceAuthEnrolled", "getFreezeFundIn", "getFreezeFundOut", "getKybLoanAvailable", "getKybLoanPartnerName", "getLimitAmount", "getMerchantId", "getMerchantName", "getMerchantQrCode", "getMerchantStatus", "getMerchantType", "getNmid", "getPendingBalance", "Ljava/util/List;", "getSignedContracts", "getUnSignedContracts", "getUrgencyLevel", "getUsedAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ZLjava/lang/String;ZZZZZLid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybMerchantInfoResult extends BaseRpcResultAphome {
    private final MoneyViewEntity balance;
    private final String businessAvatarUrl;
    private final boolean faceAuthActivated;
    private final boolean faceAuthEligible;
    private final boolean faceAuthEnrolled;
    private final boolean freezeFundIn;
    private final boolean freezeFundOut;
    private final boolean kybLoanAvailable;
    private final String kybLoanPartnerName;
    private final MoneyViewEntity limitAmount;
    private final String merchantId;
    private final String merchantName;
    private final String merchantQrCode;
    private final String merchantStatus;
    private final String merchantType;
    private final String nmid;
    private final MoneyViewEntity pendingBalance;
    private final List<MerchantContractInfoResult> signedContracts;
    private final List<MerchantContractInfoResult> unSignedContracts;
    private final String urgencyLevel;
    private final MoneyViewEntity usedAmount;

    public KybMerchantInfoResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, false, false, false, false, false, null, null, null, 2097151, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantQrCode() {
        return this.merchantQrCode;
    }

    /* renamed from: component10  reason: from getter */
    public final String getNmid() {
        return this.nmid;
    }

    /* renamed from: component11  reason: from getter */
    public final MoneyViewEntity getPendingBalance() {
        return this.pendingBalance;
    }

    /* renamed from: component12  reason: from getter */
    public final boolean getKybLoanAvailable() {
        return this.kybLoanAvailable;
    }

    /* renamed from: component13  reason: from getter */
    public final String getKybLoanPartnerName() {
        return this.kybLoanPartnerName;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getFreezeFundIn() {
        return this.freezeFundIn;
    }

    /* renamed from: component15  reason: from getter */
    public final boolean getFreezeFundOut() {
        return this.freezeFundOut;
    }

    /* renamed from: component16  reason: from getter */
    public final boolean getFaceAuthActivated() {
        return this.faceAuthActivated;
    }

    /* renamed from: component17  reason: from getter */
    public final boolean getFaceAuthEligible() {
        return this.faceAuthEligible;
    }

    /* renamed from: component18  reason: from getter */
    public final boolean getFaceAuthEnrolled() {
        return this.faceAuthEnrolled;
    }

    /* renamed from: component19  reason: from getter */
    public final MoneyViewEntity getUsedAmount() {
        return this.usedAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component20  reason: from getter */
    public final MoneyViewEntity getLimitAmount() {
        return this.limitAmount;
    }

    /* renamed from: component21  reason: from getter */
    public final String getUrgencyLevel() {
        return this.urgencyLevel;
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
    public final MoneyViewEntity getBalance() {
        return this.balance;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBusinessAvatarUrl() {
        return this.businessAvatarUrl;
    }

    public final List<MerchantContractInfoResult> component7() {
        return this.signedContracts;
    }

    public final List<MerchantContractInfoResult> component8() {
        return this.unSignedContracts;
    }

    /* renamed from: component9  reason: from getter */
    public final String getMerchantStatus() {
        return this.merchantStatus;
    }

    public final KybMerchantInfoResult copy(String merchantQrCode, String merchantName, String merchantType, String merchantId, MoneyViewEntity balance, String businessAvatarUrl, List<MerchantContractInfoResult> signedContracts, List<MerchantContractInfoResult> unSignedContracts, String merchantStatus, String nmid, MoneyViewEntity pendingBalance, boolean kybLoanAvailable, String kybLoanPartnerName, boolean freezeFundIn, boolean freezeFundOut, boolean faceAuthActivated, boolean faceAuthEligible, boolean faceAuthEnrolled, MoneyViewEntity usedAmount, MoneyViewEntity limitAmount, String urgencyLevel) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(merchantType, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(balance, "");
        Intrinsics.checkNotNullParameter(merchantStatus, "");
        return new KybMerchantInfoResult(merchantQrCode, merchantName, merchantType, merchantId, balance, businessAvatarUrl, signedContracts, unSignedContracts, merchantStatus, nmid, pendingBalance, kybLoanAvailable, kybLoanPartnerName, freezeFundIn, freezeFundOut, faceAuthActivated, faceAuthEligible, faceAuthEnrolled, usedAmount, limitAmount, urgencyLevel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybMerchantInfoResult) {
            KybMerchantInfoResult kybMerchantInfoResult = (KybMerchantInfoResult) other;
            return Intrinsics.areEqual(this.merchantQrCode, kybMerchantInfoResult.merchantQrCode) && Intrinsics.areEqual(this.merchantName, kybMerchantInfoResult.merchantName) && Intrinsics.areEqual(this.merchantType, kybMerchantInfoResult.merchantType) && Intrinsics.areEqual(this.merchantId, kybMerchantInfoResult.merchantId) && Intrinsics.areEqual(this.balance, kybMerchantInfoResult.balance) && Intrinsics.areEqual(this.businessAvatarUrl, kybMerchantInfoResult.businessAvatarUrl) && Intrinsics.areEqual(this.signedContracts, kybMerchantInfoResult.signedContracts) && Intrinsics.areEqual(this.unSignedContracts, kybMerchantInfoResult.unSignedContracts) && Intrinsics.areEqual(this.merchantStatus, kybMerchantInfoResult.merchantStatus) && Intrinsics.areEqual(this.nmid, kybMerchantInfoResult.nmid) && Intrinsics.areEqual(this.pendingBalance, kybMerchantInfoResult.pendingBalance) && this.kybLoanAvailable == kybMerchantInfoResult.kybLoanAvailable && Intrinsics.areEqual(this.kybLoanPartnerName, kybMerchantInfoResult.kybLoanPartnerName) && this.freezeFundIn == kybMerchantInfoResult.freezeFundIn && this.freezeFundOut == kybMerchantInfoResult.freezeFundOut && this.faceAuthActivated == kybMerchantInfoResult.faceAuthActivated && this.faceAuthEligible == kybMerchantInfoResult.faceAuthEligible && this.faceAuthEnrolled == kybMerchantInfoResult.faceAuthEnrolled && Intrinsics.areEqual(this.usedAmount, kybMerchantInfoResult.usedAmount) && Intrinsics.areEqual(this.limitAmount, kybMerchantInfoResult.limitAmount) && Intrinsics.areEqual(this.urgencyLevel, kybMerchantInfoResult.urgencyLevel);
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
        int hashCode5 = this.balance.hashCode();
        String str2 = this.businessAvatarUrl;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        List<MerchantContractInfoResult> list = this.signedContracts;
        int hashCode7 = list == null ? 0 : list.hashCode();
        List<MerchantContractInfoResult> list2 = this.unSignedContracts;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        int hashCode9 = this.merchantStatus.hashCode();
        String str3 = this.nmid;
        int hashCode10 = str3 == null ? 0 : str3.hashCode();
        MoneyViewEntity moneyViewEntity = this.pendingBalance;
        int hashCode11 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        boolean z = this.kybLoanAvailable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str4 = this.kybLoanPartnerName;
        int hashCode12 = str4 == null ? 0 : str4.hashCode();
        boolean z2 = this.freezeFundIn;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.freezeFundOut;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        boolean z4 = this.faceAuthActivated;
        int i4 = z4 ? 1 : z4 ? 1 : 0;
        boolean z5 = this.faceAuthEligible;
        int i5 = z5 ? 1 : z5 ? 1 : 0;
        boolean z6 = this.faceAuthEnrolled;
        int i6 = !z6 ? z6 ? 1 : 0 : 1;
        MoneyViewEntity moneyViewEntity2 = this.usedAmount;
        int hashCode13 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.limitAmount;
        int hashCode14 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        String str5 = this.urgencyLevel;
        return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + i) * 31) + hashCode12) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybMerchantInfoResult(merchantQrCode=");
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
        sb.append(", signedContracts=");
        sb.append(this.signedContracts);
        sb.append(", unSignedContracts=");
        sb.append(this.unSignedContracts);
        sb.append(", merchantStatus=");
        sb.append(this.merchantStatus);
        sb.append(", nmid=");
        sb.append(this.nmid);
        sb.append(", pendingBalance=");
        sb.append(this.pendingBalance);
        sb.append(", kybLoanAvailable=");
        sb.append(this.kybLoanAvailable);
        sb.append(", kybLoanPartnerName=");
        sb.append(this.kybLoanPartnerName);
        sb.append(", freezeFundIn=");
        sb.append(this.freezeFundIn);
        sb.append(", freezeFundOut=");
        sb.append(this.freezeFundOut);
        sb.append(", faceAuthActivated=");
        sb.append(this.faceAuthActivated);
        sb.append(", faceAuthEligible=");
        sb.append(this.faceAuthEligible);
        sb.append(", faceAuthEnrolled=");
        sb.append(this.faceAuthEnrolled);
        sb.append(", usedAmount=");
        sb.append(this.usedAmount);
        sb.append(", limitAmount=");
        sb.append(this.limitAmount);
        sb.append(", urgencyLevel=");
        sb.append(this.urgencyLevel);
        sb.append(')');
        return sb.toString();
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

    public /* synthetic */ KybMerchantInfoResult(String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity, String str5, List list, List list2, String str6, String str7, MoneyViewEntity moneyViewEntity2, boolean z, String str8, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : list2, (i & 256) == 0 ? str6 : "", (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : moneyViewEntity2, (i & 2048) != 0 ? false : z, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? false : z2, (i & 16384) != 0 ? false : z3, (i & 32768) != 0 ? false : z4, (i & 65536) != 0 ? false : z5, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z6, (i & 262144) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity3, (i & 524288) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity4, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str9);
    }

    @JvmName(name = "getBalance")
    public final MoneyViewEntity getBalance() {
        return this.balance;
    }

    @JvmName(name = "getBusinessAvatarUrl")
    public final String getBusinessAvatarUrl() {
        return this.businessAvatarUrl;
    }

    @JvmName(name = "getSignedContracts")
    public final List<MerchantContractInfoResult> getSignedContracts() {
        return this.signedContracts;
    }

    @JvmName(name = "getUnSignedContracts")
    public final List<MerchantContractInfoResult> getUnSignedContracts() {
        return this.unSignedContracts;
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
    public final MoneyViewEntity getPendingBalance() {
        return this.pendingBalance;
    }

    @JvmName(name = "getKybLoanAvailable")
    public final boolean getKybLoanAvailable() {
        return this.kybLoanAvailable;
    }

    @JvmName(name = "getKybLoanPartnerName")
    public final String getKybLoanPartnerName() {
        return this.kybLoanPartnerName;
    }

    @JvmName(name = "getFreezeFundIn")
    public final boolean getFreezeFundIn() {
        return this.freezeFundIn;
    }

    @JvmName(name = "getFreezeFundOut")
    public final boolean getFreezeFundOut() {
        return this.freezeFundOut;
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

    @JvmName(name = "getUsedAmount")
    public final MoneyViewEntity getUsedAmount() {
        return this.usedAmount;
    }

    @JvmName(name = "getLimitAmount")
    public final MoneyViewEntity getLimitAmount() {
        return this.limitAmount;
    }

    @JvmName(name = "getUrgencyLevel")
    public final String getUrgencyLevel() {
        return this.urgencyLevel;
    }

    public KybMerchantInfoResult(String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity, String str5, List<MerchantContractInfoResult> list, List<MerchantContractInfoResult> list2, String str6, String str7, MoneyViewEntity moneyViewEntity2, boolean z, String str8, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, String str9) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.merchantQrCode = str;
        this.merchantName = str2;
        this.merchantType = str3;
        this.merchantId = str4;
        this.balance = moneyViewEntity;
        this.businessAvatarUrl = str5;
        this.signedContracts = list;
        this.unSignedContracts = list2;
        this.merchantStatus = str6;
        this.nmid = str7;
        this.pendingBalance = moneyViewEntity2;
        this.kybLoanAvailable = z;
        this.kybLoanPartnerName = str8;
        this.freezeFundIn = z2;
        this.freezeFundOut = z3;
        this.faceAuthActivated = z4;
        this.faceAuthEligible = z5;
        this.faceAuthEnrolled = z6;
        this.usedAmount = moneyViewEntity3;
        this.limitAmount = moneyViewEntity4;
        this.urgencyLevel = str9;
    }
}
