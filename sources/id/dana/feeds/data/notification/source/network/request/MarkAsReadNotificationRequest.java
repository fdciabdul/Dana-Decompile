package id.dana.feeds.data.notification.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/feeds/data/notification/source/network/request/MarkAsReadNotificationRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "", "component1", "()Ljava/util/List;", "ids", "copy", "(Ljava/util/List;)Lid/dana/feeds/data/notification/source/network/request/MarkAsReadNotificationRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getIds", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MarkAsReadNotificationRequest extends BaseRpcRequest {
    private final List<String> ids;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkAsReadNotificationRequest copy$default(MarkAsReadNotificationRequest markAsReadNotificationRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = markAsReadNotificationRequest.ids;
        }
        return markAsReadNotificationRequest.copy(list);
    }

    public final List<String> component1() {
        return this.ids;
    }

    public final MarkAsReadNotificationRequest copy(List<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "");
        return new MarkAsReadNotificationRequest(ids);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MarkAsReadNotificationRequest) && Intrinsics.areEqual(this.ids, ((MarkAsReadNotificationRequest) other).ids);
    }

    public final int hashCode() {
        return this.ids.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MarkAsReadNotificationRequest(ids=");
        sb.append(this.ids);
        sb.append(')');
        return sb.toString();
    }

    public MarkAsReadNotificationRequest(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.ids = list;
    }

    @JvmName(name = "getIds")
    public final List<String> getIds() {
        return this.ids;
    }
}
