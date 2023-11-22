package id.dana.domain.announcement.model;

import id.dana.domain.pushverify.model.PushVerifyAnnouncement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/domain/announcement/model/AnnouncementsInfo;", "", "Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "component1", "()Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "", "Lid/dana/domain/announcement/model/RecurringAnnouncement;", "component2", "()Ljava/util/List;", "pushVerifyAnnouncement", "recurringAnnouncements", "copy", "(Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;Ljava/util/List;)Lid/dana/domain/announcement/model/AnnouncementsInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "getPushVerifyAnnouncement", "Ljava/util/List;", "getRecurringAnnouncements", "<init>", "(Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AnnouncementsInfo {
    private final PushVerifyAnnouncement pushVerifyAnnouncement;
    private final List<RecurringAnnouncement> recurringAnnouncements;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnouncementsInfo copy$default(AnnouncementsInfo announcementsInfo, PushVerifyAnnouncement pushVerifyAnnouncement, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            pushVerifyAnnouncement = announcementsInfo.pushVerifyAnnouncement;
        }
        if ((i & 2) != 0) {
            list = announcementsInfo.recurringAnnouncements;
        }
        return announcementsInfo.copy(pushVerifyAnnouncement, list);
    }

    /* renamed from: component1  reason: from getter */
    public final PushVerifyAnnouncement getPushVerifyAnnouncement() {
        return this.pushVerifyAnnouncement;
    }

    public final List<RecurringAnnouncement> component2() {
        return this.recurringAnnouncements;
    }

    public final AnnouncementsInfo copy(PushVerifyAnnouncement pushVerifyAnnouncement, List<RecurringAnnouncement> recurringAnnouncements) {
        Intrinsics.checkNotNullParameter(recurringAnnouncements, "");
        return new AnnouncementsInfo(pushVerifyAnnouncement, recurringAnnouncements);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AnnouncementsInfo) {
            AnnouncementsInfo announcementsInfo = (AnnouncementsInfo) other;
            return Intrinsics.areEqual(this.pushVerifyAnnouncement, announcementsInfo.pushVerifyAnnouncement) && Intrinsics.areEqual(this.recurringAnnouncements, announcementsInfo.recurringAnnouncements);
        }
        return false;
    }

    public final int hashCode() {
        PushVerifyAnnouncement pushVerifyAnnouncement = this.pushVerifyAnnouncement;
        return ((pushVerifyAnnouncement == null ? 0 : pushVerifyAnnouncement.hashCode()) * 31) + this.recurringAnnouncements.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnnouncementsInfo(pushVerifyAnnouncement=");
        sb.append(this.pushVerifyAnnouncement);
        sb.append(", recurringAnnouncements=");
        sb.append(this.recurringAnnouncements);
        sb.append(')');
        return sb.toString();
    }

    public AnnouncementsInfo(PushVerifyAnnouncement pushVerifyAnnouncement, List<RecurringAnnouncement> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.pushVerifyAnnouncement = pushVerifyAnnouncement;
        this.recurringAnnouncements = list;
    }

    @JvmName(name = "getPushVerifyAnnouncement")
    public final PushVerifyAnnouncement getPushVerifyAnnouncement() {
        return this.pushVerifyAnnouncement;
    }

    @JvmName(name = "getRecurringAnnouncements")
    public final List<RecurringAnnouncement> getRecurringAnnouncements() {
        return this.recurringAnnouncements;
    }
}
