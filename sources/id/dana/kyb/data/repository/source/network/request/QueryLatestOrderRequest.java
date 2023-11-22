package id.dana.kyb.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/repository/source/network/request/QueryLatestOrderRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "certificateType", "copy", "(Ljava/lang/String;)Lid/dana/kyb/data/repository/source/network/request/QueryLatestOrderRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCertificateType", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QueryLatestOrderRequest extends BaseRpcRequest {
    private final String certificateType;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QueryLatestOrderRequest() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.repository.source.network.request.QueryLatestOrderRequest.<init>():void");
    }

    public static /* synthetic */ QueryLatestOrderRequest copy$default(QueryLatestOrderRequest queryLatestOrderRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryLatestOrderRequest.certificateType;
        }
        return queryLatestOrderRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCertificateType() {
        return this.certificateType;
    }

    public final QueryLatestOrderRequest copy(String certificateType) {
        Intrinsics.checkNotNullParameter(certificateType, "");
        return new QueryLatestOrderRequest(certificateType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QueryLatestOrderRequest) && Intrinsics.areEqual(this.certificateType, ((QueryLatestOrderRequest) other).certificateType);
    }

    public final int hashCode() {
        return this.certificateType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryLatestOrderRequest(certificateType=");
        sb.append(this.certificateType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryLatestOrderRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "KYB" : str);
    }

    @JvmName(name = "getCertificateType")
    public final String getCertificateType() {
        return this.certificateType;
    }

    public QueryLatestOrderRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.certificateType = str;
    }
}
