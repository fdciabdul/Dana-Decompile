package id.dana.feeds.data.activation.source.network.request;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/activation/source/network/request/InitFeedRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "", "component2", "()J", "totalPhoneContactSize", "lastFetchTime", "copy", "(IJ)Lid/dana/feeds/data/activation/source/network/request/InitFeedRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "J", "getLastFetchTime", "I", "getTotalPhoneContactSize", "<init>", "(IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InitFeedRequest extends BaseRpcRequest {
    private final long lastFetchTime;
    private final int totalPhoneContactSize;

    public static /* synthetic */ InitFeedRequest copy$default(InitFeedRequest initFeedRequest, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = initFeedRequest.totalPhoneContactSize;
        }
        if ((i2 & 2) != 0) {
            j = initFeedRequest.lastFetchTime;
        }
        return initFeedRequest.copy(i, j);
    }

    /* renamed from: component1  reason: from getter */
    public final int getTotalPhoneContactSize() {
        return this.totalPhoneContactSize;
    }

    /* renamed from: component2  reason: from getter */
    public final long getLastFetchTime() {
        return this.lastFetchTime;
    }

    public final InitFeedRequest copy(int totalPhoneContactSize, long lastFetchTime) {
        return new InitFeedRequest(totalPhoneContactSize, lastFetchTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InitFeedRequest) {
            InitFeedRequest initFeedRequest = (InitFeedRequest) other;
            return this.totalPhoneContactSize == initFeedRequest.totalPhoneContactSize && this.lastFetchTime == initFeedRequest.lastFetchTime;
        }
        return false;
    }

    public final int hashCode() {
        return (this.totalPhoneContactSize * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.lastFetchTime);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InitFeedRequest(totalPhoneContactSize=");
        sb.append(this.totalPhoneContactSize);
        sb.append(", lastFetchTime=");
        sb.append(this.lastFetchTime);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ InitFeedRequest(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 0L : j);
    }

    @JvmName(name = "getTotalPhoneContactSize")
    public final int getTotalPhoneContactSize() {
        return this.totalPhoneContactSize;
    }

    @JvmName(name = "getLastFetchTime")
    public final long getLastFetchTime() {
        return this.lastFetchTime;
    }

    public InitFeedRequest(int i, long j) {
        this.totalPhoneContactSize = i;
        this.lastFetchTime = j;
    }
}
