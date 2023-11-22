package id.dana.data.merchantmanagement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\\\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "clientId", "merchantId", "divisionId", "validateData", BioUtilityBridge.SECURITY_ID, "unbindEligibilityCheckId", "userBoundId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "getDivisionId", "getMerchantId", "getSecurityId", "getUnbindEligibilityCheckId", "getUserBoundId", "getValidateData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindMerchantRequest extends BaseRpcRequest {
    private final String clientId;
    private final String divisionId;
    private final String merchantId;
    private final String securityId;
    private final String unbindEligibilityCheckId;
    private final String userBoundId;
    private final String validateData;

    public static /* synthetic */ UnbindMerchantRequest copy$default(UnbindMerchantRequest unbindMerchantRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unbindMerchantRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = unbindMerchantRequest.merchantId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = unbindMerchantRequest.divisionId;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = unbindMerchantRequest.validateData;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = unbindMerchantRequest.securityId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = unbindMerchantRequest.unbindEligibilityCheckId;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = unbindMerchantRequest.userBoundId;
        }
        return unbindMerchantRequest.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDivisionId() {
        return this.divisionId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getUnbindEligibilityCheckId() {
        return this.unbindEligibilityCheckId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getUserBoundId() {
        return this.userBoundId;
    }

    public final UnbindMerchantRequest copy(String clientId, String merchantId, String divisionId, String validateData, String securityId, String unbindEligibilityCheckId, String userBoundId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(validateData, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        return new UnbindMerchantRequest(clientId, merchantId, divisionId, validateData, securityId, unbindEligibilityCheckId, userBoundId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindMerchantRequest) {
            UnbindMerchantRequest unbindMerchantRequest = (UnbindMerchantRequest) other;
            return Intrinsics.areEqual(this.clientId, unbindMerchantRequest.clientId) && Intrinsics.areEqual(this.merchantId, unbindMerchantRequest.merchantId) && Intrinsics.areEqual(this.divisionId, unbindMerchantRequest.divisionId) && Intrinsics.areEqual(this.validateData, unbindMerchantRequest.validateData) && Intrinsics.areEqual(this.securityId, unbindMerchantRequest.securityId) && Intrinsics.areEqual(this.unbindEligibilityCheckId, unbindMerchantRequest.unbindEligibilityCheckId) && Intrinsics.areEqual(this.userBoundId, unbindMerchantRequest.userBoundId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.clientId.hashCode();
        int hashCode2 = this.merchantId.hashCode();
        String str = this.divisionId;
        int hashCode3 = str == null ? 0 : str.hashCode();
        int hashCode4 = this.validateData.hashCode();
        int hashCode5 = this.securityId.hashCode();
        String str2 = this.unbindEligibilityCheckId;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.userBoundId;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindMerchantRequest(clientId=");
        sb.append(this.clientId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", unbindEligibilityCheckId=");
        sb.append(this.unbindEligibilityCheckId);
        sb.append(", userBoundId=");
        sb.append(this.userBoundId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getUnbindEligibilityCheckId")
    public final String getUnbindEligibilityCheckId() {
        return this.unbindEligibilityCheckId;
    }

    @JvmName(name = "getUserBoundId")
    public final String getUserBoundId() {
        return this.userBoundId;
    }

    public UnbindMerchantRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.clientId = str;
        this.merchantId = str2;
        this.divisionId = str3;
        this.validateData = str4;
        this.securityId = str5;
        this.unbindEligibilityCheckId = str6;
        this.userBoundId = str7;
    }
}
