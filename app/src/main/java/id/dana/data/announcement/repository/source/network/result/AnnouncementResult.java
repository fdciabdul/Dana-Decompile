package id.dana.data.announcement.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.announcement.model.Announcements;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/announcement/model/Announcements;", "component1", "()Lid/dana/data/announcement/model/Announcements;", "announcements", "copy", "(Lid/dana/data/announcement/model/Announcements;)Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/announcement/model/Announcements;", "getAnnouncements", "setAnnouncements", "(Lid/dana/data/announcement/model/Announcements;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AnnouncementResult extends BaseRpcResult {
    private Announcements announcements;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.data.announcement.model.Announcements] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AnnouncementResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.announcement.repository.source.network.result.AnnouncementResult.<init>():void");
    }

    public static /* synthetic */ AnnouncementResult copy$default(AnnouncementResult announcementResult, Announcements announcements, int i, Object obj) {
        if ((i & 1) != 0) {
            announcements = announcementResult.announcements;
        }
        return announcementResult.copy(announcements);
    }

    /* renamed from: component1  reason: from getter */
    public final Announcements getAnnouncements() {
        return this.announcements;
    }

    public final AnnouncementResult copy(Announcements announcements) {
        return new AnnouncementResult(announcements);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnnouncementResult) && Intrinsics.areEqual(this.announcements, ((AnnouncementResult) other).announcements);
    }

    public final int hashCode() {
        Announcements announcements = this.announcements;
        if (announcements == null) {
            return 0;
        }
        return announcements.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnnouncementResult(announcements=");
        sb.append(this.announcements);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ AnnouncementResult(Announcements announcements, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : announcements);
    }

    @JvmName(name = "getAnnouncements")
    public final Announcements getAnnouncements() {
        return this.announcements;
    }

    @JvmName(name = "setAnnouncements")
    public final void setAnnouncements(Announcements announcements) {
        this.announcements = announcements;
    }

    public AnnouncementResult(Announcements announcements) {
        this.announcements = announcements;
    }
}
