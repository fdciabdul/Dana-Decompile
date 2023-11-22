package id.dana.data.announcement.model;

import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/data/announcement/model/Announcements;", "", "", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "component1", "()Ljava/util/List;", "Lid/dana/data/announcement/model/RecurringAnnouncementEntity;", "component2", "pushVerifyAnnouncement", "recurringAnnouncement", "copy", "(Ljava/util/List;Ljava/util/List;)Lid/dana/data/announcement/model/Announcements;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getPushVerifyAnnouncement", "getRecurringAnnouncement", "setRecurringAnnouncement", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Announcements {
    private final List<PushVerifyChallengeResult> pushVerifyAnnouncement;
    private List<RecurringAnnouncementEntity> recurringAnnouncement;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Announcements() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.announcement.model.Announcements.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Announcements copy$default(Announcements announcements, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = announcements.pushVerifyAnnouncement;
        }
        if ((i & 2) != 0) {
            list2 = announcements.recurringAnnouncement;
        }
        return announcements.copy(list, list2);
    }

    public final List<PushVerifyChallengeResult> component1() {
        return this.pushVerifyAnnouncement;
    }

    public final List<RecurringAnnouncementEntity> component2() {
        return this.recurringAnnouncement;
    }

    public final Announcements copy(List<PushVerifyChallengeResult> pushVerifyAnnouncement, List<RecurringAnnouncementEntity> recurringAnnouncement) {
        return new Announcements(pushVerifyAnnouncement, recurringAnnouncement);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Announcements) {
            Announcements announcements = (Announcements) other;
            return Intrinsics.areEqual(this.pushVerifyAnnouncement, announcements.pushVerifyAnnouncement) && Intrinsics.areEqual(this.recurringAnnouncement, announcements.recurringAnnouncement);
        }
        return false;
    }

    public final int hashCode() {
        List<PushVerifyChallengeResult> list = this.pushVerifyAnnouncement;
        int hashCode = list == null ? 0 : list.hashCode();
        List<RecurringAnnouncementEntity> list2 = this.recurringAnnouncement;
        return (hashCode * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Announcements(pushVerifyAnnouncement=");
        sb.append(this.pushVerifyAnnouncement);
        sb.append(", recurringAnnouncement=");
        sb.append(this.recurringAnnouncement);
        sb.append(')');
        return sb.toString();
    }

    public Announcements(List<PushVerifyChallengeResult> list, List<RecurringAnnouncementEntity> list2) {
        this.pushVerifyAnnouncement = list;
        this.recurringAnnouncement = list2;
    }

    public /* synthetic */ Announcements(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    @JvmName(name = "getPushVerifyAnnouncement")
    public final List<PushVerifyChallengeResult> getPushVerifyAnnouncement() {
        return this.pushVerifyAnnouncement;
    }

    @JvmName(name = "getRecurringAnnouncement")
    public final List<RecurringAnnouncementEntity> getRecurringAnnouncement() {
        return this.recurringAnnouncement;
    }

    @JvmName(name = "setRecurringAnnouncement")
    public final void setRecurringAnnouncement(List<RecurringAnnouncementEntity> list) {
        this.recurringAnnouncement = list;
    }
}
