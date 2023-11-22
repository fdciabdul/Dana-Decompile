package id.dana.data.merchantmanagement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindEligibilityCheckRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "clientId", "merchantId", "divisionId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindEligibilityCheckRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "getDivisionId", "getMerchantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindEligibilityCheckRequest extends BaseRpcRequest {
    private final String clientId;
    private final String divisionId;
    private final String merchantId;

    public static /* synthetic */ UnbindEligibilityCheckRequest copy$default(UnbindEligibilityCheckRequest unbindEligibilityCheckRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unbindEligibilityCheckRequest.clientId;
        }
        if ((i & 2) != 0) {
            str2 = unbindEligibilityCheckRequest.merchantId;
        }
        if ((i & 4) != 0) {
            str3 = unbindEligibilityCheckRequest.divisionId;
        }
        return unbindEligibilityCheckRequest.copy(str, str2, str3);
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

    public final UnbindEligibilityCheckRequest copy(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        return new UnbindEligibilityCheckRequest(clientId, merchantId, divisionId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindEligibilityCheckRequest) {
            UnbindEligibilityCheckRequest unbindEligibilityCheckRequest = (UnbindEligibilityCheckRequest) other;
            return Intrinsics.areEqual(this.clientId, unbindEligibilityCheckRequest.clientId) && Intrinsics.areEqual(this.merchantId, unbindEligibilityCheckRequest.merchantId) && Intrinsics.areEqual(this.divisionId, unbindEligibilityCheckRequest.divisionId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.clientId.hashCode();
        int hashCode2 = this.merchantId.hashCode();
        String str = this.divisionId;
        return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindEligibilityCheckRequest(clientId=");
        sb.append(this.clientId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UnbindEligibilityCheckRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
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

    public UnbindEligibilityCheckRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.clientId = str;
        this.merchantId = str2;
        this.divisionId = str3;
    }
}
