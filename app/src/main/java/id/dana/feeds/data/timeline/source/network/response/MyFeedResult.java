package id.dana.feeds.data.timeline.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\f"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "", "Lid/dana/feeds/data/timeline/source/network/response/ActivityResult;", "component4", "()Ljava/util/List;", "hasMore", "maxId", "minId", "notifications", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasMore", "Ljava/lang/String;", "getMaxId", "getMinId", "Ljava/util/List;", "getNotifications", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyFeedResult extends BaseRpcResult {
    private final boolean hasMore;
    private final String maxId;
    private final String minId;
    private final List<ActivityResult> notifications;

    public MyFeedResult() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyFeedResult copy$default(MyFeedResult myFeedResult, boolean z, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = myFeedResult.hasMore;
        }
        if ((i & 2) != 0) {
            str = myFeedResult.maxId;
        }
        if ((i & 4) != 0) {
            str2 = myFeedResult.minId;
        }
        if ((i & 8) != 0) {
            list = myFeedResult.notifications;
        }
        return myFeedResult.copy(z, str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMinId() {
        return this.minId;
    }

    public final List<ActivityResult> component4() {
        return this.notifications;
    }

    public final MyFeedResult copy(boolean hasMore, String maxId, String minId, List<ActivityResult> notifications) {
        Intrinsics.checkNotNullParameter(notifications, "");
        return new MyFeedResult(hasMore, maxId, minId, notifications);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyFeedResult) {
            MyFeedResult myFeedResult = (MyFeedResult) other;
            return this.hasMore == myFeedResult.hasMore && Intrinsics.areEqual(this.maxId, myFeedResult.maxId) && Intrinsics.areEqual(this.minId, myFeedResult.minId) && Intrinsics.areEqual(this.notifications, myFeedResult.notifications);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.maxId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.minId;
        return (((((r0 * 31) + hashCode) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + this.notifications.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyFeedResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", minId=");
        sb.append(this.minId);
        sb.append(", notifications=");
        sb.append(this.notifications);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    public /* synthetic */ MyFeedResult(boolean z, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getNotifications")
    public final List<ActivityResult> getNotifications() {
        return this.notifications;
    }

    public MyFeedResult(boolean z, String str, String str2, List<ActivityResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.maxId = str;
        this.minId = str2;
        this.notifications = list;
    }
}
