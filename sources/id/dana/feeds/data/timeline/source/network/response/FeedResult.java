package id.dana.feeds.data.timeline.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJb\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000fJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0007R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\fR\u001a\u0010\u0016\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u000fR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b$\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b)\u0010\u0007"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "component3", "", "Lid/dana/feeds/data/timeline/source/network/response/ActivityResult;", "component4", "()Ljava/util/List;", "", "component5", "()I", "Lid/dana/feeds/data/timeline/source/network/response/GroupedActivityResult;", "component6", "hasMore", "maxId", "minId", "activities", "feedVersion", "groupedActivities", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;)Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getActivities", "I", "getFeedVersion", "getGroupedActivities", "Ljava/lang/Boolean;", "getHasMore", "Ljava/lang/String;", "getMaxId", "getMinId", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedResult extends BaseRpcResult {
    private final List<ActivityResult> activities;
    private final int feedVersion;
    private final List<GroupedActivityResult> groupedActivities;
    private final Boolean hasMore;
    private final String maxId;
    private final String minId;

    public static /* synthetic */ FeedResult copy$default(FeedResult feedResult, Boolean bool, String str, String str2, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = feedResult.hasMore;
        }
        if ((i2 & 2) != 0) {
            str = feedResult.maxId;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = feedResult.minId;
        }
        String str4 = str2;
        List<ActivityResult> list3 = list;
        if ((i2 & 8) != 0) {
            list3 = feedResult.activities;
        }
        List list4 = list3;
        if ((i2 & 16) != 0) {
            i = feedResult.feedVersion;
        }
        int i3 = i;
        List<GroupedActivityResult> list5 = list2;
        if ((i2 & 32) != 0) {
            list5 = feedResult.groupedActivities;
        }
        return feedResult.copy(bool, str3, str4, list4, i3, list5);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getHasMore() {
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
        return this.activities;
    }

    /* renamed from: component5  reason: from getter */
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    public final List<GroupedActivityResult> component6() {
        return this.groupedActivities;
    }

    public final FeedResult copy(Boolean hasMore, String maxId, String minId, List<ActivityResult> activities, int feedVersion, List<GroupedActivityResult> groupedActivities) {
        return new FeedResult(hasMore, maxId, minId, activities, feedVersion, groupedActivities);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedResult) {
            FeedResult feedResult = (FeedResult) other;
            return Intrinsics.areEqual(this.hasMore, feedResult.hasMore) && Intrinsics.areEqual(this.maxId, feedResult.maxId) && Intrinsics.areEqual(this.minId, feedResult.minId) && Intrinsics.areEqual(this.activities, feedResult.activities) && this.feedVersion == feedResult.feedVersion && Intrinsics.areEqual(this.groupedActivities, feedResult.groupedActivities);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.hasMore;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.maxId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.minId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        List<ActivityResult> list = this.activities;
        int hashCode4 = list == null ? 0 : list.hashCode();
        int i = this.feedVersion;
        List<GroupedActivityResult> list2 = this.groupedActivities;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", minId=");
        sb.append(this.minId);
        sb.append(", activities=");
        sb.append(this.activities);
        sb.append(", feedVersion=");
        sb.append(this.feedVersion);
        sb.append(", groupedActivities=");
        sb.append(this.groupedActivities);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ FeedResult(Boolean bool, String str, String str2, List list, int i, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, i, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
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

    @JvmName(name = "getActivities")
    public final List<ActivityResult> getActivities() {
        return this.activities;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    @JvmName(name = "getGroupedActivities")
    public final List<GroupedActivityResult> getGroupedActivities() {
        return this.groupedActivities;
    }

    public FeedResult(Boolean bool, String str, String str2, List<ActivityResult> list, int i, List<GroupedActivityResult> list2) {
        this.hasMore = bool;
        this.maxId = str;
        this.minId = str2;
        this.activities = list;
        this.feedVersion = i;
        this.groupedActivities = list2;
    }
}
