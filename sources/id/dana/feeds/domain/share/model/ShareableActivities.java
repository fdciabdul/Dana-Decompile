package id.dana.feeds.domain.share.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/feeds/domain/share/model/ShareableActivities;", "", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "maxId", "Ljava/lang/String;", "getMaxId", "()Ljava/lang/String;", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "shareableActivities", "Ljava/util/List;", "getShareableActivities", "()Ljava/util/List;", "setShareableActivities", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareableActivities {
    private final Boolean hasMore;
    private final String maxId;
    private List<PreviewActivityData> shareableActivities;

    public ShareableActivities() {
        this(null, null, null, 7, null);
    }

    public ShareableActivities(String str, Boolean bool, List<PreviewActivityData> list) {
        this.maxId = str;
        this.hasMore = bool;
        this.shareableActivities = list;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    public /* synthetic */ ShareableActivities(String str, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getShareableActivities")
    public final List<PreviewActivityData> getShareableActivities() {
        return this.shareableActivities;
    }

    @JvmName(name = "setShareableActivities")
    public final void setShareableActivities(List<PreviewActivityData> list) {
        this.shareableActivities = list;
    }
}
