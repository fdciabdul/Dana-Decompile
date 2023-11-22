package id.dana.data.paylater.repository.source.network.result;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "assetStatus", "Ljava/lang/String;", "getAssetStatus", "()Ljava/lang/String;", "assetType", "getAssetType", "extendInfo", "getExtendInfo", "", "identFailedCount", "Ljava/lang/Integer;", "getIdentFailedCount", "()Ljava/lang/Integer;", "lockedExpireMins", "getLockedExpireMins", "maxFailedLimit", "getMaxFailedLimit", "orderId", "getOrderId", RecordError.KEY_PUB_KEY, "getPubKey", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "riskResult", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "getRiskResult", "()Lid/dana/data/model/cashier/PayMethodRiskResult;", BioUtilityBridge.SECURITY_ID, "getSecurityId", "serviceInstId", "getServiceInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/cashier/PayMethodRiskResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanRegisterResult extends BaseRpcResultAphome {
    private final String assetStatus;
    private final String assetType;
    private final String extendInfo;
    private final Integer identFailedCount;
    private final Integer lockedExpireMins;
    private final Integer maxFailedLimit;
    private final String orderId;
    private final String pubKey;
    private final PayMethodRiskResult riskResult;
    private final String securityId;
    private final String serviceInstId;

    public /* synthetic */ LoanRegisterResult(String str, String str2, String str3, String str4, PayMethodRiskResult payMethodRiskResult, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, str4, payMethodRiskResult, str5, str6, str7, num, num2, num3);
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

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getRiskResult")
    public final PayMethodRiskResult getRiskResult() {
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
    public final Integer getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final Integer getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "getLockedExpireMins")
    public final Integer getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    public LoanRegisterResult(String str, String str2, String str3, String str4, PayMethodRiskResult payMethodRiskResult, String str5, String str6, String str7, Integer num, Integer num2, Integer num3) {
        this.assetType = str;
        this.serviceInstId = str2;
        this.extendInfo = str3;
        this.securityId = str4;
        this.riskResult = payMethodRiskResult;
        this.orderId = str5;
        this.assetStatus = str6;
        this.pubKey = str7;
        this.identFailedCount = num;
        this.maxFailedLimit = num2;
        this.lockedExpireMins = num3;
    }
}
