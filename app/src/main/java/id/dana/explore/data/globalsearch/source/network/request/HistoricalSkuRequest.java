package id.dana.explore.data.globalsearch.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/HistoricalSkuRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "profileKeys", "profileKeyMaxResult", "copy", "(Ljava/util/List;I)Lid/dana/explore/data/globalsearch/source/network/request/HistoricalSkuRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "I", "getProfileKeyMaxResult", "Ljava/util/List;", "getProfileKeys", "<init>", "(Ljava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HistoricalSkuRequest extends BaseRpcRequest {
    private final int profileKeyMaxResult;
    private final List<String> profileKeys;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HistoricalSkuRequest copy$default(HistoricalSkuRequest historicalSkuRequest, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = historicalSkuRequest.profileKeys;
        }
        if ((i2 & 2) != 0) {
            i = historicalSkuRequest.profileKeyMaxResult;
        }
        return historicalSkuRequest.copy(list, i);
    }

    public final List<String> component1() {
        return this.profileKeys;
    }

    /* renamed from: component2  reason: from getter */
    public final int getProfileKeyMaxResult() {
        return this.profileKeyMaxResult;
    }

    public final HistoricalSkuRequest copy(List<String> profileKeys, int profileKeyMaxResult) {
        Intrinsics.checkNotNullParameter(profileKeys, "");
        return new HistoricalSkuRequest(profileKeys, profileKeyMaxResult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HistoricalSkuRequest) {
            HistoricalSkuRequest historicalSkuRequest = (HistoricalSkuRequest) other;
            return Intrinsics.areEqual(this.profileKeys, historicalSkuRequest.profileKeys) && this.profileKeyMaxResult == historicalSkuRequest.profileKeyMaxResult;
        }
        return false;
    }

    public final int hashCode() {
        return (this.profileKeys.hashCode() * 31) + this.profileKeyMaxResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HistoricalSkuRequest(profileKeys=");
        sb.append(this.profileKeys);
        sb.append(", profileKeyMaxResult=");
        sb.append(this.profileKeyMaxResult);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ HistoricalSkuRequest(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 1 : i);
    }

    @JvmName(name = "getProfileKeys")
    public final List<String> getProfileKeys() {
        return this.profileKeys;
    }

    @JvmName(name = "getProfileKeyMaxResult")
    public final int getProfileKeyMaxResult() {
        return this.profileKeyMaxResult;
    }

    public HistoricalSkuRequest(List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.profileKeys = list;
        this.profileKeyMaxResult = i;
    }
}
