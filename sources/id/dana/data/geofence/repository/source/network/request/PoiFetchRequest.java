package id.dana.data.geofence.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/data/geofence/repository/source/network/request/PoiFetchRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "location", "copy", "(Ljava/lang/String;)Lid/dana/data/geofence/repository/source/network/request/PoiFetchRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getLocation", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PoiFetchRequest extends BaseRpcRequest implements Serializable {
    private final String location;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PoiFetchRequest() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.geofence.repository.source.network.request.PoiFetchRequest.<init>():void");
    }

    public static /* synthetic */ PoiFetchRequest copy$default(PoiFetchRequest poiFetchRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = poiFetchRequest.location;
        }
        return poiFetchRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final PoiFetchRequest copy(String location) {
        Intrinsics.checkNotNullParameter(location, "");
        return new PoiFetchRequest(location);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PoiFetchRequest) && Intrinsics.areEqual(this.location, ((PoiFetchRequest) other).location);
    }

    public final int hashCode() {
        return this.location.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiFetchRequest(location=");
        sb.append(this.location);
        sb.append(')');
        return sb.toString();
    }

    public PoiFetchRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.location = str;
    }

    public /* synthetic */ PoiFetchRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }
}
