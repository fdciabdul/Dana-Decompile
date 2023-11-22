package id.dana.domain.social.model;

import id.dana.domain.social.InitStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/domain/social/model/FeedInit;", "", "", "component1", "()I", "Lid/dana/domain/social/InitStatus;", "component2", "()Lid/dana/domain/social/InitStatus;", "initProgress", "status", "copy", "(ILid/dana/domain/social/InitStatus;)Lid/dana/domain/social/model/FeedInit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lid/dana/domain/social/model/InitFeed;", "toInitFeed", "()Lid/dana/domain/social/model/InitFeed;", "", "toString", "()Ljava/lang/String;", "I", "getInitProgress", "Lid/dana/domain/social/InitStatus;", "getStatus", "<init>", "(ILid/dana/domain/social/InitStatus;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FeedInit {
    private final int initProgress;
    private final InitStatus status;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.social.InitStatus] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedInit() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.social.model.FeedInit.<init>():void");
    }

    public static /* synthetic */ FeedInit copy$default(FeedInit feedInit, int i, InitStatus initStatus, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = feedInit.initProgress;
        }
        if ((i2 & 2) != 0) {
            initStatus = feedInit.status;
        }
        return feedInit.copy(i, initStatus);
    }

    /* renamed from: component1  reason: from getter */
    public final int getInitProgress() {
        return this.initProgress;
    }

    /* renamed from: component2  reason: from getter */
    public final InitStatus getStatus() {
        return this.status;
    }

    public final FeedInit copy(int initProgress, InitStatus status) {
        Intrinsics.checkNotNullParameter(status, "");
        return new FeedInit(initProgress, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedInit) {
            FeedInit feedInit = (FeedInit) other;
            return this.initProgress == feedInit.initProgress && this.status == feedInit.status;
        }
        return false;
    }

    public final int hashCode() {
        return (this.initProgress * 31) + this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedInit(initProgress=");
        sb.append(this.initProgress);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public FeedInit(int i, InitStatus initStatus) {
        Intrinsics.checkNotNullParameter(initStatus, "");
        this.initProgress = i;
        this.status = initStatus;
    }

    public /* synthetic */ FeedInit(int i, InitStatus initStatus, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? InitStatus.INIT : initStatus);
    }

    @JvmName(name = "getInitProgress")
    public final int getInitProgress() {
        return this.initProgress;
    }

    @JvmName(name = "getStatus")
    public final InitStatus getStatus() {
        return this.status;
    }

    public final InitFeed toInitFeed() {
        return new InitFeed(this.status, this.initProgress, null, false, 12, null);
    }
}
