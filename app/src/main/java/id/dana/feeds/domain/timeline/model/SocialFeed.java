package id.dana.feeds.domain.timeline.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004Jb\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0016\u001a\u00020\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010 \u001a\u00020\fHÖ\u0001¢\u0006\u0004\b \u0010\u000eJ\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010\u0007R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010,R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010#\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010&R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b/\u0010\u0004R\"\u0010\u0014\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u00100\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u00103R\"\u0010\u0018\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u00103"}, d2 = {"Lid/dana/feeds/domain/timeline/model/SocialFeed;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "component3", "()Ljava/util/List;", "", "component4", "()I", "Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "component5", "component6", "component7", "hasMore", "maxId", "activities", "feedVersion", "groupedActivities", "minId", "fromCache", "copy", "(ZLjava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Z)Lid/dana/feeds/domain/timeline/model/SocialFeed;", "other", "equals", "(Ljava/lang/Object;)Z", "hasActivities", "hashCode", "isFeedNotVersionTwo", "toString", "Ljava/util/List;", "getActivities", "setActivities", "(Ljava/util/List;)V", "I", "getFeedVersion", "Z", "getFromCache", "setFromCache", "(Z)V", "getGroupedActivities", "setGroupedActivities", "getHasMore", "Ljava/lang/String;", "getMaxId", "setMaxId", "(Ljava/lang/String;)V", "getMinId", "setMinId", "<init>", "(ZLjava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SocialFeed {
    private List<ActivityResponse> activities;
    private final int feedVersion;
    private boolean fromCache;
    private List<GroupedActivity> groupedActivities;
    private final boolean hasMore;
    private String maxId;
    private String minId;

    public SocialFeed() {
        this(false, null, null, 0, null, null, false, 127, null);
    }

    public static /* synthetic */ SocialFeed copy$default(SocialFeed socialFeed, boolean z, String str, List list, int i, List list2, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = socialFeed.hasMore;
        }
        if ((i2 & 2) != 0) {
            str = socialFeed.maxId;
        }
        String str3 = str;
        List<ActivityResponse> list3 = list;
        if ((i2 & 4) != 0) {
            list3 = socialFeed.activities;
        }
        List list4 = list3;
        if ((i2 & 8) != 0) {
            i = socialFeed.feedVersion;
        }
        int i3 = i;
        List<GroupedActivity> list5 = list2;
        if ((i2 & 16) != 0) {
            list5 = socialFeed.groupedActivities;
        }
        List list6 = list5;
        if ((i2 & 32) != 0) {
            str2 = socialFeed.minId;
        }
        String str4 = str2;
        if ((i2 & 64) != 0) {
            z2 = socialFeed.fromCache;
        }
        return socialFeed.copy(z, str3, list4, i3, list6, str4, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    public final List<ActivityResponse> component3() {
        return this.activities;
    }

    /* renamed from: component4  reason: from getter */
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    public final List<GroupedActivity> component5() {
        return this.groupedActivities;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMinId() {
        return this.minId;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final SocialFeed copy(boolean hasMore, String maxId, List<ActivityResponse> activities, int feedVersion, List<GroupedActivity> groupedActivities, String minId, boolean fromCache) {
        Intrinsics.checkNotNullParameter(maxId, "");
        Intrinsics.checkNotNullParameter(activities, "");
        Intrinsics.checkNotNullParameter(groupedActivities, "");
        Intrinsics.checkNotNullParameter(minId, "");
        return new SocialFeed(hasMore, maxId, activities, feedVersion, groupedActivities, minId, fromCache);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SocialFeed) {
            SocialFeed socialFeed = (SocialFeed) other;
            return this.hasMore == socialFeed.hasMore && Intrinsics.areEqual(this.maxId, socialFeed.maxId) && Intrinsics.areEqual(this.activities, socialFeed.activities) && this.feedVersion == socialFeed.feedVersion && Intrinsics.areEqual(this.groupedActivities, socialFeed.groupedActivities) && Intrinsics.areEqual(this.minId, socialFeed.minId) && this.fromCache == socialFeed.fromCache;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.maxId.hashCode();
        int hashCode2 = this.activities.hashCode();
        int i = this.feedVersion;
        int hashCode3 = this.groupedActivities.hashCode();
        int hashCode4 = this.minId.hashCode();
        boolean z2 = this.fromCache;
        return (((((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + hashCode4) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialFeed(hasMore=");
        sb.append(this.hasMore);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", activities=");
        sb.append(this.activities);
        sb.append(", feedVersion=");
        sb.append(this.feedVersion);
        sb.append(", groupedActivities=");
        sb.append(this.groupedActivities);
        sb.append(", minId=");
        sb.append(this.minId);
        sb.append(", fromCache=");
        sb.append(this.fromCache);
        sb.append(')');
        return sb.toString();
    }

    public SocialFeed(boolean z, String str, List<ActivityResponse> list, int i, List<GroupedActivity> list2, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.hasMore = z;
        this.maxId = str;
        this.activities = list;
        this.feedVersion = i;
        this.groupedActivities = list2;
        this.minId = str2;
        this.fromCache = z2;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "setMaxId")
    public final void setMaxId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxId = str;
    }

    public /* synthetic */ SocialFeed(boolean z, String str, List list, int i, List list2, String str2, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 32) == 0 ? str2 : "", (i2 & 64) != 0 ? false : z2);
    }

    @JvmName(name = "getActivities")
    public final List<ActivityResponse> getActivities() {
        return this.activities;
    }

    @JvmName(name = "setActivities")
    public final void setActivities(List<ActivityResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.activities = list;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    @JvmName(name = "getGroupedActivities")
    public final List<GroupedActivity> getGroupedActivities() {
        return this.groupedActivities;
    }

    @JvmName(name = "setGroupedActivities")
    public final void setGroupedActivities(List<GroupedActivity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.groupedActivities = list;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    @JvmName(name = "setMinId")
    public final void setMinId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.minId = str;
    }

    @JvmName(name = "getFromCache")
    public final boolean getFromCache() {
        return this.fromCache;
    }

    @JvmName(name = "setFromCache")
    public final void setFromCache(boolean z) {
        this.fromCache = z;
    }

    public final boolean isFeedNotVersionTwo() {
        return this.feedVersion > 2;
    }

    public final boolean hasActivities() {
        return (this.activities.isEmpty() ^ true) || (this.groupedActivities.isEmpty() ^ true);
    }
}
