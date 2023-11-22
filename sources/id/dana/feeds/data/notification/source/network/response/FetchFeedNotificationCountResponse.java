package id.dana.feeds.data.notification.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/notification/source/network/response/FetchFeedNotificationCountResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()I", "notificationCount", "copy", "(I)Lid/dana/feeds/data/notification/source/network/response/FetchFeedNotificationCountResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getNotificationCount", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FetchFeedNotificationCountResponse extends BaseRpcResult {
    private final int notificationCount;

    public FetchFeedNotificationCountResponse() {
        this(0, 1, null);
    }

    public static /* synthetic */ FetchFeedNotificationCountResponse copy$default(FetchFeedNotificationCountResponse fetchFeedNotificationCountResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fetchFeedNotificationCountResponse.notificationCount;
        }
        return fetchFeedNotificationCountResponse.copy(i);
    }

    /* renamed from: component1  reason: from getter */
    public final int getNotificationCount() {
        return this.notificationCount;
    }

    public final FetchFeedNotificationCountResponse copy(int notificationCount) {
        return new FetchFeedNotificationCountResponse(notificationCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FetchFeedNotificationCountResponse) && this.notificationCount == ((FetchFeedNotificationCountResponse) other).notificationCount;
    }

    public final int hashCode() {
        return this.notificationCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchFeedNotificationCountResponse(notificationCount=");
        sb.append(this.notificationCount);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ FetchFeedNotificationCountResponse(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @JvmName(name = "getNotificationCount")
    public final int getNotificationCount() {
        return this.notificationCount;
    }

    public FetchFeedNotificationCountResponse(int i) {
        this.notificationCount = i;
    }
}
