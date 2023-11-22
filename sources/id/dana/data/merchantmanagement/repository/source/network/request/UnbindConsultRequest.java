package id.dana.data.merchantmanagement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0018"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindConsultRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "clientId", "merchantId", "divisionId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindConsultRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getDivisionId", "setDivisionId", "getMerchantId", "setMerchantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindConsultRequest extends BaseRpcRequest {
    private String clientId;
    private String divisionId;
    private String merchantId;

    public UnbindConsultRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UnbindConsultRequest copy$default(UnbindConsultRequest unbindConsultRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unbindConsultRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = unbindConsultRequest.merchantId;
        }
        if ((i & 4) != 0) {
            str3 = unbindConsultRequest.divisionId;
        }
        return unbindConsultRequest.copy(str, str2, str3);
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

    public final UnbindConsultRequest copy(String clientId, String merchantId, String divisionId) {
        return new UnbindConsultRequest(clientId, merchantId, divisionId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindConsultRequest) {
            UnbindConsultRequest unbindConsultRequest = (UnbindConsultRequest) other;
            return Intrinsics.areEqual(this.clientId, unbindConsultRequest.clientId) && Intrinsics.areEqual(this.merchantId, unbindConsultRequest.merchantId) && Intrinsics.areEqual(this.divisionId, unbindConsultRequest.divisionId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.clientId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.merchantId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.divisionId;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindConsultRequest(clientId=");
        sb.append(this.clientId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UnbindConsultRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "setDivisionId")
    public final void setDivisionId(String str) {
        this.divisionId = str;
    }

    public UnbindConsultRequest(String str, String str2, String str3) {
        this.clientId = str;
        this.merchantId = str2;
        this.divisionId = str3;
    }
}
