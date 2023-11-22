package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", BioUtilityBridge.SECURITY_ID, "validateData", "sendStrategy", "phoneNumber", CashierKeyParams.CASHIER_ORDER_ID, "verifyExtendData", "verifyScene", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCashierOrderId", "getPhoneNumber", "getSecurityId", "getSendStrategy", "getValidateData", "getVerifyExtendData", "getVerifyScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAgreementEntityRequest extends BaseRpcRequest {
    private final String cashierOrderId;
    private final String phoneNumber;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    private final String sendStrategy;
    private final String validateData;
    private final String verifyExtendData;
    private final String verifyScene;

    public static /* synthetic */ CashierAgreementEntityRequest copy$default(CashierAgreementEntityRequest cashierAgreementEntityRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierAgreementEntityRequest.securityId;
        }
        if ((i & 2) != 0) {
            str2 = cashierAgreementEntityRequest.validateData;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = cashierAgreementEntityRequest.sendStrategy;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = cashierAgreementEntityRequest.phoneNumber;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = cashierAgreementEntityRequest.cashierOrderId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = cashierAgreementEntityRequest.verifyExtendData;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = cashierAgreementEntityRequest.verifyScene;
        }
        return cashierAgreementEntityRequest.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getVerifyExtendData() {
        return this.verifyExtendData;
    }

    /* renamed from: component7  reason: from getter */
    public final String getVerifyScene() {
        return this.verifyScene;
    }

    public final CashierAgreementEntityRequest copy(String securityId, String validateData, String sendStrategy, String phoneNumber, String cashierOrderId, String verifyExtendData, String verifyScene) {
        return new CashierAgreementEntityRequest(securityId, validateData, sendStrategy, phoneNumber, cashierOrderId, verifyExtendData, verifyScene);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAgreementEntityRequest) {
            CashierAgreementEntityRequest cashierAgreementEntityRequest = (CashierAgreementEntityRequest) other;
            return Intrinsics.areEqual(this.securityId, cashierAgreementEntityRequest.securityId) && Intrinsics.areEqual(this.validateData, cashierAgreementEntityRequest.validateData) && Intrinsics.areEqual(this.sendStrategy, cashierAgreementEntityRequest.sendStrategy) && Intrinsics.areEqual(this.phoneNumber, cashierAgreementEntityRequest.phoneNumber) && Intrinsics.areEqual(this.cashierOrderId, cashierAgreementEntityRequest.cashierOrderId) && Intrinsics.areEqual(this.verifyExtendData, cashierAgreementEntityRequest.verifyExtendData) && Intrinsics.areEqual(this.verifyScene, cashierAgreementEntityRequest.verifyScene);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.securityId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.validateData;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.sendStrategy;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.phoneNumber;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cashierOrderId;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.verifyExtendData;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.verifyScene;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAgreementEntityRequest(securityId=");
        sb.append(this.securityId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", sendStrategy=");
        sb.append(this.sendStrategy);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", verifyExtendData=");
        sb.append(this.verifyExtendData);
        sb.append(", verifyScene=");
        sb.append(this.verifyScene);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getVerifyExtendData")
    public final String getVerifyExtendData() {
        return this.verifyExtendData;
    }

    @JvmName(name = "getVerifyScene")
    public final String getVerifyScene() {
        return this.verifyScene;
    }

    public CashierAgreementEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.securityId = str;
        this.validateData = str2;
        this.sendStrategy = str3;
        this.phoneNumber = str4;
        this.cashierOrderId = str5;
        this.verifyExtendData = str6;
        this.verifyScene = str7;
    }
}
