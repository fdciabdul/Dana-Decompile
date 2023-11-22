package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004Jp\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "fundType", "fundOrderId", "version", "amount", "payMethod", "transferMethod", "transferScenario", "remarks", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getFundOrderId", "getFundType", "getPayMethod", "getRemarks", "getTransferMethod", "getTransferScenario", "getVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ApproveSendMoneyRequest {
    private final String amount;
    private final String fundOrderId;
    private final String fundType;
    private final String payMethod;
    private final String remarks;
    private final String transferMethod;
    private final String transferScenario;
    private final String version;

    public ApproveSendMoneyRequest() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getFundType() {
        return this.fundType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTransferScenario() {
        return this.transferScenario;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    public final ApproveSendMoneyRequest copy(String fundType, String fundOrderId, String version, String amount, String payMethod, String transferMethod, String transferScenario, String remarks) {
        return new ApproveSendMoneyRequest(fundType, fundOrderId, version, amount, payMethod, transferMethod, transferScenario, remarks);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ApproveSendMoneyRequest) {
            ApproveSendMoneyRequest approveSendMoneyRequest = (ApproveSendMoneyRequest) other;
            return Intrinsics.areEqual(this.fundType, approveSendMoneyRequest.fundType) && Intrinsics.areEqual(this.fundOrderId, approveSendMoneyRequest.fundOrderId) && Intrinsics.areEqual(this.version, approveSendMoneyRequest.version) && Intrinsics.areEqual(this.amount, approveSendMoneyRequest.amount) && Intrinsics.areEqual(this.payMethod, approveSendMoneyRequest.payMethod) && Intrinsics.areEqual(this.transferMethod, approveSendMoneyRequest.transferMethod) && Intrinsics.areEqual(this.transferScenario, approveSendMoneyRequest.transferScenario) && Intrinsics.areEqual(this.remarks, approveSendMoneyRequest.remarks);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.fundType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.fundOrderId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.version;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.amount;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.payMethod;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.transferMethod;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.transferScenario;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.remarks;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApproveSendMoneyRequest(fundType=");
        sb.append(this.fundType);
        sb.append(", fundOrderId=");
        sb.append(this.fundOrderId);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", transferMethod=");
        sb.append(this.transferMethod);
        sb.append(", transferScenario=");
        sb.append(this.transferScenario);
        sb.append(", remarks=");
        sb.append(this.remarks);
        sb.append(')');
        return sb.toString();
    }

    public ApproveSendMoneyRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.fundType = str;
        this.fundOrderId = str2;
        this.version = str3;
        this.amount = str4;
        this.payMethod = str5;
        this.transferMethod = str6;
        this.transferScenario = str7;
        this.remarks = str8;
    }

    public /* synthetic */ ApproveSendMoneyRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? str8 : null);
    }

    @JvmName(name = "getFundType")
    public final String getFundType() {
        return this.fundType;
    }

    @JvmName(name = "getFundOrderId")
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    @JvmName(name = "getVersion")
    public final String getVersion() {
        return this.version;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getTransferScenario")
    public final String getTransferScenario() {
        return this.transferScenario;
    }

    @JvmName(name = "getRemarks")
    public final String getRemarks() {
        return this.remarks;
    }
}
