package id.dana.data.electronicmoney.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "", "component1", "()Ljava/util/Map;", "data", "copy", "(Ljava/util/Map;)Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getData", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EmoneyReversalResponse extends BaseRpcResult {
    private final Map<String, String> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmoneyReversalResponse copy$default(EmoneyReversalResponse emoneyReversalResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = emoneyReversalResponse.data;
        }
        return emoneyReversalResponse.copy(map);
    }

    public final Map<String, String> component1() {
        return this.data;
    }

    public final EmoneyReversalResponse copy(Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "");
        return new EmoneyReversalResponse(data);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmoneyReversalResponse) && Intrinsics.areEqual(this.data, ((EmoneyReversalResponse) other).data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmoneyReversalResponse(data=");
        sb.append(this.data);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getData")
    public final Map<String, String> getData() {
        return this.data;
    }

    public EmoneyReversalResponse(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.data = map;
    }
}
