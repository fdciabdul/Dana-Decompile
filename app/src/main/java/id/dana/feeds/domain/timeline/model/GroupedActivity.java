package id.dana.feeds.domain.timeline.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010!R\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b$\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0010"}, d2 = {"Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "component5", "()Ljava/util/List;", "", "component6", "()Z", "id", "group", "activityCount", "actorCount", "activities", "read", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Z)Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getActivities", "setActivities", "(Ljava/util/List;)V", "I", "getActivityCount", "getActorCount", "Ljava/lang/String;", "getGroup", "getId", "Z", "getRead", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupedActivity {
    private List<ActivityResponse> activities;
    private final int activityCount;
    private final int actorCount;
    private final String group;
    private final String id;
    private final boolean read;

    public static /* synthetic */ GroupedActivity copy$default(GroupedActivity groupedActivity, String str, String str2, int i, int i2, List list, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = groupedActivity.id;
        }
        if ((i3 & 2) != 0) {
            str2 = groupedActivity.group;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i = groupedActivity.activityCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = groupedActivity.actorCount;
        }
        int i5 = i2;
        List<ActivityResponse> list2 = list;
        if ((i3 & 16) != 0) {
            list2 = groupedActivity.activities;
        }
        List list3 = list2;
        if ((i3 & 32) != 0) {
            z = groupedActivity.read;
        }
        return groupedActivity.copy(str, str3, i4, i5, list3, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* renamed from: component3  reason: from getter */
    public final int getActivityCount() {
        return this.activityCount;
    }

    /* renamed from: component4  reason: from getter */
    public final int getActorCount() {
        return this.actorCount;
    }

    public final List<ActivityResponse> component5() {
        return this.activities;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getRead() {
        return this.read;
    }

    public final GroupedActivity copy(String id2, String group, int activityCount, int actorCount, List<ActivityResponse> activities, boolean read) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(group, "");
        Intrinsics.checkNotNullParameter(activities, "");
        return new GroupedActivity(id2, group, activityCount, actorCount, activities, read);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GroupedActivity) {
            GroupedActivity groupedActivity = (GroupedActivity) other;
            return Intrinsics.areEqual(this.id, groupedActivity.id) && Intrinsics.areEqual(this.group, groupedActivity.group) && this.activityCount == groupedActivity.activityCount && this.actorCount == groupedActivity.actorCount && Intrinsics.areEqual(this.activities, groupedActivity.activities) && this.read == groupedActivity.read;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.id.hashCode();
        int hashCode2 = this.group.hashCode();
        int i = this.activityCount;
        int i2 = this.actorCount;
        int hashCode3 = this.activities.hashCode();
        boolean z = this.read;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + hashCode3) * 31) + i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupedActivity(id=");
        sb.append(this.id);
        sb.append(", group=");
        sb.append(this.group);
        sb.append(", activityCount=");
        sb.append(this.activityCount);
        sb.append(", actorCount=");
        sb.append(this.actorCount);
        sb.append(", activities=");
        sb.append(this.activities);
        sb.append(", read=");
        sb.append(this.read);
        sb.append(')');
        return sb.toString();
    }

    public GroupedActivity(String str, String str2, int i, int i2, List<ActivityResponse> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.id = str;
        this.group = str2;
        this.activityCount = i;
        this.actorCount = i2;
        this.activities = list;
        this.read = z;
    }

    public /* synthetic */ GroupedActivity(String str, String str2, int i, int i2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, list, (i3 & 32) != 0 ? false : z);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getGroup")
    public final String getGroup() {
        return this.group;
    }

    @JvmName(name = "getActivityCount")
    public final int getActivityCount() {
        return this.activityCount;
    }

    @JvmName(name = "getActorCount")
    public final int getActorCount() {
        return this.actorCount;
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

    @JvmName(name = "getRead")
    public final boolean getRead() {
        return this.read;
    }
}
