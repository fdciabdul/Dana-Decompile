package id.dana.cashier.domain.model.paylater;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.model.cashier.PayMethodRisk;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u001a8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/paylater/LoanRegisterResultInfo;", "", "", "assetStatus", "Ljava/lang/String;", "getAssetStatus", "()Ljava/lang/String;", "assetType", "getAssetType", "extendInfo", "getExtendInfo", "setExtendInfo", "(Ljava/lang/String;)V", "", "identFailedCount", "I", "getIdentFailedCount", "()I", "lockedExpireMins", "getLockedExpireMins", "maxFailedLimit", "getMaxFailedLimit", "orderId", "getOrderId", RecordError.KEY_PUB_KEY, "getPubKey", "Lid/dana/domain/model/cashier/PayMethodRisk;", "riskResult", "Lid/dana/domain/model/cashier/PayMethodRisk;", "getRiskResult", "()Lid/dana/domain/model/cashier/PayMethodRisk;", BioUtilityBridge.SECURITY_ID, "getSecurityId", "serviceInstId", "getServiceInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/model/cashier/PayMethodRisk;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanRegisterResultInfo {
    private final String assetStatus;
    private final String assetType;
    private String extendInfo;
    private final int identFailedCount;
    private final int lockedExpireMins;
    private final int maxFailedLimit;
    private final String orderId;
    private final String pubKey;
    private final PayMethodRisk riskResult;
    private final String securityId;
    private final String serviceInstId;

    public LoanRegisterResultInfo(String str, String str2, String str3, String str4, PayMethodRisk payMethodRisk, String str5, String str6, String str7, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(payMethodRisk, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.assetType = str;
        this.serviceInstId = str2;
        this.extendInfo = str3;
        this.securityId = str4;
        this.riskResult = payMethodRisk;
        this.orderId = str5;
        this.assetStatus = str6;
        this.pubKey = str7;
        this.identFailedCount = i;
        this.maxFailedLimit = i2;
        this.lockedExpireMins = i3;
    }

    public /* synthetic */ LoanRegisterResultInfo(String str, String str2, String str3, String str4, PayMethodRisk payMethodRisk, String str5, String str6, String str7, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? "" : str3, str4, payMethodRisk, str5, str6, str7, i, i2, i3);
    }

    @JvmName(name = "getAssetType")
    public final String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getServiceInstId")
    public final String getServiceInstId() {
        return this.serviceInstId;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.extendInfo = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getRiskResult")
    public final PayMethodRisk getRiskResult() {
        return this.riskResult;
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    @JvmName(name = "getAssetStatus")
    public final String getAssetStatus() {
        return this.assetStatus;
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "getIdentFailedCount")
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final int getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "getLockedExpireMins")
    public final int getLockedExpireMins() {
        return this.lockedExpireMins;
    }
}
