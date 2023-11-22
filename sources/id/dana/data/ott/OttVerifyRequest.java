package id.dana.data.ott;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005R\"\u0010\u0006\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/ott/OttVerifyRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "ottValue", "copy", "(Ljava/lang/String;)Lid/dana/data/ott/OttVerifyRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getOttValue", "setOttValue", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OttVerifyRequest extends BaseRpcRequest implements Serializable {
    private String ottValue;

    public static /* synthetic */ OttVerifyRequest copy$default(OttVerifyRequest ottVerifyRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ottVerifyRequest.ottValue;
        }
        return ottVerifyRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getOttValue() {
        return this.ottValue;
    }

    public final OttVerifyRequest copy(String ottValue) {
        Intrinsics.checkNotNullParameter(ottValue, "");
        return new OttVerifyRequest(ottValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OttVerifyRequest) && Intrinsics.areEqual(this.ottValue, ((OttVerifyRequest) other).ottValue);
    }

    public final int hashCode() {
        return this.ottValue.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OttVerifyRequest(ottValue=");
        sb.append(this.ottValue);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getOttValue")
    public final String getOttValue() {
        return this.ottValue;
    }

    @JvmName(name = "setOttValue")
    public final void setOttValue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.ottValue = str;
    }

    public OttVerifyRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.ottValue = str;
    }
}
